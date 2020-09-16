package com.project.tan;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 多数据源测试
 * <p>
 * CREATE TABLE `User` (   `name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,   `age` int NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
 * <p>
 * 可能这里你会问，有两个JdbcTemplate，为什么不用@Qualifier指定？
 * 这里顺带说个小知识点，当我们不指定的时候，会采用参数的名字来查找Bean，存在的话就注入。
 * 这两个JdbcTemplate创建的时候，我们也没指定名字，它们是如何匹配上的？这里也是一个小知识点，当我们创建Bean的时候，默认会使用方法名称来作为Bean的名称，所以这里就对应上了
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/15 8:39 PM
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceTest {

    @Autowired
    protected JdbcTemplate primaryJdbcTemplate;

    @Autowired
    protected JdbcTemplate secondaryJdbcTemplate;

    @Before
    public void setUp() {
        primaryJdbcTemplate.update("DELETE  FROM  USER ");
        secondaryJdbcTemplate.update("DELETE  FROM  USER ");
    }


    @Test
    public void test() throws Exception {
        // 往第一个数据源中插入 2 条数据
        primaryJdbcTemplate.update("insert into user(name,age) values(?, ?)", "aaa", 20);
        primaryJdbcTemplate.update("insert into user(name,age) values(?, ?)", "bbb", 30);

        // 往第二个数据源中插入 1 条数据，若插入的是第一个数据源，则会主键冲突报错
        secondaryJdbcTemplate.update("insert into user(name,age) values(?, ?)", "ccc", 20);

        // 查一下第一个数据源中是否有 2 条数据，验证插入是否成功
        Assert.assertEquals("2", primaryJdbcTemplate.queryForObject("select count(1) from user", String.class));

        // 查一下第一个数据源中是否有 1 条数据，验证插入是否成功
        Assert.assertEquals("1", secondaryJdbcTemplate.queryForObject("select count(1) from user", String.class));

    }


}

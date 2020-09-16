package com.project.tan.entity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.tan.entity.model.User;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 自定义SQL
     * @param id
     * @return
     */
    @Select(value = "select * from user where id = #{id} ")
    User findUserById( Long id);

    /**
     * 通常不建议物理删除，而是打标签
     * @param id
     * @return
     */
    @Delete("delete from user where id=#{id}")
    int deleteUser(Long id);


    // 使用对象
    @Insert("insert into user (name,age,email) values (#{name},#{age},#{email})")
    int insertUser(User user);


    @Update("update book set name=#{name}, age=#{age},email=#{email} where id=#{id}")
    int updateBook(User user);


    // 1个参数
    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    // 使用map
    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);


    // 可应用于多表关联的场景
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT name, age FROM user")
    List<User> findAll();


    // 使用xml配置的方式
    User findByName2(@Param("name") String name);
    int insert(@Param("name") String name, @Param("age") Integer age);
}

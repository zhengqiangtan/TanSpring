### TanSpring SpringBoot 综合学习

##### 环境信息
- SpringBoot 2.3.0.RELEASE
- redis jedis : 3.3.0
- mysql-connector : 8.0.2
- swagger 2.9.2
- mybatis-plus 3.3.2
- Java 8




##### 1. 此项目涉及到的相关技术
 
- SpringBoot 2.3.0
- 使用Swagger2构建强大的API文档
- JdbcTemplate的使用
- mybatis-plus (xml & SQL两种方式的使用)
- 分页的使用
- 代码生成器 TODO
- 多数据源配置实践
- 集成事务管理
- 缓存的使用与Cache注解 (spring-boot-starter-cache)
- Spring单元测试
- 日志管理log4j
- 自定义定义切面拦截请求以及统计接口耗时（可指定切面顺序）
- SpringBeanUtil工具的使用 
- 集成异步任务线程池
- 线程池运行状况监视
- 集成定时任务设置
- 开发生产多环境配置
- 设置开机启动程序
- 集成外部调用Feign TODO
- 集成配置中心 TODO
- 集成外部数据源redis
- 自定义拦截器、监听器、过滤器


---
- 项目配置打印具体SQL信息
- 项目启动排除Redis配置类信息



##### 2、SpringBoot 的相关疑问和解答
- [有关SpringBoot的100问](https://zhengqiang.blog.csdn.net/article/details/108652960)

- 集成Redis注意：redis 服务需先启动并带有密码认证

- Spring Boot 如何使用拦截器、过滤器、监听器？
参考：[https://mp.weixin.qq.com/s/k16AOko-EMcrASFLAHkc5Q](https://mp.weixin.qq.com/s/k16AOko-EMcrASFLAHkc5Q)


- 解决日志jar冲突的问题
 参考：[https://zhengqiang.blog.csdn.net/article/details/108715170](https://zhengqiang.blog.csdn.net/article/details/108715170)

##### 3、SpringBoot 学习资源

 - [Spring Boot 2.x基础教程 （新手推荐](http://blog.didispace.com/spring-boot-learning-2x/)
 - [](https://github.com/dyc87112/SpringBoot-Learning/tree/master/2.1.x)



##### 4、SpringBoot 问题解决
1. Redis引入包冲突的问题 
2. java.lang.IllegalStateException: Cannot create a session after the response has been committed
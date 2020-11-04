## TanSpring SpringBoot 综合学习项目

### 环境信息
- SpringBoot 2.3.0.RELEASE
- redis jedis : 3.3.0
- mysql-connector : 8.0.2
- swagger 2.9.2
- mybatis-plus 3.3.2
- Java 8




### 一. 此项目涉及到的相关技术
 
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
- [集成外部调用Feign](https://blog.csdn.net/catoop/article/details/101011782)
- 集成配置中心 TODO
- 集成外部数据源redis
- 自定义拦截器、监听器、过滤器
- [Springboot设置跨域](https://mp.weixin.qq.com/s/s9pUpQtHgL3WK6sjKC0b0w)
- SpringBoot全局异常处理 ExceptionHandlerController
- 添加钉钉告警和邮件告警工具类（非Spring集成）


---
- 项目配置打印具体SQL信息
- 项目启动排除Redis配置类信息
- MyBatis-plus @TableName @TableFiled等的使用，使用IService接口
- [优雅关闭SpringBoot服务](https://mp.weixin.qq.com/s/f2ZvpglLwTrsRv8BZvns_A)（ 2.3 版本，内置此功能）：server.shutdown=graceful




### 二、SpringBoot 的相关疑问和解答
- [有关SpringBoot的100问](https://zhengqiang.blog.csdn.net/article/details/108652960)

- 集成Redis注意：redis 服务需先启动并带有密码认证

- Spring Boot 如何使用拦截器、过滤器、监听器？
参考：[https://mp.weixin.qq.com/s/k16AOko-EMcrASFLAHkc5Q](https://mp.weixin.qq.com/s/k16AOko-EMcrASFLAHkc5Q)


- 解决日志jar冲突的问题
 参考：[https://zhengqiang.blog.csdn.net/article/details/108715170](https://zhengqiang.blog.csdn.net/article/details/108715170)
 
 
 - Springboot设置跨域三种方式
 参考文章：[https://mp.weixin.qq.com/s/s9pUpQtHgL3WK6sjKC0b0w](https://mp.weixin.qq.com/s/s9pUpQtHgL3WK6sjKC0b0w)
 
 - SpringAop日志收集与处理工具包
 参考文章：[https://mp.weixin.qq.com/s/ENAK_yQoVvQz24aSNsVfiw](https://mp.weixin.qq.com/s/ENAK_yQoVvQz24aSNsVfiw)
 ```xml
        <!--SpringAop日志收集工具包-->
        <dependency>
            <groupId>com.github.ealenxie</groupId>
            <artifactId>aop-log</artifactId>
            <version>2.1</version>
        </dependency>
```
 

### 三、SpringBoot 学习资源

 - [Spring Boot 2.x基础教程 （新手推荐](http://blog.didispace.com/spring-boot-learning-2x/)
 - [SpringBoot-Learning](https://github.com/dyc87112/SpringBoot-Learning/tree/master/2.1.x)
 ---
 `待处理`  
[Spring Boot 知识清单（一）SpringApplication](https://developer.aliyun.com/article/773194?utm_content=g_1000186051)  
[SpringBoot统一参数校验](https://developer.aliyun.com/article/772482?spm=a2c6h.12873639.0.0.4ccf236696yB99)  
[SpringBoot分组校验及自定义校验注解](https://developer.aliyun.com/article/773001?utm_content=g_1000186050)   
[@Transaction哪里来这么多坑](https://mp.weixin.qq.com/s/NjYsZu8vRvajWNrPCtLeFg)  
[SpringBoot启动扩展点](https://mp.weixin.qq.com/s/w-oSnFbzjWbx6HJKaICsgg)  
[Spring注解相关](https://mp.weixin.qq.com/s/u7a_GGVi6y4eyAEeeUaEtA)  
[牛逼的日志切面，方便甩锅](https://mp.weixin.qq.com/s/VA07Lca9ldZj4pQxlN8TUQ)   


[SpringBoot实现的接入钉钉机器人的一个消息通知中间件](https://github.com/AnswerAIL/dingtalk-spring-boot-starter/tree/master/src/main/java/com/jaemon/dingtalk)


### 四、SpringBoot 问题解决
1. Redis引入包冲突的问题 
2. java.lang.IllegalStateException: Cannot create a session after the response has been committed
3. SpringBoot内存泄露排查 [https://mp.weixin.qq.com/s/ZrtY5qiO7fdzCC12X0gQJg](https://mp.weixin.qq.com/s/ZrtY5qiO7fdzCC12X0gQJg)


<br><br>

|  学习清单   | 完成进度情况说明  |
|  ----  | :----:  |
| `单元格`  | 单元格 |
| 单元格  | 单元格 |



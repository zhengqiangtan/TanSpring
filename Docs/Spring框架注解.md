### 核心注解
 
@Required
 
用于Bean的Setter方法上，以指示该Bean组装时必须要有该属性，否则抛出BeanInitializationException
 
@Autowired
 
自动导入依赖的bean。byType方式。把配置好的Bean拿来用，完成属性、方法的组装。 它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。
当加上（required=false）时，就算找不到bean也不报错。

JSR规范中也有相对应的注解：JSR250的@Resource，JSR330的@Inject
 
@Qualifier
 
这个注解通常和@Autowired一起使用，当你想对注入的过程做更多的控制，@Qualifier可以帮助你指定做更详细配置。 一般在两个或者多个bean是相同的类型，spring在注入的时候会出现混乱。
 
@Configuration
 
等同于spring的XML配置文件；使用Java代码可以检查类型安全。 如果有些第三方库需要用到xml文件，建议仍然通过@Configuration类作为项目的配置主类，
并使用@ImportResource注解加载xml配置文件
 
@ComponentScan
 
与@Configuration注解一起，发现和装配Bean。 可通过basePackageClasses 或basePackage指定扫描的基类或基包。
如果声明的包未定义的话，会从声明该注解的类所在的包及子包开始扫描
 
@Bean
 
等价于XML中配置的bean。 放在方法的上面，而不是类，产生一个Bean,并交给Spring容器管理。
 
@Lazy
 
用在组件类上。Spring默认在启动时自动装载依赖类。使用此注解时，会在第一次请求使用时才初始化该类。 也可与@Configuration一起使用，则所有@Bean注解的方法会延时初始化。
 
@Value
 
可用于字段，构造器参数，方法参数，以指示一个默认的值。 支持#{...}和${...}这两种占位符。
注入Spring boot application.properties配置的属性的值
 
@Import
 
用来导入其他配置类
 
@ImportResource
 
用来加载xml配置文件
 
原型注解
 
@Component
 
可配合CommandLineRunner使用，在程序启动后执行一些基础任务; 当组件不好归类的时候，可以使用这个注解进行标注
 
@Controller
 
用于定义控制器类，在spring 项目中由控制器负责将用户发来的URL请求转发到对应的服务接口（service层）， 一般这个注解在类中，通常方法需要配合注解@RequestMapping
 
@Service
 
一般用于修饰service层的组件

@Repository
 
可以确保DAO或者repositories提供异常转译， 这个注解修饰的DAO或者repositories类会被ComponetScan发现并配置，
同时也不需要为它们提供XML配置项
 
SpringBoot注解
 
@EnableAutoConfiguration
 
自动配置。尝试根据你添加的jar依赖自动配置你的Spring应用。 例如，如果classpath下存在HSQLDB，并且你没有手动配置任何数据库连接beans，将自动配置一个内存型（in-memory）数据库”。
你可以将@EnableAutoConfiguration或@SpringBootApplication注解添加到一个@Configuration类上来选择自动配置。
如果发现应用了你不想要的特定自动配置类，可使用@EnableAutoConfiguration注解的排除属性来禁用它们
 
@SpringBootApplication
 
包含了@ComponentScan、@Configuration和@EnableAutoConfiguration注解 其中@ComponentScan让spring Boot扫描到Configuration类并把它加入到程序上下文
 
SpringCloud注解
 
@EnableConfigServer
 
配置服务器
 
@EnableEurekaServer
 
注册服务器
 
@EnableDiscoveryClient
 
发现客户端
 
@EnableCircuitBreaker
 
熔断器
 
@HystrixCommand
 
服务降级
 
缓存注解
 
@Cacheable
 
方法级
 
@CachePut
 
方法级，更新缓存
 
@CacheEvict
 
方法级，清除缓存
 
@CacheConfig
 
在类级别配置缓存，以避免多次声明
任务执行和调度注解
 
@Scheduled
 
方法级，具有该注解的方法应无返回值，且不接受任何参数
 
@Async
 
方法级，每个方法均都在单独的线程中，可接受参数；可返回值，也可不返回值。
 
测试注解
 
@BootstrapWith
 
类级别，配置Spring测试上下文框架的启动
 
@ContextConfiguration
 
类级别，指定配置文件
 
@WebAppConfiguration
 
类级别，指示ApplicationContext加载的集成测试环境应为WebApplicationContext
 
@Timed
 
指定测试方法的执行时间，超时失败
 
@Repeat
 
运行次数
 
@Commit
 
类级和方法级，指示事务的提交
 
@RollBack
 
类级和方法级，指示事务的回滚
 
@DirtiesContext
 
类级和方法级，指示ApplicationContext已修改，触发重加载以进行后续的测试
 
支持3种关闭上下文的方式
 
BEFORE_METHOD
 
BEFORE_CLASS
 
BEFORE_EACH_TEST_METHOD
 
@BeforeTransaction
 
测试类的void方法上，指示具有该注解的方法应该在所有@Transactional注解的方法之前执行
 
@AfterTransaction
 
测试类的void方法上，指示具有该注解的方法应该在所有@Transactional注解的方法之后执行
 
@Sql
 
类级和方法级，运行Sql脚本 方法上的@Sql会覆盖类级别的@Sql
 
@SqlConfig
 
同@Sql一起工作，定义了如何解析和执行SQL脚本的元数据 用于类级时对该类下的所有脚本起作用
 
@SqlGroup
 
方法级，包含多个@Sql
 
@SpringBootTest
 
用于启动集成测试上下文
 
@DataJpaTest
 
用于替代@SpringBootTest进行测试JPA Repositories， 测试时使用H2等内存数据库
 
@DataMongoTest
 
提供最小化的自动配置和一个内置的MongoDB以进行集成测试
 
@WebMVCTest
 
主要用于controller层测试，只覆盖应用程序的controller层， HTTP请求和响应是Mock出来的，因此不会创建真正的连接。因此需要用@MockBean注解创建所需的Bean进行模拟接口调用。
如果Controller层对Service层中的其他bean有依赖关系，那么需要使用Mock提供所需的依赖项。
WebMvcTest要快得多，因为我们只加载了应用程序的一小部分。
 
@AutoConfigureMockMVC
 
类似于@WebMVCTest，只不过启动的是整个SpringBoot上下文
 
@MockBean
 
创建和注入一个Mockito Mock
 
@JsonTest
 
限制SpringBoot的自动化配置，以处理JSON
 
该注解会自动化配置出一个JacksonTester 或 GsonTester实例
 
@TestPropertySource
 
类级别，指派测试类的属性源
 
数据访问注解
 
@Transactional
 
用于接口、接口中的方法、类、类中的公有方法 光靠该注解并不足以实现事务
仅是一个元数据，运行时架构会使用它配置具有事务行为的Bean
 
该注解还支持以下特性：
传播类型
隔离级别
操作超时
只读标记
JPA注解
 
@Entity
 
表明这是一个实体类。一般和@Table配合使用。 如果表名和实体类名相同的话，@Table可以省略
 
@Table
 
映射数据库中的表
 
@Column
 
映射表中的列
 
@Id
 
表示该属性为主键
 
@GeneratedValue
 
指定主键生成器的名字和生成策略
 
@SequenceGeneretor
 
自动为实体的数字标识字段/属性分配值
 
@MappedSuperClass
 
用在确定是父类的Entity上。父类的属性可被子类继承
 
@NoRepositoryBean
 
在充当父类的Repository上注解，以告诉Spring不要实例化该Repository
 
@Transient
 
表示该属性并非是一个到数据库表字段的映射,ORM框架应忽略它。 如果一个属性并非数据库表的字段映射,就务必将其标示为@Transient,否则,ORM框架默认其注解为@Basic。
 
@Basic(fetch=FetchType.LAZY)
 
指定实体属性的加载方式
 
@JsonIgnore
 
标记在属性上，指示当进行序列化或反序列化时，忽略该属性
 
@JoinColumn
 
一对一：本表中指向另一个表的外键。 一对多：另一个表指向本表的外键
 
@OneToOne
 
一对一
 
@OneToMany
 
一对多
 
@ManyToOne
 
多对一
 
###  SpringMVC和 REST注解
 
@Controller
 
用于定义控制器类，在spring 项目中由控制器负责将用户发来的URL请求转发到对应的服务接口（service层）， 一般这个注解在类中，通常方法需要配合注解@RequestMapping
 
@RestController
 
@Controller和@ResponseBody的合集,表示这是个控制器bean, 并且是将函数的返回值直接填入HTTP响应体中,是REST风格的控制器
 
@RequestMapping
 
RequestMapping是一个用来处理请求地址映射的注解，可用于类或方法上。 用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。
该注解有六个属性：

- params: 指定request中必须包含某些参数值是，才让该方法处理
- headers: 指定request中必须包含某些指定的header值，才能让该方法处理请求
- value: 指定请求的实际地址，指定的地址可以是URI Template 模式
- method: 指定请求的method类型， GET、POST、PUT、DELETE等
- consumes: 指定处理请求的提交内容类型（Content-Type），如application/json,text/html;
- produces: 指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回
 
@RequestMapping变体
 
@GetMapping
 
等于@RequestMapping(method = RequestMethod.GET)
 
@PostMapping
 
等于@RequestMapping(method = RequestMethod.POST)
 
@PutMapping
 
等于@RequestMapping(method = RequestMethod.PUT)
 
@PatchMapping
 
等于@RequestMapping(method = RequestMethod.PATCH)
 
@DeleteMapping
 
等于@RequestMapping(method = RequestMethod.DELETE)
 
@CookieValue
 
用于方法参数上获得cookie
 
@CrossOrigin
 
用于类和方法上，以实现跨域请求。 有时，运行JavaScript的主机和服务数据的主机不是同一个，此时就涉及到跨域(CORS)
 
@ExceptionHandler
 
用于方法上，指示异常处理类
 
@InitBinder
 
初始化绑定器，用于数据绑定、设置数据转换器等
 
@Mappings @Mapping
 
用于字段上。 Mapping是一个Meta注解，以指示web映射注解
Mappings可用于多个
 
@MatrixVariable
 
矩阵变量
 
@PathVariable
 
路径变量，获取路径上传过来的参数
 
@RequestAttribute
 
绑定请求属性到handler方法参数
 
@RequestBody
 
指示方法参数应该绑定到Http请求Body HttpMessageConveter负责将HTTP请求消息转为对象
 
@RequestHeader
 
映射控制器参数到请求头的值
 
@RequestParam
 
用在方法的参数前面
 
@RequestPart
 
替代@RequestParam以获得多部的内容并绑定到方法参数
 
@ResponseBody
 
指示方法返回值应该直接写入Response Body（不再走视图处理器） Spring使用HttpMessageConverter实现了返回对象转为响应体
 
@ResponseStatus
 
用于方法和异常类上。以一个状态码作为指示，且原因必须返回。
 
也可注解于Controller，其所有的@RequestMapping方法都会继承它
 
@SessionAttribute
 
用于方法参数。绑定方法参数到会话属性
 
@SessionAttributes
 
用于将会话属性用Bean封装
 
@JsonBackReference
 
解决嵌套外链问题
 
@RepositoryRestResourcepublic
 
配合spring-boot-starter-data-rest使用
 
@PathVariable
 
路径变量
 
@ModelAttribute
 
把值绑定到Model中，使全局@RequestMapping可以获取到该值
 
@Valid
 
验证器，一般配合@InitBinder使用
 
### 全局异常处理
 
@ControllerAdvice
 
包含@Component。可以被扫描到。 统一处理异常，一般与@ExceptionHandler一起使用
 
@RestControllerAdvice
 
@ControllerAdvice 和 @ResponseBody的组合
# ---SpringBoot------------------------------------------------------------------------------

# 1.SpringBoot介绍

## 1-1：什么是 Spring Boot？

Spring Boot 是 Spring 开源组织下的子项目，是 Spring 组件一站式解决方案，
主要是简化了使用 Spring 的难度，简省了繁重的配置，提供了各种启动器，开发者能快速上手。

## 15-2：springboot跟spring的差别？

1. Maven依赖
   Spring创建Web应用程序所需的最小依赖项至少需要两个
   而Spring Boot只需要一个依赖项来启动和运行Web应用程序：
2. MVC配置
   使用Spring和Spring Boot创建JSP Web应用程序所需的配置中
   Spring需要将@EnableWebMvc注解添加到@Configuration注解类，
   并定义一个视图解析器来解析从控制器返回的视图
   SpringBoot一旦我们添加了Spring boot web starter，Spring Boot
   只需要一些属性来使上面的事情正常工作
3. 模板引擎配置
 Spring和Spring Boot中配置Thymeleaf模板引擎中
   在Spring中，我们需要为视图解析器添加 thymeleaf-spring5依赖项和一些配置：
   Spring Boot 只需要spring-boot-starter-thymeleaf的依赖项
   来启用Web应用程序中的Thymeleaf支持。
   一旦依赖关系添加成功后，我们就可以将模板
   添加到src / main / resources / templates文件夹中，
   Spring Boot将自动显示它们。
4. 安全配置  
   Spring和Spring Boot框架启用默认的HTTP Basic身份验证。
   Spring需要标准的 spring-security-web和spring-security-config 
   依赖项来在应用程序中设置Security。
   同样，Spring Boot也需要这些依赖项才能使其工作。   
   但是我们只需要定义spring-boot-starter-security的依赖关系，
   它会自动将所有相关的依赖项添加到类路径中。
5. 应用引导Application Bootstrap
   Spring和Spring Boot中应用程序引导的基本区别在于servlet。
spring引导
   方法一：web.xml引导方法
Servlet容器（服务器）读取web.xml
web.xml中定义的DispatcherServlet由容器实例化
DispatcherServlet通过读取WEB-INF / {servletName} -servlet.xml来创建WebApplicationContext
，DispatcherServlet注册在应用程序上下文中定义的bean
   方法二：servlet 3+引导方法
容器搜索实现ServletContainerInitializer的 类并执行
SpringServletContainerInitializer找到实现类WebApplicationInitializer的子类
WebApplicationInitializer创建会话使用XML或上下文@Configuration类
WebApplicationInitializer创建DispatcherServlet，使用先前创建的上下文。   
Spring Boot引导
   spring boot仅仅使用Servlet 3来引导程序。
   默认情况下，Spring Boot使用嵌入式容器来运行应用程序。  
   Spring Boot使用public static void main入口点来启动嵌入式Web服务器。
   此外，它还负责将Servlet，Filter和ServletContextInitializer bean从应用程序上下文绑定到嵌入式
   servlet容器。
   Spring Boot的另一个特性是它会自动扫描同一个包中的所有类或Main类的子包中的组件。
   Spring Boot提供了将其部署为外部容器中的Web存档的选项。在这种情况下，我们必须扩展
   SpringBootServletInitializer：
6. 打包和部署
   与spring相比，在部署环境中Spring Boot的一些优点包括
      提供嵌入式容器支持
      使用命令java -jar独立运行jar
      在外部容器中部署时，可以选择排除依赖关系以避免潜在的jar冲突
      部署时灵活指定配置文件的选项
      用于集成测试的随机端口生成

## 1-3：Spring Boot 有哪些优点？

1. 容易上手，提升开发效率，为 Spring 开发提供一个更快、更广泛的入门体验。
2. 开箱即用，远离繁琐的配置。
3. 提供了一系列大型项目通用的非业务性功能，
   例如：内嵌服务器、安全管理、运行数据监控、
         运行状况检查和外部化配置等。
4. 没有代码生成，也不需要XML配置。
5. 避免大量的 Maven 导入和各种版本冲突。

# 2.Springboot流程

## 2-1：启动流程（创建流程）

启动流程主要分为三个部分，
1. 第一部分进行SpringApplication的初始化模块，配置一些基本的环境变量、资源、构造器、监听器，
2. 第二部分实现了应用具体的启动方案，包括启动流程的监听模块、加载配置环境模块、及核心的创建上下文环境模块，
3. 第三部分是自动化配置模块，该模块作为springboot自动配置核心，
一、启动：
 每个SpringBoot程序都有一个主入口，也就是main方法，
 main里面调用SpringApplication.run()启动整个springboot程序，
 这个方法所在类需要使用
 @SpringBootApplication注解，
 @ImportResource注解(if need)，
 @SpringBootApplication包括三个注解，
 然后，@EnableAutoConfiguration：SpringBoot根据应用所声明的依赖来对Spring框架进行自动配置
@SpringBootConfiguration(内部为@Configuration)：
被标注的类等于在spring的XML配置文件中(applicationContext.xml)，
装配所有bean事务，提供了一个spring的上下文环境
@ComponentScan：组件扫描，可自动发现和装配Bean，
默认扫描SpringApplication的run方法里的Booter.class所在的包路径下文件，
所以最好将该启动类放到根包路径下
当运行SpringApplication的main方法时,
首先进入run方法
run方法中去创建了一个SpringApplication实例，
在该构造方法内，我们可以发现其调用了一个初始化的initialize方法
该方法中主要实现就是：
   1. 创建了应用的监听器SpringApplicationRunListeners并开始监听
   2. 加载SpringBoot配置环境(ConfigurableEnvironment)，如果是通过web容器发布，会加载      
      StandardEnvironment，其最终也是继承了ConfigurableEnvironment，
   3. 配置环境(Environment)加入到监听器对象中(SpringApplicationRunListeners)
   4. 创建run方法的返回对象：ConfigurableApplicationContext(应用配置上下文)，
       * 创建方法主要流程就是：方法会先获取显式设置的应用上下文(applicationContextClass)，
         如果不存在，再加载默认的环境配置（通过是否是web environment判断），
         默认选择AnnotationConfigApplicationContext注解上下文（通过扫描所有注解类来加载bean），
         最后通过BeanUtils实例化上下文对象，
         并返回，ConfigurableApplicationContext类图如下：
   5. 回到run方法内，prepareContext方法将listeners、environment、
      applicationArguments、banner等重要组件与上下文对象关联
   6. 之后refreshContext(context)方法将是
      实现spring-boot-starter-*(mybatis、redis等)自动化配置的关键，
      包括spring.factories的加载，bean的实例化等核心工作。     
配置结束后，Springboot返回了应用环境上下文。我认为Springboot的启动，
主要创建了配置环境(environment)、事件监听(listeners)、应用上下文(applicationContext)，
并基于以上条件，在容器中开始实例化我们需要的Bean，

## 2-3：SpringBoot的自动装配原理

Spring Boot启动的时候会通过@EnableAutoConfiguration注解
找到META-INF/spring.factories配置文件中的所有自动配置类，
并对其进行加载，这些自动配置类都是以AutoConfiguration结尾来命名的，
它实际上就是一个JavaConfig形式的Spring容器配置类，
通过@Bean导入到Spring容器中，
以Properties结尾命名的类是和配置文件进行绑定的。
它能通过这些以Properties结尾命名的类中取得在全局配置文件中配置的属性，
我们可以通过修改配置文件对应的属性来修改自动配置的默认值，来完成自定义配置

## 2-4：run方法的作用

1、推断应用的类型是普通的项目还是Web项目
2、查找并加载所有可用初始化器 ， 设置到initializers属性中
3、找出所有的应用程序监听器，设置到listeners属性中
4、推断并设置main方法的定义类，找到运行的主类
 
## 2-5：如何在自定义端口上运行 Spring Boot 应用程序？

为了在自定义端口上运行 Spring Boot 应用程序，
可以在application.properties 中指定端口。server.port = 8090

# 3.视图技术Thymeleaf

用来替代jsp
Thymeleaf 最大的特点是能够直接在浏览器中打开并正确显示模板页面，
而不需要启动整个 Web 应用。

# 3.配置

## 3-1：什么是 JavaConfig？

它提供了配置 Spring IoC 容器的纯Java 方法。因此它有助于避免使用 XML 配置。

## 3-2：JavaConfig

使用 JavaConfig 的优点在于：

（1）面向对象的配置。由于配置被定义为 JavaConfig 中的类，因此用户可以充分利用 Java 
中的面向对象功能。一个配置类可以继承另一个，重写它的@Bean 方法等。

（2）减少或消除 XML 配置。基于依赖注入原则的外化配置的好处已被证明。但是，许多开发人员
不希望在 XML 和 Java 之间来回切换。JavaConfig 为开发人员提供了一种纯 Java 
方法来配置与 XML 配置概念相似的 Spring 容器。从技术角度来讲，
只使用 JavaConfig 配置类来配置容器是可行的，
但实际上很多人认为将JavaConfig 与 XML 混合匹配是理想的。

（3）类型安全和重构友好。JavaConfig 提供了一种类型安全的方法来配置 Spring容器。
由于 Java 5.0 对泛型的支持，现在可以按类型而不是按名称检索 bean，
不需要任何强制转换或基于字符串的查找。


## 4-2：你如何理解 Spring Boot 配置加载顺序？

在 Spring Boot 里面，可以使用以下几种方式来加载配置。
1）properties文件；
2）YAML文件；
3）系统环境变量；
4）命令行参数；

# 5.YAML与XML文件

## 17-5：什么是 YAML？

YAML 是一种可读的数据序列化语言。

通常用于配置文件。与属性文件相比，

如果我们想要在配置文件中添加复杂的属性，

YAML 文件就更加结构化，而且更少混淆。

YAML 具有分层配置数据。

## 17-6：YAML 配置的优势在哪里 ?

配置有序，在一些特殊的场景下，配置有序很关键
支持数组，数组中的元素可以是基本数据类型也可以是对象
简洁
相比 properties 配置文件，YAML 还有一个缺点，就是不支持 @PropertySource 注解导入自定义的 YAML 配置。

## 17-7：Spring Boot 是否可以使用 XML 配置 ?

Spring Boot 推荐使用 Java 配置而非 XML 配置，但是 Spring Boot 中也可以使用 XML 配置，
通过 @ImportResource 注解可以引入一个 XML 配置。

spring boot 核心配置文件是什么？bootstrap.properties 和 application.properties 有何区别 ?

单纯做 Spring Boot 开发，可能不太容易遇到 bootstrap.properties 配置文件，但是在结合 Spring Cloud 时，
这个配置就会经常遇到了，特别是在需要加载一些远程配置文件的时侯。

spring boot 核心的两个配置文件：

bootstrap (. yml 或者 . properties)：boostrap 由父 ApplicationContext 加载的，
比 applicaton 优先加载，配置在应用程序上下文的引导阶段生效。一般来说我们在 Spring Cloud Config 
或者 Nacos 中会用到它。且 boostrap 里面的属性不能被覆盖；
application (. yml 或者 . properties)：由ApplicatonContext 加载，用于 spring boot 项目的自动化配置。
什么是 Spring Profiles？

Spring Profiles 允许用户根据配置文件（dev，test，prod 等）来注册 bean。因此，当应用程序在开发中运行时，
只有某些 bean 可以加载，而在 PRODUCTION中，某些其他 bean 可以加载。假设我们的要求是 Swagger 文档仅适用于 QA 环境，
并且禁用所有其他文档。这可以使用配置文件来完成。Spring Boot 使得使用配置文件非常简单。



# 6.安全

## 6-1：如何实现 Spring Boot 应用程序的安全性？

为了实现 Spring Boot 的安全性，我们使用 spring-boot-starter-security 依赖项，
并且必须添加安全配置。
它只需要很少的代码。配置类将必须扩展WebSecurityConfigurerAdapter 并覆盖其方法。

## 6-2：比较一下 Spring Security 和 Shiro 各自的优缺点 ?

由于 Spring Boot 官方提供了大量的非常方便的开箱即用的 Starter ，
包括 Spring Security 的 Starter ，使得在 Spring Boot 中使用 Spring Security 变得更加容易，
甚至只需要添加一个依赖就可以保护所有的接口，所以，如果是 Spring Boot 项目，
一般选择 Spring Security 。当然这只是一个建议的组合，单纯从技术上来说，
无论怎么组合，都是没有问题的。Shiro 和 Spring Security 相比，主要有如下一些特点：

Spring Security 是一个重量级的安全管理框架；Shiro 则是一个轻量级的安全管理框架
Spring Security 概念复杂，配置繁琐；Shiro 概念简单、配置简单
Spring Security 功能强大；Shiro 功能简单
Spring Boot 中如何解决跨域问题 ?

跨域可以在前端通过 JSONP 来解决，但是 JSONP 只可以发送 GET 请求，
无法发送其他类型的请求，在 RESTful 风格的应用中，就显得非常鸡肋，
因此我们推荐在后端通过 （CORS，Cross-origin resource sharing） 
来解决跨域问题。这种解决方案并非 Spring Boot 特有方法，
在传统的 SSM 框架中，就可以通过 CORS 来解决跨域问题，
只不过之前我们是在 XML 文件中配置 CORS ，
现在可以通过实现WebMvcConfigurer接口然后重写addCorsMappings方法解决跨域问题。

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .maxAge(3600);
    }
}

项目中前后端分离部署，所以需要解决跨域的问题。
我们使用cookie存放用户登录的信息，在spring拦截器进行权限控制，当权限不符合时，直接返回给用户固定的json结果。
当用户登录以后，正常使用；当用户退出登录状态时或者token过期时，由于拦截器和跨域的顺序有问题，出现了跨域的现象。
我们知道一个http请求，先走filter，到达servlet后才进行拦截器的处理，如果我们把cors放在filter里，就可以优先于权限拦截器执行。

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}

## 5-3：什么是 CSRF 攻击？

CSRF 代表跨站请求伪造。这是一种攻击，迫使最终用户在当前通过身份验证的Web 
应用程序上执行不需要的操作。CSRF 攻击专门针对状态改变请求，而不是数据窃取，
因为攻击者无法查看对伪造请求的响应。

# 7.监视器

## 7-1：Spring Boot 中的监视器是什么？

Spring boot actuator 是 spring 启动框架中的重要功能之一。
Spring boot 监视器可帮助您访问生产环境中正在运行的应用程序的当前状态。
有几个指标必须在生产环境中进行检查和监控。
即使一些外部应用程序可能正在使用这些服务来向相关人员触发警报消息。
监视器模块公开了一组可直接作为 HTTP URL 访问的REST 端点来检查状态。

如何在 Spring Boot 中禁用 Actuator 端点安全性？

默认情况下，所有敏感的 HTTP 端点都是安全的，只有具有 ACTUATOR 
角色的用户才能访问它们。安全性是使用标准的 HttpServletRequest.isUserInRole 
方法实施的。我们可以使用来禁用安全性。只有在执行机构端点在防火墙后访问时，才建议禁用安全性。

我们如何监视所有 Spring Boot 微服务？

Spring Boot 提供监视器端点以监控各个微服务的度量。
这些端点对于获取有关应用程序的信息（如它们是否已启动）
以及它们的组件（如数据库等）是否正常运行很有帮助。但是，
使用监视器的一个主要缺点或困难是，我们必须单独打开应用程序的知识点以了解其状态或健康状况。
想象一下涉及 50 个应用程序的微服务，
管理员将不得不击中所有 50 个应用程序的执行终端。
为了帮助我们处理这种情况，我们将使用位于的开源项目。
它建立在 Spring Boot Actuator 之上，它提供了一个 Web UI，使我们能够可视化多个应用程序的度量。

# 8.整合第三方项目

## 8-1：什么是 WebSockets？

WebSocket 是一种计算机通信协议，通过单个 TCP 连接提供全双工通信信道。

1、WebSocket 是双向的 -使用 WebSocket 客户端或服务器可以发起消息发送。

2、WebSocket 是全双工的 -客户端和服务器通信是相互独立的。

3、单个 TCP 连接 -初始连接使用 HTTP，然后将此连接升级到基于套接字的连接。然后这个单一连接用于所有未来的通信

4、Light -与 http 相比，WebSocket 消息数据交换要轻得多。

## 8-2：什么是 Spring Data ?

Spring Data 是 Spring 的一个子项目。用于简化数据库访问，支持NoSQL 和 关系数据存储。其主要目标是使数据库的访问变得方便快捷。Spring Data 具有如下特点：

SpringData 项目支持 NoSQL 存储：

MongoDB （文档数据库）
Neo4j（图形数据库）
Redis（键/值存储）
Hbase（列族数据库）
SpringData 项目所支持的关系数据存储技术：

# 9.JDBC
## 9-1：JPA
Spring Data Jpa 致力于减少数据访问层 (DAO) 的开发量. 开发者唯一要做的，就是声明持久层的接口，其他都交给 Spring Data JPA 来帮你完成！Spring Data JPA 通过规范方法的名字，根据符合规范的名字来确定方法需要实现什么样的逻辑。

## 9-2：什么是 Spring Batch？

Spring Boot Batch 提供可重用的函数，这些函数在处理大量记录时非常重要，包括日志/跟踪，事务管理，作业处理统计信息，作业重新启动，跳过和资源管理。它还提供了更先进的技术服务和功能，通过优化和分区技术，可以实现极高批量和高性能批处理作业。简单以及复杂的大批量批处理作业可以高度可扩展的方式利用框架处理重要大量的信息。

## 9-3：什么是 FreeMarker 模板？

FreeMarker 是一个基于 Java 的模板引擎，最初专注于使用 MVC 软件架构进行动态网页生成。使用 Freemarker 的主要优点是表示层和业务层的完全分离。程序员可以处理应用程序代码，而设计人员可以处理 html 页面设计。最后使用freemarker 可以将这些结合起来，给出最终的输出页面。

## 9-4：如何集成 Spring Boot 和 ActiveMQ？

对于集成 Spring Boot 和 ActiveMQ，我们使用依赖关系。它只需要很少的配置，并且不需要样板代码。

## 9-5：什么是 Apache Kafka？

Apache Kafka 是一个分布式发布 - 订阅消息系统。它是一个可扩展的，容错的发布 - 订阅消息系统，它使我们能够构建分布式应用程序。这是一个 Apache 顶级项目。Kafka 适合离线和在线消息消费。

## 9-6：什么是 Swagger？你用 Spring Boot 实现了它吗？

Swagger 广泛用于可视化 API，使用 Swagger UI 为前端开发人员提供在线沙箱。Swagger 是用于生成 RESTful Web 服务的可视化表示的工具，规范和完整框架实现。它使文档能够以与服务器相同的速度更新。当通过 Swagger 正确定义时，消费者可以使用最少量的实现逻辑来理解远程服务并与其进行交互。因此，Swagger消除了调用服务时的猜测。

## 9-7：前后端分离，如何维护接口文档 ?

前后端分离开发日益流行，大部分情况下，我们都是通过 Spring Boot 做前后端分离开发，前后端分离一定会有接口文档，不然会前后端会深深陷入到扯皮中。一个比较笨的方法就是使用 word 或者 md 来维护接口文档，但是效率太低，接口一变，所有人手上的文档都得变。在 Spring Boot 中，这个问题常见的解决方案是 Swagger ，使用 Swagger 我们可以快速生成一个接口文档网站，接口一旦发生变化，文档就会自动更新，所有开发工程师访问这一个在线网站就可以获取到最新的接口文档，非常方便。

# 10.tomcat

## 10-1：替换掉springBoot自带的tomcat容器

1. 在依赖文件中找到让我们使用了springboot自带的tomcat
2. 找到spring-boot-starter-web节点，修改：
   ```java
   <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <!-- 移除嵌入式tomcat插件 -->
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
    ```
3. 然后再做常规的war项目配置
  在pom.xml里设置war声明，之后添加servlet-api依赖，
  修改启动类，并重写启动方法
  因为我们需要类似于web.xml的配置方式来启动spring上下文了，
  在Application类的同级添加一个SpringBootStartApplication类，
4. 配置我们自己的tomcat

## 10-2：tomcat部署方式

1. 直接把Web项目放在webapps下，Tomcat会自动将其部署
2. 在server.xml文件上配置 <Context>节点，设置相关的属性即可
3. 通过Catalina来进行配置:进入到conf\Catalina\localhost文件下，
   创建一个xml文件，该文件的名字就是站点的名字。
   编写XML的方式来进行设置。

# 10.其他

## 22-1：如何重新加载 Spring Boot 上的更改，而无需重新启动服务器？Spring Boot项目如何热部署？

这可以使用 DEV 工具来实现。通过这种依赖关系，您可以节省任何更改，嵌入式tomcat 将重新启动。Spring Boot 有一个开发工具（DevTools）模块，它有助于提高开发人员的生产力。Java 开发人员面临的一个主要挑战是将文件更改自动部署到服务器并自动重启服务器。开发人员可以重新加载 Spring Boot 上的更改，而无需重新启动服务器。这将消除每次手动部署更改的需要。Spring Boot 在发布它的第一个版本时没有这个功能。这是开发人员最需要的功能。DevTools 模块完全满足开发人员的需求。该模块将在生产环境中被禁用。它还提供 H2 数据库控制台以更好地测试应用程序。

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
</dependency>

## 22-2：您使用了哪些 starter maven 依赖项？

使用了下面的一些依赖项

spring-boot-starter-activemq

spring-boot-starter-security

这有助于增加更少的依赖关系，并减少版本的冲突。

## 22-3：Spring Boot 中的 starter 到底是什么 ?

它提供了一个自动化配置类，一般命名为 XXXAutoConfiguration ，

在这个配置类中通过条件注解来决定一个配置是否生效（条件注解就是 Spring 中原本就有的），

然后它还会提供一系列的默认配置，也允许开发者根据实际情况自定义相关配置，

然后通过类型安全的属性注入将这些配置属性注入进来，新注入的属性会代替掉默认属性。

## 22-4：spring-boot-starter-parent 有什么用 ?

定义了 Java 编译版本为 1.8 。
使用 UTF-8 格式编码。
继承自 spring-boot-dependencies，这个里边定义了依赖的版本，也正是因为继承了这个依赖，所以我们在写依赖时才不需要写版本号。
执行打包操作的配置。
自动化的资源过滤。
自动化的插件配置。
针对 application.properties 和 application.yml 的资源过滤，包括通过 profile 定义的不同环境的配置文件，例如 application-dev.properties 和 application-dev.yml。
Spring Boot 打成的 jar 和普通的 jar 有什么区别 ?

Spring Boot 项目最终打包成的 jar 是可执行 jar ，这种 jar 可以直接通过 java -jar xxx.jar 命令来运行，这种 jar 不可以作为普通的 jar 被其他项目依赖，即使依赖了也无法使用其中的类。

Spring Boot 的 jar 无法被其他项目依赖，主要还是他和普通 jar 的结构不同。普通的 jar 包，解压后直接就是包名，包里就是我们的代码，而 Spring Boot 打包成的可执行 jar 解压后，在 \BOOT-INF\classes 目录下才是我们的代码，因此无法被直接引用。如果非要引用，可以在 pom.xml 文件中增加配置，将 Spring Boot 项目打包成两个 jar ，一个可执行，一个可引用。

## 22-5：运行 Spring Boot 有哪几种方式

1）打包用命令或者放到容器中运行

2）用 Maven/ Gradle 插件运行

3）直接执行 main 方法运行

## 22-6：Spring Boot 需要独立的容器运行吗

可以不需要，内置了 Tomcat/ Jetty 等容器。

开启 Spring Boot 特性有哪几种方式？

1）继承spring-boot-starter-parent项目

2）导入spring-boot-dependencies项目依赖

## 22-7：如何使用 Spring Boot 实现异常处理

Spring 提供了一种使用 ControllerAdvice 处理异常的非常有用的方法。我们通过实现一个 ControlerAdvice 类，来处理控制器类抛出的所有异常。

## 22-8：如何使用 Spring Boot 实现分页和排序？

使用 Spring Boot 实现分页非常简单。使用 Spring Data-JPA 可以实现将可分页的传递给存储库方法。

## 22-9：微服务中如何实现 session 共享 ?

在微服务中，一个完整的项目被拆分成多个不相同的独立的服务，各个服务独立部署在不同的服务器上，各自的 session 被从物理空间上隔离开了，但是经常，我们需要在不同微服务之间共享 session ，常见的方案就是 Spring Session + Redis 来实现 session 共享。将所有微服务的 session 统一保存在 Redis 上，当各个微服务对 session 有相关的读写操作时，都去操作 Redis 上的 session 。这样就实现了 session 共享，Spring Session 基于 Spring 中的代理过滤器实现，使得 session 的同步操作对开发人员而言是透明的，非常简便。

Spring Boot 中如何实现定时任务 ?

定时任务也是一个常见的需求，Spring Boot 中对于定时任务的支持主要还是来自 Spring 框架。

在 Spring Boot 中使用定时任务主要有两种不同的方式，一个就是使用 Spring 中的 @Scheduled 注解，另一个则是使用第三方框架 Quartz。

使用 Spring 中的 @Scheduled 的方式主要通过 @Scheduled 注解来实现。

使用 Quartz ，则按照 Quartz 的方式，定义 Job 和 Trigger 即可。


## 10-10：Spring Boot 的核心注解是哪个？它主要由哪几个注解组成的？

启动类上面的注解是@SpringBootApplication，它也是 Spring Boot 的核心注解，主要组合包含了以下 3 个注解：

@SpringBootConfiguration：组合了 @Configuration 注解，实现配置文件的功能。

@EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能：@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })。

@ComponentScan：Spring组件扫描。

# -------------注解-----------------------------------------------------------

# 1. @SpringBootApplication

这个注解是 Spring Boot 项目的基石，
创建 SpringBoot 项目之后会默认在主类加上。

我们可以把 @SpringBootApplication看作是 
@Configuration、@EnableAutoConfiguration、@ComponentScan 
注解的集合。
@EnableAutoConfiguration：启用 SpringBoot 的自动配置机制
@ComponentScan： 扫描被@Component (@Service,@Controller)注解的 bean，
                 注解默认会扫描该类所在的包下所有的类。
@Configuration：允许在 Spring 上下文中注册额外的 bean 或导入其他配置类
```java
@SpringBootApplication
public class SpringSecurityJwtGuideApplication {
      public static void main(java.lang.String[] args) {
        SpringApplication.run(SpringSecurityJwtGuideApplication.class, args);}}
```

# 2.Spring Bean相关

## 2-1：@Autoworied

自动导入对象到类中，被注入进的类同样要被 Spring 容器管理
比如：Service 类注入到 Controller 类中。

```java
@Service
public class UserService {
  ......
}
------------------------------------
@RestController
@RequestMapping("/users")
public class UserController {
   @Autowired
   private UserService userService;
   ......
}
```

## 2-2：@Component,@Repository,@Service, @Controller

用来标识这个属于那一层

@Component ：如果一个 Bean 不知道属于哪个层，可以使用@Component 注解标注。
@Repository : 对应持久层即 Dao 层，主要用于数据库相关操作。
@Service : 对应服务层，主要涉及一些复杂的逻辑，需要用到 Dao 层。
@Controller : 对应 Spring MVC 控制层，
              主要用户接受用户请求并调用 Service 层返回数据给前端页面。

## 2-3：@RestController

@RestController注解是@Controller和@ResponseBody的合集,
表示这是个控制器bean,并且是将函数的返回值
直接填入 HTTP 响应体中,是REST风格的控制器。

### 2-3-1：@RestController vs @Controller区别

单独使用 @Controller 不加 @ResponseBody的话一般使用在要返回一个视图的情况
当我们需要直接在后端返回一个页面的时候，Spring 推荐使用 Thymeleaf 模板引擎。
Spring MVC中@Controller中的方法可以直接返回模板名称，
接下来 Thymeleaf 模板引擎会自动进行渲染,模板中的表达式支持Spring表达式语言

```java
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String greeting(
        @RequestParam(name = "name", 
        required = false, defaultValue = "World") 
        String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}
之后会去 resources 目录下 templates 目录下找hello文件
```

@RestController只返回对象，
对象数据直接以 JSON 或 XML 形式写入 HTTP 响应(Response)中，
只需要加入注解就可以了
```java
public class Person {
    private String name;
    private Integer age;
    ......
    省略getter/setter ，有参和无参的construtor方法
}
------------------------------------------------------------------
@RestController
public class HelloController {
    @PostMapping("/hello")
    public Person greeting(@RequestBody Person person) {
        return person;}}
```
## 2-4：@Scope

声明 Spring Bean 的作用域，比如说

```java
@Bean
@Scope("singleton")
public Person personSingleton() {
    return new Person();
}
```
还有比较常见的作用域

## 2-5：@Configuration

一般用来声明配置类，可以使用 @Component注解替代，
不过使用Configuration注解声明配置类更加语义化。
```java
@Configuration
public class AppConfig {
    @Bean
    public TransferService transferService() {
        return new TransferServiceImpl();}}
```

# 3.处理常见HTTP请求类型
```java
GET ：请求从服务器获取特定资源。
      举个例子：GET /users（获取所有学生）
POST ：在服务器上创建一个新的资源。
       举个例子：POST /users（创建学生）
PUT ：更新服务器上的资源（客户端提供更新后的整个资源）。
      举个例子：PUT /users/12（更新编号为 12 的学生）
DELETE ：从服务器删除特定的资源。
         举个例子：DELETE /users/12（删除编号为 12 的学生）
PATCH ：更新服务器上的资源
      （客户端提供更改的属性，可以看做作是部分更新），目前还没有怎么使用过。
```
## 3-0：@RequestMapping

@RequestMapping注解可以将HTTP请求映射给controller
来处理，包括返回视图页面的controller和Rest服务的controller。
比如说
@RequestMapping(value="/users",method=RequestMethod.GET)
修改

## 3-1：get请求

@GetMapping("users") 等价于
@RequestMapping(value="/users",method=RequestMethod.GET)

```java
@GetMapping("/users")
public ResponseEntity<List<User>> getAllUsers() {
 return userRepository.findAll();
}
```
## 3-2：post请求

@PostMapping("users") 等价于
@RequestMapping(value="/users",method=RequestMethod.POST)

```java
@PostMapping("/users")
public ResponseEntity<User> createUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
 return userRespository.save(user);
}
```

## 3-3：put请求

@PutMapping("/users/{userId}")等价于
@RequestMapping(value="/users/{userId}",method=RequestMethod.PUT)

```java
@PutMapping("/users/{userId}")
public ResponseEntity<User> updateUser(@PathVariable(value = "userId") Long userId,
  @Valid @RequestBody UserUpdateRequest userUpdateRequest) {
  ......
}
```

## 3-4：delete请求

@DeleteMapping("/users/{userId}")等价于
@RequestMapping(value="/users/{userId}",method=RequestMethod.DELETE)

```java
@DeleteMapping("/users/{userId}")
public ResponseEntity deleteUser(@PathVariable(value = "userId") Long userId){
  ......
}
```

## 3-5：patch请求

都是 PUT 不够用了之后才用 PATCH 请求去更新数据。
```java
  @PatchMapping("/profile")
  public ResponseEntity updateStudent(@RequestBody StudentUpdateRequest studentUpdateRequest) {
        studentRepository.updateDetail(studentUpdateRequest);
        return ResponseEntity.ok().build();
    }
```

# 4.前后端传值

## 4-1：@PathVariable和 @RequestParam

@PathVariable用于获取路径参数，@RequestParam用于获取查询参数。

```java
GetMapping("/klasses/{klassId}/teachers")
public List<Teacher> getKlassRelatedTeachers(
         @PathVariable("klassId") Long klassId,
         @RequestParam(value = "type", required = false) String type ) {
...
}
```
如果我们请求的 url 是：/klasses/{123456}/teachers?type=web
那么我们服务获取到的数据就是：klassId=123456,type=web

## 4-2：@RequestBody

用于读取 Request 请求（可能是 POST,PUT,DELETE,GET 请求）
的 body 部分并且Content-Type 为 application/json 格式的数据，
接收到数据之后会自动将数据绑定到 Java 对象上去。
系统会使用HttpMessageConverter
或者自定义的HttpMessageConverter将请求的 body 中
的 json 字符串转换为 java 对象。

```java
我们有一个注册的接口：
@PostMapping("/sign-up")
public ResponseEntity signUp(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {
  userService.save(userRegisterRequest);
  return ResponseEntity.ok().build();
}
-------------------------------------------------------------------------------------------------
UserRegisterRequest对象：
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    @FullName
    @NotBlank
    private String fullName;
}
我们发送 post 请求到这个接口，并且 body 携带 JSON 数据：
{"userName":"coder","fullName":"shuangkou","password":"123456"}
```
这样我们的后端就可以直接把 json 格式的数据映射到我们的 UserRegisterRequest 类上。

# 5.读取配置信息

application.yml配置信息
```java
wuhan2020: 2020年初武汉

my-profile:
  name: Guide哥
  email: koushuangbwcx@163.com

library:
  location: 湖北武汉加油中国加油
  books:
    - name: 天才基本法
      description: 二十二岁的林朝夕
    - name: 时间的秩序
      description: 为什么我们
    - name: 了不起的我
      description: 如何养成
```

## 5-1：@value

使用 @Value("${property}") 读取比较简单的配置信息：
```java
@Value("${wuhan2020}")
String wuhan2020;
```
## 5-2：@ConfigurationProperties

通过@ConfigurationProperties读取配置信息并与 bean 绑定。

```java
@Component
@ConfigurationProperties(prefix = "library")
class LibraryProperties {
    @NotEmpty
    private String location;
    private List<Book> books;

    @Setter
    @Getter
    @ToString
    static class Book {
        String name;
        String description;
    }
  省略getter/setter
  ......
}
```
## 5-3：PropertySource

@PropertySource读取指定properties 文件
```java
@Component
@PropertySource("classpath:website.properties")
class WebSite {
    @Value("${url}")
    private String url;

  省略getter/setter
  ......
}
```
### 5-3-1：Spring 加载配置文件的优先级

首先是根目录下面的yml文件
其次是resources的yml文件
最后是config的yml文件

# 6.参数校验

前端对数据进行校验的情况下，
我们还是要对传入后端的数据再进行一遍校验，
避免用户绕过浏览器直接通过一些 HTTP 工具直接
向后端请求一些违法数据
JSR(Java Specification Requests） 是一套 JavaBean 参数校验的标准，
它定义了很多常用的校验注解，
我们可以直接将这些注解加在我们 JavaBean 的属性上面，
这样就可以在需要校验的时候进行校验了，非常方便！
SpringBoot 项目的 spring-boot-starter-web 依赖中
已经有 hibernate-validator 包，不需要引用相关依赖。

## 6-1：一些常用的字段验证的注解

@NotEmpty 被注释的字符串的不能为null，也不能为空
@NotBlank 被注释的字符串非 null，并且必须包含一个非空白字符
@Null 被注释的元素必须为 null
@NotNull 被注释的元素必须不为 null
@AssertTrue 被注释的元素必须为 true
@AssertFalse 被注释的元素必须为 false
@Pattern(regex=,flag=)被注释的元素必须符合指定的正则表达式
@Email 被注释的元素必须是 Email 格式。
@Min(value)被注释的元素必须是一个数字，其值必须大于等于指定的最小值
@Max(value)被注释的元素必须是一个数字，其值必须小于等于指定的最大值
@DecimalMin(value)被注释的元素必须是一个数字，其值必须大于等于指定的最小值
@DecimalMax(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
@Size(max=, min=)被注释的元素的大小必须在指定的范围内
@Digits (integer, fraction)被注释的元素必须是一个数字，其值必须在可接受的范围内
@Past被注释的元素必须是一个过去的日期
@Future 被注释的元素必须是一个将来的日期

## 6-2：验证请求体(RequestBody)

# 7.全局处理Controller层异常

# 8.JPA相关

## 8-1：创建表

## 8-2：验证请求参数(Path Variables和Request Parameters)

## 8-3：设置字段类型

## 8-4：指定不持久化特定字段

## 8-5：声明大字段

## 8-6：创建枚举类型的字段

## 8-7：增加审计功能

## 8-8：删除/修改数据

## 8-9：关联关系

# 9.事务@Transactional

# 10.json数据处理

## 10-1：过滤json数据

## 10-2：格式化json数据

## 10-3：扁平化对象

# 11.测试相关
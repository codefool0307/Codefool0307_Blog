<!--
 * @Author: 孙浩然
 * @Date: 2020-07-13 07:35:01
 * @LastEditors: 孙浩然
 * @LastEditTime: 2020-07-28 14:32:16
 * @FilePath: \docs\4.interview\12-Spring面经.md
 * @博客地址: 个人博客，如果各位客官觉得不错，请点个赞，谢谢。[地址](https://codefool0307.github.io/Java-Point/#/)，如对源码有异议请在我的博客中提问
--> 


Spring中的这几个注解有什么区别：@Component 、@Repository、@Service、@Controller
@Component指的是组件，
@Controller，@Repository和@Service 注解都被@Component修饰，用于代码中区分表现层，持久层和业务层的组件，代码中组件不好归类时可以使用@Component来标注

当前版本只有区分的作用，未来版本可能会添加更丰富的功能




## 21-3：Spring常用注解

1. @Configuration把一个类作为一个IoC容器，它的某个方法头上如果注册了@Bean，就会作为这个Spring容器中的Bean。

2. @Scope注解 作用域

3. @Lazy(true) 表示延迟初始化

4. @Service用于标注业务层组件

5. @Controller用于标注控制层组件@Repository用于标注数据访问组件，即DAO组件。

6. @Component泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。

7. @Scope用于指定scope作用域的（用在类上）

8. @PostConstruct用于指定初始化方法（用在方法上）

9. @PreDestory用于指定销毁方法（用在方法上）

10. @DependsOn：定义Bean初始化及销毁时的顺序

11. @Primary：自动装配时当出现多个Bean候选者时，被注解为@Primary的Bean将作为首选者，否则将抛出异常

12. @Autowired 默认按类型装配，如果我们想使用按名称装配，可以结合@Qualifier注解一起使用。如下： @Autowired 

13. @Qualifier("personDaoBean") 存在多个实例配合使用

@Resource默认按名称装配，当找不到与名称匹配的bean才会按类型装配。

@PostConstruct 初始化注解

@PreDestroy 摧毁注解 默认 单例 启动就加载

## Spring中Bean的作用域


## Spring的AOP和IOC。写过哪些动态代理

## AOP的应用场景？

## Spring相关，SpringAOP底层怎么实现的

## 什么是SpringIOC?

## Spring的核心是什么

## AOP的应用场景

## spring如何解决循环依赖

Spring能够轻松的解决属性的循环依赖正式用到了三级缓存，

一级缓存：存放完全实例化属性赋值完成的Bean，直接可以使用。
二级缓存：存放早期Bean的引用，尚未属性装配的Bean
三级缓存：存放实例化完成的Bean工厂。

## 

## 

## 

## 

## 

## 

## 

## 

## 

## 

## 

## 

## 

## 

## 

## 
## 

## 

## 

## 

## 

## 

## 

## 
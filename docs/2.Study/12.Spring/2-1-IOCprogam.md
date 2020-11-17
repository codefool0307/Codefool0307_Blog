# 1.IOC编写

IOC程序编写主要分为了三部分

1. 导包
2. 编写
3. 测试

那么我就想写一个程序，能够使得spring可以自动创建Person对象

1. 导包
   ```js
    spring-beans-4.0.0.RELEASE.jar
    spring-context-4.0.0.RELEASE.jar
    spring-core-4.0.0.RELEASE.jar
    spring-expression-4.0.0.RELEASE.jar
    commons-logging-1.1.3.jar
    junit-4.1.2.jar
    hamcrest-core-1.1.jar
   ```

2. 我想让spring自动创建一个person对象，我就需要使用bean----->使用xml文件
   * bean是什么？~~组成应用程序的主体及由 Spring IOC 容器所管理的对象~~简单的说就是一个对象，而且在bean里面把想写的写在里面
   
   目前bean有一种写法在xml中写

   * bean 标签有三个常用属性
     * id
     * name
     * [scope](https://www.cnblogs.com/yoci/p/10642553.html)

```js
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

<!--注意：
1. bean的作用是与HelloWord helloword = new HelloWord()一样的，但是注意不等同于new 对象，因为他是用了反射的思维在里面
   我们用的类就是person类，然后对person实例化，实例化对象名为person01，之后进行了setName()方法去设置属性的值
-->

<bean id="person01" class="person" >
	<property name="lastname" value="张三"></property>
	<property name="age" value="18"></property>
	<property name="email" value="sh"></property>
	<property name="gender" value="true"></property>
</bean>
</beans>
```

3. 我有了这个person类的bean，那么我怎么使用呢，就需要对spring核心容器进行创建工作

那么Spring的核心容器有两种：

1. BeanFactory
2. ApplicationContext

注：
   * BeanFactory使用绝对路径加载配置文件

   * ApplicationContext使用相对路径加载配置文件,但是呢ApplicationContext是一个接口，没办法继承或实现，然鹅他有两个x代重孙子：
  
     * FileSystemXmlApplicationContext------new ClassPathXmlApplicationContext("spring-config.xml");  ioc容器的配置文件在类路径下
     * ClassPathXmlApplicationContext-------new FileSystemXmlApplicationContext("F://ioc.xml");ioc容器的配置文件在磁盘路径下


```java
public class Demo20070703IOC {
	@Test
	public void test01(){
		applicationContext ioc =
			new ClassPathXmlApplicationContext("spring-config.xml");//我们找到了xml 文件，如何找到ioc中的bean呢？

/*  如何找到ioc中的bean呢

1.方法一:利用id定位到IOC容器中的bean
HelloWord helloword = ioc.getBean(“person01”);
在配置文件中,配置的bean很多的时候,就要靠id的定位才可以准确地找到对应的bean. 

2. 方法二:利用类型
HelloWord helloword = ioc.getBean(HelloWord.class);
解析:实质是通过类型去获得bean，如果bean不是唯一的，那就无法获取，因为不知道要获取的是哪一个。HelloWord.class  
*/
		person bean = (person) ioc.getBean("person01");
		System.out.println(bean);
	}

}
```

注意：

1. 同一个组件在ioc容器都是单例的，但是你如果这个组件你没有创建，那就不能使用
2. property的setter方法：
   
方式一：set方法注入

```js
<bean id="stu1" class="com.yc.pojo.Student" scope="prototype">
<property name="sid" value="1001"></property>
<property name="name" value="张三"></property></bean>
```

方式二:使用p命名空间简化set注入方法
首先，增加命名空间
```js
xmlns:p="http://www.springframework.org/schema/p"
```
p命名空间适用于参数少的时候 普通数据 p:name 引用数据 p:属性名-ref

```js
 <bean id="stu2" class="com.yc.pojo.Student" p:sid="1002" p:name="李四" ></bean>
```

# 2.根据bean的类型从IOC容器中获取bean的实例

如果说我存在多个bean中，那么根据ioc.getBean(Person.class)来进行查找的话，那么就会出现
```java
org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type [com.Codefool0307.bean.Person] is defined: expected single matching bean but found 2: person01,person02
```
为了避免这个错误，那么就需要一个解决方案了

```java
@Test
    public void IOCTest02(){
        Person person02 = ioc.getBean("person02", Person.class);
        System.out.println(person02);
    }
```

注意：

1与2是通过调用get/set方法进行赋值操作

# 3.调用构造器来进行bean属性赋值

```java
public class Person {
    private String lastname;
    private Integer age;
    private String gender;
    private String email;

    public Person() {
    }

    public Person(String lastname, Integer age, String gender, String email) {
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }
```

```java
<bean id="perosn03" class="com.Codefool0307.bean.Person">
        <constructor-arg name="age" value="12"></constructor-arg>
        <constructor-arg name="email" value="xxx"></constructor-arg>
        <constructor-arg name="gender" value="wu"></constructor-arg>
        <constructor-arg name="lastname" value="yyy"></constructor-arg>
    </bean>
```

测试即可

## 3-1.通过constructor-arg属性name、value进行赋值操作

```java
<!--通过省略name属性来进行赋值，必须要保证与构造器顺序一致,如果不一致，会出现标记错误-->
    <!--String lastname, Integer age, String gender, String email-->
    <bean id="person04" class="com.Codefool0307.bean.Person">
        <constructor-arg value="wufatiandi"></constructor-arg>
        <constructor-arg value="12"></constructor-arg>
        <constructor-arg value="nv"></constructor-arg>
        <constructor-arg value="@gmail.com"></constructor-arg>
    </bean>

    <!--也可以使用index属性，来进行标记-->
    <!--String lastname, Integer age, String gender, String email-->
    <bean id="person05" class="com.Codefool0307.bean.Person">
        <constructor-arg value="wufatiandi" index="0"></constructor-arg>
        <constructor-arg value="nv" index="2"></constructor-arg>
        <constructor-arg value="45" index="1"></constructor-arg>
        <constructor-arg value="@gmail.com" index="3"></constructor-arg>
    </bean>

    <!--如果有多个构造器，那么来进行标记-->
    <!--String lastname, Integer age, String gender, String email-->
    <!--Integer age,String email,String gender-->
    <bean id="person06" class="com.Codefool0307.bean.Person">
        <constructor-arg value="23" type="java.lang.Integer"></constructor-arg>
        <constructor-arg value="45" index="1"></constructor-arg>
        <constructor-arg value="@gmail.com" index="3"></constructor-arg>
    </bean>
```

# 4.名称空间

首先需要在

```java
 <bean id="person07" class="com.Codefool0307.bean.Person"
    p:age="21" p:email="shrlove888@163.com">
```
<!--
 * @Author: 孙浩然
 * @Date: 2020-07-08 14:02:49
 * @LastEditors: 孙浩然
 * @LastEditTime: 2020-07-13 14:21:34
 * @FilePath: \Java-Point\docs\2.Study\12.Spring\2-IOC.md
 * @博客地址: 个人博客，如果各位客官觉得不错，请点个赞，谢谢。[地址](https://codefool0307.github.io/JavaScholar/#/)
--> 
# 2. IOC

## 2.1 IOC概念——控制反转

1. 控制思想：

在我们传统程序设计的时候，我们使用的是通过new xxx进行创建对象，是程序<font color="#890" size='5'>主动</font>做的，为了方便脑子不好使的时候——创建了IOC

Ioc就是一个专门<font color="red" size="5">用来创建对象</font>的<font color="green" size="5">容器</font>

2. 反转思想：

传统程序设计，我们需要先创建<font color="#0987" size="6">班级信息类</font>，在创建<font color="blue" size="6">学生信息类</font>

我想看班级里面有什么学生，我没有<font color="blue" size="6">学生信息类</font>，我就没办法查看学生的一些信息，所以呢，<font color="#0987" size="6">班级信息类</font>需要主动去获取<font color="pink">依赖对象</font>，也就是所说的<font  color="blue" bgcolor="#098" size="6">学生信息类</font>-------这个也就是正转

那么现在呢，依然有两个类，但是呢，多了一个媒婆（中间商）——IOC容器

容器创建了一个班级信息类，然后看看学生信息类需不需要依赖注入
需要注入，那么容器创建学生信息类，并注入到班级信息类

别找我们，我们找你（就跟追女神一个道理，没事，我去找你吧，天气太热了。你过来太累了）

3. DI

通过反射的思想把学生信息类注入到班级信息类中

 
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
 
   * bean 标签有三个常用属性
     * id
     * name
     * [scope](https://www.cnblogs.com/yoci/p/10642553.html)

```js
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
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
		ClassPathXmlApplicationContext ioc =
			new ClassPathXmlApplicationContext("spring-config.xml");
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






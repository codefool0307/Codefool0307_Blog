<!--
 * @Author: 孙浩然
 * @Date: 2020-07-13 15:24:02
 * @LastEditors: 孙浩然
 * @LastEditTime: 2020-07-13 16:57:37
 * @FilePath: \Java-Point\docs\2.Study\12.Spring\3-1-IOC常用标签.md
 * @博客地址: 个人博客，如果各位客官觉得不错，请点个赞，谢谢。[地址](https://codefool0307.github.io/Java-Point/#/)，如对源码有异议请在我的博客中提问
--> 

那么我们就学习一下常用标签，

# 1 bean标签初步认识

在IOC已经进行阐述了，不在进行讲解

# 2 根据bean的类型从IOC容器获取bean的实例

```js
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="person01" class="person">
		<property name="age" value="12"></property>
		<property name="lastname" value="桃花"></property>
	</bean>

	<bean id="person02" class="person">
		<property name="age" value="12"></property>
		<property name="lastname" value="桃花"></property>
	</bean>

</beans>
```

```java
public class Test02 {
	private ClassPathXmlApplicationContext ioc
			= new ClassPathXmlApplicationContext("spring-config.xml");
	@Test
	public void test02(){

        //通过class反射思想获取，但是因为一个class文件可能存在多个person对象，必须要表明你的实例对象是谁？
        //也就是    第一次Person person1=newPerson（）第二次Person person2=newPerson（）
                  //但是JVM不知道你弄得那个，你必须说一下子
		person bean = ioc.getBean("person02",person.class);
		System.out.println(bean);
	}
}
```

# 3 构造器为bean的属性赋值

在这里使用的就是constructor-arg标签，在这个标签比较常用的属性有：

1. name
2. value
3. type----属性
4. index---位置

## 3.1 第一种

```js
<bean id="person03" class="person">
		<constructor-arg value="消化" name="lastname"></constructor-arg>
		<constructor-arg value="23" name="age"></constructor-arg>
</bean>
```
但是一定要注意：如果你写了两个，那么你的class类的构造器也就只能是两个

```java
public person(String lastname, int age, String email, Boolean gender) {
		this.lastname = lastname;
		this.age = age;
		this.email = email;
		this.gender = gender;
	}

public person(String lastname, int age) {
		this.lastname = lastname;
		this.age = age;
	}
```


## 3.2 第二种

那么，写name太麻烦了，能不能省略？？？

那么就在使用index标签来确定顺序就不用写了
```js
<bean id="person04" class="person">
		<constructor-arg value="消化" index="0"></constructor-arg>
		<constructor-arg value="23" index="1"></constructor-arg>
	</bean>
```

但是，这样使用index标签有时候太麻烦，我如果就知道他的类型，就直接使用type就好了

```js
    <bean id="person05" class="person">
		<constructor-arg value="消化" type="java.lang.String"></constructor-arg>
		<constructor-arg value="23" index="1"></constructor-arg>
    </bean>
```

# 4 p空间为bean的属性赋值

之前的方法又得使用property标签，标签还得写入属性

constructor-arg标签也得写入标签，标签中写入属性

这样太麻烦，

我们采用了p名称空间（名称空间是用来放置标签重复的）

步骤：

1. 导入p名称空间
2. 写带前缀的标签/属性

```js
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	   xmlns:p="http://www.springframework.org/schema/p"//添加的p空间
	   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	   xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	<bean id="person06" class="person" p:age="23" p:lastname="yutii">
	</bean>

</beans>
```

# 5 为各种属性赋值





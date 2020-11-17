<!--
 * @Author: 孙浩然
 * @Date: 2020-07-08 14:02:49
 * @LastEditors: 孙浩然
 * @LastEditTime: 2020-11-09 16:42:25
 * @FilePath: \docs\2.Study\12.Spring\2-IOC.md
 * @博客地址: 个人博客，如果各位客官觉得不错，请点个赞，谢谢。[地址](https://codefool0307.github.io/JavaScholar/#/)
--> 
# 2. IOC

## 2.1 IOC概念——控制反转

1. 控制思想：

在我们传统程序设计的时候，我们使用的是通过new xxx进行创建对象，

是程序<font color="#890" size='5'>主动</font>做的，为了方便脑子不好使的时候——创建了IOC

Ioc就是一个专门<font color="red" size="5">用来创建对象</font>的<font color="green" size="5">容器</font>

2. 反转思想：

传统程序设计，我们需要先创建<font color="#0987" size="6">班级信息类</font>，在创建<font color="blue" size="6">学生信息类</font>

我想看班级里面有什么学生，我没有<font color="blue" size="6">学生信息类</font>，我就没办法查看学生的一些信息，所以呢，<font color="#0987" size="6">班级信息类</font>需要主动去获取<font color="pink">依赖对象</font>（如何主动获取呢，我直接new 学生信息类），-------这个也就是正转

那么现在呢，依然有两个类，但是呢，多了一个媒婆（中间商）——IOC容器

容器创建了一个班级信息类，然后看看学生信息类需不需要依赖注入
需要注入，那么容器创建学生信息类，并注入到班级信息类

## 2.2 DI

通过反射的思想把学生信息类注入到班级信息类中

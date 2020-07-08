<!--
 * @Author: 孙浩然
 * @Date: 2020-05-14 20:43:32
 * @LastEditors: 孙浩然
 * @LastEditTime: 2020-07-08 14:03:12
 * @FilePath: \Java-Point\docs\6.Frame\1.Spring\1-spring框架概述.md
 * @博客地址: 个人博客，如果各位客官觉得不错，请点个赞，谢谢。[地址](https://codefool0307.github.io/JavaScholar/#/)
 -->
# 1. Spring框架概述

## 1.1 框架概念

不过多的进行介绍了

## 1.2 模块划分

![avatar](https://github.com/codefool0307/Java-Point/blob/master/docs/6.Frame/1.Spring/assets/1-1.jpg?raw=true)

一共21个分类，三个一组

1. Core Container:核心容器（IOC）；黑色代表这部分的功能由哪些jar包组成；要使用这个部分的完整功能，这些jar都需要导入
   
   ```java
   spring-beans-4.0.0.RELEASE、
   spring-core-4.0.0.RELEASE、
   spring-context-4.0.0.RELEASE、
   spring-expression-4.0.0.RELEASE
   ```

2. Data Access/Integration:数据库访问

  ```java
     spring-jdbc-4.0.0.RELEASE、
     spring-orm(Object Relation Mapping)-4.0.0.RELEASE、
     spring-ox（xml）m-4.0.0.RELEASE、
     spring-jms-4.0.0.RELEASE、（Intergration）
     spring-tx-4.0.0.RELEASE(事务)
  ```

3. Web:Spring开发web应用的模块；

    ```java
    spring-websocket(新的技术)-4.0.0.RELEASE、
    spring-web-4.0.0.RELEASE、和原生的web相关（servlet）
    spring-webmvc-4.0.0.RELEASE、开发web项目的（web）
    spring-webmvc-portlet-4.0.0.RELEASE（开发web应用的组件集成）
    ```
4. AOP+Aspects

    ```java
    spring-aop-4.0.0.RELEASE、
    spring-aspects-4.0.0.RELEASE
    ```

5. Test

   ```java
    spring-test-4.0.0.RELEASE
    ```


     




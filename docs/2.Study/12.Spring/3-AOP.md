<!--
 * @Author: 孙浩然
 * @Date: 2020-07-13 14:39:26
 * @LastEditors: 孙浩然
 * @LastEditTime: 2020-07-13 15:23:31
 * @FilePath: \Java-Point\docs\2.Study\12.Spring\3-AOP.md
 * @博客地址: 个人博客，如果各位客官觉得不错，请点个赞，谢谢。[地址](https://codefool0307.github.io/Java-Point/#/)，如对源码有异议请在我的博客中提问
--> 
# 1.概念

首先要明白两个概念：

1. AOP是啥？----->面向切面编程，很蒙，不知道是啥意思
2. OOP是啥？----->面向对象编程，貌似知道他是啥意思

有大哥说，面向切面编程就是基于OOP基础之上新的编程思想----->那他也是面向对象编程了

那么他到底啥呢？

将<font color='red' size='5'>某段代码</font><font color='pink' size='3'>动态的切入</font>到<font color='green' size='6'>指定方法</font>的<font color='#6762' size='4'>指定位置</font>进行运行的编程思想

某段代码、指定方法、指定位置我都很好理解，也大概知道怎么做，但是这个动态切入是怎么实现的？

那么
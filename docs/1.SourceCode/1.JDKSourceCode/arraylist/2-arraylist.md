<!--
 * @Author: 孙浩然
 * @Date: 2020-10-12 08:14:25
 * @LastEditors: 孙浩然
 * @LastEditTime: 2020-10-14 09:28:30
 * @FilePath: \1.SourceCode\1.JDKSourceCode\arraylist\2-arraylist.md
 * @博客地址: 个人博客，如果各位客官觉得不错，请点个赞，谢谢。[地址](https://codefool0307.github.io/Java-Point/#/)，如对源码有异议请在我的博客中提问
-->
# 1 ArrayList

## 1.1 arraylist简介

ArrayList ，基于Object数组实现的，支持自动扩容的动态数组。

相比数组来说，因为其支持自动扩容的特性，成为我们日常开发中，最常用的集合类，没有之一。

## 2.2 arraylist的类图

![类图](http://code.clouddn.com/01-%E7%B1%BB%E5%9B%BE.jpg)

### 2.2.1 RandomAccess要他何用

当我们转到这个借口的时候发现

```java
public interface RandomAccess {
}
```
空架子，莫非又是一个跟序列化seriable类似作用的（这个借口后续讲解）

那么就来看看官方怎么说的， 

RandomAccess 是 List 实现所使用的标记接口，用来表明其`支持快速（通常是固定时间）随机访问`。

此接口的主要目的是允许一般的算法更改其行为，从而在将其应用到随机或连续访问列表时能提供良好的性能。

 RandomAccess 为空的原因就是`这个接口的功能仅仅起到标记的作用。`

### 2.2.2 其他的空接口

那么看看arraylist还有没有继承其他的空接口呢

1. Cloneable 接口
   实现了 Cloneable 接口，以指示 Object.clone() 方法可以合法地对该类实例进行按字段复制。

   如果在没有实现 Cloneable 接口的实例上调用 Object 的 clone 方法，则会导致抛出 CloneNotSupportedException 异常。

2. Serializable 接口
   类通过实现 java.io.Serializable 接口以启用其序列化功能。

   未实现此接口的类将无法使其任何状态序列化或反序列化。

### 2.2.3 标记接口的作用

先说一下**结论**

我们可以利用RandomAccess在遍历前进行判断，根据 List 的不同子类选择不同的遍历方式， 提升算法性能。

再来看看
以RandomAccess为例，

因为JDK作者说实现了RandomAccess 接口，那表示它能快速随机访问存储的元素

既然能够实现快速访问，那么想一下啥样子的`数据结构`可以实现快速访问--->数组可以实现

1. 数组支持随机访问，查询速度快，增删元素慢；
2. 链表支持顺序访问，查询速度慢，增删元素快。

那么这样，LinkedList底层是链表，那么他查询慢，是不是就没有实现RandomAccess 接口
带着这样的疑问，我去看源码LinkedList源码

```java
public class LinkedList<E>
    extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable
```

好了，来总结一下

首先数组支持随机快速查询，链表是不支持快速查询

那么我就可以用这个标记接口用来标记，我这个方法支持快速访问，看起来简单明了，没有其他意思

### 2.2.4 遍历方式的选择

由于不同的类，选择不同的遍历方式，算法性能是不一样的

-------------------------------------------------------
想一下有哪几种遍历方式
-------------------------------------------------------

比较一下：ArrayList与LinkedList

`总结：ArrayList 使用 for 循环遍历优于迭代器遍历 LinkedList 使用 迭代器遍历优于 for 循环遍历`

实验待做（https://juejin.im/post/6844903519066193927）

## 2.3 arraylist源码部分

### 2.3.1 类的头部信息

已经在2.2节类图进行了阐述，不在阐述

### 2.3.2 属性

```java
transient Object[] elementData; 
private int size;
```

ArrayList只有两个属性

elementData---->元素数组
size----------->数组大小（已使用的数组大小）

有两点是需要注意的：
1. size只是表示已使用的数量，比如说elementData有十个位置，但是size只用了3个位置
   但是数组真正的大小却是elementData 的大小
2. 当添加新的元素时，如果该`数组不够`，会创建新数组，并将原数组的元素拷贝到新数组。之后，将该变量指向新数组。

### 2.3.3 构造方法

ArrayList一共有三个构造器

#### 2.3.3.1 无参构造函数

```java

 public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }
```

同时，由于有一个变量，DEFAULTCAPACITY_EMPTY_ELEMENTDATA

看看定义中有没有

```java
private static final int DEFAULT_CAPACITY = 10;

private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
```

我一直以为，在未初始化的时候，arraylist默认大小是10，其实不是很严谨的

因为，有一个DEFAULTCAPACITY_EMPTY_ELEMENTDATA的空数组，因为arraylist考虑到节省内存

一些场景下仅仅创建了ArrayList对象，但是没有用到他，所以ArrayList初始化是一个空数组

只有当`首次`**注意**`必须是首次`才真正初始化为容量为10的数组

#### 2.3.3.2 ArrayList(int initialCapacity)

```java
public ArrayList(int initialCapacity) {
    // 初始化容量大于 0 时，创建 Object 数组
    if (initialCapacity > 0) {
        this.elementData = new Object[initialCapacity];
    // 初始化容量等于 0 时，使用 EMPTY_ELEMENTDATA 对象
    } else if (initialCapacity == 0) {
        this.elementData = EMPTY_ELEMENTDATA;<-----有个这个
    // 初始化容量小于 0 时，抛出 IllegalArgumentException 异常
    } else {
        throw new IllegalArgumentException("Illegal Capacity: "+
                                           initialCapacity);
    }
}
```

主要是根据传入的初始化容量，创建ArrayList数组

但是呢，如果我们已经知道了数组的大小，一定要使用构造方法

这样做的目的是可以避免数组扩容，提高性能；也可以合理使用内存

同时有一个，EMPTY_ELEMENTDATA

```java
private static final Object[] EMPTY_ELEMENTDATA = {};
```

哎，这个不就是跟无参构造函数中DEFAULTCAPACITY_EMPTY_ELEMENTDATA一样的作用呢。

一个空数组

原来在下面的扩容机制上对这两种空白数组机制进行了解释，在扩容机制上，

DEFAULTCAPACITY_EMPTY_ELEMENTDATA 首次扩容为 10 ，
而EMPTY_ELEMENTDATA按照1.5 倍扩容从 0 开始而不是10 
之后会详细介绍

#### 2.3.3.3 ArrayList(Collection<? extends E> c)

```java
public ArrayList(Collection<? extends E> c) {
    // 将 c 转换成 Object 数组
    elementData = c.toArray();
    // 如果数组大小大于 0
    if ((size = elementData.length) != 0) {
        // <X> 如果集合元素不是 Object[] 类型，则会创建新的 Object[] 数组，
        //并将 elementData 赋值到其中，最后赋值给 elementData 。
        if (elementData.getClass() != Object[].class)
            elementData = Arrays.copyOf(elementData, size, Object[].class);
    // 如果数组大小等于 0 ，则使用 EMPTY_ELEMENTDATA 。
    } else {
        // replace with empty array.
        this.elementData = EMPTY_ELEMENTDATA;
    }
}
```
待修订http://svip.iocoder.cn/JDK/Collection-ArrayList/

### 2.3.4 数组扩容

首先要知道数组扩容叫什么名字---grow()

整个的扩容过程，首先创建一个新的更大的数组，一般是 1.5 倍大小，
然后将原数组复制到新数组中，最后返回新数组。

#### 2.3.4.1 无参数组扩容

```java
private Object[] grow() {
    // <1>
    return grow(size + 1);
}
```
通过调用`#grow(int minCapacity)`方法，要求扩容后至少比原有大 1 。

因为是最小扩容的要求，实际是允许比它大。


```java
private Object[] grow(int minCapacity) {
    int oldCapacity = elementData.length;
    // <2> 如果原容量大于 0 ，或者数组不是 DEFAULTCAPACITY_EMPTY_ELEMENTDATA 时，计算新的数组大小，并创建扩容
    if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
        int newCapacity = ArraysSupport.newLength(oldCapacity,
                minCapacity - oldCapacity, /* minimum growth */
                oldCapacity >> 1           /* preferred growth */);
        return elementData = Arrays.copyOf(elementData, newCapacity);
    // <3> 如果是 DEFAULTCAPACITY_EMPTY_ELEMENTDATA 数组，直接创建新的数组即可。
    } else {
        return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
    }
}
```



### 2.3.5 添加单个元素

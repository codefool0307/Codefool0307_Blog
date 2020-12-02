# 1.java基础-java特性

## 1-1：java特点

1. 简单易学；
2. <font color=red size='5'>⾯向对象（封装，继承，多态）；</font>
3. <font color=red size='5'>平台⽆关性（ Java 虚拟机实现平台⽆关性）；</font>
4. 可靠性；
5. 安全性；
6. <font color=red size='5'>⽀持多线程；</font>
7. <font color=red size='5'>⽀持⽹络编程并且很⽅便；</font>
8. 编译与解释并存；

## 1-2：JVM\JRE\JDK\JIT

java虚拟机(JVM)
    使用java编程语言的主要优势就是平台的独立性。java实现平台的独立性靠的就是虚拟机，
    它抽象化了硬件设备，开发者和他们的程序的得以操作系统。虚拟机的职责就是处理和操作系统的交流。
    java不同的接口规范对任何平台都有良好的支持，因为jvm很好的实现了每个平台的规范。
    jvm可以理解伪代码字节码，在用户和操作系统之间建立了一层枢纽。
 
java运行时环境(JRE)
    java运行时环境是JVM的一个超集。JVM对于一个平台或者操作系统是明确的，
    而JRE确实一个一般的概念，他代表了完整的运行时环境。
    我们在jre文件夹中看到的所有的jar文件和可执行文件都会变成运行时的一部分。
    事实上，运行时JRE变成了JVM。所以对于一般情况时候使用JRE，
    对于明确的操作系统来说使用JVM。当你下载了JRE的时候，也就自动下载了JVM。
 
java开发工具箱(JDK)
    java开发工具箱指的是编写一个java应用所需要的所有jar文件和可执行文件。
    事实上，JRE是JKD的一部分。如果你下载了JDK,你会看到一个名叫JRE的文件夹在里面。
    JDK中要被牢记的jar文件就是tools.jar,它包含了用于执行java文档的类还有用于类签名的jar包。
 
即时编译器(JIT)
    即时编译器是种特殊的编译器，它通过有效的把字节码变成机器码来提高JVM的效率。
    JIT这种功效很特殊，因为他把检测到的相似的字节码编译成单一运行的机器码，
    从而节省了CPU的使用。这和其他的字节码编译器不同，
    因为他是运行时(第一类执行的编译？)
    the firs of its kind to perform the compilation(从字节码到机器码）
    而不是在程序运行之前。
    正是因为这些，动态编译这个词汇才和JIT有那么紧密的关系。

## 1-3：变量的初始化顺序

基类的静态变量或全局变量。
派生类的静态变量或全局变量。
基类的成员变量。
派生类的成员变量。

## 1-4：⾯向过程性能⽐⾯向对象⾼

Java 性能差的主要原因并不是因为它是⾯向对象语⾔，
⽽是 Java 是半编译语⾔，最终的执⾏代码并不是可以直接被 CPU 执⾏的⼆进制机械码。

## 1-5：持久化对象三种状态

1.瞬时态：也叫做临时态或自由态，它一般指我们new出来的对象，
          它不存在OID,与hibernate session无关联，
          在数据库中也无记录。它使用完成后，
          会被jvm直接回收掉，
          它只是用于信息携带。
2.持久态：在hibernate session管理范围内，
         它具有持久化标识OID它的特点，
         在事务未提交前一直是持久态，
         当它发生改变时，hibernate是可以检测到的。
3.托管态：也叫做游离态或离线态，
          它是指持久态对象失去了与session的关联，
          托管态对象它存在OID,在数据库中有可能存在，
          也有可能不存在。对于托管态对象，
          它发生改变时hibernet不能检测到。

# 2.java基础-面对对象

## 2-1：面对对象三大特征(特点)

   1. 封装
   2. 继承
   3. 多态

## 2-2：面对对象的五大原则

1. 单一职责原则
   * 一个类，最好只做一件事，只有一个引起它的变化
2. 开放封闭原则
   * 对抽象编程，而不对具体编程
3. 里式替换原则
   * 子类必须能够替换其基类（这个是继承的关键）
4. 依赖倒置原则
   * 抽象不依赖于具体，具体依赖于抽象
5. 接口隔离原则
   * 使用多个小的专门的接口，而不要使用一个大的总接口

## 2-3：封装

### 2-3-1：什么是封装

封装就有两个含义：把该隐藏的隐藏起来，把该暴露的暴露出来。
   把字段（成员变量）和实现细节隐藏起来，不允许外部直接访问
   把方法暴露出来，让方法控制这些成员变量进行安全的访问和操作

### 2-3-2：封装的应用场景

如果一个属性不想被其他人直接的访问，那么这时候就可以使用封装。

## 2-4：继承

### 2-4-1：什么是继承

继承是使用已存在的类的定义作为基础建立新类的技术，
新类的定义可以增加新的数据或新的功能，
也可以用父类的功能，但不能选择性地继承父类。
通过使用继承我们能够非常方便地复用以前的代码，
能够大大的提高开发的效率

### 2-4-2：继承的应用场景

如果一个属性不想被其他人直接的访问，那么这时候就可以使用封装。
现实开发中的实体类的成员属性(成员变量)一般我们都会封装起来。

## 2-5：多态

### 2-5-1：多态的必要条件（实现方式、机制）

1. 有类继承或者接口实现
2. 子类要重写父类的方法
3. 父类的引用指向子类的对象

### 2-5-2：多态的好处

1. 应用程序不必为每一个派生类编写功能调用，只需要对抽象基类进行处理即可。
   大大提高程序的可复用性。 
2. 派生类的功能可以被基类的方法或引用变量所调用，可以提高可扩充性和可维护性。 

### 2-5-3：多态的例子

```java
public class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    } 

}

public class B extends A{
    public String show(B obj){
        return ("B and B");
    }
    
    public String show(A obj){
        return ("B and A");
    } 
}

public class C extends B{

}

public class D extends B{

}

public class Test {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        
        System.out.println("1--" + a1.show(b));
        System.out.println("2--" + a1.show(c));
        System.out.println("3--" + a1.show(d));
        System.out.println("4--" + a2.show(b));
        System.out.println("5--" + a2.show(c));
        System.out.println("6--" + a2.show(d));
        System.out.println("7--" + b.show(b));
        System.out.println("8--" + b.show(c));
        System.out.println("9--" + b.show(d));
    }
}
```
## 2-6：抽象

### 2-6-1：Java 抽象类可以有构造函数吗？作用是什么

可以有， 抽象类可以声明并定义构造函数。
它可以用来初始化抽象类内部声明的通用变量，并被各种实现使用。

### 2-6-2：Java 抽象类可以实现接口吗？ 它们需要实现所有的方法吗

可以， 抽象类可以通过使用关键字implements来实现接口。

### 2-6-3：Java 抽象类可以是 final 的吗

不可以， Java 抽象类不能是 final 的。
将它们声明为final的将会阻止它们被继承， 而这正是使用抽象类唯一的方法。

### 2-6-4：Java 抽象类可以有 static 方法吗

可以， 抽象类可以声明并定义 static 方法， 没什么阻止这样做。

### 2-6-5：可以创建抽象类的实例吗（new 类）

不可以，
1. 对象实例化的时候，关键字new向JVM申请内存，这个类的成员会被保存到内存中
   而抽象类，没有具体的成员，没办法准确分配内存。
2. 可能也是设计层面上的解释，不希望实例化

### 2-6-6：抽象类必须有抽象方法吗

不需要， 抽象类有抽象方法不是强制性的。但是一般在抽象类中设置抽象方法

### 2-6-7：何时选用抽象类而不是接口

1. 当关心升级时， 因为不可能在一个发布的接口中添加一个新方法， 用抽象类会更好。
2. 如果你的接口中有很多方法， 你对它们的实现感到很头疼， 考虑提供一个抽象类作为默认实现。

### 2-6-8：Java中的抽象方法是什么

1. 抽象方法是一个没有方法体的方法。 你仅需要声明一个方法，
2. 不需要定义它并使用关键字abstract 声明。

### 2-6-9：Java抽象类中可以包含main方法吗

是的， 抽象类可以包含 main 方法，
它只是一个静态方法， 你可以使用 main 方法执行抽象类， 但不可以创建任何实例。

## 2-7：面对对象区别

### 2-7-1：接⼝和抽象类的区别

1. 所有⽅法在接⼝中不能有实现，⽽抽象类可以有⾮抽象的⽅法。
2. 接⼝中除了final变量，不能有其他变量，⽽抽象类中则不⼀定。
3. ⼀个类可以实现多个接⼝，但只能实现⼀个抽象类。
4. 从设计层⾯来说，抽象类作为很多子类的父类，是一种模板式设计，接口是一种行为规范

### 2-7-2：继承和接口区别

1. java类可以一次继承多个接口，用implements 接口1，接口2
2. 如果是接口继承接口的话也可以用extends，接口是多继承的，java类才是单继承
3. 接口继承接口可以不实现父接口中的方法，可以声明自己的新方法，
4. 类实现接口时，一定要实现接口中声明的方法，
   如果接口中没有定义抽象方法则不需要，
   但是如果发生某个类实现了一个接口A,如果B是A的父接口，
   且B中有抽象方法，则该类必须实现A和B中的所有抽象方法
5. 抽象方法只能定义在抽象类中，抽象类实现接口，可以不实现接口中的抽象方法
   继承接口是说的接口来继承接口，是接口与接口间的

### 2-7-3：为什么要设计接口、抽象类还有实现类

比如说我要实现A类的多样式

接口：定义了a-1，a-2几个接口，让所有的程序都遵守这个。
抽象类：我默认实现了一个样式。如果其他扩展的样式不想做这部分的工作就不用实现了。
实现类：我只实现我需要关心的方法，如a-1就不用再实现了，只需要实现a-2就可以了。

## 2-8：面对对象应用场景

### 2-8-1：接口和抽象类的应用场景

1. 抽象类的使用场景
   既想约束子类具有共同的行为（但不再乎其如何实现），又想拥有缺省的方法，又能拥有实例变量
   如：模板方法设计模式，模板方法使得子类可以在不改变算法结构的情况下，重新定义算法中某些步骤的具体实现。
2. 接口的应用场景
  1. 约束多个实现类具有统一的行为，但是不在乎每个实现类如何具体实现
  2. 作为能够实现特定功能的标识存在，也可以是什么接口方法都没有的纯粹标识。
  3. 实现类需要具备很多不同的功能，但各个功能之间可能没有任何联系。
  4. 使用接口的引用调用具体实现类中实现的方法（多态）

# 3.java基础-构造器

## 3-1：⼀个类的构造⽅法的作⽤是什么

主要作⽤是完成对类对象的初始化⼯作。
可以执⾏。因为⼀个类即使没有声明构造⽅法也会有默认的不带参数的构造⽅法。

## 3-2：构造⽅法有哪些特性？

1. 名字与类名相同。
2. 没有返回值，但不能⽤ void 声明构造函数。
3. ⽣成类的对象时⾃动执⾏，⽆需调⽤。

## 3-3：构造方法可不可以被重写和重载

构造方法可以被重载。
构造方法不可以被重写，因为重写发生在父类和子类之间，要求方法名称相同，
而构造方法的名称是和类名相同的，而子类类名不会和父类类名相同，所以不可以被重写。

## 3-4：构造函数能用private修饰吗

可以的，用private修饰的构造方法不允许被new了
因为编译会出现访问private私有的成员

# 4.java基础-重载与重写 

## 4-1：重载与重写

1. 重载——函数或者方法有同样的名称，但是参数列表不相同的情形
2. 重写——Java的子类与父类中有两个名称、参数列表都相同的方法的情况。由于他们具有相同的方法签名，所以
   子类中的新方法将覆盖父类中原有的方法

## 4-2：Java 中是否可以覆盖(override)一个 private 或者是 static 的方法？

1. Java中static方法不能被覆盖， 因为方法覆盖是基于运行时动态绑定的， 而static方法是编译时静态
   绑定的。 
2. Java中也不可以覆盖private的方法， 因为private修饰的变量和方法只能在当前类中使用，如果是其他
   的类继承当前类是不能访问到 private 变量或方法的， 当然也不能覆盖。

# 5.java基础-值传递与引用传递

## 5-1：值传递与引用传递的概念

1. 值传递是对基本型变量而言的,传递的是该变量的一个副本,改变副本的值不影响原变量的值

2. 引用传递一般是对于引用类型变量而言的,传递的是该对象地址的一个副本，是一个地址。
   * 如果说改变了原地址的值（注意是  值  ），那么会影响
   * 如果改变了副本地址，如new 一个原地址不会改变  

一般认为,java传递都是值传递.

## 5-2：值传递与引用传递的实例举证

1. 基本类型
那我先说一下基本类型作为参数传递的例子：
```java
public class Test1 {
       public static void main(String[] args) {
        int n = 3;
        System.out.println("Before change, n = " + n);
        changeData(n);
        System.out.println("After changeData(n), n = " + n);
    }
public static void changeData(int n) {
        n = 10;
    }}
```

基本类型作为参数传递时，是传递值的拷贝，
无论你怎么改变这个拷贝，原值是不会改变的，输出的结果证明了这一点：

```java
Before change, n = 3
After changeData(n), n = 3
```

2. 引用类型

```java
   public class TransferTest2 {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);
        change(person);
        System.out.println(person);
    }
//
    public static void change(Person p) {
        p = new Person();
    }
}

/**
 * Person类
 */
class Person {

}
```
两次打印结果一致。

在调用change()方法后，person变量并没发生改变。

01.当程序执行到第3行 Person person = new Person()时，
   程序在堆内存（heap）中开辟了一块内存空间用来存储Person类实例对象，
   同时在栈内存（stack）中开辟了一个存储单元来存储该实例对象的引用，即上图中person指向的存储单元。

02.当程序执行到第5行 change(person)时，person作为参数（实参）传递给饿了change()方法。
   这里是person将自己的存储单元的内容传递给了change()方法的p变量。
   此后在change()方法中对p变量的一切操作都是针对于p变量所指向的存储单元，与perosn所指向的存储单元就没有关系了。

# 6.java基础-深拷贝与浅拷贝

## 6-1：深拷贝与浅拷贝

1. 浅拷⻉：对基本数据类型进⾏值传递，对引⽤数据类型进⾏引⽤传递的拷⻉。
2. 深拷⻉：对基本数据类型进⾏值传递，对引⽤数据类型，创建⼀个新的对象，并复制其成员变量。

## 6-2：浅拷贝方法

1. 通过拷贝<font color=red>构造方法</font>实现浅拷贝：
   * 拷贝构造方法指的是该类的构造方法参数为该类的对象。
2. 通过重写clone()方法进行浅拷贝
   * 使用clone方法的类必须实现Cloneable接口

## 6-3：深拷贝方法

1. 序列化
   * 序列化为数据流，在反序列化回来，就可以得到这个对象
2. 利用Kryo框架，这是一个快速高效的Java序列化框架
3. 利用json转化方式
   * 对象转化为JSON，再序列化为对象
4. 人工构建对象

## 6-4：深拷贝与浅拷贝的区别

深拷贝和浅拷贝最根本的区别在于是否真正获取一个对象的复制实体，而不是引用。
比如说我有两个数值，A和B，B复制了A，修改A的时候，看B是否发生变化：
如果B跟着也变了，说明是浅拷贝，修改堆内存中的同一个值
如果B没有改变，说明是深拷贝，修改堆内存中的不同的值、
浅拷贝（shallowCopy）只是增加了一个指针指向已存在的内存地址，
深拷贝（deepCopy）是增加了一个指针并且申请了一个新的内存，
使这个增加的指针指向这个新的内存，
使用深拷贝的情况下，
释放内存的时候不会因为出现浅拷贝时释放同一个内存的错误。

## 6-5：赋值和浅拷贝的区别

当我们把一个对象赋值给一个新的变量时，
赋的其实是该对象的在栈中的地址，
而不是堆中的数据。
两个对象指向的是同一个存储空间，
无论哪个对象发生改变，
其实都是改变的存储空间的内容，
因此，两个对象是联动的。
浅拷贝是按位拷贝对象，它会创建一个新对象，
这个对象有着原始对象属性值的一份精确拷贝。
如果属性是基本类型，拷贝的就是基本类型的值；
如果属性是内存地址（引用类型），拷贝的就是内存地址 ，
因此如果其中一个对象改变了这个地址，
就会影响到另一个对象。
即默认拷贝构造函数只是对对象进行浅拷贝复制(逐个成员依次拷贝)，
即只复制对象空间而不复制资源。

# 7.java基础-equals与hashcode

## 7-1： == 与 equals

1. == : 它的作⽤是判断两个对象的地址是不是相等。
   基本数据类型⽐较的是值，引⽤数据类型⽐较的是内存地址

2. equals() : 它的作⽤也是判断两个对象是否相等。但它⼀般有两种使⽤情况：

   * 情况 1：类没有覆盖equals()⽅法。
            则通过equals()⽐较该类的两个对象时，
            等价于通过“==”⽐ 较这两个对象。
   * 情况 2：类覆盖了equals()⽅法。⼀般，
             我们都覆盖 equals() ⽅法来⽐较两个对象的内容是否相等；
             若它们的内容相等，则返回true。

## 7-2：为什么要重写hashcode与equals

如果不重写equals方法，则不能比较自定义类，
在使用hashmap的时候就会出现问题，同理适用于hashcode，
不重写就无法得出原hash值，也自然无法比较依靠原hashcode找到该数据

### 7-2-1：重写equals不重写hashcode会出现什么问题

在集合中将会存储两个值相同的对象,从而导致混淆。

如果两个对象相等，那么它们的hashCode()值一定相同。
如果两个对象hashCode()相等，它们并不一定相等。

### 7-2-2：为什么两个对象有相同的hashcode值，它们也不一定是相等的？

hashCode方法实际上返回的就是对象存储的物理地址，也就是说 hashcode 只是用来缩小查找成本。

## 7-3：阿里关于hashcode和equals的处理规则

1）只要重写equals，就必须重写hashCode。
2) 因为Set存储的是不重复的对象,依据hashCode和equals进行判断，
   所以set存储的对象必须重写这两个方法。
3）如果自定义对象做为Map的键，那么必须重写hashCode和equals.
   作为key来使用。

## 7-4：hashcode和equals源码写一下

equals()方法在object类中定义如下： 

```java
public boolean equals(Object obj) {  
    return (this == obj);  //用来比较其他对象是否等于此对象
} 
```


比如说在String类中重写

```java
public boolean equals(Object anObject) {
		//使用==操作符检查“参数是否为这个对象的引用”(比较对象地址)
        if (this == anObject) {
            return true;
        }
        //用instanceof检查“参数是否为正确的类型(是否为String的实例)”
        if (anObject instanceof String) {
            String anotherString = (String)anObject;
            int n = value.length;
           	//判断两个字符串的长度是否相同
            if (n == anotherString.value.length) {
                char v1[] = value;
                char v2[] = anotherString.value;
                int i = 0;
                //一个字符一个字符的进行比较
                while (n-- != 0) {
                    if (v1[i] != v2[i])
                        return false;
                    i++;
                }
                return true;
            }
        }
        return false;
    }
```

```java
public int hashCode() {
      int h = hash;
      if (h == 0 && value.length > 0) {
          char val[] = value;
  
          for (int i = 0; i < value.length; i++) {
              h = 31 * h + val[i];
          }
          hash = h;
     }
     return h;
 }
```

# 8.java基础-i++与++i的问题

## 8-1：i++和++i的区别，及其线程安全问题

i++：先赋值再自加。
++i：先自加再赋值。
1. 如果i是局部变量（在方法里定义的），那么是线程安全的。
   因为局部变量是线程私有的，别的线程访问不到
2. 如果i是全局变量（类的成员变量），那么是线程不安全的。
   因为如果是全局变量的话，同一进程中的不同线程都有可能访问到。
如果有大量线程同时执行i++操作，i变量的副本拷贝到每个线程的线程栈，当同时有两个线程栈以上的线程读取
线程变量，假如此时是1的话，那么同时执行i++操作，再写入到全局变量，最后两个线程执行完，i会等于3而不
会是2，所以，出现不安全性。

  如果使用voliate无法保证原子性

## 8-2：i++和++i是否为原子操作

不是原子操作
比如说i++
分为三个阶段：

1. 内存到寄存器
2. 寄存器自增
3. 回内存
这三个阶段中间都可以被中断分离开.
++i首先要看编译器是怎么编译的，
如果编译成了“inc dword ptr[i]”，这是原子操作

## 8-3：如何实现i++和++i的原子性呢？

总线锁和缓存锁两个机制来保证原子性，可以通过处理器提供的很多LOCK前缀的指令来实现。
1. 总线锁：多个处理器可能会同时从各自的缓存中读取变量，并分别进行操作，
   在分别写入内存中，想要保证读改写共享变量的操作是原子的，就要使用总线锁来解决，
   即使用处理器提供的一个LOCK#信号，当有一个处理器在总线上输出此信号时，
   其他处理器的请求将被阻塞，此时该处理器可以独占共享内存。
2. 缓存锁：频繁使用的内存将会缓存在处理器的高速缓存里，
   内存区域如果被缓存到处理器的缓存行里，并且在Lock操作期间被锁定，
   那么当他执行锁操作回写到内存时，其他处理器会检查各自缓存行内的内存地址，
   如果发现自己的缓存行对应的地址被修改了，就会将缓存行置于无效状态，
   下次访问时，重新从内存中读取数据到缓存行，并允许它的缓存一致性机制
   （通常采用嗅探技术来实现，即缓存不仅仅是在内存传输的时候才和总线打交道，
   而是时刻不停的在窥探总线上发生的数据交换，并跟踪其他缓存在做什么，
   所以当一个缓存代表它所属的处理器去读写内存时，其他处理器都会得到通知，
   从而保证各个缓存保持同步）来保证操作的原子性。此时，处理器不会在总线上输出LOCK#信号。
总线锁会把CPU和内存之间的通信锁住，导致其他处理器不能操作其他内存地址的数据，
所以总线锁的开销比较大，在某些场合下，会使用缓存锁来代替总线锁进行优化。
但是，当操作的数据不能被缓存在处理器内部或要操作的数据会跨多个缓存行时，
处理器会调用总线锁。对于有些处理器不支持缓存锁，
就算锁定的内存区域在处理器的缓存行，这时也会调用总线锁。

# 9.java基础-数据类型

## 9-1：八种数据类型是什么？

1. 字符型   char
2. 布尔型  boolean
3. 数值型
   1. 整型：byte、short、int、long
   2. 浮点型：float、double

<font color=red>特别注意</font>：String不是基本数据类型，是引用类型。

### 9-1-1：java为什么除了基本数据类型还要有引用数据类型

引用类型在堆里，基本类型在栈里。
栈空间小且连续，往往会被放在缓存。
引用类型cache miss（缓存未命中）率高且要多一次解引用。
对象还要再多储存一个对象头，
对基本数据类型来说空间浪费率太高

### 9-1-2：String为什么不是基本数据类型

1. 基本类型仅表示简单的数据类型，
   引用类型可以表示复杂的数据类型，
   还可以操作这种数据类型的行为
2. java虚拟机处理基础类型与引用类型的方式是不一样的，
   对于基本类型，java虚拟机会为其分配数据类型实际占用的内存空间，
   而对于引用类型变量，
   他仅仅是一个指向堆区中某个实例的指针。

### 9-1-3：引用类型有哪几种

类或者接口，泛型类型，数组类型

## 9-2：数据类型的范围

`数值型`
byte：-2^7 ~ 2^7-1，
short：-2^15 ~ 2^15-1
int：-2^31 ~ 2^31-1
long：-2^63 ~ 2^63-1，
`浮点型：`
float：4字节。
double：8字节。
`字符型：`
char：2字节。

### 9-2-1：为什么byte类型是-128~+127

使用原码或反码表示的范围为[-127, +127],
-0并没有反码补码表示，
而使用补码表示的范围为[-128, 127]

## 9-3：自动拆装箱

### 9-3-1：为什么要有自动拆装箱

比如说集合类中，要求元素必须是Object类，
而int、double等基本数据类型无法使用，
那么我们就把基本数据类型包装起来，
使其具有对象的特征，并让他有了属性和方法

### 9-3-2：自动拆装箱的原理

自动装箱：调用valueOf（）方法将原始类型值转换成对象
自动拆箱：调用intValue()方法，其他的（xxxValue())这类的方法将对象转换成原始类型值。

### 9-3-3：自动拆装箱使用场景

1. 场景一、将基本数据类型放入集合类
2. 场景二、包装类型和基本类型的大小比较
3. 场景三、包装类型的运算 
4. 场景四、三目运算符的使用如果i是包装类，j是null就会NPE报错
5. 场景五、函数参数与返回值

### 9-3-4：自动拆装箱带来的问题

1. 包装对象的数值比较，不能简单的使用==，虽然-128到127之间的数字可以，
   但是这个范围之外还是需要使用equals比较~~。
2. 如果包装类对象为null，
   那么自动拆箱时就有可能抛出NPE（NullPointException）。
3. 如果一个for循环中有大量拆装箱操作
   会浪费很多资源。

## 9-4：Integer缓存机制

Integer对小数据（-128~=127）具有缓存机制，
当jvm在初始化的时候，如果数据是小数据，
那么就会把数据存储在本地内存当中，
当下次使用的时候该数据的时候，
那么就可以直接从本地内存进行调用，就不需要再次创建对象来解决
1. 其中会有一个valueof函数，用来判断内存中是否有着这个数值，
   * 如果说有，那么直接从内存进行读取
   * 如果说没有，那么就需要创建一个对象
2. 在jvm初始化的时候，低值是不能改变的，
   但是高值是可以改变的，可以通过jvm进行参数设置，
   但是只有Integer源码可以对高值、低值进行改变。

## 9-4-1：int与Integer区别

1. Integer是int的包装类 ，int则是java的一种基本数据类型
2. Integer变量必须实例化后才能使用，而int变量不需要
3. Integer的默认值是null, int的默认值是0

注：

1. 非new生成的Integer变量和new Integer生成的变量比较时， 
   结果为false。
   因为非new生成的Integer变量指向的是java常量池中的对象，
   而new Integer0生成的变量指向堆中新建的对象，两者在内存中的地址不同
```java
Integer i = new Integer(100);
Integer j = 100;
Syatem.out.print(i == J); //false
```
2. Integer变量和int变量比较时，只要两个变量的值是相等的，则结果为true

## 9-5：String转出int型， 判断能不能转？ 如何转？

可以转， 得处理异常 Integer.parseInt(s) 主要为 NumberFormatException： 

## 9-6：short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1+=1;有什么错?

对于 short s1 = 1; s1 = s1 + 1;
由于 s1+1运算时会自动提升表达式的类型，
所以结果是 int型，
再赋值给 short 类型 s1时， 
编译器将报告需要强制转换类型的错误。
对于 short s1 = 1; s1 += 1;
由于 +=是 java 语言规定的运算符， 
java 编译器会对它进行特殊处理，因此可以正确编译

# 10.java基础-关键字

## 10-1：关键字

private 　　    在当前类中可访问
default         在当前包内和访问
protected       在当前类和它派生的类中可访问
public          公众的访问权限，谁都能访问


## 10-1: 通过反射访问private成员和方法，既然能访问为什么要private？

1. private并不是解决安全问题的，如果想让解决代码的安全问题，请用别的办法。
2. private的意义是OOP（面向对象编程）的封装概念。

## 10-2：static关键字

### 10-2-1：static使用场景

1. 修饰成员变量和成员方法
2. 静态代码块
3. 静态内部类（static修饰类的话只能修饰内部类）  
4. 静态导包

### 10-2-2：静态⽅法和实例⽅法有何不同

1. 调⽤静态⽅法可以⽆需创建对象。而实例方法需要用类名.方法名访问
2. 静态⽅法在访问本类的成员时，只允许访问静态成员，⽽不允许访问实例成员变量和实例⽅法；实例⽅法则⽆此限制。

### 10-2-3：静态变量和实例变量的区别？

1. 语法区别： 静态变量前要加 static 关键字，而实例变量前则不加。
2. 程序运行的区别：实例变量必须创建对象后才可以通过这个对象来使用，静态变量则可以直接使用类名来引用。

### 10-2-4：static的应用

### 10-2-5：static方法可以访问非static方法或变量吗?

不可以，原因是因为静态方法在类装载的时候就分配了内存块，
而非静态的方法和变量在new这个类的对象的时候才分配内存块，
他们内存分配的时间不一样 静态区域访问非静态区域是没有任何意义的

## 10-3：final关键字

### 10-3-1：final关键字使用场景

1. final修饰的类不能被继承
2. final修饰的方法不能被重写；
3. final修饰的变量是常量，如果是基本数据类型的变量，
   则其数值一旦在初始化之后便不能更改；
   如果是引用类型的变量，
   则在对其初始化之后便不能让其指向另一个对象。
4. 想通过使用final提升程序性能
   因为编译器能从final中获取额外的信息，
   因此可以对类或者方法调用进行额外的优化处理。
   但这中优化对程序性能的提升极其有限。

### 10-3-2：final, finally, finalize 的区别。

1. final 用于声明属性，方法和类，分别表示属性不可变，方法不可覆盖，类不可继承。
2. finally 是异常处理语句结构的一部分，表示总是执行。
3. finalize 是 Object 类的一个方法，
   在垃圾收集器执行的时候会调用被回收对象的此方法，
   可以覆盖此方法提供垃圾收集时的其他资源回收，
   例如关闭文件等。

### 10-3-3：使用final关键字修饰一个变量时，是引用不能变，还是引用的对象不能变？

使用 final 关键字修饰一个变量时，
是指引用变量不能变，
引用变量所指向的对象中的内容还是可以改变的。

## 10-4：this关键字和super关键字

1. this程序
```java
class Manager {
    Employees[] employees;
     
    void manageEmployees() {
        int totalEmp = this.employees.length;
        System.out.println("Total employees: " + totalEmp);
        this.report();
    }
     
    void report() { }
}
```

主要是访问本类（自己）的成员变量和方法（可写可不写）
super主要是通过子类去访问父类的成员变量和方法，必须写
2. super程序

```java
public class Super {
    protected int number;
     
    protected showNumber() {
        System.out.println("number = " + number);
    }
}
 
public class Sub extends Super {
    void bar() {
        super.number = 10;
        super.showNumber();
    }
}
```

1. 在构造器中使用 super（） 调用父类中的其他构造方法时，该语句必须处于构造器的首行，否则编译器会报错。
2. this 调用本类中的其他构造方法时，也要放在首行。
3. this、super不能用在static方法中。

## 10-5：transient关键字

阻⽌实例中那些⽤此关键字修饰的的变量序列化；
当对象被反序列化时，被 transient 修饰的变量值不会被持久化和恢复。 
transient 只能修饰变量，不能修饰类和⽅法。

# 11.java基础-各种集合家族

## 11-1：Collection集合框架

集合框架有Map和Collection两大类
1. Collection
   1. List
        * Arraylist： Object数组
        * Vector： Object数组
        * LinkedList： 双向链表(JDK1.6之前为循环链表， JDK1.7取消了循环)
    2. Set
        * HashSet（⽆序，唯⼀） : 基于 HashMap 实现的，
                                  底层采⽤ HashMap 来保存元素
        * LinkedHashSet： LinkedHashSet 继承于 HashSet，
                         并且其内部是通过 LinkedHashMap 来实现的。
                         有点类似于我们之前说的LinkedHashMap 
                         其内部是基于 HashMap 实现⼀样，不过还是有⼀点点区别的
        * TreeSet（有序，唯⼀）： 红⿊树(⾃平衡的排序⼆叉树)
    3. Queue
2. Map
    1. HashMap： JDK1.8之前HashMap由数组+链表组成的，
                 数组是HashMap的主体，
                 链表则是主要为了解决哈希冲突⽽存在的（“拉链法”解决冲突）。
                  JDK1.8以后在解决哈希冲突时有了较⼤的变化，
                  当链表⻓度⼤于阈值（默认为8）时，
                  将链表转化为红⿊树，以减少搜索时间
    2. LinkedHashMap： LinkedHashMap 继承⾃ HashMap，
                      所以它的底层仍然是基于拉链式散列结构
                      即由数组和链表或红⿊树组成。
                      LinkedHashMap 在上⾯结构的基础上，
                      增加了⼀条双向链表，
                      使得上⾯的结构可以保持键值对的插⼊顺序。
                      同时通过对链表进⾏相应的操作，
                      实现了访问顺序相关逻辑。
    3. Hashtable： 数组+链表组成的，数组是 HashMap 的主体，
                   链表则是主要为了解决哈希冲突⽽存在的
    4. TreeMap： 红⿊树（⾃平衡的排序⼆叉树）

## 11-2：并发集合框架爱

1. Queue
  * ConcurrentLinkedQueue
  * BlockingQueue
    * ArrayBlockingQueue：基于数组、先进先出、线程安全，
                          可实现指定时间的阻塞读写，并且容量可以限制
    * LinkedBlockingQueue：基于链表实现，读写各用一把锁，
                           在高并发读写操作都多的情况下，
                           性能优于ArrayBlockingQueue
  * Deque
2. CopyOnWriteArrayList：线程安全且在读操作时无锁的ArrayList
3. CopyOnWriteArraySet：基于CopyOnWriteArrayList，不添加重复元素
4. ConcurrentMap：线程安全的HashMap的实现
   * ConcurrentHashMap
   * ConcurrentNavigableMap

### 11-2-1：并发集合出现的原因

比如说若当前线程在扩容并发的时候，
此时获得ertry节点，但是被线程中断无法继续执行，
此时线程二进入transfer 函数，并把函数顺利执行，
此时新表中的某个位置有了节点，之后线程一获得执行权继续执行，
因为并发 transfer，所以两者都是扩容的同一个链表，
当线程一执行到new table[i]的时候，
由于线程二之前数据迁移的原困导致此时new table[i]上就有ertry存在，
所以线程一执行的时候，会将next节点，设置为自己，
导致自己互相使用next引用对方，因此产生链表，导致死循环。
但是在JDK 8用head 和 tail 来保证链表的顺序和之前一样。

# 12.Hashmap

## 12-1：hashmap的数据结构

1. JDK1.7用的是头插法，而JDK1.8及之后使用的都是尾插法，
   JDK1.7采用头插法虽然能够提高插入的效率，
   但是为了安全,防止环化，因为resize的赋值方式，也就是使用了单链表的头插入方式，
   同一位置上新元素总会被放在链表的头部位置，
   在旧数组中同一条Entry链上的元素，通过重新计算索引位置后，
   有可能被放到了新数组的不同位置上。所以使用头插会改变链表的上的顺序，
   但是如果使用尾插，在扩容时会保持链表元素原本的顺序，
   保持之前节点的引用关系，就不会出现逆序且链表死循环的问题
2. 扩容存储位置的计算方式也不一样：
   1. 在JDK1.7的时候是直接用hash值和需要扩容的二进制数进行&
   2. 在JDK1.8的时候是扩容前的原始位置+扩容的大小值=JDK1.8的计算方式，
      但是这种方式就相当于只需要判断Hash值的新增参与运算的
      位是0还是1就直接迅速计算出了扩容后的存储方式。
3. （插入元素）JDK1.7的时候使用的是数组+单链表的数据结构。
    HashMap通过key的hashCode经过扰动函数处理过后得到hash
    值，然后通过(n-1)&hash判断当前元素存放的位置，
    如果当前位置存在元素的话，就判断该元素与要存入的元素的hash值以及
    key是否相同，如果相同的话，直接覆盖，
    不相同就通过拉链法解决冲突。
    但是在JDK1.8及之后时，使用的是数组+链表+红黑树的
    数据结构,当链表的深度达到8的时候，也就是默认阈值，
    就会自动扩容把链表转成红黑树的数据结构，以减少搜索时间。

### 12-2-1：扩容死循环问题

比如说若当前线程在扩容并发的时候，此时获得ertry节点，
但是被线程中断无法继续执行，此时线程二进入transfer 函数，并把函数顺利执行，
此时新表中的某个位置有了节点，之后线程一获得执行权继续执行，
因为并发 transfer，所以两者都是扩容的同一个链表，
当线程一执行到new table[i]的时候，
由于线程二之前数据迁移的原困导致此时new table[i]上就有ertry存在，
所以线程一执行的时候，会将next节点，设置为自己，
导致自己互相使用next引用对方，因此产生链表，导致死循环。
但是在JDK 8用head 和 tail 来保证链表的顺序和之前一样。

### 12-2-2：链表插入法

#### 12-2-2-1：头插法

头插法建表主要思想就是，从一个空表开始，重复读入数据，生成新结点，
将读入数据存放到新结点的数据域中，
然后将新结点插入到当前链表的表头结点之后，
直至读入结束标志为止。
比如说，
创建第一个结点
执行第一次循环时，第一次从堆中开辟一块内存空间给node，
此时需要做的是将第一个结点与 head 连接起来。
因为单链表的最后一个结点指向的是 NULL。
因此插入第一个结点时，我们需要将头指针指向的 next 赋给新创建的结点的 next ， 
这样第一个插入的结点的 next 指向的就是 NULL。 
接着，我们将数据域，也就是 node 的地址赋给 head->next， 
这时 head->next 指向的就是新创建的 node的地址。
而 node 指向的就是 NULL。
接着我们创建第二个结点
因为使用的头插法，因此新开辟的内存空间需要插入头指针所指向的下一个地址，
也就是新开辟的 node 需要插入 上一个 node 和 head 之间。 
第一个结点创建之后，head->next 的地址是 第一个 node 的地址。 
而我们申请到新的一块存储区域后，需要将 node->next 指向 上一个结点的首地址， 
而新node 的地址则赋给 head->next。 因此也就是 node->next = head->next 。
这样便将第一个结点的地址赋给了新创建地址的 next 所指向的地址。后两个结点就连接起来。
接下来再将头结点的 next 所指向的地址赋为 新创建 node 的地址。 head->next = node ，
这样就将头结点与新创建的结点连接了起来。 此时最后一个结点，
也就是第一次创建的结点的数据域为0，指针域为 NULL。

#### 12-2-2-2：尾插法

尾插法建表将新结点查到当前单链表的表尾中，增加一个尾指针，
让他指向当前单链表的表尾
比如说
尾插法创建第一个结点
刚开始为头结点开辟内存空间，因为此时除过头结点没有新的结点的建立，
接着将头结点的指针域 head->next 的地址赋为 NULL。
因此此时，整个链表只有一个头结点有效，
因此 head此时既是头结点，又是尾结点。
因此将头结点的地址赋给尾结点 end 因此：end = head。 
此时end 就是 head, head 就是 end。 
end->next 也自然指向的是 NULL。
尾插法创建第二个结点
创建完第一个结点之后，我们入手创建第二个结点。 
第一个结点，end 和 head 共用一块内存空间。
现在从堆中心开辟出一块内存给 node，将 node 的数据域赋值后，
此时 end 中存储的地址是 head 的地址。
此时，end->next 代表的是头结点的指针域，
因此 end->next = node 代表的就是将上一个，
也就是新开辟的 node 的地址赋给 head 的下一个结点地址。
此时，end->next 的地址是新创建的 node 的地址，
而此时 end 的地址还是 head 的地址。 因此 end = node ,
这条作用就是将新建的结点 node 的地址赋给尾结点 end。 
此时 end 的地址不再是头结点，而是新建的结点 node。
也就是相当于不断开创新的结点，然后不断将新的结点的地址当做尾结点。
尾结点不断后移，而新创的结点时按照创建的先后顺序而连接的。先来新到。
最后，当结点创建完毕，最后不会有新的结点来替换 end ，
因此最后需要加上一条 end->next = NULL。将尾指针的指向为 NULL。

### 12-2-3：红黑树的引入

#### 12-2-3-1：HashMap为什么要树化?

安全问题。因为在元素放置过程中，如果一个对象哈希冲突，
都被放置到同一个桶中，则会形成一个链表。而链表查询时线性的，
会严重影响存取的性能。

#### 12-2-3-2：hashmap树化门槛及作用

* 链表长度大于8
* 数组长度大于64
作用：
这个本质上，是一个安全问题。因为在元素放置过程中，
如果一个对象哈希冲突，都被放置到同一个桶中，
则会形成一个链表。而链表查询是线性的，
会严重影响存取的性能。

#### 12-2-3-3：为什么JDK8时候引入了红黑树

因为当数组中每个元素，都是一个Entry，每一个Entry是一个单链表。
当链表长度过长的时候，查询链表中的一个元素就比较耗时，这时就引入了红黑树。
首先红黑树是一棵二叉树，红黑树有一条特性就是
从一个节点到该节点的子孙节点的所有路径上包含相同数目的黑节点。
这一特性，确保没有一条路径会比其他路径长出两倍，
因而，红黑树是接近平衡的二叉树。这就使得红黑树的时间复杂度大大降低。
所以，用红黑树替代单链表会降低集合中元素的访问速度。

#### 12-2-3-4：为什么不把链表全部换为红黑树

1. 链表的结构比红黑树简单，构造红黑树要比构造链表复杂，
   所以在链表的节点不多的情况下，从整体的性能看来，
   如果把链表全部换为红黑树，效率反而更低。
2. HashMap频繁的resize（扩容），
   扩容的时候需要重新计算节点的索引位置，
   也就是会将红黑树进行拆分和重组，
   其实这是很复杂的，
   这里涉及到红黑树的着色和旋转，
   所以为链表树化设置一个阀值是非常有必要的。

#### 12-2-3-5：为什么是使用红黑树而不是AVL树？

在CurrentHashMap中是加锁了的，实际上是读写锁，
如果写冲突就会等待，如果插入时间过长必然等待时间更长。
同时因为AVL树需要更高的旋转次数才能在修改时正确地重新平衡数据结构，
所以红黑树相对AVL树他的插入更快！

#### 12-2-3-5：为什么不用二叉查找树代替，而选择红黑树

红黑树是为了解决二叉查找树的缺陷，
二叉查找树在特殊情况下会变成一条线性结构
这就跟原来使用链表结构一样了，造成很深的问题，
遍历查找会非常慢。
而红黑树在插入新数据后可能需要
通过左旋，右旋、变色这些操作来保持平衡，
引入红黑树就是为了查找数据快，解决链表查询深度的问题

### 12-3-4：HashMap为什么可以插入空值?

HashMap在put的时候会调用hash()方法来计算key的hashcode值，
可以从hash算法中看出当key==null时返回的值为0。
因此key为null时，
hash算法返回值为0，不会调用key的hashcode方法。

### 12-4：JDK8中hashmap的改变

1. 在java 1.8中，如果链表的长度超过了8，
   那么链表将转换为红黑树。但是
   桶的数量必须大于64，小于64的时候只会扩容
2. 发生hash碰撞时，
   java 1.7 会在链表的头部插入，
   而java 1.8会在链表的尾部插入
3. 在java 1.8中，Entry被Node替代。

## 12-2：put操作

HashMap通过key的hashCode经过扰动函数处理过后得到hash值，
然后通过计算判断当前元素存放的位置
1. 如果数组的这个位置是空的，把key放进去，put操作就完成了。
2. 如果数组位置不为空，就判断该元素与要存入的元素的hash值以及key是否相同，
   如果相同的话，直接覆盖
3. 若果不相等，这个元素必然是个链表。
   遍历链表逐一比对value，
   如果value在链表中不存在，就把新建节点，
   将value放进去，put操作完成。
4. 如果链表中value存在，
   则替换原节点的value，put操作完成。
5. 如果链表节点数已经达到8个，
   首先判断当前hashMap的长度，
   如果不足64，只进行resize，
   扩容table，如果达到64就将冲突的链表为红黑树。

### 12-2-1：手写put方法

```java
public V put(K key, V value) {
        if (key == null)
            return putForNullKey(value);
        int hash = hash(key.hashCode());
        int i = indexFor(hash, table.length);
        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }
  
        modCount++;
        addEntry(hash, key, value, i);
        return null;
    }
```

## 12-3：HashMap的get操作

1. 查找位置。
2. 如果访问的节点是bucket里的第一个节点，则直接命中；
3. 如果有冲突，则通过key.equals(k)去树或链表中查找对应的entry。

### 12-3-1：手写get方法

```java

 public V get(Object key) {
        //定义一个Node对象来接收
        Node<K,V> e;
        //调用getNode()方法，返回值赋值给e，如果取得的值为null，
        //就返回null，否则就返回Node对象e的value值
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }

 //取hash值方法，HashMap的put方法的也是调用了这个方法，
 //get方法也调用这个方法，保证存取时key值对应的hash值是一致的，这样才能正确对应 
 static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    
     
final Node<K,V> getNode(int hash, Object key) {
        //定义几个变量 
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        //首先是判断数组table不能为空且长度要大于0，同时把数组长度tab.length赋值给n
        if ((tab = table) != null && (n = tab.length) > 0 &&
             //其次是通过[(n - 1) & hash]获取key对应的索引，
             //同时数组中的这个索引要有值，然后赋值给first变量
            (first = tab[(n - 1) & hash]) != null) {
            //这个first其实就是链表头的节点了，接下来判断first的hash值是否等于传进来key的hash值
            if (first.hash == hash && 
                //再判断first的key值赋值给k变量，
                //然后判断其是否等于key值，
                //或者判断key不为null时，key和k变量的equals比较结果是否相等
                ((k = first.key) == key || (key != null && key.equals(k))))
                //如果满足上述条件的话，说明要找的就是first节点，直接返回
                return first;
            //走到这步，就说明要找的节点不是首节点，
            //那就用first.next找它的后继节点 ，并赋值给e变量，在这个变量不为空时   
            if ((e = first.next) != null) {
                //如果首节点是树类型的，那么直接调用getTreeNode()方法去树里找
                if (first instanceof TreeNode)
                     //这里就不跟进去了，获取树中对应key的节点后直接返回
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                //走到这步说明结构还是链表    
                do {
                    //这一步其实就是在链表中遍历节点，找到和传进来key相符合的节点，然后返回
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                  //获取e节点的后继节点，然后赋值给e，不为空则进入循环体  
                } while ((e = e.next) != null);
            }
        }
        //以上条件都不满足，说明没有该key对应的数据节点，返回null
        return null;
    }
```

### 12-3-2：hashmap的get和put操作的时间复杂度

如果说一个entry数组下标最多只对应了一个entry，此时get方法的时间复杂度可以达到O(1)。
但是如果所有的hash都一样，那么退化为线性查找，变成了O（n）

## 12-4：hashmap的String类型如何计算hashcode的

就是以31为权，每一位为字符的ASCII值进行运算，用自然溢出来等效取模。
选择值31是因为它是素数。如果是偶数并且乘法运算溢出，则信息将丢失，因为乘以2等于移位。
31的一个不错的特性是乘法可以用移位和减法来代替，以获得更好的性能
哈希分布比较均匀。偶数的冲突率很高，只有少数例外。小乘数（1-20）的冲突率也很高

## 12-5：hashmap源码部分

### 12-5-1：HashMap中(tab.length - 1) & hash作用

1. 保证不会发生数组越界
2. 保证元素尽可能的均匀分布

### 12-5-3：为什么默认初始化桶数组大小

如果我们没有设置初始容量大小，随着元素的不断增加，
HashMap会发生多次扩容，而HashMap中的扩容机制决定了每次扩容都需要重建hash表，
是非常影响性能的。

### 12-5-4：hashmap为什么是2的次幂

取模运算可以变成位与运算，效率显著提高！但是要浪费一些空间。


## 12-6：hashmap扩容过程

1. 若threshold（阈值）不为空，table的首次初始化大小为阈值，
   否则初始化为缺省值大小16
2. 默认的负载因子大小为0.75，
   当一个map填满了75%的bucket时候，
   就会扩容，扩容后的table大小变为原来的两倍
3. 假设扩容前的table大小为2的N次方，
   有put方法就可以知道，元素的table索引为其hash值的后N位确定
4. 扩容后的table大小即为2的N+1次方，
   则其中元素的table索引为其hash值的后N+1位确定，
   比原来多了一位
5. 重新调整map的大小，
   并将原来的对象放入新的bucket数组中。

### 12-6-1：什么时候扩容

当向容器添加元素的时候，会判断当前容器的元素个数，
如果大于等于阈值
也就是当前数组的长度乘以加载因子的值的时候，就要自动扩容啦。
Resize步骤
1. 扩容：创建一个新的Entry空数组，长度是原数组的2倍。
2. ReHash：遍历原Entry数组，把所有的Entry重新Hash到新数组。
           因为长度扩大以后，Hash的规则也随之改变。

### 12-6-2：reHash（重散列）过程

1. 首先创建一个比现有哈希表更大的新哈希表（expand）
2. 然后将旧哈希表的所有元素都迁移到新哈希表去（rehash）

### 12-6-3：该容量如何变化

扩容时，调用 resize() 方法，将 table 长度变为原来的两倍
扩容的其实是table 长度，而不是 threshold阈值

### 12-6-4：这种变化会带来什么问题

如果数据很大的情况下，扩展时将会带来性能的损失，
在性能要求很高的地方，这种损失很可能很致命。

### 12-6-3：扩容的几个参数

#### 12-6-3-1：HashMap 的 table 的容量如何确定

table 数组大小是由 capacity 这个参数确定的，
默认是16，也可以构造时传入，最大限制是1<<30；

#### 12-6-3-2：loadFactor 是什么

loadFactor 是装载因子，
主要目的是用来确认table数组是否需要动态扩展，
默认值是0.75，
比如table 数组大小为 16，
装载因子为 0.75 时，threshold 就是12，
当 table 的实际大小超过 12 时，
table就需要动态扩容；

##### 12-6-3-2-1：扩容因子为什么是0.75

如果负载因子小，意味着阈值变小。比如容量为10 的HashMap，
负载因子为0.5f，那么存储5个就会扩容到20，
出现哈希冲突的可能性变小，但是空间利用率不高。
适用于有足够内存并要求查询效率的场景。
相反如果阈值为1 ，那么容量为10，
就必须存储10个元素才进行扩容，
出现冲突的概率变大，
极端情况下可能会从O(1)退化到O(n)。
适用于内存敏感但不要求要求查询效率的场景

### 12-6-6：数组扩容

创建一个新的数组，其容量为旧数组的两倍，
并重新计算旧数组中结点的存储位置。
结点在新数组中的位置只有两种，原下标位置或原下标+旧数组的大小。

### 12-6-7：为什么在JDK1.7的时候是先进行扩容后进行插入，而在JDK1.8的时候则是先插入后进行扩容的呢

在JDK1.7中的话，是先进行扩容后进行插入的，
就是当你发现你插入的桶是不是为空，
说明存在值就发生了hash冲突，
那么就必须得扩容，
但是如果不发生Hash冲突的话，
说明当前桶是空的（后面并没有挂有链表），
那就等到下一次发生Hash冲突的时候在进行扩容，
但是当如果以后都没有发生hash冲突产生，
那么就不会进行扩容了，
减少了一次无用扩容，
也减少了内存的使用

### 12-6-8：JDK1.8链表转化为红黑树的阈值是8,而不是7
或者不是20呢

1. 中间有个差值7可以有效防止链表和树频繁转换，降低效率
2. 由于treenodes的大小大约是常规节点的两倍，
   因此我们仅在容器包含足够的节点以保证使用时才使用它们，
   当它们变得太小（由于移除或
   调整大小）时，
   它们会被转换回普通的node节点，
   容器中节点分布在hash桶中的频率遵循泊松分布，
   桶的长度超过8的概率非常非常小。

### 12-6-6：插入一万个元素之后会不会扩容，扩容扩多少

HashMap 是否扩容，由 threshold 决定，而 threshold 又由初始容量和 loadFactor 决定。
1. HashMap 构造方法传递的 initialCapacity，它实际表示 table 的容量。
   * 只是代表了 table 数组容量为 1000
2. 构造方法传递的initialCapacity，
   最终会被tableSizeFor()方法动态调整为2的N次幂，
   以方便在扩容的时候，计算数据在newTable中的位置。
  * 虽然你传入了10000，但是实际传入的是10000/loadFactor，但是呢会调整为最接近的2 的 N 次幂
    * 如：实际传入了10000/0.75=13333，最接近的是2^13=16384，那么就采用16384
3. 如果设置了table的初始容量，
   会在初始化 table 时，
   将扩容阈值 threshold 重新调整为 table.size * loadFactor。
  * 那么可以储存的最大容量就是：16384*0.75=12288




## 12-7：hash函数

1. 直接定址法：直接以key或者key上加上某个常数作为哈希地址
2. 数字分析法：提取key中取值比较均匀的数字作为哈希地址
3. 除留余数法：用key除以某个不大于哈希表长度m的数，将所得余数作为哈希地址
4. 分段叠加法：按照哈希表地址位数将关键字分成了位数相等的几部分，
              其中最后一部分可以比较短，然后将这几部分相加，舍弃最
              高位仅为后的结果就是该关键字的哈希地址
5. 平方取中法：如果key的各部分分部都不均匀，可以先求出他的平方值，
              然后按照需求求取中间的几位作为哈希地址
6. 伪随机数法：采用一个伪随机数作为哈希函数

### 12-7-1：hash 的实现

JDK 1.8 中，是通过 hashCode() 的高 16 位异或低 16 位实现的：
(h = k.hashCode()) ^ (h >>> 16)，
主要是从速度，功效和质量来考虑的，
减少系统的开销，
也不会造成因为高位没有参与下标的计算，
从而引起的碰撞。

#### 12-7-1-2：为什么要用异或运算符？

保证了对象的 hashCode 的 32 位值只要有一位发生改变，
整个 hash() 返回值就会改变。尽可能的减少碰撞。

### 12-7-2：哈希冲突的解决方法

1. 拉链法
   创建一个链表数组，数组中每一格就是一个链表。
   若遇到哈希冲突，则将冲突的值加到链表中即可。
2. 开发地址法
   所有输入的元素全部存放在哈希表里，
   先通过哈希函数进行判断，若是发生哈希冲突，
   就以当前地址为基准，根据再寻址的方法（探查序列），
   去寻找下一个地址，若发生冲突再去寻找，
   直至找到一个为空的地址为止。
3. 建立一个公共溢出区
   假设哈希函数的值域为[0,m-1],则设向量HashTable[0..m-1]为基本表，
   另外设立存储空间向量OverTable[0..v]用以存储发生冲突的记录。
4. 再哈希法
   当发生冲突时，使用第二个、第三个、哈希函数计算地址，
   直到无冲突时。缺点：计算时间增加。
   比如上面第一次按照姓首字母进行哈希，
   如果产生冲突可以按照姓字母首字母第二位进行哈希，
   再冲突，第三位，直到不冲突为止

### 12-7-3：一致性Hash算法

一致性Hash算法也是使用取模的方法，
一致性Hash算法是对2^32取模，一致性Hash算法将整个哈希值空间组织成一个虚拟的圆环，
将各个服务器使用Hash进行一个哈希，
具体可以选择服务器的IP或主机名作为关键字进行哈希，
这样每台机器就能确定其在哈希环上的位置，
每次根据要缓存的key计算得到hash值，在hash环上顺时针查找距离最近的缓存服务器节点，
根据一致性Hash算法，数据A会被定为到Node A上，
B被定为到Node B上，C被定为到Node C上，D被定为到Node D上。

#### 12-7-3-1：一致性hash和普通hash区别

一致性哈希算法能尽可能减少了服务器数量变化所导致的缓存迁移。
一致性hash算法能够在一定程度上改善缓存的雪崩问题，
它能够在移除/添加一台缓 存服务器时，尽可能小的改变已存在的key映射关系，
避免大量key的重新映射。
先构造一个长度为2 32次方的整数环（这个环被称为一致性Hash环），
根据节点名称的Hash值（其分布为[0, 23 2次方-1]）将服务器节点放置在这个Hash环上，
然后根据数据的Key值计算得到其Hash值（其分布也为[0, 2 32次方-1]），
接着在Hash环上顺时针查找距离这个Key值的Hash值最近的服务器节点，
完成Key到服务器的映射查找。
这种算法解决了普通余数Hash算法伸缩性差的问题，
可以保证在上线、下线服务器的情况下尽量有多的请求命中原来路由到的服务器。

如果`节点有增加或者删除`，普通哈希算法key都要`全部分配`，一致性哈希算法只需要重新分配`部分key`

## 12-8：扰动函数以及作用

HashMap的hash方法。
为了防止一些实现比较差的hashCode()方法，
使用扰动函数之后可以减少碰撞。

## 12-9：hashmap线程问题

hashmap是线程不安全的
在JDK1.7的时候没有加入同步锁保护，
同时由于JDK1.7在并发执行put造作导致扩容行为从而导致环形链表，
在获取数据遍历链表形成死循环，
同时hashmap迭代器的fail-fast策略，
一旦在使用地带器过程中出现并发操作，就会跑出异常。
那么JDK1.8虽然解决了死循环问题，
但是还是没有同步锁保护机制，
所以依然线程不安全
所以多线程情况下，
首选线程安全的ConcurrentHashMap

### 12-9-1：线程安全的Map

* Hashtable
* ConcurrentHashMap
* SynchronizedMap

1. Hashtable、SynchronizedMap源码中是使用synchronized来保证线程安全的
2. ConcurrentHashMap沿用了与它同时期的HashMap版本的思想，
   底层依然由“数组”+链表+红黑树的方式思想，但是
   ConcurrentHashMap没有对整个hash表进行锁定，
   而是采用了分离锁（segment）的方式进行局部锁定。
   具体体现在，它在代码中维护着一个segment数组。
   
### 12-9-2：设计线程安全的map

1. 使用synchronized来进行约束：
2. 使用JDK1.5版本所提供的lock机制
3. 使用JDK提供的读写锁
4. 使用JDK1.5提供的ConcurrentHashMap,
   该类将Map的存储空间分为若干块,
   每块拥有自己的锁,减少了多个线程争夺同一个锁的情况

## 12-10：hashmap应用

### 12-10-1：为什么hashmap中String、integer包装类适合作为key

1. 包装类重写了equals\hashcode方法，不容易出现hash值计算错误
2. 由于String类型是final的，保证了key的不可更改性

### 12-10-2：如果想要一个key对应多个Value的话，怎么设计Map

1.普通做法
  Map<Object,List<Object>> map=new HashMap<>();
2.apache commons工具包里有个org.apache.commons.collections.map.MultiValueMap。
3.开源项目NoHttp里的MultiValueMap。

```java
1. 首先使用MultiValueMap接口
public interface MultiValueMap<K, V> {
添加Key-Value。
    void add(K key, V value);
添加Key-List<Value>。
    void add(K key, List<V> values);
设置一个Key-Value，如果这个Key存在就被替换，不存在则被添加。
    void set(K key, V value);
设置Key-List<Value>，如果这个Key存在就被替换，不存在则被添加。
     void set(K key, List<V> values);
替换所有的Key-List<Value>。
     void set(Map<K, List<V>> values);
 移除某一个Key，对应的所有值也将被移除。
     List<V> remove(K key);
移除所有的值。
     void clear();
拿到Key的集合。
     Set<K> keySet();
拿到所有的值的集合。
     List<V> values();
拿到某一个Key下的某一个值。
     V getValue(K key, int index);
拿到某一个Key的所有值。
     List<V> getValues(K key);
拿到MultiValueMap的大小.
     int size();
判断MultiValueMap是否为null.
     boolean isEmpty();
判断MultiValueMap是否包含某个Key.
     boolean containsKey(K key);}
2. MultiValueMap接口的实现类LinkedMultiValueMap
public class LinkedMultiValueMap<K, V> implements MultiValueMap<K, V> {
一个Key对应多个Value
   protected Map<K, List<V>> mSource = new LinkedHashMap<K, List<V>>();
}
3. 实现MultiValueMap接口所有的方法
public class LinkedMultiValueMap<K, V> implements MultiValueMap<K, V> {
    protected Map<K, List<V>> mSource = new LinkedHashMap<K, List<V>>();
    public LinkedMultiValueMap() {}
    @Override
    public void add(K key, V value) {
        if (key != null) {
            // 如果有这个Key就继续添加Value，没有就创建一个List并添加Value
            if (!mSource.containsKey(key))
                mSource.put(key, new ArrayList<V>(2));
            mSource.get(key).add(value);}}
    @Override
    public void add(K key, List<V> values) {
        // 便利添加进来的List的Value，调用���面的add(K, V)方法添加
        for (V value : values) {
            add(key, value);}}
    @Override
    public void set(K key, V value) {
        // 移除这个Key，添加新的Key-Value
        mSource.remove(key);
        add(key, value);}
    @Override
    public void set(K key, List<V> values) {
        // 移除Key，添加List<V>
        mSource.remove(key);
        add(key, values);}
    @Override
    public void set(Map<K, List<V>> map) {
        // 移除所有值，便利Map里的所有值添加进来
        mSource.clear();
        mSource.putAll(map);}
    @Override
    public List<V> remove(K key) {
        return mSource.remove(key);}
    @Override
    public void clear() {
        mSource.clear();}
    @Override
    public Set<K> keySet() {
        return mSource.keySet();}
    @Override
    public List<V> values() {
        // 创建一个临时List保存所有的Value
        List<V> allValues = new ArrayList<V>();
        // 便利所有的Key的Value添加到临时List
        Set<K> keySet = mSource.keySet();
        for (K key : keySet) {
            allValues.addAll(mSource.get(key));
        }
        return allValues;}
    @Override
    public List<V> getValues(K key) {
        return mSource.get(key);}
    @Override
    public V getValue(K key, int index) {
        List<V> values = mSource.get(key);
        if (values != null && index < values.size())
            return values.get(index);
        return null;}
    @Override
    public int size() {
        return mSource.size();}
    @Override
    public boolean isEmpty() {
        return mSource.isEmpty();}
    @Override
    public boolean containsKey(K key) {
        return mSource.containsKey(key);}}
4. 然后就可以写一个测试类，测试一下了，
public static void main(String[] args) {
    MultiValueMap<String, String> stringMultiValueMap = new LinkedMultiValueMap<>();
    // 添加Key为name的
    stringMultiValueMap.add("name", "yolanda");
    stringMultiValueMap.add("name", "yanzhenjie");
    // 打印所有值
    Set<String> keySet = stringMultiValueMap.keySet();
    for (String key : keySet) {
        List<String> values = stringMultiValueMap.getValues(key);
        for (String value : values) {
            System.out.println(key + ": " + value);}}}
```

### 12-10-3：创建一个对象HashMap<Integer,Integer> map=new HashMap<>先put(10),然后get(new Long(10))结果是多少？

为空，原因是
1. hashmap在存入的时候，先对key做一遍hash，
   以hash值作为数组下标，如果发现下标已有值，
   判断存的key跟传入的key是不是
   相同，如果相同覆盖，
   显然Integer 和 Long 肯定不是一个类型，
   所以 Long 123 和 Integer 123 hashmap会认为是 hash冲突
2. hashmap 在 get的时候，也是先做hash处理，
   根据hash值查找对应的数组下标查找,
   虽然存入Integer 123  根据 Long 123 来获取返回的 是 NULL

### 12-10-4：使用final static修饰集合hashmap会产生什么影响

当final修饰变量时，对于基本类型和string，这个变量的值是不能改变的；
当修饰其他类型的对象时，final使其引用恒定不变，但是对象自身却可以自由修改变换。

## 12-11：JDK的hashmap与Redis的hashmap的区别

1. HashMap由于对链表size超过8采用二叉树结构，
   使得get操作随着激烈冲突导致变成一个类二叉树，
   时间复杂度为O(log(n))较redis的字典表O(n)，性能提升明显。
2. Redis的rehash由于采用渐进式的方式，
   对于大数据量下的rehash操作性能提升明显。
   这也是由于HashMap大部分用于临时且数据量不是特别大的数据，
   redis的hash用于存储避免大数据情况导致异常，
   双方的侧重点不一样。
3. Redis的单链表在冲突的情况下是从表头插入，
   时间复杂度为O(1)，而HashMap则为O(n)。


# 13.ConcurrentHashMap数据结构

## 13-1：ConcurrentHashMap的底层实现

在JDK7的时候，这种安全策略采用的是分段锁的机制，
ConcurrentHashMap维护了一个Segment数组，
Segment这个类继承了重入锁ReentrantLock，
并且该类里面维护了一个 HashEntry<K,V>[] table数组，
在写操作put，remove，扩容的时候，会对Segment加锁，
所以仅仅影响这个Segment，不同的Segment还是可以并发的，
所以解决了线程的安全问题，同时又采用了分段锁也提升了并发的效率。
JDK8中最大的区别在于JDK8的锁粒度更细，
理想情况下talbe数组元素的大小就是其支持并发的最大个数，
在JDK7里面最大并发个数就是Segment的个数，默认值是16，
可以通过构造函数改变一经创建不可更改，这个值就是并发的粒度，
每一个segment下面管理一个table数组，加锁的时候其实锁住的是整个segment，
这样设计的好处在于数组的扩容是不会影响其他的segment的，
简化了并发设计，不足之处在于并发的粒度稍粗，
所以在JDK8里面，去掉了分段锁，将锁的级别控制在了更细粒度的table元素级别，
也就是说只需要锁住这个链表的head节点，并不会影响其他的table元素的读写，
好处在于并发的粒度更细，影响更小，从而并发效率更好，
但不足之处在于并发扩容的时候，由于操作的table都是同一个，
不像JDK7中分段控制，所以这里需要等扩容完之后，
所有的读写操作才能进行，所以扩容的效率就成为了整个并发的一个瓶颈点，
好在Doug lea大神对扩容做了优化，本来在一个线程扩容的时候，
如果影响了其他线程的数据，那么其他的线程的读写操作都应该阻塞，
但Doug lea说你们闲着也是闲着，不如来一起参与扩容任务，
这样人多力量大，办完事你们该干啥干啥，别浪费时间，
于是在JDK8的源码里面就引入了一个ForwardingNode类，
在一个线程发起扩容的时候，就会改变sizeCtl这个值

### 13-1-1：为何会出现ConcurrenHashMap?

1. 线程安全，读写还快，以空间换时间
2. 改善了hashmap迭代器出现的ConcurrentModificationException
   由于ConcurrentHashMap对于会产生并发操作的node都会有加锁同步处理,
   且迭代器获取tab[index]开头node时都会从主存来获得,
   保证获取的数据是最新的，
   从而保证了迭代器在迭代过程中即使有put , remove 
   等操作同时发生也可以保证迭代的安全性,
   不会出现ConcurrentModificationException

### 13-1-2：为什么ConcurrentHashMap（hashtable）为何不支持null键和null值

ConcurrentHashmap和Hashtable都是支持并发的，
这样会有一个问题，当你通过get(k)获取对应的value时，
如果获取到的是null时，你无法判断，
它是put（k,v）的时候value为null，
还是这个key从来没有做过映射。HashMap是非并发的，
可以通过contains(key)来做这个判断。
而支持并发的Map在调用m.contains（key）和m.get(key),m可能已经不同了。

### 13-1-3：分段锁原理

它内部细分了若干个小的 HashMap，称之为段(Segment)。
默认情况下一个 ConcurrentHashMap 被进一步细分为 16 个段，既就是锁的并发度。
如果需要在ConcurrentHashMap 添加一项key-value，
并不是将整个 HashMap 加锁，而是首先根据 hashcode 得到该key-value应该存放在哪个段中，
然后对该段加锁，并完成 put 操作。在多线程环境中，如果多个线程同时进行put操作，
只要被加入的key-value不存放在同一个段中，则线程间可以做到真正的并行。
ConcurrentHashMap 是一个 Segment 数组， Segment 通过继承ReentrantLock 来进行加锁，
所以每次需要加锁的操作锁住的是一个 segment，
这样只要保证每个 Segment 是线程安全的，也就实现了全局的线程安全

### 13-1-4：为什么要使用内置锁synchronized来代替重入锁 ReentrantLock？

1. 粒度降低了；
2. 基于 JVM 的 synchronized 优化空间更大
   在大量的数据操作下，对于 JVM 的内存压力，
   基于 API 的 ReentrantLock 会开销更多的内存。

## 13-2：ConcurrentHashMap的put操作

1. 首先判断是否初始化，如果没有初始化则进入initTable()方法进行初始化工作
2. 如果已经初始化了，进入无限循环，判断key对应的数组下标是否有值了
3. 如果key对应的下标没有值，通过CAS原理插入，插入成功则退出循环，插入失败则继续循环
4. 如果key对应的下标已经存在值,判断此时hash==MOVED(-1),则进入帮助扩容。
5. 如果key对应的下标已经存在值，但是hash!=MOVED,则需要对数组的这个下标进行加锁了，以保证线程的安全。
6. 如果数组的这个下标是一个链表，则对操作链表（判断链表用hash>=0）
7. 如果数组的这个下标是一个红黑树，则操作红黑树。
8. 插入成功后，如果链表的长度已经达到了红黑树的阀门8，
   则首先判断此时数组的长度是否大于64，如果小于64则进行扩容，如果大于等于64则链表变成红黑树
9.  判断容器是否扩容

### 13-2-1：手写ConcurrentHashMap的put操作

```java
public V put(K key, V value) {
        return putVal(key, value, false);
    }
    final V putVal(K key, V value, boolean onlyIfAbsent) {
    if (key == null || value == null) throw new NullPointerException();
    int hash = spread(key.hashCode());//对hashCode进行再散列，算法为(h ^ (h >>> 16)) & HASH_BITS
    int binCount = 0;
 //这边加了一个循环，就是不断的尝试，
 //因为在table的初始化和casTabAt用到了compareAndSwapInt、compareAndSwapObject
//因为如果其他线程正在修改tab，那么尝试就会失败，所以这边要加一个for循环，不断的尝试
    for (Node<K,V>[] tab = table;;) {
        Node<K,V> f; int n, i, fh;
        // 如果table为空，初始化；否则，根据hash值计算得到数组索引i，
        //如果tab[i]为空，直接新建节点Node即可。注：tab[i]实质为链表或者红黑树的首节点。
        if (tab == null || (n = tab.length) == 0)
            tab = initTable();

        else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
            if (casTabAt(tab, i, null,
                         new Node<K,V>(hash, key, value, null)))
                break;                   // no lock when adding to empty bin
        }
        // 如果tab[i]不为空并且hash值为MOVED(-1)，说明该链表正在进行transfer操作，返回扩容完成后的table。
        else if ((fh = f.hash) == MOVED)
            tab = helpTransfer(tab, f);
        else {
            V oldVal = null;
            // 针对首个节点进行加锁操作，而不是segment，进一步减少线程冲突
            synchronized (f) {
                if (tabAt(tab, i) == f) {
                    if (fh >= 0) {
                        binCount = 1;
                        for (Node<K,V> e = f;; ++binCount) {
                            K ek;
                            // 如果在链表中找到值为key的节点e，直接设置e.val = value即可。
                            if (e.hash == hash &&
                                ((ek = e.key) == key ||
                                 (ek != null && key.equals(ek)))) {
                                oldVal = e.val;
                                if (!onlyIfAbsent)
                                    e.val = value;
                                break;}
                            // 如果没有找到值为key的节点，直接新建Node并加入链表即可。
                            Node<K,V> pred = e;
                            if ((e = e.next) == null) {
                                pred.next = new Node<K,V>(hash, key,
                                                          value, null);
                                break;}}}
                    // 如果首节点为TreeBin类型，说明为红黑树结构，执行putTreeVal操作。
                    else if (f instanceof TreeBin) {
                        Node<K,V> p;
                        binCount = 2;
                        if ((p = ((TreeBin<K,V>)f).putTreeVal(hash, key,
                                                       value)) != null) {
                            oldVal = p.val;
                            if (!onlyIfAbsent)
                                p.val = value;} }}}
            if (binCount != 0) {
                // 如果节点数>＝8，那么转换链表结构为红黑树结构。
                if (binCount >= TREEIFY_THRESHOLD)
                    treeifyBin(tab, i);
                if (oldVal != null)
                    return oldVal;
                break;}}}
    // 计数增加1，有可能触发transfer操作(扩容)。
    addCount(1L, binCount);
    return null;}
@SuppressWarnings("unchecked")
static final <K,V> Node<K,V> tabAt(Node<K,V>[] tab, int i) {
    return (Node<K,V>)U.getObjectVolatile(tab, ((long)i << ASHIFT) + ABASE);
}

/*
 *但是这边为什么i要等于((long)i << ASHIFT) + ABASE呢,计算偏移量
 *ASHIFT是指tab[i]中第i个元素在相对于数组第一个元素的偏移量，而ABASE就算第一数组的内存素的偏移地址
 *所以呢，((long)i << ASHIFT) + ABASE就算i最后的地址
 * 那么compareAndSwapObject的作用就算tab[i]和c比较，如果相等就tab[i]=v否则tab[i]=c;
*/
static final <K,V> boolean casTabAt(Node<K,V>[] tab, int i,
                                    Node<K,V> c, Node<K,V> v) {
    return U.compareAndSwapObject(tab, ((long)i << ASHIFT) + ABASE, c, v);
}

static final <K,V> void setTabAt(Node<K,V>[] tab, int i, Node<K,V> v) {
    U.putObjectVolatile(tab, ((long)i << ASHIFT) + ABASE, v);
}
```
### 13-2-2：hashmap与ConcurrentHashMap中put的区别

一个加锁，一个没有加锁

## 13-3：ConcurrentHashMap的get操作

1. 首先计算hash值，定位到该table索引位置，如果是首节点符合就返回
2. 如果遇到扩容的时候，
   会调用标志正在扩容节点ForwardingNode的find方法，
   查找该节点，匹配就返回
3. 以上都不符合的话，就往下遍历节点，匹配就返回，否则最后就返回null

### 13-3-1：手写ConcurrentHashMap的get操作

```java
//会发现源码中没有一处加了锁
public V get(Object key) {
    Node<K,V>[] tab; Node<K,V> e, p; int n, eh; K ek;
    int h = spread(key.hashCode()); //计算hash
    if ((tab = table) != null && (n = tab.length) > 0 &&
      (e = tabAt(tab, (n - 1) & h)) != null) {//读取首节点的Node元素
        if ((eh = e.hash) == h) { //如果该节点就是首节点就返回
            if ((ek = e.key) == key || (ek != null && key.equals(ek)))
                return e.val;
        }
//hash值为负值表示正在扩容，这个时候查的是ForwardingNode的find方法来定位到nextTable来
//eh=-1，说明该节点是一个ForwardingNode，正在迁移，此时调用ForwardingNode的find方法去nextTable里找。
//eh=-2，说明该节点是一个TreeBin，
//此时调用TreeBin的find方法遍历红黑树，
//由于红黑树有可能正在旋转变色，所以find里会有读写锁。
//eh>=0，说明该节点下挂的是一个链表，直接遍历该链表即可。
        else if (eh < 0)
            return (p = e.find(h, key)) != null ? p.val : null;
        while ((e = e.next) != null) {//既不是首节点也不是ForwardingNode，那就往下遍历
            if (e.hash == h &&
             ((ek = e.key) == key || (ek != null && key.equals(ek))))
                 return e.val;
        }
    }
    return null;
}
```


## 13-4：ConcurrentHashMap扩容机制

1. 通过计算CPU核心数和Map数组的长度得到每个线程要帮助处理多少个桶，
   并且这里每个线程处理都是平均的。默认每个线程处理 16 个桶。
   因此，如果长度是 16 的时候，扩容的时候只会有一个线程扩容。
2. 初始化临时变量,将其在原有基础上扩容两倍。
3. 死循环开始转移。多线程并发转移就是在这个死循环中，
   根据一个 finishing 变量来判断，该变量为 true 表示扩容结束，否则继续扩容。
 31. 进入一个 while 循环，分配数组中一个桶的区间给线程，
     默认是 16. 从大到小进行分配。当拿到分配值后，进行i--递减。
     这个 i 就是数组下标。（其中有一个 bound 参数，
     这个参数指的是该线程此次可以处理的区间的最小下标，超过这个下标，就需要
     qiyeweix重新领取区间或者结束扩容，还有一个 advance 参数，
     该参数指的是是否继续递减转移下一个桶，
     如果为 true，表示可以继续向后推进，反之，说明还没有处理好当前桶，不能推进)
 32. 出 while 循环，进 if 判断，判断扩容是否结束，如果扩容结束，清空临死变量，
     更新 table 变量，更新库容阈值。如果没完成，但已经无法领取区间（没了），
     该线程退出该方法，并将 sizeCtl 减一，表示扩容的线程少一个了。如果减完这个数以后，
     sizeCtl 回归了初始状态，表示没有线程再扩容了，
     该方法所有的线程扩容结束了。（这里主要是判断扩容任务是否结束，如果结束
     了就让线程退出该方法，并更新相关变量）。然后检查所有的桶，防止遗漏。
 33. 如果没有完成任务，且 i 对应的槽位是空，尝试 CAS 插入占位符，让 putVal 方法的线程感知。
 34. 如果 i 对应的槽位不是空，且有了占位符，那么该线程跳过这个槽位，处理下一个槽位。
 35. 如果以上都是不是，说明这个槽位有一个实际的值。开始同步处理这个桶。
 36. 到这里，都还没有对桶内数据进行转移，只是计算了下标和处理区间，
     然后一些完成状态判断。同时，如果对应下标内没有数据
     或已经被占位了，就跳过了。
4. 之后处理每个桶的行为都是同步的。防止 putVal 的时候向链表插入数据。
 41. 如果这个桶是链表，那么就将这个链表根据 length 取于拆成两份，
     取于结果是 0 的放在新表的低位，取于结果是 1 放在新表的高位。
 42. 如果这个桶是红黑数，那么也拆成 2 份，方式和链表的方式一样，
     然后，判断拆分过的树的节点数量，如果数量小于等于 6，
     改造成链表。反之，继续使用红黑树结构。
 43. 到这里，就完成了一个桶从旧表转移到新表的过程。

### 13-4-1：什么时候会发生扩容机制

1. put操作（插入键值对）
2. putAll操作（批量插入键值对）
3. remove操作（移除元素，底层实现是用null空值代替原位元素）
4. replace操作（对已存在的键值对替换值）
5. computeIfAbsent操作（若key对应的value为空，会将第二个参数的返回值存入并返回）

### 13-4-2：hashmap与ConcurrentHashMap中扩容的区别

1. concurrenthashmap中扩容时候会判断这个值，如果超过阈值就要扩容，
   首先根据运算得到需要遍历的次数i，
   然后利用tabAt方法获得i位置的元素f，
   初始化一个forwardNode实例fwd，如果f == null，
   则在table中的i位置放入fwd，
   否则采用头插法的方式把当前旧table数组的指定任务范围的数据给迁移到新的数组中，
   然后 给旧table原位置赋值fwd。
   直到遍历过所有的节点以后就完成了复制工作，
   把table指向nextTable，并更新sizeCtl为新数组大小的0.75倍 ，
   扩容完成。在此期间如果其他线程的有读写操作
   都会判断head节点是否为forwardNode节点，如果是就帮助扩容
2. 在JDK8里面，HashMap的底层数据结构已经变为数组+链表+红黑树的结构了，
   因为在hash冲突严重的情况下，链表的查询效率是O(n），
   所以JDK8做了优化对于单个链表的个数大于8的链表，
   会直接转为红黑树结构算是以空间换时间，这样以来查询的效率就变为O(logN)

## 13-5：ConcurrentHashMap读写操作的锁

1. ConcurrentHashMap在读操作时不需要加锁，
   也就是说在get操作时，会发现get操作全程是没有加任何锁的
   主要是因为get操作可以无锁是由于Node的元素val和指针next是用volatile修饰的，
   在多线程环境下线程A修改结点的val或者新增节点的时候是对线程B可见的
   而数组用volatile修饰主要是保证在数组扩容的时候保证可见性
2. 在写操作会加入锁，将键、值构造为Entry节点加入到对应的Segment段里

## 13-6：为什么 ConcurrentHashMap 比 HashTable 效率要高？

HashTable 使用一把锁（锁住整个链表结构）处理并发问题，
多个线程竞争一把锁，容易阻塞；
而在ConcurrentHashMap
JDK 1.7 中使用分段锁（ReentrantLock + Segment + HashEntry），
相当于把一个 HashMap 分成多个段，
每段分配一把锁，这样支持多线程访问。
锁粒度：基于 Segment，包含多个 HashEntry。
JDK 1.8 中使用 CAS + synchronized + Node + 红黑树。
锁粒度：Node（首结点）（实现 Map.Entry<K,V>）。锁粒度降低了。

## 13-7：ConcurrentHashMap 的并发度是什么？

程序运行时能够同时更新 ConccurentHashMap 
且不产生锁竞争的最大线程数。默认为 16，
且可以在构造函数中设置。
当用户设置并发度时，ConcurrentHashMap 
会使用大于等于该值的最小2幂指数
作为实际并发度
（假如用户设置并发度为17，实际并发度则为32）


# 14.TreeMap

## 14-1：TreeMap数据结构

TreeMap是桶+红黑树的实现方式.TreeMap的底层结构就是一个数组,
数组中每一个元素又是一个红黑树.当添加一个元素(key-value)的时候,
根据key的hash值来确定插入到哪一个桶中(确定插入数组中的位置),
当桶中有多个元素时,使用红黑树进行保存;
当一个桶中存放的数据过多,那么根据key查找的效率就会降低

## 14-2：TreeMap使用场景

1. 需要基于排序的统计功能：
2. 需要快速增删改查的存储功能：
3. 需要快速增删改查而且需要保证遍历和插入顺序一致的存储功能：

# 15.LinkedHashmap

## 15-1：LinkedHashmap数据结构

LinkedHashMap继承于HashMap，
底层使用哈希表和双向链表来保存所有元素，
并且它是非同步，允许使用null值和null键。
基本操作与父类HashMap相似，
通过重写HashMap相关方法，
重新定义了数组中保存的元素Entry，
来实现自己的链接列表特性。
该Entry除了保存当前对象的引用外，
还保存了其上一个元素before和下一个元素after的引用，
从而构成了双向链接列表。

# 16.HashTable

## 16-1：HashTable数据结构

Hashtable是基于哈希表的Map接口的同步实现，不允许使用null值和null键
底层使用数组实现，数组中每一项是个单链表，即数组和链表的结合体
Hashtable在底层将key-value当成一个整体进行处理，这个整体就是一个Entry对象。
Hashtable底层采用一个Entry[]数组来保存所有的key-value对，
当需要存储一个Entry对象时，会根据key的hash算法来决定其在数组中的存储位置，
在根据equals方法决定其在该数组位置上的链表中的存储位置；
当需要取出一个Entry时，也会根据key的hash算法找到其在数组中的存储位置，
再根据equals方法从该位置上的链表中取出该Entry。
synchronized是针对整张Hash表的，即每次锁住整张表让线程独占


# 17.ArrayLlist

## 17-1：ArrayList数据结构

ArrayList是List接口的可变数组非同步实现，
并允许包括null在内的所有元素。
底层使用数组实现
该集合是可变长度数组，
数组扩容时，
会将老数组中的元素重新拷贝一份到新的数组中，
每次数组容量增长大约是其容量的1.5倍，
这种操作的代价很高。
采用了Fail-Fast机制，
面对并发的修改时，迭代器很快就会完全失败，
而不是冒着在将来某个不确定时间发生任意不确定行为的风险
remove方法会让下标到数组末尾的元素向前移动一个单位，
并把最后一位的值置空，方便GC

### 17-1-1：数组(Array)和列表(ArrayList)有什么区别？ 
1. 定义上： Array 可以包含基本类型和对象类型， ArrayList 只能包含对象类型。 
2. 容量上： Array 大小固定， ArrayList 的大小是动态变化的。 
3. 操作上： ArrayList 提供更多的方法和特性， 

使用基本数据类型或者知道数据元素数量的时候
可以考虑Array;
ArrayList处理固定数量
的基本类型数据类型时
会自动装箱来减少编码工作量，
但是相对较慢。

## 17-2：ArrayList扩容机制

1. 当前数组是由默认构造方法生成的空数组并且第一次添加数据。
   此时minCapacity等于默认的容量（10）
   那么根据下面逻辑可以看到最后数组的容量会从0扩容成10。
   而后的数组扩容才是按照当前容量的1.5倍进行扩容；
2. 当前数组是由自定义初始容量构造方法创建并且指定初始容量为0。
   此时minCapacity等于1那么根据下面逻辑可以看到最后数组的
   容量会从0变成1。但是
   一旦我们执行了初始容量为0，那么根据下面的算法前四次扩容每次都 +1，
   在第5次添加数据进行扩容的时候才是按照当前容量的1.5倍进行扩容。
3. 当扩容量（newCapacity）大于ArrayList
   数组定义的最大值后会调用hugeCapacity来进行判断。
   如果minCapacity已经大于Integer的最大值（溢出为负数）
   那么抛出OutOfMemoryError（内存溢出）
   否则的话根据与MAX_ARRAY_SIZE的比较情况确定是
   返回Integer最大值还是MAX_ARRAY_SIZE。
   这边也可以看到ArrayList允许的最大容量
   就是Integer的最大值（-2的31次方~2的31次方减1）。

### 17-2-1：ArrayList的add操作

不是原子操作，原因主要是elementData[size++] = e可以继续进行拆分

### 17-2-2：Arraylist初始大小以及扩容大小

ArrayList添加第一个元素时，数组的容量设置为10
当ArrayList数组超过当前容量时，扩容至1.5倍（遇到计算结果为小数的，向下取整），
第一次扩容后，容量为15，第二次扩容至22

## 17-3：ArrayList线程安全

因为在多线程中操作一个ArrayList对象，则会出现不确定的结果，
arraylist线程不安全

### 17-3-1：那如何解决ArrayList线程不安全问题呢？

1. 用Vector代替ArrayList
2. 用Collections.synchronized(new ArrayList<>())
   *  因为Collections.synchronizedList封装后的list，
      list的所有操作方法都是带synchronized关键字的，
      相当于所有操作都会进行加锁，
      所以使用它是线程安全的但是除迭代数组之外
1. CopyOnWriteArrayList
   * 写操作：添加元素时，
            不直接往当前容器添加，而是先拷贝一份数组，
            在新的数组中添加元素后，
            在将原容器的引用指向新的容器。
            因为数组时用volatile关键字修饰的，
            所以当array重新赋值后，
            其他线程可以立即知道（volatile的可见性）
   * 读操作：读取数组时，读老的数组，不需要加锁。
   * 读写分离：写操作是copy了一份新的数组进行写，
              读操作是读老的数组，所以是读写分离。

# 18.vector

## 18-1：vector数据结构

底层数据结构为数组，支持快速随机访问
Vector有四个不同的构造函数。 无参构造的容量默认值为10
很多方法都加入了synchronized同步语句，来确保线程安全。
Vector在查找给定元素索引值等方法中，
源码都将该元素的值分为null和不为null两种情况处理，
Vector中允许元素为null

## 18-2：扩容机制

扩充容量的方法ensureCapacityHelper。
与ArrayList不同的是，
Vector在每次增加元素(可能是1个，也可能是一组)时，
都要调用该方法来确保足够的容量。
当容量不足以容纳当前的元素个数时，
就看构造方法中传入的容量增长系数CapacityIncrement是否为0，
如果不为0，就设置新的容量为 旧容量 + 容量增长量；
如果为0，设置新的容量为旧的容量的2倍，如果设置后的容量还不够，
则直接新的容量设置为 旧容量 + 传入参数所需要的容量 
而后同样用Arrays.copyof()方法将元素拷贝到新的数组。

## 18-3：Vector是保证线程安全的

由于vector中Add方法加了synchronized，来保证add操作是线程安全的

# 19.linkedlist

## 19-1：linkedlist数据结构

LinkedList是List接口的双向链表非同步实现，
并允许包括null在内的所有元素。
底层的数据结构是基于双向链表的，
该数据结构我们称为节点
双向链表节点对应的类Node的实例，
Node中包含成员变量：prev，next，item。
其中，prev是该节点的上一个节点，
next是该节点的下一个节点，
item是该节点所包含的值。
它的查找是分两半查找，
先判断index是在链表的哪一半，
然后再去对应区域查找，
这样最多只要遍历链表的一半节点即可找到

# 20.set

## 20-1：set数据结构

1. 在调用add方法添加元素时,先判断该元素的hash值
   和集合中原有元素的hash值,不一样则添加进来.
2. 如果你存入的对象的 key 值已经存在的话，
   那么新的 value 将会取代老的 value 值，但是并不会添加新的元素进去

# 21.hashset

## 21-1：HashSet数据结构

HashSet由哈希表(实际上是一个HashMap实例)支持，不保证set的迭代顺序，并允许使用null元素。
基于HashMap实现，API也是对HashMap的行为进行了封装，可参考HashMap

## 21-2：hashSet的内存泄漏

当一个对象被存储进HashSet集合中以后，
就不能修改该对象的参与计算哈希值的属性值了，
否则对象修改后的哈希值与最初存储进
HashSet集合中时的哈希值就不同了，
在这种情况下，
即使在contains方法使用该对象的去HashSet集合中检索对象，
也将返回找不到对象的结果，
这也会导致无法从HashSet集合中删除当前对象，造成内存泄露。

## 21-3：HashSet线程安全

HashSet不安全，
底层add操作可以保证可见性、原子性。所以不是线程安全的

### 21-3-1：HashSet如何保证线程安全

1. 使用Collections.synchronizedSet
2. 使用CopyOnWriteArraySet

# 22.TreeSet

## 22-1：TreeSet数据结构

底层是基于TreeMap来实现的，
所以底层结构也是红黑树，
因为他和HashSet不同的是不需要重写hashCode()和equals()方法，
因为它去重是依靠比较器来去重，
因为结构是红黑树，
所以每次插入都会遍历比较来寻找节点插入位置，
如果发现某个节点的值是一样的那就会直接覆盖。


# 23.LinkedHashSet

## 23-1：LinkedHashSet数据结构

对于LinkedHashSet而言，
它继承与HashSet、又基于LinkedHashMap来实现的。
LinkedHashSet底层使用LinkedHashMap来保存所有元素，
它继承与HashSet，其所有的方法操作上又与HashSet相同。

# 24.线程安全/非线程安全的集合

1. 线程安全
   
* Vector
* HashTable
* StringBuffer

2. 非线程安全

* ArrayList
* LinkedList
* HashMap
* HashSet
* TreeMap
* TreeSet
* StringBulider

# 25.java基础-集合-集合大比较

## 25-1：set和list、map的区别

1. List(对付顺序的好帮手)：List接口存储一组不唯一
                        （可以有多个元素引用相同的对象），
                          有序的对象
2. Set(注重独一无二的性质):不允许重复的集合。
                          不会有多个元素引用相同的对象。
3. Map(用Key来搜索的专家):使用键值对存储。
                        Map会维护与Key有关联的值。
                        两个Key可以引用相同的对象，
                        但Key不能重复，典型的Key是String类型，
                        但也可以是任何对象。

## 25-2：arraylist、linkedlist区别和适用场景

1. 是否保证线程安全： ArrayList在单线程下是线程安全的，
                    多线程下由于多个线程不断抢夺资源，
                    所以会出现不安全
                    和 LinkedList 都是不同步的，也就是不保证线程安全；
2. 底层数据结构： Arraylist 底层使用的是 Object 数组；
                 LinkedList 底层使用的是 双向链表 数据结构
3. 插入和删除是否受元素位置的影响： 
   ① ArrayList 采用数组存储，所以插入和删除元素的时间复杂度受元素位置的影响。 
   ② LinkedList 采用链表存储，插入删除元素时间复杂度不受元素位置的影响，
                如果是要在指定位置i插入和删除元素的话需要先移动到指定位置再插入。
4. 是否支持快速随机访问： LinkedList 不支持高效的随机元素访问，
                        而 ArrayList 支持。
                        快速随机访问就是通过
                        元素的序号快速获取元素对象(对应于get(int index) 方法)。
5. 内存空间占用： ArrayList的空间浪费主要体现在在list列表的结尾会预留一定的容量空间，
                 而LinkedList的空间花费则体现在
                 它的每一个元素都需要消耗比ArrayList更多的空间
                 （因为要存放直接后继和直接前驱以及数据）

<font color="#986078">使用场景：</font>

当需要对数据进行对此访问的情况下选用ArrayList，
当需要对数据进行多次增加删除修改时采用LinkedList。

## 25-3：vector、Arraylist区别和适用场景

1. 线程：Vector是多线程安全的，
2. 底层：两个都是数组实现，
3. 时间复杂度：Vector类中的方法很多有synchronized进行修饰，
              这样就导致了Vector在效率上无法与ArrayList相比
4. 内存：但是当空间不足的时候，
         两个类的增加方式是不同。
         vector增长率为目前数组长度的100%,
         而arraylist增长率为目前数组长度的一部分
5. 其他：Vector可以设置增长因子，而ArrayList不可以
   
<font color="#986078">使用场景：</font>

1. 安全因素
2. 在集合中使用数据量比较大的数据

## 25-4：HashMap、Treemap、linkedHashMap区别和适用场景

1. 线程安全：都不是线程安全的
2. 底层：TreeMap的底层是红黑树，能够按照键值进行升序排列，
        而HashMap与linkedHashMap是基于哈希表实现，
3. 时间复杂度：Treemap由于是红黑树，hashmap要更快一些，
4. 内存，由于Treemap使用的是红黑树，内存要大于另外两个， 
        又因为linkedhashmap多维护了一个双向链表，也要大约hashmap
5. 其他：hashmap排序是无序的。另外两种排序有序
   
<font color="#986078">使用场景：</font>

如果你需要得到一个有序的结果时就应该使用TreeMap
（因为HashMap中元素的排列顺序是不固定的）。
除此之外，由于HashMap有更好的性能，
所以大多不需要排序的时候我们会使用HashMap。
LinkedHashMap：在需要输出的顺序和输入的顺序相同的情况下

## 25-5：HashTable、Hashmap区别和适用场景

1. HashMap 是线程不安全的，HashTable 是线程安全的；
2. 由于线程安全，所以 HashTable 的效率比不上 HashMap；
3. HashMap最多只允许一条记录的键为null，
   允许多条记录的值为null，而 HashTable不允许；
4. HashMap 默认初始化数组的大小为16，
   HashTable 为 11，前者扩容时，扩大两倍，后者扩大两倍+1；
5. HashMap 需要重新计算 hash 值，
   而 HashTable 直接使用对象的 hashCode

<font color="#986078">使用场景：</font>

1. 若在单线程中，我们往往会选择HashMap；
2. 而在多线程中，则会选择Hashtable。(02)，
3. 若不能插入null元素，则选择Hashtable；否则，可以选择HashMap。

## 25-6： ConcurrentHashMap、Hashmap区别和适用场景

1. ConcurrentHashMap对桶数组进行了分段，而HashMap并没有。
2. ConcurrentHashMap在每一个分段上都用锁进行了保护。
     HashMap没有锁机制。所以，前者线程安全的，后者不是线程安全的。
   
<font color="#986078">使用场景：</font>

1.安全因素

## 25-7： Hashset、Hashmap区别和适用场景

待定
1. 接口：实现了Map接⼝ 实现Set接⼝
2. 存储：存储键值对 仅存储对象
3. 添加元素：调⽤ put（）向map中添加元素
            调⽤ add（） ⽅法向Set中添加元素
4. 计算：HashMap使⽤键（Key）计算Hashcode     
         HashSet使⽤成员对象来计算hashcode值，
         对于两个对象来说hashcode可能相同，
         所以equals()⽅法⽤来判断对象的相等性，
   
<font color="#986078">使用场景：</font>

## 25-8：treeset、hashset区别和适用场景

1. TreeSet 是二差树实现的,
   Treeset中的数据是自动排好序的，不允许放入null值
   HashSet 是哈希表实现的,HashSet中的数据是无序的，
   可以放入null，但只能放入一个null，
   两者中的值都不能重复，就如数据库中唯一约束
2. HashSet要求放入的对象必须实现HashCode()方法，
   放入的对象，是以hashcode码作为标识的，而具有相同内容的String对象，
   hashcode是一样，所以放入的内容不能重复。
   但是同一个类的对象可以放入不同的实例	

<font color="#986078">使用场景：</font>

在我们需要排序的功能时，我们才使用TreeSet。

# 26.Collections

## 26-1：collection与collections的区别

java.util.Collection 是一个集合接口
Collections则是集合类的一个工具类/帮助类，其中提供了一系列静态方法

## 26-2：Collections有哪些静态方法

1. 排序(Sort)
2. 混排（Shuffling）
3. 反转(Reverse)
4. 替换所有的元素(Fill)
5. 拷贝(Copy)
6. 返回Collections中最小元素(min)
7. 返回Collections中最小元素(max)

## 26-3：Comparable和Comparator区别

1. 实现Comparable的类，该类就具有自身比较的功能；
   Comparator的实现，是一个外部比较工具器 

# 27.IO

## 27-1：IO流

### 27-1-1：为何还要有字符流

因为我们不知道编码类型很容易出现乱码，所以IO就提供了一个直接操作字符的接口

### 27-1-2：字节流和字符流区别

1. 字节流不会用到缓冲区(内存)的，而字符流在操作的时候是使用到缓冲区的
2. 字节流在操作文件时，即使不关闭资源，文件也能输出，
   但是如果字符流不使用close方法的话，则不会输出任何内容，
   只有在使用flush方法强制进行刷新缓冲区，这时才能在不close的情况下输出内容
3. 字节流:处理字节和字节数组或二进制对象;字符流:处理字符、字符数组或字符串。

## 27-2：IO读取

### 27-2-1：IO读取方法

1、FileInputStrem和FileOnputStream字节流逐字节读写（速度最慢）
2、FileInputStrem和FileOnputStream构造一个缓冲数组进行读写（速度提升）
3、利用字节缓冲区流BufferedInputStream和BufferedOutputStream来直接逐字节读写（速度较快）
4、利用字节缓冲区流BufferedInputStream和BufferedOutputStream通过构造一个缓冲数组进行读写（速度最快）
5、利用字符流InputStreamWriter和 OutputStreamWriter直接按字节读取
6、字符流InputStreamWriter和 OutputStreamWriter直接用缓冲区数组读写
7、字符缓冲流BufferedWriter和BufferedReader直接逐字节读写
8、字符缓冲流BufferedWriter和BufferedReader按照数组大小逐块读写
9、字符缓冲流BufferedWriter和BufferedReader按逐行读写（应用于文本读写）

### 27-2-2：将c盘的文件复制到d盘
```java
public class CopyTextFileTest {

public static void main(String[] args) {

               FileReader fr = null;

               FileWriter fw = null;


                  try {
                  //1,创建一个字符读取流读取与源数据相关联。
                  fr = new FileReader("demo.txt");
                  //2,创建一个存储数据的目的地。
                  fw = new FileWriter("copyDemo.txt");
                  //3,创建一个字符数组将读取流对象和写入流对象相连接。
                  char[] buf = new char[1024];
                  //4,每次读取的长度不一样，所以定义一个变量.
                  int len = 0;
                  //5,用循环读取文件中的数据
                  while((len= fr.read(buf)) != -1)//判断是否读取完没
                  fw.write(buf,0,len);//为了只读取有效的数据
                  } catch (Exception e) {
                  }finally{
                  try {fr.close();} catch (IOException e) {e.printStackTrace();}
                  try {fw.close();} catch (IOException e) {e.printStackTrace();}}}}
```

## 27-3：BIO\NIO\AIO

### 27-3-1：BIO\NIO\AIO定义

BIO: 同步阻塞 I/O 模式，数据的读取写入必须阻塞在一个线程内等待其完成。
NIO: NIO 是一种同步非阻塞的I/O模型
AIO: AIO 也就是NIO2。在引入了NIO的改进版,
     它是异步非阻塞的IO模型。异步IO是基于事件和回调机制实现的，
     也就是应用操作之后会直接返回，不会阻塞在那里，
     当后台处理完成，操作系统会通知相应的线程进行后续的操作。

### 27-3-2：BIO与NIO的区别

1. IO流是阻塞的，NIO流是不阻塞的。
   比如说，单线程中从通道读取数据到buffer，
   同时可以继续做别的事情，当数据读取到
   buffer中后，线程再继续处理数据。
   Java IO的各种流是阻塞的。这意味着，
   当一个线程调用 read() 或 write() 时，
   该线程被阻塞，直到一些数据被读取，
   或数据完全写入。该线程在此期间不能干其他任何事情了
2. IO面向流(Stream oriented)，
   而NIO面向缓冲区(Buffer oriented)。
   在面向流的I/O中,可以将数据直接写入或者将数据直接读到Stream对象中。
   在从流读到缓冲区，因为Buffer是一个对象，
   它包含一些要写入或者要读出的数据。
   NIO是直接读到Buffer中进行操作。
3. NIO通过Channel（通道）进行读写。
   通道是双向的，可读也可写，而流的读写是单向的。
   无论读写，通道只能和Buffer交互。因为 Buffer，通道可以异步地读写。
4. NIO有选择器，而IO没有。
   线程之间的切换对于操作系统来说是昂贵的，
   因此选择器用于使用单个线程处理多个通道提高系统效率选择器是有用的。

## 27-4：IO模型

1. 阻塞式IO模型
2. 非阻塞IO模型
3. IO复用模型
4. 信号驱动IO模型
5. 异步IO模型

### 27-4-1：IO多路复用

如果有一百万个I/O流进来，
那我们就需要开启一百万个进程一一对应处理这些I/O流，
这样会造成CPU占有率会多高，这个实现方式极其的不合理。
所以人们提出了I/O多路复用这个模型，
一个线程，通过记录I/O流的状态来同时管理多个I/O，
可以提高服务器的吞吐能力

### 27-4-2：IO多路复用实现方式

#### 27-4-2-1：三种实现方式以及优缺点

主要包括
       select
       poll
       epoll
三种方式

1. select
 select函数优缺点　
    缺点：两次拷贝耗时、轮询所有fd耗时，支持的文件描述符太小
　　优点：跨平台支持
2. poll
　　优点：连接数没有限制（链表存储）
　　缺点：大量拷贝，水平触发（当报告了fd没有被处理，会重复报告，很耗性能）
3. epoll
    优点：
         没有最大并发连接的限制
         只有活跃可用的fd才会调用callback函数
         内存拷贝是利用mmap()文件映射内存的方式加速与内核空间的消息传递，
         减少复制开销。（内核与用户空间共享一块内存）
         只有存在大量的空闲连接和不活跃的连接的时候，
         使用epoll的效率才会比select/poll高

#### 27-4-2-2：三种常用的实现方式区别

(1)select==>时间复杂度O(n)
只是知道有I/O事件发生了，却并不知道是哪那几个流，
我们只能无差别轮询所有流，找出能读出数据，
同时处理的流越多，无差别轮询时间就越长。
(2)poll==>时间复杂度O(n)
poll本质上和select没有区别，
它将用户传入的数组拷贝到内核空间，
然后查询每个fd对应的设备状态， 
但是它没有最大连接数的限制，
原因是它是基于链表来存储的.
(3)epoll==>时间复杂度O(1)
epoll可以理解为event poll，
不同于忙轮询和无差别轮询，
epoll会把哪个流发生了怎样的I/O事件通知我们。
所以我们说epoll实际上是事件驱动（每个事件关联上fd）的，
此时我们对这些流的操作都是有意义的。

## 27-5：同步、异步与阻塞、非阻塞

### 27-5-1：IO发生时涉及的对象和步骤（23期修改）

等待数据准备
将数据从内核拷贝到进程中



## 27-5-2：同步、异步与阻塞、非阻塞区别

同步：执行一个操作之后， 等待结果，
     然后执行其他后续的操作
异步：执行一个操作后，可以去执行其他的操作，
     然后等待通知再回来执行刚才没有执行完的操作
阻塞：进程给CPU传达一个任务后，
     一直等待CPU处理完成，然后执行后面的操作
非阻塞：进程给CPU传达一个任务后，
       继续处理其他的操作，隔段时间来询问之前的操作是否完成

# 28.反射

## 28-1：反射的概念

JAVA 反射机制是在运行状态中，
对于任意一个类，都能够知道这个类的所有属性和方法；
对于任意一个对象，都能够调用它的任意一个方法和属性

### 28-1-1：反射会导致性能问题呢

由于反射的时候调用了native方法，可能暂时无法准确判断
可能造成的原因也是可能是
在程序运行时操作class有关，比如需要判断是否安全、是否允许这样操作、入参是否正确
是否能够在虚拟机中找到需要反射的类、主要是这一系列判断条件导致了反射耗时；
也有可能是因为调用natvie方法，需要使用JNI接口，导致了性能问题
在四种访问方式当中，直接访问实例的方式效率最高；
其次是直接调用方法的方式；
接着是通过反射访问实例的方式；
最慢的是通过反射访问方法的方式

#### 28-1-1-1：如何避免反射导致的性能问题

不要过于频繁地使用反射，大量地使用反射会带来性能问题；
通过反射直接访问实例会比访问方法快很多，所以应该优先采用访问实例的方式。

### 28-1-2：哪些类不能反射

枚举，因为枚举类类的修饰abstract，所以没法实例化，反射也无能为力

### 28-1-3：反射优缺点

优点： 动态编译可以最大程度地支持多态，
      而多态最大的意义在于降低类的耦合性，
      因此反射的优点就很明显了:解耦以及提高代码的灵活性。

缺点： 1、性能瓶颈：反射相当于一系列解释操作，
          通知 JVM 要做的事情，
          性能比直接的 java 代码要慢很多。
      2、安全问题，让我们可以动态操作改变类的属性同时也增加了类的安全隐患。

### 28-1-4：反射的应用场景

1. 使用 JDBC 连接数据库时使用 Class.forName()通过反射加载数据库的驱动程序；
2. Spring 框架的 IOC（动态加载管理 Bean）创建对象以及 AOP（动态代理）功能都和反射有联系；
3. 动态配置实例的属性；

## 34-2：Class类的作用

Class主要是反射的源头，
不光可以取得对象所在类的信息，
也可以通过Class类的方法进行对象的实例化操作，
正常情况下，使用new关键字为对象实例化，
如果现在已经实例化好了class对象，
则就可以通过Class类中提供的newInstance()方法。

### 34-2-1：获取class对象方法

1. Object类的getClass();
2. 任何数据类型（包括基本数据类型）都有一个“静态”的class属性
3. 通过Class类的静态方法：forName(常用)

### 34-2-2：Class.forName和classloader.loadClass的区别

1. 初始化不同:
   * Class.forName()会对类初始化，而loadClass()只会装载或链接。
   * foranme在类加载的时候会执行静态代码块，loadclass只有在调用newInstance方法的时候才会执行静态代码块
2. 类加载器不同:
   * Class.forName(String)方法(只有一个参数)，哪个调用了forname就用那个类加载器
   * ClassLoader.loadClass()方法是一个实例方法，调用时需要自己指定类加载器

## 28-3：反射应用

### 28-3-1：反射实例

```java
首先创建一个类
public class Car {
    private String brand;
    private String color;
    private int maxSpeed;


通过反射思路创建

public class ReflectTest {

    public static Car initByDefaultConst() throws Throwable {

        //①通过类装载器获取Car类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.smart.reflect.Car");

        //②获取类的默认构造器对象并通过它实例化Car
        Constructor cons = clazz.getDeclaredConstructor((Class[]) null);
        Car car = (Car) cons.newInstance();

        //③通过反射方法设置属性
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "红旗CA72");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "黑色");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 200);
        return car;
    }

    public static void main(String[] args) throws Throwable {
        Car car = initByDefaultConst();
        car.introduce();
    }
}
```
### 28-3-2：反射调用类的私有方法

1. 获取类中属性及方法的信息
2. 通过反射获取类中属性及方法的信息

```java

public class ReflectionTest {
  
  public static void setObjectColor(Object obj) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAcces***ception, InvocationTargetException{
    Class cls = obj.getClass();
    //获得类的私有方法
    Method method = cls.getDeclaredMethod("privateMethod", null);
    method.setAccessible(true); //没有设置就会报错
    //调用该方法
    method.invoke(obj, null);
  }
  public static void main(String args[]) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAcces***ception, InvocationTargetException{
    setObjectColor(new MyTest());
  }
}
 //测试类 
class MyTest{
  public void setMyTest(){
    System.out.println("setMyTest");
  }
  /**
   类的私有方法
   **/
  private void privateMethod(){
    System.out.println("调用了 private Method");
  }
}
```

# 29.注解

## 29-1：元注解以及分类

定义其他注解的注解 ，共四个

1. @Target（表示该注解可以用于什么地方）
2. @Retention（表示再什么级别保存该注解信息）
3. @Documented（将此注解包含再javadoc中）
4. @Inherited（允许子类继承父类中的注解）
 
## 29-2：Java常用注解

1. @Override 表示当前方法覆盖了父类的方法
2. @Deprecation 表示方法已经过时,方法上有横线，使用时会有警告。
3. @SuppressWarnings 表示关闭一些警告信息(通知java编译器忽略特定的编译警告)
4. SafeVarargs (jdk1.7更新) 表示：专门为抑制“堆污染”警告提供的。
5. @FunctionalInterface (jdk1.8更新) 表示：用来指定某个接口必须是函数式接口，否则就会编译出错。

# 30.泛型

## 30-1：什么是泛型

1. 允许在定义类和接口的时候使⽤类型
2. 泛型可以提⾼代码的复⽤性

## 30-2：编译器如何处理泛型

1. Code specialization：在实例化一个泛型类或泛型方法时
                        都产生一份新的字节码or二进制代码。
2. Code sharing：对每个泛型类只生成唯一的一份目标代码；
                 该泛型类的所有实例都映射到这份目标代码上，
                 在需要的时候执行类型检查和类型转换。

### 30-2-1：为什么Java要用这种编译器

1. C++和C#是使用Code specialization的处理机制，他有几个缺点:
   * 导致代码膨胀。
   * 在引用类型系统中，浪费空间
2. Java编译器通过Code sharing方式为每个泛型类型创建唯一的字节码表示，
   并且将该泛型类型的实例都映射到这个唯一的字节码表示上。
   将多种泛型类形实例映射到唯一的字节码表示是通过类型擦除（type erasue）实现的。

## 30-3: 什么是类型擦除

Java的泛型基本上都是在编译器这个层次上实现的，
在生成的字节码中是不包含泛型中的类型信息的，
使用泛型的时候加上类型参数，
在编译器编译的时候会去掉，
这个过程成为类型擦除。

## 30-3-1：类型擦除过程

1. 将所有的泛型参数用最顶级的父类型进行替换。 
2. 移除所有的类型参数

## 30-4：泛型带来的问题

1. 虚拟机中没有泛型，只有普通类和普通方法,
   所有泛型类的类型参数在编译时都会被擦除,
   泛型类并没有自己独有的Class类对象。
   比如并不存在List<String>.class或是List<Integer>.class，而只有List.class。 
2. 创建泛型对象时需要指明类型，让编译器尽早的做参数检查
3. 不要忽略编译器的警告信息，那意味着潜在的ClassCastException等着你。 
4. 静态变量是被泛型类的所有实例所共享的。 
5. 泛型的类型参数不能用在Java异常处理的catch语句中。

## 30-5：泛型应用

### 30-5-1：List泛型和原始类型List之间的区别?
 
 List<Object>和原始类型List之间的区别?

1. 在编译时编译器不会对原始类型进行类型安全检查，会对带参数的类进行检查
2. 你可以把任何带参数的类型传递给原始类型List，但是list会产生编译错误

### 30-5-2：List泛型和原始类型List泛型之间的区别?

List<?>和原始类型List<Object>之间的区别?

List<?>是一个未知类型的List，而List<Object> 其实是任意类型的List。
你可以把List<String>, List<Integer>赋值给
List<?>，却不能把List<String>赋值给 List<Object>。

### 30-5-3:子类继承父类的public可以写成private吗

可以写，但是变为private之后，需要对方法重写写get/set方法

### 30-5-4：多态时是否会出现类型擦除

会出现类型擦除
编译器在编译一个继承自泛型类的子类时，
为了方法覆盖的签名匹配，保留泛型类型的多态性，会生成一个桥接方法

# 31.异常

## 31-1：异常的分类

1. Error表⽰系统级的错误，
        是java运⾏环境内部错误或者硬件问题，
        不能指望程序来处理这样的问题
2. Exception 表⽰程序需要捕捉、需要处理的常，
             是由与程序设计的不完善⽽出现的问题，
             程序必须处理的问题。

### 31-1-1：Error和Exception的区别

1. Exception是java程序运行中可预料的异常情况，
            可以获取到这种异常，并且对这种异常进行业务外的处理。
2. Error是java程序运行中不可预料的异常情况，
          这种异常发生以后，
          会直接导致JVM不可处理或者不可恢复的情况。
          所以这种异常不可能抓取QQ到，
          比如OutOfMemoryError、NoClassDefFoundError等。

## 31-2：Java中的两种异常类型是什么

Java 中有两种异常：受检查的(checked)异常和不受检查的(unchecked)异常。

1. 受检异常
这种异常在IO操作中⽐较多。
⽬的就是告诉这个⽅法的调⽤者，
我这个⽅法不保证⼀定可以成功，
是有可能找不到对应的⽂件的，
你要明确的对这种情况做特殊处理哦。
2. 非受检异常
这种异常⼀般可以理解为是代码原因导致的。
⽐如发⽣空指针、数组越界等。

### 31-2-1：他们有什么区别

1. 不受检查的异常不需要在方法或者是构造函数上声明
2. 受检查的异常必须要用 throws 语句在方法或者是构造函数上声明。

### 31-2-2：异常链

是指在进⾏⼀个异常处理时抛出了另外⼀个异常， 由此产⽣了⼀个异常链条。
该技术⼤多⽤于将“ 受检查异常” 封装成为“⾮受检查异常”或者RuntimeException。

## 31-3：什么是OOM？常见有哪些OOM

1. `Java堆溢出——OutOfMemoryError`
   原因：由于不断创建对象实例，当对象数量达到了最大堆的容量限制后产生内存溢出异常。
   解决方法：
   1)首先确认是内存泄露（Memory Leak）还是内存溢出（Memory Overflow）；
   2)如果是内存泄漏引起的，查看GC Roots引用链，找出为什么无法被垃圾回收的原因；
   3)如果是内存溢出，检查虚拟机的堆参数（-Xmx最大值和-Xms最小值），对比物理内存看是否可以调大；
2. `虚拟机栈和本地方法栈溢出——StackOverflowError`
   原因：在单线程下，虚拟机栈容量太小或者定义了大量的本地变量
   解决方法：增大虚拟机栈容量
   原因：在多线程下，大量创建新线程，会抛出OOM，每个线程的栈分配的内存越大，越容易产生；
   解决方法：减少线程产生、降低最大堆、减少栈容量；
3. `运行时常量池溢出`
   原因：代码在运行时创建了大量的常量，超出了常量池上限；
   解决方法：通过修改-XX:PermSize和-XX:MaxPermSize参数来修改方法区大小，从而修改常量池大小；
4. `方法区溢出`
   原因：在运行时，ClassLoader动态加载了大量的Class信息，超出方法区上限；
   解决方法：通过修改参数来修改方法区大小；

## 31-4：try、catch、finally执行顺序

### 31-4-1：不带return返回顺序

如果try中没有异常，则顺序为try→finally，如果try中有异常，则顺序为try→catch→finally

### 31-4-1：带return返回顺序

`如果try中带有return`
   程序执行try块中return之前代码；
   再执行finally块，最后执行try中return;
   finally块之后的语句return不再执行，因为程序在try中已经return过了。

`catch块中有return`
   程序先执行try，如果遇到异常执行catch块，
      有异常：执行catch中return之前代码，
             再执行finally语句中全部代码，
             最后执行catch块中return。 
             finally之后的return不再执行。
      无异常：执行完try再finally再return。

`try块和finally块中有return`
   无异常：程序执行try块中return之前代码；
          再执行finally块，因为finally块中有return所以提前退出，
          而不再执行try中的return；
   有异常：不执行try，顺序执行catch-finally

`catch块和finally块中有return`
   无异常：执行try后跳过catch执行finally；得到finally的返回值；
   有异常：程序执行catch块中return之前代码；
          再执行finally块，因为finally块中有return所以提前退出。
          而不再执行catch中的return。

`try块、catch块和finally块中有return`
   无异常：然后再执行finally块，
          因为finally块中有return所以提前退出。
   有异常：执行catch块中return之前代码；
          再执行finally块，因为finally块中有return所以提前退出。


# 32.String

## 32-1：string数据结构

他的底层实现是Char数组

### 32-1-1：String为什么是final的？

1. 它创建的时候HashCode就被缓存了，不需要重新计算，这样在键值对就运行很快
2. 为了线程安全，可以被多个线程调用
3. 只有字符串不变，才能实现字符串池，提高效率

### 32-1-2：String的内部属性

1. 创建一个能够容纳两个数组长度的数组
2. 使用getChars方法，将对象数组中赋值到新的数组中，偏移量为0；
3. 使用getChars()方法将，参数数组赋值到新的数组中，偏移量对象数组的长度。	 
4. 通过String构造器将数组转换成为新的字符串。

### 32-1-3：String的常用方法

1. 求字符串长度----length方法
2. 求字符串某一位置字符----charAt方法
3. 提取子串-----substring方法
4. 字符串比较-----compareTo方法
5. 字符串连接-----concat方法
6. 用于查找当前字符串中字符或子串----indexOf方法
7. 字符串中字符的大小写转换-----toLowerCase方法/toUpperCase方法
8. 字符串中字符的替换-----replace方法

### 32-1-4：subString原理

这个方法是通过new String（偏移量，数量，原字符串值）的构造方法，
进行创建对象，这个方法的好处是为了提高效率实现快速的共享，
但是由于要赋值原有的数据进行截取，
在新的截取的字符串中包含了原来的所有的内容，
占据了相应的内存，但是实际数值只是其中一部分，浪费了大量的内存空间

### 32-1-5：String长度有限制的

首先字符串的内容是由一个字符数组 char[] 来存储的，
由于数组的长度及索引是整数，
且String类中返回字符串长度的方法length() 的返回值也是int ，
所以通过查看java源码中的类Integer
我们可以看到Integer的最大范围是2^31 -1,
由于数组是从0开始的，所以数组的最大长度可以使【0~2^31】
通过计算是大概4GB。
但是通过翻阅java虚拟机手册对class文件格式的定义
以及常量池中对String类型的结构体定义
我们可以知道对于索引定义了u2，
就是无符号占2个字节，
2个字节可以表示的最大范围是2^16 -1 = 65535。
其实是65535，但是由于JVM需要1个字节表示结束指令，
所以这个范围就为65534了。
超出这个范围在编译时期是会报错的，
但是运行时拼接或者赋值的话范围是在整形的最大范围。

## 32-2：String str = new String("abc");创建了几个对象

分情况讨论：
1. 如果常量池中没有abc，会创建两个
   * 一个是new  String 创建的一个新的对象
   * 一个是常量“abc”对象的内容创建出的一个新的String对象
2. 如果常量池有，会创建一个

### 32-2-1：String str="abc",堆和常量池中的情况

因为String是不可变的，由final关键字修饰过了，
“abc”字符串，就是作为字面量（常量)写在class的常量池里。
"abc"的一个引用会被存到同样在Non Heap区的字符串常量池(String Pool)里。
而“abc”本体还是和所有对象一样，创建在Heap堆区。
因为一直有一个引用驻留在字符串常量池，所以不会被GC清理掉。
也就是这个abc对象会生存到整个线程结束。
字符串常量池的具体位置是在过去说的永生代里，方法区的外面。
等主线程开始创建str变量的时候，虚拟机就会到字符串常量池里找，
看有没有能equals("abc")的String。如果找到了，
就在栈区当前栈帧的局部变量表里创建str变量，然后把字符串常量池里对
abc对象的引用复制给str变量。
找不到的话，才会在heap堆重新创建一个对象，
然后把引用驻留到字符串常量区。然后再把引用复制栈帧的局部变量表。

### 32-2-2：String str = new String("abc");堆和常量池中的情况

因为new关键字会在Heap堆申请一块全新的内存，来创建新对象。
虽然字面还是"Hello"，但是完全不同的对象，有不同的内存地址。
运行程序用到运行了new String的类的时候，这个类文件的信息就会被解析到内存的方法区里。
class文件里常量池里大部分数据会被加载到“运行时常量池”。
String s1 = new String(“123”);，
这里要编译时首先涉及到 “123” 这个字面量，因此会先在常量池中创建 “123” 这个对象，
然后通过 new 关键字在堆中再创建一个 “123” 的对象

## 32-3：String的==与equals问题

### 32-3-1：两个st1 = "abc"相等问题

==、equals肯定是相等的
```java
public class Demo2_String {
   public static void main(String[] args) {
     String st1 = "abc";
     String st2 = "abc";
     System.out.println(st1 == st2);
     System.out.println(st1.equals(st2)); }}
```
`==比较运算符`
它可以基本数据类型和引用数据类型是否相等，
如果是基本数据类型，==比较的是值是否相等，
如果是引用数据类型，==比较的是两个对象的内存地址是否相等。
字符串不属于基本数据类型，字符串对象属于引用数据类型，
在上面把“abc”同时赋值给了st1和st2两个字符串对象，
指向的都是同一个地址，
所以第一个打印语句中的==比较输出结果是true
如果从内存过程来看的话就是
第一步、运行先编译，然后当前类.class文件加载进入内存的方法区
第二步，main方法压入栈内存
之后呢，常量池创建一个“abc”对象，产生一个内存地址
然后把“abc”内存地址赋值给main方法里的成员变量st1，
这个时候st1根据内存地址，指向了常量池中的“abc”。
因为常量池有个特点，如果发现已经存在，就不在创建重复的对象
运行到代码 String st2 =”abc”, 
由于常量池存在“abc”，所以不会再创建，
直接把“abc”内存地址赋值给了st2
最后st1和st2都指向了内存中同一个地址，
所以两者是完全相同的。

`equals的比较`，

equals是Object这个父类的方法，在String类中重写了这个equals方法，
只有当且仅当该参数不为null，
并且是与此对象表示相同字符序列的 String 对象时，结果才为 true。
由于st1和st2的值都是“abc”，两者指向同一个对象，当前字符序列相同，
所以第二行打印结果也为true。

### 32-3-2：一个创建对象，一个str1=“abc”

==是false，equals是true

```java
public class Demo2_String {
   public static void main(String[] args) {
     String st1 = new String("abc");
     String st2 = "abc";
     System.out.println(st1 == st2);
     System.out.println(st1.equals(st2));}}
```
`==`
==比较的st1和st2对象的内存地址，由于st1指向的是堆内存的地址，
st2看到“abc”已经在常量池存在，就不会再新建，
所以st2指向了常量池的内存地址，所以==判断结果输出false

### 32-3-3：一个a+b+c，一个abc

都是真
```java
public class Demo2_String {
   public static void main(String[] args) {
     String st1 = "a" + "b" + "c";
     String st2 = "abc";
     System.out.println(st1 == st2);
     System.out.println(st1.equals(st2));
   }
}
```
“a”,”b”,”c”三个本来就是字符串常量，
进行+符号拼接之后变成了“abc”，
“abc”本身就是字符串常量（Java中有常量优化机制），
所以常量池立马会创建一个“abc”的字符串常量对象，
在进行st2=”abc”,这个时候，常量池存在“abc”，
所以不再创建。
所以，不管比较内存地址还是比较字符串序列，都相等。

#### 32-3-3-1：常量优化机制

### 32-3-4：一个str1+c，一个abc

==是false，equals是true
```java
public class Demo2_String {
   public static void main(String[] args) {
     String st1 = "ab";
     String st2 = "abc";
     String st3 = st1 + "c";
     System.out.println(st2 == st3);
     System.out.println(st2.equals(st3));
   }
}
```
任何数据和字符串进行加号（+）运算，
最终得到是一个拼接的新的字符串。
而这个拼接的原理是由StringBuilder
或者StringBuffer类和里面的append方法实现拼接，
然后调用toString（）把拼接的对象转换成字符串对象，
最后把得到字符串对象的地址赋值给变量
从内存过程上来看的话就是
首先常量池创建“ab”对象，并赋值给st1，所以st1指向了“ab”
其次常量池创建“abc”对象，并赋值给st2，所以st2指向了“abc”
由于这里走的+的拼接方法，
所以第三步是使用StringBuffer类的append方法，
得到了“abc”，这个时候内存假设用0x0011表示的是一个StringBuffer对象，
调用了Object的toString方法把StringBuffer对象装换成了String对象。
把String对象（0x0022）赋值给st3
因为比较一个是“abc”，另外一个是拼接得到的“abc”，
所以equals比较，这个是输出true，

### 32-3-5：两个new String对象

==是false，equals是true
```java
public class Demo2_String {
   public static void main(String[] args) {
     String st1 = new String("abc");
     String st2 = new String("abc");
     System.out.println(st1 == st3);
     System.out.println(st1.equals(st3));
   }
}
```
str1与str2这两个对象在堆内存里分别在不同的内存地址，
是因为我们“new”一个对象的时候，内存会为它开劈一个新的内存空间
String.equal() 只看两者是否为String，长度是否相等，
以及每个字符的值是否相等，很显然str1和str2满足这三点要求，
所以返回结果为真。

## 32-3：拼接方式

1. 使用+
2. 使用concat
3. 使用StringBuilder
4. 使用StringBuffer
5. 使用StringUtils.join

## 32-4: String、StringBuffer和StringBuilder区别

1. 运行速度上：StringBuilder>StringBuffer>String(因为String每次都要生成新对象)
2. 线程安全：StringBuffer，String
3. 是否可变：只有String不可变
4. 底层实现：StringBuffer用了同步块synchronized

### 32-4-1：StringBuffer如何实现线程安全

直接通过synchronized 关键字来实现同步操作

### 32-4-2：处理数据量较大的字符串用string还是stringbuilder，为什么

Stringbuilder，操作字符串效率更高
虽然StringBuffer虽然也可以处理字符而且线程安全，但是处理字符相对Stringbuilder慢

### 32-4-3：为什么StringBuffer和StringBuilder比String更快（不变性）

1. string类设计成final类型，每次有修改操作时，都会赋值给新的对象。
2. 因为赋值给新的对象，原来的对象就不再引用，就会进行回收。
3. 因为string拼接的扩容机制，当在某个点上，会发生oom(内存用完了)


## 32-5：应用

### 32-5-1：如何把一段逗号分割的字符串转换成一个数组?

1 用正则表达式，代码大概为： String [] result = orgStr.split(“,”);
2 用 StingTokenizer 

### 32-5-2：String 和 char[] 数组谁更适合存密码

相对来说是String更合适，原因是底层有final关键字进行了修饰

# 33.枚举

## 33-1：enum线程安全

## 33-2: switch 是否可用于String类型的判断

JDK1.7开始支持

# 34.时间类

## 34-1：SimpDateFormat是线程不安全的类，如何改为线程安全

1. SimpleDateFormat变成了局部变量，就不会被多个线程同时访问到了，就避免了线程安全问题。
2. 通过加锁，使多个线程排队顺序执行。避免了并发导致的线程安全问题。
3. ThreadLocal 可以确保每个线程都可以得到单独的一个 SimpleDateFormat 的对象


# 35.Object类

## 35-1：Object类有哪些方法

一共有11种方法

1. `Object()`
   Object类的构造方法。
2. `registerNatives()`
   为了使JVM发现本机功能，
   他们被一定的方式命名。
   例如，对于java.lang.Object.registerNatives，
   对应的C函数命名为Java_java_lang_Object_registerNatives。
   通过使用registerNatives
   或者更确切地说，JNI函数RegisterNatives，
   可以命名任何你想要你的C函数。
3. clone方法
   clone()函数的用途是用来另存一个当前存在的对象。
   只有实现了Cloneable接口才可以调用该方法，
   否则抛出CloneNotSupportedException异常。
4. getClass方法
   final方法，用于获得运行时的类型。
   该方法返回的是此Object对象的
   类对象/运行时类对象Class。
   效果与Object.class相同。
5. toString方法
   toString()方法返回该对象的字符串表示
6. finalize方法
   当垃圾回收器确定不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法。
7. equals方法
   equals用来比较两个对象的内容是否相等。
   默认情况下(继承自Object类)，
   equals和==是一样的，除非被覆写(override)了。
8. hashCode方法
   该方法用来返回其所在对象的物理地址（哈希码值），
   常会和equals方法同时重写，
   确保相等的两个对象拥有相等的hashCode。
9. wait方法
  导致当前的线程等待，
  直到其他线程调用此对象的 
  notify() 方法或 notifyAll() 方法。
10. notify方法
   唤醒在此对象监视器上等待的单个线程。
11. notifyAll方法
   唤醒在此对象监视器上等待的所有线程。

### 35-1-1：XX.toString和String.valueOf()

### 35-1-1：为什么操作线程方法会在Object对象中

1. 这些方法存在于同步中；
2. 使用这些方法必须标识同步所属的锁；
3. 锁可以是任意对象，所以任意对象调用方法一定定义在Object类中。

# 36.序列化与反序列化

## 36-1：Java序列化与反序列化是什么

序列化：对象序列化的最主要的用处就
       是在传递和保存对象的时候，
       保证对象的完整性和可传递性。
       序列化是把对象转换成有序字节流，
       以便在网络上传输或者保存在本地文件中。
       核心作用是对象状态的保存与重建。
反序列化：客户端从文件中或网络上获得序列化后的对象字节流，
         根据字节流中所保存的对象状态及描述信息，
         通过反序列化重建对象。

## 36-2：为什么需要序列化与反序列化

一：对象序列化可以实现分布式对象。
   主要应用比如说：RMI(即远程调用Remote Method Invocation)
   要利用对象序列化运行远程主机上的服务，就像在本地机上运行对象时一样。
二：java对象序列化不仅保留一个对象的数据，
   而且递归保存对象引用的每个对象的数据。
   可以将整个对象层次写入字节流中，
   可以保存在文件中或在网络连接上传递。
   利用对象序列化可以进行对象的"深复制"，
   即复制对象本身及引用的对象本身。
   序列化一个对象可能得到整个对象序列。
三：序列化可以将内存中的类写入文件或数据库中。
    比如：将某个类序列化后存为文件，
    下次读取时只需将文件中的数据反序列化就
    可以将原先的类还原到内存中。
    也可以将类序列化为流数据进行传输。
    就是将一个已经实例化的类转成文件存储，
    下次需要实例化的时候只要反序列化即可
    将类实例化到内存中并保留序列化时类中的所有变量和状态。
四：对象、文件、数据，有许多不同的格式，很难统一传输和保存。
    序列化以后就都是字节流了，无论原来是什么东西，
    都能变成一样的东西，就可以进行通用的格式传输或保存，
    传输结束以后，要再次使用，就进行反序列化还原，
    这样对象还是对象，文件还是文件。

## 36-3：java对象如何实现序列化与反序列化

### 36-3-1：如何实现序列化

1. 通过实现Serializable接口

```java
    public class UserInfo implements Serializable{
    private String userName;
    private String usePass;
    ....}

public class UserInfoTest {
    
    /**
     * 序列化对象到文件
     * @param fileName
     */
    public static void serialize(String fileName){
        try {
            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fileName));
            
            out.writeObject("序列化的日期是：");//序列化一个字符串到文件
            out.writeObject(new Date());//序列化一个当前日期对象到文件
            UserInfo userInfo=new UserInfo("郭大侠","961012",21);
            out.writeObject(userInfo);//序列化一个会员对象
            
            out.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 从文件中反序列化对象
     * @param fileName
     */
    public static void deserialize(String fileName){
        try {
            ObjectInputStream in=new ObjectInputStream(new FileInputStream(fileName));
            
            String str=(String) in.readObject();//刚才的字符串对象
            Date date=(Date) in.readObject();//日期对象
            UserInfo userInfo=(UserInfo) in.readObject();//会员对象
            
            System.out.println(str);
            System.out.println(date);
            System.out.println(userInfo);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
```
2. 通过实现ExternalSeri alizable方法

因为一个类中我们只希望序列化一部分数据，
其他数据都使用transient修饰的话显得有点麻烦，
这时候我们使用externalizable接口，指定序列化的属性。

```java
//实现Externalizable接口序列化
public class UserInfo implements Externalizable{
 private String userName;
 private String usePass;
 private int userAge;

 测试函数同上
```

#### 36-2-1-1：externalizable和Serializable的区别

1. 实现serializable接口是默认序列化所有属性，如果有不需要序列化的属性使用transient修饰。
2. 实现serializable接口的对象序列化文件进行反序列化不走构造方法，
   载入的是该类对象的一个持久化状态，再将
   这个状态赋值给该类的另一个变量

#### 36-2-1-2: 什么是serialVersionUID

1. 这样做是为了serialVersionUID是用来验证版本一致性的，
   保证安全的，因为⽂件存储中的内容可能被篡改。
2. 在进⾏反序列化时， JVM会把传来的字节流中的
   serialVersionUID与本地相应实体类的
   serialVersionUID进⾏⽐较，
   如果相同就认为是⼀致的，
   可以进⾏反序列化，
   否则就会出现序列化版本不⼀致的异常

#### 36-2-1-3：序列化协议有哪些

1. COM,COM的序列化的原理利用了编译器中虚表,使得其学习成本巨大.
2. CORBA，COBRA的主要问题是版本之间兼容性较差,以及使用复杂晦涩.
3. XML&5OAP，无论是性能还是间接性比较差
4. Thrift在时空开销上不太理想
5. JSON，序列化后数据更加简洁，而且解析速度较快
6. protobuf、avro不仅兼容json格式，解析速度更快

#### 36-2-1-4：该接口并没有方法和字段，为什么只有实现了该接口的类的对象才能被序列化呢？

这是因为，在序列化操作过程中会对类型进行检查，
要求被序列化的类必须属于Enum、Array和Serializable类型其中的任何一种。

### 36-3-2：java对象如何实现反序列化

* 实现Serializable接口的对象在反序列化时不需要调用对象所在类的构造方法。
* 实现externalSerializable接口的方法在反序列化时会调用构造方法。

## 36-4：哪些不会被序列化

1. 被static修饰的属性不会被序列化
2. 对象的类名、属性都会被序列化,方法不会被序列化

## 36-5：序列化和反序列化应用场景

（1）将对象或者异常等写入文件，通过文件交互传输信息；
（2）将对象或者异常等通过网络进行传输。

# 37.JDK8新特性

1. 接口可以添加默认方法，default;
2. lambda表达式，对于接口可以直接用()->{}方式来表达，
   小括号表示方法入参，花括号内表示方法返回值，如Collections的sort()方法：
3. 函数式接口
4. 新的日期和时间API
5. 并发增强
6. 支持多重注解
7. 特性四、反射的加强 。JDK8加强了反射，它允许你直接通过反射获取参数的名字
8. Stream API
9.  JavaScript引擎Nashorn
10. Java虚拟机（JVM）的新特性,PermGen空间被移除了，取而代之的是Metaspace（JEP 122）

# 38.字符集

## 38-1：字符集种类

ASCII字符集、GB2312字符集、BIG5字符集、GB18030字符集、Unicode字符集

## 38-2：Unicode字符集

### 38-2-1：有了Unicode为啥还需要UTF-8

unicode虽然统一了字符的二进制编码，但没有规定如何存储。
如果Unicode统一规定，每个符号就要用三个或四个字节表示，
因为字符太多，只能用这么多字节才能表示完全。
一旦这么规定，那么每个英文字母前都必然有二到三个字节是0，
因为所有英文字母在ASCII中都有，都可以用一个字节表示，剩余字节位置就要补充0。
如果这样，文本文件的大小会因此大出二三倍，这对于存储来说是极大的浪费。
这样导致一个后果：出现了Unicode的多种存储方式。
UTF-8就是Unicode的一个使用方式
UTF-8使用可变长度字节来储存 Unicode字符，
例如ASCII字母继续使用1字节储存，重音文字、希腊字母或西里尔字母等使用2字节来储存，
而常用的汉字就要使用3字节。辅助平面字符则使用4字节。

### 38-2-2：UTF-8编码原理

它是一种变长的编码方式。
它可以使用1~4个字节表示一个符号，
根据不同的符号而变化字节长度。
1）对于单字节的符号，字节的第一位（字节的最高位）设为0，
后面7位为这个符号的unicode码。因此对于英语字母，UTF-8编码和ASCII码是相同的。 
2）对于n字节的符号（n>1），第一个字节的前n位都设为1，
第n+1位设为0，后面字节的前两位一律设为10。
剩下的没有提及的二进制位，全部为这个符号的unicode码。

# 39.创建对象

1. 使用new关键字
2. 使用反射的机制创建对象
   * 使用Class类的newInstance方法
   * 使用Constructor类的newInstance方法
3. 使用clone方法
   * 需要已经有一个分配了内存的源对象，创建新对象时，
     首先应该分配一个和源对象一样大的内存空间。
4. 反序列化
   * 调用ObjectInputStream类的readObject（）方法
5. 通过Unsafe实例化一个类

注：使用构造器的三种(new和反射的两种newInstance)，没用构造器的两种(clone和反序列化)
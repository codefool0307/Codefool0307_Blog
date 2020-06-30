<!--
 * @Author: your name
 * @Date: 2020-05-05 16:35:34
 * @LastEditTime: 2020-05-05 16:35:34
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \docs\3.database\3.JDBC\2-JDBC连接方式.md
 -->
# 2. JDBC连接方式

## 2.1 JDBC程序编写步骤

1. 注册驱动
2. 获取连接
3. 执行增删改查
4. 释放资源

注:

前提：准备mysql的驱动包，加载到项目中
 *  mysql-connector-java-5.1.37-bin.jar

```java
public class TestConnection {
	
	public static void main(String[] args) throws SQLException {
		//1.加载驱动
		
		DriverManager.registerDriver(new Driver());
		
		//2.获取连接
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/girls", "root", "root");

		//3.执行增删改查
		
		//3-1.编写sql语句
		//删除
        //String sql = "delete from beauty where id = 9";
		//更新
       //String sql = "update beauty set name='关晓彤' where id = 7";
		//增加
		String sql = "insert into beauty values(null,'小龙女','女','1998-1-1','110',null,3)";
		//3-2.获取执行sql语句的命令对象
		Statement statement = connection.createStatement();
		//3-3.使用命令对象指向sql语句
		int update = statement.executeUpdate(sql);
		
		//3-4.处理执行结果	
		System.out.println(update>0?"success":"failure");
		//4.关闭连接
		statement.close();
		connection.close();		
	}

}
```
那么在这个程序还是存在着几点问题：
1. new 对象加载类的不足
2. 数据库连接的耦合性过高
3. 操作或访问数据库只能通过查看sql图形化界面或者指令才能查看是否操作
4. 如果进行界面登录设计，会出现一些非法的sql语句注入问题

那么为了解决这些问题，我们一个一个来解决：


### 2.1.1 加载并注册驱动

加载驱动，把驱动类加载到内存
注册驱动，把驱动类的对象交给DriverManager管理，用于后面创建连接等使用。

类的加载时机：
  1》new 对象
  2》加载子类
  3》调用类中的静态成员
  4》通过反射
 
  使用new 对象的方式加载类的不足：
  1、属于编译期加载，如果编译期间该类不存在，则直接报编译错误，也就是依赖性太强
  2、导致Driver对象创建了两遍，效率较低
  
  采用反射的方式加载类!
  1、属于运行期加载，大大降低了类的依赖性
  2、Driver对象仅仅创建了1遍，效率较高


1、Class.forName( )
因为 Driver 接口的驱动程序类都包含了静态代码块，在这个静态代码块中，会调用 DriverManager.registerDriver() 方法来注册自身的一个实例，所以可以换一种方式来加载驱动。（即只要想办法让驱动类的这段静态代码块执行即可注册驱动类，而要让这段静态代码块执行，只要让该类被类加载器加载即可）
 
调用 Class 类的静态方法 forName()，向其传递要加载的 JDBC 驱动的类名

Class.forName("com.mysql.jdbc.Driver");//通过反射，加载与注册驱动类，解耦合（不直接依赖）

```java
public class TestJDBC1 {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//老方式  不推荐
//		DriverManager.deregisterDriver(new Driver());
		
		Class.forName("com.mysql.jdbc.Driver");	
	}

}
```

### 2.1.2 数据库连接

可以通过 DriverManager 类建立到数据库的连接Connection：

DriverManager 试图从已注册的 JDBC 驱动程序集中选择一个适当的驱动程序。

* public static Connection getConnection(String url) 
* public static Connection getConnection(String url,String user, String password)
* public static Connection getConnection(String url,Properties info)其中Properties info通常至少应该包括 "user" 和 "password" 属性

```java
public class TestJDBC2 {
	
	public static void main(String[] args) throws Exception {
		
		Properties info  = new Properties();
		info.load(new FileInputStream("src\\jdbc.properties"));
		String user = info.getProperty("user");
		String password = info.getProperty("password");
		String driver = info.getProperty("driver");
		String url = info.getProperty("url");
		
		//1.注册驱动
		Class.forName(driver);
		
		//2.获取连接
		Connection connection = DriverManager.getConnection(url, user, password);
		
		System.out.println("连接成功");
	}

}
```

### 2.1.3 操作或者访问数据库

在 java.sql 包中有 3 个接口分别定义了对数据库的调用的不同方式：
* Statement：用于执行静态 SQL 语句并返回它所生成结果的对象。 
  * PrepatedStatement：SQL 语句被预编译并存储在此对象中，然后可以使用此对象多次高效地执行该语句。
  * CallableStatement：用于执行 SQL 存储过程

int excuteUpdate(String sql)：执行更新操作INSERT、UPDATE、DELETE
ResultSet excuteQuery(String sql)：执行查询操作SELECT

* ResultSet
通过调用 Statement 对象的 excuteQuery() 方法创建该对象
ResultSet 对象以逻辑表格的形式封装了执行数据库操作的结果集，ResultSet 接口由数据库厂商实现
ResultSet 对象维护了一个指向当前数据行的游标，初始的时候，游标在第一行之前，可以通过 ResultSet 对象的 next() 方法移动到下一行
ResultSet 接口的常用方法：
  * boolean next()
  * getXxx(String columnLabel)：columnLabel使用 SQL AS 子句指定的列标签。如果未指定 SQL AS 子句，则标签是列名称
  * getXxx(int index) :索引从1开始

```java
ublic class TestJDBC3 {
	
	public static void main(String[] args) throws Exception {
		
		Properties info  = new Properties();
		info.load(new FileInputStream("src\\jdbc.properties"));
		String user = info.getProperty("user");
		String password = info.getProperty("password");
		String driver = info.getProperty("driver");
		String url = info.getProperty("url");
		
		//1.注册驱动
		Class.forName(driver);
		
		//2.获取连接
		Connection connection = DriverManager.getConnection(url, user, password);
		
		//3.执行增删改查
		//①编写sql命令
		
//		String sql = "select id,name,sex,borndate from beauty";
		//②获取执行sql的命令对象
		Statement statement = connection.createStatement();
		//③执行sql语句
		
//		boolean execute = statement.execute(sql);//执行任何sql语句
//		int update = statement.executeUpdate(sql);//执行增删改语句，返回受影响的行数
		ResultSet set = statement.executeQuery( "select id,name,sex,borndate from beauty");//执行查询语句，返回一个结果集
		
		//④处理执行后的结果
		while(set.next()){
			
			int id = set.getInt(1);
			String name = set.getString(2);
			String sex = set.getString(3);
			Date date = set.getDate(4);
			
			System.out.println(id+"\t"+name+"\t"+sex+"\t"+date);
		}
		//4.关闭连接
		
		set.close();
		statement.close();
		connection.close();
	}

}
```

### 2.1.4 preparedStatement
1、Statement的不足

（1）SQL拼接

（2）SQL注入

SQL 注入是利用某些系统没有对用户输入的数据进行充分的检查，而在用户输入数据中注入非法的 SQL 语句段或命令，从而利用系统的 SQL 引擎完成恶意行为的做法。对于 Java 而言，要防范 SQL 注入，只要用 PreparedStatement 取代 Statement 就可以了。

2、PreparedStatement概述

可以通过调用 Connection 对象的 preparedStatement(String sql) 方法获取 PreparedStatement 对象
PreparedStatement 接口是 Statement 的子接口，它表示一条预编译过的 SQL 语句

* PreparedStatement 对象所代表的 SQL 语句中的参数用问号(?)来表示，调用 PreparedStatement 对象的 setXxx() 方法来设置这些参数. setXxx() 方法有两个参数，第一个参数是要设置的 SQL 语句中的参数的索引(从 1 开始)，第二个是设置的 SQL 语句中的参数的值
* ResultSet executeQuery()执行查询，并返回该查询生成的 ResultSet 对象。
* int executeUpdate()：执行更新，包括增、删、该 

3、PreparedStatement vs Statement
* 代码的可读性和可维护性. Statement的sql拼接是个难题。
* PreparedStatement 可以防止 SQL 注入 
* PreparedStatement 可以处理Blob类型的数据
* PreparedStatement 能最大可能提高性能：（Oracle和PostgreSQL8是这样，但是对于MySQL不一定比Statement高）
* DBServer会对预编译语句提供性能优化。因为预编译语句有可能被重复调用，所以语句在被DBServer的编译器编译后的执行代码被缓存下来，那么下次调用时只要是相同的预编译语句就不需要编译，只要将参数直接传入编译过的语句执行代码中就会得到执行。

```java
@Test
	public void testPreparedStatement() throws Exception{
		Scanner input  = new Scanner(System.in);
		System.out.println("Please input username:");
		String username = input.next();
		System.out.println("Please input password:");
		String pwd = input.next();
		
		
		//----------------以下为连接数据库的步骤---------------------------
		Properties info  = new Properties();
		info.load(new FileInputStream("src\\jdbc.properties"));
		String user = info.getProperty("user");
		String password = info.getProperty("password");
		String driver = info.getProperty("driver");
		String url = info.getProperty("url");
		
		//1.注册驱动
		Class.forName(driver);
		//2.获取连接
		Connection connection = DriverManager.getConnection(url, user, password);
		
		//3.执行查询
		//3-1 编写sql
		String sql = "SELECT COUNT(*) FROM admin WHERE username =?  AND PASSWORD=?";
		//3-1 获取PreparedStatement命令对象
		PreparedStatement statement = connection.prepareStatement(sql);
		//预编译
		//3-2 设置占位符的值
		statement.setString(1, username);
		statement.setString(2, pwd);
		
		//3-3 执行sql命令
//		int update = statement.executeUpdate();//执行增删改，返回受影响的行数
		ResultSet set = statement.executeQuery();//执行查询，返回结果集
		if (set.next()) {
			int count = set.getInt(1);
			System.out.println(count>0?"Login Success!":"Login Failure!!");
		}
		
		//4.关闭
		set.close();
		statement.close();
        connection.close();
```

### 2.1.5 JDBC获取数据库自动生成主键

（1）在创建PreparedStatement对象时

原来：

PreparedStatement pst = conn.preparedStatement(sql);

现在：

PreparedStatement pst = conn.prepareStatement(orderInsert,Statement.RETURN_GENERATED_KEYS);

（2）原来执行更新

原来：

 int len = pst.executeUpdate();	

 现在：

int len = pst.executeUpdate();	

ResultSet rs = pst.getGeneratedKeys();

if(rs.next()){

	 Object key = rs.getObject(第几列);//获取自增长的键值
     
}	




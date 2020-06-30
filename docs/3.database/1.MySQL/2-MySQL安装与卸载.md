<!--
 * @Author: your name
 * @Date: 2020-04-30 10:19:38
 * @LastEditTime: 2020-04-30 10:32:20
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \docs\3.shujuku\1.MySQL\2-MySQL安装与卸载.md
 -->
 # 2 MySQL安装与卸载

 # 2.1 MySQL SerVer安装与卸载

 # 2.1.1 安装

 方式一：通过控制面板
 
方式二：通过电脑管家等软件卸载
 
方式三：通过安装包中提供的卸载功能卸载
 
2）清理残余文件
如果再次安装不成功，可以卸载后对残余文件进行清理后再安装
a）清除安装残余文件
 
b）清除数据残余文件
请在卸载前做好数据备份
 
c）清理注册表
如果前两步做了，再次安装还是失败，那么可以清理注册表
1：HKEY_LOCAL_MACHINE\SYSTEM\ControlSet001\Services\Eventlog\Application\MySQL服务 目录删除
2：HKEY_LOCAL_MACHINE\SYSTEM\ControlSet001\Services\MySQL服务 目录删除
3：HKEY_LOCAL_MACHINE\SYSTEM\ControlSet002\Services\Eventlog\Application\MySQL服务 目录删除
4：HKEY_LOCAL_MACHINE\SYSTEM\ControlSet002\Services\MySQL服务 目录删除
5：HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Services\Eventlog\Application\MySQL服务目录删除
6：HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Services\MySQL服务删除
注册表中的ControlSet001,ControlSet002,不一定是001和002,可能是ControlSet005、006之类
2、安装
（1）准备安装
 
（2）欢迎安装
 
（3）准许协议
 
（4）选择安装模式
 
Typical：表示一般常用的组件都会被安装，默认情况下安装到”C:\Program Files\MySQL\MySQL Server 5.5\”下。
Complete：表示会安装所有的组件。此套件会占用比较大的磁盘空间。
Custom：表示用户可以选择要安装的组件，可以更改默认按照的路径。这种按照类型最灵活，适用于高级用户。
（5）选择安装组件及安装路径
 
 这里可以选择安装哪些部分，主要是这里可以设置两个路径：
MySQL Server的应用软件的安装路径，默认在“C:\Program Files\MySQL\MySQL Server 5.5\”
Server data files的数据存储的目录路径，默认在“C:\ProgramData\MySQL\MySQL Server 5.5\”
 
（6）开始安装
 
安装进度
 
系统会显示MySQL Enterprise版（企业版）的一些功能介绍界面，可以单击“Next”继续。
 
 
（7）安装完成
 
单击“Finish”按钮完成安装过程。如果想马上配置数据库连接，选择“Launch the MySQL Instance Configuration Wizard”复选框。如果现在没有配置，以后想要配置或重新配置都可以在“MySQL Server”的安装目录的bin目录下（例如：D:\ProgramFiles\MySQL5.5\MySQL Server 5.5\bin）找到“MySQLInstanceConfig.exe”打开“MySQL Instance Configuration Wizard”向导。
3、MySQL的配置
（1）准备开始
 
（2）选择配置类型
 
选择配置方式，“Detailed Configuration（手动精确配置）”、“Standard Configuration（标准配置）”，我们选择“Detailed Configuration”，方便熟悉配置过程。
（3）选择MySQL的应用模式
 
Develop Machine（开发机），使用最小数量的内存
Server Machine（服务器），使用中等大小的内存
Dedicated MySQL Server Machine（专用服务器），使用当前可用的最大内存。
（4）选择数据库用途选择界面
 
选择mysql数据库的大致用途：
“Multifunctional Database（通用多功能型，好）”：此选项对事务性存储引擎（InnoDB）和非事务性（MyISAM）存储引擎的存取速度都很快。
“Transactional Database Only（服务器类型，专注于事务处理，一般）”：此选项主要优化了事务性存储引擎（InnoDB），但是非事务性（MyISAM）存储引擎也能用。
“Non-Transactional Database Only（非事务处理型，较简单）主要做一些监控、记数用，对MyISAM数据类型的支持仅限于non-transactional，注意事务性存储引擎（InnoDB）不能用。
（5）配置InnoDB数据文件目录
 
InnoDB的数据文件会在数据库第一次启动的时候创建，默认会创建在MySQL的安装目录下。用户可以根据实际的空间状况进行路径的选择。
（6）并发连接设置
 
选择您的网站的一般mysql 访问量，同时连接的数目，“Decision Support(DSS)/OLAP（决策支持系统，20个左右）”、“Online Transaction Processing(OLTP)（在线事务系统，500个左右）”、“Manual Setting（手动设置，自己输一个数）”
（7）网络选项设置
 
是否启用TCP/IP连接，设定端口，如果不启用，就只能在自己的机器上访问mysql 数据库了，我这里启用，把前面的勾打上，Port Number：3306，还有一个关于防火墙的设置“Add firewall exception ……”需要选中，将MYSQL服务的监听端口加为windows防火墙例外，避免防火墙阻断。
在这个页面上，您还可以选择“启用标准模式”（Enable Strict Mode），这样MySQL就不会允许细小的语法错误。尽量使用标准模式，因为它可以降低有害数据进入数据库的可能性。
（8）选择字符集
 
注意：如果要用原来数据库的数据，最好能确定原来数据库用的是什么编码，如果这里设置的编码和原来数据库数据的编码不一致，在使用的时候可能会出现乱码。
这个比较重要，就是对mysql默认数据库语言编码进行设置，第一个是西文编码，第二个是多字节的通用utf8编码，第三个，手工选择字符集。
提示：
如果安装时选择了字符集和“utf8”，通过命令行客户端来操作数据库时，有时候会出现乱码，
这是因为“命令行客户端”默认是GBK字符集，因此客户端与服务器端就出现了不一致的情况，会出现乱码。
可以在客户端执行：
mysql> set names gbk;  
可以通过以下命令查看：
mysql> show variables like 'character_set_%';
  
对于客户端和服务器的交互操作，MySQL提供了3个不同的参数：character_set_client、character_set_connection、character_set_results，分别代表客户端、连接和返回结果的字符集。通常情况下，这3个字符集应该是相同的，才能确保用户写入的数据可以正确的读出和写入。“set names xxx;”命令可以同时修改这3个参数的值，但是需要每次连接都重新设置。
（9）安全选择
 
选择是否将mysql 安装为windows服务，还可以指定Service Name（服务标识名称，例如我这里取名为“MySQL5.5”），是否将mysql的bin目录加入到Windows PATH环境变量中（加入后，就可以直接使用bin下的命令）”，我这里全部打上了勾。
（10）设置密码
 
这一步询问是否要修改默认root 用户（超级管理）的密码（默认为空），“New root password”如果要修改，就在此填入新密码，“Confirm（再输一遍）”内再填一次，防止输错。（如果是重装，并且之前已经设置了密码，在这里更改密码可能会出错，请留空，并将“Modify Security Settings”前面的勾去掉，安装配置完成后另行修改密码）

“Enable root access from remotemachines（是否允许root 用户在其它的机器或使用IP地址登陆，如果要安全，就不要勾上，如果要方便，就勾上它）”。如果没有勾选，默认只支持localhost和127.0.0.1连接。

最后“Create An Anonymous Account（新建一个匿名用户，匿名用户可以连接数据库，不能操作数据，包括查询，如果要有操作数据的权限需要单独分配）”，一般就不用勾了
（11）准备执行界面
 
（12）完成
 
2.3 MySQL的安装目录
	bin目录中都是可执行文件；
	my.ini文件是MySQL的配置文件；
	MySQL的数据存储目录为data
	data目录通常在C:\Documents and Settings\All Users\Application Data\MySQL\MySQL Server 5.1\data位置。
	在data下的每个目录都代表一个数据库。

2.4 MySQL环境变量的配置
将C:\Program Files (x86)\MySQL\MySQL Server 5.5\bin;添加到path中
 

第3章 MySQL的使用
1、启动和停止服务
MySQL软件的服务器端必须先启动，客户端才可以连接和使用使用数据库。

启动服务的方式：
方式一：图形化方式
“我的电脑/计算机”-->右键-->“管理”-->“服务”-->启动和关闭MySQL
“开始菜单”-->“控制面板”-->“管理工具”-->“服务”-->启动和关闭MySQL
“任务管理器”-->“服务”-->启动和关闭MySQL

      
方式二：命令行

以管理员身份运行
net  start  MySQL服务名
net  stop  MySQL服务名
2、客户端登录
方式一：MySQL自带客户端
“开始菜单”-->MySQL-->MySQL Server 5.5 --> MySQL 5.5 Command Line Client
 
仅限于root用户
方式二：命令行
mysql -h 主机名 -P 端口号 -u 用户名 -p密码
例如：mysql -h localhost -P 3306 -u root -proot	

 注意：
（1）-p与密码之间不能有空格，其他参数名与参数值之间可以有空格也可以没有空格
		mysql -hlocalhost -P3306 -uroot -proot
（2）密码建议在一行输入
		mysql -h localhost -P 3306 -u root -p
		Enter password:****
（3）如果是连本机：-hlocalhost就可以省略，如果端口号没有修改：-P3306也可以省略
		简写成：mysql -u root -p
			    Enter password:****
 
连接成功后，有关于MySQL Server服务版本的信息，还有第几次连接的id标识。
也可以在命令行通过以下方式获取MySQL Server服务版本的信息
 
或登录后，通过以下方式查看当前版本信息：
 

方式三：可视化工具
例如：Navicat Preminum，SQLyogEnt等工具
还有其他工具：mysqlfront,phpMyAdmin
（1）Navicat Preminum
 
 
（2）SQLyog
 
 


3、MySQL的基本命令
启动和关闭mysql服务
方式一：
	启动：net start mysql；
	关闭：net stop mysql；
方式二：
 

在启动mysql服务后，打开windows任务管理器，会有一个名为mysqld.exe的进程运行，所以mysqld.exe才是MySQL服务器程序。
 
客户端登录退出mysql
在启动MySQL服务器后，我们需要使用管理员用户登录MySQL服务器，然后来对服务器进行操作。登录MySQL需要使用MySQL的客户端程序：mysql.exe
	登录：mysql -u root -p root -h localhost；
	-u：后面的root是用户名，这里使用的是超级管理员root；
	-p：后面的root是密码，这是在安装MySQL时就已经指定的密码；
	-h：后面给出的localhost是服务器主机名，它是可以省略的，例如：mysql -u root -p root；
	退出：quit或exit；
在登录成功后，打开windows任务管理器，会有一个名为mysql.exe的进程运行，所以mysql.exe是客户端程序。
 


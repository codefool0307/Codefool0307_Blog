
# 1. 基础查询使用

select 查询列表 
from 表名;

类似于：System.out.println(打印东西);

特点：

1. 查询列表可以是：表中的字段、常量值、表达式、函数
2. 查询的结果是一个<font color=red size='6'>虚拟的表格</font>


## 1.1 查询表中的单个字段

```sql
SELECT last_name FROM employees;
```

## 1.2 查询表中的多个字段

```sql
SELECT last_name,salary,email FROM employees;
```

## 1.3 查询表中的所有字段

### 1.3.1 方式一：挨个输入

```sql
SELECT 
    `employee_id`,
    `first_name`,
    `last_name`,
    `phone_number`,
    `last_name`,
    `job_id`,
    `phone_number`,
    `job_id`,
    `salary`,
    `commission_pct`,
    `manager_id`,
    `department_id`,
    `hiredate` 
FROM
    employees ;
```

### 1.3.2 方式二：  

```sql
 SELECT * FROM employees;
``` 

## 1.4 查询常量值

```sql
 SELECT 100;
 SELECT 'john';
``` 

## 1.5 查询表达式

```sql
 SELECT 100%98;
```

## 1.6 查询函数
 
```sql 
 SELECT VERSION();
``` 
 
## 1.7 起别名
 
### 1.7.1 方式一：                                                                                                                               使用as

```sql
SELECT 100%98 AS 结果;
SELECT last_name AS 姓,first_name AS 名 FROM employees;
```

### 1.7.2 方式二：使用空格

```sql
SELECT last_name 姓,first_name 名 FROM employees;
```

# 1.8 去重

```sql
#案例：查询员工表中涉及到的所有的部门编号
SELECT DISTINCT department_id FROM employees;
```

# 1.9 +号与concat

mysql中的+号：
仅仅只有一个功能：运算符

```sql
select 100+90;      两个操作数都为数值型，则做加法运算
select '123'+90;    只要其中一方为字符型，试图将字符型数值转换成数值型
			        如果转换成功，则继续做加法运算
select 'john'+90;	如果转换失败，则将字符型数值转换成0
select null+10; 只要其中一方为null，则结果肯定为null
```

```sql
#案例：查询员工名和姓连接成一个字段，并显示为 姓名

SELECT 
	CONCAT(last_name,first_name) AS 姓名
FROM
	employees;
```
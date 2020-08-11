# 1.常见函数

概念类似于java的方法

select 函数名(实参列表) 【from 表】;


分类：
	
    1. 单行函数
	2. 分组函数
	
# 2.单行函数
## 2.1 字符函数

### 2.1.1 length 获取参数值的<font color=red>字节</font>个数
```sql
SELECT LENGTH('john');
SELECT LENGTH('张三丰hahaha');
```

### 2.1.2 concat 拼接字符串

```sql
SELECT CONCAT(last_name,'_',first_name) 姓名 FROM employees;
```

### 2.1.3 upper、lower 大小写

```sql
#示例：将姓变大写，名变小写，然后拼接
SELECT CONCAT(UPPER(last_name),LOWER(first_name))  姓名 FROM employees;
```

### 2.1.4 substr  截取

```sql
注意：索引从1开始
#截取从指定索引处后面所有字符
SELECT SUBSTR('李莫愁爱上了陆展元',7)  out_put;

#截取从指定索引处  读取   指定  字符长度  的字符
SELECT SUBSTR('李莫愁爱上了陆展元',1,3) out_put;
```

### 2.1.5 instr 返回子串第一次出现的索引，如果找不到返回0

```sql
SELECT INSTR('杨不殷六侠悔爱上了殷六侠','殷八侠') AS out_put;
```

### 2.1.6 trim  去除填充

```sql
SELECT TRIM('   Sample   ');
```

结果:'Sample'

```sql
SELECT LTRIM('   Sample   ');
```

结果:'Sample   '

```sql

SELECT RTRIM('   Sample   ');
```

结果:'   Sample'


### 2.1.7 lpad 用指定的字符实现左填充指定长度

```sql
SELECT LPAD('殷素素',10,'*') AS out_put;
```
注：可以左右填充

### 2.1.8 replace 替换

```sql
SELECT REPLACE('周芷若周芷若周芷若周芷若张无忌爱上了周芷若','周芷若','赵敏') AS out_put;
```


## 2.2 数学函数

### 2.2.1 round 四舍五入

```sql
SELECT ROUND(-1.55);
SELECT ROUND(1.567,2);
```

### 2.2.2 ceil 向上取整

```sql
SELECT CEIL(-1.02);
```

### 2.2.3 floor 向下取整

```sql
SELECT FLOOR(-9.99);
```


### 2.2.4 truncate 截断

```sql
SELECT TRUNCATE(1.69999,1);
```
### 2.2.5 mod取余

```sql
SELECT MOD(10,-3);
SELECT 10%3;
```

## 2.3 日期函数

### 2.3.1 now 返回当前系统日期+时间

```sql
SELECT NOW();
``` 

### 2.3.2 curdate 返回当前系统日期，不包含时间

```sql
SELECT CURDATE();
``` 

### 2.3.3 curtime 返回当前时间，不包含日期

```sql
SELECT CURTIME();
``` 

### 2.3.4 可以获取指定的部分，年、月、日、小时、分钟、秒

```sql
SELECT YEAR(NOW()) 年;
SELECT YEAR('1998-1-1') 年;

SELECT MONTH(NOW()) 月;
SELECT MONTHNAME(NOW()) 月;
```

### 2.3.5 str_to_date 字符转换为日期

```sql
SELECT STR_TO_DATE('1998-3-2','%Y-%c-%d') AS out_put;
```

### 2.3.6 date_format 字符转换为日期

```sql
SELECT DATE_FORMAT(NOW(),'%y年%m月%d日') AS out_put;
```



## 2.4 其他函数

```sql
SELECT VERSION();
SELECT DATABASE();
SELECT USER();
```

## 2.5 流程控制函数

### 2.5.1 if函数： if else 的效果

```sql
SELECT last_name,commission_pct,IF(commission_pct IS NULL,'没奖金，呵呵','有奖金，嘻嘻') 备注
FROM employees;
```

### 2.5.2 case函数


# 3.分组函数


功能：用作统计使用，又称为聚合函数或统计函数或组函数

分类：
sum 求和、avg 平均值、max 最大值 、min 最小值 、count 计算个数

特点：
1、sum、avg一般用于处理数值型
   max、min、count可以处理任何类型
2、以上分组函数都忽略null值

3、可以和distinct搭配实现去重的运算

4、count函数的单独介绍
一般使用count(*)用作统计行数

5、和分组函数一同查询的字段要求是group by后的字段

*/


#1、简单 的使用
SELECT SUM(salary) FROM employees;
SELECT AVG(salary) FROM employees;
SELECT MIN(salary) FROM employees;
SELECT MAX(salary) FROM employees;
SELECT COUNT(salary) FROM employees;


SELECT SUM(salary) 和,AVG(salary) 平均,MAX(salary) 最高,MIN(salary) 最低,COUNT(salary) 个数
FROM employees;

SELECT SUM(salary) 和,ROUND(AVG(salary),2) 平均,MAX(salary) 最高,MIN(salary) 最低,COUNT(salary) 个数
FROM employees;

#2、参数支持哪些类型

SELECT SUM(last_name) ,AVG(last_name) FROM employees;
SELECT SUM(hiredate) ,AVG(hiredate) FROM employees;

SELECT MAX(last_name),MIN(last_name) FROM employees;

SELECT MAX(hiredate),MIN(hiredate) FROM employees;

SELECT COUNT(commission_pct) FROM employees;
SELECT COUNT(last_name) FROM employees;

#3、是否忽略null

SELECT SUM(commission_pct) ,AVG(commission_pct),SUM(commission_pct)/35,SUM(commission_pct)/107 FROM employees;

SELECT MAX(commission_pct) ,MIN(commission_pct) FROM employees;

SELECT COUNT(commission_pct) FROM employees;
SELECT commission_pct FROM employees;


#4、和distinct搭配

SELECT SUM(DISTINCT salary),SUM(salary) FROM employees;

SELECT COUNT(DISTINCT salary),COUNT(salary) FROM employees;



#5、count函数的详细介绍

SELECT COUNT(salary) FROM employees;


SELECT COUNT(*) FROM employees;

SELECT COUNT(1) FROM employees;

效率：
MYISAM存储引擎下  ，COUNT(*)的效率高
INNODB存储引擎下，COUNT(*)和COUNT(1)的效率差不多，比COUNT(字段)要高一些


#6、和分组函数一同查询的字段有限制

SELECT AVG(salary),employee_id  FROM employees;
















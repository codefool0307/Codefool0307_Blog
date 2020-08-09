
# 1.条件查询语法

	select 
		查询列表
	from
		表名
	where
		筛选条件;

## 1.1 分类

1. 按条件表达式筛选
	
    简单条件运算符：> < = != <> >= <=
	
2. 按逻辑表达式筛选
	
	作用：用于连接条件表达式   and or not
	
3. 模糊查询
		
        like
		between and
		in
		is null
	

## 1.2 按条件表达式筛选

```sql

#案例1：查询工资>12000的员工信息

SELECT 
	*
FROM
	employees
WHERE
	salary>12000;
```	
	
## 1.3 按逻辑表达式筛选

```sql
#案例1：查询工资z在10000到20000之间的员工名、工资以及奖金
SELECT
	last_name,
	salary,
	commission_pct
FROM
	employees
WHERE
	salary>=10000 AND salary<=20000;
```
## 1.4 模糊查询

1. like	
2. between and
3. in
4. is null|is not null

### 1.4.1 like

特点：
①一般和通配符搭配使用
	通配符：
	% 任意多个字符,包含0个字符
	_ 任意单个字符


```sql
#案例1：查询员工名中包含字符a的员工信息

select 
	*
from
	employees
where
	last_name like '%a%';#abc

#案例2：查询员工名中第三个字符为e，第五个字符为a的员工名和工资
select
	last_name,
	salary
FROM
	employees
WHERE
	last_name LIKE '__n_l%';

#案例3：查询员工名中第二个字符为_的员工名

SELECT
	last_name
FROM
	employees
WHERE
	last_name LIKE '_$_%' ESCAPE '$';
```

### 1.4.2 between and

①使用between and 可以提高语句的简洁度
②包含临界值
③两个临界值不要调换顺序

```sql
#案例1：查询员工编号在100到120之间的员工信息

SELECT
	*
FROM
	employees
WHERE
	employee_id BETWEEN 120 AND 100;
```

### 1.4.3 in

含义：判断某字段的值是否属于in列表中的某一项
特点：
	①使用in提高语句简洁度
	②in列表的值类型必须一致或兼容
	③in列表中不支持通配符

```sql
#案例：查询员工的工种编号是 IT_PROG、AD_VP、AD_PRES中的一个员工名和工种编号

SELECT
	last_name,
	job_id
FROM
	employees
WHERE
	job_id IN( 'IT_PROT' ,'AD_VP','AD_PRES');
```

### 1.4.4 is null

=或<>不能用于判断null值
is null或is not null 可以判断null值

```sql
#案例1：查询没有奖金的员工名和奖金率
SELECT
	last_name,
	commission_pct
FROM
	employees
WHERE
	commission_pct IS NULL;


#案例1：查询有奖金的员工名和奖金率
SELECT
	last_name,
	commission_pct
FROM
	employees
WHERE
	commission_pct IS NOT NULL;
```


	
### 1.4.5 安全等于  <=>

```sql
#案例1：查询没有奖金的员工名和奖金率
SELECT
	last_name,
	commission_pct
FROM
	employees
WHERE
	commission_pct <=>NULL;
```	

注：is null pk <=>

1. IS NULL:仅仅可以判断NULL值，可读性较高，建议使用
2. <=>    :既可以判断NULL值，又可以判断普通的数值，可读性较低

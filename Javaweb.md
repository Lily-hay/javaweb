# Javaweb

## 1、前端基础知识

前后端分离开发

![web流程](D:\java codes\javaweb\笔记图片\web流程.jpg)

1、web前端

web标准，网页标准

三个组成部分：

1、HTML负责网页的的结构  2、CSS：负责网页的表现   3、JavaScript:负责网页的行为（交互效果）

HTML:超文本语言

超文本：超越文本限制，还可以定义其它内容

标记语言：标签预定义好的

CSS：层叠样式表

html快速入门

<html>

	<head>
		<title>HTML快速入门</title>
	</head>
​	<body>
​		<h1>Hello HTML</h1>

​	</body>

</html>



Vue 构建用户界面的的渐进式的js框架

Ajax 数据交换 异步交互 



## 2、后端开发

### 1、基础知识

#### 1、Maven 概念

![image-20250701205131124](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250701205131124.png)

管理和构建Java项目的工具

作用：1、项目依赖管理  2、项目构建流程(编译、测试、打包、发布)  3、统一项目结构

Meven中的仓库用来存储和管理jar包，总共有三类仓库，先从本地仓库找包，找不到去公司的远程仓库找，最后到中央仓库找

坐标：资源的唯一标识，通过该坐标可以唯一定位资源位置，使用坐标来定义项目或引入项目中所需要的依赖

groupId:组织名称，artifacted:模块名称 ，Version:版本号

如果不知道依赖的坐标信息，可以到 https://mvnrepository.com/ 中搜索

2、依赖传递

maven的依赖传递，A依赖B，B依赖C，则A依赖C

若不想要某些依赖，可用exclusions排除

依赖范围：<scope> ...</scope>  compile（默认值，全局有效）test（测试有效）

3、生命周期

clean:移除上一次构建生成的文件

compile：编译项目代码

test:使用合适的单元测试框架运行测试

package：将编译后的文件打包，如：jar，war等

install：安装项目到本地仓库

在同一套生命周期中，当运行后面的阶段时，前面的阶段都会运行

4、单元测试

单元测试（白盒）—集成测试（灰盒）—系统测试（黑盒）—验收测试

```
@DisplayName("测试年龄")
@ParameterizedTest //参数化测试
@ValueSource(strings={"138937200305062829","138937200105062829","138937200205062829"})
public void testGetAge(String id)
{
    Integer age=new UserService().getAge(id);
    System.out.println("age:"+age);
}
```

断言：assertEquals...



#### 2、Tomcat

开源免费的轻量web服务器

报错：Address already in use:bind

解决方法：

1、cmd  -ano findstr 8080查找进程号，任务管理器kill

2、改端口号，conf 里的server.xml



#### 3、Servlet

运行在web服务器中的小型服务器，一门动态web资源开发技术，一个接口

执行流程

![image-20250702174026001](C:\Users\DL\AppData\Roaming\Typora\typora-user-images\image-20250702174026001.png)

![image-20250705111417550](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250705111417550.png)

Servlet对象由Web服务器创建，Servlet方法由Web服务器调用

HttpServletRequest:用于封装请求数据

HttpServletReponse:用于封装响应数据

#### 4、HTTP协议

特点：

基于TCP协议：面向连接，安全

基于请求-响应模型的：一次请求对应一次响应

HTTP协议是无状态的协议：对于事务处理没有记忆能力。每次请求-响应都是独立的。

•缺点：多次请求间不能共享数据。

•优点：速度快

![image-20250702174344463](C:\Users\DL\AppData\Roaming\Typora\typora-user-images\image-20250702174344463.png)

![image-20250705111944509](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250705111944509.png)

第一行 请求方式资源路径 协议

分为三个部分 请求行 （第一行） 请求头（key:value） 请求体（与请求头隔一行）

![image-20250702175006376](C:\Users\DL\AppData\Roaming\Typora\typora-user-images\image-20250702175006376.png)

请求响应格式

![image-20250702193040826](C:\Users\DL\AppData\Roaming\Typora\typora-user-images\image-20250702193040826.png)

![image-20250705111852678](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250705111852678.png)

状态码：200代表成功，404代表前端错误，500表示服务端发生了不可描述对方错误



5、springbootweb

方式一：

先创建一个springboot工程

```
@RestController//标识当前类是一个请求处理类
public class HelloController {
    @RequestMapping("/hello")//设置请求路径
    public String hello() {
        System.out.println("hello........");
        return "Hello~";
    }
}
```



方式二:

1、创建一个Mawen项目

2、pom文件中，继承springboot父工程，添加web依赖

3、创建启动类，类上加注解

4、定义请求类

```
//启动类
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("Hello and welcome!");
    }
}
```

修改端口在resources新建一个文件，名字为：application.properties

```
server.port=9090
```

为什么一个main方法就将Springboot启动起来了？

因为Springboot内嵌了tomcat，引入了springboot-web起步依赖，占用8080端口

tomcat是一个Servlet容器，是如何运行我们编写的HelloController程序的？

springboot底层封装了dispatcherServlet,而dispatcherServlet实现类Servlet

Maven的packege可以将项目打包成jar包，install将包打入repo



### 2、实战案例

实战案例一：

#### 1、开发规范

功能接口文档：请求路径、请求方式、请求参数、响应数据

![image-20250703111715383](C:\Users\DL\AppData\Roaming\Typora\typora-user-images\image-20250703111715383.png)

REST风格

| REST风格url                   | 请求方式 | 含义            | 备注                                              |
| ----------------------------- | -------- | --------------- | ------------------------------------------------- |
| http://localhost:8080/users/1 | GET      | 查询id为1的用户 | URL定位资源  HTTP动词描述操作    简洁、规范、优雅 |
| http://localhost:8080/users/1 | DELETE   | 删除id为1的用户 |                                                   |
| http://localhost:8080/users   | POST     | 新增用户        |                                                   |
| http://localhost:8080/users   | PUT      | 修改用户        |                                                   |

#### 2、环境准备

测试工具apifox

查询部分

```
@RestController
public class DeptController {
    //@RequestMapping(value = "/depts",method = RequestMethod.GET)//限制请求方式
    @GetMapping("/depts")
    public List<Dept> getAll() throws Exception {
        //1.加载dept.txt数据并读取
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\java codes\\javaweb\\java147\\tlias-web-manager\\src\\main\\resources\\dept.txt"));

        ArrayList<Dept> depts = new ArrayList<>();
        String line;
        //2.解析文本中的数据，并转为集合
        while ((line = bufferedReader.readLine()) != null) {
            String[] parts = line.split(",");
            Integer id = Integer.valueOf(parts[0]);
            String name = parts[1];
            LocalDateTime time = LocalDateTime.parse(parts[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            depts.add(new Dept(id, name, time));
            
            //3.响应数据
        }
        return depts;
    }
}
```

返回的集合会自动转为json格式，因为注解@RestController=@Contraoller+ResponseBody,**ResponseBody将集合/实体对象转换为json格式，用在类上、方法上**



统一响应结果

code,msg,data (成功失败、错误信息、响应数据)



前端环境：Nginx   端口：localhost:90

反向代理，前端的地址不同于后端服务器

好处：安全、灵活、负载均衡（比较平均分配每台服务器的访问量）



#### 3、分层解耦：提高复用性

三层架构：单一职责原则

![image-20250705111019917](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250705111019917.png)

控制层：接收请求、响应数据（Controller）

业务逻辑层： 逻辑数据（Service）

数据访问层：数据访问（Dao）

为了增添不同业务而不改变已写代码，各自新增一个接口

**Springboot自带解耦方法，对象不再自己new，而是提前将对象交由容器，需要的时候直接从容器取**

**控制反转**：IOC，对象的创建控制权由程序自身转移到外部（容器）加注解@Component

**依赖注入**：DI，容器为应用程序提供运行时，所依赖的资源              加注解@Autowired

Bean对象：IOC容器中创建、管理的对象  

声明beans的注解：@Controller,@Service,@Repository,@Component

其中，在服务层上，可用@Service代替@Component，在数据层用@Repository代替@Component，但在Controller层，不能用@Component代替@ResController

依赖注入的注解：@Autowired 默认按照类型自动装配

如果同时存在多个bean对象：@Primary（在需要的bean类上使用）@Resource(name="deptServicelmpl")

@Qualifier(value = "service2")+@Autowired经我使用出错

加了注解不一定起效，要经过启动类里的注解扫描到，启动类默认扫描当前包以及子包

实现的效果：高内聚低耦合



### 3、数据库

MySQL数据模型（我的用户名root 密码13145）

关系型数据库（DBMS）：建立在关系模型的基础上，由多张相互连接的**二维表**组成的数据库

先连上服务器，然后再建库

SQL分类

| **分类** | **全称**                   | **说明**                                               |
| -------- | -------------------------- | ------------------------------------------------------ |
| DDL      | Data Definition Language   | 数据定义语言，用来定义数据库对象(数据库，表，字段)     |
| DML      | Data Manipulation Language | 数据操作语言，用来对数据库表中的数据进行增删改         |
| DQL      | Data Query Language        | 数据查询语言，用来查询数据库中表的记录                 |
| DCL      | Data Control Language      | 数据控制语言，用来创建数据库用户、控制数据库的访问权限 |

![image-20250705143659789](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250705143659789.png)

#### 1、DDL

**--** **查询所有数据库**

show databases;

**--** **查询当前数据库**

select database();

**--** **使用****/****切换数据库**

use 数据库名;

**--** **创建数据库**

create database [if not exists] 数据库名 [default charset utf8mb4];

**--** **删除数据库**

drop database [if exists] 数据库名;

database，也可以替换成 schema，数据库的名称不能相同



创建表

```
create table user(
    id int comment '唯一标识',
    username varchar(20) comment '用户名',
    name varchar(20) comment '姓名',
    age int comment '年龄',
    gender char(1) comment '性别'
) comment"用户表"
```

约束

| **约束** |                     **描述**                     | **关键字**  |
| :------: | :----------------------------------------------: | :---------: |
| 非空约束 |              限制该字段值不能为null              |  not null   |
| 唯一约束 |       保证字段的所有数据都是唯一、不重复的       |   unique    |
| 主键约束 |     主键是一行数据的唯一标识，要求非空且唯一     | primary key |
| 默认约束 |   保存数据时，如果未指定该字段值，则采用默认值   |   default   |
| 外键约束 | 让两张表的数据建立连接，保证数据的一致性和完整性 | foreign key |

主键约束可以再加auto_increment 实现自增效果，但序号不一定连续，如果删除，就会在删除的上面加；一个字段上可以添加多个约束

mysql数据类型

数值类型

|  tinyint  |  1   |                      (-128，127)                      |                          (0，255)                          | 小整数值         |                                                   |
| :-------: | :--: | :---------------------------------------------------: | :--------------------------------------------------------: | ---------------- | ------------------------------------------------- |
| smallint  |  2   |                    (-32768，32767)                    |                         (0，65535)                         | 大整数值         |                                                   |
| mediumint |  3   |                  (-8388608，8388607)                  |                       (0，16777215)                        | 大整数值         |                                                   |
|  **int**  |  4   |               (-2147483648，2147483647)               |                      (0，4294967295)                       | 大整数值         |                                                   |
|  bigint   |  8   |                    (-2^63，2^63-1)                    |                        (0，2^64-1)                         | 极大整数值       |                                                   |
|   float   |  4   |       (-3.402823466 E+38，3.402823466351  E+38)       |         0 和 (1.175494351  E-38，3.402823466 E+38)         | 单精度浮点数值   | float(5,2)：5表示整个数字长度，2 表示小数位个数   |
|  double   |  8   | (-1.7976931348623157 E+308，1.7976931348623157 E+308) | 0 和  (2.2250738585072014 E-308，1.7976931348623157 E+308) | 双精度浮点数值   | double(5,2)：5表示整个数字长度，2 表示小数位个数  |
|  decimal  |      |                                                       |                                                            | 小数值(精度更高) | decimal(5,2)：5表示整个数字长度，2 表示小数位个数 |

日期类型

|     分类     | 类型 |                 大小(byte)                 |        范围         |           格式           | 描述 |
| :----------: | :--: | :----------------------------------------: | :-----------------: | :----------------------: | :--: |
|   **date**   |  3   |          1000-01-01 至 9999-12-31          |     YYYY-MM-DD      |          日期值          |      |
|     time     |  3   |          -838:59:59 至  838:59:59          |      HH:MM:SS       |     时间值或持续时间     |      |
|     year     |  1   |                1901 至 2155                |        YYYY         |          年份值          |      |
| **datetime** |  8   | 1000-01-01 00:00:00 至 9999-12-31 23:59:59 | YYYY-MM-DD HH:MM:SS |     混合日期和时间值     |      |
|  timestamp   |  4   | 1970-01-01 00:00:01 至 2038-01-19 03:14:07 | YYYY-MM-DD HH:MM:SS | 混合日期和时间值，时间戳 |      |

字符串类型：

| char    | 0-255  bytes  | 定长字符串 性能高，浪费空间  |
| ------- | ------------- | ---------------------------- |
| varchar | 0-65535 bytes | 变长字符串  性能低，节省空间 |

如何设计表结构？

1、分析表中包含的字段、字段的类型及约束；2、创建表结构，添加基础字段（如id，create time,update time）



#### 2、DML

新增数据

**--** **指定字段添加数据**

insert into 表名(字段名1, 字段名2) values (值1, 值2); 

**--** **全部字段添加数据**

insert into 表名 values (值1, 值2, ...);

**--** **批量添加数据（指定字段）**

insert into 表名 (字段名1, 字段名2) values (值1, 值2), (值1, 值2);

**--** **批量添加数据（全部字段）**

insert into 表名 values (值1, 值2, ...), (值1, 值2, ...);



更新数据

 update emp set name='张三' where id=1;若不写条件，就更新全部的



**--** **删除数据**

delete from 表名 [where 条件];



#### 3、DQL

1、基础查询

**--** **查询多个字段**

select 字段1,字段2,字段3 from 表名;

**--** **查询所有字段****(****通配符****)**

select * from 表名;

**--** **为查询字段设置别名，****as****关键字可以省略**

select 字段1 [as 别名1], 字段2 [as 别名2] from 表名;

**--** **去除重复记录**

select distinct 字段列表 from 表名;



2、条件查询

select 字段列表 from 表名 where 条件列表 ;

| **比较运算符**       | **功能**                                     |
| -------------------- | -------------------------------------------- |
| >                    | 大于                                         |
| >=                   | 大于等于                                     |
| <                    | 小于                                         |
| <=                   | 小于等于                                     |
| =                    | 等于                                         |
| <> 或 !=             | 不等于                                       |
| between ...  and ... | 在某个范围之内(**含最小、最大值**)           |
| in(...)              | 在in之后的列表中的值，多选一                 |
| like 占位符          | 模糊匹配(**_匹配单个字符, %匹配任意个字符**) |
| is null              | 是null                                       |

| **逻辑运算符** | **功能**                    |
| -------------- | --------------------------- |
| and 或 &&      | 并且 (多个条件同时成立)     |
| or 或 \|\|     | 或者 (多个条件任意一个成立) |
| not 或 !       | 非 , 不是                   |



3、分组查询

聚合函数：将一整列数据作为一个整体，进行纵向计算

| **函数** | **功能** |
| -------- | -------- |
| count    | 统计数量 |
| max      | 最大值   |
| min      | 最小值   |
| avg      | 平均值   |
| sum      | 求和     |

```
select count(id) from emp;
select count(job) from emp;//为null的不参与计算
select count(1) from emp;
select count(*) from emp; //推荐使用，底层做过优化，效率最高
```

分组 ：**只支持查询分组字段以及聚合函数，其他的字段没有意义**

select 字段列表 from 表名 [where 条件列表] **group by 分组字段名 [having 分组后过滤条件]**;

```
-- 2. 先查询入职时间在 '2015-01-01' (包含) 以前的员工 , 并对结果根据职位分组 , 获取员工数量大于等于2的职位
select job,count(*) from emp where entry_date<='2015-01-01' group by job having count(*)>=2;
```

4、排序查询

select 字段列表 from 表名 [where 条件列表] [group by 分组字段名 having 分组后过滤条件] **order by** 排序字段 排序方式;

asc升序，desc降序，默认升序，可以不写

```
select * from emp order by entry_date asc ,update_time desc ;
```

5、分页查询

select 字段 from 表名 [where 条件] [group by 分组字段 having 过滤条件] [order by 排序字段] limit 起始索引,每页条数;

若是查询第一页，起始索引可以省略，起始索引=（查询页数-1）*展示个数

```
-- 3. 查询 第2页 员工数据, 每页展示5条记录
select * from emp limit 5,5;
```



#### 4、Java程序操作数据库

JDBC：操作关系型数据库的API，即接口

各个数据厂商实现这套接口，提供数据库驱动jar包

先引入MySQL依赖

```
//1、准备工作
//注册驱动
Class.forName("com.mysql.cj.jdbc.Driver");
//获取连接对象
Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/java147_db02","root","13145");
//获取执行对象
Statement statement = connection.createStatement();
//2、执行SQL语句
int i = statement.executeUpdate("update user set password='12345678'where id=1");
System.out.println("i=="+i);
//3、释放资源
statement.close();
connection.close();
```

注册驱动可以省略，因为**SPI（在驱动包的META-INF目录下的配置文件中配置了驱动类发全类名）**

Statement执行DML,DQL语句

executeUpdate(sql):执行DML语句，返回值为int，代表被影响的行数

executeQuery(sql):执行DQL语句，返回值为ResultSet,封装了查询结果集

参数化测试

```
@ParameterizedTest
    @CsvSource(value={"xiaoqiao,123456","zhangsan,123456"})
    public void testSearch(String uname,String pwd) throws Exception {
        //1、准备工作
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接对象
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/java147_db02","root","13145");
        //获取执行对象
        Statement statement = connection.createStatement();
        //2、执行SQL语句
        ResultSet resultSet = statement.executeQuery("select * from user where username='"+uname+"' and password='"+pwd+"'");
        while (resultSet.next()) {  //resultSet.next()可遍历
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String name=resultSet.getString("name");
            int  age = resultSet.getInt("age");
            User user = new User(id,username,password,name,age);
            System.out.println(user);
        }

        //3、释放资源
        statement.close();
        connection.close();
    }
}
```



SQL注入：**通过控制输入端来修改事先定义好的SQL语句，以达到执行代码对服务器进行攻击的方法**

PreparedStatement:预编译SQL语句并执行，可以防止SQL注入问题

```
PreparedStatement ps = connection.prepareStatement("select * from user where username=? and password=?");
//设置参数       ?表示占位符，参数传入后会做转义，看作了一个整体
ps.setString(1,uname);
ps.setString(2,pwd);
//2、执行SQL语句
ResultSet resultSet = ps.executeQuery();
```

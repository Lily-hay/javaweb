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

#### 1、数据库基础

##### 1、DDL

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



##### 2、DML

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



##### 3、DQL

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



#### 2、Java程序操作数据库

##### 1、JDBC（硬编码、繁琐、资源浪费、性能降低）

：操作关系型数据库的API，即接口

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

PreparedStatement:**预编译SQL语句并执行，可以防止SQL注入问题；性能还更好**

```
PreparedStatement ps = connection.prepareStatement("select * from user where username=? and password=?");
//设置参数       ?表示占位符，参数传入后会做转义，看作了一个整体
ps.setString(1,uname);
ps.setString(2,pwd);
//2、执行SQL语句
ResultSet resultSet = ps.executeQuery();
```



##### 2、MyBatis

对JDBC进行优化，更简洁，性能更好

步骤：

准备工作

1、创建Springboot工程，引入Mybatis相关依赖

2、准备数据库表，实体类

3、配置Mybatis(在application.prpperities中配置数据库信息)

```
spring.application.name=springboot-mybatis-quickstart
spring.datasource.url=jdbc:mysql://localhost:3306/java147_db02
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=13145
#mybatis配置，将sql语句显示在控制台,日志
mybatis.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
```

编写Mybatis程序：编写持久层接口

```
@Mapper//作用，程序启动时，会自动生成该接口的代理对象，交由IOC容器管理
public interface UserMapper {
    @Select("select * from user")
    public List<User> list();
}
```

测试

```
@SpringBootTest//会加载SpringBoot环境
public class UserMapperTest {
    @Autowired//依赖注入
    private UserMapper userMapper;
    @Test
    public void testList()
    {
        List<User> list = userMapper.list();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
```

**数据库连接池**

负责分配、管理数据库连接

允许重复使用一个现有的数据库连接，而不是重现建立一个

释放空闲时间超过最大空闲时间的连接，来避免因为没有释放而引起的数据库遗漏

优势：资源重用、提升系统响应度、避免数据连接遗漏

springboot默认Hikari

Druid(德鲁伊) 阿里提供



XML映射配置

Mybatis中，可以通过注释配置SQL语句，也可以通过XML配置SQL

规则：

1、放于resources下的XML映射文件名称与Mapper接口名称一致，放置的包的目录结构也要一致

2、XML映射文件的namespace属性为Mapper接口的全限定名一致

3、XML映射文件的sql语句中的id与mapper接口中的方法名一致，并且保持返回类型一致

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.lily.mapper.UserMapper">
    <select id="list" resultType="com.lily.entity.User">
        select * from user
    </select>
</mapper>
```

用MyBatisX插件加速开发



若不同包，需要配置XML文件映射路径

```
#配置xml与mapper接口的映射路径
mybatis.mapper-locations=classpath:mapper/*.xml //会扫描该类下所有.xml文件
```

数据封装(当表里的名字与实体类的名字不同时，不会自动封装，值为null)

```
//数据封装
//1.手动结果映射
/*@Results
        ({
                @Result(column="create_time",property = "createTime"),
                @Result(column="update_time",property = "updateTime"),

        }
        )*/
//2.数据封装2，起别名
//@Select("select id,name,create_time createTime,update_time updateTime from dept")

//数据封装方式3 全局配置，开启驼峰命名规则映射
@Select("select * from dept")
public List<Dept> list();
```

配置文件

```
mybatis.configuration.map-underscore-to-camel-case=true
```



实现部门管理删除时的请求参数

```
//方式一：原始的HttpServletRequest对象获取请求参数
/*@DeleteMapping("/depts")
public Result delete(HttpServletRequest request) throws Exception {
    String id = request.getParameter("id");
    int idInt=Integer.parseInt(id);
    System.out.println(idInt);
    return Result.success();
}*/

//方式二：通过@RequestParam注解进行参数绑定，一旦加了RequestParam，默认required=true
//则前端必须传入id参数，不传就会报错误400，bad request;将默认值改为false，则不需要
/*@DeleteMapping("/depts")
public Result delete(@RequestParam(value = "id",required = false) Integer deptId) throws Exception {
    System.out.println(deptId);
    return Result.success();
}*/

//方式三：保证请求参数名与形参变量名相同，直接接收（推荐）
@DeleteMapping("/depts")
public Result delete(Integer id) throws Exception {
    System.out.println(id);
    return Result.success();
}
```



```
@Delete("delete from dept where id=#{id}")
void delete(Integer id);
```

| **符号** | **说明**                                                 | **场景**                   | **优缺点**            |
| -------- | -------------------------------------------------------- | -------------------------- | --------------------- |
| #{…}     | 执行时，会将#{…}替换为?，生成预编译SQL，并自动设置参数值 | 参数值传递                 | 安全、性能高 （推荐） |
| ${…}     | 拼接SQL。直接将参数拼接在SQL语句中，存在SQL注入问题      | 表名、字段名动态设置时使用 | 不安全、性能低        |



新增部门数据

@RequestBody 注解用来接收json格式的数据

```
@PostMapping
public Result save(@RequestBody Dept dept)  {
    deptService.save(dept);
    return Result.success();
}
```

更新部门数据

首先要实现参数回显，根据id查询数据，再进行更新

```
//@Pathvariable 获取请求参数路径
@GetMapping("/{id}")
public Result getById(@PathVariable("id") Integer id) {
    Dept dept = deptService.getById(id);
    return Result.success(dept);
}
```

Controller层，更新

```
@PutMapping
public Result update(@RequestBody Dept dept) {
    deptService.update(dept);
    return Result.success(dept);
}
```

Servicec层，要更新更新时间

```
public void update(Dept dept) {
    dept.setUpdateTime(LocalDateTime.now());
    deptMapper.update(dept);
}
```

```
@Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
void update(Dept dept);
```



动态SQL，修改部分数据，传值就更新，不传就不更新

<if>标签，判断条件是否成立

<set>标签，可以优化，可以去除不需要的逗号

```
<update id="update">
    update dept
    <set>
        <if test="name !=null and name!=''">
            name=#{name},
        </if>
        <if test="updateTime !=null" >
            update_time=#{updateTime}
        </if>
    </set>
    where id=#{id}
</update>
```



日志技术

要配置logback.xml

| **日志级别** | **说明**                                                     | **记录方式**     |
| ------------ | ------------------------------------------------------------ | ---------------- |
| trace        | 追踪，记录程序运行轨迹 【使用很少】                          | log.trace("...") |
| debug        | 调试，记录程序调试过程中的信息，实际应用中一般将其视为最低级别 【使用较多】 | log.debug("...") |
| info         | 记录程序运行的重要信息，如：数据库连接、网络连接、io操作 【使用较多】 | log.info("...")  |
| warn         | 警告信息，可能会发生问题 【使用较多】                        | log.warn("...")  |
| error        | 错误信息 【使用较多】                                        | log.error("...") |

使用@Slf4j注解



### 3、多表关系与查询

一对多：场景，部门与员工（一个部门下有多个员工）

一对多的关系如何实现？ **在数据表中多的一方（子表）添加字段，来关联一（父表）的一方的主键**

外键约束（作用，保证多表操作中数据的一致性、完整性问题）

物理外键（frain_key）

```
alter table emp add constraint fk_emp_dept_id foreign key (dept_id) references dept(id);
```

缺点：1、影响增删改查的效率（需要检查外键关系） 2、仅用于单节点数据库，不适用于分布式、集群场景

​	   3、容易引发数据的死锁问题，消耗性能

选择逻辑外键（在业务逻辑中，解决外键问题，查询是否有关联，有则不删除）



一对一：场景 用户与身份信息的关系

实现：**在任意一方加入外键，关联另一方的主键，并且设置外键为唯一的**



多对多：课程与学生的关系

实现：**建立第三张中间表，中间表至少包含两个外键，分别关联两方的主键**



多表查询：**消除无效的笛卡尔积**，加条件

内连接：相当于查询A、B交集部分数据

左外连接：查询左表所有数据(包括两张表交集部分数据)

右外连接：查询右表所有数据(包括两张表交集部分数据)

隐式内连接与显式内连接

```
-- A. 查询所有员工的ID, 姓名 , 及所属的部门名称 (隐式、显式内连接实现)
-- 隐式内连接
select emp.id,emp.name,dept.name from emp,dept where emp.dept_id=dept.id;
-- 显式内连接
select emp.id,emp.name,dept.name  from emp inner join dept on emp.dept_id = dept.id;
select emp.id,emp.name,dept.name  from emp join dept on emp.dept_id = dept.id;
```

左外连接和右外连接

on 后面的会看作一个整体，若有其它条件，还是要用where拼接

```
-- A. 查询员工表 所有 员工的姓名, 和对应的部门名称 (左外连接)
select emp.name,d.name from emp left join dept d on emp.dept_id = d.id;

-- B. 查询部门表 所有 部门的名称, 和对应的员工名称 (右外连接)
select emp.name,dept.name from dept right join emp on emp.dept_id=dept.id;
```

子查询：SQL语句中嵌套select语句，称为嵌套查询，又称子查询。

形式：select * from t1 where column1 = (select column1 from t2 …);

```
-- 标量子查询
-- A. 查询 最早入职 的员工信息
-- 1.查询最早的入职日期
select min(entry_date) from emp ;
-- 2.查询入职日期为'2000-01-01'的员工信息
select * from emp where entry_date='2000-01-01';
-- 3.合并表
select * from emp where entry_date=(select min(entry_date) from emp);

-- B. 查询在 "阮小五" 入职之后入职的员工信息
-- 1.查询"阮小五" 入职的日期
select entry_date from emp where name='阮小五';
-- 2.合并表
select * from emp where entry_date>(select entry_date from emp where name='阮小五');

-- 列子查询
-- A. 查询 "教研部" 和 "咨询部" 的所有员工信息
-- 1.查询"教研部" 和 "咨询部"的id (2,3)
select id from dept where name='教研部' or name='咨询部';
-- 2.合并
select * from emp where dept_id in (2,3);
select * from emp where dept_id in (select id from dept where name='教研部' or name='咨询部');
-- 行子查询
-- A. 查询与 "李忠" 的薪资 及 职位都相同的员工信息 ;
-- 1.查询"李忠" 的薪资 及 职位
select salary,job from emp where name='李忠';
-- 2.合并表
select * from emp where (salary,job)=(select salary,job from emp where name='李忠');

-- 表子查询
-- A. 查询入职日期是 "2006-01-01" 之后的员工信息 , 及其部门信息
-- 1.查询入职日期是 "2006-01-01" 之后的员工
select * from emp where entry_date>'2006-01-01';
-- 2.将其看作一个临时表
select * from (select * from emp where entry_date>'2006-01-01') t1,dept t2 where t1.dept_id=t2.id;
```



#### 分页查询

分页插件

a.导入依赖 pagehelper-spring-boot-starter 【注意版本问题】
b.设置分页参数 PageHelper.startPage(page,pageSize);
c.强转对象List-->Page
d.封装分页结果对象

PageHelper 实现机制：会拦住请求，对SQL语句进行改进，加入count统计和limit限制

有了PageHelper,sql语句就只用写普通查询

注意事项：

1、**SQL语句结尾不要加分号（;）,因为它直接在后面拼接limit语句会有语法错误**；

2、**PageHepler 只会对设置分页后的第一条SQL语句进行分页处理**



动态sql 用xml文件开发

当传入的参数过多时，可建一个对象，直接传递一整个对象

在进行模糊匹配时，**#{} 放在引号(“ ”)中就失效了**，此时需要用concat拼接，如concat('%',#{name},'%')

进行条件查询时，**where要转为标签，优化条件内为空的内容**



### 4、新增员工

需求分析与梳理

![image-20250711220542138](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250711220542138.png)

新增员工经历 有多条

用sql语句forEach遍历，则要用xml开发

```
<foreach collection="exprList" item="expr" separator=",">
```

用了xml,新增员工就不能再通过注解@Options获取主键值，要统一用xml

```
<insert id="insert" useGeneratedKeys="true" keyProperty="id"> /*用了xml开发就不能再通过注解获取主键值*/
    insert into emp values (null,#{username},#{password},#{name},#{gender},
    #{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})
</insert>
```



#### 2、事务管理

**操作同时成功，同时失败**   解决同时新增员工信息和经历不同时成功导致数据不一致的问题

控制事务，场景，银行转账；下单扣减库存  步骤：

1、开启事务 start tansaction/begin

2、提交事务（全部成功）submit     or 回滚事务（只要一项失败）rollback

spring事务管理 @Transactional    可加在业务（Service）的类、方法、接口上

```
@Transactional(rollbackFor = Exception.class)//开启事务指定处理最大异常，默认只处理RunningTime Exception
```

**rollbackFor属性，控制事务处理的异常的大小**

事务的传播行为控制：propagation 一个事务方法，调用另一个事务方法时的处理 （加入或新建）

| **属性值**   | **含义**                                     |
| ------------ | -------------------------------------------- |
| REQUIRED     | 【默认值】需要事务，有则加入，无则创建新事务 |
| REQUIRES_NEW | 需要新事务，无论有无，总是创建新事务         |

 REQUIRED大部分场景

REQUIRES_NEW  ：希望两个方法在独立的事务中运行，互不影响，比如打日志

四大特性：原子性：事务是不可分割的最小单元，要么全部成功，要么全部失败

​		  一致性：必须使所有的数据都保持一致状态

​		  隔离性：保证事务在不受外部并发操作影响的独立环境下运行

​		  持久性：一旦提交或回滚，对数据的改变是永久的



#### 3、文件上传

前端上传的三要素：表单项 type="file"  表单提交方式  post     表单的enctype 属性 multipart/form-data

<form action="/upload" method="post" enctype="multipart/form-data">
    头像: <input type="file" name="file"><br>

服务端对应的配置

本地上传，问题：不能直接访问、磁盘可能会爆满、磁盘损坏

```
@PostMapping("/upload")
public Result upload(String username, Integer age, MultipartFile file) throws IOException {
    log.info("参数：{},{},{}",username, age, file.getOriginalFilename());
    //1.获取原始文件名
    String originalFilename = file.getOriginalFilename();
    //2.用UUID随机生成字符串
    String fileName= UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
    //3.将文件上传到本地
    file.transferTo(new File("D:/"+fileName));
    return Result.success(fileName);
```

上传阿里云

```
String originalFilename = file.getOriginalFilename();
log.info("原文件名：{}",originalFilename);
//2.用UUID随机生成字符串
String extName= originalFilename.substring(originalFilename.lastIndexOf("."));
String url = AliyunOSSUtils.upload(endpoint, bucketName, file.getBytes(), extName);

return Result.success(url);
```

配置endpoint和bucket

配置文件：

```
aliyun:
  oss:
    endpoint: https://oss-cn-beijing.aliyuncs.com
    bucket: lily-java147
```

#### 参数配置化：

1、使用注解注入值：

```
@Value("${aliyun.oss.endpoint}")
private String endpoint;
@Value("${aliyun.oss.bucket}")
private String bucketName;
```

2、要是要同时注入多个值，需要写一个配置类将多个属性值批量注入到bean对象中

```
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOSSProperties {
    private String endpoint;//名字需要与配置文件相同
    private String bucket;
}
```

sprtingboot支持三种文件配置：

application.properties

application.yaml

application.yml

优先级properties>yml>yaml

yml配置文件推荐，key与值之间加空格

**如果配置项的值是以0开头的，值需要使用' '引起来，因为以零开头的数据在yml中表示8进制的数据**



### 5、删除员工

接收前端传入的参数多个参数

```
@DeleteMapping("/emps")
//传入参数1： 直接用数组接
//public Result delete(Integer[] ids)
//传入参数2：用集合来接，方便后续操作
 public Result delete(@RequestParam List<Integer> ids)
```

```
@Transactional
@Override
public void delete(List<Integer> ids) {
    //1.批量删除员工信息
    empMapper.deleteBatch(ids);

    //2.批量删除员工经历 动态xml forEach
    empExprMapper.deleteBatch(ids);
}
```



编辑员工

涉及两步操作：

先回显、再修改

回显，方式一，一次性获取所有信息

则sql的类型修改为empResultMap，自定义封装返回结果

```
public Emp getById(Integer id) {
    //1.方式一 获取员工信息和员工经历
   // return empMapper.getById(id);
    //方式二
    //1.查询员工基本信息
    Emp emp=empMapper.getById2(id);
    //2.查询员工经历
    List<EmpExpr> exprList=empExprMapper.getEmpbyId(id);
    emp.setExprList(exprList);
    return emp;
}
```

更新信息

```
@Transactional
@Override
public void update(Emp emp) {
    //1.更新员工基本信息
    emp.setUpdateTime(LocalDateTime.now());
    empMapper.update(emp);

    //2.更新员工经历
    //1.根据先id删除，再根据新增
    empExprMapper.delete(emp.getId());
    List<EmpExpr> empExprList=emp.getExprList();
    if(!empExprList.isEmpty())//如果集合为空，sql语句会报错
    {
        empExprList.forEach((expr)->{
            expr.setEmpId(emp.getId());
        });
        empExprMapper.insertBatch(emp.getExprList());
    }
}
```



### 6、登录校验

1、会话技术

会话：用户打开浏览器，访问web资源，会话建立，一方断开，会话结束，在一次会话中可包含多次请求和响应

会话跟踪：维护浏览器状态的方法，服务器需要识别多次请求是否来自于同一浏览器，以便在一次会话的请求中**共享数据**

登录校验思路

![image-20250725160807090](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250725160807090.png)

跟踪方案：

1、Cookie

优点：http协议中支持的技术

生成Cookie,自动返回到浏览器（响应 Set-Cookie）、自动存到浏览器、再次请求自动携带Cookie(请求Cookie)

缺点：1、移动端app无法使用Cookie；2、不安全，用户可自己禁用Cookie；3、Cookie不能跨域（协议、IP/域名、端口不一致）

2、Session

底层基于Cookie

优点：存储在服务器，安全

缺点：1、服务器集群环境下无法使用Session;   2、Cookie的缺点

3、令牌技术

优点：1、支持PC端、移动端  2、解决集群环境下的认证问题； 3、减轻服务器的压力

JWT(jsonwebtoken)令牌组成：

第一部分：Header 包含算法签名，令牌类型

第二部分：Payload(有效载荷)  携带有效信息，做登录

第三部分：Signature(签名)  jiangheader,payload融入，并加入指定密钥，通过签名算法计算而来，保证安全性，不被篡改

生成令牌

第一步：注入依赖

```
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.9.1</version>
</dependency>
```

第二部

```
Map<String,Object> claims=new HashMap<>();
claims.put("id",1);
claims.put("username","lily");
String jwt= Jwts.builder()
        .signWith(SignatureAlgorithm.HS256,"lily")//设置算法签名，密钥
        .addClaims(claims)//声明有效信息
        .setExpiration(new Date(System.currentTimeMillis()+12*3600*1000))//设置有效时间
        .compact();//收集
```

令牌解析

```
Claims claims=Jwts.parser().setSigningKey("lily")
        .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJsaWx5IiwiZXhwIjoxNzUzNDgwNDAwfQ.hJ7CeGI2aQUwVsqgZfKKHPxKfzi9rDf7rs0x3VtiDb8")
        .getBody();
```

令牌解析失败的原因：1、令牌改动   2、令牌失效

注意事项：**JWT校验时使用的签名密钥与生成时的要相同**



#### 过滤器（Filter）

javaweb三大组件（Servlet、Filter、Listener）之一

把对资源的请求拦截下来，完成一些特殊功能，比如登录校验、统一编码处理、敏感字符处理等

步骤：1、定义一个实现类实现Filter接口

​	    2、配置，在该类上添加注解@WebFilter(urlPatterns="/*") 设置请求路径，在启动类上加上注解@ServletComponentScan扫描Servlet组件

注意事项：**如果过滤器不执行放行操作，过滤器拦截之后，就不会访问对应的资源**

```
@WebFilter(urlPatterns = "/*")//表示拦截所有请求
public class FilterDemo implements Filter {
    @Override
    //初始化方法，在web服务器启动时触发一次
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("FilterDemo init----------");
    }

    //每次拦截到请求就会触发该方法，会调用多次
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("FilterDemo doFilter-----------");
        filterChain.doFilter(servletRequest,servletResponse);//放行
    }
    //销毁方法，在web服务器正常关闭时触发一次
    @Override
    public void destroy() {
        log.info("FilterDemo destroy----------");
    }
}
```

过滤器执行过程：放行前->放行->目标资源->放行后

配置拦截路径：/*  拦截所有 /emps/* 拦截目录 

过滤器链：一个项目中有多个过滤器，默认按照过滤器字母顺序执行

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250726140440557.png" alt="image-20250726140440557" style="zoom: 50%;" />

#### 拦截器

1、先建一个Interceptor类实现HandlerInterceptor 接口，实现里面的方法

```
@Component
public class DemoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("DemoInterceptor preHandle");
        return true;//表示放行
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("DemoInterceptor postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("DemoInterceptor afterCompletion");
    }
}
```

2、写一个配置类，继承WebMvcConfigurer

```
@Configuration//声明当前类为配置类
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private DemoInterceptor demoInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("拦截器");
        registry.addInterceptor(demoInterceptor).addPathPatterns("/**");
    }
}
```

![拦截器](E:\javaprojects\javaweb\笔记图片\拦截器.png)

拦截路径设置：

/*表示一级路径     /**  全部路径

Filter与Interceptor的区别：

1、接口规范不同：过滤器要实现Filter接口，而拦截器实现HandlerInterceptor接口

2、拦截范围不同：Filter会拦截所有资源，而Interceptor只会拦截Spring环境中的资源



### 7、AOP

Aspect Oriented Programming面向（切面）特定方法编程

场景:案例中部分接口方法运行较慢，定位执行耗时较长的接口，此时需要统计每一个接口方法的实行的耗时

优势：1、减少重复代码；2、代码无侵入；3、提高开发效率；4、维护方便

引入依赖

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

SpringAOP应用场景：

1、记录系统日志；2、权限控制；3、事务管理

目标对象，在管理bean对象的过程中，主要通过底层的**动态代理机制**，对特定的方法进行编程

连接点：可以被AOP控制的方法

切入点：匹配连接点条件，通知仅会在切入点方法执行时被应用

```
@Aspect//声明切面类
@Component
public class RecordTimeAspect {
//通知
    @Around("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))") //.*连接点，即可以被调用的方法
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info("执行时间：{}", end - start);
        return result;
    }
}
```

通知（将共性逻辑抽取成一个方法）

@Around 环绕通知

@Before 前置通知

@After 后置通知

@AfterReturning  正常返回时触发

@AfterThrowing 出异常时触发



@PointCut注解  抽取公共表达式，提高复用性

```
@Pointcut("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
public void pt(){}
@Around("pt()")
```



#### 通知顺序

当有多个切面的切面点匹配到目标方法，多个通知方法都会被执行

1、不同切面类中，按照切面类的字母排序：

目标方法前的通知方法：字母靠前的排前

目标方法后的通知方法：字母靠后的排前

2、用@Order(数字)加在切面类上来控制顺序，数字越小的排在前面



#### 切入点表达式

1、根据方法签名来匹配 execution(访问修饰符？ 返回值 包名.类名.？方法名 throws 异常？)

？前的可省略

通配符：*可匹配任意一级   ..可匹配任意多级

当方法名没有共同点时，可用连接符

```
@Pointcut("execution(* com.itheima.service.impl.DeptServiceImpl.list(..)) || execution(* com.itheima.service.impl.DeptServiceImpl.getById(..))")
```

书写建议

1.所有业务业务方法名在**命名时尽量规范**  2.切入点方法**通常基于接口描述**，而不是直接描述实现类，**增强拓展性**

3.在满足业务需求时，**尽量缩小切入点的匹配范围**



2、根据@annotation切入表达式

步骤：定义一个注解类，在需要的方法上打上注解

@annotation(注解全类名)

execution切入点表达式与annotation表达式应用场景：

* 如果execution切入点表达式方便描述指定的方法，就用



连接点

可获取方法执行时的相关信息，如方法名、类名、方法参数等

对于@Around通知，获取连接点信息只能用ProceedingJoinPoint

而其他四种只能用JoinPoint,是ProceedingJoinPoint的父类型

```
public void before(JoinPoint joinPoint) {
    //获取类名
    String className = joinPoint.getTarget().getClass().getName();
    System.out.println("className = " + className);
    //获取方法签名
    Signature signature = joinPoint.getSignature();
    System.out.println("signature = " + signature);
    //获取方法名
    String methodName = joinPoint.getSignature().getName();
    System.out.println("methodName = " + methodName);
    //获取方法参数
    Object[] args = joinPoint.getArgs();
    System.out.println("args = " + Arrays.toString(args));
```



### 8、SpringBoot原理

1、属性配置

SpringBoot除了支持配置文件属性配置，还支持**Java系统属性**和**命令行参数**的方式进行属性配置

如-Dserver.port=9090   --Server.port=10010

![系统配置](E:\javaprojects\javaweb\笔记图片\系统配置.png)

优先级 --Server.port>-Dserver.port>配置文件里的

配置这两个属性之后，可以在打包后在运行时在命令行窗口直接改端口

java -Dserver.port=9090 -jar 包 --Server.port=10010

若运行时出行**没有主清单属性**，则是**没有引入打包插件依赖**



2、Bean对象

```
 @Autowired
    private ApplicationContext context;
    //获取bean对象
    @Test
    public void testGetBean(){
        //根据bean的名称获取
        DeptController bean1 = (DeptController) context.getBean("deptController");
        System.out.println("bean1 = " + bean1);
        //根据bean的类型获取
        DeptController bean2 = context.getBean(DeptController.class);
        System.out.println("bean2 = " + bean2);
        //根据bean的名称 及 类型获取
        DeptController bean3 = context.getBean("deptController", DeptController.class);
        System.out.println("bean3 = " + bean3);
    }
```



3、bean作用域

常见作用域单例 singleton(默认)    非单例prototype  bean对象无法初始化，会在启动后创建；会有多个bean对象

设置bean的作用域 ：使用@Scope("singleton")注解

默认单例的bean在容器启动时被创建

@Lazy可以延迟bean对象的初始化，本来在启动过程中加载的会在启动后加载，可加快启动速度



4、循环依赖

A类在加载时检测到依赖注入时先加载B类，而B类也依赖注入了A类，就会倒是循环依赖，导致启动失败

解决办法：1.在任意一个类中加上@Lazy，延迟另一个类的加载   2.在配置文件中设置

```
spring:
	main:
    	allow-circular-references:true
```



5、第三方bean

@Bean声明第三方bean,只作用于方法上，不推荐直接写到启动类里，重新写一个配置类

```
@Configuration//声明是配置类
public class CommonConfig {
    @Bean("SAXReader")   //作用：程序启动时，会执行该方法，并将方法的返回值对象交由IOC容器管理
    //bean的名字默认是方法名，可以通过name/value属性改名字
    public SAXReader saxReader(ServiceB serviceB) {
        return new SAXReader();
    }
}
```



6、SpringBoot原理（简单快捷）

起步依赖：引入该依赖代表了多个依赖，原理，依赖传递

自动配置

方案一：

引入依赖后，在启动类上加@@ComponentScan({"com.example","com.itheima"})，扫描到该类

方案二：@Import导入

```
//@EnableHeaderConfig//封装import注解
//@Import(MyImportSelector.class)//导入接口实现类
//@Import(HeaderConfig.class)//导入配置类
//@Import({HeaderGenerator.class, HeaderParser.class})//导入普通类
//@Import(TokenParser.class)
```

接口实现类

```
public class MyImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.example.HeaderConfig"};
    }
}
```

封装注解

```
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MyImportSelector.class)
@interface EnableHeaderConfig {
}
```



自动配置-源码跟踪

启动类上的注解@SpringBootApplication包含了三个部分：

1.@SpringBootConfiguration 与@Configuration注解相同，用来声明当前类是一个配置类

2.@ComponentScan组件扫描，默认扫描当前引导类所在包及其子包

3.@EnableAutoConfiguration 	开启自动配置，SpringBoot实现自动化配置的核心注解

自动配置原理：.@EnableAutoConfiguration 开启自动配置，下面有一个Import注解，该注解会加载META-INF下spring下面一个自动配置类的文件，存了配置文件的全类名，有一百多个配置类，会加载到方法中返回，再经过一系列的过滤，排除重复的，再加上一些条件判断，最终将留下的配置类全部注册为IOC容器的bean

启动时就自动配置了，但并不是全都使用，要满足条件

@Conditional及其衍生注解，满足给定条件后，注册对应的bean对象到Spring IOC容器中，可作用于方法上、类上

@ConditionalOnClass()  当前环境存在这个类是，才声明该bean

@ConditionalOnMissingBean  当不存在当前类型的bean时，才声明该bean

@ConditionalOnProperty(name=,havingValue=)当配置文件中存在对应的属性和值时，才注册到bean容器中

### 9、Maven高级

1、分模块设计

将项目按照供能拆分为若干个子模块，方便项目的管理维护、扩展，也方便模块间的互相调用，资源共享

2、继承

子工程可以继承父工程的配置信息，常见于依赖关系的继承，可简化依赖配置、统一管理依赖

<parent>...</parent>

步骤：

1、创建父工程，设置打包方式为pom，并继承spring-boot-starter-parent

2、在子工程中配置继承关系

3、在父工程中配置各工程共有依赖，解决重复问题

在子工程中，配置继承关系后，坐标中的groupId可省，自动继承父工程的

relativePath指定父工程的相对位置，若父子工程配置类同一依赖的不同版本，以子工程为准

```
<parent>
    <groupId>com.lily</groupId>
    <artifactId>tlias-parent</artifactId>
    <version>1.0-SNAPSHOT</version>
    <relativePath>../tlias-parent</relativePath>
</parent>
```



3、版本锁定

依赖管理，只做管理，不做依赖，在父工程中通过<dependencyManagement>进行管理，解决部分子工程的版本管理，子工程不需要再写版本号，而没有该依赖的子工程依赖也不会增加



4、聚合

将多个模块组成一个整体，同时进行项目的构建

聚合工程会将子工程放到聚合工程之下，进行统一的项目构建，一般在父工程下进行聚合

```
<modules>
    <module>../tlias-pojo</module>
    <module>../tlias-utils</module>
    <module>../tlias-web-manager</module>
</modules>
```

继承与聚合的联系与区别？

联系：继承与聚合都属于设计型模块，打包方式都是pom，是在子工程下配置继承关系

区别：1、继承用于简化依赖配置、统一管理版本依赖，在子工程配置继承关系

​	     2、聚合用于快速构建项目，在父工程下配置聚合模块


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

HttpServletRequest:用于封装请求数据

HttpServletReponse:用于封装响应数据

#### 4、HTTP协议

![image-20250702174344463](C:\Users\DL\AppData\Roaming\Typora\typora-user-images\image-20250702174344463.png)

第一行 请求方式资源路径 协议

分为三个部分 请求行 （第一行） 请求头（key:value） 请求体（与请求头隔一行）

![image-20250702175006376](C:\Users\DL\AppData\Roaming\Typora\typora-user-images\image-20250702175006376.png)

请求响应格式

![image-20250702193040826](C:\Users\DL\AppData\Roaming\Typora\typora-user-images\image-20250702193040826.png)

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

1、开发规范

功能接口文档：请求路径、请求方式、请求参数、响应数据

![image-20250703111715383](C:\Users\DL\AppData\Roaming\Typora\typora-user-images\image-20250703111715383.png)

REST风格

| REST风格url                   | 请求方式 | 含义            | 备注                                              |
| ----------------------------- | -------- | --------------- | ------------------------------------------------- |
| http://localhost:8080/users/1 | GET      | 查询id为1的用户 | URL定位资源  HTTP动词描述操作    简洁、规范、优雅 |
| http://localhost:8080/users/1 | DELETE   | 删除id为1的用户 |                                                   |
| http://localhost:8080/users   | POST     | 新增用户        |                                                   |
| http://localhost:8080/users   | PUT      | 修改用户        |                                                   |

2、环境准备

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

返回的集合会自动转为json格式，因为注解@RestController=@Contraoller+ResponseBody,ResponseBody将集合/实体对象转换为json格式，用在类上、方法上



统一响应结果

code,msg,data (成功失败、错误信息、响应数据)

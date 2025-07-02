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

## 1、基础知识

### 1、Maven 概念

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



2、Tomcat

开源免费的轻量web服务器

报错：Address already in use:bind

解决方法：

1、cmd  -ano findstr 8080查找进程号，任务管理器kill

2、改端口号，conf 里的server.xml



3、Servlet

运行在web服务器中的小型服务器，一门动态web资源开发技术，一个接口
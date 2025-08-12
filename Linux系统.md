Linux

## 1、系统目录

etc 存放系统配置文件

bin 存放二进制可执行文件

root 超级用户目录

user 存放系统应用程序

## 2、Linux常用命令

1、ls 显示指定目录下的内容

ls [-al] [dir]

-a显示所有文件，包含隐藏文件

-l将文件形态、权限、拥有者、文件大小等详细信息列出

ls常需要加入-l选项 ，则ls -l 可简写为ll

pwd 查看当前所属目录

2、cd [dirName]

cd . 当前目录，cd .. 上一个目录

3、mkdir [-p] dirName 创建文件夹

[-p]检测没有才创建，可实现多级创建

4、rm 删除文件

rm [-rf] name

-r递归删除，-f无需确认，直接删除

5、cat [-n] fileName查看文件内容

-n 显示行数 适合文件内容少

6、more fileName分页查看文件内容

操作：回车键 向下滚动一行

​	    空格键 向下滚动一屏

​	    b 返回上一层

​	   q/Ctrl+C退出

less FileName ，显示冒号时，敲/可以查自己想要的信息

head [-n] fileName展示前n行，默认展示前10行

tail [-n] fileName 展示最后 加-f 追踪

7、cp复制文件或目录

cp [-r] source dest

8、mv source dest移动

目标文件夹存在，就直接改名字，不存在就移动

9、tar 对文件打包、解包、压缩、解压

tar [-zcxvf] fileName [files]

包文件后缀为.tar表示只完成了打包，没压缩；为.tar.gz表示打包还进行了压缩

-z:代表gzip 表示对文件压缩或解压

-c:create ，创建新的包文件

-x:extract，解压

-v:verbose,显示命令执行过程

-f: file 指定包文件名称



编辑操作

vi/vim fileName

命令模式：默认模式—i/a/o—>插入模式 

插入模式—ESC—>命令模式

底行模式 

wq 保存并退出  ：q！ 不保存退出 ：set nu显示行号 ：set nonu 取消行号显示 ：n定位到第几行

底行模式 —ESC—>命令模式



查找 find 根据文件属性查找文件

find fileName -name 属性(‘*.log’等)

grep 根据指定的关键字查找文件内容

grep [-inAB] word fileName  

i:忽略大小写  n:显示在文件第几行  A：after  B:before

ps -ef 查看所有进程

as:ps -ef | grep java 查看Java相关的进程
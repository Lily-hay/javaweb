Java前端工程

前期准备：环境依赖 Node JS  

切为镜像环境

npm config set prefix  安装目录

npm config set registry https://registry.npmmirror.com

create-vue  Vue脚手架，用于快速生成一个工程化的Vue项目

包含：统一的目录结构 、本地调试、热部署、单元测试、集成打包

Vue的入口文件：main.js,APP.vue,index.html

Vue的单文件组件包括：script,template,style

ApI风格

选项式API

<script>
//选项式API
export default{
    data(){
        return {
            message: "Hello 声明式API...",
            count:0
        }
    },
    //声明方法
    methods:{
        increment(){
            this.count++
        }
    },
    //声明钩子函数，页面加载完成生效
    mounted(){
        console.log('页面加载完成！')
    }

}
</script>

<template>
    <h1>{{message}}</h1>
    <input type="button" value="点我加1" @click="increment"> {{ count }} <!-- 绑定点击事件 -->
</template>

<style scoped>
</style>

组合式API，使用得更多

<script setup>
//组合式API
import {onMounted, ref} from 'vue'
//声明响应式变量
const count=ref(0)
//声明函数
function increment(){
    count.value++  //不可再用this
}
//声明钩子函数
onMounted=>{
    console.log("页面加载完成！！！！！！")
}
</script>

<template>
    <h1>Hello 组合式API</h1>
    <input type="button" value="点我加1" @click="increment"> {{ count }} <!-- 绑定点击事件 -->
</template>

<style scoped>
</style>



typescript 指定变量类型的JavaScript

1、安装：npm install -g typescript

浏览器不能直接运行,需要编译为JS程序才可运行

let name:string

指定TS编译的目标版本：tsc  demo.ts -target esnext

2、数据类型

let usname : string ='akun';

let y_age : number=10;

let sex : boolean=true;

let email:undefined=undefined;

let phone:null=null;

let hobbies:string[]=['sing','dance','rap'];

3、联合类型

type strNumBooArr=(string|number|boolean)[];//起别名

let arr1:strNumBooArr=['A','B','C',10,23,true]

4、函数，可变参数放在最后

function getFullName(firstName:string,lastName?:string)

{

  if(lastName)

  {

​    console.log(`${firstName}.${lastName}`);

​    return;

  }

  console.log(`${firstName}`)

}



5、对象与接口，接口达到复用的效果

interface与type对比：

相同点：都可以给对象指定类型

不同点：interface只能为对象指定类型

type可以为任意类型指定别名



6、类型推定

一般作用于变量初始化，以及函数返回值

一旦初始化，类型就确定了



element-plus

网址：https://cn.element-plus.org/zh-CN/

路由 npm install vue-router@4

由三个部分组成

- VueRouter：路由器类，根据路由请求在路由视图中动态渲染选中的组件

- &lt;router-link&gt;：请求链接组件，浏览器会解析成&lt;a&gt;

- &lt;router-view&gt;：动态视图组件，用来渲染展示与路由路径对应的组件

  

 定义路由

在 `src/router/index.ts` 中定义路由表信息，在其中主要是定义请求路径与组件之间的对应关系。 完整的文件内容如下：

```
import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('../views/layout/index.vue')
    },
    {
      path: '/index',
      name: 'index',
      component: () => import('../views/index/index.vue')
    }
  ]
})

export default router
```

 在 `App.vue` 根组件中，定义 `<RouterView></RouterView>` 标签

该标签将用于显示，访问的请求路径对应的组件

<template>
  <RouterView></RouterView>
</template>

嵌套路由

 

```
 component: () => import('../views/layout/index.vue'),
      redirect: '/index',//重定向
      children: [
        {
          path: 'index',
          name: 'index',
          component: () => import('../views/index/index.vue') //首页
        },
```

在vue组件中相应区域展示

<el-menu router> 加上router后，会自动进行路径映射

<el-main>
	<RouterView></RouterView>
</el-main>


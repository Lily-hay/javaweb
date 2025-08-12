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
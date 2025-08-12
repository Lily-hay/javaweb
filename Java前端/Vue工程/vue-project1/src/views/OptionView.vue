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
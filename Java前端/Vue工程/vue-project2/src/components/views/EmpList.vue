<script setup>
import axios from 'axios'
import { onMounted, reactive,ref } from 'vue'

const formEmp = reactive({
  id:'',
  name: '',
  image:'',
  gender: '',
  job: '',
  entrydate:'',
  updatetime:''
})

const EmpList = ref([])

const search = () => {
  console.log('正在查询中!')
  axios.get(`https://web-server.itheima.net/emps/list?name=${formEmp.name}&gender=${formEmp.gender}&job=${formEmp.job}`).then((result)=>{
    console.log(result.data.data);
    EmpList.value=result.data.data
  })
}
const clean = () => {
  console.log('清空!')
}
onMounted(()=>{
  search();
})
</script>

<template>
<el-form :inline="true" :model="formEmp" class="demo-form-inline">
    <el-form-item label="姓名">
      <el-input v-model="formEmp.name" placeholder="请输入姓名" clearable />
    </el-form-item>
    <el-form-item label="性别">
      <el-select
        v-model="formEmp.gender"
        placeholder="请选择"
        clearable
      >
        <el-option label="男" value="1" />
        <el-option label="女" value="2" />
      </el-select>
    </el-form-item>
    <el-form-item label="职位">
      <el-select
        v-model="formEmp.job"
        placeholder="请选择"
        clearable
      >
        <el-option label="班主任" value="1" />
        <el-option label="讲师" value="2" />
        <el-option label="其他" value="3" />
      </el-select>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="search">查询</el-button>
      <el-button type="primary" @click="clean">清空</el-button>
    </el-form-item>
  </el-form>

  <!-- 表格 -->
   <el-table :data="EmpList" border style="width: 100%">
    <el-table-column prop="id" label="ID" width="100" align="center"/>
    <el-table-column prop="name" label="姓名" width="100" align="center"/>
    <el-table-column prop="image" label="头像" width="100" align="center">
      <!-- 插槽 -->
      <template #default="scope">
        <img :src="scope.row.image" width="50px">
      </template>
    </el-table-column>
    <el-table-column prop="gender" label="性别" width="100" align="center">
      <template #default="scope">
        {{scope.row.gender==1?'男':'女'}}
      </template>
    </el-table-column>
    <el-table-column prop="job" label="职位" width="100" align="center">
      <template #default="scope">
        <span v-if="scope.row.job==1">班主任</span>
        <span v-else-if="scope.row.job==2">讲师</span>
        <span v-else>其他</span>
      </template>
    </el-table-column>
    
    <el-table-column prop="entryDate" label="入职日期" width="100" align="center"/>
    <el-table-column prop="updateTime" label="更新时间" align="center"/>
  </el-table>
</template>

<style  scoped>
.demo-form-inline .el-input {
  --el-input-width: 220px;
}

.demo-form-inline .el-select {
  --el-select-width: 220px;
}
</style>
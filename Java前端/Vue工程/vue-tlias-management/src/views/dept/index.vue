<script setup lang="ts">
import { onMounted, ref } from 'vue';
import type { DeptModel,DeptModelArray } from '@/api/model/model';
import axios from 'axios';
import {addApi,QueryAllApi,getDeptApi, updateApi,deleteDeptApi} from '@/api/model/dept'
import { ElMessage, ElMessageBox } from 'element-plus';



  const deptList = ref<DeptModelArray>([])
  /* 查询部门 */
  const queryAll=async () =>{
    //const result=await axios.get('https://m1.apifoxmock.com/m1/6710024-0-default/depts');
  let  result=await QueryAllApi();
    console.log(result);
    deptList.value=result.data;
  }


  onMounted(()=>{
    queryAll();
  })

let dialogFormVisible=ref(false)
let deptForm=ref<DeptModel>({name:''})
let formtitle=ref("")
const add=()=>{
  dialogFormVisible.value=true;
  formtitle.value='新增部门';
  deptForm.value={name:''};//清空数据
}
/* 新增部门 */
const save=async ()=>{
  console.log(deptForm.value)
  //1.发送请求
  let result=null;
  if(deptForm.value.id){
    result=await updateApi(deptForm.value);
    ElMessage.success('修改成功');
  }else{
    result=await addApi(deptForm.value);
    ElMessage.success('新增成功')
     
   }   
   //2.保存数据 
     if(result.code)
    {
      dialogFormVisible.value=false;
      queryAll();
    }else{
      ElMessage.error('result.msg')
    }  
}

/* 修改部门 */
const update=async(id:number)=>{
  dialogFormVisible.value=true;
  formtitle.value='修改部门';
  deptForm.value={name:''};//清空数据
  console.log("id=",id);
  let result=await getDeptApi(id);
    if(result.code)
  {
    deptForm.value=result.data;
  }
  }

  /* 根据id删除数据 */
  const deleteById=async(id:number)=> {
    ElMessageBox.confirm(
    '您确认是否要删除数据?',
    '删除部门',
    {
      confirmButtonText: '确认',
      cancelButtonText: '取消',
      type: 'warning',
    }
  ).then(async() => {
    let result=await deleteDeptApi(id);
    if(result.code)
      {
        ElMessage({
        type: 'success',
        message: '删除成功',
      })
      queryAll();
      }else
      {
        ElMessage.error(result.msg);
      }
    })
    .catch(() => {
      ElMessage({
        type: 'info',
        message: '取消删除',
      })
    })
    
  }
</script>

<template>
  <h1>部门管理</h1><br>
  <!-- 按钮 -->
   <el-button type="primary" style="float: right" @click="add">+新增部门</el-button>
   <br><br>
   <!-- 表格 -->
  <el-table :data="deptList" border style="width: 100%" >
    <el-table-column type="index" label="序号" width="150" align="center"/>
    <el-table-column prop="name" label="部门名称" width="200" align="center"/>
    <el-table-column prop="updateTime" label="最后操作时间" width="300" align="center"/>
    <el-table-column prop="address" label="操作" align="center">
      <template #default="scope">
        <el-button size="small" type="success" @click="update(scope.row.id)">编辑</el-button>
        <el-button size="small" type="danger" @click="deleteById(scope.row.id)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
  <!-- 增加|修改对话框 -->
   <el-dialog v-model="dialogFormVisible" :title="formtitle" width="500">
    <el-form :model="deptForm">
      <el-form-item label="部门名称" >
        <el-input v-model="deptForm.name" autocomplete="off" />
      </el-form-item>
    </el-form>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="save">
          确定
        </el-button>
      </div>
    </template>
  </el-dialog>
</template>

<style scoped>

</style>

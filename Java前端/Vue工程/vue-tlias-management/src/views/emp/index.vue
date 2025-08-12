<script setup lang="ts">
import { addApi, queryPageApi  as queryPageApi} from '@/api/model/emp';
import {type EmpExprModel, type DeptModelArray, type EmpModel, type EmpModelArray, type PaginationParam, type SearchEmpModel } from '@/api/model/model';
import { onMounted, ref, watch } from 'vue';
import { QueryAllApi as queryDeptPageApi} from '@/api/model/dept';
import { ElMessage,type FormInstance,type FormRules,type UploadProps } from 'element-plus';
const searchEmp=ref<SearchEmpModel>({
  name: '',
  gender: '',
  begin: '',
  end: '',
  date: []
})

/* watch 侦听函数  只要值发生改变，就会触发  deep深度监听，可监测对象的全部属性*/
/* watch(searchEmp,(newVal,oldVal)=>{
  console.log("date:",searchEmp.value.date)
},{deep:true}) */

/* 监听单个属性值 */
//给begin,end赋值
watch(()=>searchEmp.value.date,(newVal,oldVal)=>{
  console.log("date:",searchEmp.value.date)
  if(newVal)
    {
      searchEmp.value.begin=newVal[0];
      searchEmp.value.end=newVal[1];
    }else{
      searchEmp.value.begin='';
      searchEmp.value.end='';
    }
    console.log("begin:,end:",searchEmp.value.begin,searchEmp.value.end)
})

//展示列表数据
const empList=ref<EmpModelArray>([]);
const pagination=ref<PaginationParam>({
  currentPage: 1,
  pageSize: 5,
  total: 0
});
/* 当页面发生改变时触发 */
const handleSizeChange = (pageSize: number) => {
  console.log(`${pageSize} items per page`)
  pagination.value.pageSize=pageSize
  pageQuery();
}
const handleCurrentChange = (page: number) => {
  console.log(`current page: ${page}`)
  pagination.value.currentPage=page;
  pageQuery();
}
/* 分页查询 */
const pageQuery=async()=>{
  let result=await queryPageApi(searchEmp.value.begin,searchEmp.value.end,
  searchEmp.value.gender,searchEmp.value.name,pagination.value.currentPage,pagination.value.pageSize);
  if(result.code)
  {
    empList.value=result.data.rows;
    pagination.value.total=result.data.total;
  }
}
onMounted(()=>{
  pageQuery();
  querAllDepts();
})

/* 清空查询项 */
const clean=()=>{
searchEmp.value=
  {
    name: '',
  gender: '',
  begin: '',
  end: '',
  date: []
  }
  pageQuery();
}

/* -----------新增员工------------------------------------------ */

const dialogFormVisible=ref<boolean>(false);
const emp=ref<EmpModel>({
  username: '',
  password: '',
  name: '',
  gender: '',
  phone: '',
  job: '',
  salary: '',
  image: '',
  entryDate: '',
  deptId: '',
  exprList: []
});
const labelWidth="80px";

//职位列表数据
const jobs = ref([{ name: '班主任', value: 1 },{ name: '讲师', value: 2 },{ name: '学工主管', value: 3 },{ name: '教研主管', value: 4 },{ name: '咨询师', value: 5 },{ name: '其他', value: 6 }])

//性别列表数据
const genders = ref([{ name: '男', value: 1 }, { name: '女', value: 2 }])

const deptlist=ref<DeptModelArray>([]);
//查询部门数据
const querAllDepts=async()=>{
  let result=await queryDeptPageApi();
  deptlist.value=result.data;
}

/* 文件上传 */

const handleAvatarSuccess: UploadProps['onSuccess'] = (
  response,
  uploadFile
) => {
  console.log("response=",response);
  console.log("uploadFile=",uploadFile);
  emp.value.image = response.data;
}

const beforeAvatarUpload: UploadProps['beforeUpload'] = (rawFile) => {
  if (rawFile.type !== 'image/jpeg') {
    ElMessage.error('图片格式不对!')
    return false
  } else if (rawFile.size / 1024 / 1024 > 2) {
    ElMessage.error('图像大小不能超过2MB!')
    return false
  }
  return true
}

/* 点击新增员工时展示对话框，并清空对话空 */
const add=()=>{
  dialogFormVisible.value=true;
  emp.value={
    username: '',
    password: '',
    name: '',
    gender: '',
    phone: '',
    job: '',
    salary: '',
    image: '',
    entryDate: '',
    deptId: '',
    exprList: []
  }
}

/* 添加工作经历 */
const addWorkExpr=(expr:EmpExprModel)=>{
  
  emp.value.exprList.push({
    exprDate: [],
    begin: '',
    end: '',
    company: '',
    job: ''
  });
}
/* 删除工作经历 */
const deleteWorkExpr=(expr:EmpExprModel)=>{
  //获取当前删除的下标
  const start=emp.value.exprList.indexOf(expr);
  //删除当前
  if(start!=-1)
  {
    emp.value.exprList.splice(start,1);
  }
}

/* 监听empList对象是否有变化 */
watch(emp,(newVal,oldVal)=>{
  if(emp.value.exprList)
  {
    emp.value.exprList.forEach((expr)=>{
      console.log(expr.exprDate);
      expr.begin=expr.exprDate[0];
      expr.end=expr.exprDate[1];
    })
  }
},{deep:true})

/* 保存员工数据 */
const save=async(formEl: FormInstance | undefined)=>{
  
   if (!formEl) return
  formEl.validate((valid) => {
      if (valid) {
        if(result.code)
      {
        ElMessage("操作成功");
        dialogFormVisible.value = false;
        pageQuery();
      }
      else
      {
        ElMessage(result.msg);
      }
      console.log('submit!')
    } else {
      console.log('error submit!')
    }
  })
  const result=await addApi(emp.value)
 
}

/* 表单校验规则 */
const empFormRef = ref<FormInstance>();
const rules = ref<FormRules<EmpModel>>({
  username: [
    { required: true, message: '用户名为必填项', trigger: 'blur' },
    { min: 2, max: 20, message: '用户名长度为2-20个字', trigger: 'blur' }
  ],
  name: [
    { required: true, message: '姓名为必填项', trigger: 'blur' },
    { min: 2, max: 10, message: '姓名长度为2-10个字', trigger: 'blur' }
  ],
  gender: [{ required: true, message: '性别为必填项', trigger: 'change' }],
  phone: [
    { required: true, message: '手机号为必填项', trigger: 'blur' },
    { pattern: /^1[3-9]\d{9}$/g, message: '请输入合法的手机号', trigger: 'blur' }
  ],
  salary: [
    { pattern: /^[1-9]\d*$/g, message: '请输入合法的数字', trigger: 'blur' }
  ]
})
</script>

<template>
  <h1>员工管理</h1><br>
  <el-form :inline="true" :model="searchEmp" class="demo-form-inline">
      <el-form-item label="姓名">
        <el-input v-model="searchEmp.name" placeholder="请输入姓名"/>
      </el-form-item>
  
      <el-form-item label="性别">
        <el-select v-model="searchEmp.gender" placeholder="请选择">
          <el-option label="男" value="1" />
          <el-option label="女" value="2" />
        </el-select>
      </el-form-item>
  
      <el-form-item label="入职时间">
        <el-date-picker
          v-model="searchEmp.date"
          type="daterange"
          range-separator="到"
          start-placeholder="开始时间"
          end-placeholder="结束时间"
          value-format="YYYY-MM-DD"
        />
      </el-form-item>
  
      <el-form-item>
        <el-button type="primary" @click="pageQuery">查询</el-button>
        <el-button @click="clean">清空</el-button>
      </el-form-item>
    </el-form>
  
    <!-- 功能按钮 -->
    <el-button type="success" @click="add">+ 新增员工</el-button>
    <el-button type="danger" @click="">- 批量删除</el-button>
    <br><br>
  
  <!-- 列表展示 -->
  <el-table :data="empList" border style="width: 100%" fit >
    <el-table-column prop="name" label="姓名" align="center" width="130px" />
    <el-table-column prop="gender" label="性别" align="center" width="100px">
      <template #default="scope">
          {{scope.row.gender==1?'男':'女'}}
      </template>
    </el-table-column>
    <el-table-column prop="image" label="头像" align="center">
      <template #default="scope">
          <img :src="scope.row.image" width="50px">
      </template>
    </el-table-column>
    <el-table-column prop="deptName" label="所属部门" align="center" />
    <el-table-column prop="job" label="职位" align="center" width="100px">
      <template #default="scope">
          <span v-if="scope.row.job==1">班主任</span>
          <span v-else-if="scope.row.job==2">讲师</span>
          <span v-else-if="scope.row.job==3">学工主管</span>
          <span v-else-if="scope.row.job==4">教研主管</span>
          <span v-else>咨询师</span>
      </template>
    </el-table-column>
    <el-table-column prop="entryDate" label="入职时间" align="center" width="130px" />
    <el-table-column prop="updateTime" label="最后修改时间" align="center" />
    <el-table-column label="操作" align="center">
      <template #default="scope">
        <el-button type="primary" size="small" @click="">编辑</el-button>
        <el-button type="danger" size="small" @click="">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
  <br>

  <!-- 分页组件Pagination -->
  <el-pagination
    v-model:current-page="pagination.currentPage"
    v-model:page-size="pagination.pageSize"
    :page-sizes="[5, 10, 20, 50, 100]"
    layout="total, sizes, prev, pager, next, jumper"
    :total="pagination.total"
    @size-change="handleSizeChange"
    @current-change="handleCurrentChange"
  />

  <!-- 新增员工 / 修改员工的 DiaLog对话框 -->
  <el-dialog v-model="dialogFormVisible" title="新增员工">
    <el-form :model="emp" ref="empFormRef" :rules="rules">
      <!-- 第一行 -->
      <el-row>
        <el-col :span="12">
          <el-form-item label="用户名" :label-width="labelWidth" prop="username">
            <el-input v-model="emp.username" placeholder="请输入用户名2-20位"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="姓名" :label-width="labelWidth" prop="name">
            <el-input v-model="emp.name" placeholder="请输入姓名 2-10位"/>
          </el-form-item>
        </el-col>
      </el-row>
      
      <!-- 第二行 -->
      <el-row>
        <el-col :span="12">
          <el-form-item label="
          性别" :label-width="labelWidth" prop="gender">
            <el-select v-model="emp.gender" placeholder="请选择" style="width: 100%;">
              <!-- 循环遍历 -->
              <el-option v-for="(gender,index) in genders" :key="index"  :label="gender.name" :value="gender.value"/>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="手机号" :label-width="labelWidth" prop="phone">
            <el-input v-model="emp.phone" placeholder="请输入合法的手机号"/>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第三行 -->
      <el-row>
        <el-col :span="12">
          <el-form-item label="薪资" :label-width="labelWidth" prop="salary">
            <el-input v-model="emp.salary" placeholder="请输入合法的数字"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="入职日期" :label-width="labelWidth">
            <el-date-picker v-model="emp.entryDate" type="date" placeholder="请选择入职日期" value-format="YYYY-MM-DD" style="width: 100%;"/>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第四行 -->
      <el-row>
        <el-col :span="12">
          <el-form-item label="所属部门" :label-width="labelWidth">
            <el-select v-model="emp.deptId" placeholder="请选择" style="width: 100%;">
              <el-option v-for="(dept,index) in deptlist" :key="index" :label="dept.name" :value="dept.id" />
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="职位" :label-width="labelWidth">
            <el-select v-model="emp.job" placeholder="请选择" style="width: 100%;">
              <el-option v-for="(job,index) in jobs" :key="index" :label="job.name" :value="job.value" />
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第五行 -->
      <el-row>
        <el-col :span="12">
          <el-form-item label="头像"  :label-width="labelWidth">
            <!-- 文件上传 -->
             <!-- action 文件上传路径
                  on-success上传成功后会触发的钩子函数 
                  before-upload上传前会触发的钩子函数 -->
            <el-upload
              class="avatar-uploader"
              action="/api/upload"
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
              :before-upload="beforeAvatarUpload"
            >
              <img v-if="emp.image" :src="emp.image" class="avatar" width="50px"/>
              <el-icon v-else class="avatar-uploader-icon"><Plus /></el-icon>
            </el-upload>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第六行 -->
      <el-row>
        <el-col :span="24">
          <el-form-item label="工作经历" :label-width="labelWidth">
            <el-button type="success" size="small" @click="addWorkExpr">+ 添加工作经历</el-button>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第七行 -->
      <el-row :gutter="5" v-for="(expr,index) in emp.exprList" :key="index" >
        <el-col :span="10">
          <el-form-item label="时间" size="small" :label-width="labelWidth">
            <el-date-picker v-model="expr.exprDate" type="daterange" range-separator="至" start-placeholder="开始时间" end-placeholder="结束时间" value-format="YYYY-MM-DD"/>
          </el-form-item>
        </el-col>
        
        <el-col :span="6">
          <el-form-item  label="公司" size="small">
            <el-input v-model="expr.company" placeholder="公司名称"/>
          </el-form-item>
        </el-col>

        <el-col :span="6">
          <el-form-item label="职位" size="small">
            <el-input v-model="expr.job" placeholder="职位名称"/>
          </el-form-item>
        </el-col>

        <el-col :span="2">
          <el-form-item size="small">
            <el-button type="danger" @click="deleteWorkExpr(expr)">- 删除</el-button>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>

    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="save(empFormRef)">确定</el-button>
      </span>
    </template>
  </el-dialog>

  
</template>

<style scoped>
.avatar-uploader .el-upload {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}

.avatar-uploader .el-upload:hover {
  border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 78px;
  height: 78px;
  text-align: center;
  border: 1px dashed;
}
</style>
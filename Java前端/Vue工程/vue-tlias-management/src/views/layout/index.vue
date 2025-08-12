<script setup lang="ts">
import { RouterView } from 'vue-router'

</script>

<template>
  <div class="common-layout">
    <el-container>
        <!-- 头部 -->
      <el-header class="header">
        <span class="title"><b>Tlias 智能学习辅助系统</b></span>
        <span class="right_tool">
            <a href=""><el-icon><EditPen /></el-icon>修改密码&nbsp;&nbsp;|&nbsp;&nbsp;</a> 
            <a href=""><el-icon><SwitchButton /></el-icon>退出登录</a>
        </span>
    </el-header>
    <!-- 左侧 -->
      <el-container>
        <!-- 菜单 -->
        <el-aside width="200px">
            <el-scrollbar>
            <el-menu router>
            <el-menu-item index="/index">
              <el-icon><Promotion /></el-icon>首页
              
            </el-menu-item>   
            <el-sub-menu index="/message">
                <template #title>
                <el-icon><el-icon><Menu /></el-icon></el-icon>班级学员管理
                </template>
                <el-menu-item-group>
                <el-menu-item index="/clazz"><el-icon><HomeFilled /></el-icon>班级管理</el-menu-item>
                <el-menu-item index="/stu"><el-icon><Avatar /></el-icon>学员管理 </el-menu-item>
                </el-menu-item-group>
            </el-sub-menu>
             <!-- 系统信息管理 -->
              <el-sub-menu index="/system">
                <template #title>
                  <el-icon><Tools /></el-icon>系统信息管理
                </template>
                <el-menu-item index="/dept">
                  <el-icon><HelpFilled /></el-icon>部门管理
                </el-menu-item>
                <el-menu-item index="/emp">
                  <el-icon><Avatar /></el-icon>员工管理
                </el-menu-item>
              </el-sub-menu>

              <!-- 数据统计管理 -->
              <el-sub-menu index="/report">
                <template #title>
                  <el-icon><Histogram /></el-icon>数据统计管理
                </template>
                <el-menu-item index="/empReport">
                  <el-icon><InfoFilled /></el-icon>员工信息统计
                </el-menu-item>
                <el-menu-item index="/stuReport">
                  <el-icon><Share /></el-icon>学员信息统计
                </el-menu-item>
                <el-menu-item index="/log">
                  <el-icon><Document /></el-icon>日志信息统计
                </el-menu-item>
              </el-sub-menu>
            </el-menu>
        </el-scrollbar>
      </el-aside>
        <el-main><RouterView></RouterView></el-main>
      </el-container>
    </el-container>
  </div>
</template>

<style scoped>

</style>

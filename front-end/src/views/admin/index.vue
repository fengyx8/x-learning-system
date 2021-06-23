<template>
  <el-container>
    <el-header>
      <Header />
    </el-header>
    <el-container style="margin-top:30px">
      <el-aside width="250px" style="height:500px">
        <el-row class="tac">
          <el-col :span="24">
            <el-menu
              :router="true"
              :default-active="'/admin/baseInformation'"
              class="el-menu-vertical-demo"
            >
              <el-menu-item :index="'/admin/baseInformation'">
                <span slot="title">基本资料</span>
              </el-menu-item>
              <el-menu-item
                :index="'/admin/reviewExperience'"
              >
                <span slot="title">心得审核</span>
              </el-menu-item>
              <el-menu-item :index="'/admin/reviewComment'">
                <span slot="title">评论审核</span>
              </el-menu-item>
              <el-menu-item :index="'/admin/rank'">
                <span slot="title">积分排名</span>
              </el-menu-item>
              <!-- <el-menu-item :index="'/admin/addInformation'">
                <span slot="title">数据录入</span>
              </el-menu-item> -->
              <!-- <el-menu-item :index="'/admin/manage'">
                <span slot="title">成员管理</span>
              </el-menu-item> -->
              <el-submenu :index="'/admin/manage'">
                <template slot="title">
                  <i class="el-icon-menu"></i>
                  <span>成员管理</span>
                </template>
                <el-menu-item :index="'/admin/manage'"
                  >成员信息</el-menu-item
                >
                <el-menu-item :index="'/admin/addInformation'"
                  >添加新成员</el-menu-item
                >
                <el-menu-item
                  :index="'/admin/searchInformation'"
                  >查询成员信息</el-menu-item
                >
                <el-menu-item
                  :index="'/admin/updateInformation'"
                  >更新成员信息</el-menu-item
                >
                <el-menu-item
                  :index="'/admin/changeScore'"
                  >修改成员积分</el-menu-item
                >
                <el-menu-item
                  :index="'/admin/deleteInformation'"
                  >删除成员</el-menu-item
                >
              </el-submenu>
              <el-menu-item :index="'/admin/circle'">
                <span slot="title">社群</span>
              </el-menu-item>
            </el-menu>
          </el-col>
        </el-row>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import Header from '@/components/Header.vue';
export default {
  components: {
    Header,
  },
};
</script>

<style scoped>
.el-header {
  padding: 0;
}
</style>

<template>
  <el-container>
    <el-header>
      <Header />
    </el-header>
    <el-container style="margin-top:50px">
      <el-aside width="250px" style="height:500px;padding-left:30px">
        <el-row class="tac">
          <el-col :span="24">
            <el-menu
              :router="true"
              default-active="2"
              class="el-menu-vertical-demo"
            >
              
              <el-menu-item :index="'/personal/baseInformation'">基本信息</el-menu-item>
              <el-submenu :index="'/personal/integral'">
                <template slot="title">
                  <i class="el-icon-menu"></i>
                  <span>学习和积分</span>
                </template>
                <!-- <el-menu-item :index="'/personal/data?name=' + accountId"
                  >学习数据</el-menu-item
                > -->
                <el-menu-item :index="'/personal/integral'"
                  >个人积分</el-menu-item
                >
                <el-menu-item :index="'/personal/rank'"
                  >排行榜</el-menu-item
                >
              </el-submenu>
              <el-submenu :index="'/personal/answer'">
                <template slot="title">
                  <i class="el-icon-menu"></i>
                  <span>答题</span>
                </template>
                <el-menu-item :index="'/personal/answer'"
                  >答题中心</el-menu-item
                >
                <el-menu-item
                  :index="'/personal/answerResult'"
                  >答题记录</el-menu-item
                >
              </el-submenu>
              <!-- <el-menu-item :index="'/personal/experience'">
                <span slot="title">心得分享</span>
              </el-menu-item> -->
              

              <el-submenu :index="'/personal/experience'">
                <template slot="title">
                  <i class="el-icon-menu"></i>
                  <span>心得分享</span>
                </template>
                <el-menu-item :index="'/personal/publish'"
                  >发表心得</el-menu-item
                >
                <el-menu-item
                  :index="'/personal/experience'"
                  >社群</el-menu-item
                >
              </el-submenu>
              <!-- <el-menu-item :index="'/personal/message?name=' + accountId">
                <span slot="title">消息</span>
              </el-menu-item> -->
              <!-- <el-menu-item :index="'/personal/data?name=' + accountId">
                <span slot="title">学习数据</span>
              </el-menu-item> -->
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

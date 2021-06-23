<template>
  <!-- <el-card class="box-card"> -->
    <!-- <div slot="header" class="clearfix">
      <el-row style="width:100%">
        <el-col :span="4" :offset="4"><img style="width:60px" src="@/../public/images/女人-女性头像.png" alt=""></el-col>
        <el-col :span="4" :offset="2">
          <el-row style="font-size:20px">
            <el-col>{{ form.userId }}</el-col>
          </el-row>
        </el-col>
      </el-row>
    </div> -->
    <div class="inf">
      <el-row>
        <span style="display:inline-block;width:80px">姓名：</span>
        <el-input class="my-input-box" v-model="name" disabled></el-input>
      </el-row>
      <el-row>
        <span style="display:inline-block;width:80px">学工号：</span>
        <el-input class="my-input-box" v-model="userId" disabled></el-input>
        <!-- <span>{{ id }}</span> -->
      </el-row>
      <el-row>
        <span style="display:inline-block;width:80px">组织：</span>
        <el-input class="my-input-box" v-model="org" disabled></el-input>
      </el-row>
      <el-row>
        <span style="display:inline-block;width:80px">邮箱：</span>
        <el-input class="my-input-box" v-model="mail" disabled></el-input>
      </el-row>
      <el-row>
        <span style="display:inline-block;width:80px">积分：</span>
        <el-input class="my-input-box" v-model="score" disabled></el-input>
      </el-row>
      <el-row>
        <el-col :span="6" :offset="16">
          <span
            style="cursor:pointer;text-decoration:underline"
            @click="toChangePassword"
            >修改密码</span
          >
        </el-col>
      </el-row>
    </div>
  <!-- </el-card> -->
</template>

<script>
export default {
  data() {
    return {
      name: '',
      userId: '',
      mail: '',
      org: '',
      score: ''
    };
  },
  mounted() {
    this.getData();
  },
  methods: {
    async getData () {
      let userId = window.sessionStorage.getItem('userId');
      // let {data:res} = await this.$http.get("communityUser/userInfo/" + userId)
      let res = await this.$http.get("communityUser/userInfo/" + userId)
      .catch(function (error) {
        console.log('出错',error.response);//可以拿到后端返回的信息
        // if(error.response.status == 500)
        //   this.$router.push('active')
      });
      console.log('用户信息',res)
      if(res.data.code == 200) {
        this.name = res.data.data.name;
        this.userId = res.data.data.userId;
        this.mail = res.data.data.mail;
        this.org = res.data.data.org;
        this.score = res.data.data.score;
      }
      if(res.data.code == 500) {
        this.$message.success('请先激活账户！')
        this.$router.push('/active');
      }
       

    },
    toChangePassword() {
      this.$router.push({
        path: '/personal/changePassword',
        // query: {
        //   name: this.accountId,
        // },
      });
    },
  },
};
</script>

<style scoped>
.box-card {
  width: 60%;
  margin: 0px 20% auto 20%;
}

.inf {
  width: 100%;
  /* background-color: aqua; */
  /* padding: 0 20px; */
  box-sizing: border-box;
}

.inf .el-row {
  margin: 20px auto 20px 100px;
}

.my-input-box {
  width: 260px;
}
</style>

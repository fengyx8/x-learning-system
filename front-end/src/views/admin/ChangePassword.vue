<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span>修改密码</span>
    </div>
    <el-form ref="form" :model="form" label-width="100px">
      <el-form-item style="margin-top:30px;margin-left:50px" label="旧密码">
        <el-input
          style="width:300px"
          v-model="form.password"
          show-password
          placeholder="请输入旧密码"
        ></el-input>
      </el-form-item>
      <el-form-item style="margin-top:30px;margin-left:50px" label="新密码">
        <el-input
          style="width:300px"
          v-model="form.newPassword"
          show-password
          placeholder="请输入新密码"
        ></el-input>
      </el-form-item>
      <el-form-item style="margin-top:30px;margin-left:50px" label="确认新密码">
        <el-input
          style="width:300px"
          v-model="form.rePassword"
          show-password
          placeholder="请确认新密码"
        ></el-input>
      </el-form-item>
      <el-form-item style="margin-top:50px;margin-left:160px">
        <el-button type="primary" @click="changePassword">确认修改</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
export default {
  data() {
    return {
      accountId: '',
      form: {
        password: '',
        newPassword: '',
        rePassword: '',
      },
    };
  },
  mounted() {
    this.accountId = this.$route.query.name;
  },
  methods: {
    changePassword() {
      if (
        this.form.newPassword &&
        this.form.newPassword === this.form.rePassword
      ) {
        //发送确认旧密码准确，然后设置成新密码
        this.$router.push({
          path: '/personal/baseInformation',
          query: {
            name: this.accountId,
          },
        });
      } else {
        this.form.newPassword = '';
        this.form.rePassword = '';
        this.$message({
          type: 'error',
          message: '新旧密码不一样！',
        });
      }
    },
  },
};
</script>

<style scoped>
.box-card {
  width: 60%;
  margin: 0px 20% auto 20%;
}
</style>

<template>
  <el-container>
    <div class="box">
      <el-form
        ref="formRef"
        label-width="0px"
        class="active_form"
        :model="form"
        :rules="rules"
      >
        <el-form-item prop="name">
          <el-input placeholder="姓名" v-model="form.name">
            <i slot="prefix" class="el-input__icon el-icon-user"></i>
          </el-input>
        </el-form-item>
        <el-form-item prop="mail">
          <el-input placeholder="邮箱" v-model="form.mail">
            <i slot="prefix" class="el-input__icon el-icon-user"></i>
          </el-input>
        </el-form-item>
        <el-form-item prop="org">
          <el-input placeholder="所属组织" v-model="form.org">
            <i slot="prefix" class="el-input__icon el-icon-user"></i>
          </el-input>
        </el-form-item>
        <el-form-item prop="newpwd">
          <el-input placeholder="密码" type="password" v-model="form.newpwd">
            <i slot="prefix" class="el-input__icon el-icon-lock"></i>
          </el-input>
        </el-form-item>
        <el-form-item prop="renewpwd">
          <el-input
            placeholder="确认密码"
            type="password"
            v-model="form.renewpwd"
          >
            <i slot="prefix" class="el-input__icon el-icon-lock"></i>
          </el-input>
        </el-form-item>
        <el-form-item class="form_btns">
          <el-button type="info" @click="cancel">取消</el-button>
          <el-button type="primary" @click="active">注册</el-button>
        </el-form-item>
      </el-form>
    </div>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      form: {
        id: '',
        prepwd: '',
        newpwd: '',
        answer: '',
        renewpwd: '',
      },
      rules: {
        name: [{ required: true, message: '请输入姓名', trigger: 'blur' }],
        org: [{ required: true, message: '请输入所属组织', trigger: 'blur' }],
        mail: [{ required: true, message: '请输入邮箱地址', trigger: 'blur' },
            { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change']}],
        prepwd: [{ required: true, message: '请输入原密码', trigger: 'blur' }],
        newpwd: [{ required: true, message: '请输入新密码', trigger: 'blur' }],
        renewpwd: [
          { required: true, message: '请确认新密码', trigger: 'blur' },
        ],
      },
    };
  },
  mounted() {
    //后台获取options回填
  },
  methods: {
    cancel() {
      this.$router.push('/login')
    },
    async active() {
      if (this.form.newpwd === this.form.renewpwd) {
        //将表单信息发送给后端,验证通过后跳转页面
        let res = await this.$http.post('xUser/registerManager?mail='+this.form.mail+'&name='+this.form.name+'&org='+this.form.org+'&password='+this.form.newpwd)
        if(res.data.code == 200) {
          console.log('注册', res.data)
          
          this.$confirm('请牢记您的账号，以便后续登录系统：' + res.data.data, '提示', {
          confirmButtonText: '记住了',
          cancelButtonText: '收到',
          type: 'warning'
        }).then(() => {
          this.$message({
            type: 'success',
            message: '注册成功!'
          });
        }).catch(() => {
          this.$message({
            type: 'success',
            // type: 'info',
            message: '注册成功!'
          });          
        });
          
          
          return this.$router.push('/login');
        }
        
        this.$message.error('激活失败！')
        
      } else {
        this.form.newpwd = '';
        this.form.renewpwd = '';
        this.$message.error('两次密码不一致！！');
      }

    },
  },
};
</script>

<style scoped>
.el-container {
  height: 100%;
  background-color: rgba(255, 216, 8, 0.7);
}
.box {
  width: 450px;
  height: 390px;
  background-color: #fff;
  border-radius: 3px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
.active_form {
  position: absolute;
  top: 20px;
  width: 100%;
  padding: 0 20px;
  box-sizing: border-box;
}
.form_btns {
  /* 按钮靠右对齐 */
  display: flex;
  justify-content: center;
}
</style>

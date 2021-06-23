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
        <el-form-item prop="id">
          <el-input placeholder="学号" v-model="form.id" disabled>
            <i slot="prefix" class="el-input__icon el-icon-user"></i>
          </el-input>
        </el-form-item>
        <el-form-item prop="name">
          <el-input placeholder="姓名" v-model="form.name" disabled>
            <i slot="prefix" class="el-input__icon el-icon-user"></i>
          </el-input>
        </el-form-item>
        <el-form-item prop="mail">
          <el-input placeholder="邮箱" v-model="form.mail">
            <i slot="prefix" class="el-input__icon el-icon-user"></i>
          </el-input>
        </el-form-item>
        <el-form-item prop="newpwd">
          <el-input placeholder="新密码" type="password" v-model="form.newpwd">
            <i slot="prefix" class="el-input__icon el-icon-lock"></i>
          </el-input>
        </el-form-item>
        <el-form-item prop="renewpwd">
          <el-input
            placeholder="确认新密码"
            type="password"
            v-model="form.renewpwd"
          >
            <i slot="prefix" class="el-input__icon el-icon-lock"></i>
          </el-input>
        </el-form-item>
        <el-form-item required>
          <el-col :span="11">
            <el-form-item prop="value">
              <el-select v-model="form.value" placeholder="请选择密保问题">
                <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :offset="1" :span="10">
            <el-form-item prop="answer">
              <el-input
                style="width:185px;margin-left:20px"
                placeholder="密保问题答案"
                v-model="form.answer"
              >
                <i slot="prefix" class="el-input__icon el-icon-lock"></i>
              </el-input>
            </el-form-item>
          </el-col>
        </el-form-item>
        <el-form-item class="form_btns">
          <el-button type="primary" @click="active">激活</el-button>
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
        name: '',
        mail: '',
        newpwd: '',
        answer: '',
        renewpwd: '',
        value: '',
      },
      options: [
        {
          value: '你的父亲的名字',
          label: '你的父亲的名字',
        },
        {
          value: '你的母亲的名字',
          label: '你的母亲的名字',
        },
        {
          value: '你最喜欢的东西',
          label: '你最喜欢的东西',
        },
        {
          value: '对你最有影响力的人',
          label: '对你最有影响力的人',
        },
      ],
      rules: {
        id: [{ required: true, message: '请输入学号', trigger: 'blur' }],
        mail: [{ required: true, message: '请输入邮箱地址', trigger: 'blur' },
              { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }],
        newpwd: [{ required: true, message: '请输入新密码', trigger: 'blur' }],
        renewpwd: [
          { required: true, message: '请确认新密码', trigger: 'blur' },
        ],
        value: [{ required: true, message: '请选择密码问题', trigger: 'change' }],
        answer: [
          { required: true, message: '请输入密保答案', trigger: 'blur' },
        ],
      },
    };
  },
  mounted() {
    //后台获取options回填
    this.form.id = window.sessionStorage.getItem('userId');
    this.form.name = window.sessionStorage.getItem('name');
  },
  methods: {
    async active() {
      this.$refs.formRef.validate(async (valid) => {
        // console.log(valid); // valid 是 boolean，告知表单预验证是通过了还是失败了
        if(!valid) return;
      if (this.form.newpwd === this.form.renewpwd) {
        //将表单信息发送给后端,验证通过后跳转页面
        let res = await this.$http.post('userOperation/activeAccount?mail='+this.form.mail+'&name='+this.form.name+'&password='+this.form.newpwd+'&secureAns='+this.form.answer+'&secureQue='+this.form.value+'&userId='+this.form.id)
        if(res.data.code == 200) {
          this.$router.push('home');
          return this.$message.success('激活成功！一起学习吧')
        }
        this.$message.error('激活失败！')
        
      } else {
        this.form.newpwd = '';
        this.form.renewpwd = '';
        this.$message.error('两次密码不一致！！');
      }
      })
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
  /* width: 450px;
    height: 300px; */
  width: 450px;
  /* height: 400px; */
  height: 450px;
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

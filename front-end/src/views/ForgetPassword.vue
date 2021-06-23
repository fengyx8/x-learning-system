<template>
  <el-container>
    <div class="box">
      <el-form
        ref="formRef"
        label-width="0px"
        class="change_form"
        :model="form"
        :rules="rules"
      >
        <el-form-item prop="id">
          <el-input placeholder="学号" v-model="form.id">
            <i slot="prefix" class="el-input__icon el-icon-user"></i>
          </el-input>
        </el-form-item>
        <el-form-item required>
          <el-col :span="11">
            <el-form-item prop="value">
              <el-select v-model="value" placeholder="请选择密保问题">
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
        <el-form-item prop="newpwd">
          <el-input
            placeholder="请输入新密码"
            type="password"
            v-model="form.newpwd"
          >
            <i slot="prefix" class="el-input__icon el-icon-lock"></i>
          </el-input>
        </el-form-item>
        <el-form-item prop="renewpwd">
          <el-input
            placeholder="请确认新密码"
            type="password"
            v-model="form.renewpwd"
          >
            <i slot="prefix" class="el-input__icon el-icon-lock"></i>
          </el-input>
        </el-form-item>
        <el-form-item class="form_btns">
          <el-button type="primary" @click="cancel">取消</el-button>
          <el-button type="primary" @click="change">重置密码</el-button>
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
        answer: '',
        newpwd: '',
        renewpwd: '',
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
      value: '',
      rules: {
        id: [{ required: true, message: '请输入学号', trigger: 'blur' }],

        value: [{ required: true, message: '请选择密码问题', trigger: 'blur' }],
        answer: [
          { required: true, message: '请输入密保答案', trigger: 'blur' },
        ],
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
    cancel () {
      this.$router.push('/login');
    },
    async change() {
      if (this.form.newpwd === this.form.renewpwd) {
        //向后台发送请求验证是否通过
        let res = await this.$http.put('userOperation/forgetPassword?password='+this.form.newpwd+'&secureAns='+this.form.answer+'&secureQue='+this.value+'&userId='+this.form.id)
        console.log('重置！',res.data)
        if(res.data.code == 200) {
          this.$message.success('修改密码成功！');
          this.$router.push('/login');
        }
        else {
          this.$message.error('修改密码失败！');
        }
        
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
  /* width: 450px;
    height: 300px; */
  width: 450px;
  height: 350px;
  background-color: #fff;
  border-radius: 3px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}

.change_form {
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

<template>
  <div class="login_container">
    <div class="login_box">
      <!-- 头像 -->
      <div class="ava_box">
        <!-- <img src="../assets/logo.png" alt=""> -->
        <img src="../assets/images/logo2.png" alt="">
      </div>
      <!-- 登录表单 -->
      <!-- 为表单绑定规则。:rules="formRules不行"。规则用prop绑定 -->
      <!-- ref添加引用，便于拿到表单的实例对象 -->
      
      <el-form ref="formRef" label-width="0px" class="login_form" :model="form" :rules="rules">
        <el-form-item prop="username">
          <el-input placeholder="用户名" v-model="form.username">
            <i slot="prefix" class="el-input__icon el-icon-user"></i>
          </el-input>
        </el-form-item>
        <el-form-item prop="pwd">
          <el-input placeholder="密码" type="password" v-model="form.pwd" :show-password="true">
            <i slot="prefix" class="el-input__icon el-icon-lock"></i>
          </el-input>
        </el-form-item>
          
          <span class="form_btns">
            <router-link to="register" style="font-size: 14px;">
              / 管理员注册
            </router-link>
            <router-link to="forgetPassword" style="margin-left: 5px; font-size: 14px;">
            / 忘记密码
            </router-link>
          </span>

        <!-- 按钮 -->
        <el-form-item class="form_btns_2">
          <el-button type="primary" @click="btnLogin">登录</el-button>
          <el-button type="info" @click="btnReset">清除</el-button>
          <!-- <span>
              <router-link to="loginadmin" style="padding-left: 35px;">
            我是管理员 >>
            </router-link>
          </span> -->
            
        </el-form-item>
      </el-form>
    </div>
  </div>
  
</template>

<script>
export default {
  data() {
    return {
      form: {
        username: "",
        pwd: ""
      },
      rules: {
        // rules 属性必须严格对应form属性，名字不能不一样（？）
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
        ],
        pwd: [
          { required: true, message: '请输入密码', trigger: 'blur' },
        ]
      }
    }
  },
  methods: {
    btnLogin () {
      // validate函数接受一个回调函数，回调函数有2个形参
      this.$refs.formRef.validate(async (valid) => {
        // console.log(valid); // valid 是 boolean，告知表单预验证是通过了还是失败了
        if(!valid) return;
        let userForm = {
          key: this.form.username,
          password: this.form.pwd
        };
        // console.log(userForm);

        // 不行
        // let result = this.$http.post(
        //   "xUser/doLogin", userForm
        // ); 

        // 行
        // let result = this.$http.post(
        //   "xUser/doLogin?" + "key=" + userForm.key + "&password=" + userForm.password
        // ); 

        // await 用来简化返回值为 promise 的方法；注意 await 只能用在被 async 修饰的方法中，因此必须把紧挨着它的方法修饰成异步的 async 方法
        let {data:res} = await this.$http.post(
          "xUser/doLogin?" + "key=" + userForm.key + "&password=" + userForm.password
        );
        console.log("loginTest",res);
      if(res.code == 200) {
        window.sessionStorage.setItem("token", res.data.tokenInfo.tokenValue);
        window.sessionStorage.setItem("roleId", res.data.xUser.roleId);
        window.sessionStorage.setItem("userId", res.data.xUser.id);
        window.sessionStorage.setItem("name", res.data.xUser.name);
        this.$router.push("/home");
        return this.$message({
          message: '登录成功',
          type: 'success'
        });
      }

      this.$message.error('登录失败！');

      });
    },
    btnLogin2 () {
      // validate函数接受一个回调函数，回调函数有2个形参
      this.$refs.formRef.validate(async (valid) => {
        // console.log(valid); // valid 是 boolean，告知表单预验证是通过了还是失败了
        if(!valid) return;
        let userForm = {
          key: this.form.username,
          password: this.form.pwd
        };
        console.log(userForm);
        let {result} = this.$post(
          "http://192.168.43.94:8290/xUser/doLogin", userForm
        ); 
        // let {data:result} = await this.$post(
        //   "http://192.168.43.94:8290/xUser/doLogin", userForm
        // ); 
        // await 用来简化返回值为 promise 的方法；注意 await 只能用在被 async 修饰的方法中，因此必须把紧挨着它的方法修饰成异步的 async 方法
        console.log(result);
        this.$message({
          message: '登录成功',
          type: 'success'
        });
        // window.sessionStorage.setItem("token", res.data.token);
        this.$router.push("/home");
      });
    },
    btnReset () {
      // 调用 element-ui form 实例自带的方法
      this.$refs.formRef.resetFields();
    },

  }

}
</script>

<style scoped>
  .login_container {
    /* background-color: #2b4b6b; */
    background-color: rgba(255,216,8,0.7);
    height: 100%;
  }
  .login_box {
    /* width: 450px;
    height: 300px; */
    width: 450px;
    height: 330px;
    background-color: #fff;
    border-radius: 3px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
  }

  .ava_box {
    height: 130px;
    width: 130px;
    border: 1px solid #eee;
    border-radius: 50%;
    padding: 10px;
    box-shadow: 0 0 10px #ddd;
    position: absolute;
    left: 50%;
    /* transform 用来位移，移动父盒子一般的宽度 - 自己一半的宽度 */
    transform: translate(-50%,-50%);
    background-color: #fff;
  }
  img {
    width: 100%;
    height: 100%;
    border-radius: 50%;
    background-color: #eee;
  }
  .login_form {
    position: absolute;
    bottom: 0;
    width: 100%;
    padding: 0 20px;
    box-sizing: border-box;
  }
  .form_btns {
    /* 按钮靠右对齐 */
    display: flex;
    justify-content: flex-end;
  }
  .form_btns_2 {
    /* 按钮靠右对齐 */
    display: flex;
    justify-content: center;
  }
</style>
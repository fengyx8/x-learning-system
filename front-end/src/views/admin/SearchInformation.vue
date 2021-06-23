<template>
  <div>
    <el-form ref="form" :model="form" label-width="100px">
      <el-form-item style="margin-left:10px" label="学号">
        <el-input
          style="width:300px"
          v-model="form.id"
        ></el-input>
      </el-form-item>
      <el-form-item class="not-first-line" label="姓名">
        <el-input
          style="width:300px"
          v-model="form.name"
          disabled
        ></el-input>
      </el-form-item>
      <!-- <el-form-item class="not-first-line" label="性别">
        <el-select v-model="form.gender" style="width: 300px;">
          <el-option label="男" value="male"></el-option>
          <el-option label="女" value="female"></el-option>
        </el-select>
      </el-form-item> -->
      <el-form-item class="not-first-line" label="所属支部">
        <el-input
          style="width:300px"
          v-model="form.org"
          disabled
        ></el-input>
      </el-form-item>
      <el-form-item class="not-first-line" label="邮箱">
        <el-input
          style="width:300px"
          v-model="form.mail"
          disabled
        ></el-input>
      </el-form-item>
      <el-form-item class="not-first-line" label="角色">
        <el-input
          style="width:300px"
          v-model="form.roleName"
          disabled
        ></el-input>
      </el-form-item>
      <el-form-item class="not-first-line" label="登录时间">
        <el-input
          style="width:300px"
          v-model="form.loginTime"
          disabled
        ></el-input>
      </el-form-item>
      <el-form-item class="not-first-line" label="登录IP">
        <el-input
          style="width:300px"
          v-model="form.loginIp"
          disabled
        ></el-input>
      </el-form-item>
      <el-form-item class="not-first-line" label="登录次数">
        <el-input
          style="width:300px"
          v-model="form.loginCount"
          disabled
        ></el-input>
      </el-form-item>
      <el-form-item class="not-first-line" label="创建时间">
        <el-input
          style="width:300px"
          v-model="form.createTime"
          disabled
        ></el-input>
      </el-form-item>
      <el-form-item class="not-first-line" label="创建者">
        <el-input
          style="width:300px"
          v-model="form.createByAid"
          disabled
        ></el-input>
      </el-form-item>
      <el-form-item class="btn-line">
        <el-button type="primary" @click="cancel">取消</el-button>
        <el-button type="primary" @click="add">查询</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      accountId: '',
      form: {
        id: '',
        name: '',
        mail: '',
        org: '',
        roleName: '',
        loginTime: '',
        loginIp: '',
        loginCount: '',
        createTime: '',
        createByAid: ''
      },
    };
  },
  methods: {
    async add () {
      if ( this.form.id) {
        let res = await this.$http.get("managerOperation/xUser/" + this.form.id);
        console.log('add',res.data.data)
        this.form = res.data.data;
        if(res.status == 200) {
          this.$message.success('查询成功！');
          // this.$router.push('/admin/baseInformation');
        } else {
          this.$message.error('查询失败！')
        }
      } else {
        this.$message({
          type: 'error',
          message: '查询失败！学号不能为空',
        });
      }
    },
    cancel () {
      this.$router.push('/admin/baseInformation');
    }
  },
};
</script>

<style scoped>
  .not-first-line {
    margin-left: 10px
  }
  .btn-line {
    margin-top: 30px;
    margin-left: 60px
  }
</style>

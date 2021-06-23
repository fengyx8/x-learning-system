<template>
  <div>
    <el-form ref="form" :model="form" label-width="100px">
      <el-form-item style="margin-left:10px" label="学号">
        <el-input
          style="width:300px"
          v-model="form.student"
        ></el-input>
      </el-form-item>
      <el-form-item class="not-first-line" label="姓名">
        <el-input
          style="width:300px"
          v-model="form.name"
        ></el-input>
      </el-form-item>
      <el-form-item class="not-first-line" label="初始密码">
        <el-input
          style="width:300px"
          v-model="form.pwd"
        ></el-input>
      </el-form-item>
      <el-form-item class="btn-line">
        <el-button type="primary" @click="cancel">取消</el-button>
        <el-button type="primary" @click="add">确定</el-button>
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
        student: '',
        name: '',
        pwd: '',
      },
    };
  },
  methods: {
    async add () {
      if ( this.form.student && this.form.name && this.form.pwd ) {
        let res = await this.$http.put("managerOperation/xUser?name=" + this.form.name + "&password=" + this.form.pwd + "&userId=" + this.form.student);
        console.log('add',res)
        if(res.status == 200) {
          this.$message.success('修改成功！');
          this.$router.push('/admin/baseInformation');
        } else {
          this.$message.error('修改失败！')
        }
      } else {
        this.$message({
          type: 'error',
          message: '修改失败！',
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

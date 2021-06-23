<template>
  <div>
    <el-form ref="form" :model="form" label-width="100px">
      <el-form-item style="margin-left:10px" label="学号">
        <el-input
          style="width:300px"
          placeholder="请输入删除的学号"
          v-model="form.student"
        ></el-input>
      </el-form-item>
      <el-form-item class="btn-line">
        <el-button type="primary" @click="cancel">取消</el-button>
        <el-button type="primary" @click="add">确定删除</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        student: '',
      },
    };
  },
  methods: {
    async add () {
      if ( this.form.student) {
        let res = await this.$http.delete("managerOperation/xUser/" + this.form.student);
        console.log('delete',res)
        if(res.status == 200) {
          this.$message.success('删除成功！');
          this.$router.push('/admin/baseInformation');
        } else {
          this.$message.error('添加失败！')
        }
      } else {
        this.$message({
          type: 'error',
          message: '删除失败！学号不能为空',
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

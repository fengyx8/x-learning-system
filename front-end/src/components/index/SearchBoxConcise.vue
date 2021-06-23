<template>
    <div class="content-wrap-110">
        <!-- <h2 style="color: #fff; text-align: center;"> -->
        <h2 style="text-align: center;">
        学习知识百科全书
        </h2>
        
        <!-- <el-form :inline="true" class="demo-form-inline"> -->
            <!-- <el-form-item> -->
              <div class="form_btns" style="margin-bottom: 2.5%;">
                <el-input v-model="user_input" placeholder="请输入..." :clearable=true style="width: 450px;" @keyup.enter.native="onSubmit"></el-input>
              </div>
            <!-- </el-form-item> -->
            <!-- <el-form-item>
                <el-button type="primary" @click="onSubmit">搜索</el-button>
            </el-form-item>
            <router-link style="font-size: 14px;" to="indexComplecated">高级检索</router-link> -->
        <!-- </el-form> -->

        
        <div class="form_btns">
        <button class="btn btn-primary" @click="onSubmit">搜索</button>
        <router-link to="indexComplecated">
          <span style="position: relative; top: 20%; font-size: 14px; margin-left: 20px; color: #333;">
          高级检索
          </span>
        </router-link>
        </div>

    </div>
</template>

<script>
  export default {
    data() {
      return {
        user_input: ''
      }
    },
    methods: {
      onSubmit() {
        // console.log('submit!',res);
        this.$router.push('/morenews?keyword='+this.user_input+'&type=&page=1&year=');
        // this.$router.push({
        //   path: 'morenews',
        //   query: {
        //     keyword: this.user_input,
        //     type: '',
        //     page: '1',
        //     year: ''
        //   }
        // })
      }
    }
  }
</script>

<style scoped>
    .demo-form-inline {
        text-align: center;
    }
  .form_btns {
    /* 按钮居中对齐 */
    display: flex;
    justify-content: center;
  }
</style>
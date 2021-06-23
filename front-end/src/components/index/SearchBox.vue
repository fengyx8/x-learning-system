<template>
    <div class="content-wrap-110">
        <!-- <h2 style="color: #fff; text-align: center;"> -->
        <h2 style="text-align: center;">
        学习知识百科全书
        </h2>
        
        <el-form :inline="true" class="demo-form-inline">
            <el-form-item label="主题：">
                <el-input v-model="keyword" placeholder="请输入关键词" :clearable=true></el-input>
            </el-form-item>
            <el-form-item label="类型：">
                <el-select v-model="type" placeholder="请选择">
                    <el-option label="政治" value="政治"></el-option>
                    <el-option label="经济" value="经济"></el-option>
                    <el-option label="文化" value="文化"></el-option>
                    <el-option label="社会" value="社会"></el-option>
                    <el-option label="生态" value="生态"></el-option>
                    <el-option label="党建" value="党建"></el-option>
                    <el-option label="国防" value="国防"></el-option>
                    <el-option label="外交" value="外交"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="时间：">
              <el-select v-model="year" placeholder="请选择">
                    <el-option label="2021" value="2021" selected></el-option>
                    <el-option label="2020" value="2020"></el-option>
                    <el-option label="2019" value="2019"></el-option>
                    <el-option label="2018" value="2018"></el-option>
                </el-select>
              <!-- <el-date-picker type="date" placeholder="选择日期" v-model="year" style="width: 100%;">
              </el-date-picker> -->
            </el-form-item>
        </el-form>
        <div class="form_btns">
        <button class="btn btn-primary" @click="onSubmit">搜索</button>
        <router-link to="home">
          <span style="position: relative; top: 20%; font-size: 14px; margin-left: 20px; color: #333;">
          返回
          </span>
        </router-link>
        </div>
    </div>
</template>

<script>
  export default {
    data() {
      return {
        keyword: '',
        type: '',
        year: '',
      }
    },
    methods: {
      onSubmit() {
        console.log('submit!');
        this.$router.push('/morenews?keyword='+this.keyword+'&type='+this.type+'&page=1&year='+this.year);
        // this.$router.push({
        //   path: 'morenews',
        //   query: {
        //     keyword: this.keyword,
        //     type: this.type,
        //     page: '1',
        //     year: this.year
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
<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span>学习数据</span>
    </div>
    <el-select style="margin-left:150px" v-model="value" placeholder="请选择">
      <el-option
        v-for="item in options"
        :key="item.value"
        :label="item.label"
        :value="item.value"
      >
      </el-option>
    </el-select>
    <div
      style="width:80%;margin-left:10%;padding-left:10%;box-sizing:border-box;height:200px"
    >
      <el-row
        v-for="(prop, index) in summary"
        :key="index"
        style="margin-top:30px"
      >
        <el-col :span="4">{{ prop.title }}</el-col>
        <el-col :span="4" :offset="12">{{ prop.time }}次</el-col>
      </el-row>
    </div>
  </el-card>
</template>

<script>
export default {
  data() {
    return {
      options: [
        {
          value: '近一个月',
          label: '近一个月',
        },
        {
          value: '近三个月',
          label: '近三个月',
        },
        {
          value: '近半年',
          label: '近半年',
        },
        {
          value: '近一年',
          label: '近一年',
        },
        {
          value: '一年以上',
          label: '一年以上',
        },
      ],
      value: '',
      summary: [
        {
          title: '发表心得',
          time: 19,
        },
        {
          title: '发表评论',
          time: 10,
        },
        {
          title: '答题',
          time: 10,
        },
      ],
    };
  },
  mounted() {
    let name = this.$route.query.name;
    console.log(name);
    //根据姓名和this.value拿到对应数据回填summary
  },
  watch: {
    value() {
      //根据姓名和this.value拿到对应数据回填summary,做到响应式
    },
  },
};
</script>

<style scoped>
.box-card {
  width: 60%;
  margin: 50px 20% auto 20%;
}
</style>

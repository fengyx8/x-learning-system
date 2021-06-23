<template>
      <!-- CONTENT -->
  <div class="section">
    <el-table
    :data="question"
    style="width: 100%">
    <el-table-column type="expand">
      <template slot-scope="props">
        <el-form label-position="left" class="demo-table-expand">
          <el-form-item label="【选择】">
            <span>{{ props.row.ans }}</span>
          </el-form-item>
          <el-form-item label="【正确答案】">
            <span>{{ props.row.stdAns }}</span>
          </el-form-item>
          <el-form-item label="【解析】">
            <span>{{ props.row.analysis }}</span>
          </el-form-item>
        </el-form>
      </template>
    </el-table-column>
    <el-table-column
      prop="index"
      width="40px">
    </el-table-column>
    <el-table-column
      label="题目"
      prop="problem">
    </el-table-column>
  </el-table>
  </div>

</template>

<script>
export default {
  data () {
    return {
      question: []
    }
  },
  methods: {
    async getData () {
      // let userId = window.sessionStorage.getItem('userId');
      let {data:res} = await this.$http.get("communityUser/ansRecords")
      console.log('ansRecords',res.data)
      for(var i=0; i<res.data.length; i++) {
          let {data} = await this.$http.get("communityWhole/question/" + res.data[i].queId)
          console.log(data)
          this.question.push({
            index: i+1,
            problem: data.data.problem,
            stdAns: data.data.stdAns,
            analysis: data.data.analysis,
            ans: res.data[i].ans,
            // isCorrect: res.data[i].isCorrect,
          })
      }
      console.log('答题列表汇总', this.question)
      // window.localStorage.setItem('userBasic', res.data);
    },
  },
  mounted () {
    this.getData();
  }

}
</script>

<style>
  .demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 120px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 90%;
  }
  div.el-table__expand-icon {
    /* color: #FFD808; */
    background-color: #EEEEEE;
    /* background-color: #C61202; */
  }

</style>
<template>
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
      type="index"
      width="70">
      </el-table-column>
      <el-table-column
        prop="userId"
        label="学号"
        width="200px">
      </el-table-column>
      <el-table-column
        prop="name"
        label="姓名">
      </el-table-column>
      <!-- <el-table-column
        prop="gender"
        label="性别">
      </el-table-column> -->
      <el-table-column
        prop="score"
        label="积分">
      </el-table-column>
      <!-- <el-table-column
        prop="note"
        label="心得感悟/篇">
      </el-table-column> -->
      <!-- <el-table-column
        prop="comment"
        label="评论/条">
      </el-table-column> -->
      <!-- <el-table-column
        prop="question"
        label="答题/次">
      </el-table-column> -->
    </el-table>
</template>

<script>
    export default {
      data() {
        return {
          tableData: [],
          tableData2: [{
            student: '18379999',
            name: '王小虎',
            gender: '男',
            association: '193',
            note: '53',
            comment: '27',
            question: '14'
          },{
            student: '18379999',
            name: '王小虎',
            gender: '男',
            association: '193',
            note: '53',
            comment: '27',
            question: '14'
          },{
            student: '18379999',
            name: '王小虎',
            gender: '男',
            association: '193',
            note: '53',
            comment: '27',
            question: '14'
          },{
            student: '18379999',
            name: '王小虎',
            gender: '男',
            association: '193',
            note: '53',
            comment: '27',
            question: '14'
          }]
        }
      },
      methods: {
        async getData () {
          let res = await this.$http.get("communityWhole/scoreBoard");
          console.log(res.data.data)
          this.tableData = res.data.data;
        }
      },
      mounted () {
        this.getData();
      }
    }
</script>
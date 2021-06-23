<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span>评论审核</span>
    </div>
    <div class="content">
      <!-- <ul>
        <li v-for="(prop, index) in select" :key="index">
          <div class="img">
            <img :src="prop.src" alt="" />
          </div>
          <div class="main">
            <div class="name">{{ prop.name }}</div>
            <div class="word">
              {{ prop.word }}
            </div>
          </div>
          <el-button
            size="mini"
            class="mybtn"
            @click="selected(prop.key)"
            type="primary"
            >精选</el-button
          >
        </li>
      </ul> -->

      <!-- <el-table :data="tableData2" border style="width: 100%">
        <el-table-column prop="taskid" label="taskid"> </el-table-column>
        <el-table-column prop="type" label="数据类型"> </el-table-column>
        <el-table-column prop="state" label="数据状态"> </el-table-column>
        <el-table-column prop="content" label="内容" width="200">
        </el-table-column>
        <el-table-column prop="time" label="审核时间"> </el-table-column>
        <el-table-column prop="user" label="用户标识"> </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="small"
              >查看详情</el-button
            ></template
          >
        </el-table-column>
      </el-table> -->


      <el-table :data="tableData" border style="width: 100%">
        <el-table-column prop="commentId" label="评论Id" width="70"> </el-table-column>
        <el-table-column prop="noteId" label="来源" width="70"> </el-table-column>
        <el-table-column prop="userId" label="用户Id" width="90"> </el-table-column>
        <el-table-column prop="time" label="发表时间" width="100"> </el-table-column>
        <el-table-column prop="content" label="内容"></el-table-column>
        <el-table-column prop="status" label="审核状态" width="80"> </el-table-column>
        <el-table-column label="操作" width="100">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="small">通过</el-button>
            <el-button @click="handleClickReject(scope.row)" type="text" size="small" class="danger">不通过</el-button>
          </template>
        </el-table-column>
        
      </el-table>
    </div>

    <!-- <div style="display:flex;justify-content:center">
      <el-pagination
        layout="prev, pager, next"
        :total="total"
        @current-change="handleCurrentChange"
        :current-page="nowPage"
      >
      </el-pagination>
    </div> -->


  </el-card>
</template>

<script>
import img1 from '@/../public/images/女人-女性头像.png';
import img2 from '@/../public/images/女人.png';
export default {
  data() {
    return {
      select: [
        {
          src: img1,
          name: '张三',
          word:
            '哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈',
          key: 1,
        },
        {
          src: img2,
          name: '李四',
          word: '叫大家猜猜吧才能保持开机内存空间能看见',
          key: 2,
        },
        {
          src: img1,
          name: '王五',
          word: '上看超级难看此u额蹙额去年磁轭去你',
          key: 3,
        },
        {
          src: img2,
          name: '王五',
          word: '上看超级难看此u额蹙额去年磁轭去你',
          key: 4,
        },
        {
          src: img1,
          name: '王五',
          word: '上看超级难看此u额蹙额去年磁轭去你',
          key: 4,
        },
      ],
      nowPage: 1,
      total: 100,
      tableData: [],
      tableData2: [
        {
          taskid: 'vewnvcnwk',
          type: '色情',
          state: '不通过',
          content: '打电脑情况检查你请客查看尼康',
          time: '2019-09-09',
          user: 'dqwol',
        },
        {
          taskid: 'vewnvcnwk',
          type: '广告',
          state: '嫌疑',
          content: '打电脑情况检查你请客查看尼康',
          time: '2019-09-09',
          user: 'dqwol',
        },
        {
          taskid: 'vewnvcnwk',
          type: '正常',
          state: '通过',
          content: '打电脑情况检查你请客查看尼康',
          time: '2019-09-09',
          user: 'dqwol',
        },
        {
          taskid: 'vewnvcnwk',
          type: '正常',
          state: '通过',
          content: '打电脑情况检查你请客查看尼康',
          time: '2019-09-09',
          user: 'dqwol',
        },
      ],
    };
  },
  mounted() {
    this.getData();
  },
  methods: {
    async getData () {
      // let res = await this.$http.get("communityWhole/noteList");
      let userId = window.sessionStorage.getItem('userId');
      let res = await this.$http.get("communityUser/userInfo/" + userId)
      console.log('xx',res.data.data.comments);
      let list = res.data.data.comments;
      let newList = [];
      for(var i=0;i<list.length;i++) {
        let status = '未审核';
        if(list[i].status == 1) {
          status = '审核通过'
        }
        if(list[i].status == 2) {
          status = '不通过'
        }
        newList.push({
          content: list[i].content,
          status: status,
          userId: list[i].userId,
          noteId: list[i].noteId,
          time: list[i].time.substring(0,10),
          commentId: list[i].commentId
        })
      }
      this.tableData = newList;
      // console.log('shenhe',res.data.data)
    },
    selected(key) {
      //根据key对后台发送请求更改数据，然后再获得最新的需要精选的数据回填select
      console.log(key);
    },
    async handleClick(e) {
      // console.log(e);
      // console.log(e.commentId);
      let res = await this.$http.put("managerOperation/ncStatus?contentId=" + e.commentId +"&isChecked=true")
      // console.log('审核结果',res.data);
      if(res.data.code == 200) {
        this.$message.success('操作成功!');
        this.getData();
      } else {
        this.$message.error('操作失败!')
      }
    },
    async handleClickReject(e) {
      // console.log(e);
      // console.log(e.commentId);
      let res = await this.$http.put("managerOperation/ncStatus?contentId=" + e.commentId +"&isChecked=false")
      // console.log(res);
      if(res.data.code == 200) {
        this.$message.success('操作成功!');
        this.getData();
      } else {
        this.$message.error('操作失败!')
      }
    },
    handleCurrentChange(currentPage) {
      this.nowPage = currentPage;
      //向后台获取数据回填tableData
    },
  },
};
</script>

<style scoped>
.box-card {
  width: 100%;
  margin: 0px 0% auto 0%;
}
.content {
  width: 100%;
  /* margin-left: 5%; */
  /* height: 330px; */
  min-height: 330px;
  /* overflow-y: scroll; */
  /* background-color: blue; */
}
ul {
  position: relative;
}
ul > li {
  list-style: none;
  position: relative;
  margin-top: 10px;
}
.img {
  float: left;
  position: relative;
  width: 40px;
  height: 40px;
  top: 0;
  /* background-color: blue; */
}
.img > img {
  width: 100%;
}
li::after {
  content: '';
  clear: both;
  display: block;
}
.main {
  font-size: 14px;
  margin-left: 50px;
  width: 60%;
}
.name {
  font-size: 12px;
}
.mybtn {
  position: absolute;
  right: 20px;
  top: 10px;
}
.el-button {
  color: #0aa;
}
.danger {
  color: red;
}
</style>

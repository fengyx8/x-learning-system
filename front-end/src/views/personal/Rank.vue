<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span>积分排行榜</span>
    </div>
    <div class="content">
      <!-- <div class="left"> -->
      <div>
        <!-- <el-button type="danger" class="btn1" plain>总榜</el-button> -->
        <!-- <ul style="height:200px;overflow-y: scroll;"> -->
        <ul style="height:200px;">
          <li v-for="(prop, index) in rankList" :key="index">
            <!-- <span :style="'float:left;margin-left:0px;margin-right:10px;color:' + prop.color"> -->
            <span>
              {{ (index+1) + '  ' }}
            </span>
            <img
              style="width:18px;margin-top:-2px"
              src="@/../public/images/女人-女性头像.png"
              alt=""
            />
            <span>{{ ' ' + prop.name }}</span>
            <span style="float:right;margin-right:20px;">
              {{ '   ' + prop.score }}
            </span>
          </li>
        </ul>
      </div>
      <!-- <div class="right">
        <el-button type="danger" class="btn2" plain>组织榜</el-button>
        <ul style="height:200px;overflow-y: scroll;">
          <li v-for="(prop, index) in myClass" :key="index">
            <span
              :style="
                'float:left;margin-left:0px;margin-right:10px;color:' +
                  prop.color
              "
            >
              {{ prop.ranking + '  ' }}
            </span>
            <img
              style="width:18px;margin-top:-2px"
              src="@/../public/images/女人-女性头像.png"
              alt=""
            />

            <span>{{ ' ' + prop.name }}</span>
            <span style="float:right;margin-right:20px">
              {{ '   ' + prop.grade }}
            </span>
          </li>
        </ul>
      </div> -->
    </div>
  </el-card>
</template>

<script>
export default {
  data() {
    return {
      rankList: [],
      total: [
        {
          ranking: 1,
          name: '张三',
          class: '信A',
          grade: 996,
          color: '#f00',
        },
        {
          ranking: 2,
          name: '李四',
          class: '信A',
          grade: 993,
          color: '#ff2d2d',
        },
        {
          ranking: 3,
          name: '王五',
          class: '信B',
          grade: 985,
          color: '#ff8000',
        },
        {
          ranking: 4,
          name: '王五',
          class: '信B',
          grade: 980,
        },
        {
          ranking: 5,
          name: '王五',
          class: '信B',
          grade: 960,
        },
      ],
      // myClass: [
      //   {
      //     ranking: 1,
      //     name: '张三',
      //     grade: 996,
      //     color: '#f00',
      //   },
      //   {
      //     ranking: 2,
      //     name: '王五',
      //     grade: 993,
      //     color: '#ff2d2d',
      //   },
      //   {
      //     ranking: 3,
      //     name: '赵六',
      //     grade: 980,
      //     color: '#ff8000',
      //   },
      //   {
      //     ranking: 4,
      //     name: '赵六',
      //     grade: 970,
      //   },
      //   {
      //     ranking: 5,
      //     name: '赵六',
      //     grade: 960,
      //   },
      // ],
    };
  },
  methods: {
    async getData () {
      let res = await this.$http.get("communityWhole/scoreBoard");
      console.log(res.data)
      let arr = res.data.data.reverse();
      this.rankList = arr.splice(0,10);
      // this.ranklist[0].color = '#f00'
      // this.ranklist[1].color = '#ff2d2d'
      // this.ranklist[2].color = '#ff8000'

    }
  },
  mounted() {
    this.getData();
  },
};
</script>

<style scoped>
li {
  list-style: none;
  margin-top: 5px;
}
.box-card {
  width: 60%;
  margin: 0px 20% auto 20%;
}
.content {
  width: 80%;
  margin: 10px 10%;
  box-sizing: border-box;
  /* background-color: aqua; */
  position: relative;
  height: 300px;
}
.left {
  position: absolute;
  left: 0%;
  width: 50%;
  /* background-color: #f90; */
}
.right {
  position: absolute;
  left: 50%;
  width: 50%;
  /* background-color: blue; */
}
.btn1 {
  margin-left: 33%;
}
.btn2 {
  margin-left: 30%;
}
</style>

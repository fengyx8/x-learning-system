<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <el-row style="width:100%">
        <el-col :span="4" :offset="4"
          ><img
            style="width:60px"
            src="@/../public/images/女人-女性头像.png"
            alt=""
        /></el-col>
        <el-col :span="4" :offset="2">
          <el-row style="font-size:20px">
            <el-col>{{ accountId }}</el-col>
            <el-col>{{ userId }}</el-col>
          </el-row>
        </el-col>
      </el-row>
    </div>
    <el-container class="inf">
      <el-header>
        <el-row class="first">
          <el-col :span="20"
            >积分：<span style="color:#f00;font-size:28px">{{
              integral
            }}</span></el-col
          >
          <el-col :span="4">
            <router-link to="/personal/rank"
              ><span style=" text-decoration: underline"
                >查看排行榜</span
              ></router-link
            >
          </el-col>
        </el-row>
      </el-header>
      <el-container>
        <el-aside class="word" width="40%">
          <ul>
            <li
              v-for="(prop, index) in grade"
              :key="index"
              style="border-bottom:1px solid #aaa"
            >
              <el-row>
                <el-col :span="3" style="margin-top:-2px">
                  <img :src="prop.src" alt="" style="width:20px" />
                </el-col>
                <el-col :span="10">
                  {{ prop.title }}
                </el-col>
                <el-col :offset="6" :span="4">
                  {{ prop.num }}
                </el-col>
              </el-row>
            </li>
          </ul>
        </el-aside>
        <el-main><div id="ech" class="pic"></div></el-main>
      </el-container>
    </el-container>
  </el-card>
</template>

<script>
import img1 from '@/assets/images/4.png';
import img2 from '@/assets/images/1.png';
import img3 from '@/assets/images/2.png';
import img4 from '@/assets/images/3.png';
export default {
  data() {
    return {
      accountId: '',
      userId: '',
      integral: 0,
      grade: [
        {
          src: img1,
          title: '学习',
          num: 52,
        },
        {
          src: img2,
          title: '心得分享',
          num: 86,
        },
        {
          src: img3,
          title: '答题',
          num: 42,
        },
        {
          src: img4,
          title: '评论',
          num: 58,
        },
      ],
    };
  },
  methods: {
    async getData () {
      let res = await this.$http.get("communityUser/userInfo/" + this.userId)
      // console.log('用户信息',res)
      if(res.data.code == 200) {
        this.integral = res.data.data.score;
      }
      if(res.data.code == 500) {
        this.$message.success('请先激活账户！')
        this.$router.push('/active');
      }
    }
  },
  mounted() {
    this.accountId = window.sessionStorage.getItem('name');
    this.userId = window.sessionStorage.getItem('userId');
    this.getData();

    let arr = [];
    let data = [];
    for (let prop of this.grade) {
      arr.push(prop.title);
      data.push({
        value: prop.num,
        name: prop.title,
      });
    }
    let ech = {
      title: {
        text: '积分分布',
        left: 50,
        top: 0,
      },
      legend: {
        left: '300px',
        data: arr,
      },
      series: {
        // name: "进货量",
        type: 'pie',
        data: data,
        label: {
          show: false,
        },
      },
      tooltip: {},
    };
    this.$echarts.init(document.getElementById('ech')).setOption(ech);
  },
};
</script>

<style scoped>
.box-card {
  width: 80%;
  margin: 20px 10% auto 10%;
}

.inf .first {
  margin: 0px auto 0px 20px;
  height: 40px;
  line-height: 40px;
  border-bottom: 1px solid #999;
}

.word {
  margin-top: 30px;
}

.pic {
  width: 90%;
  height: 200px;
  padding: 0;
  padding-left: 10px;
}

.el-main {
  padding: 0;
}
</style>

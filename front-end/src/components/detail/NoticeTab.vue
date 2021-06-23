<template>
    <div class="notice-tab">
        <div class="widget-title">
            讲话原音 <span>Audio</span>
        </div>

        <div v-for="(item,index) in list" :key="item+index">
            <el-row class="my-notices-row">
                    <a :href="item.url" target="_blank">
                    <el-col :span="3">
                        <img src="../../../public/images/新闻.png">
                    </el-col>
                    <el-col :span="21" class="my-title">
                        {{ item.title }}
                    </el-col>
                    </a>
            </el-row>
            <div class="my-time">{{ item.date }}</div>
        </div>

        <router-link to="/morenews?keyword=&type=讲话原音&page=1&year=2021"> 
            <div class="seeMore">查看更多 >></div>
        </router-link>

    </div>
</template>
<script>
  export default {
    data() {
      return {
        page:1,
        list: [],
      };
    },
    methods: {
      async getData () {
        // let res = await this.$http.post("getNews?keyword=&page=1&type=讲话原音&year=")
        // console.log('讲话原音list',res.data);
        // this.list = res.data.lists.slice(0,10);

        let res = {"lists":[{"id":"19746089","title":"习近平：承前启后继往开来 朝着中华民族伟大复兴目标奋勇前进","date":"2012-11-30","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/19746089"},{"id":"20819130","title":"习近平在第十二届全国人民代表大会第一次会议上的讲话","date":"2013-3-18","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/20819130"},{"id":"20893328","title":"习近平：顺应时代前进潮流 促进世界和平发展","date":"2013-3-24","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/20893328"},{"id":"20911841","title":"习近平：永远做可靠朋友和真诚伙伴","date":"2013-3-26","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/20911841"},{"id":"21048139","title":"习近平在博鳌亚洲论坛2013年年会上的主旨演讲","date":"2013-4-8","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/21048139"},{"id":"21959839","title":"习近平同神舟十号航天员亲切通话","date":"2013-6-25","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/21959839"},{"id":"23995306","title":"国家主席习近平发表二〇一四年新年贺词","date":"2014-1-1","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/23995306"},{"id":"24270126","title":"习近平向全国各族人民和全球华人拜年","date":"2014-1-31","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/24270126"},{"id":"24303725","title":"习近平接受俄罗斯电视台专访","date":"2014-2-9","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/24303725"},{"id":"25250527","title":"习近平在纪念全民族抗战爆发七十七周年仪式上的讲话","date":"2014-7-8","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/25250527"},{"id":"26244425","title":"国家主席习近平抵达澳门澳门特别行政区行政长官崔世安等前往机场迎接","date":"2014-12-20","origin":"人民网-人民日报","url":"http://jhsjk.people.cn/article/26244425"},{"id":"26246398","title":"习近平在庆祝澳门回归祖国15周年大会暨澳门特别行政区第四届政府就职典礼上的讲话","date":"2014-12-21","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/26246398"},{"id":"26353652","title":"习近平：共同谱写中拉全面合作伙伴关系新篇章","date":"2015-1-9","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/26353652"},{"id":"26581566","title":"习近平在2015年春节团拜会上的讲话","date":"2015-2-18","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/26581566"},{"id":"27709112","title":"携手消除贫困 促进共同发展","date":"2015-10-17","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/27709112"},{"id":"28855099","title":"习近平在纪念孙中山先生诞辰150周年大会上的讲话","date":"2016-11-12","origin":"人民网-人民日报","url":"http://jhsjk.people.cn/article/28855099"},{"id":"29274595","title":"习近平在“一带一路”国际合作高峰论坛欢迎宴会上的祝酒辞","date":"2017-5-15","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/29274595"},{"id":"29376805","title":"习近平在庆祝香港回归祖国二十周年大会暨香港特别行政区第五届政府就职典礼上的讲话","date":"2017-7-2","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/29376805"},{"id":"29443168","title":"习近平在庆祝中国人民解放军建军90周年大会上的讲话","date":"2017-8-2","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/29443168"}]}

        this.list = res.lists.slice(0,10);
      }
    },
    created () {
      this.getData()
    }
  };
</script>

<style scoped>
    .notice-tab {
        margin-top: 60px;
    }
    img {
        width: 70%;
    }
    .my-title {
        font-family: "Ubuntu", sans-serif;;
        /* font-family: "Open Sans", sans-serif; */
        font-size: 14px;
        /* font-weight: 600; */
        /* color: #000; */
    }
    .my-time {
        font-size: 12px;
        text-align: right;
        /* margin-right: 1em; */
        padding-top: 3%;
        margin-bottom: 12px;
    }
    .seeMore {
        margin-top: 20px;
        text-align: right;
        font-size: 14px;
        border-bottom: 1px solid #EBEEF5;
        padding-bottom: 10px;
        margin-bottom: 60px;
    }
</style>
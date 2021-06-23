<template>
    <div class="notice-tab">
        <div class="widget-title">
            国际资讯 <span>Abroad</span>
        </div>

        <div v-for="(item,index) in list" :key="item+index">
            <el-row class="my-reports-row">
                    <a :href="item.url" target="_blank">
                    <el-col class="my-title">
                        {{ item.title }}
                    </el-col>
                    </a>
            </el-row>
        </div>

        <router-link to="/morenews?keyword=&type=国外最新讲话&page=1&year=">  
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
        // let res = await this.$http.post("getNews?keyword=&page=1&type=国外最新讲话&year=")
        // console.log('国际最新讲话list',res.data);
        // this.list = res.data.lists.slice(0,5);

        let res = {"lists":[{"id":"20893328","title":"习近平：顺应时代前进潮流 促进世界和平发展","date":"2013-3-24","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/20893328"},{"id":"20911841","title":"习近平：永远做可靠朋友和真诚伙伴","date":"2013-3-26","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/20911841"},{"id":"20971990","title":"习近平在刚果共和国议会的演讲（全文）","date":"2013-3-30","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/20971990"},{"id":"23117724","title":"发挥亚太引领作用 维护和发展开放型世界经济","date":"2013-10-8","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/23117724"},{"id":"24303725","title":"习近平接受俄罗斯电视台专访","date":"2014-2-9","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/24303725"},{"id":"24725051","title":"习近平在荷兰《新鹿特丹商业报》发表署名文章","date":"2014-3-25","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/24725051"},{"id":"24736453","title":"习近平在法国《费加罗报》发表署名文章","date":"2014-3-26","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/24736453"},{"id":"24770827","title":"习近平在德国《法兰克福汇报》发表署名文章","date":"2014-3-29","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/24770827"},{"id":"24773109","title":"习近平在比利时《晚报》发表署名文章","date":"2014-3-30","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/24773109"},{"id":"24799696","title":"习近平在布鲁日欧洲学院的演讲","date":"2014-4-2","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/24799696"},{"id":"25008109","title":"中华人民共和国主席习近平致第三届中非民间论坛的贺信","date":"2014-5-13","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/25008109"},{"id":"25110795","title":"习近平：弘扬丝路精神 深化中阿合作","date":"2014-6-6","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/25110795"},{"id":"25214109","title":"弘扬和平共处五项原则　建设合作共赢美好世界","date":"2014-6-29","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/25214109"},{"id":"25236664","title":"习近平在韩国媒体发表署名文章：风好正扬帆","date":"2014-7-4","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/25236664"},{"id":"25291163","title":"习近平在金砖国家领导人第六次会晤上的讲话","date":"2014-7-17","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/25291163"},{"id":"25296593","title":"习近平在巴西国会的演讲：弘扬传统友好 共谱合作新篇","date":"2014-7-18","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/25296593"},{"id":"25515671","title":"习近平在蒙古国媒体发表署名文章：策马奔向中蒙关系更好的明天","date":"2014-8-22","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/25515671"},{"id":"25684408","title":"习近平在印度媒体发表署名文章","date":"2014-9-18","origin":"人民网-人民日报","url":"http://jhsjk.people.cn/article/25684408"},{"id":"26008448","title":"习近平在亚太经合组织第二十二次领导人非正式会议上的闭幕辞","date":"2014-11-12","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/26008448"},{"id":"26032955","title":"习近平：推动创新发展  实现联动增长","date":"2014-11-16","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/26032955"}]}

        
        this.list = res.lists.slice(0,5);
        
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
    .my-reports-row {
      margin-bottom: 10px;
      padding: 5%;
      background-color: #FFFFF0;
      /* border: 1px solid #EBEEF5; */
      /* border-radius: 5px; */
      
    }
    /* .my-reports-row:hover {
      background-color: #FFD808;
    }
    .my-reports-row:hover .my-title {
      color: #000;
    } */
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
    }
</style>
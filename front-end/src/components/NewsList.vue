<template>
  <div>
    <div class="widget-title">
            最新讲话 <span>Latest</span>
    </div>  
  <div class="widget widget-text" style="overflow: auto"> 
      <div class="latest-post-item" v-for="(item,index) in newslist" :key="item.title+index">
        <div class="meta-date"><span>{{item.day}}</span>{{item.month}}</div>
        <div class="title" :href="item.url">
            <el-link :underline="false" :href="item.url" target="_blank">{{item.title}}</el-link>
        </div>
      </div>
  </div>
  <router-link to="/morenews?keyword=&type=国内最新讲话&page=1&year=2021"> 
		<div class="seeMore">查看更多 >></div>
  </router-link>
  </div>
</template>
<script>
export default {
  data() {
    return {
      newslist: [],
      page:1,
    };
  },
  mounted() {
      this.getData();
  },
  methods: {
    async getData () {
      // let res = await this.$http.post("getNews?keyword=&page=1&type=国内最新讲话&year=2021")
      // console.log('国内最新讲话list',res.data);
      // let arr = res.data.lists;

      let arr = [{"id":"32086936","title":"习近平出席海军三型主战舰艇集中交接入列活动","date":"2021-4-25","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/32086936"},{"id":"32090265","title":"习近平向伊拉克总统巴尔哈姆致慰问电","date":"2021-4-28","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/32090265"},{"id":"32091897","title":"中国空间站天和核心舱发射任务成功 习近平致电祝贺","date":"2021-4-29","origin":"新华网","url":"http://jhsjk.people.cn/article/32091897"},{"id":"32096116","title":"习近平向首届中国国际消费品博览会致贺信","date":"2021-5-6","origin":"新华网","url":"http://jhsjk.people.cn/article/32096116"},{"id":"32032918","title":"习近平在党史学习教育动员大会上强调 学党史悟思想办实事开新局 以优异成绩迎接建党一百周年 李克强栗战书汪洋赵乐际韩正王岐山出席 王沪宁主持","date":"2021-2-20","origin":"新华网","url":"http://jhsjk.people.cn/article/32032918"},{"id":"32034282","title":"习近平同吉尔吉斯斯坦总统扎帕罗夫通电话","date":"2021-2-23","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/32034282"},{"id":"32037041","title":"习近平：在全国脱贫攻坚总结表彰大会上的讲话","date":"2021-2-25","origin":"新华网","url":"http://jhsjk.people.cn/article/32037041"},{"id":"32037142","title":"习近平同法国总统马克龙通电话","date":"2021-2-26","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/32037142"},{"id":"32037154","title":"在全国脱贫攻坚总结表彰大会上的讲话","date":"2021-2-26","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/32037154"},{"id":"32038656","title":"坚定不移走中国特色社会主义法治道路 为全面建设社会主义现代化国家提供有力法治保障","date":"2021-2-28","origin":"《求是》","url":"http://jhsjk.people.cn/article/32038656"},{"id":"32038843","title":"坚定不移走中国特色社会主义法治道路，为全面建设社会主义现代化国家提供有力法治保障","date":"2021-3-1","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/32038843"},{"id":"32039915","title":"立志做党光荣传统和优良作风的忠实传人在新时代新征程中奋勇争先建功立业","date":"2021-3-2","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/32039915"},{"id":"32044476","title":"习近平看望参加政协会议的医药卫生界教育界委员","date":"2021-3-6","origin":"新华社","url":"http://jhsjk.people.cn/article/32044476"},{"id":"32045096","title":"习近平参加青海代表团审议","date":"2021-3-7","origin":"新华网","url":"http://jhsjk.people.cn/article/32045096"},{"id":"32047363","title":"实现“十四五”时期国防和军队建设良好开局以优异成绩迎接中国共产党建党100周年","date":"2021-3-10","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/32047363"},{"id":"32051839","title":"努力成为世界主要科学中心和创新高地","date":"2021-3-15","origin":"《求是》","url":"http://jhsjk.people.cn/article/32051839"},{"id":"32054242","title":"习近平向孟加拉国纪念“国父”穆吉布·拉赫曼诞辰100周年暨庆祝独立50周年活动发表视频致辞","date":"2021-3-18","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/32054242"},{"id":"32061251","title":"在服务和融入新发展格局上展现更大作为 奋力谱写全面建设社会主义现代化国家福建篇章","date":"2021-3-26","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/32061251"},{"id":"32065635","title":"中共中央政治局召开会议","date":"2021-3-31","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/32065635"},{"id":"32066280","title":"在党史学习教育动员大会上的讲话","date":"2021-3-31","origin":"《求是》","url":"http://jhsjk.people.cn/article/32066280"},{"id":"32071305","title":"习近平向印尼总统佐科致慰问电","date":"2021-4-7","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/32071305"},{"id":"32077228","title":"加快构建现代职业教育体系 培养更多高素质技术技能人才能工巧匠大国工匠","date":"2021-4-14","origin":"人民网－人民日报","url":"http://jhsjk.people.cn/article/32077228"},{"id":"32079803","title":"在庆祝中国共产党成立95周年大会上的讲话","date":"2021-4-16","origin":"《求是》","url":"http://jhsjk.people.cn/article/32079803"},{"id":"32082047","title":"习近平在清华大学考察时强调 坚持中国特色世界一流大学建设目标方向 为服务国家富强民族复兴人民幸福贡献力量","date":"2021-4-19","origin":"新华社","url":"http://jhsjk.people.cn/article/32082047"}];

      // 数据处理
      let new_arr = [];
      for(var i=0; i<arr.length; i++) {
        if(arr[i].date[6] == '-') {
          new_arr.push ({
            title: arr[i].title,
            url: arr[i].url,
            date: arr[i].date,
            day: arr[i].date.slice(7,9),
            month: this.getMonth(arr[i].date.slice(5,6))
          })
        }
      }
      this.newslist = new_arr;
    },
    getMonth(str) {
      if (str == '12')
          return "Dec";
      else if (str == '11')
          return "Nov";
      else if (str == '10')
          return "Oct";
      else if (str == '9')
          return "Sep";
      else if (str == '8')
          return "Aug";
      else if (str == '7')
          return "Jul";
      else if (str == '6')
          return "Jun";
      else if (str == '5')
          return "May";
      else if (str == '4')
          return "Apr";
      else if (str == '3')
          return "Mar";
      else if (str == '2')
          return "Feb";
      else if (str == '1')
          return "Jan";
      else return str;
    }
  },
};
</script>

<style scoped>
  .widget-title {
    margin-top: 40px;
  }
/* .el-tabs--border-card>.el-tabs__header .el-tabs__item.is-active {
    color: #FFD808;
} */
.widget-text{
  height: 300px;  
}
  .seeMore {
    text-align: right;
    font-size: 14px;
    border-bottom: 1px solid #EBEEF5;
    padding-bottom: 10px;
  }
</style>

<style src="../../public/css/vendor/bootstrap.min.css"></style>
<style src="../../public/css/vendor/owl.carousel.min.css"></style>
<style src="../../public/css/vendor/owl.theme.default.min.css"></style>
<style src="../../public/css/vendor/magnific-popup.css"></style>
<style src="../../public/css/vendor/animate.min.css"></style>
<style src="../../public/css/fontawesome.css"></style>
<style src="../../public/css/brands.css"></style>
<style src="../../public/css/solid.css"></style>
<style src="../../public/css/style.css"></style>
<style>
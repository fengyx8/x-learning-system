<template>
  <div class="home-container">
  <!-- <div class="home-container" v-loading.fullscreen="fullscreenLoading"> -->

    <!-- BACK TO TOP SECTION -->
    <BackTop></BackTop>

    <!-- 头部区域 -->
    <!-- <div class="header header-1"> -->
    <div class="new-header">
    <!-- <div class="header"> -->
        <div class="middlebar d-none d-sm-block">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-3 col-md-3">
                        <div class="logo">
                            <!-- <img src="../assets/images/logo.png" alt="" width="60%" /> -->
                            <img src="../assets/images/logo.png" alt="" width="50%" />
                        </div>
                    </div>
                    <div class="col-9 col-md-9">
                        <div class="contact-info">
                                <div class="body-content">
                                    <!-- <el-button type="primary" @click="checkOut">
                                    退出
                                    </el-button> -->

                                    <el-button type="primary" @click="userRoom">
                                            个人中心
                                    </el-button>
                                </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        

    </div>
    
    <div class="backgroundImage" :id="'anchor-search'">
        <SearchBoxConcise></SearchBoxConcise>
        <!-- <SearchSingle></SearchSingle> -->
    </div>

    <div class="others">
    
        

    <!-- ABOUT -->
    <div class="section" :id="'anchor-about'">
		<div class="content-wrap-140">
			<div class="container">
                        <router-link to="morenews?keyword=&type=原文&page=1&year=">
                            <img src="http://jhsjk.people.cn/images/btn21.png" alt="" class="imgIndex"/>
                        </router-link>
                        <router-link to="morenews?keyword=&type=讲话&page=1&year=">
                            <img src="http://jhsjk.people.cn/images/btn22.png" alt="" class="imgIndex"/>
                        </router-link>
                        <router-link to="morenews?keyword=&type=会议&page=1&year=">
                            <img src="http://jhsjk.people.cn/images/btn23.png" alt="" class="imgIndex"/>
                        </router-link>
                        <router-link to="morenews?keyword=&type=活动&page=1&year=">
                            <img src="http://jhsjk.people.cn/images/btn24.png" alt="" class="imgIndex"/>
                        </router-link>
                        <router-link to="morenews?keyword=&type=考察&page=1&year=">
                            <img src="http://jhsjk.people.cn/images/btn25.png" alt="" class="imgIndex"/>
                        </router-link>
                        <router-link to="morenews?keyword=&type=会见&page=1&year=">
                            <img src="http://jhsjk.people.cn/images/btn26.png" alt="" class="imgIndex"/>
                        </router-link>
                        <router-link to="morenews?keyword=&type=出访&page=1&year=">
                            <img src="http://jhsjk.people.cn/images/btn27.png" alt="" class="imgIndex"/>
                        </router-link>
                        <router-link to="morenews?keyword=&type=函电&page=1&year=">
                            <img src="http://jhsjk.people.cn/images/btn28.png" alt="" class="imgIndex"/>
                        </router-link>
					
                        <div class="spacer-30"></div>
                        <el-divider></el-divider>
                        <div class="spacer-30"></div>

                        <router-link to="morenews?keyword=&type=经济&page=1&year=">
                            <img src="http://jhsjk.people.cn/images/btn1.png" alt="" class="imgIndex"/>
                        </router-link>
                        <router-link to="morenews?keyword=&type=政治&page=1&year=">
                            <img src="http://jhsjk.people.cn/images/btn2.png" alt="" class="imgIndex"/>
                        </router-link>
                        <router-link to="morenews?keyword=&type=文化&page=1&year=">
                            <img src="http://jhsjk.people.cn/images/btn3.png" alt="" class="imgIndex"/>
                        </router-link>
                        <router-link to="morenews?keyword=&type=社会&page=1&year=">
                            <img src="http://jhsjk.people.cn/images/btn4.png" alt="" class="imgIndex"/>
                        </router-link>
                        <router-link to="morenews?keyword=&type=生态&page=1&year=">
                            <img src="http://jhsjk.people.cn/images/btn5.png" alt="" class="imgIndex"/>
                        </router-link>
                        <router-link to="morenews?keyword=&type=党建&page=1&year=">
                            <img src="http://jhsjk.people.cn/images/btn6.png" alt="" class="imgIndex"/>
                        </router-link>
                        <router-link to="morenews?keyword=&type=国防&page=1&year=">
                            <img src="http://jhsjk.people.cn/images/btn7.png" alt="" class="imgIndex"/>
                        </router-link>
                        <router-link to="morenews?keyword=&type=外交&page=1&year=">
                            <img src="http://jhsjk.people.cn/images/btn8.png" alt="" class="imgIndex"/>
                        </router-link>

				
			</div>
		</div>
	</div>

    
    <el-container>
        <el-main>


    <!-- SERVICES -->
    <!-- <div class="section bg-gray-light" :id="'anchor-services'"> -->
    <div class="section" :id="'anchor-services'">
        <!-- <div class="content-wrap pb-0"> -->
        <div class="content-wrap-40">
            <div class="container">

                <div class="row">
                    <div class="col-sm-12 col-md-12">
                        <h3 class="section-heading text-center text-black no-after mb-5">
                            学习关键词 <span class="text-primary">Hot Topics</span>
                        </h3>
                    </div>
                </div>

                <WordCloud></WordCloud>

                <!-- <div class="row">
                    <div id="mymywordcloud" class="chartBox"></div>
                </div> -->

                
            </div>
        </div>

        <div class="content-wrap-40">
                    <div class="col-sm-12 col-md-12">
                        <h3 class="section-heading text-center text-black no-after mb-5">
                            到访地图 <span class="text-primary">Map</span>
                        </h3>
                    </div>

                    
                <Bmap></Bmap>

                    <!-- <div id="mymybmap" class="chartBox-2"></div> -->
        </div>

        <div class="content-wrap-40">
                    <div class="col-sm-12 col-md-12">
                        <h3 class="section-heading text-center text-black no-after mb-5">
                            报道日历 <span class="text-primary">Reports</span>
                        </h3>
                    </div>
                    <!-- zh中文，en英文，详见https://blog.csdn.net/qq_42383670/article/details/109295058 -->
                    <!-- <full-calendar :events="fcEvents" @eventClick="eventClick" @dayClick="dayClick" lang="zh" class="chartBox-3" height="400px"></full-calendar> -->
                    <full-calendar :events="fcEvents" @eventClick="eventClick" lang="zh" class="chartBox-3" height="400px"></full-calendar>
        </div>

        <div class="content-wrap-40">
                    <div class="col-sm-12 col-md-12">
                        <h3 class="section-heading text-center text-black no-after mb-5">
                            学习动态 <span class="text-primary">Timeline</span>
                        </h3>
                    </div>
                    <div id="mymyline" class="chartBox-2"></div>
        </div>

    </div>

    </el-main>

    <el-aside width="30%" class="my-aside">
        <!-- 新闻、公告、研究报告 -->
                        <NewsList></NewsList>
                        <ResearchList></ResearchList>
                        <NoticeTab></NoticeTab>
        <div class="widget-title">
            学习标兵 <span>Rank Top 5</span>
        </div>
        <!-- <div id="mymybar" class="chartBox-right"></div> -->
        <Bar></Bar>

        <div class="widget-title widget-title-2">
            组织榜 <span>Association</span>
        </div>
        <div id="mymypie" class="chartBox-right"></div>
    </el-aside>

    </el-container>

    


    <!-- FOOTER SECTION页尾联系信息 -->
    <Footer></Footer>
    <!-- 路由占位符 -->
    <router-view></router-view>

    
    </div>
    
    
 </div>
</template>

<script src="../../public/js/vendor/modernizr.min.js"></script>
<!-- JS VENDOR -->
<script src="../../public/js/vendor/jquery.min.js"></script>
<script src="../../public/js/vendor/bootstrap.min.js"></script>
<script src="../../public/js/vendor/owl.carousel.js"></script>
<script src="../../public/js/vendor/jquery.magnific-popup.min.js"></script>
<!-- SENDMAIL -->
<script src="../../public/js/vendor/validator.min.js"></script>
<script src="../../public/js/vendor/form-scripts.js"></script>
<script src="../../public/js/script.js"></script>

<script>
import BackTop from '@/components/BackTop'
import SearchBoxConcise from '@/components/index/SearchBox'
import Footer from "@/components/Footer"
import { scrollAnimation } from '../util/smoothScroll'; // 用于平滑滚动的函数

import Bmap from '@/components/index/Bmap';
import WordCloud from '@/components/index/WordCloud';
import Bar from '@/components/index/Bar';

// 新闻三部分
import NewsList from '@/components/NewsList';
import NoticeTab from '@/components/detail/NoticeTab'
import ResearchList from '@/components/detail/ResearchList'

// 通过 js 的方式绘图
import lineObj from '@/assets/js/graph_line'
import pieObj from '@/assets/js/graph_pie'

// 日历
import demoEvents from '@/assets/data/calendar.json'
// 日历测试样例数据 


export default {
  components:{
    BackTop,
    SearchBoxConcise,
    Footer,
    Bmap,
    WordCloud,
    Bar,
    NewsList,
    NoticeTab,
    ResearchList,
    'full-calendar': require('vue-fullcalendar')
  },
  data() {
    return {
      input: '',
      active: 1, //标记锚点
      // fullscreenLoading: true, // 设置定时的、全屏的加载、3000ms
      fcEvents: demoEvents,
    };
  },
  methods: {
        async getData () {
            // let res = await this.$http.get('getCalender/2017');
            // let res = await this.$http.get('getCalender/20');
            // console.log('日历数据',res)

            // console.log('日历数据moban',this.fcEvents)
            // if(res.data.length != 0) {
            //     this.fcEvents = res.data;
            //     console.log('日历数据request',this.fcEvents)
            // }


            // js 作图
            lineObj.paint("mymyline");
            pieObj.paint("mymypie");

            
    },
    userRoom () {
        if(!window.sessionStorage.getItem('token'))
            this.$router.push('login');
        var roleId = window.sessionStorage.getItem('roleId');
        if(roleId == 1) { 
            // 管理员
            this.$router.push('admin')
        }
        if(roleId == 2) { 
            // 一般用户
            this.$router.push('personal')
        }
    },
    checkOut () {
        window.sessionStorage.clear();
        this.$message({
          message: '退出成功',
          type: 'success'
        });
        this.$router.push('/login');
    },
    // 日历的点击事件
    // eventClick (event, jsEvent, pos) {
    //    console.log('eventClick', event, jsEvent, pos);
    //    console.log('eventClickContent', event.title)
    // },
    eventClick (event) {
        console.log('eventClickContent', event)
        if(event.end)
            this.$router.push('morenews?keyword=&type=&page=1&year='+ event.end)
    },
    // 点击当天
    // dayClick(dayDate, allDay, jsEvent, view) {
    //     console.log( 'xx',dayDate, allDay, jsEvent, view )
    // }
    dayClick(date) {
        // console.log( 'xx',date);
        var newDate = date.getFullYear() + "-" + (date.getMonth()+1) + "-"+date.getDate();
        // var newDate = (date.getMonth()+1) ;
        // var newDate = date.getDate();
        // var newDate = date.toLocaleDateString()
        console.log(newDate);
    }
  },

  mounted () {
        this.getData();
  }
}


</script>

<style src="../../public/css/vendor/bootstrap.min.css"></style>
<style src="../../public/css/vendor/owl.carousel.min.css"></style>
<style src="../../public/css/vendor/owl.theme.default.min.css"></style>
<style src="../../public/css/vendor/magnific-popup.css"></style>
<style src="../../public/css/vendor/animate.min.css"></style>
<style src="../../public/css/fontawesome.css"></style>
<style src="../../public/css/brands.css"></style>
<style src="../../public/css/solid.css"></style>
<style src="../../public/css/style.css"></style>

<style scoped>
    /* 头部锚点导航栏 */
    .header-nav {
        margin: 0 auto;
        width: 100%;
        height: 100px;
        position: fixed;
        background-color: #fff;
        border-top: 4px solid #000;
        z-index: 999;
        /* 阴影 */
        box-shadow: 0px 7px 7px rgba(0,0,0,.3);
        transition: all .2s;

    }
    .my-el-row {
        margin: 0 auto;
        padding: 25px 0px 5px;
        width: 90%;
    }
    
    .nav-title {
        /* margin-top: 20px; */
        /* margin-bottom: 10px; */
        padding-top: 13px;
        padding-bottom: 5px;
        text-align: center;
        font-family: "Ubuntu", sans-serif;
        /* font-size: 14px; */
        font-size: 15px;
        color: rgba(0, 0, 0, 0.5);
    }
    .nav-title:hover {
        color: #000;
        cursor: pointer;
        border-bottom: 3px solid #FFD808;
    }
    /* 关于我们 */
    .nav-title-2 {
        margin-left: 8px;
    }
    .active {
        color: #000;
        border-bottom: 3px solid #FFD808;
    }

    /* 搜索框 */
   .backgroundImage {
       padding-top: 70px;
       min-height: 500px;
       /* background: url('../assets/images/banner-bg.png'); */
       background: url('../assets/images/未标题-2.jpg');
       /* 100%是按照图片大小铺满 cover是根据屏幕大小铺满（可能会截取掉一部分） */
       background-size: cover; 
       /* 是否跟随鼠标一起滑动 */
       background-attachment:fixed;
       /* 是否重复铺满  */
       /* background-repeat:no-repeat; */
       width:calc(100%);
       background-position:center;
       height: calc(50%);
       /* 父元素设置relative 子元素设置absolute 实现相对定位*/
       /* position: relative; */
       z-index: 1;
   }
   .middlebar {
       border-top: 2px solid black;
       position: fixed;
       /* height: 100px; */
       height: 60px;
       min-height: 75px;
       width: 100%;
       background-color: rgba(255, 255, 255) !important;
       /* z-index: 3; */
       z-index: 999;
       /* 阴影 */
       box-shadow: 0px 7px 7px rgba(0,0,0,.3);
       transition: all .2s;
   }
   .section {
       z-index: 8;   
   }
   .section-tech {
       background-color: #fff;
       /* background-color: #000; */
       /* background-color: #FFD808; */
   }
   .rs-icon-info-1 {
       /* padding: 33px !important; */
       padding: 63px !important;
   }

   .content-wrap-140 {
       padding: 140px 0;
   }
   /* 16个按钮 */
   .imgIndex {
       /* margin: 1%; */
       width: 12.5%;
       padding: 1%;
       text-align: center;
   }

   /* echarts图表统一格式 */
   .chartBox {
       width: 85%;
       height: 400px;
       border: 1px solid #EBEEF5;
       /* border-radius: 2%; */
       margin: 0 auto;
       /* z-index: 9999; */
    }

    .chartBox-2 {
       width: 85%;
       height: 600px;
       border: 1px solid #EBEEF5;
       margin: 0 auto;
       /* z-index: 9999; */
    }

    .chartBox-3 {
       width: 85%;
       border: 1px solid #EBEEF5;
       margin: 0 auto;
    }

    .chartBox-right {
        width: 100%;
        height: 400px;
        border: 1px solid #EBEEF5;
    }

   /* 技术 */
   .bo-text {
       color: #4d4d4d;
       font-size: 16px;
   }




   /* 展示 */
   .media-img:hover {
       transform: scale(1.05,1.05);
   }
   .get-all-pic {
       width: 80%;
       margin: 0 auto;
       color: #FFD808;
       text-align: center;
   }
   .get-all-pic:hover {
       transform: scale(1.05,1.05);
   }
   /* 团队 */
   .section-team {
       /* background-color: #FFFFF0; */
       background-color: #fff;
       /* background-color: #000; */
   }
    .team-row {
       margin: 0 auto;
       width: 100%;
    }
    .team-center {
        text-align: center;
    }
   div.media {
       /* 人头像周围的背景色，配合 section-team 一起调整 */
       /* background-color: #FFFFF0; */
       background-color: #fff;
       /* background-color: #000; */
   }
   .backgroundWhite {
       background-color: rgba(255, 255, 255) !important;
   }
   /* .img-subsco:after {
       background-color: #FFD808;
   } */

   /* 边栏 */
   .my-aside {
       padding-right: 6%;
   }

   /* 小标题 */
   .widget-title-2 {
       margin-top: 60px;
   }
   
</style>

<style>
    .my-blur {
        width: 100%;
            height: 100%;
            position: relative;
            background: #000;
            background-size: cover;
            box-sizing: border-box;
            z-index: 19;
        /* position: relative; */
    }
    .my-blur::after {
        content: "";
            width: 100%;
            height: 100%;
            position: absolute;
            left: 0;
            top: 0;
            /* 从父元素继承 background 属性的设置 */
            /* background: inherit; */
            /* background-color: #fff; */
            background-color: #000;
            /* filter: blur(30px); */
            filter: blur(50px);
            z-index: 20;
        /* background-color: #000 !important;
        filter: blur(2px) !important;
        z-index: 20 !important; */

    }
    .my-fas {
    width: 110px;
    height: 110px;
    color: #FFD808;
    background-color: transparent;
    -webkit-border-radius: 0;
    -moz-border-radius: 0;
    -ms-border-radius: 0;
    border-radius: 0;
    padding-top: 17px;
    font-size: 60px; }

    /* 日历 */
    .full-calendar-body .dates .dates-events .events-week .events-day .event-box .event-item {
        overflow: show !important;
        padding: 0 20% !important;
    }
    .new-header {
        /* background-color: rgb(238, 243, 171); */
    }
</style>

<style type="text/css">
    .anchorBL{
        display:none
    }
</style>
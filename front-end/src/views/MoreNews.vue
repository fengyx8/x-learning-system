<template>
  <div class="moreNews">

    <BackTop></BackTop>

  <div>
    <!-- Header -->
    <!-- <div class="header header-1 sticky-header">
    <div class="middlebar d-none d-sm-block">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-3 col-md-3">
            <div class="logo">
              <router-link to="home">
              <img src="../assets/images/logo.png" alt="" width="50%" />
              </router-link>
            </div>
          </div>
          
          <div class="col-9 col-md-9">
            <div class="contact-info">
              <div class="rs-icon-1">
                <div class="icon">
                  <router-link to="home">
                  <div class="fas fa-home"></div>
                  </router-link>
                </div>
                <div class="body-content">
                  <router-link to="home">
                  <div class="heading">首页</div>
                  </router-link>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div> -->


    <div class="header sticky-header">
    <!-- MIDDLE BAR -->
    <div class="middlebar d-none d-sm-block">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-3 col-md-3">
            <div class="logo">
              <router-link to="home">
              <img src="../assets/images/logo.png" alt="" width="50%" />
              </router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>



    <!-- BANNER -->
    <!-- <div class="section banner-page backgroundImage"> -->
    <div class="section banner-page backgroundImage">
        <div class="content-wrap pos-relative">
            <div class="container">
                <div class="col-12 col-md-12">
                    <div class="d-flex bd-highlight mb-2">
                        <div class="title-page">检索结果</div>
                    </div>
                    <ol class="breadcrumb">
                      <li class="breadcrumb-item">共有  <span :data="totalRecords"> {{ totalRecords }} </span>  篇相关结果</li>
                    </ol>
                </div>
            </div>

        </div>
    </div>

  </div>

  
    <div class="card-box-news-2">
      <div class="news-component">
        <el-table v-loading="loading" :data="newslist">
          
          <el-table-column prop="date" label="日期" width="180"></el-table-column>
          <el-table-column prop="title" label="标题">
            <template slot-scope="newslist">
              <a :href="newslist.row.url" target="_blank" class="TestCSS"
              >{{ newslist.row.title }}
              </a>
            </template>
          </el-table-column>
          <el-table-column prop="origin" label="来源" width="180"></el-table-column>
        </el-table>

        <!-- 分页组件 -->
        <div class="block">
          <el-pagination
           :page-size="20"
           layout="prev, pager, next"
           :total="totalRecords"
           :current-page="this.page"
           @current-change="currentChange"
           @prev-click="prevpage"
           @next-click="nextpage"
          ></el-pagination>
        </div>
      
      </div>
    </div>

    <Footer></Footer>
  </div>
</template>
<script>
// import data from '../../public/data/新闻示例.json'
import BackTop from '@/components/BackTop';
import Footer from "@/components/Footer";


export default {
  components: {
    BackTop,
    Footer,
  },
  data() {
    return {
      loading: true,
      totalRecords: 0,
      newslist: [],
      keyword: decodeURI(this.$route.query.keyword),
      type: decodeURI(this.$route.query.type),
      // page: parseInt(this.$route.query.page),
      page: decodeURI(this.$route.query.page),
      year: decodeURI(this.$route.query.year),
      // type: "讲话",
    };
  },
  methods: {
    async loadMoreNews(keyword, type, page, year) {
      this.page = page;
      this.type = type;
      this.keyword = keyword;
      this.year = year;
      console.log(page);

      //处理url的显示问题
      // if(page!=1)
      // {
        this.$router.replace({
        path: this.$route.path,
        query: {
          keyword: this.keyword,
          type: this.type,
          page: this.page,
          year: this.year
        }
      });
      // }
      

      // let { data } = await this.$get("/data/morenews_expect.json");
      
      
      this.loading = true;
      let res = await this.$http.post("getNews?keyword="+this.keyword+"&page="+this.page+"&type="+this.type+"&year="+this.year)
      console.log('list',res.data);
      
      this.totalRecords = res.data.totalRecords;
      this.newslist = res.data.lists;
      this.loading = false;
    },
    currentChange(val) {
      this.page = val;
      this.loadMoreNews(this.keyword,this.type,val,this.year);
    },
    prevpage(val) {
      this.page = val;
      this.loadMoreNews(this.keyword,this.type,val,this.year);
    },
    nextpage(val) {
      this.page = val;
      this.loadMoreNews(this.keyword,this.type,val,this.year);
    },
  },
  created() {
    this.loadMoreNews(this.keyword,this.type,1,this.year);

  },
};
</script>

<style scoped>
/* 头部 */
.header {
    /* position: fixed; */
    /* height: 100px;
    width: 100%;
    background-color: rgba(255, 255, 255) !important; */
    z-index: 999;
    box-shadow: 0px 7px 7px rgba(0,0,0,.3);
    transition: all .2s;
}
.sticky-header {
  position: sticky;
  top: 0;
}
.middlebar {
       border-top: 2px solid black;
       /* position: fixed; */
       height: 60px;
       min-height: 75px;
       width: 100%;
       background-color: rgba(255, 255, 255) !important;
       /* 阴影 */
       box-shadow: 0px 7px 7px rgba(0,0,0,.3);
       transition: all .2s;
   }
    .moreNews {
      width: 100%;
      margin: 0 auto;
    }
    .backgroundImage{
      /* background-image: url('../assets/images/banner-bg.png'); */
      background-image: url('../assets/images/bg33.jpg');
      background-attachment:fixed; 
      background-repeat:no-repeat;
      width:calc(100%);
      height: calc(100%);
    }
    .news-component {
      margin-top: 50px;
    }
    .card-box-news-2 {
      margin-top: 60px;
      margin-bottom: 20px;
      width: 80%;
      margin-left: 10%;
    }
    .block {
        margin-top: 70px;
        margin-bottom: 30px;
    }
    div.el-pagination {
        text-align: center;
    }
    li:hover {
        color: #FFD808 !important;
    }
</style>

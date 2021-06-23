<template>
      <!-- Header -->
    <!-- <div class="header header-1 sticky-header"> -->
    <div class="header">
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
          <div class="col-9 col-md-9">
            <div class="contact-info">
              <div class="body-content">
                <el-button type="primary" @click="checkOut">
                  退出
                </el-button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script src="../../public/js/vendor/modernizr.min.js"></script>
<script>
export default {
  methods: {
    checkOut () {
        window.sessionStorage.clear();
        this.$message({
          message: '退出成功',
          type: 'success'
        });
        this.$router.push('/login');
    },
  }
};
</script>

<style scoped>
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
       z-index: 999;
   }
</style>
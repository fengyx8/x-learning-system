<template>
<!-- FOOTER SECTION -->
<div class="footer" id="footer">
	<div class="content-wrap">
			<div class="row">
				<div class="col-sm-6 col-md-6 col-lg-4">
					<div class="footer-item">
					</div>
				</div>
				<div class="col-sm-6 col-md-6 col-lg-4">
					<div class="footer-item">
						<img src="../assets/images/logo.png" alt="logo bottom" class="logo-bottom" width="50%"/>
					</div>
				</div>
			</div>
	</div>
	<div class="fcopy">
		<!-- <div class="container"> -->
			<!-- <div class="row"> -->
				<div class="col-sm-12 col-md-12 col-lg-12">
					<p class="mt-3 text-center">Copyright 2021 
						<!-- <a href="home" class="copyright-link">XLearn</a> -->
						<router-link to="home" class="copyright-link">XLearn
						</router-link>
						– All rights reserved.</p>
				</div>
			<!-- </div> -->
		<!-- </div> -->
	</div>
		
	</div>
</template>
<script src="../../public/js/vendor/modernizr.min.js"></script>


<script>
export default {}
</script>

<style src="../../public/css/vendor/bootstrap.min.css"></style>

<style src="../../public/css/vendor/owl.theme.default.min.css"></style>
<style src="../../public/css/vendor/magnific-popup.css"></style>
<style src="../../public/css/vendor/animate.min.css"></style>
<style src="../../public/css/fontawesome.css"></style>
<style src="../../public/css/brands.css"></style>
<style src="../../public/css/solid.css"></style>
<style src="../../public/css/style.css"></style>

<style>
	.footer-item {
		text-align: center;
	}
	.footer-item span{
		color: rgb(255,216,8);
		margin-top: 30px;
	}
</style>

<style scoped>
	.copyright-link {
		color: #FFD808;
	}
	.copyright-link:hover {
		text-decoration: underline;
	}
	/* 底部 */
.footer {
  background-color: #fff !important;
  background-image: url('../assets/images/图片2.png');
  color: #ffffff;
  background-size: cover;
  background-position: center;
  /*border-top: 2px solid $color-primary;*/
  position: relative; 
}
</style>
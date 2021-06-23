<template>
    <div>
        <BackTop></BackTop>

			<div class="container">
				<div class="row">
					<div class="col-sm-12 col-md-11 pleft">
						<h4 class="text-black mt-0">心得体会</h4>
						<form class="form-contact">
							<div class="form-group">
								<textarea v-model="my_input" class="form-control" rows="8" placeholder="分享你的心得体会吧"></textarea>
							</div>
            </form>
						<button type="submit" class="btn btn-primary" @click="submit_notes">发表心得</button>
						
					</div>
				</div>
			</div>
		
    </div>

</template>

<script>
import BackTop from '@/components/BackTop';

export default {
  components: {
    BackTop,
  },
  data () {
    return {
      my_input: ''
    }
  },
  methods: {
    async submit_notes () {
      // console.log('用户输入', this.my_input)
      let res = await this.$http.post("userOperation/note?content=" + this.my_input)
      // console.log('发布心得', res)
      if(res.status == 200)
        this.$message.success('发表成功！等待管理员审核')
      this.$router.push('/personal/experience')
      
      
    }
  }
    
}
</script>

<style scoped>
</style>
<template>
	<div>
			<div class="container">

				<div class="row">

					<div class="col-sm-12 col-md-12" v-for="(item,index) in list" :key="item+index">
						<div class="rs-icon-info-3 mb-5">
							<div class="info-icon">
								<i class="fas fa-comments comments" style="color: #c61202;"></i>
							</div>
							<div class="info-text">
								<h4 class="text-black mb-2">{{ item.userId }}</h4>
								<p>{{ item.content }}</p>
								<div class="xinde-info">
									<!-- <i class="fas fa-thumbs-up" style="font-size: 20px; color: #bdbdbd; padding-left: 5px;" @click="like_btn(item.noteId, index)"></i> -->
									<!-- <span style="width: 50px;">{{ item.like }}</span> -->
									<span class="grey" style="font-size: 14px;">发表时间：{{ item.time }} </span>
									<!-- <span>发表人员：{{ item.userId }}</span> -->
								</div>
							</div>
							<div class="compick" v-show="item.commentNum!=0">
								<div class="comment-one">
									<div class="comment-one-usr">
										<span>评论({{ item.commentNum }})</span>
									</div>
									<div v-for="(item2,index2) in item.commentList" :key="item2+index2">
										<h4 class="text-black mb-2" style="font-size: 20px; padding-left: 1%;">{{ item2.userId }}</h4>
										<div class="comment-one-con" >{{ item2.content }}</div>
										<div class="xinde-info">
											<!-- <i class="fas fa-thumbs-up" @click="like_btn_comment(item2.commentId,index,index2)" style="font-size: 20px; color: #bdbdbd; padding-left: 20px;"></i> -->
											<!-- <span style="width: 50px;"> {{ item2.like }}</span> -->
											<span class="grey" style="margin-left: 2%; font-size: 14px;" >发表时间：{{ item2.time }}</span>
									</div>
									</div>
								</div>

								<!-- <div class="pinglun" style="width: 70%; display: flex;">
								<el-input placeholder="请输入内容..." style="display: inline;" v-model="item.self_input"></el-input>
								<el-button type="danger" style="margin-left: 3%;" @click="summit_comment(item.noteId,item.self_input,index)">发表</el-button>
								</div> -->
									
							</div>
							
						</div>
					</div>



				</div>

				
			</div>
	</div>
</template>

<script>
export default {
	data () {
		return {
			list: []
		}
	},
	methods: {
		async getData () {
			let res = await this.$http.get("communityWhole/noteList");
			console.log('社群',res.data);
			this.list = res.data.data;

			let arr = [];
			for(var i=0; i<res.data.data.length; i++) {
				// let result = await this.$http.get("communityWhole/likeList/" + res.data.data[i].noteId);
				let result2 = await this.$http.get("communityWhole/commentList/" + res.data.data[i].noteId);
				// console.log('like',result.data.data);
				console.log('comment',result2.data.data);

				let myCommentList = result2.data.data;
				// if(result2.data.data.length != 0) {
				// 	// 有评论
				// 	for(var j=0; j<result2.data.data.length; j++) {
				// 		let result3 = await this.$http.get("communityWhole/likeList/" + result2.data.data[j].commentId);
				// 		myCommentList[j].like = result3.data.data.length;
				// 		myCommentList[j].likeBefore = false;
				// 	}
				// }
				arr.push({
					// likeBefore: false,
					// like: result.data.data.length,
					noteId: res.data.data[i].noteId,
					content: res.data.data[i].content,
					time: res.data.data[i].time,
					userId: res.data.data[i].userId,
					commentNum: result2.data.data.length,
					// commentList: result2.data.data
					commentList: myCommentList
				})
			}

			this.list = arr;

		},
		async like_btn (noteId, index) {
			if(this.list[index].likeBefore == true) {
				return this.$message.error('您已经点赞过啦,明天再来试试吧!');
			}
			let res = await this.$http.post("userOperation/like?contentId="+noteId);
			// console.log('dianzan', res.data);
			if(res.data.code == 200) {
				this.list[index].like += 1;
				this.list[index].likeBefore = true;
				return this.$message.success('点赞成功！');
			}
			this.$message.error('点赞失败！请稍后再试。')
		},
		async like_btn_comment (commentId, index, index2) {
			if(this.list[index].commentList[index2].likeBefore == true) {
				return this.$message.error('您已经点赞过啦,明天再来试试吧!');
			}
			let res = await this.$http.post("userOperation/like?contentId="+commentId);
			// console.log('dianzan', res.data);
			if(res.data.code == 200) {
				this.list[index].commentList[index2].like += 1;
				this.list[index].commentList[index2].likeBefore = true;
				return this.$message.success('点赞成功！');
			}
			this.$message.error('点赞失败！请稍后再试。')
		},
		async summit_comment (noteId, self_input, index) {
			let res = await this.$http.post("userOperation/comment?content=" + self_input +"&noteId=" + noteId)
			console.log('发布评论', res)
			if(res.status == 200) {
				this.list[index].self_input = '';
				return this.$message.success('发表成功！等待管理员审核')
			}
			this.$message.error('发布失败！请稍后再试。')
		}
	},
	mounted () {
		this.getData();
	}
}
</script>

<style scoped>

p {
	margin: 0;
}

#xindebackground{
			background-color: #c61202;
		}
		#comments{
			color: #c61202;
		}

		.compick{
			margin-left: 90px;
		}

		.pinglun{
			/* margin-left: 20px; */
			margin-top: 10px;
		}

		.zantu{
			color: #c61202;
		}

		.wenben{
			border-color: #bdbdbd;
			border: 1px solid #ccc;
                padding: 7px 0px;
                border-radius: 3px;
                padding-left:5px;
                -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
                box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
                -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
                -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
                transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s
		}

		input:focus{
			/* border-color: #c61202; */
			border: 2px solid #c61202;
            outline: none;
		}

		.but{
			width: 200px;
			background-color: #c61202;
			text-align: center;
			border-radius:50px;
			box-shadow:0px 1px 2px rgba(0,0,0,0.2);
			text-shadow:0px 1px 1px rgb(255, 255, 255);
			color:white;
	}
	.but-box{
		margin-left: 250px;
		margin-top: 100px;
		margin-bottom: 0px;
	}
	.grey{
		color: grey;
	}

	.comment-one{
		/* margin-top: 30px; */
		box-shadow: 0px 0px 1px 1px #e6e4e4;
		padding-bottom: 1px;
	}

	.comment-one-usr{
		/* padding-left: 30px; */
		padding: 10px;
		box-shadow: 0px 0px 1px 1px #e6e4e4;
		background-color: #e6e4e4;
		/* font-size: 20px; */
	}
	.comment-one-con{
		margin-left: 50px;
		margin-right: 50px;
		margin-top: 10px;
	}
	.comment-one-time{
		margin-left: 50px;
		margin-top: 20px;
		font-size: 15px;
		color: #bdbdbd;
		margin-bottom: 10px;
	}
	.comment-one-zan{
		padding-left: 50px;
		height: 30px;
		margin-bottom: 5px;
	}
	.comment-two{
		margin-left: 70px;

		margin-top: 0px;
		border-color: grey;
		background-color:#FFD808;
		width: 800px;
		border: 1px solid #ccc;
                padding: 7px 0px;
                border-radius: 3px;
                padding-left:5px;
                -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
                box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
                -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
                -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
                transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s
	}
	.comment-two-con{
		margin-left: 80px;
	}
	.comment-two-time{
		color: #bdbdbd;
		font-size: 10px;
		margin-left: 80px;
	}

	#xinde-input{
		width: 1000px;
		height: 300px;
		border: 1px solid #ccc;
                padding: 7px 0px;
                border-radius: 3px;
                padding-left:5px;
                -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
                box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
                -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
                -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
                transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s
	}
	.huifu-input{
		border-color: #bdbdbd;
		width: 400px;
		height: 30px;
			border: 1px solid #ccc;
                padding: 7px 0px;
                border-radius: 3px;
                padding-left:5px;
                -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
                box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
                -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
                -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
                transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s
		
	}
	.huifu-but{
		text-decoration:none;
	background:#c61202;
	color:#f2f2f2;
	font-size:16px;
	font-family: 微软雅黑,宋体,Arial,Helvetica,Verdana,sans-serif;
	font-weight:bold;
	border-radius:3px;
	
	-webkit-transition:all linear 0.30s;
	-moz-transition:all linear 0.30s;
	transition:all linear 0.30s;
	}
	.xinde-input{
		margin-bottom: 20px;
	}
	.fabiao{
		text-decoration:none;
	background:#c61202;
	color:#f2f2f2;
	padding: 10px 30px 10px 30px;
	font-size:16px;
	font-family: 微软雅黑,宋体,Arial,Helvetica,Verdana,sans-serif;
	font-weight:bold;
	border-radius:3px;
	
	-webkit-transition:all linear 0.30s;
	-moz-transition:all linear 0.30s;
	transition:all linear 0.30s;

	}

	.img-female{
		margin: 0px;
		border: 0px;
		padding: 0px;
	}

	#xinde-input:focus{
                    border-color: #66afe9;
                    outline: 0;
                    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(233, 102, 109, 0.6);
                    box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(233, 102, 109, 0.6)
            }
 
.yongyin:hover {
    background: #000000;
}



</style>

<style>
.el-input__inner {
	border-color: #dcdfe6 !important;
}
</style>
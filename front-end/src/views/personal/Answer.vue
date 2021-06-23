<template>
  <div>

    <form>
	<div class="divCss">
	<div style="font-size: 20px; font-weight: 600; margin-bottom: 2em;">
		1. <span :data="problem">{{problem}}</span>
	</div>
		<ol type="A" start="" class="olCss" name="single">
			<p><input class="input" type="radio" name="place1" value="A"  v-model="ans"/>A．<span :data="optionA">{{optionA}}</span></p>
			<p><input class="input" type="radio" name="place1" value="B"  v-model="ans"/>B．<span :data="optionB">{{optionB}}</span></p>
			<p><input class="input" type="radio" name="place1" value="C"  v-model="ans"/>C．<span :data="optionC">{{optionC}}</span></p>
			<p><input class="input" type="radio" name="place1" value="D"  v-model="ans"/>D．<span :data="optionD">{{optionD}}</span></p>
		</ol>
	</div>
  <!-- <el-input v-model="ans" :disabled="isdisabled" style="margin-bottom: 80px;"></el-input> -->
	<button type="submit" class="btn btn-primary" @click="submit" v-if="!showAnswer">提交</button>
</form>

    <div v-if="showAnswer">
      <div class="card">
                  <div class="card-body">
                    <p>
                    【回答】<span :data="isCorrect">{{isCorrect==true?'正确':'错误'}}</span>
                    </p>
                    <p>
                    【选择】<span :data="ans">{{ans}}</span>
                    </p>
                    <p>
                    【正确答案】<span :data="stdAns">{{stdAns}}</span>
                    </p>
                    <p>
                    【解析】<span :data="stdAns">{{analysis}}</span>
                    </p>
                  </div>
                  
      </div>
      <button type="submit" class="btn btn-primary" @click="try_next" style="margin-top: 2%;">继续闯关</button>
    </div>
    

  </div>
  
</template>

<script>
export default {
  data () {
    return {
      showAnswer: false,
      isdisabled: false,
      isCorrect: false,
      problem: '',
      ans: '',
      optionA:'',optionB:'',optionC:'',optionD:'',
    }
  },
  methods: {
    async getData () {
      // let userId = window.sessionStorage.getItem('userId');
      // 产生随机题号
      // let n = Math.floor(Math.random()*10+1) // 返回[0,1) -> [1,10]整数
      let n = Math.floor(Math.random()*48+1); // 返回[0,1) -> [1,48]整数
      this.n = n;
      let {data:res} = await this.$http.get("communityWhole/question/" + "q" + n);
      console.log('ansRecords',res.data)
      this.problem = res.data.problem;
      this.stdAns = res.data.stdAns;
      this.analysis = res.data.analysis;
      this.optionA = res.data.optionA;
      this.optionB = res.data.optionB;
      this.optionC = res.data.optionC;
      this.optionD = res.data.optionD;
    },
    async submit () {
      this.showAnswer = true;
      this.isdisabled = true;
      let {data:res} = await this.$http.post("userOperation/answer?ans=" + this.ans + "&queId=" + "q" + this.n);
      console.log('回答结果',res)
      if(res.data.correct == true)
        this.isCorrect = true
    },
    try_next () {
      this.showAnswer = false;
      this.isdisabled = false;
      this.ans = '';
      this.isCorrect = false;
      this.getData();
    }
  },
  mounted () {
    this.getData();
  }
}
</script>

<style>

</style>
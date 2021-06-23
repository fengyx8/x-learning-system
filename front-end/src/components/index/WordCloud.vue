<template>
    <div class="cloud-wrap">
        <div class="my-card-box-2">
          <div class="cloud-box" ref="cloudEl"></div>
        </div>
    </div>

</template>

<script>
var echarts = require('echarts')
import 'echarts-wordcloud';

import $router from '../../router/index'

import ccdata from '../../../public/data/词云示例.json'
export default {
  props: {},
  data() {
    return {
      cloudData: []
    };
  },
  mounted() {
    this.getData();
  },
  methods: {
    async getData () {
        // let {data} = await this.$get("http://192.168.43.94:8290/getWordCloud")

                // 本地测试
                // let  {data}  = await this.$get("/data/词云示例.json");

                let data = ccdata;
                
        let arr = [];
        let max = 0; // 最高词频
        let min = 9999; //最低词频
        for(var i=0; i<data.wordCloud.length; i++) {
          let myValue = data.wordCloud[i].count;
          arr.push({
            name: data.wordCloud[i].word,
            // value: myValue
            value: Math.ceil(myValue)
          })
          if (myValue < min) {
            min = myValue;
          }
          if (myValue > max) {
            max = myValue;
          }
        }
        this.cloudData = arr;

        console.log('词云：', this.cloudData)

        // this.cloudData = data.wordCloud;
        // this.drawCloud(this.$refs.cloudEl, this.cloudData);

        if(max ==  min) // 否则在visualMap里会出错，刻度置灰
          max = min + 4;
        this.drawCloud(this.$refs.cloudEl, this.cloudData, max, min);
    },
    drawCloud(wrapEl, data, max, min) {
      let myChart = echarts.init(wrapEl);
      
      var option = {
            tooltip: {
              show: true,
            },
            visualMap: {
              min: min,
              max: max,
              inRange: {
                color: ['#2F93C8', '#AEC48F', '#FFDB5C', '#F98862']
              },
              itemWidth: 8,
              // itemHeight: 200,
              itemHeight: 300,
              left: 'right',
              text: ['高频词','低频词'],
              textStyle: {
                overflow: 'breakAll', // 截断
              },
              hoverLink: true
            },
            series: [
              {
                name: "热词",
                type: "wordCloud",
                layoutAnimation: true,
                sizeRange: [35, 80],
                rotationRange: [-45, 45],
                // rotationRange: [0, 0],
                drawOutOfBound: false, //是否允许词绘制在canvas之外
                shape: 'circle', // 自带的形状，可选circle（默认）、square、triangle、star、pentagon、triangle-forward 等
                // left: "center",
                top: "center",
                width: "90%",
                left: "0%",
                // width: "85%",
                height: "100%",
                // height: "80%",
                gridSize: 4, // 词间距
                textPadding: 0,
                autoSize: {
                  enable: true,
                  minSize: 6,
                },
                // 更换字体颜色
                textStyle: {
                  fontFamily: 'sans-serif',
                  // fontWeight: 'bold',
                  // Color can be a callback function or a color string
                  // color: function () {
                  //   // Random color
                  //   return 'rgb(' + [
                  //       Math.round(Math.random() * 160),
                  //       Math.round(Math.random() * 160),
                  //       Math.round(Math.random() * 160)
                  //   ].join(',') + ')';
                  // }
                },
                emphasis: {
                  focus: 'self',
                  textStyle: {
                    shadowBlur: 10,
                    shadowColor: '#333'
                  }
                },
                data: data,
              },
            ],
          };
      myChart.setOption(option);

      // 为 echarts 图表添加点击事件
      myChart.on('click', function(param) {
        // console.log(param);
        // console.log(param.data.name); //获取热词名称

        $router.push({
          path: "/morenews",
          query: {
            keyword: param.data.name,
            type: '',
            page: 1,
            year: ''
          }
        })


      });
      
    },
  }
};


</script>

<style scoped>
    .cloud-wrap {
      margin: 0 auto;
      width: 90%;
      height: 400px;
    }

    
    .card-box {
      width: 100%;
      text-align: left;
    }
    .my-card-box-2 {
      width: 100%;
      border: 1px solid #EBEEF5;
      border-radius: 5px;
      height: 400px;
    }
    .cloud-box {
      width: 100%;
      height: 400px;
    }
    
</style>

<style>
    /* div.el-card__body {
      padding: 0px !important;
    } */
</style>
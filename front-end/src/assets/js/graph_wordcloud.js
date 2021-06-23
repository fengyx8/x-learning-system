var echarts = require("echarts");
import 'echarts-wordcloud';
import router from '../../router/index';

export default {
    paint: function (data, graphID) {
        var myChart = echarts.init(document.getElementById(graphID));

        var arr = [];
        var max = 0; // 最高词频
        var min = 9999; //最低词频
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
        if(max ==  min) // 否则在visualMap里会出错，刻度置灰
          max = min + 4;

        data = arr;
        

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
        // window.open(href + 'whole?query='+ param.data.name);

        router.push({
          path: "/whole",
          query: {
            query: param.data.name
          }
        })


      });
    }
}
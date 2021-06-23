var echarts = require("echarts");

export default {
    paint: function (pieIndustrySingle){
        var myChart = echarts.init(document.getElementById(pieIndustrySingle));
    
        var option = {};
        option = {
            tooltip: {
                trigger: 'axis',
                axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                    type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: [
                {
                    type: 'category',
                    data: ['张三', '李四', '王五', '赵六', '小七'],
                    axisTick: {
                        alignWithLabel: true
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value'
                }
            ],
            series: [
                {
                    name: '积分',
                    type: 'bar',
                    barWidth: '60%',
                    data: [390, 352, 200, 134, 90]
                }
            ]
        };
    
        myChart.setOption(option);
    
    
    }
}
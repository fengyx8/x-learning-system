var echarts = require("echarts");
import router from '../../router/index';

export default {
    paint: function (data, mainInterest){
        var myChart = echarts.init(document.getElementById(mainInterest));
        //myChart.showLoading();
    
        n = data.interest.length;
        // data = data.interest;
        
        var option = {};
    
        function getNodes (arr) {
            var nodes = [];
            for (var i=0; i<arr.length; i++) {
                var x = arr[i].symbolSize;
                if(x>=6)
                    x = 70;
                else
                    x = x * 5 + 40;
                nodes.push({
                    name: arr[i].name,
                    // category: 1,
                    // symbolSize: arr[i].symbolSize * 5 + 40
                    symbolSize: x
                })
            }
            return nodes;
        }

        if(n == 0) {
            // 没有数据
            option = {
                title: {
                    text: '数据暂无',
                    left: 'center'
                },
            };
            myChart.setOption(option);
        }

        if(n == 1) {
            // 只有一年的数据

            var json = data.interest[0].series;
            option = {
                tooltip: {
                    formatter: function (params) {
                        return params.marker + params.name;
                    }
                },
                series: [{
                    type: 'graph',
                    layout: 'force',
                    symbolSize: 20,
                    roam: false, // 是否能够缩放和漫游
                    data: getNodes(json),
                    force: {
                        repulsion: 100,
                        layoutAnimation: false
                    },
                    label: {
                        show: true
                    },
                    itemStyle: {
                        color: function () {
                            var colors = ['#51689b', '#ce5c5c', '#fbc357', '#8fbf8f', '#659d84', '#fb8e6a', '#c77288', '#786090', '#91c4c5', '#6890ba'];
                            return colors[Math.floor(Math.random() * 10)];
                        }
                    }
                }],
                            
            };
    
    
            myChart.setOption(option);
    
        // 为 echarts 图表添加点击事件
        myChart.on('click', function(param) {
            // console.log(param);
            // console.log(param.data.name); //获取热词名称
            // window.open(href + 'whole?query='+ param.data.name);
    
            if(param.dataType == 'node') {
                router.push({
                    path: "/whole",
                    query: {
                        query: param.data.name
                    }
                })
            }
            
        });
    
        }
    
    
        if(n >= 2) {
            // 有多年数据
            // 时间是乱序的，应当按从小到大排列
            data.interest =  data.interest.sort(function (a,b) {
                return a.year - b.year;
            });

            var timeline = [];
            var series = [];
            for(var i = 0; i < n; i++) {
                timeline.push(data.interest[i].year);
                series.push(data.interest[i].series);
            }
            data = {
                timeline: timeline,
                series: series
            }
    
        option = {
            baseOption: {
                timeline: {
                    axisType: 'category',
                    // orient: 'vertical',
                    autoPlay: true,
                    playInterval: 2000,
                    width: 600,
                    left: 'center',
                    symbol: 'diamond',
                    lineStyle:{
                        color:'#ccc',
                        width: 1,
                        type:'dashed'
                    },
                    checkpointStyle: {
                        symbol: 'diamond',
                        symbolSize: '13',
                        // opacity: 0.8,
                        // symbol: 'arrow',
                        // symbolRotate: '270',
                        // symbolOffset: ['-15%',0],
                    },
                    controlStyle: {
                        showNextBtn: false,
                        showPrevBtn: false
                    },
                    data: [],
                    
                },
                title: [
                    {
                    text: data.timeline[0],
                    textAlign: 'center',
                    // left: '63%',
                    top: '1%',
                    right: 'right',
                    textStyle: {
                        fontSize: 30
                    }
                }, 
                // {
                //     text: '研究领域'
                // }
                ],
                tooltip: {
                    formatter: function (params) {
                        if(params.dataType == 'node')
                            return params.seriesName + ' 年' + '</br>' + params.marker + params.name;
                        else // 时间轴上的点
                            return params.name + '年';
                    }
                },
                series: [
                    {
                        type: 'graph',
                        layout: 'force',
                        symbolSize: 20,
                        roam: false, // 是否能够缩放和漫游
                        data: getNodes(data.series[0]),
                    }
                ],
                animationDurationUpdate: 1000,
                animationEasingUpdate: 'quinticInOut'
            },
            options: []
        };
    
    
        for (var n = 0; n < data.timeline.length; n++) {
            option.baseOption.timeline.data.push(data.timeline[n]);
            option.options.push({
                title: {
                    show: true,
                    'text': data.timeline[n] + ''
                },
                series: {
                    name: data.timeline[n],
                    data: getNodes(data.series[n]),
                    type: 'graph',
                    layout: 'force',
                    symbolSize: 20,
                    roam: false, // 是否能够缩放和漫游
                    force: {
                        repulsion: 100,
                        layoutAnimation: false
                    },
                    // data: nodes,
                    label: {
                        show: true
                    },
                    itemStyle: {
                        color: function () {
                            var colors = ['#51689b', '#ce5c5c', '#fbc357', '#8fbf8f', '#659d84', '#fb8e6a', '#c77288', '#786090', '#91c4c5', '#6890ba'];
                            return colors[Math.floor(Math.random() * 10)];
                        }
                    }
                }
            });
        }
    
    
    
    
        myChart.setOption(option);
    
        // 为 echarts 图表添加点击事件
        myChart.on('click', function(param) {
            // console.log(param);
            // console.log(param.data.name); //获取热词名称
            // window.open(href + 'whole?query='+ param.data.name);
    
            if(param.dataType == 'node') {
                router.push({
                    path: "/whole",
                    query: {
                        query: param.data.name
                    }
                })
            }
            
        });
    
    }

    

    }
    
}
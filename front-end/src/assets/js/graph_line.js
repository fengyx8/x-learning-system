var echarts = require("echarts");

export default {
    paint: function (pieIndustrySingle){
        var myChart = echarts.init(document.getElementById(pieIndustrySingle));
    
        var option = {};
        option = {
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross',
                    label: {
                        backgroundColor: '#6a7985'
                    }
                }
            },
            legend: {
                data: ['18信A', '18信B', '18档案', '18图书馆学', '19档案']
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
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
                    boundaryGap: false,
                    data: ['2020年12月', '2021年1月', '2021年2月', '2021年3月', '2021年4月', '2021年5月', '2021年6月']
                }
            ],
            yAxis: [
                {
                    type: 'value'
                }
            ],
            series: [
                {
                    name: '心得发布',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {},
                    emphasis: {
                        focus: 'series'
                    },
                    data: [120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name: '答题数',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {},
                    emphasis: {
                        focus: 'series'
                    },
                    data: [220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name: '点赞数',
                    type: 'line',
                    stack: '总量',
                    label: {
                        show: true,
                        position: 'top'
                    },
                    areaStyle: {},
                    emphasis: {
                        focus: 'series'
                    },
                    data: [150, 232, 201, 154, 190, 330, 410]
                },
                // {
                //     name: '直接访问',
                //     type: 'line',
                //     stack: '总量',
                //     areaStyle: {},
                //     emphasis: {
                //         focus: 'series'
                //     },
                //     data: [320, 332, 301, 334, 390, 330, 320]
                // },
                // {
                //     name: '搜索引擎',
                //     type: 'line',
                //     stack: '总量',
                //     label: {
                //         show: true,
                //         position: 'top'
                //     },
                //     areaStyle: {},
                //     emphasis: {
                //         focus: 'series'
                //     },
                //     data: [820, 932, 901, 934, 1290, 1330, 1320]
                // }
            ]
        };
    
        myChart.setOption(option);
    
    
    }
}
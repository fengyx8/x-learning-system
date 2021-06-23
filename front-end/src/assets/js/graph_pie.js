var echarts = require("echarts");

export default {
    paint: function (pieIndustrySingle){
        var myChart = echarts.init(document.getElementById(pieIndustrySingle));
        var option = {};

        option = {
            tooltip: {
                trigger: 'item'
            },
            legend: {
                top: '5%',
                left: 'center'
            },
            series: [
                {
                    name: '支部积分',
                    type: 'pie',
                    radius: ['40%', '70%'],
                    avoidLabelOverlap: false,
                    label: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        label: {
                            show: true,
                            fontSize: '40',
                            fontWeight: 'bold'
                        }
                    },
                    labelLine: {
                        show: false
                    },
                    data: [
                        {value: 1048, name: '18信A'},
                        {value: 735, name: '18信B'},
                        {value: 580, name: '18档案'},
                        {value: 484, name: '18图书馆学'},
                        {value: 300, name: '19档案'}
                    ]
                }
            ]
        };
        
    
        myChart.setOption(option);
    
    
    
    }
}
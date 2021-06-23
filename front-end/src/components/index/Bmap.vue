<template>
    <div id="maintest" v-loading="loading"></div>
</template>

<script>
var echarts = require('echarts')
require('echarts/extension/bmap/bmap')
import router from '../../router/index'

import demo from '@/assets/data/map.json'

function graph(level1,level2,level3,level4,level5) {
var myChart = echarts.init(document.getElementById('maintest'));
var option;

// 示例数据
// var data2 = [
//     {name: '海门', value: [113,28.21,100]},
//      {name: '鄂尔多斯', value: [115.480656,35.23375,120]},
//      {name: '招远', value: [125.03,46.58,780], stock_code: '600433'}
// ];

option = {
    tooltip : {
        trigger: 'item',
        formatter: function (params) {
            return params.marker + params.seriesName
            + '<br/>' + params.name
        }
    },
    bmap: {
        // center: [112.114129, 37.550339],
        center: [78.114129, 12.550339],
        // zoom: 5,
        zoom: 1,
        roam: true,
        silent: true, // 不响应和触发鼠标事件，否则点击节点跳转至新页面时地图会聚焦到那个点
        mapStyle: {
            styleJson: [{
                'featureType': 'railway',
                'elementType': 'all',
                'stylers': {
                    'visibility': 'off'
                }
            }, {
                'featureType': 'highway',
                'elementType': 'all',
                'stylers': {
                    'color': '#fdfdfd'
                }
            }, {
                'featureType': 'highway',
                'elementType': 'labels',
                'stylers': {
                    'visibility': 'off'
                }
            }, {
                'featureType': 'arterial',
                'elementType': 'geometry',
                'stylers': {
                    'color': '#fefefe'
                }
            }, {
                'featureType': 'arterial',
                'elementType': 'geometry.fill',
                'stylers': {
                    'color': '#fefefe'
                }
            }, {
                'featureType': 'poi',
                'elementType': 'all',
                'stylers': {
                    'visibility': 'off'
                }
            }, {
                'featureType': 'green',
                'elementType': 'all',
                'stylers': {
                    'visibility': 'off'
                }
            }, {
                'featureType': 'subway',
                'elementType': 'all',
                'stylers': {
                    'visibility': 'off'
                }
            }, {
                'featureType': 'manmade',
                'elementType': 'all',
                'stylers': {
                    'color': '#d1d1d1'
                }
            }, {
                'featureType': 'local',
                'elementType': 'all',
                'stylers': {
                    'color': '#d1d1d1'
                }
            }, {
                'featureType': 'arterial',
                'elementType': 'labels',
                'stylers': {
                    'visibility': 'off'
                }
            }, {
                'featureType': 'building',
                'elementType': 'all',
                'stylers': {
                    'color': '#d1d1d1'
                }
            }, {
                'featureType': 'label',
                'elementType': 'labels.text.fill',
                'stylers': {
                    'color': '#999999'
                }
            }]
        }
    },
    series : [
        
        {
            name: '城市Level2',
            type: 'scatter',
            coordinateSystem: 'bmap',
            // data: json,
            data: level2,
            symbolSize: 10,
            encode: {
                value: 2
            },
            label: {
                formatter: '{b}',
                position: 'top',
                show: false
            },
            itemStyle: {
                // color: '#ddb926'
            },
            emphasis: {
                label: {
                    show: true
                },
                scale: true,
            }
        },
        {
            name: '城市Level3',
            type: 'scatter',
            coordinateSystem: 'bmap',
            // data: json,
            data: level3,
            symbolSize: 15,
            encode: {
                value: 2
            },
            label: {
                formatter: '{b}',
                position: 'top',
                show: false
            },
            itemStyle: {
                // color: '#ddb926'
            },
            emphasis: {
                label: {
                    show: true
                },
                scale: true,
            }
        },
        {
            name: '城市Top',
            type: 'effectScatter',
            coordinateSystem: 'bmap',
            // data: level5.sort(function (a, b) {
            //     return b.value[2] - a.value[2];
            // }).slice(0, 5),
            data: level5,
            symbolSize: 35,
            // symbolSize: function (val) {
            //     return val[2] * 15 + 40;
            // },
            encode: {
                value: 2
            },
            showEffectOn: 'render',
            rippleEffect: {
                brushType: 'stroke'
            },
            hoverAnimation: true,
            label: {
                formatter: '{b}',
                position: 'right',
                show: true
            },
            itemStyle: {
                // color: '#18D070',
                color: 'rgba(255,99,71, 0.7)',
                shadowBlur: 10,
                shadowColor: '#333'
                // shadowColor: '#18D070'
            },
            emphasis: {
                scale: true,
            },
            zlevel: 1
        },
        {
            name: '城市Level4',
            type: 'scatter',
            coordinateSystem: 'bmap',
            // data: json,
            data: level4,
            symbolSize: 20,
            encode: {
                value: 2
            },
            label: {
                formatter: '{b}',
                position: 'top',
                show: false
            },
            itemStyle: {
                // color: '#ddb926'
            },
            emphasis: {
                label: {
                    show: true
                },
                scale: true,
            }
        },
        {
            name: '城市Level1',
            type: 'scatter',
            coordinateSystem: 'bmap',
            // data: json,
            data: level1,
            symbolSize: 8,
            // symbolSize: function (val) {
                // return val[2] * 20 + 20;
            // },
            encode: {
                value: 2
            },
            label: {
                formatter: '{b}',
                position: 'top',
                show: false
            },
            itemStyle: {
                // color: '#ddb926'
            },
            emphasis: {
                label: {
                    show: true
                },
                scale: true,
            }
        },
    ]
};

myChart.setOption(option);

// 为 echarts 图表添加点击事件
    myChart.on('click', function(param) {
        // console.log(param);
        // console.log(param.data.name); //获取热词名称

        // if(param.dataType == 'node') {
            router.push({
                path: "/morenews",
                query: {
                    keyword: param.data.name,
                    type: '',
                    page: 1,
                    year: ''
                }
            })
        // }
        
    });


}



export default {
    data () {
        return {
            list: [],
            loading: true,
            level1: [],
            level2: [],
            level3: [],
            level4: [],
            level5: [],
        }
    },
    methods: {
        graph,
        async getData () {
            // let {data} = await this.$get(
            //     "http://192.168.43.94:8290/getGraph"
            // )

            // 本地测试
            // let  {data}  = await this.$get("/data/multi.json");
            // console.log('地图数据',data)

            let data = demo;

            // 数据处理
            let arr = [];
            for(var i=0; i<data.geo.length; i++) {
                let oneValue = [];
                oneValue.push(data.geo[i].lng);
                oneValue.push(data.geo[i].lat);
                oneValue.push(0.2);
                if(data.geo[i].level == 1)
                    this.level1.push({
                        name: data.geo[i].name,
                        value: oneValue,
                    })
                if(data.geo[i].level == 2)
                    this.level2.push({
                        name: data.geo[i].name,
                        value: oneValue,
                    })
                if(data.geo[i].level == 3)
                    this.level3.push({
                        name: data.geo[i].name,
                        value: oneValue,
                    })
                if(data.geo[i].level == 4)
                    this.level4.push({
                        name: data.geo[i].name,
                        value: oneValue,
                    })
                if(data.geo[i].level == 5)
                    this.level5.push({
                        name: data.geo[i].name,
                        value: oneValue,
                    })
                arr.push({
                    name: data.geo[i].name,
                    value: oneValue,
                });
            }
            this.list = arr;
            
            // console.log('地图>')
            // console.log(arr)
            setTimeout(() => {
                this.graph(this.level1,this.level2,this.level3,this.level4,this.level5);
                this.loading = false;
            }, 1000);
            
        },
        async getData2 () {
            let res = await this.$http.get(
                "/getGraph"
            )
            console.log('地图request',res);
            let data = res.data;

            // 析构
            // let {data} = await this.$http.get(
            //     "getGraph"
            // )
            // console.log('xx',data);
            // let data = res;


            // 本地测试
            // let  {data}  = await this.$get("/data/multi.json");
            // console.log(data)

            // 数据处理
            let arr = [];
            for(var i=0; i<data.geo.length; i++) {
                let oneValue = [];
                oneValue.push(data.geo[i].lng);
                oneValue.push(data.geo[i].lat);
                oneValue.push(0.2);
                arr.push({
                    name: data.geo[i].name,
                    value: oneValue,
                });
            }
            this.list = arr;
            
            // console.log('地图>')
            // console.log(arr)
            setTimeout(() => {
                this.graph(this.list);
                this.loading = false;
            }, 1000);
            
        },
    },
    mounted () {
        this.getData();
        // this.getData2();
    },
    
}
</script>

<style scoped>
    #maintest {
        width: 90%; 
        height: 600px; 
        border: 1px solid #EBEEF5;
        margin: 0 auto;
        margin-bottom: 30px;
        margin-top: 60px;
    }
</style>

<style type="text/css">
    .anchorBL{
        display:none
    }
</style>
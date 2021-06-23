var echarts = require("echarts");
require('echarts/extension/bmap/bmap')
import router from '../../router/index';

export default {
    paint: function (data, graphID) {
        var myChart = echarts.init(document.getElementById(graphID));
        
        // 数据处理 
        let arr = [];
            for(var i=0; i<data.geo.length; i++) {
                let oneValue = [];
                oneValue.push(data.geo[i].lng);
                oneValue.push(data.geo[i].lat);
                oneValue.push(data.geo[i].value);
                arr.push({
                    name: data.geo[i].company_name,
                    value: oneValue,
                    stock_code: data.geo[i].stock_code,
                });
            }
        var json = arr;
        
        console.log('地图数据',json);
        var option;

// 示例数据
// var data2 = [
//     {name: '海门', value: [113,28.21,100]},
//      {name: '鄂尔多斯', value: [115.480656,35.23375,120]},
//      {name: '招远', value: [125.03,46.58,780], stock_code: '600433'}
// ];


option = {
    // title: {
    //     text: '企业地图',
    //     textStyle: {
    //         color: '#fff'
    //     }
    // },
    tooltip : {
        trigger: 'item',
        formatter: function (params) {
            return params.marker + params.seriesName
            + '<br/>' + params.name
            // + '<br/>' + '股票代码：' + params.data.stock_code;
        }
    },
    bmap: {
        // center: [104.114129, 37.550339],
        // center: [112.114129, 37.550339],
        center: [112.114129, -18.550339],
        zoom: 5,
        // zoom: 1,
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
            name: '相关企业',
            type: 'scatter',
            // type: 'effectScatter',
            coordinateSystem: 'bmap',
            // data: convertData(data),
            data: json,
            // data: data2,
            // symbolSize: 20,
            symbolSize: function (val) {
                // return val[2].slice(0,2) / 4;
                // return val[2] / 150000000 + 10;
                return val[2] * 20 + 20;
            },
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
            name: 'Top 5',
            type: 'effectScatter',
            coordinateSystem: 'bmap',
            // data: data2,
            data: json.sort(function (a, b) {
                return b.value[2] - a.value[2];
            }).slice(0, 5),
            // symbolSize: 30,
            symbolSize: function (val) {
                // return val[2].slice(0,2) / 2;
                // return val[2] / 150000000 + 15;
                return val[2] * 15 + 40;
            },
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
                shadowBlur: 10,
                shadowColor: '#333'
                // shadowColor: '#18D070'
            },
            emphasis: {
                scale: true,
            },
            zlevel: 1
        }
    ]
};

myChart.setOption(option);


// 为 echarts 图表添加点击事件
    myChart.on('click', function(param) {
        // console.log(param);
        // console.log(param.data.name); //获取热词名称
        // window.open(href + 'whole?query='+ param.data.name);

        // if(param.dataType == 'node') {
            router.push({
                path: "/detail",
                query: {
                    stockCode: param.data.stock_code
                }
            })
        // }
        
    });


    }
}
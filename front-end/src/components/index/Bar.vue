<template>
    <div id="maintestBar" v-loading="loading"></div>
</template>

<script>
var echarts = require('echarts')

function graph(nameList, scoreList) {
var myChart = echarts.init(document.getElementById('maintestBar'));
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
                    // data: ['张三', '李四', '王五', '赵六', '小七'],
                    data: nameList,
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
                    // data: [390, 352, 200, 134, 90]
                    data: scoreList
                }
            ]
        };

myChart.setOption(option);



}



export default {
    data () {
        return {
            nameList: [],
            scoreList: [],
            loading: true
        }
    },
    methods: {
        graph,
        async getData () {
            let res = await this.$http.get("communityWhole/scoreBoard");
            console.log(res.data)
            let arr = res.data.data.reverse();
            let arr2 = arr.splice(0,5);

            // 数据处理
            for(var i=0;i<arr2.length;i++) {
                this.nameList.push(arr2[i].name)
                this.scoreList.push(arr2[i].score)
            }
            
            console.log('条图>',this.nameList)
            console.log('条图>',this.scoreList)

            setTimeout(() => {
                this.graph(this.nameList, this.scoreList);
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
    #maintestBar {
        width: 100%;
        height: 400px;
        border: 1px solid #EBEEF5;
    }
</style>

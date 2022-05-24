<template>
  <div id="leiDaTu" style="width: 1200px;height: 1200px;"></div>
</template>
<script>
  export default {
    data(){
      return{
      }
    },
    created() {
    },
    methods:{
      drawPie() {
        //1、导入 echarts
        const eCharts = require('echarts')
        let charts = eCharts.init(document.getElementById('leiDaTu'));
        var option = {
          title: {
            text: "java工程师等级划分标准",
            // target: "blank",
            // textAlign: 'bottom',
          },
          tooltip: {},//提示层
          legend: {
            data: ['java初级工程师','java中级工程师','java高级工程师','java架构师']
          },
          radar: {
            splitNumber: 5, // 雷达图圈数设置
            name: {
              formatter:'【{value}】',
              textStyle: {
                color: '#0C0C0C', //字体颜色
                // backgroundColor: '#999', //背景色
                // borderRadius: 3, //圆角
                // padding: [6,5,2,5] //padding
              }
            },
            splitArea: {
              areaStyle: {
                color: ['rgba(114, 0, 209, 0.2)',
                  'rgba(210, 200, 100, 0.2)', 'rgba(114, 172, 209, 0.6)',
                  'rgba(114, 172, 209, 0.8)', 'rgba(210, 200, 100, 1)'],
                shadowColor: 'rgba(0, 0, 0, 0.3)',
                shadowBlur: 10
              }
            },
            axisLine: {
              lineStyle: {
                color: 'rgba(255, 255, 255, 255)'
              }
            },
            splitLine: {
              lineStyle: {
                color: 'rgba(255, 255, 255, 255)'
              }
            },
            center: ['50%', '50%'],
            radius: '60%',
            //shape: 'circle',//雷达图形状设置
            startAngle: 90,
            indicator: [
              {name: '基础算法',
              max: 100
            },
              {
                name: 'java开发基础',
                max: 100
              },
              {
                name: '数据库设计优化',
                max: 100
              },
              {
                name: '高并发',
                max: 100
              },
              {
                name: 'java语言基础',
                max: 100
              },
              {
                name: '主流Web框架',
                max: 100
              },
              {
                name: '英语阅读能力',
                max: 100
              },
              {
                name: '工程工具',
                max: 100
              },
              {
                name: '业务能力',
                max: 100
              },
              {
                name: 'Linux系统',
                max: 100
              },
              {
                name: '沟通协调能力',
                max: 100
              },
            ],
          },
          series: [
            {
            name: '测试标题名字',
            type: 'radar',
              // itemStyle : {//设置线条和折点的颜色
              //   normal : {
              //     color:'#00FF00',
              //     lineStyle:{
              //       color:'#91CC75'
              //     }
              //   }
              // },
              emphasis: {//当点击圈线时，会凸显
                lineStyle: {
                  width: 4
                }
            },
            data: [
              {
              value: [75,40,30,20,70,60,70,60,50,40,75],
              name: "java初级工程师",
                itemStyle : {//设置线条和折点的颜色
                  normal : {
                    color:'#00FF00',
                    lineStyle:{
                      color:'#91CC75'
                    }
                  }
                },
              areaStyle: {
                color: 'rgba(255, 255, 255, 0.5)'
              }
            },
              {
                value: [75,60,50,50,85,78,70,77,80,67,75],
                name: "java中级工程师",
                areaStyle: {
                  color: 'rgba(255, 255, 255, 0.5)'
                }
              },
              {
                value: [90,80,75,75,85,85,78,85,85,80,80],
                name: "java高级工程师",
                areaStyle: {
                  color: 'rgba(255, 255, 255, 0.5)'
                }
              },
              {
                value: [95,90,95,95,85,90,85,90,95,92,98],
                name: "java架构师",
                areaStyle: {
                  color: 'rgba(255, 255, 255, 0.5)'
                }
              },
            ]
          }]
        }
        charts.setOption(option);
      }
    },
    //调用mounted时，此时页面上的DOM元素已经被初始化了
    mounted() {
      this.$nextTick(function() {
        this.drawPie('leiDaTu')
      })
    }
  }
</script>
<style lang="less" scoped>

</style>

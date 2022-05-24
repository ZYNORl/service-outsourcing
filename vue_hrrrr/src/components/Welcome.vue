<template>
    <div>
        <div id="treeChart" :style="{width: '100%', height: '870px'}"></div>
    </div>
</template>

<script>
    export default {
        name: "eCharts",
        data() {
            return {
                treeData:[]
            }
        },
        mounted() {
            this.showChart();
        },
        methods: {
            async showChart() {
                const eCharts = require('echarts')
                // 基于准备好的dom，初始化echarts实例
                var myChart = eCharts.init(document.getElementById('treeChart'));

                const {data:res} = await this.$http.get('getPosCateTree')
                this.treeData = res

                var theme = {
                    darkMode:true,
                    color: ['#4992ff','#7cffb2','#fddd60','#ff6e76','#58d9f9',
                        '#05c091','#ff8a45','#8d48e3','#dd79ff'],
                    backgroundColor:"#333744",
                };
                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: '职位划分',
                        textStyle: {
                            fontSize: 18,
                            fontWeight: 'bolder',
                            color: '#B9B8CE'          // 主标题文字颜色
                        },
                    },
                    tooltip: {
                        trigger: 'item',
                        triggerOn: 'mousemove'
                    },
                    series: [
                        {
                            type: 'tree',

                            data: this.treeData,
                            // line:"circle",
                            top: '1%',
                            left: '7%',
                            bottom: '1%',
                            right: '20%',

                            symbolSize: 7,

                            label: {
                                position: 'left',
                                verticalAlign: 'middle',
                                align: 'right',
                                fontSize: 13
                            },

                            leaves: {
                                label: {
                                    position: 'right',
                                    verticalAlign: 'middle',
                                    align: 'left'
                                }
                            },
                            emphasis:{
                              focus:'descendant'
                            },
                            expandAndCollapse: true,
                            animationDuration: 550,
                            animationDurationUpdate: 750
                        }
                    ]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
                myChart.setOption(theme);
            }
        }
    }
</script>

<style>

</style>


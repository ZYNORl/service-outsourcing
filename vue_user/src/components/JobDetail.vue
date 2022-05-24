<template>
    <div>
        <div style="margin: 40px">
            <el-card class="box-card">
                <el-button type="primary" size="small" plain icon="el-icon-d-arrow-right"  @click="toudi()"
                >一键投递</el-button>
                <el-collapse v-model="activeNames" @change="handleChange">
                    <el-collapse-item title="企业信息" name="1">
                        <el-row :gutter="0">
                            <el-col :span="16"><div>企业名称：{{JobDetail.job.company.name}}</div></el-col>
                            <el-col :span="16"><div>法人代表：{{JobDetail.job.company.legalperson}}</div></el-col>
                            <el-col :span="16"><div>注册资本：{{JobDetail.job.company.fund}}</div></el-col>
                            <el-col :span="16"><div>成立日期：{{JobDetail.job.company.date}}</div></el-col>
                            <el-col :span="16"><div>企业类型：{{JobDetail.job.company.type}}</div></el-col>
                            <el-col :span="16"><div>经营状态：{{JobDetail.job.company.status}}</div></el-col>
                            <el-col :span="16"><div>注册地址：{{JobDetail.job.company.address}}</div></el-col>
                            <el-col :span="16"><div>统一社会信用代码：{{JobDetail.job.company.code}}</div></el-col>
                            <el-col :span="16"><div>经营范围：{{JobDetail.job.company.range}}</div></el-col>
                            <el-col :span="16"><div>基本介绍：{{JobDetail.job.company.introduce}}</div></el-col>
                        </el-row>
                    </el-collapse-item>
                    <el-collapse-item title="职位信息" name="2">
                        <el-row :gutter="0">
                            <el-col :span="16"><div>职位名称：{{JobDetail.job.submitJob.position}}</div></el-col>
                            <el-col :span="16"><div>薪资范围：{{JobDetail.job.submitJob.salary}}</div></el-col>
                            <el-col :span="16"><div>发布日期：{{JobDetail.job.submitJob.submitdate}}</div></el-col>
                            <el-col :span="16"><div>工作地址：{{JobDetail.job.submitJob.address}}</div></el-col>
                            <el-col :span="16"><div>学历要求：{{JobDetail.job.submitJob.edu}}</div></el-col>
                            <el-col :span="16"><div>工作经验：{{JobDetail.job.submitJob.yearLimit}}</div></el-col>
                            <el-col :span="16"><div>额外要求：{{JobDetail.job.submitJob.extraAsk}}</div></el-col>
                            <el-col :span="16"><div>职位福利：{{JobDetail.job.submitJob.welfare}}</div></el-col>
                        </el-row>
                    </el-collapse-item>
                    <el-collapse-item title="职位要求职业素质画像">
                        <div id="leiDaTu" style="width: 750px;height: 750px;"></div>
                    </el-collapse-item>
                </el-collapse>
            </el-card>
        </div>
        <div style="margin: 40px">
        </div>
    </div>
</template>

<script>
    export default {
        data(){
            return{
                indicator:[],
                activeNames: ['2'],
                JobDetail: '',
                queryInfo:{
                    JobId : window.sessionStorage.getItem("JobId"),
                },
                toudiParameters:{
                    position:window.sessionStorage.getItem("position"),
                    JobId:window.sessionStorage.getItem("JobId"),
                    userid:window.sessionStorage.getItem("userId"),
                    scores:window.sessionStorage.getItem("scores"),
                    comid:''
                }
            }
        },
        created() {
            this.getJobDetail();
        },
        methods:{
            async getJobDetail(){
                console.log(this.queryInfo.JobId)
                const {data:res}=await this.$http.get('/getJobDetail',{params:this.queryInfo})
                this.$message.success('获取职位详情成功')
                this.JobDetail = res
                console.log(res)
                const {data:result} = await this.$http.get('/getSkills',{params:{positionName:this.JobDetail.job.submitJob.position}})
                this.indicator = result.indicatorSkillList;
                this.$nextTick(function() {
                    this.drawPie('leiDaTu')
                })
            },
            handleChange(val) {
                console.log(val);
            },
            async toudi(id){
                this.toudiParameters.comid = this.JobDetail.job.company.id
                const {data:result} = await this.$http.get('/toudi/push',{params:this.toudiParameters})
                if(result.code===200){
                    return this.$message.success("投递成功")
                }else{
                    return this.$message.error("投递失败")
                }
            },
            async drawPie() {
                //1、导入 echarts
                const eCharts = require('echarts')
                let charts = eCharts.init(document.getElementById('leiDaTu'));
                var option = {
                    tooltip: {},//提示层
                    legend: {
                        data: ['java初级工程师']
                    },
                    radar: {
                        splitNumber: 5, // 雷达图圈数设置
                        name: {
                            formatter:'【{value}】',
                            textStyle: {
                                color: '#0C0C0C',
                            }
                        },
                        splitArea: {
                            areaStyle: {
                                color: ['rgba(114, 172, 209, 0.2)',
                                    'rgba(114, 172, 209, 0.4)', 'rgba(114, 172, 209, 0.6)',
                                    'rgba(114, 172, 209, 0.8)', 'rgba(114, 172, 209, 1)'],
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
                        indicator:this.indicator,
                    },
                    series: [
                        {
                            name: '测试标题名字',
                            type: 'radar',
                            emphasis: {//当点击圈线时，会凸显
                                lineStyle: {
                                    width: 4
                                }
                            },
                            data: [
                                {
                                    value: this.JobDetail.jobScoreList.scorelist,
                                    name: "java初级工程师标准",
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
                            ]
                        }]
                }
                charts.setOption(option);
            },
            //调用mounted时，此时页面上的DOM元素已经被初始化了
            mounted() {
                // this.$nextTick(function() {
                //     this.drawPie('leiDaTu')
                // })
            }

        }
    }
</script>

<style scoped>

</style>
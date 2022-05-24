<template xmlns:box-shadow="http://www.w3.org/1999/xhtml">
    <div style="width:100%;height:100%;padding-top: 30px;margin-left: -100px">
        <el-collapse style="margin: -10px 200px 10px 250px" v-model="activeNames" @change="handleChange">
            <el-collapse-item title=">>员工职业素质画像" name="1">
                <div id="leiDaTu" style="width: 750px;height: 750px; margin: 0 auto"><span>员工职业素质画像</span></div>
            </el-collapse-item>
        </el-collapse>
        <div style="width: 75%;margin: 0px auto;">
            <div style="width: 60%;margin: 0px auto">
                <el-alert
                        class="elAlert"
                        :title="record.userInfo.user.name+' 个人档案'"
                        type="info"
                        center
                        show-icon :closable = "false">
                </el-alert>
            </div>
            <div class="block">
                <el-timeline>
                    <el-timeline-item timestamp="自我介绍" placement="top">
                        <el-card>
                                <el-row :gutter="2">
                                    <el-col :span="8">
                                        <div style="margin: 15px 0px 15px 40px">
                                            <img v-bind:src="record.userInfo.user.photo" width="150px" height="180px"/>
                                        </div>
                                    </el-col>
                                    <el-col :span="15">
                                        <div style="width: 100%;text-align: left;margin-left: -60px;margin-top: 30px">
                                        <p>{{record.userInfo.user.introduce}}</p>
                                        </div>
                                    </el-col>
                                </el-row>
                        </el-card>
                    </el-timeline-item>
                    <el-timeline-item timestamp="基本信息" placement="top">
                        <el-card>
                            <div style="padding: 0 40px">
                                <el-row :gutter="15">
                                    <el-col :span="6"><span>姓名：{{record.userInfo.user.name}}</span></el-col>
                                    <el-col :span="6"><span>性别：{{record.sex}}</span></el-col>
                                    <el-col :span="6"><span>年龄：{{record.age}}</span></el-col>
                                    <el-col :span="6"><span>职称：{{record.userInfo.user.posname}}</span></el-col>
                                </el-row>
                                <el-row :gutter="15">
                                    <el-col :span="6"><span>民族：{{record.userInfo.user.nation}}</span></el-col>
                                    <el-col :span="6"><span>政治面貌：{{record.userInfo.user.politicStatus}}</span></el-col>
                                    <el-col :span="6"><span>邮箱：{{record.userInfo.user.email}}</span></el-col>
                                    <el-col :span="6"><span>电话：{{record.userInfo.user.tel}}</span></el-col>
                                </el-row>
                                <el-row :gutter="15">
                                    <el-col :span="6"><span v-if="record.userInfo.user.english===1">英文水平： 四级</span></el-col>
                                    <el-col :span="6"><span v-if="record.userInfo.user.english===2">英文水平： 六级</span></el-col>
                                    <el-col :span="6"><span v-if="record.userInfo.user.english===3">英文水平： 雅思>=7</span></el-col>
                                    <el-col :span="6"><span v-if="record.userInfo.user.english===4">英文水平： 托福>=95</span></el-col>
                                    <el-col :span="6"><span>最高学历：{{record.userInfo.user.maxEduBack}}</span></el-col>
                                    <el-col :span="6"><span>政治面貌：{{record.userInfo.user.politicStatus}}</span></el-col>
                                </el-row>
                                <el-row :gutter="15">
                                    <el-col :span="6"><span v-if="record.userInfo.user.eduBen">学校：{{record.userInfo.user.eduBen}}</span></el-col>
                                    <el-col :span="6"><span v-if="record.userInfo.user.benMajor">专业： {{record.userInfo.user.benMajor}}</span></el-col>
                                    <el-col :span="6"><span v-if="record.userInfo.user.eduBenDateStart">学年： {{record.userInfo.user.eduBenDateStart}} 至 {{record.userInfo.user.eduBenDateEnd}}</span></el-col>
                                </el-row>
                                <el-row :gutter="15">
                                    <el-col :span="6"><span v-if="record.userInfo.user.eduSuo">学校：{{record.userInfo.user.eduSuo}}</span></el-col>
                                    <el-col :span="6"><span v-if="record.userInfo.user.SuoMajor">专业： {{record.userInfo.user.SuoMajor}}</span></el-col>
                                    <el-col :span="6"><span v-if="record.userInfo.user.eduSuoDateStart">学年： {{record.userInfo.user.eduSuoDateStart}} 至 {{record.userInfo.user.eduSuoDateEnd}}</span></el-col>
                                </el-row>
                                <el-row :gutter="15">
                                    <el-col :span="6"><span v-if="record.userInfo.user.eduBo">本科学校：{{record.userInfo.user.eduBo}}</span></el-col>
                                    <el-col :span="6"><span v-if="record.userInfo.user.boMajor">本科专业： {{record.userInfo.user.boMajor}}</span></el-col>
                                    <el-col :span="6"><span v-if="record.userInfo.user.eduBoDateStart">学年： {{record.userInfo.user.eduBoDateStart}} 至 {{record.userInfo.user.eduBoDateEnd}}</span></el-col>
                                </el-row>
                            </div>
                        </el-card>
                    </el-timeline-item>
                    <el-timeline-item timestamp="自我评价/兴趣爱好" placement="top">
                        <el-card>
                            <el-row :gutter="0">
                                <el-col>
                                    <div style="margin: 5px 40px">
                                        <p><span style="font-weight: 600">1、</span>{{record.userInfo.user.evaluation}}</p>
                                    </div>
                                    <div style="margin: 5px 40px">
                                        <p><span style="font-weight: 600">2、</span>{{record.userInfo.user.hobby}}</p>
                                    </div>
                                </el-col>
                            </el-row>
                        </el-card>
                    </el-timeline-item>
                    <el-timeline-item timestamp="专业技能" placement="top">
                        <el-card >
                            <el-row :gutter="0" v-for='(item,index) in this.record.userInfo.domainSkills' :key="index">
                                <p><span style="font-weight: 600">{{index}}、 </span>{{item.text}}</p>
                            </el-row>
                        </el-card>
                    </el-timeline-item>
                    <el-timeline-item timestamp="奖项荣誉" placement="top">
                        <el-card >
                            <el-row :gutter="200">
                                <el-col :span="400" v-for='(item,index) in this.record.userInfo.domains' :key="index">
                                    <p>{{item.text}}</p>
                                </el-col>
                            </el-row>
                        </el-card>
                    </el-timeline-item>
                    <el-timeline-item timestamp="实习经验" placement="top">
                        <el-card >
                            <el-row :gutter="200">
                                <el-col :span="400" v-for='(item,index) in this.record.userInfo.domainPractices' :key="index">
                                    <p>{{item.text}}</p>
                                </el-col>
                            </el-row>
                        </el-card>
                    </el-timeline-item>
                    <el-timeline-item timestamp="项目经验" placement="top">
                        <el-card >
                            <el-row :gutter="200">
                                <el-col :span="400" v-for='(item,index) in this.record.userInfo.domainProjects' :key="index">
                                    <p>{{item.text}}</p>
                                </el-col>
                            </el-row>
                        </el-card>
                    </el-timeline-item>
                    <el-timeline-item v-for="(item,index) in this.record.companyRecordList" :key="index" :timestamp="item.comName" placement="top">
                        <el-card>
                            <h4>早退次数：{{item.sumAttendance.leavesum}}</h4>
                            <h4>迟到次数：{{item.sumAttendance.latesum}}</h4>
                            <h4>未打卡次数：{{item.sumAttendance.cardsum}}</h4>
                            <h4>加班次数：{{item.sumAttendance.overworksum}}</h4>
                            <h4>绩效： {{item.performance.text}}</h4>
                            <h4>重大事件：{{item.event.text}}</h4>
                            <h4>评价：{{item.comment.text}}</h4>
                        </el-card>
                    </el-timeline-item>
                    <el-timeline-item :timestamp="this.record.companyName" placement="top">
                        <el-card>
                            <h4>早退次数：{{this.record.companyRecord.sumAttendance.leavesum}}</h4>
                            <h4>迟到次数：{{this.record.companyRecord.sumAttendance.latesum}}</h4>
                            <h4>未打卡次数：{{this.record.companyRecord.sumAttendance.cardsum}}</h4>
                            <h4>加班次数：{{this.record.companyRecord.sumAttendance.overworksum}}</h4>
                            <h4>绩效： {{this.record.companyRecord.performance.text}}</h4>
                            <h4>重大事件：{{this.record.companyRecord.event.text}}</h4>
                            <h4>评价：{{this.record.companyRecord.comment.text}}</h4>
                        </el-card>
                    </el-timeline-item>
                </el-timeline>
            </div>
        </div>
    </div>

</template>

<script>
export default {
    data(){
        return{
            activeNames:['2'],
            record: '',
            indicator:'',
            scorelist:[75,62,51,41,74,71,69,46,60],
            queryInfo:{
                comid : window.sessionStorage.getItem("comId"),
                userid : window.sessionStorage.getItem("userid")
            }
        }
    },
    created() {
        this.getRecord()
    },
    methods:{
        async getRecord(){
            const {data:res}=await this.$http.get('/getUserRecord',{params:this.queryInfo})
            if(res.code!==200) return this.$message.error('获取用户档案失败')
            this.$message.success('获取用户档案成功')
            this.record = res
            console.log(res)
            const {data:result} = await this.$http.get('/getSkills',{params:{positionName:this.record.userInfo.user.posname}})
            this.indicator = result.indicatorSkillList;
            this.$nextTick(function() {
                this.drawPie('leiDaTu')
            })
        },
        handleChange(val) {
            console.log(val);
        },
        async drawPie() {
            //1、导入 echarts
            const eCharts = require('echarts')
            let charts = eCharts.init(document.getElementById('leiDaTu'));
            var option = {
                tooltip: {},//提示层
                legend: {
                    data: ['个人职业素质画像']
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
                                value: this.scorelist,
                                name: "个人职业素质画像",
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
    },
}
</script>

<style lang="less" scoped>

</style>

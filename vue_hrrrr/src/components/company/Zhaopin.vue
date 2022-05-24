<template>
    <div>
        <!--        面包屑导航区域-->
        <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>招聘管理</el-breadcrumb-item>
            <el-breadcrumb-item>发布招聘</el-breadcrumb-item>
        </el-breadcrumb>
        <el-card class="box-card">
            <div>
            <div style="margin-left: 150px;margin-top: 50px;margin-bottom: 50px" >
                <el-form >
                    <el-form-item label="职位选择: " prop="posCateValue">
                        <el-cascader
                                :show-all-levels="false"
                                v-model="posCateValue"
                                :options="posCateList"
                                :props="{ expandTrigger: 'hover',label:'pos_name',value:'pos_name',children:'children' }"
                                @change="handleCascader"></el-cascader>
                    </el-form-item>
                </el-form>
            </div>
            <div style="margin: 0px 120px 0px 30px">
                <div class="oneDiv" style="margin: 0px 0px">
                    <div id="leiDaTu" style="width: 750px;height: 750px;"></div>
                </div>
                <div class="twoDiv" style="margin:85px 20px 0px 0px">
                <el-row :span="12" v-for='(item,index) in this.positionSkills' :key="index">
                    <div>{{item.skill+' : '}}<el-slider
                            @input= "scoreChange"
                            input-size="mini"
                            v-model="item.score"
                            show-input></el-slider></div>
                </el-row>
                </div>
            </div>
            </div>
            <div style="margin: 140px">
                <el-form v-if="isShow" :model="jobForm" ref="jobFormRef" label-width="200px">
                    <el-form-item label=" "></el-form-item>
                    <el-form-item label="额外要求：">
                        <el-input
                                maxlength="300"
                                show-word-limit
                                type="textarea"
                                :autosize="{ minRows: 2, maxRows: 8}"
                                placeholder="请输入内容"
                                v-model="jobForm.extraAsk">
                        </el-input>
                    </el-form-item>
                    <el-form-item label="薪资：">
                        <el-input v-model="jobForm.salary"></el-input>
                    </el-form-item>
                    <el-form-item label="学历：">
                        <el-select v-model="jobForm.edu" placeholder="请选择">
                            <el-option
                                    v-for="item in eduOptions"
                                    :key="item.value"
                                    :label="item.label"
                                    :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="工作年限：">
                        <el-select v-model="jobForm.yearLimit" placeholder="请选择">
                            <el-option
                                    v-for="item in yearOptions"
                                    :key="item.value"
                                    :label="item.label"
                                    :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="福利：">
                        <el-input
                                maxlength="100"
                                show-word-limit
                                type="textarea"
                                :autosize="{ minRows: 2, maxRows: 8}"
                                placeholder="请输入内容"
                                v-model="jobForm.welfare">
                        </el-input>
                    </el-form-item>
                    <el-button type="primary" @click="submitJob">提 交</el-button>
                </el-form>
            </div>
        </el-card>
    </div>

</template>

<script>
    export default {
        data(){
            return{
                sumbitJob:{
                    id:'',
                    scorelist:''
                },
                jobForm:{
                    comid:window.sessionStorage.getItem("comId"),
                    position:'',
                    extraAsk:'',
                    salary:'',
                    edu:'',
                    yearLimit:'',
                    address:'',
                    welfare:'',
                    submitdate:''
                },
                isShow:false,
                value: 0,
                posCateValue:[],
                posCateList:[],
                positionSkills:[],
                positionSkillScore:[],
                indicator: [],
                scoreList:[],
                scoreListNow:[],
                eduOptions:[
                    {
                        value: '大专',
                        label: '大专'
                    }, {
                        value: '本科',
                        label: '本科'
                    }, {
                        value: '硕士',
                        label: '硕士'
                    }, {
                        value: '博士',
                        label: '博士'
                    },],
                yearOptions:[
                    {
                        value: '在校/应届',
                        label: '在校/应届'
                    }, {
                        value: '1~3年',
                        label: '1~3年'
                    }, {
                        value: '3~5年',
                        label: '3~5年'
                    }, {
                        value: '5~10年',
                        label: '5~10年'
                    },
                    {
                        value: '10年以上',
                        label: '10年以上'
                    }
                ]
            }
        },
        //create()函数自动触发
        created() {
            this.getPosCateList()
        },
        methods:{
            //自动获取商品分类列表
            async getPosCateList(){
                const {data:res} = await this.$http.get('getPosCate')
                this.posCateList = res
            },
            async handleCascader(){
                if(this.posCateValue.length !== 4){
                    this.posCateValue = []
                }
                console.log(this.posCateValue[this.posCateValue.length-1])
                const {data:res} = await this.$http.get('/getSkills',{params:{positionName:this.posCateValue[this.posCateValue.length-1]}})
                this.positionSkills = res.skillList;
                this.positionSkillScore = res.skillList;
                this.indicator = res.indicatorSkillList;
                this.scoreList = res.scoreList;
                this.$nextTick(function() {
                    this.drawPie('leiDaTu')
                })
                this.isShow = true;
                // for(var index in res){
                //     this.indicator.push({
                //         'name' : res[index].skill,
                //         'max' : 100
                //     })
                // }

            },
            async submitJob(){
                this.jobForm.position = this.posCateValue[this.posCateValue.length-1]
                this.jobForm.submitdate = new Date();
                const {data :code} = await this.$http.post('company/addSubmitJob',this.jobForm);
                this.sumbitJob.id = code
                console.log(this.scoreListNow)
                console.log(code)
                this.sumbitJob.scorelist = this.scoreListNow
                const {data :res} = await this.$http.post('company/submitJob',this.sumbitJob);
                console.log(res)
                return this.$message.success("提交成功")
            },
            scoreChange(){
                this.scoreListNow=[]
                for(var index in this.positionSkills){
                    this.scoreListNow.push(this.positionSkills[index].score)
                }
                this.$nextTick(function() {
                    this.drawPie('leiDaTu')
                })
            },
            async drawPie() {
                //1、导入 echarts
                const eCharts = require('echarts')
                let charts = eCharts.init(document.getElementById('leiDaTu'));
                var option = {
                    tooltip: {},//提示层
                    legend: {
                        data: ['java初级工程师标准','java初级工程师']
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
                                    value: this.scoreList,
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
                                {
                                    value: this.scoreListNow,
                                    name: "java初级工程师",
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
        //调用mounted时，此时页面上的DOM元素已经被初始化了
        mounted() {

        }
    }
</script>

<style scoped>
    .oneDiv{
        width: 750px;
        float: left;
    }
    .twoDiv{
        float: right;
        width: 600px;
    }

</style>
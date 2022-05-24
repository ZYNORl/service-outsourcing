<template>
    <div>
        <!--        面包屑导航区域-->
        <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>企业中心</el-breadcrumb-item>
            <el-breadcrumb-item>企业信息</el-breadcrumb-item>
        </el-breadcrumb>
        <!--        卡片视图区域-->
        <el-card class="box-card">
        <div style="margin: 40px 100px">
        <el-row :gutter="0">
            <el-col :span="16"><div>企业名称：{{detail.name}}</div></el-col>
            <el-col :span="16"><div>法人代表：{{detail.legalperson}}</div></el-col>
            <el-col :span="16"><div>登录账号：{{detail.tel}}</div></el-col>
            <el-col :span="16"><div>登录密码：{{detail.password}}</div></el-col>
            <el-col :span="16"><div>注册地址：{{detail.address}}</div></el-col>
            <el-col :span="16"><div>企业类型：{{detail.type}}</div></el-col>
            <el-col :span="16"><div>经营状态：{{detail.status}}</div></el-col>
            <el-col :span="16"><div>成立日期：{{detail.date}}</div></el-col>
            <el-col :span="16"><div>经营范围：{{detail.range}}</div></el-col>
        </el-row>
            <div style="margin: 60px 400px 40px -20px">
                <el-form :model="introduceForm" :rules="introduceFormRules" ref="introduceFormRef" label-width="100px">
                    <el-form-item label="企业介绍：">
                        <el-input
                                maxlength="500"
                                show-word-limit
                                type="textarea"
                                :autosize="{ minRows: 2, maxRows: 8}"
                                placeholder="请输入内容"
                                v-model="introduceForm.introduce">
                        </el-input>
                        <el-form-item label="企业规模: " style="margin: 40px 0px 0px -100px">
                            <el-select v-model="introduceForm.personnum" placeholder="请选择">
                                <el-option
                                        v-for="item in numOptions"
                                        :key="item.value"
                                        :label="item.label"
                                        :value="item.value">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-form-item>
                    <el-button style="margin-left:100px;margin-top: 20px" type="primary" @click="setCompanyIntroduce">提 交</el-button>
                </el-form>
            </div>
        </div>
        </el-card>
    </div>
</template>

<script>
    export default {
        data(){
            return{
                introduceForm:{
                    comid:window.sessionStorage.getItem("comId"),
                    introduce:'',
                    personnum:''
                },
                detail:{
                    name:'',
                    tel:'',
                    password:'',
                    introduce:'',
                    legalperson:'',
                    fund:'',
                    date:'',
                    type:'',
                    status:'',
                    address:'',
                    code:'',
                    range:'',
                    photo:'',
                    personnum:''
                },
                numOptions:[
                    {
                        value: '0~20',
                        label: '0~20'
                    },{
                        value: '20~90',
                        label: '20~90'
                    },{
                        value: '90~200',
                        label: '90~200'
                    },{
                        value: '200~500',
                        label: '200~500'
                    },{
                        value: '500~1000',
                        label: '500~1000'
                    },{
                        value: '1000~10000',
                        label: '1000~10000'
                    },{
                        value: '10000以上',
                        label: '10000以上'
                    }
                ],
                introduceFormRules:{
                    introduce: [
                        { required: true, message: '请输入密码', trigger: 'blur' },
                        { min: 6, max: 15, message: '长度在 6 到 15 个字符', trigger: 'blur' }
                    ]
                },
                queryCompanyInfo:{
                    comid:window.sessionStorage.getItem("comId")
                }
            }
        },
        created() {
            this.getCompanyDetails();
        },
        methods:{
            async getCompanyDetails(){
                const {data :res} = await this.$http.get('company/getDetail',{params:this.queryCompanyInfo});
                this.detail = res
                this.introduceForm.introduce = res.introduce
            },
            async setCompanyIntroduce(){
                const {data :res} = await this.$http.get('company/setIntroduce',{params:this.introduceForm});
                this.introduceForm.introduce = res;
                return this.$message.success("修改成功")
            }
        },

    }
</script>

<style scoped>

</style>
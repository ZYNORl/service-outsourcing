<template>
    <div>
        <!--        面包屑导航区域-->
        <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>出勤管理</el-breadcrumb-item>
            <el-breadcrumb-item>出勤列表</el-breadcrumb-item>
        </el-breadcrumb>
        <!--        卡片视图区域-->
        <el-card class="box-card">
            <el-row style="margin: 30px" :gutter="7">
                <el-col :span="27">
                    <div class="block">
                        <span class="demonstration">请选择时间段：</span>
                        <el-date-picker
                                default-value=''
                                @change="searchByDate"
                                v-model="searchDate.date"
                                type="daterange"
                                range-separator="至"
                                start-placeholder="开始日期"
                                end-placeholder="结束日期">
                        </el-date-picker>
                    </div>
<!--                    <el-input placeholder="请输入内容"  class="input-with-select" v-model="#" clearable @clear="getUerList">-->
<!--                        <el-button slot="append" icon="el-icon-search" @click="#"></el-button>-->
<!--                    </el-input>-->
                </el-col>
            </el-row>
            <el-table :data="attendanceList" border stripe>
                <!--                索引列-->
                <el-table-column type="index" label="#"></el-table-column>
                <el-table-column label="员工姓名" prop="name"></el-table-column>
                <el-table-column label="职称" prop="posName"></el-table-column>
                <el-table-column label="早退次数" prop="leavenum"></el-table-column>
                <el-table-column label="迟到次数" prop="latenum"></el-table-column>
                <el-table-column label="未打卡次数" prop="cardnum"></el-table-column>
                <el-table-column label="加班次数" prop="overworknum"></el-table-column>
                <el-table-column label="操作" width="300px" >
                    <template slot-scope="scope">
                        <el-tooltip class="item" effect="dark" content="修改" placement="top" :enterable="false">
                            <el-button type="primary" icon="el-icon-edit" size="mini" @click="showEditDialog(scope.row)"></el-button>
                        </el-tooltip>
                    </template>
                </el-table-column>

            </el-table>
        </el-card>
        <!--        修改用户的对话框-->
        <el-dialog
                title="修改用户"
                :visible.sync="editDialogVisible"
                width="40%">
            <div style="margin: 5px 50px">
                <el-input
                        style="margin: 20px 0px"
                        value="hhh"
                        v-model="name"
                        :disabled="true">
                </el-input>
                <el-input
                        style="margin: 20px 0px"
                        placeholder="请输入内容"
                        v-model="posName"
                        :disabled="true">
                </el-input>
            </div>
            <div style="margin: 0px 50px">
            <el-form :model="slidSwitch" label-width="90px">
                <el-form-item label="是否早退：">
                    <el-switch
                            v-model="slidSwitch.leavenum"
                            active-color="#13ce66"
                            inactive-color="#C0C4CC">
                    </el-switch>
                </el-form-item>
                <el-form-item label="是否迟到：">
                    <el-switch
                            v-model="slidSwitch.latenum"
                            active-color="#13ce66"
                            inactive-color="#C0C4CC">
                    </el-switch>
                </el-form-item>
                <el-form-item label="是否打卡：">
                    <el-switch
                            v-model="slidSwitch.cardnum"
                            active-color="#13ce66"
                            inactive-color="#C0C4CC">
                    </el-switch>
                </el-form-item>
                <el-form-item label="是否加班：" prop="email">
                    <el-switch
                            v-model="slidSwitch.overworknum"
                            active-color="#13ce66"
                            inactive-color="#C0C4CC">
                    </el-switch>
                </el-form-item>
            </el-form>
            </div>
            <span slot="footer" class="dialog-footer">
    <el-button @click="editDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="editAttendanceInfo">确 定</el-button>
  </span>
        </el-dialog>
    </div>
</template>

<script>
    var moment = require('moment');
    export default {
        data(){
            return{
                attendanceList:[],
                name:'牛振洋',
                posName:'',
                slidSwitch:{
                    leavenum:false,
                    latenum:false,
                    cardnum:false,
                    overworknum:false
                },
                editForm:{
                    dotime:'',
                    userid:'',
                    comid:'',
                    leavenum:'',
                    latenum:'',
                    cardnum:'',
                    overworknum:''
                },
                searchDate: {
                    date: [],
                },
                editDialogVisible: false,
            }
        },


        created() {
            this.searchByDate()
        },
        methods:{
            async searchByDate(){
                let comId = window.sessionStorage.getItem("comId")
                const {data:res}=await this.$http.get('/company/AttendanceUserListByDate',{
                    params:{firstDate:moment(this.searchDate.date[0]).format('yyyy-MM-DD'),
                        lastDate:moment(this.searchDate.date[1]).format('yyyy-MM-DD'),
                    comid:comId}})
                this.$message.success('获取用户列表成功')
                this.attendanceList = res
            },
            editAttendanceInfo: async function () {
                if (this.slidSwitch.leavenum === false && this.slidSwitch.cardnum === false && this.slidSwitch.latenum === false && this.slidSwitch.overworknum === false) {
                    return this.$message.warning("未改动，提交无效")
                }
                if(this.slidSwitch.leavenum === true){
                    this.editForm.leavenum=1
                }
                if(this.slidSwitch.cardnum === true){
                    this.editForm.cardnum=1
                }
                if(this.slidSwitch.latenum === true){
                    this.editForm.latenum=1
                }
                if(this.slidSwitch.overworknum === true){
                    this.editForm.overworknum=1
                }
                let dateNow = new Date();
                this.editForm.dotime = dateNow
                const {data: res} = await this.$http.post('/company/editAttendance', this.editForm)
                if (res.code === 200) {
                    this.$message.success(res.message)
                    this.searchByDate()
                    this.editDialogVisible=false
                } else {
                    return this.$message.error(res.message)
                }
            },
            async showEditDialog(attendanceBody){
                this.editForm.userid = attendanceBody.userid
                this.editForm.comid = parseInt(window.sessionStorage.getItem("comId"))
                this.name = attendanceBody.name
                this.posName = attendanceBody.posName
                this.editDialogVisible = true
            }
        },

    }
</script>

<style scoped>

</style>
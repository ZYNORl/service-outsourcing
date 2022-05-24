<template>
    <div>
        <el-card>
            <div style="width: 80%;margin: 0px auto;">
                <div
                        v-for="(item, index) in this.searchJobList"
                        :key="index"
                        style="margin: 20px 30px;box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)"
                >
                    <el-row :gutter="14">
                        <el-col :span="5">
                            <div style="margin: 30px 0px 15px 90px">
                                <img v-bind:src="item.company.photo" width="80px" height="100px" />
                            </div>
                        </el-col>
                        <el-col :span="6">
                            <div style="padding: 25px 10px">
                                <p>{{ item.submitJob.position}} [{{ item.submitJob.address }}]</p>
                                <p>{{item.submitJob.salary}}K {{item.submitJob.yearLimit}} | {{item.submitJob.edu}}</p>
                                <div style="float: left"><span>匹配度：</span></div><div style="float: left"><el-rate
                                    v-model="item.scores"
                                    disabled
                                    show-score
                                    text-color="#ff9900"
                                    score-template="{value}"
                            ></el-rate></div>
                            </div>
                        </el-col>
                        <el-col :span="7">
                            <div style="padding: 25px 10px">
                                <p>{{ item.company.name}} | {{ item.company.personnum}}人</p>
                                <div style="margin-left: 30px;margin-top: 30px">
                                    <el-button type="primary" size="small" plain icon="el-icon-d-arrow-right"  @click="toJobDetail(item.submitJob.id,item.scores,item.submitJob.position)"
                                    >职位详情</el-button>

                                </div>
                            </div>
                        </el-col>
                    </el-row>
                </div>
            </div>
        </el-card>
    </div>
</template>

<script>
    export default {
        data(){
            return{
                scorelist:[75,62,51,41,74,71,69,46,60],
                searchJobList:[],
                searchQueryInfo: {
                    userid: window.sessionStorage.getItem("userId")
                    // maxLevelOrder: false, //从匹配度的从大到小
                    // posName: "", //按照职位检查
                    // name: "" //按照名字准确检索
                },
            }
        },
        created() {
            this.getSearchRecordList()
        },
        methods:{
            async getSearchRecordList() {
                const { data: res } = await this.$http.get("/searchJobList",{
                    params: this.searchQueryInfo}
                );
                this.searchJobList = res;
                this.$message.success("获取职位列表成功");
                console.log(res);
                this.scorelist
                //res.scores;
                //res.matchScores;

            },
            async toJobDetail(id,scores,position){
                console.log(id)
                console.log(scores)
                window.sessionStorage.setItem("position",position)
                window.sessionStorage.setItem("scores",scores)
                window.sessionStorage.setItem("JobId",id)
                await this.$router.push({path:`/jobDetail/${id}`})
            }

        }
    }
</script>

<style scoped>

</style>
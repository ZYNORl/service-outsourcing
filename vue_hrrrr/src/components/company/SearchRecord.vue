<template xmlns:el-col="http://www.w3.org/1999/html">
  <div>
    <!--        面包屑导航区域-->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>招聘管理</el-breadcrumb-item>
      <el-breadcrumb-item>搜索简历</el-breadcrumb-item>
    </el-breadcrumb>
    <el-card>
      <div style="width: 80%;margin: 0px auto;">
        <div style="margin: 25px 60px">
          <el-row :gutter="10">
            <el-col :span="5">
              <el-input
                      placeholder="请输入职位"
                      class="input-with-select"
                      v-model="searchQueryInfo.posName"
                      clearable
                      @clear="getSearchRecordList">
              </el-input>
            </el-col>
            <el-col :span="5">
              <el-input
                      placeholder="请输入姓名"
                      class="input-with-select"
                      v-model="searchQueryInfo.name"
                      clearable
                      @clear="getSearchRecordList"></el-input>
            </el-col>
            <el-col :span="4">
              <div style="padding: 8px">
                <el-switch
                        v-model="searchQueryInfo.maxLevelOrder"
                        active-color="#13ce66"
                        inactive-color="#C0C4CC">
                </el-switch>
              </div>
            </el-col>
            <el-col :span = 5>
              <div style="margin-left: -100px">
                <el-button type="primary" plain icon="el-icon-search"  @click="getSearchRecordList"
                >开始检索</el-button>
              </div>
            </el-col>
          </el-row>
        </div>
        <div
          v-for="(item, index) in this.searchRecordList"
          :key="index"
          style="margin: 20px 30px;box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)"
        >
          <el-row :gutter="14">
            <el-col :span="5">
              <div style="margin: 15px 0px 15px 40px">
                <img v-bind:src="item.photo" width="100px" height="120px" />
              </div>
            </el-col>
            <el-col :span="5">
                <div style="padding: 25px 10px">
              <p>姓名：{{ item.name }}</p>
              <p>最高学历：{{ item.maxEdu }}</p>
                </div>
            </el-col>
              <el-col :span="7">
                  <div style="padding: 25px 10px">
                  <p>职位：{{ item.posName }}</p>
                    <div style="float: left"><span>匹配度：</span></div><div style="float: left"><el-rate
                          v-model="item.level"
                          disabled
                          show-score
                          text-color="#ff9900"
                          score-template="{value}"
                  ></el-rate></div>
                  </div>
              </el-col>
              <el-col :span="5">
                  <div style="padding: 50px 0px">
                  <el-button type="primary" circle plain icon="el-icon-d-arrow-right"  @click="toUserRecord(item.userid)"
                  ></el-button>
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
  data() {
    return {
      searchQueryInfo: {
        maxLevelOrder: false, //从匹配度的从大到小
        posName: "", //按照职位检查
        name: "" //按照名字准确检索
      },
      searchRecordList: []
    };
  },
  created() {
    this.getSearchRecordList();
  },
  methods: {
    async getSearchRecordList() {
      const { data: res } = await this.$http.get("/searchRecordList", {
        params: this.searchQueryInfo
      });
      this.searchRecordList = res;
      this.$message.success("获取用户档案成功");
      console.log(res);
    },
      async toUserRecord(id){
        window.sessionStorage.setItem("userid",id)
        let jishu = window.sessionStorage.getItem("jishu");
        if(jishu<0){
          return this.$message({
            duration:6000,
            dangerouslyUseHTMLString:true,
            type:"warning",
            message:'对不起，你今天查看档案已经超过限制，无法继续查看。可以明天再来，或<strong>申请VIP</strong>增加次数</strong>'
          })
        }
        jishu=jishu-1;
        window.sessionStorage.setItem("jishu",jishu);
        await this.$router.push({path:`/record/${id}`})
      }
  }
};
</script>

<style scoped></style>

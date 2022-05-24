<template>
    <el-container class="home-container">
        <el-header>
            <div>
                <img src="../assets/logo.png">
                <span>中小微企业人才档案管理系統</span>
            </div>
            <el-popover
                    class="message_button"
                    placement="right"
                    width="550"
                    trigger="click">
                    <el-select v-model="form.job" value-key="id" placeholder="请选择职位" @focus="pushJob">
                        <el-option v-for="item in jobs" :key="item.id" :label="item.name" :value="item"></el-option>
                    </el-select>
                <el-table :data="gridData">
                    <el-table-column width="150" property="position" label="应聘岗位"></el-table-column>
                    <el-table-column width="120" property="time" label="投递日期"></el-table-column>
                    <el-table-column width="120" property="scores" label="匹配度"></el-table-column>
                    <el-table-column width="120" property="handle" label="查看详情">
                        <template slot-scope="scope">
                            <el-button type="primary" round size="mini"  @click="getDetailPage(scope.row.userid)">详情</el-button>
                            </template>
                    </el-table-column>
                </el-table>
                <template :slot="reference">
                    <el-button class="buttom_nini" type="warning" icon="el-icon-bell" circle ></el-button>
                </template>
            </el-popover>
            <el-button type="info" @click="logout">退出</el-button>
        </el-header>
        <el-container>
            <el-aside :width="isCollapse ? '64px':'200px'">
<!--                左侧菜单栏伸缩-->
                <div class="toggle-button" @click="toggleCollapse">
                    |||
                </div>
                <!--側邊欄菜單區域-->
                <el-menu background-color="#333744" text-color="#fff"
                         active-text-color="#409EFF" unique-opened :collapse="isCollapse" :collapse-transition="false"
                         router :default-active="this.$route.path">
             <!--       一级菜单-->
                    <el-submenu :index="item.id+''" v-for="item in menuList" :key="item.id" width="100px">
<!--                        模板區域-->
                        <template slot="title">
                            <i :class="iconsObj[item.id]"></i>
                            <span>{{item.authName}}</span>
                        </template>
<!--                        二级菜单-->
                            <el-menu-item :index="'/'+childItem.path+''" v-for="childItem in item.children" :key="childItem.id">
                                <template slot="title">
                                    <i class="el-icon-aim"></i>
                                    <span>{{childItem.authName}}</span>
                                </template>
                            </el-menu-item>

                    </el-submenu>
                </el-menu>
            </el-aside>
            <el-main>
                <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>

</template>
<script>
export default{

    data(){
        return{
            reference:'reference',
            jobs:[{name:'java初级工程师',id:'1'},{name:'java中级工程师',id:'2'}],
            form: {
                job:[{name:'java初级工程师',id:'1'}]
            },
            //左侧菜单数据
            menuList:['员工管理'],
            iconsObj:{
                '125':'el-icon-user',
                '103':'el-icon-s-release',
                '101':'el-icon-goods',
                '102':'el-icon-document-checked',
                '145':'el-icon-data-line'
            },
            //不折叠
            isCollapse:false,
            // gridData: [{
            //     position:'java初级工程师',
            //     time: '2016-05-02',
            //     scores: '87%',
            //     id: '1'
            // },],
            gridData:[],
        }
    },
    created() {
        this.getMenuList();
        this.getToudiGridData()
    },
    methods: {
         logout() {
             window.sessionStorage.clear()
             this.$router.push('/login')
         },
        // 获取所以的菜单
        async getMenuList(){
            const {data:res} = await this.$http.get('api/getMenus')
            console.log(res)
            if(res.meta.status !== 200) return this.$message.error(res.meta.msg)
            this.menuList = res.data;
        },
        async getToudiGridData(){
            const {data :res} = await this.$http.get('company/get/Toudi',{params:{comid:window.sessionStorage.getItem("comId")}});
            this.gridData = res
        },
        //点击按钮，菜单的伸展
        toggleCollapse(){
             this.isCollapse = !this.isCollapse;
             console.log(this.$route.path)
        },
        pushJob(){
        },
        async getDetailPage(userid){
            window.sessionStorage.setItem("userDetailId",userid);
            await this.$router.push({path:`/userDetail/${userid}`})
        }

     }
}
</script>

<style lang="less" scoped>
    .home-container{
        height: 100%;
    }
    .el-header{
       background-color: #373d41;
        display: flex;
        justify-content: space-between;
        padding-left: 0px;
        align-items: center;
        color: #ffffff;
        font-size: 20px;
        >div{
            display: flex;
            align-items: center;
            span{
                margin-left: 15px;
            }
        }

    }
    .el-aside{
        background-color: #333744;
        .el-menu{
            border-right: none;
        }
    }
    .el-main{
        background-color: #eaedf1;
    }
    .toggle-button{
        font-size: 10px;
        line-height: 24px;
        color: #ffffff;
        background-color: #4A5064;
        text-align: center;
        letter-spacing: 0.2em;
        //鼠标放上去，变成一个小手
        cursor: pointer;
    }
    .message_button{
        position:absolute;    /**绝对定位**/
        margin-left:90%;    /**对于屏幕边进行定位**/
        //background-color:#384C38
    }
    .buttom_nini{
        background-color: lightcoral;
    }


</style>
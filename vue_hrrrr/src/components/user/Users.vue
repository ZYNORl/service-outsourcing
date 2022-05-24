<template>
    <div>
        <!--        面包屑导航区域-->
        <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>员工管理</el-breadcrumb-item>
            <el-breadcrumb-item>员工列表</el-breadcrumb-item>
        </el-breadcrumb>
        <!--        卡片视图区域-->
        <el-card class="box-card">
            <el-row :gutter="70">
                <el-col :span="7">
                    <el-input placeholder="请输入内容"  class="input-with-select" v-model="queryInfo.query" clearable @clear="getUerList">
                        <el-button slot="append" icon="el-icon-search" @click="getUerList"></el-button>
                    </el-input>
                </el-col>
                <el-col :span="4">
                    <el-button type="primary" @click="addDialogVisible=true">添加员工</el-button>
                </el-col>
            </el-row>
            <el-table :data="userList" border stripe>
                <!--                索引列-->
                <el-table-column type="index" label="#"></el-table-column>
                <el-table-column label="姓名" prop="name"></el-table-column>
                <el-table-column label="职称" prop="posname"></el-table-column>
                <el-table-column label="年龄" prop="age"></el-table-column>
                <el-table-column label="学历" prop="maxedu"></el-table-column>
                <el-table-column label="邮箱" prop="email"></el-table-column>
                <el-table-column label="电话" prop="tel"></el-table-column>
                <el-table-column label="状态">
                    //scope 作用域插槽，定位
                    <template slot-scope="scope">
                        <el-switch
                                :active-value="1" :inactive-value="0"
                                v-model="scope.row.status"
                                @change="userStateChange(scope.row)"
                                active-color="#13ce66"
                                inactive-color="#ff4949">
                        </el-switch>
                    </template>
                </el-table-column>
                <el-table-column label="操作" width="300px" >
                    <template slot-scope="scope">
                        <el-tooltip class="item" effect="dark" content="修改" placement="top" :enterable="false">
                            <el-button type="primary" icon="el-icon-edit" size="mini"  @click="showEditDialog(scope.row)"></el-button>
                        </el-tooltip>
                        <el-tooltip class="item" effect="dark" content="删除" placement="top" :enterable="false">
                            <el-button type="danger" icon="el-icon-delete" size="mini" @click="removeUserById(scope.row.id)"></el-button>
                        </el-tooltip>
                        <el-tooltip class="item" effect="dark" content="档案" placement="top" :enterable="false">
                            <el-button type="warning" icon="el-icon-document" size="mini" @click="openUserRecord(scope.row)"></el-button>
                        </el-tooltip>
                    </template>
                </el-table-column>

            </el-table>
            <!--            分页区域-->
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="queryInfo.pagenum"
                    :page-sizes="[2, 8, 10, 12,15]"
                    :page-size="queryInfo.pagesize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="total">
            </el-pagination>
        </el-card>
        <!--        添加用户的对话框-->
        <el-dialog
                title="添加新员工"
                :visible.sync="addDialogVisible"
                width="40%" @close="addDialogClosed">
            <!--            对话框主题区域-->
            <el-form :model="addUserForm" :rules="addUserFormRules" ref="addUserFormRef" label-width="100px">
                <el-form-item label="账号" prop="tel">
                    <el-input v-model="addUserForm.tel"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                <el-input v-model="addUserForm.password"></el-input>
                </el-form-item>
                <el-form-item label="姓名" prop="name">
                    <el-input v-model="addUserForm.name"></el-input>
                </el-form-item>
                <el-form-item label="身份证号" prop="identNumber">
                    <el-input v-model="addUserForm.identNumber"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
    <el-button @click="addDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="addUser">确 定</el-button>
  </span>
        </el-dialog>
        <!--        修改用户的对话框-->
        <el-dialog
                title="编辑员工档案"
                :visible.sync="editDialogVisible"
                width="40%">
            <el-form :model="editForm" :rules="editFormRules" ref="editFormRef" label-width="120px">
                <el-form-item label="用户名">
                    <el-input v-model="editTitile.name" disabled></el-input>
                </el-form-item>
                <el-form-item label="职称">
                    <el-input v-model="editTitile.posName" disabled></el-input>
                </el-form-item>
                <el-form-item label="绩效：">
                    <el-input
                            type="textarea"
                            :autosize="{ minRows: 2, maxRows: 4}"
                            placeholder="请输入内容"
                            v-model="editForm.performance">
                    </el-input>
                </el-form-item>
                <el-form-item label="评价：">
                    <el-input
                            type="textarea"
                            :autosize="{ minRows: 2, maxRows: 4}"
                            placeholder="请输入内容"
                            v-model="editForm.comment">
                    </el-input>
                </el-form-item>
                <el-form-item label="有无重大事件：">
                    <el-switch
                            @click="isRadiou"
                            v-model="isRadio"
                            active-color="#13ce66"
                            inactive-color="#C0C4CC">
                    </el-switch>
                    <el-input v-if="isRadio===true"
                            type="textarea"
                            :autosize="{ minRows: 2, maxRows: 4}"
                            placeholder="请输入内容"
                            v-model="editForm.event">
                    </el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
    <el-button @click="editDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="editUserInfo()">确 定</el-button>
  </span>
        </el-dialog>
    </div>

</template>

<script>
    export default {

        data(){

            //登录邮箱规则
            const checkEmail = (rule,value,cb)=>{
                // 邮箱验证正则表达式
                const regEmail = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/
                if(regEmail.test(value)){
                    //合法的邮箱
                    return cb();
                }
                cb(new Error('请输入合法的邮箱'))
            }
            //验证身份证规则
            const checkIdent = (rule,value,cb)=>{
                //18位身份证正则表达式
                const  regIdent18 = /^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/
                //15位身份证正则表达式
                const regIdent15 = /^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}$/
                if(regIdent18.test(value)||regIdent15.test(value)){
                    return cb();
                }
                cb(new Error('请输入合法的身份证号'))
            }
            //验证手机号规则
            const checkMobile = (rule,value,cb)=>{
                // 手机号验证正则表达式
                const regMobile = /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/
                if(regMobile.test(value)){
                    return cb();
                }
                cb(new Error('请输入合法的手机号'))
            }

            return {
                // 当选择了，即为有重大事件，联动填写事件内容
                isRadio:false,
                editTitile:{
                  name:'',
                  posName:''
                },
                editContext:{
                    userid:'',
                    comid:window.sessionStorage.getItem("comId")
                },
                Form:{
                    eduBackList:['博士研究生/博士后','硕士研究生','大学本科','大学专科','高中','职业高中','技校']
                },
               //获取用户列表的对象
                queryInfo:{
                    // query:''
                    comid : window.sessionStorage.getItem("comId"),
                    pagenum:1,
                    pagesize:4
                },
                userList:[],
                total:'',
                //控制添加用户对话框的显示与关闭
                addDialogVisible: false,
                editDialogVisible: false,
                //添加用户的表单数据
                addUserForm:{tel:'',password:'',name:'',identNumber:'',comid:''},
                //需要分配角色的用户信息
                userInfo:{},
                //添加用户表单的验证规则对象
                addUserFormRules:{
                    tel:[
                        { required: true, message: '请输入用户手机号', trigger: 'blur' },
                        {validator: checkMobile,trigger: 'blur'}
                    ],
                    password:[
                        { required: true, message: '请输入密码', trigger: 'blur' },
                        { min: 3, max: 10,  message: '密码的长度在3~10字节之间',trigger: 'blur' },
                    ],
                    name:[
                        { required: true, message: '请输入姓名', trigger: 'blur' },
                        { min: 3, max: 5,  message: '用户名的长度在2~5字节之间',trigger: 'blur' },
                    ],
                    identNumber:[
                        { required: true, message: '请输入身份证还号码', trigger: 'blur' },
                        { validator:checkIdent,trigger:'blur' },
                    ],
                },
                //查询到的用户信息对象
                editForm:{
                    userid:'',
                    comid:window.sessionStorage.getItem("comId"),
                    performance:'',
                    comment:'',
                    event:''
                },
                //修改表单的验证对象
                editFormRules:{
                    username:[
                        { required: true, message: '请输入用户名称', trigger: 'blur' },
                        { min: 3, max: 5,  message: '用户名的长度在3~5字节之间',trigger: 'blur' },
                    ],
                    role_name:[
                        { required: true, message: '请输入职称名', trigger: 'blur' },
                        { min: 3, max: 5,  message: '职称名的长度在3~5字节之间',trigger: 'blur' },
                    ],
                    role_edu:[
                        { required: true, message: '请输入学历', trigger: 'blur' },
                    ],
                    email:[
                        { required: true, message: '请输入用户邮箱', trigger: 'blur' },
                        {validator: checkEmail,trigger: 'blur'}
                    ],
                    mobile:[
                        { required: true, message: '请输入用户手机号', trigger: 'blur' },
                        {validator: checkMobile,trigger: 'blur'}
                    ]
                },
                //所有角色列表
                roleList:[],
                //select 已选中的角色id
                selectRoleById:''

            }
        },
        created() {
            this.getUerList()
        },
        methods:{

            async getUerList(){
                const {data:res}=await this.$http.get('getEmployees',{params:this.queryInfo})
                console.log(res)
                if(res.code!==200) return this.$message.error('获取用户列表失败')
                this.$message.success('获取用户列表成功')
                this.userList = res.users;
                console.log(this.userList)
                this.total = res.total;
            },
            //监听pagesize改变的事件
            handleSizeChange(newSize){
                this.queryInfo.pagesize=newSize
                this.getUerList()
            },
            handleCurrentChange(newPage){
                this.queryInfo.pagenum=newPage
                this.getUerList()
            },
            //监听switch 开关状态的改变
            async userStateChange(userInfo){
                //const {data:res} = await this.$http.put(`users/${userInfo.id}/state/${userInfo.mg_state}`)
                // if(res.meta.status !== 200){
                //     userInfo.mg_state = ! userInfo.mg_state
                //     return this.$message.error('更新用户状态失败')
                // }
                this.$message.success('更新用户状态成功')

            },
            //监听用户对话框的关闭事件，关闭后重置对话框内容（清空）
            addDialogClosed(){
                this.$refs.addUserFormRef.resetFields()
            },
            //点击添加按钮，修改预验证，验证成功，添加新对象
            addUser(){
                this.$refs.addUserFormRef.validate(async valid=>{
                    //添加用户请求
                    this.addUserForm.comid = window.sessionStorage.getItem("comId")
                    const {data:res} = await this.$http.post('company/addUser',this.addUserForm)
                    if(res.code === 201){
                        return this.$message.error(res.message)
                    }
                    window.sessionStorage.setItem("addUserId",res.code);
                    this.$message.success(res.message)
                    this.addDialogVisible = false
                    //延迟跳转
                    setTimeout(() => {
                        this.$router.push('/face')
                    }, 500);
                })
            },
            //修改预验证，验证成功后提交请求
            async editUserInfo(){
                const { data: res } = await this.$http.get("/company/editEmployeeRecord", {
                    params: this.editForm
                });
                if(res.code===201){ return this.$message.error(res.message);} else {
                    this.$message.success(res.message)
                    this.getUerList()
                }
                this.editDialogVisible = false
            },

            //展示用户编辑对话框
            async showEditDialog(user){
                this.editContext.userid = user.id
                console.log(user.id)
                const { data: res } = await this.$http.get("/company/getEmployeeRecord", {
                    params: this.editContext
                });
                this.editForm.performance = res[0]
                this.editForm.comment = res[1]
                this.editForm.event = res[2]
                this.editTitile.name = user.name
                this.editTitile.posName = user.posname
                this.editForm.userid = user.id
                if(this.editForm.event!=null){
                    this.isRadio = true
                }
                this.editDialogVisible = true

            },
            //根据用户id删除用户记录
            async removeUserById(id){
                //询问用户是否删除
                //console.log(id)
                const confirmResult = await this.$confirm('此操作将永久删除该用户, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).catch(err=>{return err})
                //如果用户确认删除，则返回值为字符串 confirm,如果取消删除，则返回值为字符串cancel
                console.log(confirmResult)
                if(confirmResult !== 'confirm'){
                    return this.$message.info('您已取消删除操作')
                }
                const {data:res} = await this.$http.delete('users/'+id)
                if(res.meta.status !== 200){
                    return this.$message.error('删除用户失败')
                }
                this.$message.success('删除用户成功')
                this.getUerList()
            },
            //档案
            async openUserRecord(userInfo){
                this.userInfo = userInfo
                let id = userInfo.id
                console.log(id)
                window.sessionStorage.setItem("userid",userInfo.id)
                await this.$router.push({path:`/record/${id}`})
            },
            isRadiou(){
                if(this.editForm.event!=null&&this.isRadio()==null){
                    this.editForm.event=null
                }
            }
        }
    }
</script>

<style lang="less" scoped>
    .el-pagination{
        margin-top: 20px;
    }

</style>
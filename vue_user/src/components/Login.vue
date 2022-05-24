<template>
    <div :style="backNote" class="login_container">
        <div class="login_box">
<!--            头像区域-->
            <div class="avatar_box">
                <img src="../assets/logo.jpeg" alt="login">
            </div>
            <!--登录表单-->
            <el-form :model="loginForm" :rules="loginRules" ref="loginRef" label-width="0px" class="loginForm">
                <el-tabs v-model="activeName" @tab-click="handleClick">
                    <el-tab-pane label="密码登录" name="first">
                        <!--登录表单-->
                        <el-form-item prop="tel">
                            <el-input v-model="loginForm.tel" prop="tel" prefix-icon="el-icon-user-solid" placeholder="手机号"></el-input>
                        </el-form-item>

                        <el-form-item prop="password">
                            <el-input v-model="loginForm.password" prop="password"  type="password" prefix-icon="el-icon-lock" placeholder="密码"></el-input>
                        </el-form-item>

                        <el-form-item class="btn-item">
                            <el-button type="primary" @click="login">登录</el-button>
                            <el-button type="info" @click="resetLoginForm">重置</el-button>
                        </el-form-item>
                        <!--                    </el-form>-->
                    </el-tab-pane>
                    <el-tab-pane label="验证码登录" name="second">
                        <!--登录表单-->
                        <el-form-item prop="tel">
                            <el-input v-model="loginForm.tel" prop="tel" prefix-icon="el-icon-user-solid" placeholder="手机号"></el-input>
                        </el-form-item>

                        <el-form-item prop="password">
                            <el-button style="margin-right: 25px" type="primary" @click="loginSendSms" plain>发送验证码</el-button>
                            <el-input v-if="this.telCode" style="width: 63%; float: right" v-model="loginFormTelCode.code" prop="password" type="password" prefix-icon="el-icon-lock" placeholder="验证码"></el-input>
                        </el-form-item>

                        <el-form-item class="btn-item">
                            <el-button type="primary" @click="loginByTelCode">登录</el-button>
                            <el-button type="info" @click="resetLoginForm">重置</el-button>
                        </el-form-item>
                    </el-tab-pane>
                    <el-tab-pane label="" :disabled=true name="fourth"></el-tab-pane>
                    <el-tab-pane label="" :disabled=true name="fifth"></el-tab-pane>
                    <el-tab-pane label="注册账号" name="third">
                        <!--登录表单-->
                        <el-form-item prop="tel" size="small">
                            <el-input v-model="loginForm.tel" prop="tel" prefix-icon="el-icon-user-solid" placeholder="手机号"></el-input>
                        </el-form-item>

                        <el-form-item size="small" >
                            <el-button style="margin-right: 25px" type="primary" @click="registerSendSms" plain>发送验证码</el-button>
                            <el-input v-if="this.telCode" style="width: 63%; float: right" v-model="loginFormTelCode.code" prop="password" type="password" prefix-icon="el-icon-lock" placeholder="验证码"></el-input>
                        </el-form-item>

                        <el-form-item prop="password" size="small">
                            <el-input v-model="loginForm.password" prop="password"  type="password" prefix-icon="el-icon-lock" placeholder="密码"></el-input>
                        </el-form-item>

                        <el-form-item class="btn-item" size="small">
                            <el-button type="primary" @click="register">注册</el-button>
                            <el-button type="info" @click="resetLoginForm">重置</el-button>
                        </el-form-item>
                    </el-tab-pane>
                </el-tabs>
            </el-form>
        </div>
    </div>
</template>

<script>
    //验证手机号规则
    const checkMobile = (rule,value,cb)=>{
        // 手机号验证正则表达式
        const regMobile = /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/
        if(regMobile.test(value)){
            return cb();
        }
        cb(new Error('请输入合法的手机号'))
    }
    export default {
        data(){
            return{
                telCode:'',
                activeName: 'first',
                backNote:{
                    backgroundImage:"url("+require("C:\\Users\\admin\\Desktop\\服务外包\\img\\1.jpeg")+")",
                    backgroundRepeat:"no-repeat",
                    backgroundPosition:"center",
                    backgroundSize:"100% 100%"
                },
                //这是登录表单的数据绑定对象
                loginForm:{tel:'',password:''},
                loginFormTelCode:{tel:'',code:''},
                //表单验证
                loginRules:{
                    tel: [
                        { required:true, message: '请输入账号', trigger: 'blur' },
                        { validator:checkMobile, trigger: 'blur' }
                    ],
                    // password: [
                    //     { required: true, message: '请输入密码', trigger: 'blur' },
                    //     { min: 6, max: 15, message: '长度在 6 到 15 个字符', trigger: 'blur' }
                    // ]
                }

            }
        },
        methods:{
            //点击重置按钮，重置表单信息
            resetLoginForm(){
                this.$refs.loginRef.resetFields();
            },
            login(){
                this.$refs.loginRef.validate(async valid=>{
                    if(!valid) return;
                    const {data :res} = await this.$http.post('/user/login',this.loginForm);
                    console.log(res);
                    if(res.status!==200) return this.$message.error("对不起，登录失败");
                    this.$message.success("恭喜您，登录成功");
                    //1、将登录成功后的token,保存到客户端sessionStorage中
                    //1.1、项目中除了登录外的其它接口，必须在登录之后才能访问
                    //1.2、token只能在当前网站打开时有效，所以，将token保存在sessionStorage中
                    window.sessionStorage.setItem("userId",res.useId);
                    //2、通过编程式导航跳转到后台主页，路由地址是 /home
                    await this.$router.push('/home')
                })
            },
            registerSendSms(){

            },
            register(){

            },
            handleClick(tab, event) {
                console.log(tab, event);
                this.$refs.loginRef.resetFields();
            },
            loginSendSms(){
                this.$refs.loginRef.validate(async valid=>{
                    if(!valid) return;
                    this.loginFormTelCode.tel = this.loginForm.tel
                    const {data :res} = await this.$http.get('user/login/getTelCode',{params:this.loginFormTelCode});
                    if(res.code!==201){
                        this.telCode = res.message;
                        window.sessionStorage.setItem("userId",res.code);
                    }else{
                        if(res.message==='用户不存在，请注册'){
                            this.$refs.loginRef.resetFields();
                            this.activeName= 'third'
                        }
                        return this.$message.error(res.message)
                    }
                })
            },
            async loginByTelCode(){
                if(this.loginFormTelCode.code===this.telCode){
                    this.loginFormTelCode.tel = this.loginForm.tel
                    this.$message.success("恭喜您，登录成功");
                    await this.$router.push('/home')
                }else{
                    this.$message.error("验证码有误")
                }
            }
        }
    }
</script>

<style lang="less" scoped>
    .login_container{
        background-color: #2b4b6b;
        height: 100%;
    }
    .login_box{
        box-shadow: 0 2px 12px 0 rgba(0,0,0.5,0.5);
        height:350px;
        width: 500px;
        background-color: #ffff;
        border-radius: 3px;
        position: absolute;
        left: 50%;
        top:50%;
        transform: translate(-50%,-50%);
        background-image: url("../assets/login.jpg");
    }
    .avatar_box{
        height: 100px;
        width: 100px;
        border: 1px solid #eee;
        border-radius: 50%;
        padding: 4px;

        box-shadow: 0 0 10px #ddd;
        position: absolute;
        left: 50%;
        transform: translate(-50%,-50%);
        background-color: #fff;

        img{
            width: 100%;
            height: 100%;
            border-radius: 50%;
            background-color: #eee;
        }

    }
    .btn-item{
        display: flex;
        margin-bottom: 1px;
        justify-content: flex-end;
    }
    .loginForm{
        position: absolute;
        bottom: 20%;
        width: 100%;
        padding: 0 60px;
        box-sizing: border-box;
    }
</style>
<template xmlns:el-col="http://www.w3.org/1999/html">
    <div style="width:100%;height:100%;padding-top: 30px">
    <div style="width: 80%;margin: 0px auto">
        <el-card class="box-card">
            <!--            alert 提示信息-->
            <el-alert
                    title="填写个人简历"
                    type="info"
                    center
                    show-icon :closable = "false">
            </el-alert>
            <!--            含状态步骤条-->
            <el-steps :active="activeIndex - 0" finish-status="success" align-center>
                <el-step title="基本信息"></el-step>
                <el-step title="技能清单"></el-step>
                <el-step title="荣誉奖项"></el-step>
                <el-step title="实习经历"></el-step>
                <el-step title="项目经历"></el-step>
            </el-steps>
            <!--            tab页-->
            <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm">
                <el-tabs v-model="activeIndex" :tab-position="'left'">
                    <el-tab-pane label="基本信息" name="0">
                        <el-row :gutter="15">
                            <el-col :span="5">
                                <el-form-item>
                                    <el-upload
                                            class="avatar-uploader"
                                            :action="fileUrl"
                                            name="myfile"
                                            :on-change="handleChangePhotoFile"
                                            :show-file-list="false"
                                            :on-success="handleAvatarSuccess"
                                            :before-upload="beforeAvatarUpload">
                                        <img v-if="imageUrl" :src="imageUrl" class="avatar">
                                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                                    </el-upload>
                                </el-form-item>
                            </el-col>
                            <el-col :span="12">
                                <el-form-item label="自我介绍:">
                                    <el-input
                                            type="textarea"
                                            :autosize="{ minRows: 6, maxRows: 7}"
                                            maxlength="500"
                                            placeholder="请输入内容"
                                            v-model="ruleForm.user.introduce" show-word-limit>
                                    </el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row :gutter="10">
                            <el-col :span="5">
                                <el-form-item label="姓名:" prop="user.name">
                                    <el-input v-model="ruleForm.user.name" placeholder="姓名"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="5">
                                <el-form-item label="性别" prop="user.sex">
                                    <el-select v-model="ruleForm.user.sex" placeholder="请选择性别">
                                        <el-option label="男" value="男"></el-option>
                                        <el-option label="女" value="女"></el-option>
                                    </el-select>
                                </el-form-item>
                            </el-col>
                            <el-col :span="5">
                                <el-form-item label="年龄:" prop="user.age">
                                    <el-input v-model="age" placeholder="年龄"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="5">
                                <el-form-item label="民族:" prop="user.nation">
                                    <el-select v-model="ruleForm.user.nation" placeholder="请选择民族">
                                        <el-option label="汉族" value="汉族"></el-option>
                                        <el-option label="维吾尔族" value="维吾尔族"></el-option>
                                        <el-option label="满族" value="满族"></el-option>
                                    </el-select>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row :gutter="10">
                            <el-col :span="5">
                                <el-form-item label="政治面貌:" prop="user.politicStatus">
                                    <el-select v-model="ruleForm.user.politicStatus" placeholder="政治面貌">
                                        <el-option label="共青团员" value="共青团员"></el-option>
                                        <el-option label="护照" value="护照"></el-option>
                                        <el-option label="其他" value="其他"></el-option>
                                    </el-select>
                                </el-form-item>
                            </el-col>
                            <el-col :span="5">
                                <el-form-item label="证件类型:" prop="user.ident">
                                    <el-select v-model="ruleForm.user.ident" placeholder="证件类型">
                                        <el-option label="居民身份证" value="居民身份证"></el-option>
                                        <el-option label="护照" value="护照"></el-option>
                                        <el-option label="台胞证" value="台胞证"></el-option>
                                        <el-option label="军官证" value="军官证"></el-option>
                                        <el-option label="回乡证" value="回乡证"></el-option>
                                        <el-option label="往来大陆通行证" value="往来大陆通行证"></el-option>
                                        <el-option label="其他" value="其他"></el-option>
                                    </el-select>
                                </el-form-item>
                            </el-col>
                            <el-col :span="5">
                                <el-form-item label="身份证号:" prop="user.identNumber">
                                    <el-input v-model="ruleForm.user.identNumber" placeholder="身份证号"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="5">
                                <el-form-item label="出生日期:" prop="user.birth">
                                    <el-date-picker
                                            v-model="ruleForm.user.birth"
                                            type="date"
                                            placeholder="出生日期">
                                    </el-date-picker>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row :gutter="10">
                            <el-col :span="5">
                                <el-form-item label="最高学历:" prop="user.maxEduBack">
                                    <el-select v-model="ruleForm.user.maxEduBack"
                                               @change="selectEduBack(ruleForm.user.maxEduBack)">
                                        <el-option label="请选择" value=""></el-option>
                                        <el-option
                                                v-for="item in Form.eduBackList"
                                                :key="item"
                                                :label="item"
                                                :value="item">
                                        </el-option>
                                    </el-select>
                                </el-form-item>
                            </el-col>
                            <el-col :span="5">
                                <el-form-item v-if="this.edu_min==1" label="本科/专科:" prop="user.edu_ben">
                                    <el-input v-model="ruleForm.user.eduBen" placeholder="学校名称"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="5">
                                <el-form-item v-if="this.edu_min==1" label="本科专业:" prop="user.benMajor">
                                    <el-input v-model="ruleForm.user.benMajor" placeholder="本科专业"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="5">
                                <el-form-item v-if="this.edu_min==1" label="就读时间">
                                    <el-date-picker
                                            v-model="eduBenDate.date"
                                            type="monthrange"
                                            unlink-panels
                                            range-separator="至"
                                            start-placeholder="入学日期"
                                            end-placeholder="毕业日期">
                                    </el-date-picker>
                                </el-form-item>
                            </el-col>
                            <el-col :span="5">
                                <el-form-item v-if="this.edu_mid==1" label="硕士:" prop="user.edu_suo">
                                    <el-input v-model="ruleForm.user.eduSuo" placeholder="学校名称"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="5">
                                <el-form-item v-if="this.edu_mid==1" label="硕士专业:" prop="user.suoMajor">
                                    <el-input v-model="ruleForm.user.suoMajor" placeholder="硕士专业"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="5">
                                <el-form-item v-if="this.edu_mid==1" label="就读时间:" prop="user.eduSuoDate">
                                    <el-date-picker
                                            v-model="eduSuoDate.date"
                                            type="monthrange"
                                            unlink-panels
                                            range-separator="至"
                                            start-placeholder="入学日期"
                                            end-placeholder="毕业日期">
                                    </el-date-picker>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row :gutter="10">
                            <el-col :span="5">
                                <el-form-item v-if="this.edu_max==1" label="博士:" prop="user.edu_bo">
                                    <el-input v-model="ruleForm.user.eduBo" placeholder="学校名称"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="5">
                                <el-form-item v-if="this.edu_max==1" label="博士专业:" prop="user.boMajor">
                                    <el-input v-model="ruleForm.user.boMajor" placeholder="博士专业"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="5">
                                <el-form-item v-if="this.edu_max==1" label="就读时间:" prop="user.eduBoDate">
                                    <el-date-picker
                                            v-model="eduBoDate.date"
                                            type="monthrange"
                                            unlink-panels
                                            range-separator="至"
                                            start-placeholder="入学日期"
                                            end-placeholder="毕业日期">
                                    </el-date-picker>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row :gutter="10">
                            <el-col :span="5">
                                <el-form-item label="手机号:" prop="user.tel">
                                    <el-input v-model="ruleForm.user.tel" placeholder="手机号"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="5">
                                <el-form-item label="邮箱:" prop="user.email">
                                    <el-input v-model="ruleForm.user.email" placeholder="邮箱"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="10">
                                <el-form-item label="  英语水平:" prop="user.siJi">
                                    <el-radio-group v-model="ruleForm.user.english">
                                        <el-radio :label="1">四级</el-radio>
                                        <el-radio :label="2">六级</el-radio>
                                        <el-radio :label="3">雅思>=7</el-radio>
                                        <el-radio :label="4">托福>=95</el-radio>
                                    </el-radio-group>
                                </el-form-item>
                            </el-col>
                            <el-col :span="5">
                                <el-form-item label="英语证书凭证:">
                                    <el-upload
                                            class="upload-demo"
                                            :action="fileUrl"
                                            :on-change="handleChangeFile"
                                            :on-preview="handleEnglishPreview"
                                            :on-remove="handleEnglishRemove"
                                            :before-remove="beforeEnglishRemove"
                                            multiple
                                            name="myfile"
                                            :limit="1"
                                            :on-exceed="handleEnglishExceed"
                                            :file-list="fileEnglishList">
                                        <el-button size="small" type="primary">点击上传</el-button>
                                    </el-upload>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row :gutter="10">
                            <el-col :span="10">
                                <el-form-item label="自我评价:">
                                    <el-input
                                            type="textarea"
                                            placeholder="请输入内容"
                                            v-model="ruleForm.user.evaluation"
                                            maxlength="200"
                                            clearable
                                            :autosize="autosize"
                                            show-word-limit>
                                    </el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="10">
                                <el-form-item label="兴趣爱好:">
                                    <el-input
                                            type="textarea"
                                            placeholder="请输入内容"
                                            v-model="ruleForm.user.hobby"
                                            maxlength="200"
                                            clearable
                                            :autosize="autosize"
                                            show-word-limit>
                                    </el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </el-tab-pane>
                    <el-tab-pane label="技能清单" name="1">
                        <el-form-item label="职位名称">
                            <el-cascader
                                    v-model="position_cat"
                                    :options="cateList"
                                    :props="{ expandTrigger: 'hover'}"
                                    clearable :show-all-levels="false" @change="handleChange"></el-cascader>
                        </el-form-item>
                        <el-form-item
                                v-for="(domainSkill, index) in ruleForm.domainSkills"
                                :label="'技能' + index"
                                :key="domainSkill.key"
                                :prop="'domainSkills.' + index + '.text'"
                                :rules="{required: true, message: '技能不能为空', trigger: 'blur'}">
                            <div>
                                <div class="left1">
                                    <el-input  placeholder="请输入你的技能，比如精通xxx" v-model="domainSkill.text" maxlength="80"
                                               show-word-limit></el-input>
                                </div>
                                <div class="left2">
                                    <el-button type="warning" @click.prevent="removeDomainSkill(domainSkill)">删除</el-button>
                                </div>
                            </div>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click="addDomainSkill">新增</el-button>
                        </el-form-item>
                    </el-tab-pane>
                    <el-tab-pane label="荣誉奖项" name="2">
                        <el-form-item
                                v-for="(domain, index) in ruleForm.domains"
                                :label="'荣誉奖项' + index"
                                :key="domain.key"
                                :prop="'domains.' + index + '.text'"
                                :rules="{required: true, message: '荣誉不能为空', trigger: 'blur'}">
                            <div>
                                <div class="left1">
                                    <el-input  placeholder="请输入获奖经历\资格证书" v-model="domain.text" maxlength="50"
                                               show-word-limit></el-input>

<!--                                        <el-upload-->
<!--                                                class="upload-demo"-->
<!--                                                :action="fileUrl"-->
<!--                                                :on-change="handleChangeFile"-->
<!--                                                :on-preview="handleEnglishPreview"-->
<!--                                                :on-remove="handleEnglishRemove"-->
<!--                                                :before-remove="beforeEnglishRemove"-->
<!--                                                multiple-->
<!--                                                name="myfile"-->
<!--                                                :limit="1"-->
<!--                                                :on-exceed="handleEnglishExceed"-->
<!--                                                :file-list="fileEnglishList">-->
<!--                                            <el-button size="small" type="primary">点击上传</el-button>-->
<!--                                        </el-upload>-->
                                </div>
                                <div class="left2">
                                    <el-button type="warning" @click.prevent="removeDomain(domain)">删除</el-button>
                                </div>
                            </div>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click="addDomain">新增</el-button>
                        </el-form-item>
                    </el-tab-pane>
                    <el-tab-pane label="实习经历" name="3">
                        <el-form-item
                                v-for="(domainPractice, index) in ruleForm.domainPractices"
                                :label="'实习经历' + index"
                                :key="domainPractice.key"
                                :prop="'domainPractices.' + index + '.text'"
                                :rules="{required: true, message: '荣誉不能为空', trigger: 'blur'}">
                            <div>
                                <div class="left1">
                                    <el-input type="textarea"  placeholder="实习经历" v-model="domainPractice.text" maxlength="50"
                                              show-word-limit :autosize="autosizePractice"></el-input>
                                </div>
                                <div class="left2">
                                    <el-button type="warning" @click.prevent="removeDomainPractice(domainPractice)">删除</el-button>
                                </div>
                            </div>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click="addDomainPractice">新增</el-button>
                        </el-form-item>
                    </el-tab-pane>
                    <el-tab-pane label="项目经历" name="4">
                        <el-form-item
                                v-for="(domainProject, index) in ruleForm.domainProjects"
                                :label="'项目经历' + index"
                                :key="domainProject.key"
                                :prop="'domainProjects.' + index + '.text'"
                                :rules="{required: true, message: '荣誉不能为空', trigger: 'blur'}">
                            <div>
                                <div class="left1">
                                    <el-input type="textarea"  placeholder="请输入项目经历" v-model="domainProject.text" maxlength="200"
                                              show-word-limit :autosize="autosizePractice"></el-input>
                                </div>
                                <div class="left2">
                                    <el-button type="warning" @click.prevent="removeDomainProject(domainProject)">删除</el-button>
                                </div>
                            </div>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click="addDomainProject">新增</el-button>
                        </el-form-item>
                        <el-form-item style="margin-left: 25%">
                            <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                        </el-form-item>
                    </el-tab-pane>
                </el-tabs>
            </el-form>
        </el-card>
    </div>
    </div>

</template>

<script>
    const isNum = (rule, value, callback) => {
        const age= /^[0-9]*$/
        if (!age.test(value)) {
            callback(new Error('年龄只能为数字'))
        }else{
            callback()
        }
    }
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
    //验证手机号规则
    const checkMobile = (rule,value,cb)=>{
        // 手机号验证正则表达式
        const regMobile = /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/
        if(regMobile.test(value)){
            return cb();
        }
        cb(new Error('请输入合法的手机号'))
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
    export default {
        data(){
            return {
                age:'',
                eduBenDate: {
                    date: [],
                },
                eduSuoDate: {
                    date: [],
                },
                eduBoDate: {
                    date: [],
                },
                fileUrl:"http://localhost:83/File/upload",
                imageUrl:'',
                cateList: [
                    {
                    value: '技术',
                    label: '技术',
                    children: [{
                        value: '后端开发',
                        label: '后端开发',
                        children: [{
                            value: 'java工程师',
                            label: 'java工程师'
                        }, {
                            value: 'fankui',
                            label: '反馈'
                        }, {
                            value: 'xiaolv',
                            label: '效率'
                        }, {
                            value: 'kekong',
                            label: '可控'
                        }]
                    }, {
                        value: 'daohang',
                        label: '导航',
                        children: [{
                            value: 'cexiangdaohang',
                            label: '侧向导航'
                        }, {
                            value: 'dingbudaohang',
                            label: '顶部导航'
                        }]
                    }]
                }, {
                    value: 'zujian',
                    label: '组件',
                    children: [{
                        value: 'basic',
                        label: 'Basic',
                        children: [{
                            value: 'layout',
                            label: 'Layout 布局'
                        }, {
                            value: 'color',
                            label: 'Color 色彩'
                        }, {
                            value: 'typography',
                            label: 'Typography 字体'
                        }, {
                            value: 'icon',
                            label: 'Icon 图标'
                        }, {
                            value: 'button',
                            label: 'Button 按钮'
                        }]
                    }, {
                        value: 'form',
                        label: 'Form',
                        children: [{
                            value: 'radio',
                            label: 'Radio 单选框'
                        }, {
                            value: 'checkbox',
                            label: 'Checkbox 多选框'
                        }, {
                            value: 'input',
                            label: 'Input 输入框'
                        }, {
                            value: 'input-number',
                            label: 'InputNumber 计数器'
                        }, {
                            value: 'select',
                            label: 'Select 选择器'
                        }, {
                            value: 'cascader',
                            label: 'Cascader 级联选择器'
                        }, {
                            value: 'switch',
                            label: 'Switch 开关'
                        }, {
                            value: 'slider',
                            label: 'Slider 滑块'
                        }, {
                            value: 'time-picker',
                            label: 'TimePicker 时间选择器'
                        }, {
                            value: 'date-picker',
                            label: 'DatePicker 日期选择器'
                        }, {
                            value: 'datetime-picker',
                            label: 'DateTimePicker 日期时间选择器'
                        }, {
                            value: 'upload',
                            label: 'Upload 上传'
                        }, {
                            value: 'rate',
                            label: 'Rate 评分'
                        }, {
                            value: 'form',
                            label: 'Form 表单'
                        }]
                    }, {
                        value: 'data',
                        label: 'Data',
                        children: [{
                            value: 'table',
                            label: 'Table 表格'
                        }, {
                            value: 'tag',
                            label: 'Tag 标签'
                        }, {
                            value: 'progress',
                            label: 'Progress 进度条'
                        }, {
                            value: 'tree',
                            label: 'Tree 树形控件'
                        }, {
                            value: 'pagination',
                            label: 'Pagination 分页'
                        }, {
                            value: 'badge',
                            label: 'Badge 标记'
                        }]
                    }, {
                        value: 'notice',
                        label: 'Notice',
                        children: [{
                            value: 'alert',
                            label: 'Alert 警告'
                        }, {
                            value: 'loading',
                            label: 'Loading 加载'
                        }, {
                            value: 'message',
                            label: 'Message 消息提示'
                        }, {
                            value: 'message-box',
                            label: 'MessageBox 弹框'
                        }, {
                            value: 'notification',
                            label: 'Notification 通知'
                        }]
                    }, {
                        value: 'navigation',
                        label: 'Navigation',
                        children: [{
                            value: 'menu',
                            label: 'NavMenu 导航菜单'
                        }, {
                            value: 'tabs',
                            label: 'Tabs 标签页'
                        }, {
                            value: 'breadcrumb',
                            label: 'Breadcrumb 面包屑'
                        }, {
                            value: 'dropdown',
                            label: 'Dropdown 下拉菜单'
                        }, {
                            value: 'steps',
                            label: 'Steps 步骤条'
                        }]
                    }, {
                        value: 'others',
                        label: 'Others',
                        children: [{
                            value: 'dialog',
                            label: 'Dialog 对话框'
                        }, {
                            value: 'tooltip',
                            label: 'Tooltip 文字提示'
                        }, {
                            value: 'popover',
                            label: 'Popover 弹出框'
                        }, {
                            value: 'card',
                            label: 'Card 卡片'
                        }, {
                            value: 'carousel',
                            label: 'Carousel 走马灯'
                        }, {
                            value: 'collapse',
                            label: 'Collapse 折叠面板'
                        }]
                    }]
                }, {
                    value: 'ziyuan',
                    label: '资源',
                    children: [{
                        value: 'axure',
                        label: 'Axure Components'
                    }, {
                        value: 'sketch',
                        label: 'Sketch Templates'
                    }, {
                        value: 'jiaohu',
                        label: '组件交互文档'
                    }]
                }],
                position_cat:[],
                activeIndex:'0',
                //imageUrl: require("C:\\Users\\admin\\Desktop\\1.jpg"),
                edu_min:'',
                edu_mid:'',
                edu_max:'',
                Form:{
                    eduBackList:['博士研究生/博士后','硕士研究生','大学本科','大学专科','高中','职业高中','技校']
                },
                ruleForm: {
                    user:{
                        id:'',
                        photo:'',
                        name: '',
                        sex: '',
                        comid:'',
                        nation:'',
                        politicStatus:'',
                        //证件类型
                        ident:'',
                        identNumber:'',
                        birth:'',
                        maxEduBack:'',
                        eduBen:'',
                        eduBenDateStart:'',
                        eduBenDateEnd:'',
                        benMajor:'',
                        eduSuo:'',
                        suoMajor:'',
                        eduSuoDateStart:'',
                        eduSuoDateEnd:'',
                        eduBo:'',
                        boMajor:'',
                        eduBoDateStart:'',
                        eduBoDateEnd:'',
                        tel:'',
                        email:'',
                        english:'',
                        englishUrl:'',
                        status:'',
                        posname:'',
                        //自我介绍
                        introduce:'',
                        //自我评价
                        evaluation:'',
                        //兴趣爱好
                        hobby:''
                    },

                    //荣誉
                    domains: [{
                        text: '',
                        url:''
                    }],
                    //技能
                    domainSkills:[{
                        text:''
                    }],
                    //项目经历
                    domainProjects:[{
                        text:''
                    }],
                    //实习经历
                    domainPractices:[{
                        text:''
                    }],
                },
               // 校验规则
                rules: {
                    age:[{required: true,message:'请输入年龄',trigger:'blur'},
                        {validator:isNum, message: '请输入数字', trigger: 'blur' },
                        {min:2, max:2, message: '请输入二位数字', trigger: 'blur' }
                    ],
                    user:{
                        name: [
                            { required: true, message: '请输入姓名', trigger: 'blur' },
                            { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                        ],
                        sex:[{required: true,message:'请选择',trigger:'blur'}],
                        nation:[{required: true,message:'请选择',trigger:'blur'}],
                        politicStatus:[{required: true,message:'请选择',trigger:'blur'}],
                        ident:[{required: true,message:'请选择',trigger:'blur'}],
                        identNumber:[{required: true,message:'请输入身份证号',trigger:'blur'},
                            {validator:checkIdent,trigger: 'blur'}],
                        birth:[{required: true,message:'请选择',trigger:'blur'}],
                        maxEduBack:[{required: true,message:'请选择',trigger:'blur'}],
                        eduBen:[{ required: true, message: '请输入学校名称', trigger: 'blur' },
                            { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }],
                        eduBenDate:[{required: true, message: '请选择', trigger: 'blur' }],
                        benMajor:[{ required: true, message: '请输入本科专业名称', trigger: 'blur' },
                            { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }],
                        benJiDian:[{required: true, message: '请输入绩点', trigger: 'blur' },
                            { min: 1, max: 3, message: '1~3数字', trigger: 'blur' }],
                        eduSuo:[{ required: true, message: '请输入学校名称', trigger: 'blur' },
                            { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }],
                        suoMajor:[{ required: true, message: '请输入硕士专业名称', trigger: 'blur' },
                            { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }],
                        eduSuoDate:[{required: true, message: '请选择', trigger: 'blur' }],
                        eduBo:[{ required: true, message: '请输入学校名称', trigger: 'blur' },
                            { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }],
                        boMajor:[{ required: true, message: '请输入博士专业名称', trigger: 'blur' },
                            { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }],
                        eduBoDate:[{required: true, message: '请选择', trigger: 'blur' }],
                        tel:[{ required: true, message: '请输入用户手机号', trigger: 'blur' },
                            {validator: checkMobile,trigger: 'blur'}],
                        email:[{ required: true, message: '请输入用户邮箱', trigger: 'blur' },
                            {validator: checkEmail,trigger: 'blur'}],
                    },
                },
                //英语凭证图片
                fileEnglishList: {name:'',url:''},
                //头像图片
                filePhotoUrl:'',
                autosize:{ minRows: 4, maxRows: 6 },
                autosizeHonor:{ minRows:2, maxRows: 4 },
                autosizePractice:{ minRows:4, maxRows: 8 },
                autosizeProject:{ minRows:4, maxRows: 8 },
                selectSearch:'',
                search:'',
            }
        },

        methods:{
            submitForm(formName) {
                this.$refs[formName].validate(async (valid) => {
                    if(!valid){
                        this.$message.warning('请确定前面填写表项是否正确')
                        return
                    }
                    this.ruleForm.user.eduBenDateStart=this.eduBenDate.date[0];
                    this.ruleForm.user.eduBenDateEnd=this.eduBenDate.date[1];
                    this.ruleForm.user.eduSuoDateStart=this.eduSuoDate.date[0];
                    this.ruleForm.user.eduSuoDateEnd=this.eduSuoDate.date[1];
                    this.ruleForm.user.eduBoDateStart=this.eduBoDate.date[0];
                    this.ruleForm.user.eduBoateEnd=this.eduBoDate.date[1];

                    this.ruleForm.user.englishUrl = this.fileEnglishList.url
                    this.ruleForm.user.status = 1
                    this.ruleForm.user.id = window.sessionStorage.getItem("userId")
                    this.ruleForm.user.posname = this.position_cat[2]
                    this.ruleForm.user.photo = this.filePhotoUrl

                    if(this.ruleForm.sex==='男'){
                        this.ruleForm.user.sex = 1
                    }else{
                        this.ruleForm.user.sex = 0
                    }
                    console.log(this.ruleForm)
                    const {data : res} = await this.$http.post('/user/info',this.ruleForm);
                    console.log(res)
                    if (res.status===200) {
                        alert('submit!');
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            selectEduBack(val){
                if(val=='大学本科'||val=='大学专科'){this.edu_min=1;this.edu_mid=0;this.edu_max=0}
                else if(val=='硕士研究生'){this.edu_min=1;this.edu_mid=1;this.edu_max=0}
                else if(val=='博士研究生/博士后'){this.edu_min=1;this.edu_mid=1;this.edu_max=1}
                else{this.edu_min=0;this.edu_mid=0;this.edu_max=0}
            },
            // handleAvatarSuccess(res, file) {
            //     this.imageUrl = URL.createObjectURL(file.raw);
            //     this.img = `C:\\Users\\admin\\Desktop\\服务外包\\企业人才管理系统\\vue_hrrrr\\picture\\${file.raw.name}`;
            //     console.log(this.img)
            // },
            handleAvatarSuccess(res, file) {
                this.imageUrl = URL.createObjectURL(file.raw);
            },
            beforeAvatarUpload(file) {
                const isJPG = file.type === 'image/jpeg';
                const isLt2M = file.size / 1024 / 1024 < 2;

                if (!isJPG) {
                    this.$message.error('上传头像图片只能是 JPG 格式!');
                }
                if (!isLt2M) {
                    this.$message.error('上传头像图片大小不能超过 2MB!');
                }
                return isJPG && isLt2M;
            },
            drawPie() {
                //1、导入 echarts
                const eCharts = require('echarts')
                let charts = eCharts.init(document.getElementById('leiDaTu'));
                var option = {
                    title: {
                        text: "java工程师等级划分标准",
                        target: "blank",
                        padding: [400,0,0,150],
                        textAlign: 'bottom',
                    },
                    tooltip: {},//提示层
                    legend: {
                        data: ['java初级工程师','java中级工程师','java高级工程师','java架构师']
                    },
                    radar: {
                        splitNumber: 5, // 雷达图圈数设置
                        name: {
                            formatter:'【{value}】',
                            textStyle: {
                                color: '#0C0C0C', //字体颜色
                                // backgroundColor: '#999', //背景色
                                // borderRadius: 3, //圆角
                                // padding: [6,5,2,5] //padding
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
                        indicator: [
                            {name: '基础算法',
                                max: 100
                            },
                            {
                                name: 'java开发基础',
                                max: 100
                            },
                            {
                                name: '数据库设计优化',
                                max: 100
                            },
                            {
                                name: '高并发',
                                max: 100
                            },
                            {
                                name: 'java语言基础',
                                max: 100
                            },
                            {
                                name: '主流Web框架',
                                max: 100
                            },
                            {
                                name: '英语阅读能力',
                                max: 100
                            },
                            {
                                name: '工程工具',
                                max: 100
                            },
                            {
                                name: '业务能力',
                                max: 100
                            },
                            {
                                name: 'Linux系统',
                                max: 100
                            },
                            {
                                name: '沟通协调能力',
                                max: 100
                            },
                        ],
                    },
                    series: [
                        {
                            name: '测试标题名字',
                            type: 'radar',
                            // itemStyle : {//设置线条和折点的颜色
                            //   normal : {
                            //     color:'#00FF00',
                            //     lineStyle:{
                            //       color:'#91CC75'
                            //     }
                            //   }
                            // },
                            emphasis: {//当点击圈线时，会凸显
                                lineStyle: {
                                    width: 4
                                }
                            },
                            data: [
                                {
                                    value: [75,40,30,20,70,60,70,60,50,40,75],
                                    name: "java初级工程师",
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
                                    value: [75,60,50,50,85,78,70,77,80,67,75],
                                    name: "java中级工程师",
                                    areaStyle: {
                                        color: 'rgba(255, 255, 255, 0.5)'
                                    }
                                },
                                {
                                    value: [90,80,75,75,85,85,78,85,85,80,80],
                                    name: "java高级工程师",
                                    areaStyle: {
                                        color: 'rgba(255, 255, 255, 0.5)'
                                    }
                                },
                                {
                                    value: [95,90,95,95,85,90,85,90,95,92,98],
                                    name: "java架构师",
                                    areaStyle: {
                                        color: 'rgba(255, 255, 255, 0.5)'
                                    }
                                },
                            ]
                        }]
                }
                charts.setOption(option);
            },
            drawPieMe() {
                //1、导入 echarts
                const eCharts = require('echarts')
                let charts = eCharts.init(document.getElementById('leiDaTuMe'));
                var option = {
                    title: {
                        text: "java工程师等级划分标准",
                        target: "blank",
                        padding: [400,0,0,150],
                        textAlign: 'bottom',
                    },
                    tooltip: {},//提示层
                    legend: {
                        data: ['java初级工程师','java中级工程师','java高级工程师','java架构师']
                    },
                    radar: {
                        splitNumber: 5, // 雷达图圈数设置
                        name: {
                            formatter:'【{value}】',
                            textStyle: {
                                color: '#0C0C0C', //字体颜色
                                // backgroundColor: '#999', //背景色
                                // borderRadius: 3, //圆角
                                // padding: [6,5,2,5] //padding
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
                        indicator: [
                            {name: '基础算法',
                                max: 100
                            },
                            {
                                name: 'java开发基础',
                                max: 100
                            },
                            {
                                name: '数据库设计优化',
                                max: 100
                            },
                            {
                                name: '高并发',
                                max: 100
                            },
                            {
                                name: 'java语言基础',
                                max: 100
                            },
                            {
                                name: '主流Web框架',
                                max: 100
                            },
                            {
                                name: '英语阅读能力',
                                max: 100
                            },
                            {
                                name: '工程工具',
                                max: 100
                            },
                            {
                                name: '业务能力',
                                max: 100
                            },
                            {
                                name: 'Linux系统',
                                max: 100
                            },
                            {
                                name: '沟通协调能力',
                                max: 100
                            },
                        ],
                    },
                    series: [
                        {
                            name: '测试标题名字',
                            type: 'radar',
                            // itemStyle : {//设置线条和折点的颜色
                            //   normal : {
                            //     color:'#00FF00',
                            //     lineStyle:{
                            //       color:'#91CC75'
                            //     }
                            //   }
                            // },
                            emphasis: {//当点击圈线时，会凸显
                                lineStyle: {
                                    width: 4
                                }
                            },
                            data: [
                                {
                                    value: [75,40,30,20,70,60,70,60,50,40,75],
                                    name: "java初级工程师",
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
                                    value: [75,60,50,50,85,78,70,77,80,67,75],
                                    name: "java中级工程师",
                                    areaStyle: {
                                        color: 'rgba(255, 255, 255, 0.5)'
                                    }
                                },
                                {
                                    value: [90,80,75,75,85,85,78,85,85,80,80],
                                    name: "java高级工程师",
                                    areaStyle: {
                                        color: 'rgba(255, 255, 255, 0.5)'
                                    }
                                },
                                {
                                    value: [95,90,95,95,85,90,85,90,95,92,98],
                                    name: "java架构师",
                                    areaStyle: {
                                        color: 'rgba(255, 255, 255, 0.5)'
                                    }
                                },
                            ]
                        }]
                }
                charts.setOption(option);
            },
            handleEnglishRemove(file, fileEnglishList) {
                // console.log(file, fileEnglishList);
            },
            handleEnglishPreview(file)  {
                //看英语等级是否已经选择
            },
            handleEnglishExceed(files, fileEnglishList) {
                console.log(this.fileEnglishList)
                this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileEnglishList.length} 个文件`);
            },
            beforeEnglishRemove(file, fileEnglishList) {
                return this.$confirm(`确定移除 ${ file.name }？`);
            },
            removeDomain(item) {
                var index = this.ruleForm.domains.indexOf(item)
                if (index !== -1) {
                    this.ruleForm.domains.splice(index, 1)
                }
            },
            addDomain() {
                this.ruleForm.domains.push({
                    text: '',
                    key: Date.now()
                });
            },
            removeDomainSkill(item) {
                var index = this.ruleForm.domainSkills.indexOf(item)
                if (index !== -1) {
                    this.ruleForm.domainSkills.splice(index, 1)
                }
            },
            addDomainSkill() {
                this.ruleForm.domainSkills.push({
                    text: '',
                    key: Date.now()
                });
            },

            removeDomainPractice(item) {
                var index = this.ruleForm.domainPractices.indexOf(item)
                if (index !== -1) {
                    this.ruleForm.domainPractices.splice(index, 1)
                }
            },
            addDomainPractice() {
                this.ruleForm.domainPractices.push({
                    text: '',
                    key: Date.now()
                });
            },
            removeDomainProject(item) {
                var index = this.ruleForm.domainProjects.indexOf(item)
                if (index !== -1) {
                    this.ruleForm.domainProjects.splice(index, 1)
                }
            },
            addDomainProject() {
                this.ruleForm.domainProjects.push({
                    text: '',
                    key: Date.now()
                });
            },
            handleChange(){
                console.log(this.ruleForm.position_cat[this.ruleForm.position_cat.length-1])
            },
            handleChangeFile(file){
                this.fileEnglishList.name = file.name;
                //this.fileEnglishList.url = 'C:\\Users\\admin\\Desktop\\服务外包\\img\\'+file.name;
                this.fileEnglishList.url = 'http://localhost:83/file/upload/'+file.name;
                console.log(this.fileEnglishList.url)

            },
            handleChangePhotoFile(file){
                this.filePhotoUrl = 'http://localhost:83/file/upload/'+file.name;
                console.log(this.filePhotoUrl)
            }

        },
        //调用mounted时，此时页面上的DOM元素已经被初始化了
        mounted() {
            this.$nextTick(function() {
                this.drawPieMe('leiDaTuMe')
                this.drawPie('leiDaTu')
            })
        }
    }
</script>
<style lang="less" scoped>
    .avatar-uploader .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }
    .avatar-uploader .el-upload:hover {
        border-color: #409EFF;
    }
    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 120px;
        height: 150px;
        line-height: 178px;
        text-align: center;
    }
    .avatar {
        width: 120px;
        height: 150px;
        display: block;
    }
    .div-inline01{ display:inline;
        float: left;margin-left: 30px;margin-top: 1%}
    .div-in{
        display: block;
        margin-top: 10px;
        margin-left: -20px;
    }
    .div-inline02{ display:inline;margin-top: 2%;margin-right: 100px;
        float: right;}
    .row{
        margin-top: 0px;
    }

    .left1{
        float: left!important;
        margin-right: 10px;
        width: 700px;
    }
    .left2{
        float: left!important;
        margin-right: 10px;
    }


</style>
import Vue from 'vue'
import {Form,FormItem,Input,Button,Container,Header,Aside,Main,Menu,MenuItem,
    Submenu,MenuItemGroup,Breadcrumb,BreadcrumbItem,Card,Row,Col,Table,
    TableColumn,Switch,Tooltip,Pagination,Dialog,MessageBox,Tag,Tree,Select,
    Option,Cascader,Alert,Tabs,TabPane,Steps,Step,CheckboxGroup,Checkbox,Upload} from 'element-ui'
//导入弹框组件
import {Message} from "element-ui";
//use注冊為全局組件
Vue.use(Button)
Vue.use(Form)
Vue.use(FormItem)
Vue.use(Input)
Vue.use(Container)
Vue.use(Header)
Vue.use(Aside)
Vue.use(Main)
Vue.use(Menu)
Vue.use(MenuItem)
Vue.use(Submenu)
Vue.use(MenuItemGroup)
Vue.use(Breadcrumb)
Vue.use(BreadcrumbItem)
Vue.use(Card)
Vue.use(Row)
Vue.use(Col)
Vue.use(TableColumn)
Vue.use(Table)
Vue.use(Switch)
Vue.use(Tooltip)
Vue.use(Pagination)
Vue.use(Dialog)
Vue.use(Tag)
Vue.use(Tree)
Vue.use(Select)
Vue.use(Option)
Vue.use(Cascader)
Vue.use(Alert)
Vue.use(Tabs)
Vue.use(TabPane)
Vue.use(Steps)
Vue.use(Step)
Vue.use(CheckboxGroup)
Vue.use(Checkbox)
Vue.use(Upload)
//将Message组件挂载到了Vue的原型对象（prototype）上
Vue.prototype.$message=Message
Vue.prototype.$confirm=MessageBox .confirm
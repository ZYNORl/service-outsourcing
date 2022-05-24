import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from "../components/Home";
import About from "../views/About";
import Login from "../components/Login";
import Mock from "../views/Mock";
import Welcome from "../components/Welcome";
import Users from "../components/user/Users";
import Record from "../components/user/Record";
import Leida from "../views/Leida";
import Face from "../components/user/Face";
import Zhaopin from "../components/company/Zhaopin";
import Attendances from "../components/attendance/Attendances";
import SearchRecord from "../components/company/SearchRecord";
import Details from "../components/company/Details";
import UserDetail from "../components/user/UserDetail";
Vue.use(VueRouter)
const routes = [{path: '/mock', component: Mock},
  {path:'/',component:Login},
  {path:'/login',component:Login},
  {path:'/leida',component:Leida},
  {path:'/about',component:About},
  {path:'/home',component:Home,
    redirect:'/welcome',
    children:[
      {path:'/welcome',component:Welcome},
      {path:'/users',component:Users},
      {path:'/record/:id',component:Record},
      {path:'/userDetail/:id',component:UserDetail},
      {path:'/face',component:Face},
      {path:'/zhaopin',component:Zhaopin},
      {path:'/attendances',component:Attendances},
      {path:'/searchRecord',component:SearchRecord},
      {path:'/details',component:Details}
    ]
  },
]

const router = new VueRouter({
  routes
})
//向外暴露路由
export default router

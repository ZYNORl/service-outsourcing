import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "../components/Login";
import Home from "../components/Home";
import Look from "../components/Look";
import Navigation from "../components/Navigation";
import FindJob from "../components/FindJob";
import JobDetail from "../components/JobDetail";
Vue.use(VueRouter)
const routes = [
  {path:'/',component:Login},
  {path:'/login',component:Login},
  {path:'/navigation',component:Navigation,
    redirect:'/home',
    children:[
      {path:'/look',component:Look},
      {path:'/jobDetail/:id',component:JobDetail},
      {path:'/home',component:Home},
      {path:'/findJob',component:FindJob},
    ]
  },
]
const router = new VueRouter({
  routes
})
//向外暴露路由
export default router

//项目的入口地址
import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
Vue.use(ElementUI);
import './mock/index'
import router from './router'
import './plugins/element.js'
//导入全局样式表
import './assets/css/global.css'
//导入请求，拦截
import axios from "axios";
//导入树状表格
import TreeTable from 'vue-table-with-tree-grid'
//导入富文本编辑器
import VueQuillEditor from "vue-quill-editor";
//富文本样式
import 'quill/dist/quill.core.css' // import styles
import 'quill/dist/quill.snow.css' // for snow theme
import 'quill/dist/quill.bubble.css' // for bubble theme
Vue.config.productionTip = false
Vue.component('tree-table', TreeTable)
//将富文本编辑器注册为全局可用的组件
Vue.use(VueQuillEditor, /* { default global options } */)
Vue.component('tree-table', TreeTable)

// axios.defaults.baseURL='http://www.ysqorz.top:8888/api/private/v1/'
axios.defaults.baseURL='http://localhost:83/'
//在request拦截器上，显示拦截器，NProgress.start()
//axios配置請求攔截器 (請求頭加上token)
axios.interceptors.request.use(config=>{
  // NProgress.start()
  config.headers.Authorization = window.sessionStorage.getItem("token");
  //必須return config
  return config
})
Vue.filter('dataFormat',function (originVal) {
  const dt = new Date(originVal)

  const y = dt.getFullYear()
  const m = (dt.getMonth() + 1 +'').padStart(2,'0')
  const d = (dt.getDate() + '').padStart(2,'0')

  const hh = (dt.getHours() + '').padStart(2,'0')
  const mm = (dt.getMinutes() + '').padStart(2,'0')
  const ss = (dt.getSeconds() + '').padStart(2,'0')

  return `${y}-${m}-${d} ${hh}:${mm}:${ss}`
})
//全局挂载
Vue.prototype.$http = axios

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')

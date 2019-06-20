import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)
// 动态路径参数 以冒号开头
var routes = [{
  path: '/',
  name: 'login',
  component: resolve => require(['@/web/login'], resolve)
},
{
  path: '/modify',
  name: 'modify',
  component: resolve => require(['@/web/modify'], resolve)
},
{
  path: '/register',
  name: 'register',
  component: resolve => require(['@/components/register'], resolve)
},
{
  path: '/home',
  name: 'home',
  component: resolve => require(['@/components/homepage'], resolve)
},
{
  path: '/newsubject',
  name: 'newsubject',
  component: resolve => require(['@/components/newsubject'], resolve)
},
{
  path: '/mysubject/:id/:courseName/:discription',
  name: 'mysubject',
  component: resolve => require(['@/components/subject'], resolve)
},
{
  path: '/home/chat',
  name: 'chat',
  component: resolve => require(['@/components/chat'], resolve)
}
]

var router = new Router({
  linkActiveClass: 'active',
  routes: routes
})
export default router

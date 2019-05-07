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
  path: '/register',
  name: 'register',
  component: resolve => require(['@/components/register'], resolve)
},
{
  path: '/main',
  name: 'main',
  component: resolve => require(['@/components/main'], resolve)
}
]

var router = new Router({
  linkActiveClass: 'active',
  routes: routes
})
export default router

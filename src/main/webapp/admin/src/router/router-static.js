import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import news from '@/views/modules/news/list'
import tushufenlei from '@/views/modules/tushufenlei/list'
import maijia from '@/views/modules/maijia/list'
import yonghu from '@/views/modules/yonghu/list'
import orders from '@/views/modules/orders/list'
import storeup from '@/views/modules/storeup/list'
import config from '@/views/modules/config/list'
import liaotianjilu from '@/views/modules/liaotianjilu/list'
import discusstushuxinxi from '@/views/modules/discusstushuxinxi/list'
import tushuxinxi from '@/views/modules/tushuxinxi/list'


//2.配置路由   注意：名字
const routes = [{
  path: '/index',
  name: 'Home',
  component: Index,
  children: [{
    // 这里不设置value，Yes把main作为defaultpage面
    path: '/',
    name: 'Home',
    component: Home,
    meta: { icon: '', title: 'center' }
  }, {
    path: '/updatePassword',
    name: 'Change Password',
    component: UpdatePassword,
    meta: { icon: '', title: 'updatePassword' }
  }, {
    path: '/pay',
    name: '支付',
    component: pay,
    meta: { icon: '', title: 'pay' }
  }, {
    path: '/center',
    name: 'Person Information',
    component: center,
    meta: { icon: '', title: 'center' }
  }
    , {
    path: '/news',
    name: 'Notice information',
    component: news
  }
    , {
    path: '/tushufenlei',
    name: 'Book classification',
    component: tushufenlei
  }
    , {
    path: '/maijia',
    name: 'seller',
    component: maijia
  }
    , {
    path: '/yonghu',
    name: 'user',
    component: yonghu
  }
    , {
    path: '/orders/:status',
    name: 'Order management',
    component: orders
  }
    , {
    path: '/storeup',
    name: 'My Collection manage',
    component: storeup
  }
    , {
    path: '/config',
    name: 'Rotation chart',
    component: config
  }
    , {
    path: '/liaotianjilu',
    name: 'Chat record',
    component: liaotianjilu
  }
    , {
    path: '/discusstushuxinxi',
    name: 'Book informationcomment',
    component: discusstushuxinxi
  }
    , {
    path: '/tushuxinxi',
    name: 'Book information',
    component: tushuxinxi
  }
  ]
},
{
  path: '/login',
  name: 'login',
  component: Login,
  meta: { icon: '', title: 'login' }
},
{
  path: '/register',
  name: 'register',
  component: register,
  meta: { icon: '', title: 'register' }
},
{
  path: '/',
  name: 'Home',
  redirect: '/index'
}, /*default跳转路由*/
{
  path: '*',
  component: NotFound
}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;

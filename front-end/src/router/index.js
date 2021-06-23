import Vue from 'vue';
import VueRouter from 'vue-router';
Vue.use(VueRouter);

//解决vue路由重复导航错误
//获取原型对象上的push函数
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}

const router = new VueRouter({
  routes: [
    // {
    //     path: "/",
    //     component: () => import(/*webpackChunkName:"Home"*/'@/views/Home'),
    //     meta: { title: "首页" }
    // },
    {
      path: '/',
      redirect: '/login',
    },
    {
      path: '/active',
      name:'Active',
      component: () => import(/*webpackChunkName:"Active"*/ '@/views/Active'),
      meta: { title: '激活' },
    },
    {
      path: '/personal/home',
      redirect: '/home',
    },
    {
      path: '/personal/login',
      redirect: '/login',
    },
    {
      path: '/personal/active',
      redirect: '/active',
    },
    {
      path: '/admin/home',
      redirect: '/home',
    },
    {
      path: '/admin/login',
      redirect: '/login',
    },
    {
      path: '/home',
      name: 'Home',
      component: () => import(/* webpackChunkName: "Index" */ '@/views/Index'),
      meta: { title: '首页' },
    },
    {
      path: '/indexComplecated',
      name: 'IndexComplecated',
      component: () => import(/* webpackChunkName: "IndexComplicated" */ '@/views/IndexComplicated'),
      meta: { title: '首页' },
    },
    {
      path: '/login',
      props: true,
      component: () => import(/*webpackChunkName:"Login"*/ '@/views/Login'),
      meta: { title: '登录' },
    },
    {
      path: '/forgetPassword',
      name:'ForgetPassword',
      component: () => import(/*webpackChunkName:"Forgetpassword"*/ '@/views/ForgetPassword'),
      meta: { title: '忘记密码' },
    },
    {
      path: '/register',
      name:'Register',
      component: () => import(/*webpackChunkName:"Register"*/ '@/views/Register'),
      meta: { title: '注册' },
    },
    {
      path: '/morenews',
      props: true,
      component: () =>
        import(/*webpackChunkName:"MoreNews"*/ '@/views/MoreNews'),
      meta: { title: '新闻' },
    },
    {
      path: '/personal',
      name: 'Personal',
      redirect: '/personal/baseInformation',
      component: () =>
        import(/*webpackChunkName:"Personal"*/ '@/views/personal'),
      children: [
        {
          path: 'baseInformation',
          name: 'BaseInformation',
          component: () => import('@/views/personal/BaseInformation.vue'),
        },
        {
          path: 'changePassword',
          name: 'ChangePassword',
          component: () => import('@/views/personal/ChangePassword.vue'),
        },
        {
          path: 'integral',
          name: 'Integral',
          component: () => import('@/views/personal/Integral.vue'),
        },
        {
          path: 'rank',
          name: 'Rank',
          component: () => import('@/views/personal/Rank.vue'),
        },
        {
          path: 'answer',
          name: 'Answer',
          component: () => import('@/views/personal/Answer.vue'),
        },
        {
          path: 'answerResult',
          name: 'AnswerResult',
          component: () => import('@/views/personal/AnswerResult.vue'),
        },
        {
          path: 'experience',
          name: 'Experience',
          component: () => import('@/views/personal/Experience.vue'),
        },
        {
          path: 'publish',
          component: () => import('@/views/personal/PublishNotes'),
        },
        {
          path: 'message',
          name: 'Message',
          component: () => import('@/views/personal/Message.vue'),
        },
        {
          path: 'data',
          name: 'Data',
          component: () => import('@/views/personal/Data.vue'),
        },
      ],
    },
    {
      path: '/admin',
      name: 'Admin',
      redirect: '/admin/baseInformation',
      component: () => import('@/views/admin'),
      children: [
        {
          path: 'baseInformation',
          name: 'BaseInformation',
          component: () => import('@/views/admin/BaseInformation.vue'),
        },
        {
          path: 'reviewExperience',
          name: 'ReviewExperience',
          component: () => import('@/views/admin/ReviewExperience.vue'),
        },
        {
          path: 'reviewComment',
          name: 'ReviewComment',
          component: () => import('@/views/admin/ReviewComment.vue'),
        },
        {
          path: 'rank',
          name: 'Rank',
          component: () => import('@/views/admin/Rank.vue'),
        },
        {
          path: 'manage',
          name: 'Manage',
          component: () => import('@/views/admin/Manage.vue'),
        },
        {
          path: 'addInformation',
          name: 'AddInformation',
          component: () => import('@/views/admin/AddInformation.vue'),
        },
        {
          path: 'addBatch',
          name: 'AddBatch',
          component: () => import('@/views/admin/AddBatch.vue'),
        },
        {
          path: 'updateInformation',
          name: 'UpdateInformation',
          component: () => import('@/views/admin/UpdateInformation.vue'),
        },
        {
          path: 'deleteInformation',
          name: 'DeleteInformation',
          component: () => import('@/views/admin/DeleteInformation.vue'),
        },
        {
          path: 'changeScore',
          name: 'ChangeScore',
          component: () => import('@/views/admin/ChangeScore.vue'),
        },
        {
          path: 'searchInformation',
          name: 'SearchInformation',
          component: () => import('@/views/admin/SearchInformation.vue'),
        },
        {
          path: 'changePassword',
          name: 'ChangePassword',
          component: () => import('@/views/admin/ChangePassword.vue'),
        },
        {
          path: 'circle',
          name: 'Circle',
          component: () => import('@/views/admin/Circle.vue'),
        },
      ],
    },
  ],
  scrollBehavior() {
    return { x: 0, y: 0 };
  },
  // mode: 'history',
});

// 挂载导航守卫
router.beforeEach((to, from, next) => {
  // to 将要访问的路径
  // from 代表从哪个路径跳转过来
  // next 是一个函数，表示放行
  //    next() 放行  next('login') 强制跳转

  if(to.path === '/login') return next();
  if(to.path === '/register') return next();
  if(to.path === '/forgetPassword') return next();
  // if(to.path === '/active') return next();

  // 获取token 和用户角色
  const tokenStr = window.sessionStorage.getItem('token')
  const roleId = window.sessionStorage.getItem('roleId')
  if(!tokenStr) return next('login')

  if(to.path == '/personal/baseInformation') {
    if(roleId == 1) {
      // 管理员
      return next('admin')
    }
  }
  
  if(to.path == '/admin/baseInformation') {
    if(roleId == 2) {
      // 一般用户
      return next('personal')
    }
  }
  next()
});


export default router;

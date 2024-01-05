import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: 路由配置项
 *
 * hidden: true                     // 当设置 true 的时候该路由不会再侧边栏出现 如401，login等页面，或者如一些编辑页面/edit/1
 * alwaysShow: true                 // 当你一个路由下面的 children 声明的路由大于1个时，自动会变成嵌套的模式--如组件页面
 *                                  // 只有一个时，会将那个子路由当做根路由显示在侧边栏--如引导页面
 *                                  // 若你想不管路由下面的 children 声明的个数都显示你的根路由
 *                                  // 你可以设置 alwaysShow: true，这样它就会忽略之前定义的规则，一直显示根路由
 * redirect: noRedirect             // 当设置 noRedirect 的时候该路由在面包屑导航中不可被点击
 * name:'router-name'               // 设定路由的名字，一定要填写不然使用<keep-alive>时会出现各种问题
 * query: '{"id": 1, "name": "ry"}' // 访问路由的默认传递参数
 * roles: ['admin', 'common']       // 访问路由的角色权限
 * permissions: ['a:a:a', 'b:b:b']  // 访问路由的菜单权限
 * meta : {
    noCache: true                   // 如果设置为true，则不会被 <keep-alive> 缓存(默认 false)
    title: 'title'                  // 设置该路由在侧边栏和面包屑中展示的名字
    icon: 'svg-name'                // 设置该路由的图标，对应路径src/assets/icons/svg
    breadcrumb: false               // 如果设置为false，则不会在breadcrumb面包屑中显示
    activeMenu: '/system/user'      // 当路由设置了该属性，则会高亮相对应的侧边栏。
  }
 */

// 公共路由
export const constantRoutes = [{
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [{
      path: '/redirect/:path(.*)',
      component: () => import('@/views/redirect')
    }]
  },
  {
    path: '/login',
    component: () => import('@/views/login'),
    hidden: true
  },
  {
    path: '/bidding/:id',
    component: () => import('@/views/yz-bidding/bidding'),
    hidden: true
  },
  {
    path: '/insertNotice/:id',
    component: () => import('@/views/yz-bidding/tender_notice/insert'),
    hidden: true
  },
  {
    path: '/draw_experts/:id',
    component: () => import('@/views/yz-bidding/draw_experts/index'),
    hidden: true
  },
  {
    path: '/insert',
    component: () => import('@/views/yz-shopping/insert'),
    hidden: true,
    props: true
  },
  {
    path: '/desk_insert',
    component: () => import('@/views/yz-bidding/desk_insert'),
    hidden: true,
    props: true
  },
  // {
  //   path: '/vendor_login',
  //   component: () => import('@/views/vendor_login'),
  //   hidden: true
  // },
  {
    path: '/404',
    component: () => import('@/views/error/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views/error/401'),
    hidden: true
  },
  {
    path: '/supplierdetails',
    component: () => import('@/views/supplierdetails'),
    hidden: true,
    props: true
  },
  {
    path: '',
    component: Layout,
    redirect: 'index',
    children: [{
      path: 'index',
      component: () => import('@/views/index'),
      name: 'Index',
      meta: {
        title: '首页',
        icon: 'dashboard',
        affix: true
      }
    }]
  },
  {
    path: '/user',
    component: Layout,
    hidden: true,
    redirect: 'noredirect',
    children: [{
      path: 'profile',
      component: () => import('@/views/system/user/profile/index'),
      name: 'Profile',
      meta: {
        title: '个人中心',
        icon: 'user'
      }
    }]
  },
  {
    path: '/yz-public/vendor/enroll',
    component: Layout,
    hidden: true,
    name: 'enroll',
    children: [{
      path: 'enroll/:vid(\\d+)',
      component: () => import('@/views/yz-public/vendor/enroll'),
    }],
  },
  {
    path: '/yz-public/vendor/info',
    component: Layout,
    hidden: true,
    name: 'info',
    children: [{
      path: 'info/:vid(\\d+)',
      component: () => import('@/views/yz-public/vendor/info'),
    }],
  }, {
    path: '/yz-public/supply/insert',
    component: Layout,
    hidden: true,
    name: 'insert',
    children: [{
      path: 'insert/:sid(\\d+)',
      component: () => import('@/views/yz-public/supply/insert'),
    }],
  }, {
    path: '/yz-bidding/tender_projects',
    component: Layout,
    hidden: true,
    name: 'insertProjects',
    children: [{
      path: 'insert/:sid(\\d+)',
      component: () => import('@/views/yz-bidding/tender_projects/index'),
    }],
  },
  {
    path: '/yz-bidding/agreement',
    component: Layout,
    hidden: true,
    redirect: [''],
    children: [{
      path: 'index',
      component: () => import('@/views/yz-bidding/agreement/index'),
      name: 'index',
      meta: {
        title: '申请合同签订',
      }
    }]
  },
  {
    path: '/yz-shopping/pro_require',
    component: Layout,
    hidden: true,
    redirect: [''],
    children: [{
      path: 'index',
      component: () => import('@/views/yz-shopping/pro_require/index'),
      name: 'index',
      meta: {
        title: '采购需求',
      }
    }]
  },
  {
    path: '/yz-shopping/pro_require',
    component: Layout,
    hidden: true,
    redirect: [''],
    children: [{
      path: 'insert',
      component: () => import('@/views/yz-shopping/pro_require/insert'),
      name: 'insInfo',
      meta: {
        title: '采购需求表',
      }
    }]
  },
  {
    path: '/yz-shopping/pro_require',
    component: Layout,
    hidden: true,
    redirect: [''],
    children: [{
      path: 'info',
      component: () => import('@/views/yz-shopping/pro_require/info'),
      name: 'reInfo',
      meta: {
        title: '采购需求登记',
      }
    }]
  },
  {
    path: '/yz-shopping/buy_plan',
    component: Layout,
    hidden: true,
    redirect: [''],
    children: [{
      path: 'index',
      component: () => import('@/views/yz-shopping/buy_plan/index'),
      name: 'index',
      meta: {
        title: '采购计划',
      }
    }]
  },
  {
    path: '/yz-shopping/buy_plan',
    component: Layout,
    hidden: true,
    redirect: [''],
    children: [{
      path: 'insert',
      component: () => import('@/views/yz-shopping/buy_plan/insert'),
      name: 'insert',
      meta: {
        title: '采购计划申请',
      }
    }]
  },
  {
    path: '/yz-shopping/buy_plan',
    component: Layout,
    hidden: true,
    redirect: [''],
    children: [{
      path: 'info/:buy_plan_id',
      component: () => import('@/views/yz-shopping/buy_plan/info'),
      name: 'info',
      meta: {
        title: '采购计划登记',
      }
    }]
  }, {
    path: '/yz-shopping/buy_plan',
    component: Layout,
    hidden: true,
    redirect: [''],
    children: [{
      path: 'update',
      component: () => import('@/views/yz-shopping/buy_plan/update'),
      name: 'planUpdate',
      meta: {
        title: '采购计划修改',
      }
    }]
  },
  {
    path: '/yz-shopping/orders',
    component: Layout,
    hidden: true,
    redirect: [''],
    children: [{
      path: 'index',
      component: () => import('@/views/yz-shopping/orders/index'),
      name: 'index',
      meta: {
        title: '采购订单',
      }
    }]
  }, {
    path: '/yz-shopping/orders',
    component: Layout,
    hidden: true,
    redirect: [''],
    children: [{
      path: 'info',
      component: () => import('@/views/yz-shopping/orders/info'),
      name: 'info1',
      meta: {
        title: '采购订单确认',
      }
    }]
  }, {
    path: '/yz-shopping/orders',
    component: Layout,
    hidden: true,
    redirect: [''],
    children: [{
      path: 'information',
      component: () => import('@/views/yz-shopping/orders/information'),
      name: 'information',
      meta: {
        title: '采购订单登记',
      }
    }]
  },
  {
    path: '/yz-shopping/receipt',
    component: Layout,
    hidden: true,
    redirect: [''],
    children: [{
      path: 'index',
      component: () => import('@/views/yz-shopping/receipt/index'),
      name: 'index_receipt',
      meta: {
        title: '收货管理',
      }
    }]
  },
  {
    path: '/yz-bidding/contractdetails',
    component: Layout,
    hidden: true,
    redirect: [''],
    children: [{
      path: 'index',
      component: () => import('@/views/yz-bidding/contractdetails/index'),
      name: 'index_contractDetails',
      meta: {
        title: '合同管理',
      }
    }]
  },
  {
    path: '/yz-bidding/bid_desk',
    component: Layout,
    hidden: true,
    redirect: [''],
    children: [{
      path: 'index',
      component: () => import('@/views/yz-bidding/bid_desk/index'),
      name: 'index_desk',
      meta: {
        title: '投标台',
      }
    }]
  },
]
// 动态路由，基于用户权限动态去加载
export const dynamicRoutes = [{
    path: '/system/user-auth',
    component: Layout,
    hidden: true,
    permissions: ['system:user:edit'],
    children: [{
      path: 'role/:userId(\\d+)',
      component: () => import('@/views/system/user/authRole'),
      name: 'AuthRole',
      meta: {
        title: '分配角色',
        activeMenu: '/system/user'
      }
    }]
  },
  {
    path: '/system/role-auth',
    component: Layout,
    hidden: true,
    permissions: ['system:role:edit'],
    children: [{
      path: 'user/:roleId(\\d+)',
      component: () => import('@/views/system/role/authUser'),
      name: 'AuthUser',
      meta: {
        title: '分配用户',
        activeMenu: '/system/role'
      }
    }]
  },
  {
    path: '/system/dict-data',
    component: Layout,
    hidden: true,
    permissions: ['system:dict:list'],
    children: [{
      path: 'index/:dictId(\\d+)',
      component: () => import('@/views/system/dict/data'),
      name: 'Data',
      meta: {
        title: '字典数据',
        activeMenu: '/system/dict'
      }
    }]
  },
  {
    path: '/monitor/job-log',
    component: Layout,
    hidden: true,
    permissions: ['monitor:job:list'],
    children: [{
      path: 'index/:jobId(\\d+)',
      component: () => import('@/views/monitor/job/log'),
      name: 'JobLog',
      meta: {
        title: '调度日志',
        activeMenu: '/monitor/job'
      }
    }]
  },
  {
    path: '/tool/gen-edit',
    component: Layout,
    hidden: true,
    permissions: ['tool:gen:edit'],
    children: [{
      path: 'index/:tableId(\\d+)',
      component: () => import('@/views/tool/gen/editTable'),
      name: 'GenEdit',
      meta: {
        title: '修改生成配置',
        activeMenu: '/tool/gen'
      }
    }]
  }
]

// 防止连续点击多次路由报错
let routerPush = Router.prototype.push;
let routerReplace = Router.prototype.replace;
// push
Router.prototype.push = function push(location) {
  return routerPush.call(this, location).catch(err => err)
}
// replace
Router.prototype.replace = function push(location) {
  return routerReplace.call(this, location).catch(err => err)
}

export default new Router({
  mode: 'history', // 去掉url中的#
  scrollBehavior: () => ({
    y: 0
  }),
  routes: constantRoutes
})

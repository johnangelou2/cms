import Vue from 'vue'
import Router from 'vue-router'
import StudentLogin from '@/components/StudentLogin'
import AdminLogin from '@/components/AdminLogin'
import Students from '@/components/Students'
import Residences from '@/components/Residences'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/studentlogin',
      name: 'StudentLogin',
      component: StudentLogin
    },
    {
      path: '/adminlogin',
      name: 'AdminLogin',
      component: AdminLogin
    },
    {
      path: '/students',
      name: 'Students',
      component: Students
    },
  ]
})

import Vue from "vue";
import Router from "vue-router";
import StudentLogin from "@/components/StudentLogin";
import AdminLogin from "@/components/AdminLogin";
import Students from "@/components/Students";
import Residences from "@/components/Residences";
import Reports from "@/components/Reports";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/student-login",
      name: "StudentLogin",
      component: StudentLogin
    },
    {
      path: "/admin-login",
      name: "AdminLogin",
      component: AdminLogin
    },
    {
      path: "/students",
      name: "Students",
      component: Students
    },

    {
      path: "/reports",
      name: "Reports",
      component: Reports
    }
  ]
});

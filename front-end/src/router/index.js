import Vue from "vue";
import Router from "vue-router";
import LoginPage from "@/components/LoginPage";
import Students from "@/components/Students";
import Residences from "@/components/Residences";
import Reports from "@/components/reports";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      name: "LoginPage",
      component: LoginPage
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

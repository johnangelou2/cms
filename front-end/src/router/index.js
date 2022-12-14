import Vue from "vue";
import Router from "vue-router";
import LoginPage from "@/components/LoginPage";
import Students from "@/components/Students";
import Residences from "@/components/residences";
import Reports from "@/components/reports";
import Rooms from "@/components/rooms";
import FurtherInformation from "@/components/FurtherInformation";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      name: "LoginPage",
      component: LoginPage,
      meta: {
        hideNavbar: true
      }
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
    },
    {
      path: "/residences",
      name: "Residences",
      component: Residences
    },
    {
      path: "/FurtherInformation",
      name: "FurtherInformation",
      component: FurtherInformation
    },
    {
      path: "/rooms",
      name: "Rooms",
      component: Rooms
    }
  ]
});

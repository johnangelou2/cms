<template>
  <div id="app">
    <div>
        <b-navbar
          v-if="!$route.meta.hideNavbar"     
          type="dark"
          variant="primary"
        >
        <b-container>
          <b-navbar-brand href="#">
              <img src="https://iili.io/HffFylf.png" fluid class="d-inline-block align-top" height="35px" alt="Opal Residence Icon">
            Opal: Residential Management Services
          </b-navbar-brand>
          <b-navbar-nav>
            <b-nav-item to="/students" exact exact-active-class="exact-active"
                >Students</b-nav-item>
              <b-nav-item to="/reports" exact exact-active-class="exact-active"
                >Reports</b-nav-item>
              <b-nav-item to="/rooms" exact exact-active-class="exact-active"
                >Rooms</b-nav-item>
              <b-nav-item-dropdown text="Info" left>
                <b-dropdown-item to="/residences" exact exact-active-class="exact-active">Residence Info</b-dropdown-item>
                <b-dropdown-item to="/FurtherInformation" exact exact-active-class="exact-active">Further Info</b-dropdown-item>
              </b-nav-item-dropdown>
              <b-nav-item to="/" exact exact-active-class="exact-active"
                >Logout</b-nav-item
              >
          </b-navbar-nav>
          <b-navbar-toggle target="sidebar-menu"> </b-navbar-toggle>
          <b-sidebar
            id="sidebar-menu"
            title="Opal Residence"
            backdrop-variant="dark"
            backdrop
            shadow
          >
          </b-sidebar>
        </b-container>
      </b-navbar>
    </div>
    <br />
    <router-view />
  </div>
</template>

<script>
import LoginPage from "./components/LoginPage.vue";
import Residences from "./components/residences.vue";
import Students from "./components/Students.vue";
import Reports from "./components/reports.vue";
import FurtherInformation from "./components/FurtherInformation.vue";
import Rooms from "./components/rooms.vue";

export default {
  name: "App",

  components: {
    LoginPage,
    Residences,
    Reports,
    Students,
    FurtherInformation,
    Rooms
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #334250;

  margin-top: 0px;
  background: #ffffff;
  width: 100%;
  height: 100%;
  position: fixed;
  left: 0;
  top: 0;
}
</style>

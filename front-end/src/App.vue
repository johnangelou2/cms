<template>
  <div id="app">
    <b-container>
      <div>
        <b-navbar toggleable type="dark" variant="dark">
          <b-navbar-brand href="#"
            ><b-icon
              icon="book"
              variant="warning"
              style="margin-left: 20px;"
            ></b-icon>
            Residential Management Services
          </b-navbar-brand>

          <b-navbar-toggle target="sidebar-menu"> </b-navbar-toggle>
          <b-sidebar
            id="sidebar-menu"
            title="RMS"
            backdrop-variant="dark"
            backdrop
            shadow
          >
            <b-nav vertical align="center">
              <b-nav-item
                to="/"
                exact
                exact-active-class="exact-active"
                >Login Page</b-nav-item
              >
        
              <b-nav-item to="/students" exact exact-active-class="exact-active"
                >Students</b-nav-item
              >
              <b-nav-item
                to="/residences"
                exact
                exact-active-class="exact-active"
                >Residence Info</b-nav-item
              >
              <b-nav-item to="/reports" exact exact-active-class="exact-active"
                >Reports</b-nav-item
              >
          
              <b-nav-item disabled>Admin</b-nav-item>
            </b-nav>
          </b-sidebar>
        </b-navbar>
      </div>
      <br />
      <router-view />
    </b-container>
  </div>

  <!--
<ul>
        <li>
          <student-login></student-login>
        </li>
    </ul>

    <div id="app">
      <NavBar :name="$route.name"/>
      <main>
        <router-view/>
      </main>
    </div>
  -->
</template>

<script>
import LoginPage from "./components/LoginPage.vue";
import Residences from "./components/residences.vue";
import Students from "./components/Students.vue";
import Reports from "./components/reports.vue";

export default {
  name: "App",

  components: {
    LoginPage,
    Residences,
    Reports,
    Students
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 20px;
}
</style>

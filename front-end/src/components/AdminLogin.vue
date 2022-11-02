<template>
  <div id="nav">
    <b-navbar toggleable type="dark" variant="dark">
      <b-navbar-brand href="#">RMS</b-navbar-brand>
      <b-navbar-nav class="ml-auto">
        <div>
          <b-link to="/studentlogin">Student Login</b-link>
        </div>
      </b-navbar-nav>
    </b-navbar>
  </div>
</template>

<script>
export default {
  name: "AdminLogin"
};
</script>

<style>
#app {
  font-family: "Gill Sans", "Gill Sans MT", Calibri, "Trebuchet MS", sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 0px;
}
</style>

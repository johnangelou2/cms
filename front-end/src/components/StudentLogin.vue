<template>
    <b-navbar toggleable type="dark" variant="dark">
    <b-navbar-brand href="#">RMS</b-navbar-brand>

    <b-navbar-nav class="ml-auto">
      <div>
        <b-link to="/adminlogin">Admin Login</b-link>
      </div>
    </b-navbar-nav>
    <b-button href="/front-end/Old_Files/StudentDatabase/studentDatabase.html">Student Database</b-button>

  </b-navbar>

    
</template>

<script>
export default {
  name: 'StudentLogin'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 0px;
  
}
</style>
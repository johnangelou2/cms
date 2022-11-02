<template>
    <div id="app">
      <NavBar :name="$route.name"/>
      <main>
        <router-view/>
      </main>
    </div>
    
    </template>

<script>
import StudentLogin from './components/StudentLogin.vue'
import Professors from './components/Professors.vue'
import AdminLogin from './components/AdminLogin.vue'
import Students from './components/Students.vue'

export default {
  name: 'App',

  components: {
    StudentLogin
  }

}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 20px;
  
}
</style>

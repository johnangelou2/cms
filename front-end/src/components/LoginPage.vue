<template>
<div class="login-container">

<b-container>
      <form @submit.prevent="login">
        <h2 class="mb-3">Login to Opal Residences</h2>
        <div class="input">
          <label for="id">Login ID</label>
          <input
            class="form-control"
            type="text"
            name="id"
            placeholder="Login ID"
            required
          />
        </div>
        <div class="input">
          <label for="password">Password</label>
          <input
            class="form-control"
            type="password"
            name="password"
            placeholder="Password"
          />
        </div>
        <button type="submit" class="mt-4 btn-pers" id="login_button">
          Login
        </button>
        <div
          class="alert alert-danger fade show mt-5 d-none"
          role="alert"
          id="alert_1"
        >
          Lorem ipsum dolor sit amet consectetur, adipisicing elit.
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="alert"
            aria-label="Close"
          ></button>
        </div>
      </form>
    </b-container>

    <img src="https://iili.io/HffFylf.png" alt="Opal Residence Icon">
    </div>
 
</template>

<script>

import axios from 'axios';
  export default {
    name: 'LoginPage',
    data() {
      return {
        id: "",
        password: "",
      };
    },
    methods: {
      login(submitEvent) {
        this.id = submitEvent.target.elements.id.value;
        this.password = submitEvent.target.elements.password.value;

        axios.all([
            axios.get('http://localhost:8085/students/'+submitEvent.target.elements.id.value)
            .catch(
                function(e){console.log('Error', e);}), 
            axios.get('http://localhost:8085/admins/'+submitEvent.target.elements.id.value)
            .catch(
                function(e){console.log('Error', e);})
            ])
            .then(axios.spread((data1, data2) => {
            console.log('data1', data1, 'data2', data2)
            if (typeof data1 !== 'undefined'){
                this.$emit("authenticated", true);
                this.$emit("authorized", false);
                this.$emit('User',data1.data);
                this.$router.push("/");

                window.alert("Logged in as Student");
                window.location.href = 'http://localhost:3000/#/residences';


            }
            else if(typeof data2 !== 'undefined'){
                this.$emit("authenticated", true);
                this.$emit("authorized", true);
                this.$emit('User',data2.data);
                this.$router.push("/");

                window.alert("Logged in as Administrator");
                window.location.href = 'http://localhost:3000/#/residences';

            }
            else{
                let alert_1 = document.querySelector("#alert_1");
                alert_1.classList.remove("d-none");
                alert_1.innerHTML = 'User Does Not Exist!';
            }
        }));

      },
    },
  };
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 0px;
 
}
img {
  display: block;
  margin-left: auto;
  margin-right: auto;}
</style>
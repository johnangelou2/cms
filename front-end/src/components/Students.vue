<template>
  <div class="hello">
    <div class="search-container">
      <b-input-group>
        <b-form-input type="text" placeholder="Search Students' Name" v-model="studentnum"/>
          <template #append>
            <b-button class="search-button" @click="searchbyId(studentnum)">
              <b-icon-search></b-icon-search>
            </b-button>
          </template>
      </b-input-group>
    </div>  
    <b-container>
    <h2>Students Information</h2>
    <b-table striped hover responsive :items="students" :fields="fields">
      <template #cell(actions)="row">
        <b-button
          size="sm"
          v-b-modal.edit-modal
          @click="edit(row.item, row.index, $event.target)"
        >
          Edit
        </b-button>
      </template>
    </b-table>
    <b-modal
      id="edit-modal"
      title="Edit Student"
      @hide="resetEditModal"
      hide-footer
    >
      <b-form>
        <label class="sr-only" for="input-id">Student ID</label>
        <b-form-input
          id="input-id"
          v-model="form.id"
          placeholder="Student ID"
          readonly
        ></b-form-input>

        <label class="sr-only" for="input-first-name">First Name</label>
        <b-form-input
          id="input-first-name"
          v-model="form.firstName"
          placeholder="Jane"
          required
          
        ></b-form-input>

        <label class="sr-only" for="input-last-name">Last Name</label>
        <b-form-input
          id="input-last-name"
          v-model="form.lastName"
          placeholder="Doe"
          required
        ></b-form-input>

        <label class="sr-only" for="input-date-of-birth">Date of Birth</label>
        <b-form-input
          id="input-date-of-birth"
          v-model="form.dateOfBirth"
          placeholder="Date of Birth"
          required
        ></b-form-input>

        <label class="sr-only" for="input-phone-num">Phone Number</label>
        <b-form-input
          id="input-phone-num"
          v-model="form.last_name"
          placeholder=""
          required
        ></b-form-input>

        <label class="sr-only" for="input-email">Email</label>
        <b-input-group prepend="@">
          <b-form-input
            id="input-email"
            v-model="form.email"
            placeholder="Email"
            required
          ></b-form-input>
        </b-input-group>

        <br />
        <b-button type="button" @click="onSave()" variant="primary"
          >Save</b-button
        >
        <b-button type="reset" variant="warning">Reset</b-button>
        <b-button type="button" variant="danger">Remove Student</b-button>
      </b-form>
    </b-modal>
  </b-container>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Students",
  data() {
    return {
      students: null,
      studentnum: "",
      fields: [
        { key: "id", label: "Student ID", sortable: true },
        { key: "lastName", label: "Last Name", sortable: true},
        { key: "firstName", label: "First Name", sortable: true},
        { key: "dateOfBirth", label: "Date of Birth", sortable: false },
        { key: "phoneNum", label: "Phone Number", sortable: true },
        { key: "email", label: "Email", sortable: true, sortable: true },
        { key: "actions", label: "Actions", sortable: false }
      ],
      form: {
        firstName: "",
        lastName: "",
        email: "",
        dateOfBirth: "",
        phoneNum: "",
        id: ""
      }
    };
  },
  mounted() {
    this.init();
  },
  methods: {
    init() {
      axios
        .get("http://localhost:8085/students")
        .then(response => (this.students = response.data));
    },
    searchbyId(studentnum) {
      if (studentnum) {
        axios
        .get("http://localhost:8085/students/" + studentnum)
        .then(response => (this.students= response.data))
        .catch(function (error) {
          if (error.response) {
            console.log(error.response.data);
          }
        })
      }
    },
    edit(item, index, button) {
      this.form.email = item.email;
      this.form.dateOfBirth = item.dateOfBirth;
      this.form.phoneNum = item.phoneNum;
    },
    resetEditModal() {
      this.form.email = "";
      this.form.dateOfBirth = "";
      this.form.phoneNum = "";
    },
    onSave(event) {
      var numId;
      numId = parseInt(this.form.id);
      axios
        .put("http://localhost:8085/students/" + numId, {
          id: numId,
          dateOfBirth: this.form.dateOfBirth,
          lastName: this.form.phoneNum,
          email: this.form.email
        })
        .then(() => this.init())
        .catch(function(error) {
          console.log(error);
        });
        window.alert("Changes Saved!");
        this.init();
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.search-container {
  padding:2%
}
</style>

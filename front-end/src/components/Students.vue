<template>
  <div class="hello">
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
          placeholder="xxx-xxx-xxxx"
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
        <b-button type="button" @click="onSave" variant="primary"
          >Save</b-button
        >
        <b-button type="reset" variant="warning">Reset</b-button>
        <b-button type="button" variant="danger">Remove Student</b-button>
      </b-form>
    </b-modal>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Students",
  data() {
    return {
      students: null,
      fields: [
        { key: "id", label: "Student ID", sortable: true },
        { key: "phoneNum", label: "Phone Number", sortable: true },
        { key: "dateOfBirth", label: "Date of Birth", sortable: true },
        { key: "email", label: "Email", sortable: true, sortable: true },
        { key: "actions", label: "Actions" }
      ],
      form: {
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
    edit(item, index, button) {
      this.form.id = item.id;
      this.form.email = item.email;
      this.form.dateOfBirth = item.dateOfBirth;
      this.form.phoneNum = item.phoneNum;
    },
    resetEditModal() {
      this.form.id = "";
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
</style>

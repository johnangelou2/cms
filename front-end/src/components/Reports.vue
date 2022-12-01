<template>
  <div class="hello">
  <b-container>
    <h2>Reports Information</h2>
    <b-table striped hover responsive :items="reports" :fields="fields">
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
    <div class = "add-button">
      <button type="submit" v-b-modal.add-modal>New Report</button>
    </div>
    <b-modal
      id="edit-modal"
      title="Edit Report"
      @hide="resetEditModal"
      hide-footer
    >
      <b-form>
        <label class="sr-only" for="input-id">Report ID</label>
        <b-form-input
          id="input-id"
          v-model="form.id"
          placeholder="Report ID"
          required
        ></b-form-input>

        <label class="sr-only" for="input-date">Report Date</label>
        <b-form-input
          id="input-date-of-birth"
          v-model="form.dateOfBirth"
          placeholder="Date of Birth"
          required
        ></b-form-input>

        <label class="sr-only" for="input-time">Report Time</label>
        <b-form-input
          id="input-time"
          v-model="form.time"
          placeholder="Time of Report"
          required
        ></b-form-input>

        <label class="sr-only" for="input-description">Description</label>
        <b-form-input
          id="input-description"
          v-model="form.description"
          placeholder="Lorem Ipsum"
          required
        ></b-form-input>

        <label class="sr-only" for="input-type">Report Type</label>
        <b-form-input
          id="input-type"
          v-model="form.type"
          placeholder="Type"
          required
        ></b-form-input>

        <label class="sr-only" for="input-status">Report Status</label>
        <b-form-input
          id="input-status"
          v-model="form.status"
          placeholder="Status"
          required
        ></b-form-input>

        <label class="sr-only" for="input-author">Author</label>
        <b-form-input
          id="input-author"
          v-model="form.author"
          placeholder="Author"
          required
        ></b-form-input>
        <br />
        <b-button type="button" @click="onSave" variant="primary"
          >Save</b-button
        >
        <b-button type="reset" variant="warning">Reset</b-button>
        <b-button type="button" @click="removeReport" variant="danger">Remove Report</b-button>
      </b-form>
    </b-modal>
    <b-modal
      id="add-modal"
      title="Add Report"
      @hide="resetEditModal"
      hide-footer
    >
      <b-form>
        <label class="sr-only" for="input-id">Report ID</label>
        <b-form-input
          id="input-id"
          v-model="form.id"
          placeholder="Report ID"
          required
        ></b-form-input>

        <label class="sr-only" for="input-date">Report Date</label>
        <b-form-input
          id="input-date-of-birth"
          v-model="form.dateOfBirth"
          placeholder="Date of Report"
          required
        ></b-form-input>

        <label class="sr-only" for="input-time">Report Time</label>
        <b-form-input
          id="input-time"
          v-model="form.time"
          placeholder="Time of Report"
          required
        ></b-form-input>

        <label class="sr-only" for="input-description">Description</label>
        <b-form-input
          id="input-description"
          v-model="form.description"
          placeholder="Description"
          required
        ></b-form-input>

        <label class="sr-only" for="input-type">Report Type</label>
        <b-form-input
          id="input-type"
          v-model="form.type"
          placeholder="Type"
          required
        ></b-form-input>

        <label class="sr-only" for="input-status">Report Status</label>
        <b-form-input
          id="input-status"
          v-model="form.status"
          placeholder="Status"
          required
        ></b-form-input>

        <label class="sr-only" for="input-author">Author</label>
        <b-form-input
          id="input-author"
          v-model="form.author"
          placeholder="Author"
          required
        ></b-form-input>
        <br />
        <b-button type="button" @click="addReport" variant="primary"
          >Add</b-button>
      </b-form>
    </b-modal>
  </b-container>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Reports",
  data() {
    return {
      reports: null,
      fields: [
        { key: "reportId", label: "Report ID", sortable: true },
        { key: "date", label: "Report Date", sortable: true },
        { key: "time", label: "Report Time", sortable: true },
        { key: "description", label: "Description", sortable: true },
        { key: "type", label: "Report Type", sortable: true },
        { key: "status", label: "Report Status", sortable: true },
        {
          key: "author.id",
          label: "Report Admin",
          sortable: true
        },
        { key: "actions", label: "Actions" }
      ],
      form: {
        id:"",
        date:"",
        time:"",
        description:"",
        type: "",
        status: ""
      }
    };
  },
  mounted() {
    this.init();
  },
  methods: {
    init() {
      axios
        .get("http://localhost:8085/reports")
        .then(response => (this.reports = response.data));
    },
    addReport() {
      axios
      .post("http://localhost:8085/reports/", {
        "reportId": this.form.id,
        "date": this.form.date,
        "time": this.form.time,
        "description": this.form.description,
        "type": this.form.type,
        "status": this.form.status,
      })
      .then(() => {this.init();this.$refs['add-modal'].hide()})
      .catch(function (error) {
        console.log(error);
      });
    },
    removeReport() {
      axios 
      .delete("http://localhost:8085/reports/" + this.form.id)
      .then(() => {this.init();this.$refs['edit-modal'].hide()})
      .catch(function (error) {
        console.log(error);
      });
    },
    edit(item, index, button) {
      this.form.id = item.id;
      this.form.date = item.date;
      this.form.time = item.time;
      this.form.description = item.description;
      this.form.type = item.type;
      this.form.status = item.status;
      this.form.admin = item.admin;
    },
    resetEditModal() {
      this.form.id = item.id;
      this.form.date = item.date;
      this.form.time = item.time;
      this.form.description = item.description;
      this.form.type = item.type;
      this.form.status = item.status;
      this.form.admin = item.admin;
    },
    onSave() {
      var numId;
      numId = parseInt(this.form.id);
      axios
        .put("http://localhost:8085/reports/" + numId, {
          id: numId,
          date: this.form.date,
          time: this.form.time,
          description: this.form.description,
          type: this.form.type,
          status: this.form.status,
          admin: this.form.admin
        })
        .then(() => {this.init();this.$refs['edit-modal'].hide()})
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

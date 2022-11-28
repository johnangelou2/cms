<template>
  <div class="hello">
    <h2>Rooms Information</h2>
    <b-table striped hover responsive :items="rooms" :fields="fields">
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
      title="Edit Rooms"
      @hide="resetEditModal"
      hide-footer
    >
      <b-form>
        <label class="sr-only" for="input-id">Room ID</label>
        <b-form-input
          id="input-id"
          v-model="form.id"
          placeholder="Room ID"
          readonly
        ></b-form-input>

        <label class="sr-only" for="input-date-of-birth"></label>
        <b-form-input
          id="input-date-of-birth"
          v-model="form.dateOfBirth"
          placeholder="Room Number"
          required
        ></b-form-input>

        <label class="sr-only" for="input-phone-num">Room Type</label>
        <b-form-input
          id="input-phone-num"
          v-model="form.last_name"
          placeholder="xxx-xxx-xxxx"
          required
        ></b-form-input>

        <label class="sr-only" for="input-email">Capacity</label>
        <b-input-group prepend="@">
          <b-form-input
            id="input-email"
            v-model="form.email"
            placeholder="Capacity"
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
  name: "rooms",
  data() {
    return {
      rooms: null,
      fields: [
        { key: "roomN", label: "Residence ID", sortable: true },
        { key: "roomType", label: "Room Type", sortable: true },
        { key: "capacity", label: "Capacity", sortable: true, sortable: true },
        { key: "actions", label: "Actions" }
      ],
      form: {
        roomN: "",
        roomType: "",
        capacity: ""
      }
    };
  },
  mounted() {
    this.init();
  },
  methods: {
    init() {
      axios
        .get("http://localhost:8085/rooms")
        .then(response => (this.rooms = response.data));
    },
    edit(item, index, button) {
      this.form.resId = item.resId;
      this.form.roomNumber = item.roomNumber;
      this.form.roomType = item.roomType;
      this.form.capacity = item.capacity;
    },
    resetEditModal() {
      this.form.resId = "";
      this.form.roomNumber = "";
      this.form.roomType = "";
      this.form.capacity = "";
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

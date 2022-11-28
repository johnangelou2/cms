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
        <label class="sr-only" for="input-res-id">Res ID</label>
        <b-form-input
          id="res-id"
          v-model="form.resId"
          placeholder="Residence ID"
          readonly
        ></b-form-input>

        <label class="sr-only" for="input-room-id">Room ID</label>
        <b-form-input
          id="room-number"
          v-model="form.roomNumber"
          placeholder="Room ID"
          readonly
        ></b-form-input>

        <label class="sr-only" for="input-room-type">Room Type</label>
        <b-form-input
          id="room-type"
          v-model="roomType"
          placeholder="Room Type"
          required
        ></b-form-input>

        <label class="sr-only" for="input-capacity">Capacity</label>
        <b-form-input
            id="input-capacity"
            v-model="form.capacity"
            placeholder="Capacity"
            required
        ></b-form-input>

        <br />
        <b-button type="button" @click="onSave" variant="primary"
          >Save</b-button
        >
        <b-button type="reset" variant="warning">Reset</b-button>
        <b-button type="button" variant="danger">Remove Room</b-button>
      </b-form>
    </b-modal>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Rooms",
  data() {
    return {
      rooms: null,
      fields: [
        { key: "resId", label: "Residence ID", sortable: true },
        { key: "roomNumber", label: "Room ID", sortable: true },
        { key: "roomType", label: "Room Type", sortable: true },
        { key: "capacity", label: "Capacity", sortable: true, sortable: true },
        { key: "actions", label: "Actions" }
      ],
      form: {
        resId: "",
        roomNumber: "",
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
        .get("http://localhost:8085/rooms/")
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
      var resId;
      var roomNumber
      resId = parseInt(this.form.resId);
      roomNumber = parseInt(this.form.roomNumber);
      axios
        .put("http://localhost:8085/students/" + roomNumber + "/" + resId, {
          resId: resId,
          roomNumber: roomNumber,
          roomType: this.form.roomType,
          capacity: this.form.capacity
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
</style>

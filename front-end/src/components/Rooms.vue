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
          v-model="form.residenceId"
          placeholder="Residence ID"
          readonly
        ></b-form-input>

        <label class="sr-only" for="input-room-id">Room ID</label>
        <b-form-input
          id="room-number"
          v-model="form.roomN"
          placeholder="Room ID"
          readonly
        ></b-form-input>

        <label class="sr-only" for="input-room-type">Room Type</label>
        <b-form-input
          id="room-type"
          v-model="form.roomType"
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
import _ from "lodash";

export default {
  name: "Rooms",
  data() {
    return {
      rooms: null,
      fields: [
        { key: "residenceId.name", label: "Residence ID", sortable: true },
        { key: "roomKey.roomN", label: "Room ID", sortable: true },
        { key: "roomType", label: "Room Type", sortable: true },
        { key: "capacity", label: "Capacity", sortable: true, sortable: true },
        { key: "actions", label: "Actions" }
      ],
      form: {
        residenceId: "",
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
        .get("http://localhost:8085/rooms/")
        .then(response => {this.rooms = _.flatMapDeep(response.data);console.log(this.rooms)});
        
    },
    edit(item, index, button) {
      this.form.residenceId = item.residenceId;
      this.form.roomN = item.roomN;
      this.form.roomType = item.roomType;
      this.form.capacity = item.capacity;
    },
    resetEditModal() {
      this.form.residenceId = "";
      this.form.roomN = "";
      this.form.roomType = "";
      this.form.capacity = "";
    },
    onSave(event) {
      var residenceId;
      var roomN;
      residenceId = parseFloat(this.form.residenceId);
      roomN = parseInt(this.form.roomN);
      axios
        .put("http://localhost:8085/rooms/" + roomN + "/" + residenceId, {
          residenceId: residenceId,
          roomN: roomN,
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

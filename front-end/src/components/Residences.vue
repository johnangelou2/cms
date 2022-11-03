<template>
  <div class="hello">
    <h2> Residence Information </h2>
    <b-table striped hover stacked :items="residences" :fields="fields">
      <template #cell(actions)="row">
        <b-button size="sm" v-b-modal.edit-modal @click="edit(row.item, row.index, $event.target)">
          Edit
        </b-button>
      </template>
    </b-table>
    <b-modal id="edit-modal" title="Edit Residence" @hide="resetEditModal" hide-footer>
      <b-form >

        <label class="sr-only" for="input-id">Residence ID</label>
        <b-form-input
          id='input-id'
          v-model="form.id"
          placeholder="Residence ID"
          readonly
        ></b-form-input>

        <label class="sr-only" for="input-address">Address</label>
        <b-form-input
          id='input-Address'
          v-model="form.Address"
          placeholder="Address"
          required
        ></b-form-input>

        <label class="sr-only" for="input-name">Name</label>
        <b-form-input
          id="input-name"
          v-model="form.name"
          placeholder="Name"
          required
        ></b-form-input>
        
        <br />
        <b-button type="submit" variant="primary">Submit</b-button>
        <b-button type="reset" variant="warning">Reset</b-button>
        <b-button type="button" variant="danger">Remove Professor</b-button>
      </b-form>

    </b-modal>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Residences',
  data () {
    return {
      professors: null,
      fields: [
      {key: 'id', label: 'Professor ID', sortable: true},
      {key: 'address', label: 'Address', sortable: true},
      {key: 'name', label: 'Name', sortable: true}],
      form: {
          id: '',
          address: '',
          name: '',
        },
    }
  },
  mounted () {
    axios
      .get('http://localhost:8085/residences')
      .then(response => (this.residences = response.data))
  },
  methods: {
    edit(item, index, button) {
      this.form.id = item.id
      this.form.address = item.address
      this.form.name = item.name
    },
    resetEditModal() {
      this.form.id=''
      this.form.address=''
      this.form.name=''
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
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

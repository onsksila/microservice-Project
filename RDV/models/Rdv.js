const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const RdvSchema = new Schema({
  nameemploye: {
    type: String,
    required: true,
  },
  namefournisseur: {
    type: String,
    required: true,
  },
  location: {
    type: String,
    required: true,
  },
});

module.exports = Item = mongoose.model("rdv", RdvSchema);

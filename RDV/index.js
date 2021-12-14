const { response } = require("express");
const express = require("express");
const mongoose = require("mongoose");
const bodyParser = require("body-parser");

const app = express();

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

// Connect to MongoDB
mongoose
  .connect("mongodb://mongo:27017/docker-node-mongo", { useNewUrlParser: true })
  .then(() => console.log("MongoDB Connected"))
  .catch((err) => console.log(err));

const Rdv = require("./models/Rdv");

app.get("/rdv", (req, res) => {
  Rdv.find({}, (err, result) => {
    if (err) {
      res.send(err);
    }
    res.send(result);
  });
});

app.post("/Rdv/add", (req, res) => {
  const newRdv = new Rdv({
    nameemploye: req.body.nameemploye,
    namefournisseur: req.body.namefournisseur,
    location: req.body.location,
  });
  newRdv
    .save()
    .then((response) => {
      res.json({
        message: "Rdv added !",
      });
    })
    .catch((error) => {
      res.json({
        message: "Rdv not added !!!",
      });
    });
});
app.delete("/delete/:id", (req, res) => {
  const id = req.params.id;

  Rdv.findByIdAndRemove(id).exec();
  res.send("Rdv deleted");
});


app.put("/rdv/update/:id", (req, res) => {
  const id = req.params.id;

  try {
    Rdv.findById(id).then((Rdv) => {
      Rdv.nameemploye = req.body.nameemploye;
      Rdv.namefournisseur = req.body.namefournisseur;
      Rdv.location = req.body.location;

      Rdv.save().then(() => res.json("the rdv updated"));
    });
  } catch (error) {
    console.log(error);
  }
});

const port = 8555;
const eurekaHelper = require('./eureka-helper');
eurekaHelper.registerWithEureka('nodejs-mongo-docker', port);


app.listen(port, () => console.log("Server running..."));

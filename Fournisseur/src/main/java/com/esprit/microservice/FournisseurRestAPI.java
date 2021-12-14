package com.esprit.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.microservice.Fournisseur;
import com.esprit.microservice.FournisseurService;

@RestController
@RequestMapping(value = "/api/fournisseur")
public class FournisseurRestAPI {
	
	private String title = "Hello, I'm the fournisseur Microservice";
	@Autowired
	private FournisseurService fournisseurService;
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Fournisseur> createFournisseur(@RequestBody Fournisseur rec) {
		return new ResponseEntity<>(fournisseurService.addFournisseur(rec), HttpStatus.OK);
	}
	@PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable(value = "id") int id, @RequestBody Fournisseur rec){
		return new ResponseEntity<>(fournisseurService.updateFournisseur(id, rec), HttpStatus.OK);
	}
	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteFournisseur(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(fournisseurService.deleteFournisseur(id), HttpStatus.OK);
	}

}

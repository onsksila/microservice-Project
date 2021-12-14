package tn.esprit.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.esprit.produit.Produit;
import tn.esprit.produit.ProduitRepository;
import tn.esprit.produit.ProduitService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/produits/")
public class ProduitRestApi {
    @Autowired
    private ProduitService produitService;

    @Autowired
    private ProduitRepository produitRepository;

    private String title = "Hello, I'm the product Microservice";
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}
	
    @GetMapping
    public ResponseEntity<List<Produit>> getAllProduit(){
        List<Produit> produits = produitRepository.findAll();

        if(produits.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(produits,HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Produit> createProduit(@RequestBody Produit produit){
        return new ResponseEntity<>(produitService.addProduit(produit), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Produit> updateProduit(@PathVariable(value = "id") int id, @RequestBody Produit produit){
        return new ResponseEntity<>(produitService.updateProduit(produit, id), HttpStatus.OK);

    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteProduit(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(produitService.deleteProduit(id), HttpStatus.OK);

    }

}

package tn.esprit.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.produit.Produit;
import tn.esprit.produit.ProduitRepository;

import javax.ws.rs.core.Response;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public Produit addProduit(Produit p){

        return produitRepository.save(p);
    }

    public Produit updateProduit(Produit newP, int id){
        if(produitRepository.findById(id).isPresent()){
            Produit produit = produitRepository.findById(id).get();
            produit.setNom(newP.getNom());
            produit.setCategorie(newP.getCategorie());
            return produitRepository.save(produit);
        }
        else return null;
    }

    public String deleteProduit(int id){
        if(produitRepository.findById(id).isPresent()){
            produitRepository.deleteById(id);
            return "Produit supprimé avec succés";
        }
        else return "Produit non supprimé, il n'existe pas";
    }
}

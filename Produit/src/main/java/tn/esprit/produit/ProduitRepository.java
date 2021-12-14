package tn.esprit.produit;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.produit.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {

    @Query("select p from Produit p where p.nom like :nom")
    public Page<Produit> produitByNom(@Param("nom") String n, Pageable pageable);

}

package com.esprit.microservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.microservice.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {

}

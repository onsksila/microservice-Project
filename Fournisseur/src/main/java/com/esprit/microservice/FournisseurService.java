package com.esprit.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservice.Fournisseur;
import com.esprit.microservice.FournisseurRepository;

@Service
public class FournisseurService {
	
	
	@Autowired
	private FournisseurRepository fournisseurRepository;

	public Fournisseur addFournisseur(Fournisseur f) {
		return fournisseurRepository.save(f);
	}
	public Fournisseur updateFournisseur(int id, Fournisseur newFour) {
		if (fournisseurRepository.findById(id).isPresent()) {
			Fournisseur existingFour = fournisseurRepository.findById(id).get();
			existingFour.setNom(newFour.getNom());
			existingFour.setPrenom(newFour.getPrenom());
			existingFour.setAdresse(newFour.getAdresse());
			existingFour.setAge(newFour.getAge());

			return fournisseurRepository.save(existingFour);
		} else
			return null;
	}
	public String deleteFournisseur(int id) {
		if (fournisseurRepository.findById(id).isPresent()) {
			fournisseurRepository.deleteById(id);
			return "fournisseur supprimé";
		} else
			return "ERROR!! fournisseur non supprimé";
	}

}

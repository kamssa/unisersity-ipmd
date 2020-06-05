package ci.ipmd.ecole.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ci.ipmd.ecole.entites.Filiere;
import ci.ipmd.ecole.entites.Formation;
import ci.ipmd.ecole.metier.IFiliereMetier;
import ci.ipmd.ecole.metier.IFormationMetier;
import ci.ipmd.ecole.modele.Reponse;
import ci.ipmd.ecole.utilitaire.Static;
@RestController
public class FiliereController {
	@Autowired
	private IFiliereMetier filiereMetier;
	
	// Obtenir une filiere par son identifiant
	@GetMapping("/filiere/{id}")
	public Reponse<Filiere> getFiliereById(@PathVariable String id)   {
		Reponse<Filiere> reponse;
		try {
			Filiere filiere = filiereMetier.findById(id);
			List<String> messages = new ArrayList<>();
			messages.add(String.format("%s retrouvée", filiere.getLibelle()));
			reponse = new Reponse<Filiere>(0, null, filiere);
		} catch (Exception e) {
			reponse = new Reponse<>(1, Static.getErreursForException(e), null);
		}
		return reponse;

	}
	// creer une filiere dans la base mongo
	@PostMapping("/filiere")
	public Reponse<Filiere> create(@RequestBody Filiere filiere) {
		Reponse<Filiere> reponse = null;

		try {
			Filiere f = filiereMetier.creer(filiere);
			List<String> messages = new ArrayList<>();
			messages.add(String.format("%s a été ajouté avec succès", f.getLibelle()));
			reponse = new Reponse<Filiere>(0, messages, f);
		} catch (Exception e) {

			reponse = new Reponse<Filiere>(1, Static.getErreursForException(e), null);
		}

		return reponse;

	}
	// faire la mise à jour d'une filiere existante
	@PutMapping("/filiere")
	public Reponse<Filiere> modfier(@RequestBody Filiere modif) {
		Reponse<Filiere> reponse = null;

		// on recupere la filiere à modifier
		Filiere formation = filiereMetier.findById(modif.getId());
		if (formation != null) {
			try {
				Filiere f2 = filiereMetier.modifier(modif);
				List<String> messages = new ArrayList<>();
				messages.add(String.format("%s a modifier avec succes", f2.getId()));
				reponse = new Reponse<Filiere>(0, messages, f2);
			} catch (Exception e) {

				reponse = new Reponse<Filiere>(1, Static.getErreursForException(e), null);
			}

		} else {
			List<String> messages = new ArrayList<>();
			messages.add(String.format("La filiere n'existe pas"));
			reponse = new Reponse<Filiere>(0, messages, null);
		}

		return reponse;

	}
 ////////////////////////////////////////////////////////////
	// recuperer toute les filieres de la base
	///////////////////////////////////////////////////////
	@GetMapping("/filiere")
    public Reponse<List<Filiere>> findAll()  {
		Reponse<List<Filiere>> reponse;
		try {
			List<Filiere> formations = filiereMetier.findAll();
			if (!formations.isEmpty()) {
				reponse = new Reponse<List<Filiere>>(0, null, formations);
			} else {
				List<String> messages = new ArrayList<>();
				messages.add("Pas de filiere trouvée");
				reponse = new Reponse<List<Filiere>>(1, messages, new ArrayList<>());
			}
		} catch (Exception e) {
			reponse = new Reponse<List<Filiere>>(1, Static.getErreursForException(e), new ArrayList<>());
		}
		return reponse;

	}
	
}

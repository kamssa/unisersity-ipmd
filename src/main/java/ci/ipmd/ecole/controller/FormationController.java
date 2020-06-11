package ci.ipmd.ecole.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import ci.ipmd.ecole.entites.Formation;
import ci.ipmd.ecole.metier.IFormationMetier;
import ci.ipmd.ecole.modele.Reponse;
import ci.ipmd.ecole.utilitaire.Static;

@RestController
@CrossOrigin
public class FormationController {
	@Autowired
	private IFormationMetier formationMetier;
	
	// Obtenir une formation par son identifiant
	@GetMapping("/formation/{id}")
	public Reponse<Formation> getFormationById(@PathVariable String id)   {
		Reponse<Formation> reponse;
		try {
			Formation formation = formationMetier.findById(id);
			List<String> messages = new ArrayList<>();
			messages.add(String.format("%s retrouvé", formation.getType()));
			reponse = new Reponse<Formation>(0, null, formation);
		} catch (Exception e) {
			reponse = new Reponse<>(1, Static.getErreursForException(e), null);
		}
		return reponse;

	}
	// creer une formation dans la base mongo
	@PostMapping("/formation")
	public Reponse<Formation> create(@RequestBody Formation docs) {
		Reponse<Formation> reponse = null;

		try {
			Formation d = formationMetier.creer(docs);
			List<String> messages = new ArrayList<>();
			messages.add(String.format("%s a été ajouté avec succès", d.getType()));
			reponse = new Reponse<Formation>(0, messages, d);
		} catch (Exception e) {

			reponse = new Reponse<Formation>(1, Static.getErreursForException(e), null);
		}

		return reponse;

	}
	// faire la mise à jour d'une formation existante
	@PutMapping("/formation")
	public Reponse<Formation> modfier(@RequestBody Formation modif) {
		Reponse<Formation> reponse = null;

		// on recupere la formation à modifier
		Formation formation = formationMetier.findById(modif.getId());
		if (formation != null) {
			try {
				Formation f2 = formationMetier.modifier(modif);
				List<String> messages = new ArrayList<>();
				messages.add(String.format("%s a modifier avec succes", f2.getId()));
				reponse = new Reponse<Formation>(0, messages, f2);
			} catch (Exception e) {

				reponse = new Reponse<Formation>(1, Static.getErreursForException(e), null);
			}

		} else {
			List<String> messages = new ArrayList<>();
			messages.add(String.format("La formation n'existe pas"));
			reponse = new Reponse<Formation>(0, messages, null);
		}

		return reponse;

	}
 ////////////////////////////////////////////////////////////
	// recuperer toute les formation de la base
	///////////////////////////////////////////////////////
	@GetMapping("/formation")
    public Reponse<List<Formation>> findAll()  {
		Reponse<List<Formation>> reponse;
		try {
			List<Formation> formations = formationMetier.findAll();
			if (!formations.isEmpty()) {
				reponse = new Reponse<List<Formation>>(0, null, formations);
			} else {
				List<String> messages = new ArrayList<>();
				messages.add("Pas de formation trouvée");
				reponse = new Reponse<List<Formation>>(1, messages, new ArrayList<>());
			}
		} catch (Exception e) {
			reponse = new Reponse<List<Formation>>(1, Static.getErreursForException(e), new ArrayList<>());
		}
		return reponse;

	}
	// supprimer une formation par son id
	@DeleteMapping("/formation/{id}")
	public Reponse<Boolean> supprimer(@PathVariable("id") String id) throws JsonProcessingException {

		Reponse<Boolean> reponse = null;

		try {

			reponse = new Reponse<Boolean>(0, null, formationMetier.supprimer(id));

		} catch (RuntimeException e1) {
			reponse = new Reponse<>(1, Static.getErreursForException(e1), null);
		}

		return reponse;
	}
}

package ci.ipmd.ecole.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import ci.ipmd.ecole.entites.Niveau;
import ci.ipmd.ecole.metier.INiveauMetier;
import ci.ipmd.ecole.modele.Reponse;
import ci.ipmd.ecole.utilitaire.Static;

@RestController
@CrossOrigin
public class NiveauController {
	@Autowired
	private INiveauMetier niveauMetier;

	// Obtenir un niveau par son identifiant
	@GetMapping("/niveau/{id}")
	public Reponse<Niveau> getFormationById(@PathVariable String id) {
		Reponse<Niveau> reponse;
		try {
			Niveau niveau = niveauMetier.findById(id);
			List<String> messages = new ArrayList<>();
			messages.add(String.format("%s retrouvé", niveau.getLibelle()));
			reponse = new Reponse<Niveau>(0, null, niveau);
		} catch (Exception e) {
			reponse = new Reponse<>(1, Static.getErreursForException(e), null);
		}
		return reponse;

	}

	// Obtenir un niveau par son identifiant
	@GetMapping("/niveauLibelle")
	public Reponse<Niveau> getNiveauByLibelle() {
		Reponse<Niveau> reponse;
		String libelle1 = "Licence 1 (L1)";
		try {
			Niveau niveau = niveauMetier.findByLibelle(libelle1).get();
			List<String> messages = new ArrayList<>();
			messages.add(String.format("%s retrouvé", niveau.getLibelle()));
			reponse = new Reponse<Niveau>(0, null, niveau);
		} catch (Exception e) {
			reponse = new Reponse<>(1, Static.getErreursForException(e), null);
		}
		return reponse;

	}

	// creer un niveau dans la base mongo
	@PostMapping("/niveau")
	public Reponse<Niveau> create(@RequestBody Niveau niveau) {
		Reponse<Niveau> reponse = null;

		try {
			Niveau n = niveauMetier.creer(niveau);
			List<String> messages = new ArrayList<>();
			messages.add(String.format("%s a été ajouté avec succès", n.getLibelle()));
			reponse = new Reponse<Niveau>(0, messages, n);
		} catch (Exception e) {

			reponse = new Reponse<Niveau>(1, Static.getErreursForException(e), null);
		}

		return reponse;

	}

	// faire la mise à jour d'un niveau existant
	@PutMapping("/niveau")
	public Reponse<Niveau> modfier(@RequestBody Niveau modif) {
		Reponse<Niveau> reponse = null;

		// on recupere le niveau à modifier
		Niveau formation = niveauMetier.findById(modif.getId());
		if (formation != null) {
			try {
				Niveau f2 = niveauMetier.modifier(modif);
				List<String> messages = new ArrayList<>();
				messages.add(String.format("%s a modifier avec succes", f2.getId()));
				reponse = new Reponse<Niveau>(0, messages, f2);
			} catch (Exception e) {

				reponse = new Reponse<Niveau>(1, Static.getErreursForException(e), null);
			}

		} else {
			List<String> messages = new ArrayList<>();
			messages.add(String.format("Le niveau n'existe pas"));
			reponse = new Reponse<Niveau>(0, messages, null);
		}

		return reponse;

	}

	////////////////////////////////////////////////////////////
	// recuperer tous les niveux de la base
	///////////////////////////////////////////////////////
	@GetMapping("/niveau")
	public Reponse<List<Niveau>> findAll() {
		Reponse<List<Niveau>> reponse;
		try {
			List<Niveau> niveaux = niveauMetier.findAll();
			if (!niveaux.isEmpty()) {
				reponse = new Reponse<List<Niveau>>(0, null, niveaux);
			} else {
				List<String> messages = new ArrayList<>();
				messages.add("Pas de niveau trouvée");
				reponse = new Reponse<List<Niveau>>(1, messages, new ArrayList<>());
			}
		} catch (Exception e) {
			reponse = new Reponse<List<Niveau>>(1, Static.getErreursForException(e), new ArrayList<>());
		}
		return reponse;

	}
	// supprimer un niveau par son id
			@DeleteMapping("/niveau/{id}")
			public Reponse<Boolean> supprimer(@PathVariable("id") String id) throws JsonProcessingException {

				Reponse<Boolean> reponse = null;

				try {

					reponse = new Reponse<Boolean>(0, null, niveauMetier.supprimer(id));

				} catch (RuntimeException e1) {
					reponse = new Reponse<>(1, Static.getErreursForException(e1), null);
				}

				return reponse;
			}

}

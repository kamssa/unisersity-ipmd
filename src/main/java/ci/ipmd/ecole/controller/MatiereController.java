package ci.ipmd.ecole.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ci.ipmd.ecole.entites.Matiere;
import ci.ipmd.ecole.metier.IMatiereMetier;
import ci.ipmd.ecole.modele.Reponse;
import ci.ipmd.ecole.utilitaire.Static;

@RestController
@CrossOrigin
public class MatiereController {
	@Autowired
	private IMatiereMetier matiereMetier;
	
	// Obtenir une matiere par son identifiant
	@GetMapping("/matiere/{id}")
	public Reponse<Matiere> getSemestreById(@PathVariable String id)   {
		Reponse<Matiere> reponse;
		try {
			Matiere matiere = matiereMetier.findById(id);
			List<String> messages = new ArrayList<>();
			messages.add(String.format("%s retrouvée", matiere.getLibelle()));
			reponse = new Reponse<Matiere>(0, null, matiere);
		} catch (Exception e) {
			reponse = new Reponse<>(1, Static.getErreursForException(e), null);
		}
		return reponse;

	}
	// creer une matiere dans la base mongo
	@PostMapping("/matiere")
	public Reponse<Matiere> create(@RequestBody Matiere semestre) {
		Reponse<Matiere> reponse = null;

		try {
			Matiere m = matiereMetier.creer(semestre);
			List<String> messages = new ArrayList<>();
			messages.add(String.format("%s a été ajouté avec succès", m.getLibelle()));
			reponse = new Reponse<Matiere>(0, messages, m);
		} catch (Exception e) {

			reponse = new Reponse<Matiere>(1, Static.getErreursForException(e), null);
		}

		return reponse;

	}
	// faire la mise à jour d'un semestres existante
	@PutMapping("/matiere")
	public Reponse<Matiere> modfier(@RequestBody Matiere modif) {
		Reponse<Matiere> reponse = null;

		// on recupere le semestre à modifier
		Matiere semestre = matiereMetier.findById(modif.getId());
		if (semestre != null) {
			try {
				Matiere m2 = matiereMetier.modifier(modif);
				List<String> messages = new ArrayList<>();
				messages.add(String.format("%s a modifier avec succes", m2.getId()));
				reponse = new Reponse<Matiere>(0, messages, m2);
			} catch (Exception e) {

				reponse = new Reponse<Matiere>(1, Static.getErreursForException(e), null);
			}

		} else {
			List<String> messages = new ArrayList<>();
			messages.add(String.format("La matiere n'existe pas"));
			reponse = new Reponse<Matiere>(0, messages, null);
		}

		return reponse;

	}
 ////////////////////////////////////////////////////////////
	// recuperer toutes les matiere de la base
	///////////////////////////////////////////////////////
	@GetMapping("/matiere")
    public Reponse<List<Matiere>> findAll()  {
		Reponse<List<Matiere>> reponse;
		try {
			List<Matiere> matieres = matiereMetier.findAll();
			if (!matieres.isEmpty()) {
				reponse = new Reponse<List<Matiere>>(0, null, matieres);
			} else {
				List<String> messages = new ArrayList<>();
				messages.add("Pas de matieres trouvée");
				reponse = new Reponse<List<Matiere>>(1, messages, new ArrayList<>());
			}
		} catch (Exception e) {
			reponse = new Reponse<List<Matiere>>(1, Static.getErreursForException(e), new ArrayList<>());
		}
		return reponse;

	}
	
}

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

import ci.ipmd.ecole.entites.Filiere;
import ci.ipmd.ecole.entites.Semestre;
import ci.ipmd.ecole.metier.ISemestreMetier;
import ci.ipmd.ecole.modele.Reponse;
import ci.ipmd.ecole.utilitaire.Static;

@RestController
@CrossOrigin
public class SemestreController {
	@Autowired
	private ISemestreMetier semestreMetier;
	
	// Obtenir un semestre par son identifiant
	@GetMapping("/semestre/{id}")
	public Reponse<Semestre> getSemestreById(@PathVariable String id)   {
		Reponse<Semestre> reponse;
		try {
			Semestre semestre = semestreMetier.findById(id);
			List<String> messages = new ArrayList<>();
			messages.add(String.format("%s retrouvée", semestre.getLibelle()));
			reponse = new Reponse<Semestre>(0, null, semestre);
		} catch (Exception e) {
			reponse = new Reponse<>(1, Static.getErreursForException(e), null);
		}
		return reponse;

	}
	// creer un semestre dans la base mongo
	@PostMapping("/semestre")
	public Reponse<Semestre> create(@RequestBody Semestre semestre) {
		Reponse<Semestre> reponse = null;

		try {
			Semestre s = semestreMetier.creer(semestre);
			List<String> messages = new ArrayList<>();
			messages.add(String.format("%s a été ajouté avec succès", s.getLibelle()));
			reponse = new Reponse<Semestre>(0, messages, s);
		} catch (Exception e) {

			reponse = new Reponse<Semestre>(1, Static.getErreursForException(e), null);
		}

		return reponse;

	}
	// faire la mise à jour d'un semestres existante
	@PutMapping("/semestre")
	public Reponse<Semestre> modfier(@RequestBody Semestre modif) {
		Reponse<Semestre> reponse = null;

		// on recupere le semestre à modifier
		Semestre semestre = semestreMetier.findById(modif.getId());
		if (semestre != null) {
			try {
				Semestre s2 = semestreMetier.modifier(modif);
				List<String> messages = new ArrayList<>();
				messages.add(String.format("%s a modifier avec succes", s2.getId()));
				reponse = new Reponse<Semestre>(0, messages, s2);
			} catch (Exception e) {

				reponse = new Reponse<Semestre>(1, Static.getErreursForException(e), null);
			}

		} else {
			List<String> messages = new ArrayList<>();
			messages.add(String.format("Le semestre n'existe pas"));
			reponse = new Reponse<Semestre>(0, messages, null);
		}

		return reponse;

	}
 ////////////////////////////////////////////////////////////
	// recuperer tous les semestre de la base
	///////////////////////////////////////////////////////
	@GetMapping("/semestre")
    public Reponse<List<Semestre>> findAll()  {
		Reponse<List<Semestre>> reponse;
		try {
			List<Semestre> semestres = semestreMetier.findAll();
			if (!semestres.isEmpty()) {
				reponse = new Reponse<List<Semestre>>(0, null, semestres);
			} else {
				List<String> messages = new ArrayList<>();
				messages.add("Pas de semestre trouvée");
				reponse = new Reponse<List<Semestre>>(1, messages, new ArrayList<>());
			}
		} catch (Exception e) {
			reponse = new Reponse<List<Semestre>>(1, Static.getErreursForException(e), new ArrayList<>());
		}
		return reponse;

	}
	
}

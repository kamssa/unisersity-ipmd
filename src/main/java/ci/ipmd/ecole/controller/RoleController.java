package ci.ipmd.ecole.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ci.ipmd.ecole.entites.Filiere;
import ci.ipmd.ecole.entites.Role;
import ci.ipmd.ecole.metier.IFiliereMetier;
import ci.ipmd.ecole.metier.IRoleMetier;
import ci.ipmd.ecole.modele.Reponse;
import ci.ipmd.ecole.utilitaire.Static;

@RestController
@CrossOrigin
public class RoleController {
	@Autowired
	private IRoleMetier roleMetier;
	
	// creer une filiere dans la base mongo
	@PostMapping("/role")
	public Reponse<Role> create(@RequestBody Role role) {
		Reponse<Role> reponse = null;

		try {
			Role f = roleMetier.creer(role);
			List<String> messages = new ArrayList<>();
			messages.add(String.format("%s a été ajouté avec succès", f.getCode()));
			reponse = new Reponse<Role>(0, messages, f);
		} catch (Exception e) {

			reponse = new Reponse<Role>(1, Static.getErreursForException(e), null);
		}

		return reponse;

	}
	// creer une filiere dans la base mongo
		@PostMapping("/addRoleToAdmin")
		public Reponse<Role> addRoleToAdmin(@RequestBody Role role) {
			Reponse<Role> reponse = null;

			try {
				Role f = roleMetier.creer(role);
				List<String> messages = new ArrayList<>();
				messages.add(String.format("%s a été ajouté avec succès", f.getCode()));
				reponse = new Reponse<Role>(0, messages, f);
			} catch (Exception e) {

				reponse = new Reponse<Role>(1, Static.getErreursForException(e), null);
			}

			return reponse;

		}
}

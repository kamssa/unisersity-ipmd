package ci.ipmd.ecole.entites;

import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Administrateurs")
public class Administrateur extends Personne{

	public Administrateur() {
		super();
	}

	public Administrateur(String id, String nom, String prenom, String login, String email, String password,
			Set<Role> roles) {
		super(id, nom, prenom, login, email, password, roles);
	}

	public Administrateur(String login, String password) {
		super(login, password);
	}

	
	
}

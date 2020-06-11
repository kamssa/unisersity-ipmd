package ci.ipmd.ecole.entites;

import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Etudiants")
public class Etudiant extends Personne{
	
    
    
	public Etudiant(String login, String password) {
		super(login, password);
	}

	public Etudiant() {
		super();
	}

	public Etudiant(String id, String nom, String prenom, String login, String email, String password,
			Set<Role> roles) {
		super(id, nom, prenom, login, email, password, roles);
	}
	
	
}

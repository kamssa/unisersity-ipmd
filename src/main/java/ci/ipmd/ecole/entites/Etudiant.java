package ci.ipmd.ecole.entites;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Etudiant extends Personne{
	
    
    
	public Etudiant(String login, String password) {
		super(login, password);
	}
	
	
}

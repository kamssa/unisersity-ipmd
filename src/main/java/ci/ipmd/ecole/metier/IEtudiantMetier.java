package ci.ipmd.ecole.metier;

import ci.ipmd.ecole.entites.Personne;

public interface IEtudiantMetier extends Imetier<Personne, String>{
	  Boolean existsByLogin(String login);

}

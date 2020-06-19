package ci.ipmd.ecole.metier;

import java.util.Optional;

import ci.ipmd.ecole.entites.Niveau;

public interface INiveauMetier extends Imetier<Niveau, String>{

Optional<Niveau> findByLibelle(String libelle);
}

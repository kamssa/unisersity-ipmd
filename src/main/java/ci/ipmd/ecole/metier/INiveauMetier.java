package ci.ipmd.ecole.metier;

import java.util.List;
import java.util.Optional;

import ci.ipmd.ecole.entites.Niveau;

public interface INiveauMetier extends Imetier<Niveau, String>{
List<Niveau> findAllFiliereNiveauL1();
List<Niveau> findAllFiliereNiveauL2();
List<Niveau> findAllFiliereNiveauL3();
List<Niveau> findAllFiliereNiveauM1();
List<Niveau> findAllFiliereNiveauM2();
Optional<Niveau> findByLibelle(String libelle);
}

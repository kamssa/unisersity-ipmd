package ci.ipmd.ecole.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.ipmd.ecole.dao.PersonneRepository;
import ci.ipmd.ecole.entites.Etudiant;

@Service
public class EtudiantMetierImpl implements IEtudiantMetier {
@Autowired
private PersonneRepository personneRepository;
	
@Override
	public Etudiant creer(Etudiant entity) {
		return personneRepository.save(entity);
	}

	@Override
	public Etudiant modifier(Etudiant entity) {
		return null;
	}

	@Override
	public List<Etudiant> findAll() {
		return null;
	}

	@Override
	public Etudiant findById(String id) {
		return null;
	}

	@Override
	public boolean supprimer(String id) {
		return false;
	}

	@Override
	public boolean supprimer(List<Etudiant> entites) {
		return false;
	}

	@Override
	public boolean existe(String id) {
		return false;
	}

}

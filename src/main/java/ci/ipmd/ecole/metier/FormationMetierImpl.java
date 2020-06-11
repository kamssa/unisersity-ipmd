package ci.ipmd.ecole.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ci.ipmd.ecole.dao.FormationRepository;
import ci.ipmd.ecole.entites.Formation;
import ci.ipmd.ecole.exception.InvalideipmdException;
import ci.ipmd.ecole.modele.MessageResponse;

@Service
public class FormationMetierImpl implements IFormationMetier {
	@Autowired
	private FormationRepository formationRepository;

	@Override
	public Formation creer(Formation f) throws InvalideipmdException {
		System.out.println("admin a enregistrer" + ":" + f);
		if ((f.getType().equals(null)) || (f.getType() == "")) {
			throw new InvalideipmdException("Le login ne peut etre null");
		}
		if (formationRepository.existsByType(f.getType())) {
			throw new InvalideipmdException("Ce type est déjà utilisé");
		}
		return formationRepository.save(f);
	}

	@Override
	public Formation modifier(Formation entity) {
		return formationRepository.save(entity);
	}

	@Override
	public List<Formation> findAll() {
		return formationRepository.findAll();
	}

	@Override
	public Formation findById(String id) {
		return formationRepository.findById(id).get();
	}

	@Override
	public boolean supprimer(String id) {
		formationRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean supprimer(List<Formation> entites) {
		return false;
	}

	@Override
	public boolean existe(String id) {
		return false;
	}

	@Override
	public Boolean existsByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}

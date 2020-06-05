package ci.ipmd.ecole.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.ipmd.ecole.dao.FormationRepository;
import ci.ipmd.ecole.entites.Formation;

@Service
public class FormationMetierImpl implements IFormationMetier {
	@Autowired
	private FormationRepository formationRepository;

	@Override
	public Formation creer(Formation entity) {
		
		return formationRepository.save(entity);
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
		return false;
	}

	@Override
	public boolean supprimer(List<Formation> entites) {
		return false;
	}

	@Override
	public boolean existe(String id) {
		return false;
	}

}

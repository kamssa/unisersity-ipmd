package ci.ipmd.ecole.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ci.ipmd.ecole.dao.MatiereRepository;
import ci.ipmd.ecole.entites.Matiere;

@Service
public class MatiereMetier implements IMatiereMetier{

	@Autowired
	private MatiereRepository matiereRepository;
	@Override
	public Matiere creer(Matiere entity) {
		return matiereRepository.save(entity);
	}

	@Override
	public Matiere modifier(Matiere entity) {
		return matiereRepository.save(entity);
	}

	@Override
	public List<Matiere> findAll() {
		return matiereRepository.findAll();
	}

	@Override
	public Matiere findById(String id) {
		return matiereRepository.findById(id).get();
	}

	@Override
	public boolean supprimer(String id) {
		return false;
	}

	@Override
	public boolean supprimer(List<Matiere> entites) {
		return false;
	}

	@Override
	public boolean existe(String id) {
		return false;
	}

}

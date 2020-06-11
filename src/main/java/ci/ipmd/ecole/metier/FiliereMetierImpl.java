package ci.ipmd.ecole.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.ipmd.ecole.dao.FiliereRepository;
import ci.ipmd.ecole.entites.Filiere;

@Service
public class FiliereMetierImpl implements IFiliereMetier {
@Autowired
private FiliereRepository filireRepository;
	@Override
	public Filiere creer(Filiere entity) {
		
		return filireRepository.save(entity);
	}

	@Override
	public Filiere modifier(Filiere entity) {
		return filireRepository.save(entity);
	}

	@Override
	public List<Filiere> findAll() {
		return filireRepository.findAll();
	}

	@Override
	public Filiere findById(String id) {
		return filireRepository.findById(id).get();
	}

	@Override
	public boolean supprimer(String id) {
		 filireRepository.deleteById(id);
		 return true;
	}

	@Override
	public boolean supprimer(List<Filiere> entites) {
		return false;
	}

	@Override
	public boolean existe(String id) {
		return false;
	}

	
}

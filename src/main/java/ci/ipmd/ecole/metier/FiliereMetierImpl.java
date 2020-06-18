package ci.ipmd.ecole.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.ipmd.ecole.dao.FiliereRepository;
import ci.ipmd.ecole.entites.Filiere;
import ci.ipmd.ecole.entites.Formation;
import ci.ipmd.ecole.exception.InvalideipmdException;

@Service
public class FiliereMetierImpl implements IFiliereMetier {
@Autowired
private FiliereRepository filireRepository;
	@Override
	public Filiere creer(Filiere f) throws InvalideipmdException{
		
	if ((f.getLibelle().equals(null)) || (f.getLibelle() == "")) {
				throw new InvalideipmdException("Le libelle ne peut etre null");
			}
	if ((f.getFormation().getType().equals(null)) || (f.getFormation().getType() == "")) {
		throw new InvalideipmdException("La formation ne peut etre null");
	}
			
			return filireRepository.save(f);
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

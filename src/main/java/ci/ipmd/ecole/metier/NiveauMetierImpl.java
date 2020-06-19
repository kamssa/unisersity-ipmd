package ci.ipmd.ecole.metier;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.ipmd.ecole.dao.NiveauRepository;
import ci.ipmd.ecole.entites.Niveau;
import ci.ipmd.ecole.exception.InvalideipmdException;

@Service
public class NiveauMetierImpl implements INiveauMetier {
	@Autowired
	private NiveauRepository niveauRepository;

	@Override
	public Niveau creer(Niveau n) throws InvalideipmdException {
		if ((n.getLibelle().equals(null)) || (n.getLibelle() == "")) {
			throw new InvalideipmdException("Le libelle ne peut etre null");
		}
		
		return niveauRepository.save(n);
	}

	@Override
	public Niveau modifier(Niveau entity) {
		return niveauRepository.save(entity);
	}

	@Override
	public List<Niveau> findAll() {
		return niveauRepository.findAll();
	}

	@Override
	public Niveau findById(String id) {
		return niveauRepository.findById(id).get();
	}

	@Override
	public boolean supprimer(String id) {
		niveauRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean supprimer(List<Niveau> entites) {
		return false;
	}

	@Override
	public boolean existe(String id) {
		return false;
	}

	@Override
	public Optional<Niveau> findByLibelle(String libelle) {
		return niveauRepository.findByLibelle(libelle);
	}

	
}

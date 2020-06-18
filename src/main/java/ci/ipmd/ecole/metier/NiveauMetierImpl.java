package ci.ipmd.ecole.metier;

import java.util.List;
import java.util.Optional;
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
		if ((n.getFiliere().getLibelle().equals(null)) || (n.getFiliere().getLibelle() == "")) {
			throw new InvalideipmdException("La filiere ne peut etre null");
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
		return false;
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
	public List<Niveau> findAllFiliereNiveauL1() {
		List<Niveau> niveau = null;
		List<Niveau> niveaux = niveauRepository.findAll();
		niveau = niveaux.stream().filter(n -> n.getLibelle().equals("Licence 1 (L1)")).collect(Collectors.toList());
		return niveau;
	}

	@Override
	public Optional<Niveau> findByLibelle(String libelle) {

		return niveauRepository.findByLibelle(libelle);
	}

	@Override
	public List<Niveau> findAllFiliereNiveauL2() {
		List<Niveau> niveau = null;
		List<Niveau> niveaux = niveauRepository.findAll();
		niveau = niveaux.stream().filter(n -> n.getLibelle().equals("Licence 2 (L2)")).collect(Collectors.toList());
		return niveau;
	}

	@Override
	public List<Niveau> findAllFiliereNiveauL3() {
		List<Niveau> niveau = null;
		List<Niveau> niveaux = niveauRepository.findAll();
		niveau = niveaux.stream().filter(n -> n.getLibelle().equals("Licence 3 (L3)")).collect(Collectors.toList());
		return niveau;
	}

	@Override
	public List<Niveau> findAllFiliereNiveauM1() {
		List<Niveau> niveau = null;
		List<Niveau> niveaux = niveauRepository.findAll();
		niveau = niveaux.stream().filter(n -> n.getLibelle().equals("Master 1 (M1)")).collect(Collectors.toList());
		return niveau;
	}

	@Override
	public List<Niveau> findAllFiliereNiveauM2() {
		List<Niveau> niveau = null;
		List<Niveau> niveaux = niveauRepository.findAll();
		niveau = niveaux.stream().filter(n -> n.getLibelle().equals("Master 2 (M2)")).collect(Collectors.toList());
		return niveau;
	}

}

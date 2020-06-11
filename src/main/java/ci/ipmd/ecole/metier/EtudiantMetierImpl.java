package ci.ipmd.ecole.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ci.ipmd.ecole.dao.PersonneRepository;
import ci.ipmd.ecole.entites.Etudiant;
import ci.ipmd.ecole.entites.Personne;
import ci.ipmd.ecole.exception.InvalideipmdException;

@Service
public class EtudiantMetierImpl implements IEtudiantMetier {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	private PersonneRepository personneRepository;
	@Override
	public Personne creer(Personne entity) throws InvalideipmdException {
		return personneRepository.save(entity);
	}
	@Override
	public Personne modifier(Personne entity) throws InvalideipmdException {
		return personneRepository.save(entity);
	}
	@Override
	public List<Personne> findAll() {
		return personneRepository.findAll();
	}
	@Override
	public Personne findById(String id) {
		return personneRepository.findById(id).get();
	}
	@Override
	public boolean supprimer(String id) {
		personneRepository.deleteById(id);
		return true;
	}
	@Override
	public boolean supprimer(List<Personne> entites) {
		return false;
	}
	@Override
	public boolean existe(String id) {
		return false;
	}
	@Override
	public Boolean existsByLogin(String login) {
		return personneRepository.existsByLogin(login);
	}
	
}

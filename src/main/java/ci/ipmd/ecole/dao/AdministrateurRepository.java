package ci.ipmd.ecole.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import ci.ipmd.ecole.entites.Administrateur;

public interface AdministrateurRepository extends MongoRepository<Administrateur, String>{
	 Optional<Administrateur> findByLogin(String login);

	  
	  Boolean existsByLogin(String login);

	  Boolean existsByEmail(String email);
}

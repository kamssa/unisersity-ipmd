package ci.ipmd.ecole.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ci.ipmd.ecole.entites.Personne;

@RepositoryRestResource
public interface PersonneRepository extends MongoRepository<Personne, String> {
	  
	   Optional<Personne> findByEmail(String email);

	    List<Personne> findByIdIn(List<Long> userIds);

	    Optional<Personne> findByLogin(String username);

	    Boolean existsByLogin(String username);

	    Boolean existsByEmail(String email);
}

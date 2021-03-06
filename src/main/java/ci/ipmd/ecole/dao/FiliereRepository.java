package ci.ipmd.ecole.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ci.ipmd.ecole.entites.Filiere;


@RepositoryRestResource
public interface FiliereRepository extends MongoRepository<Filiere, String> {

}

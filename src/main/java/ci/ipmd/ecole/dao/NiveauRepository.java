package ci.ipmd.ecole.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ci.ipmd.ecole.entites.Niveau;

@RepositoryRestResource
public interface NiveauRepository extends MongoRepository<Niveau, String>{

}

package ci.ipmd.ecole.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ci.ipmd.ecole.entites.Formation;
@RepositoryRestResource
public interface FormationRepository extends MongoRepository<Formation, String> {

}

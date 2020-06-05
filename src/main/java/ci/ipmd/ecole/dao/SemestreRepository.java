package ci.ipmd.ecole.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ci.ipmd.ecole.entites.Semestre;

@RepositoryRestResource
public interface SemestreRepository extends MongoRepository<Semestre, String>{

}

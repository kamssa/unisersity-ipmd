package ci.ipmd.ecole.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import ci.ipmd.ecole.entites.Semestre;

public interface SemestreRepository extends MongoRepository<Semestre, String>{

}

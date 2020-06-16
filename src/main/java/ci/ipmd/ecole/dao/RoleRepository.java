package ci.ipmd.ecole.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ci.ipmd.ecole.entites.ERole;
import ci.ipmd.ecole.entites.Role;


@RepositoryRestResource
public interface RoleRepository extends MongoRepository<Role, String> {
	  Optional<Role> findByName(ERole name);
	  Optional<Role> findByCode(int code);
	  
}

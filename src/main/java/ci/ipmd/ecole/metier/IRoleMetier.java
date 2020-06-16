package ci.ipmd.ecole.metier;

import java.util.Optional;

import ci.ipmd.ecole.entites.ERole;
import ci.ipmd.ecole.entites.Role;


public interface IRoleMetier extends Imetier<Role, String>{
public Role findByName(ERole name);
public Role findByCode(int code);

}

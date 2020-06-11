package ci.ipmd.ecole.metier;

import ci.ipmd.ecole.entites.ERole;
import ci.ipmd.ecole.entites.Role;


public interface IRoleMetier extends Imetier<Role, String>{
public Role findByName(ERole name);


}

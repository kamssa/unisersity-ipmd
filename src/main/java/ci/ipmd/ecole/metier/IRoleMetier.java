package ci.ipmd.ecole.metier;

import ci.ipmd.ecole.entites.Role;


public interface IRoleMetier extends Imetier<Role, String>{
public Role findByRoleName(String name);
}

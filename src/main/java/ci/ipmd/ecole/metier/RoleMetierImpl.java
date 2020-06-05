package ci.ipmd.ecole.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.ipmd.ecole.dao.RoleRepository;
import ci.ipmd.ecole.entites.Role;


@Service
public class RoleMetierImpl implements IRoleMetier{
@Autowired
private RoleRepository roleRepository;
	
@Override
	public Role creer(Role entity) {
		return null;
	}

	@Override
	public Role modifier(Role entity) {
		return null;
	}

	@Override
	public List<Role> findAll() {
		return null;
	}

	@Override
	public Role findById(String id) {
		return null;
	}

	@Override
	public boolean supprimer(String id) {
		return false;
	}

	@Override
	public boolean supprimer(List<Role> entites) {
		return false;
	}

	@Override
	public boolean existe(String id) {
		return false;
	}

	@Override
	public Role findByRoleName(String name) {
		return roleRepository.findByName(name).get();
	}

}

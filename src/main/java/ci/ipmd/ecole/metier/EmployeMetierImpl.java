package ci.ipmd.ecole.metier;

import java.util.List;

import org.springframework.stereotype.Service;

import ci.ipmd.ecole.entites.Employe;
import ci.ipmd.ecole.exception.InvalideipmdException;

@Service
public class EmployeMetierImpl implements IEmployeMetier{

	@Override
	public Employe creer(Employe entity) throws InvalideipmdException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employe modifier(Employe entity) throws InvalideipmdException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employe> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employe findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supprimer(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimer(List<Employe> entites) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existe(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}

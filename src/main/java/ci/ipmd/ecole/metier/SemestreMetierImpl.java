package ci.ipmd.ecole.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.ipmd.ecole.dao.SemestreRepository;
import ci.ipmd.ecole.entites.Semestre;

@Service
public class SemestreMetierImpl implements ISemestreMetier{
@Autowired
private SemestreRepository semestreRepository;
	@Override
	public Semestre creer(Semestre entity) {
		return semestreRepository.save(entity);
	}

	@Override
	public Semestre modifier(Semestre entity) {
		return semestreRepository.save(entity);
	}

	@Override
	public List<Semestre> findAll() {
		return semestreRepository.findAll();
	}

	@Override
	public Semestre findById(String id) {
		return semestreRepository.findById(id).get();
	}

	@Override
	public boolean supprimer(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimer(List<Semestre> entites) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existe(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}

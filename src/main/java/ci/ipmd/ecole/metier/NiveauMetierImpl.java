package ci.ipmd.ecole.metier;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.ipmd.ecole.dao.NiveauRepository;
import ci.ipmd.ecole.entites.Niveau;

@Service
public class NiveauMetierImpl implements INiveauMetier{
@Autowired
private NiveauRepository niveauRepository;

@Override
public Niveau creer(Niveau entity) {
	return niveauRepository.save(entity);
}

@Override
public Niveau modifier(Niveau entity) {
	return niveauRepository.save(entity);
}

@Override
public List<Niveau> findAll() {

	return niveauRepository.findAll();
}

@Override
public Niveau findById(String id) {
	return niveauRepository.findById(id).get();
}

@Override
public boolean supprimer(String id) {
	return false;
}

@Override
public boolean supprimer(List<Niveau> entites) {
	return false;
}

@Override
public boolean existe(String id) {
	return false;
}
	
}

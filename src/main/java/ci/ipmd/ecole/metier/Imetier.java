package ci.ipmd.ecole.metier;

import java.util.List;

import ci.ipmd.ecole.exception.InvalideipmdException;




public interface Imetier <T,U>{
	
	public T creer(T entity) throws InvalideipmdException;
	
	public T modifier(T entity) throws InvalideipmdException;
	
	public List<T> findAll();
	
	public T findById(U id);

	public boolean supprimer(U id);
	
	public boolean supprimer(List<T> entites);
	
	public boolean existe(U id);
	

}

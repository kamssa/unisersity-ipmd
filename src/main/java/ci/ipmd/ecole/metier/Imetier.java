package ci.ipmd.ecole.metier;

import java.util.List;




public interface Imetier <T,U>{
	
	public T creer(T entity);
	
	public T modifier(T entity);
	
	public List<T> findAll();
	
	public T findById(U id);

	public boolean supprimer(U id);
	
	public boolean supprimer(List<T> entites);
	
	public boolean existe(U id);
	

}

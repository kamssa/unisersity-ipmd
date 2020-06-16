package ci.ipmd.ecole.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ci.ipmd.ecole.dao.PersonneRepository;
import ci.ipmd.ecole.entites.Personne;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	PersonneRepository personneRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		
		Personne personne = personneRepository.findByLogin(login)
				.orElseThrow(() -> 
				new UsernameNotFoundException("Aucun utilisateur trouve : " + login));

		return UserPrincipal.build(personne);
	}

	@Transactional
	public UserDetails loadUserById(String id) {
		
		 Personne personne = personneRepository.findById(id)
				.orElseThrow(() -> 
				new UsernameNotFoundException("User not found with id : " + id));
          System.out.println(personne.getRoles());
		return UserPrincipal.build(personne);
	}
}
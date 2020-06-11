package ci.ipmd.ecole.modele;

import java.util.Set;

public class SignupRequest {
   
    private String login;
 
    private Set<String> roles;
    
    
    private String password;


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public Set<String> getRoles() {
		return roles;
	}


	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
  
   
}
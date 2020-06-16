package ci.ipmd.ecole.modele;

public class JwtResponse {
	
			private String token;
			private String type = "Bearer";
			private String id;
			private String login;
			private String email;
			//private List<String> roles;

			public JwtResponse(String accessToken, String id, String login) {
				this.token = accessToken;
				this.id = id;
				this.login = login;
				
			}

			public String getAccessToken() {
				return token;
			}

			public void setAccessToken(String accessToken) {
				this.token = accessToken;
			}

			public String getTokenType() {
				return type;
			}

			public void setTokenType(String tokenType) {
				this.type = tokenType;
			}

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

			

			public String getLogin() {
				return login;
			}

			public void setLogin(String login) {
				this.login = login;
			}

		
}
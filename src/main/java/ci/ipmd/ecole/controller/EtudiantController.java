package ci.ipmd.ecole.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ci.ipmd.ecole.entites.Etudiant;
import ci.ipmd.ecole.entites.Personne;
import ci.ipmd.ecole.entites.Role;

import ci.ipmd.ecole.metier.IEtudiantMetier;
import ci.ipmd.ecole.metier.IRoleMetier;
import ci.ipmd.ecole.modele.JwtAuthenticationResponse;
import ci.ipmd.ecole.modele.Reponse;
import ci.ipmd.ecole.security.JwtTokenProvider;
import ci.ipmd.ecole.utilitaire.Static;


@RestController
@CrossOrigin
public class EtudiantController {
	@Autowired
	private IEtudiantMetier etudiantMetier;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtTokenProvider tokenProvider;
	@Autowired
	private IRoleMetier roleMetier;
	@Autowired
	private ObjectMapper jsonMapper;

	
	// athentifer un etudiant
		@PostMapping("/signin")
		public String authenticateUser(@RequestBody Personne loginRequest) throws JsonProcessingException {
			Reponse<ResponseEntity<?>> reponse;
			Authentication authentication = authenticationManager.authenticate(

					new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);

			String jwt = tokenProvider.generateToken(authentication);
			reponse = new Reponse<ResponseEntity<?>>(0, null, ResponseEntity.ok(new JwtAuthenticationResponse(jwt)));
						return jsonMapper.writeValueAsString(reponse);

		}

	@PostMapping("/signup")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String registerAbonne(@RequestBody Etudiant signUpRequest) throws Exception {

		Reponse<Personne> reponse = null;
		Personne abonne = null;
		try {
           
			Role userRole = roleMetier.findByRoleName("USER");
			signUpRequest.setRoles(Collections.singleton(userRole));
		
			abonne = etudiantMetier.creer(signUpRequest);

			List<String> messages = new ArrayList<>();
			messages.add(String.format("%s  a été créé avec succès", abonne.getId()));
			reponse = new Reponse<Personne>(0, messages, abonne);

		} catch (Exception e) {
			reponse = new Reponse<Personne>(1, Static.getErreursForException(e), null);
		}
		return jsonMapper.writeValueAsString(reponse);
	}
	
	
}

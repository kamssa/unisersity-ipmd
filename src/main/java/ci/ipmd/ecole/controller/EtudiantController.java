package ci.ipmd.ecole.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ci.ipmd.ecole.entites.Administrateur;
import ci.ipmd.ecole.entites.ERole;
import ci.ipmd.ecole.entites.Etudiant;
import ci.ipmd.ecole.entites.Personne;
import ci.ipmd.ecole.entites.Role;

import ci.ipmd.ecole.metier.IEtudiantMetier;
import ci.ipmd.ecole.metier.IRoleMetier;
import ci.ipmd.ecole.modele.JwtAuthenticationResponse;
import ci.ipmd.ecole.modele.JwtResponse;
import ci.ipmd.ecole.modele.LoginRequest;
import ci.ipmd.ecole.modele.MessageResponse;
import ci.ipmd.ecole.modele.Reponse;
import ci.ipmd.ecole.modele.SignupRequest;
import ci.ipmd.ecole.security.JwtTokenProvider;
import ci.ipmd.ecole.security.UserPrincipal;
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
	@Autowired
	PasswordEncoder encoder;
	
	// athentifer un etudiant
			@PostMapping("/etudiantin")
			public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
							Authentication authentication = authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword()));

				SecurityContextHolder.getContext().setAuthentication(authentication);
				String jwt = tokenProvider.generateToken(authentication);
				
				UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();		
				/*List<String> roles = userDetails.getAuthorities().stream()
						.map(item -> item.getAuthority())
						.collect(Collectors.toList());*/

				return ResponseEntity.ok(new JwtResponse(jwt, 
														 userDetails.getId(), 
														 userDetails.getLogin()));
			}

		@PostMapping("/etudiantup")
		@ResponseStatus(code = HttpStatus.CREATED)
		public ResponseEntity<?> register(@RequestBody SignupRequest signUpRequest) throws Exception {
			
			if (etudiantMetier.existsByLogin(signUpRequest.getLogin())) {
				return ResponseEntity
						.badRequest()
						.body(new MessageResponse("Error: Login déja utilisé!"));
			}
			// Create new etudiant's account
			Etudiant etudiant = new Etudiant(signUpRequest.getLogin(),encoder.encode(signUpRequest.getPassword()));

			Set<String> strRoles = signUpRequest.getRoles();
			Set<Role> roles = new HashSet<>();

			if (strRoles == null) {
				Role userRole = roleMetier.findByName(ERole.ROLE_USER);
						
				roles.add(userRole);
			} else {
				strRoles.forEach(role -> {
					switch (role) {
					case "admin":
						Role adminRole = roleMetier.findByName(ERole.ROLE_ADMIN);
							
						roles.add(adminRole);

						break;
					case "mod":
						Role modRole = roleMetier.findByName(ERole.ROLE_MODERATOR);
						roles.add(modRole);

						break;
					default:
						Role userRole = roleMetier.findByName(ERole.ROLE_USER);
						roles.add(userRole);
					}
				});
			}

			etudiant.setRoles(roles);
			etudiantMetier.creer(etudiant);

			return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
		}
		

	
}

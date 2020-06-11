package ci.ipmd.ecole;

import java.util.TimeZone;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ci.ipmd.ecole.dao.FiliereRepository;
import ci.ipmd.ecole.dao.FormationRepository;
import ci.ipmd.ecole.dao.RoleRepository;
import ci.ipmd.ecole.entites.Filiere;
import ci.ipmd.ecole.entites.Formation;
import ci.ipmd.ecole.entites.Role;

@SpringBootApplication
public class EcoleWebMetierDaoJpaApplication {
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}


	public static void main(String[] args) {
		SpringApplication.run(EcoleWebMetierDaoJpaApplication.class, args);
	}
	@Bean
	   CommandLineRunner start(FormationRepository formationRepository,
			   FiliereRepository filiereRepository) {
		return args ->{
			filiereRepository.deleteAll();  
			Stream.of("IDA").forEach(d->{
				//formationRepository.save(new Formation("init", "DESC"));
				filiereRepository.save(new Filiere(d,"c'est pour les experts"));
			});
			filiereRepository.findAll().forEach(System.out::println);
		};
	}
}

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
	   CommandLineRunner start(RoleRepository formationRepository,
			   FiliereRepository filiereRepository) {
		return args ->{
			formationRepository.deleteAll();  
			Stream.of("USER").forEach(d->{
				formationRepository.save(new Role("USER"));
			});
			formationRepository.findAll().forEach(System.out::println);
		};
	}
}

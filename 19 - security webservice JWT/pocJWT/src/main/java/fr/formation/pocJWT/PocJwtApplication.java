package fr.formation.pocJWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import fr.formation.pocJWT.entity.Personne;
import fr.formation.pocJWT.security.jwt.UserInfo;
import fr.formation.pocJWT.security.jwt.UserInfoRepository;
import fr.formation.pocJWT.service.PersonneService;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class PocJwtApplication {
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserInfoRepository repo;
	
	@Autowired
	PersonneService service;
	
	@PostConstruct
	public void init() {
		repo.save(new UserInfo("manu","{bcrypt}"+encoder.encode("manu"),"ROLE_ADMIN"));
		repo.save(new UserInfo("pierre","{bcrypt}"+encoder.encode("pierre"),"ROLE_USER"));
		repo.save(new UserInfo("jean","{bcrypt}"+encoder.encode("jean"),"USER,ADMIN"));
		
		repo.findAll().forEach(System.out::println);
		
		service.addPersonne(new Personne("Cérien","Jean"));
		service.addPersonne(new Personne("Terrieur","Alex"));
		service.addPersonne(new Personne("Terrieur","Alain"));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PocJwtApplication.class, args);
	}

}

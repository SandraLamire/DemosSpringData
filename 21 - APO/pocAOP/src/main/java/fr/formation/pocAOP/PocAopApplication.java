package fr.formation.pocAOP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.formation.pocAOP.entity.Personne;
import fr.formation.pocAOP.service.PersonneService;

@SpringBootApplication
public class PocAopApplication implements CommandLineRunner{
	@Autowired
	private PersonneService service;
	
	public static void main(String[] args) {
		SpringApplication.run(PocAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.addPersonne(new Personne("Cérien", "Jean", 10));
		
		service.getPersonnes().forEach(System.out::println);
	}

}

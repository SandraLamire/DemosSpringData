package fr.formation.codeur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.formation.codeur.service.Codeur;

@SpringBootApplication
public class CodeurApplication implements CommandLineRunner{
	@Autowired
	@Qualifier("MIN")
	private Codeur codeur;
	
	@Autowired
	@Qualifier("MAJ")
	private Codeur codeur2;
	
	public static void main(String[] args) {
		SpringApplication.run(CodeurApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(codeur.coder("Coucou"));
		System.out.println(codeur2.coder("Coucou"));
	}

}

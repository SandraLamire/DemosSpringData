package fr.formation.heritage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.formation.heritage.bo.Etudiant;
import fr.formation.heritage.bo.Formateur;
import fr.formation.heritage.bo.Personne;
import fr.formation.heritage.dal.PersonneDAO;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class HeritageApplication implements CommandLineRunner{
	@Autowired
	PersonneDAO dao;
	
	public static void main(String[] args) {
		SpringApplication.run(HeritageApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
//		dao.save(new Personne("Cérien","Jean"));
		dao.save(new Etudiant("Prendbien","Jacques",20000));
		dao.save(new Formateur("Seigne","Jean",70000));
		
		dao.findAll().forEach(System.out::println);
		
		dao.findAllFormateur().forEach(System.out::println);
	}

}

package com.example.pocGroupBy;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.pocGroupBy.entity.Personne;
import com.example.pocGroupBy.repository.PersonneRepository;
import com.example.pocGroupBy.repository.PersonneRepository.Resultat;

@SpringBootApplication
public class PocGroupByApplication implements CommandLineRunner{
	@Autowired
	PersonneRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(PocGroupByApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repo.save(new Personne("Cérien", "Jean",12));
		repo.save(new Personne("Terrieur", "Alex",21));
		repo.save(new Personne("Terrieur", "Alain",25));
		repo.save(new Personne("Tim", "Vincent",12));
		repo.save(new Personne("Zita", "Eva",25));
	
		List<Resultat> res = repo.stat();
		res.forEach(r->System.out.println(r.getAge()+":"+r.getCountAge()));
	}

}

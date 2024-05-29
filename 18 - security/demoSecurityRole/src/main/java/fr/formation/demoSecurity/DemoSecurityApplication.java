package fr.formation.demoSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import fr.formation.demoSecurity.entity.Utilisateur;
import fr.formation.demoSecurity.service.UtilisateurService;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class DemoSecurityApplication {
	@Autowired
	public UtilisateurService service;
	

	@PostConstruct
	public void init() {
		service.addUtilisateur(new Utilisateur("jessy","jessy","Toutfaire","Jessy","ADMIN,USER"));
		service.addUtilisateur(new Utilisateur("jeffrey","jeffrey","Leminimum","Jeffrey","USER"));
		service.addUtilisateur(new Utilisateur("jean","jean","Cérien","Jean","ADMIN"));	
		service.getAllUtilisateurs().forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoSecurityApplication.class, args);
	}


}

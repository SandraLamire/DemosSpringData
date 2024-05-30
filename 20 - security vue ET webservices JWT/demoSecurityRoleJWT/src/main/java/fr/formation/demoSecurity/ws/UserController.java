package fr.formation.demoSecurity.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.demoSecurity.entity.Utilisateur;
import fr.formation.demoSecurity.service.UtilisateurService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UtilisateurService service;
	
	@GetMapping
	public List<Utilisateur> getall(){
		return service.getAllUtilisateurs();
	}
}

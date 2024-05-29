package fr.formation.demoSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.demoSecurity.service.UtilisateurService;

@Controller
public class TestController {
	@Autowired
	public UtilisateurService service;
	
	@GetMapping("/")
	public String accueil(Model model) {
		model.addAttribute("utilisateurs",service.getAllUtilisateurs());
		return "accueil";
	}
	
	@GetMapping("/url1")
	public String url1() {
		return "url1";
	}
	
	@GetMapping("/url2")
	public String url2(Authentication authentication) {
		return "url2";
	}
	
	@GetMapping("/url3")
	public String url3(Authentication authentication) {
		return "url3";
	}
}

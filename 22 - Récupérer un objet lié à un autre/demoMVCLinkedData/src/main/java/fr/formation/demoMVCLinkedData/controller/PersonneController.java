package fr.formation.demoMVCLinkedData.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.demoMVCLinkedData.bo.Maison;
import fr.formation.demoMVCLinkedData.bo.Personne;
import fr.formation.demoMVCLinkedData.dal.MaisonDAO;
import fr.formation.demoMVCLinkedData.dal.PersonneDAO;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Controller
public class PersonneController {
	@Autowired
	PersonneDAO personneDAO;
	
	@Autowired
	MaisonDAO maisonDAO;
	
	
	@PostConstruct
	@Transactional
	public void init() {
		Maison m1 = new Maison("Ici Pas Là 53000 Laval");
		Maison m2 = new Maison("Rue du grand duduche 53000 Laval");
		maisonDAO.save(m1);
		maisonDAO.save(m2);
		
		personneDAO.save(new Personne("Cérien","Jean",m1));
		personneDAO.save(new Personne("Terrieur","Alain",m2));
		personneDAO.save(new Personne("Terrieur","Alex",m2));
	}
	
	
	
	@ModelAttribute("lstPersonnes")
	public List<Personne> getPersonnes() {
		return (List<Personne>) personneDAO.findAll();
	}
	
	@ModelAttribute("lstMaisons")
	public List<Maison> getMaisons() {
		return (List<Maison>) maisonDAO.findAll();
	}
	
	
	@GetMapping("/")
	public String init(Personne personne) {
		return "accueil";
	}
	
	@PostMapping("/")
	@Transactional
	public String valid(Personne personne) {
		maisonDAO.save(personne.getMaison());
		personneDAO.save(personne);
		return "redirect:/";
	}
}

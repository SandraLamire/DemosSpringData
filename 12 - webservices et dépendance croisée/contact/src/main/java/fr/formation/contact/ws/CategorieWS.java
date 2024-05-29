package fr.formation.contact.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.contact.entity.Categorie;
import fr.formation.contact.service.CategorieService;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/categorie")
public class CategorieWS {
	
	
	@Autowired
	CategorieService service;

	@PostConstruct
	public void init() {
		service.addCategorie(new Categorie("SUPER", "Super client"));
		service.addCategorie(new Categorie("MAUVAIS", "Mauvais client"));
		service.addCategorie(new Categorie("ETRANGE", "client étrange"));
	}
	
	@GetMapping
	public List<Categorie> getAll(){
		return service.getAllCategorie();
	}
	
	
	@GetMapping("/{id}")
	public Categorie getById(@PathVariable("id") Integer id){
		return service.getCategorieById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Integer id){
		service.delCategorieById(id);
	}
	
	@PostMapping
	public Categorie addCategorie(@RequestBody Categorie categorie) {
		service.addCategorie(categorie);
		return categorie;
	}
	
	@PutMapping
	public Categorie modCategorie(@RequestBody Categorie categorie) {
		service.modCategorie(categorie);
		return categorie;
	}
	
}

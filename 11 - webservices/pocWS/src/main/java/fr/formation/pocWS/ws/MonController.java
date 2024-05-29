package fr.formation.pocWS.ws;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.pocWS.entity.Personne;

@RestController
@RequestMapping("/essai")
public class MonController {

	@GetMapping
	public String disHello() {
		return "Bonjour";
	}
	
	@GetMapping("/anglais")
	public String disHelloEN() {
		return "hello";
	}
	
	//http://localhost:8080/essai/langue/br
	@GetMapping("/langue/{langue}")
	public String disEnLaLangue(@PathVariable("langue") String langue) {
		return switch (langue) {
		case "en" -> "hello";
		case "fr" -> "bonjour";
		case "es" -> "hola";
		case "br" -> "bom dia";
		default -> "hein !!!";
		};
	}
	
	//http://localhost:8080/essai/langue2?langue=br
	@GetMapping("/langue2")
	public String disEnLaLangue2(@RequestParam("langue") String langue) {
		return switch (langue) {
		case "en" -> "hello";
		case "fr" -> "bonjour";
		case "es" -> "hola";
		case "br" -> "bom dia";
		default -> "hein !!!";
		};
	}
	
	@GetMapping("/personne")
	public Personne getPersonne() {
		return new Personne("Cérien", "Jean", "4545457");
	}
	
	@GetMapping("/personnes")
	public List<Personne> getPersonnes() {
		return Arrays.asList(new Personne("Cérien", "Jean", "4545457"),new Personne("Terrieur", "Alain", "4545457"));
	}
	
	@GetMapping("/plus/{a}/{b}")
	public Integer plus(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
		return a+b;
	}
	
}

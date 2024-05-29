package fr.formation.pocCons.ws;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.formation.pocCons.bo.Fact;

@RestController
public class ConsomateurWS {
	
	@GetMapping("/go")
	public Fact consomme(RestTemplate restTemplate) {
		Fact fact = restTemplate.getForObject("https://api.chucknorris.io/jokes/random", Fact.class);
		return fact;
	}
}

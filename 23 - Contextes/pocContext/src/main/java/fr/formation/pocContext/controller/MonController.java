package fr.formation.pocContext.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import fr.formation.pocContext.entity.MyModel;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class MonController {

	@Autowired
	@Qualifier("singleton")
	MyModel modelSingleton;

	@Autowired
	@Qualifier("application")
	MyModel modelApplication;
	
	@Autowired
	@Qualifier("request")
	MyModel modelRequest;

	@Autowired
	@Qualifier("session")
	MyModel modelSession;
	
	@GetMapping("/")
	public String application() {
		System.out.println(">>>>appels des informations");
		modelSingleton.getMessage();
		modelApplication.getMessage();
		modelRequest.getMessage();
		modelSession.getMessage();
		return "ok";
	}
	

}

package fr.formation.pocContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import fr.formation.pocContext.entity.MyModel;

@Configuration
public class Conf {

	@Bean("singleton")
	public MyModel getSingleton() {
		System.out.println("SINGLETON");
		return new MyModel("SINGLETON");
	}
	
	
	@Bean("application")
	@ApplicationScope
	public MyModel getApplication() {
		System.out.println("APPLICATION");
		return new MyModel("APPLICATION");
	}
	
	@Bean("request")
	@RequestScope
	public MyModel getRequest() {
		System.out.println("REQUEST");
		return new MyModel("REQUEST");
	}
	
	@Bean("session")
	@SessionScope
	public MyModel getSession() {
		System.out.println("SESSION");
		return new MyModel("SESSION");
	}
}

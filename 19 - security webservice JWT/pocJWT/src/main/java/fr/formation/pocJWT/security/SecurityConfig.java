package fr.formation.pocJWT.security;

import org.apache.commons.logging.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.Filter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private Filter jwtAuthenticationFilter;
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	/**
	 * Restriction des URLs selon la connexion utilisateur et leurs rôles
	 */
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> {
			auth
				.requestMatchers("/auth/**").permitAll()
				.requestMatchers(HttpMethod.GET, "/personne").hasAnyRole("EMPLOYE", "ADMIN")
				.anyRequest().denyAll();

		});

		// Désactivé Cross Site Request Forgery
		// Non préconisé pour les API REST en stateless. Sauf pour POST, PUT, PATCH et
		// DELETE
		http.csrf(csrf -> {
			csrf.disable();
		});

		// Connexion de l'utilisateur
		http.authenticationProvider(authenticationProvider);

		// Activer le filtre JWT et l'authentication de l'utilisateur
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		// Session Stateless
		http.sessionManagement(session -> {
			session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		});

		return http.build();
	}

}

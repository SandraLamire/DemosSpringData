package fr.formation.demoSecurity.security.jwt;

import java.io.IOException;

import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
//Doit être active dès qu'il y a une requête
//Doit devenir un bean pour spring
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	// Gérer le jeton
	private JwtService jwtService;

	// Gérer les données de l'utilisateur - Classe de Spring Security
	private UserDetailsService userDetailsService;

	protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
			@NonNull FilterChain filterChain)
			throws ServletException, IOException {
		// vérifier le jeton JWT – il est passé dans l’en-tête
		final String authHeader = request.getHeader("Authorization");
		final String jwt;
		// vérifier qu’il y a une donnée dans l’entête qui correspond à Authorization
		// l’entête contient Bearer <jeton> SINON erreur
		// Sinon laissé le comportement suivre son cours
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		// Il y a un JWT – il faut l’extraire
		jwt = authHeader.substring(7);// 7 correspond à Bearer
		
		// Vérification de l'utilisateur
		final String userPseudo = jwtService.extractUserName(jwt);

		// Validation des données par rapport à la DB
		if (userPseudo != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			// Check in DB
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(userPseudo);
			if (jwtService.isTokenValid(jwt, userDetails)) {
				// Si valide - servlet ok
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userPseudo, null,
						userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		filterChain.doFilter(request, response);
	}
}

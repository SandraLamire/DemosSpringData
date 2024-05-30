package fr.formation.demoSecurity.security.jwt;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import fr.formation.demoSecurity.security.MyUserDetailsService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthenticationService {
	private MyUserDetailsService UserDetailService;
	private JwtService jwtService;
	private AuthenticationManager authenticationManager;
	
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getPseudo(), request.getPassword()));		
		UserDetails user = UserDetailService.loadUserByUsername(request.getPseudo());
		
		String jwtToken = jwtService.generateToken(user);
		AuthenticationResponse authResponse = new AuthenticationResponse();
		authResponse.setToken(jwtToken);
		return authResponse;
	}

}

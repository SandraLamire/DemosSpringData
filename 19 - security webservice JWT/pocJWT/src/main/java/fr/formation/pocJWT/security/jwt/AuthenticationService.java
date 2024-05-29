package fr.formation.pocJWT.security.jwt;

import org.springframework.security.authentication.*;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthenticationService {
	private UserInfoRepository userInfoRepository;
	private JwtService jwtService;
	private AuthenticationManager authenticationManager;
	
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getPseudo(), request.getPassword()));		
		UserInfo user = userInfoRepository.findById(request.getPseudo()).orElseThrow();
		
		String jwtToken = jwtService.generateToken(user);
		AuthenticationResponse authResponse = new AuthenticationResponse();
		authResponse.setToken(jwtToken);
		return authResponse;
	}

}

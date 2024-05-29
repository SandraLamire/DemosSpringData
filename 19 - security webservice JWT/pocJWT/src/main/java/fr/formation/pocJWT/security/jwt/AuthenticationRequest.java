package fr.formation.pocJWT.security.jwt;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "pseudo")
public class AuthenticationRequest {
	private String pseudo;
    private String password;
}

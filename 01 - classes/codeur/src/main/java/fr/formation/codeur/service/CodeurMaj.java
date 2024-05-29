package fr.formation.codeur.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("MAJ")
@Primary
public class CodeurMaj implements Codeur {

	@Override
	public String coder(String message) {
		return message.toUpperCase();
	}

}

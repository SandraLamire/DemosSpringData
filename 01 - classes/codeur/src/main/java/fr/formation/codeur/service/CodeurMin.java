package fr.formation.codeur.service;

import org.springframework.stereotype.Service;

@Service("INV")
public class CodeurMin implements Codeur {

	@Override
	public String coder(String message) {
		return new StringBuilder(message).reverse().toString();
	}

}

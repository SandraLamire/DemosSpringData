package fr.formation.codeur.service;

import org.springframework.stereotype.Service;

@Service("MIN")
public class CodeurInv implements Codeur {

	@Override
	public String coder(String message) {
		return message.toLowerCase();
	}

}

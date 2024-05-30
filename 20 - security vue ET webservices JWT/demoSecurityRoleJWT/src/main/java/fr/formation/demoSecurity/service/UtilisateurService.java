package fr.formation.demoSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.formation.demoSecurity.entity.Utilisateur;
import fr.formation.demoSecurity.repository.UtilisateurRepository;
import jakarta.transaction.Transactional;

@Service
public class UtilisateurService {
	@Autowired
	UtilisateurRepository repo;
	
	@Autowired
	PasswordEncoder encodeur;
	
	
	@Transactional
	public void addUtilisateur(Utilisateur utilisateur) {
		// encodage du mot de passe 
		utilisateur.setMdp("{bcrypt}"+encodeur.encode(utilisateur.getMdp()));
		
		// insertion en base
		repo.save(utilisateur);
	}

	public List<Utilisateur> getAllUtilisateurs() {
		return (List<Utilisateur>) repo.findAll();
	}
	
}

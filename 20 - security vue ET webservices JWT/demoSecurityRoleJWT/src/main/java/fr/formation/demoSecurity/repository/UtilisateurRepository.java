package fr.formation.demoSecurity.repository;

import org.springframework.data.repository.CrudRepository;

import fr.formation.demoSecurity.entity.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer>{

	Utilisateur findByPseudo(String pseudo);

}

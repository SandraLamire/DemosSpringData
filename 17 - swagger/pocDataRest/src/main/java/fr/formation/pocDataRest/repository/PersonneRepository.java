package fr.formation.pocDataRest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.formation.pocDataRest.entity.Personne;

public interface PersonneRepository extends CrudRepository<Personne, Integer>{
	public List<Personne> findByNom(@Param("nom")String nom);

}

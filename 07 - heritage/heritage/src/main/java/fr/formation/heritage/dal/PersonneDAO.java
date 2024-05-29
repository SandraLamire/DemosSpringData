package fr.formation.heritage.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.formation.heritage.bo.Personne;

public interface PersonneDAO extends CrudRepository<Personne, Integer>{

	@Query("SELECT f FROM Formateur f")
	List<Personne> findAllFormateur();

}

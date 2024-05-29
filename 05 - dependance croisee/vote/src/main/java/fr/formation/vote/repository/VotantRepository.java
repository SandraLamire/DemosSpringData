package fr.formation.vote.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.formation.vote.entity.Votant;

public interface VotantRepository extends CrudRepository<Votant, Integer>{

	@Query("SELECT count(v) FROM Votant v WHERE v.candidat.nom=:candidat")
	Integer countWhen(@Param("candidat") String candidat);

	@Query("SELECT v FROM Votant v WHERE v.candidat.parti=:parti")
	List<Votant> findAllToParti(@Param("parti") String parti);


}

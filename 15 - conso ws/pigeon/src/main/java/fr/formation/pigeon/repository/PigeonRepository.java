package fr.formation.pigeon.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.formation.pigeon.entity.Pigeon;

public interface PigeonRepository extends CrudRepository<Pigeon, Integer> {

	List<Pigeon> findByCode(String numero);

}

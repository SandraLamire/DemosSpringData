package fr.formation.pocJSONVIEW.dal;

import org.springframework.data.repository.CrudRepository;

import fr.formation.pocJSONVIEW.bo.Personne;

public interface PersonneDAO extends CrudRepository<Personne, Integer>{

}

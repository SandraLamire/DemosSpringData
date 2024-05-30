package fr.formation.demoMVCLinkedData.dal;

import org.springframework.data.repository.CrudRepository;

import fr.formation.demoMVCLinkedData.bo.Maison;

public interface MaisonDAO extends CrudRepository<Maison, Integer>{

}

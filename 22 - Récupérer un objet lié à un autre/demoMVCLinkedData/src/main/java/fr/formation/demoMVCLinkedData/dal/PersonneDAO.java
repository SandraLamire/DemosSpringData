package fr.formation.demoMVCLinkedData.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.formation.demoMVCLinkedData.bo.Maison;
import fr.formation.demoMVCLinkedData.bo.Personne;

public interface PersonneDAO extends CrudRepository<Personne, Integer>{

}

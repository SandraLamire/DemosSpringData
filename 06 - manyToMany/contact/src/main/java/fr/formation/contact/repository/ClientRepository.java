package fr.formation.contact.repository;

import org.springframework.data.repository.CrudRepository;

import fr.formation.contact.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Integer>{

}

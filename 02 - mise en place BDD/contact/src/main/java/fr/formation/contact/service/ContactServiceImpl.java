package fr.formation.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.contact.entity.Contact;
import fr.formation.contact.repository.ContactRepository;
import jakarta.transaction.Transactional;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	ContactRepository repo;


	
	@Override
	@Transactional
	public void addContact(Contact contact) throws ContactException {
		if("Martin".equals(contact.getNom())){
			throw new ContactException("Pas de Martin!!!");
		}
		repo.save(contact);
	}

	@Override
	public List<Contact> getAll() {
		return (List<Contact>) repo.findAll();
	}

	@Override
	public List<Contact> getFromNomAndPrenom(String nom, String prenom) {
		return repo.findAllByNomAndPrenom(nom, prenom);
	}

}

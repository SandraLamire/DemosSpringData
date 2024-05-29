package fr.formation.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.contact.entity.Categorie;
import fr.formation.contact.repository.CategorieRepository;
import jakarta.transaction.Transactional;

@Service
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	private CategorieRepository repo;
	
	@Override
	public List<Categorie> getAllCategorie() {
		return (List<Categorie>) repo.findAll();
	}

	@Override
	public Categorie getCategorieById(Integer id) {
		// TODO : faire un truc plus propre que ce truc pas propre
		return repo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void addCategorie(Categorie categorie) {
		repo.save(categorie);
	}

	@Override
	@Transactional
	public void modCategorie(Categorie categorie) {
		repo.save(categorie);
	}

	@Override
	@Transactional
	public void delCategorie(Categorie categorie) {
		repo.delete(categorie);
	}

	@Override
	@Transactional
	public void delCategorieById(Integer id) {
		repo.deleteById(id);
	}

}

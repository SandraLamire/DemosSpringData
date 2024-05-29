package com.example.pocGroupBy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.pocGroupBy.entity.Personne;

public interface PersonneRepository extends CrudRepository<Personne, Integer> {

	 public interface Resultat{
		 Integer getAge();
		 Integer getCountAge();
	 }
	 
	 @Query("SELECT age as age, count(p) as countAge FROM Personne p GROUP BY age")
	 public List<Resultat> stat();
}

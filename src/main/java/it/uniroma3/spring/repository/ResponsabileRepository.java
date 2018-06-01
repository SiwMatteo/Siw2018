package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import it.uniroma3.spring.model.Responsabile;

public interface ResponsabileRepository extends CrudRepository<Responsabile, String>{

	Responsabile findByEmail(String email);
	List<Responsabile> findByRuolo(String ruolo);
	void add(Responsabile responsabile);
	
 


    

	
	

}

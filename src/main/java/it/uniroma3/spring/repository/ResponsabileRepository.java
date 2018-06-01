package it.uniroma3.spring.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Allievo;
import it.uniroma3.spring.model.Responsabile;

public interface ResponsabileRepository extends CrudRepository<Responsabile, String>{

	void save(Allievo allievo);

	
	
 


    

	
	

}

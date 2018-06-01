package it.uniroma3.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Attivita;

public interface AttivitaRepository extends CrudRepository<Attivita, Long> {
  
	

	
	



	List<Attivita> findByNome(String nome);

    List<Attivita> findByDescrizione(String descrizione);
    
    List<Attivita> findByData(Date date);

	Attivita findOne(Long id);

}

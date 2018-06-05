package it.uniroma3.spring.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Azienda;
import it.uniroma3.spring.model.Centro;

public interface AziendaRepository extends CrudRepository<Azienda, Long>{

	Azienda findByNome(String nome);

	Azienda findbyCentro(Centro centro);
	

	
}

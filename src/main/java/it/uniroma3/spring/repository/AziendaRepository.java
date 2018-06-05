package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Azienda;

public interface AziendaRepository extends CrudRepository<Azienda, Integer>{

	public Azienda findByNome(String nome);

	public List<Azienda>findAll();

	public Azienda findById(int id);


		
	
	
	
	
	
	
}

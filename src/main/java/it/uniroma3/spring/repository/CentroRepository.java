package it.uniroma3.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Azienda;
import it.uniroma3.spring.model.Centro;

public interface CentroRepository extends CrudRepository<Centro, Long> {

	List<Centro> findByNome(String nome);

	List<Centro> findAll();

	Centro findById(Long id);
	
	void deleteByNome(String nome);
	void delete(Centro centro);
	void deleteById(Long id);
}

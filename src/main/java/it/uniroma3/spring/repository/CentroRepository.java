package it.uniroma3.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Centro;

public interface CentroRepository extends CrudRepository<Centro, Long> {
	

	
	


	List<Centro> findByNome(String nome);

	Centro findOne(Long id);

}

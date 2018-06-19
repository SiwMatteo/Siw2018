package it.uniroma3.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Azienda;
import it.uniroma3.spring.model.Centro;

public interface CentroRepository extends CrudRepository<Centro, Integer> {

	public List<Centro> findByNome(String nome);

	public List<Centro> findAll();

	void deleteByNome(String nome);

	void delete(Centro centro);

	void deleteById(Long id);

	public Centro findById(int id);

	public Centro findByEmail(String email);
}

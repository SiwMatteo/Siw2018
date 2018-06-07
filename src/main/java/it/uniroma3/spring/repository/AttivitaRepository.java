package it.uniroma3.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Attivita;
import it.uniroma3.spring.model.Centro;

public interface AttivitaRepository extends CrudRepository<Attivita, Long> {

	List<Attivita> findByNome(String nome);

	List<Attivita> findByDescrizione(String descrizione);

	List<Attivita> findByData(Date date);

	List<Attivita> findByCentro(Centro centro);

	Attivita findById(Long id);

	void deleteById(Long arg0);

	void deleteAll();

	void delete(Attivita attivita);

}

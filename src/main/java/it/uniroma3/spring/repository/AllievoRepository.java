package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Allievo;
import it.uniroma3.spring.model.Attivita;
import it.uniroma3.spring.model.Azienda;

public interface AllievoRepository extends CrudRepository<Allievo, String> {
	
	public List<Allievo> findByNome(String nome);

	public List<Allievo> findByCognome(String cognome);

	public Allievo findByCodiceFiscale(String codiceFiscale);

	public void deleteByCodiceFiscale(String codiceFiscale);
	
	public void delete(Allievo allievo);
	
	public List<Allievo> findByAzienda(Azienda azienda);
	
	public List<Allievo> findAll();
	
	public List<Allievo> findAllByAttivita(Attivita attivita);

}

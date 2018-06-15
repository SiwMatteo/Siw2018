package it.uniroma3.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Allievo;
import it.uniroma3.spring.model.Attivita;
import it.uniroma3.spring.model.Azienda;
import it.uniroma3.spring.repository.AllievoRepository;

@Service
@Transactional
public class AllievoService {

	@Autowired
	private AllievoRepository allievoRepository;

	public void save(Allievo allievo) {
		this.allievoRepository.save(allievo);
	}

	public List<Allievo> findbyNome(String nome) {
		return (List<Allievo>) this.allievoRepository.findByNome(nome);
	}

	public List<Allievo> findbyCognome(String cognome) {
		return (List<Allievo>) this.allievoRepository.findByCognome(cognome);
	}

	public Allievo findbyCodiceFiscale(String codiceFiscale) {
		return this.allievoRepository.findByCodiceFiscale(codiceFiscale);
	}

	public void deleteAllievo(Allievo allievo) {
		this.allievoRepository.delete(allievo);
	}

	public void deleteAllievoByCF(String codiceFiscale) {
		this.allievoRepository.deleteByCodiceFiscale(codiceFiscale);
	}

	public List<Allievo> findAll() {
		return this.allievoRepository.findAll();
	}

	public boolean alreadyExists(Allievo allievo) {
		List<Allievo> allievi = this.allievoRepository.findAll();
		boolean uno=false;
		for(Allievo all: allievi) {
			if(all.getCodiceFiscale().equals(allievo.getCodiceFiscale())) {
				uno=true;
			}
		}
		return uno;
	}

	public List<Allievo> findByAzienda(Azienda azienda) {

		return this.allievoRepository.findByAzienda(azienda);
	}

	public List<Allievo> findAllByAttivita(Attivita attivita) {
		
		return this.allievoRepository.findAllByAttivita(attivita);
	}
}

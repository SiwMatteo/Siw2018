package it.uniroma3.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Allievo;
import it.uniroma3.spring.model.Attivita;
import it.uniroma3.spring.model.Centro;
import it.uniroma3.spring.repository.AttivitaRepository;


@Service
public class AttivitaService {
	@Autowired
	private AttivitaRepository attivitaRepository;

	public List<Attivita> findAll() {
		return this.attivitaRepository.findAll();
	}

	@Transactional
	public void save(final Attivita attivita) {
		this.attivitaRepository.save(attivita);
	}

	public List<Attivita> findbyNome(String nome) {
		return this.attivitaRepository.findByNome(nome);
	}
	public Attivita findById(Long id) {
		return this.attivitaRepository.findOne(id);
	}

	public void deleteById(Long arg0) {
		this.attivitaRepository.delete(arg0);
	}

	public void deleteAll() {
		this.attivitaRepository.deleteAll();
	}
	
	public void delete(Attivita attivita) {
		this.attivitaRepository.delete(attivita);
	}

	public boolean alreadyExists(Attivita attivita) {
		List<Attivita> att = this.attivitaRepository.findByNomeAndData( attivita.getNome(), attivita.getData());
		if (att.size()!=0) {
			return true;
		}
		return false;
	}

	public List<Attivita> findByCentro(Centro centro) {
		// TODO Auto-generated method stub
		return attivitaRepository.findByCentro(centro);
	}



}

package it.uniroma3.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Attivita;
import it.uniroma3.spring.repository.AttivitaRepository;


@Service
public class AttivitaService {
	@Autowired
	private AttivitaRepository attivitaRepository;

	public Iterable<Attivita> findAll() {

		return this.attivitaRepository.findAll();
	}

	@Transactional
	public void add(final Attivita attivita) {
		this.attivitaRepository.save(attivita);
	}

	public List<Attivita> findbyNome(String nome) {
		return this.attivitaRepository.findByNome(nome);
	}
	public Attivita findbyId(Long id) {
		return this.attivitaRepository.findOne(id);
	}

	public void deleteById(Long arg0) {
		// TODO Auto-generated method stub

	}

	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}

package it.uniroma3.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Azienda;
import it.uniroma3.spring.repository.AziendaRepository;

@Service
@Transactional
public class AziendaService {
	
	@Autowired
	private AziendaRepository aziendaRepository;
	
	
	public void save(Azienda azienda) {
		this.aziendaRepository.save(azienda);
	}
	
	public Azienda findByNome(String nome) {
		return this.aziendaRepository.findByNome(nome);
	}

	public Azienda findById(Long id) {
		return this.aziendaRepository.findById(id);
	}
	
	public List<Azienda>findAll(){
		return this.aziendaRepository.findAll();
	}
}

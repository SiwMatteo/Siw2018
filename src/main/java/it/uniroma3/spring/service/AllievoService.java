package it.uniroma3.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Allievo;
import it.uniroma3.spring.repository.AllievoRepository;



@Service
@Transactional
public class AllievoService {

	@Autowired
	private AllievoRepository allievoRepository;

	@Transactional
	public void add(Allievo allievo) {
		this.allievoRepository.save(allievo);
	}

	public Allievo findbyCodiceFiscale(String codiceFiscale) {
		return this.allievoRepository.findByCodiceFiscale(codiceFiscale);
	}

}

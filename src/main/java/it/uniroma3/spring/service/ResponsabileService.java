package it.uniroma3.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Allievo;
import it.uniroma3.spring.model.Responsabile;
import it.uniroma3.spring.repository.ResponsabileRepository;

@Service
@Transactional
public class ResponsabileService {
	@Autowired
	private ResponsabileRepository responsabileRepository;

	@Transactional
	public void add(Allievo allievo) {
		this.responsabileRepository.save(allievo);
	}

	public Responsabile findOne(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}

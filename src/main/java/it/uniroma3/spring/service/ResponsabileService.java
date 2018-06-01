package it.uniroma3.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Responsabile;
import it.uniroma3.spring.repository.ResponsabileRepository;

@Service
@Transactional
public class ResponsabileService {
	
	@Autowired
	private ResponsabileRepository responsabileRepository;
	

	@Transactional
	public void add(Responsabile responsabile) {
		this.responsabileRepository.add(responsabile);
	}
	public Responsabile findyByEmail(String email) {
		return this.responsabileRepository.findByEmail(email);
		
	}
	public List<Responsabile> findByRuolo(String ruolo){
		return this.responsabileRepository.findByRuolo(ruolo);
	}
}

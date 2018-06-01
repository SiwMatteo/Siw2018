package it.uniroma3.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Centro;
import it.uniroma3.spring.repository.CentroRepository;


@Service
public class CentroService {

	@Autowired
	CentroRepository centroRepository;

	public Iterable<Centro> findAll() {

		return this.centroRepository.findAll();
	}

	@Transactional
	public void add(final Centro centro) {
		this.centroRepository.save(centro);
	}

	public Centro findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}

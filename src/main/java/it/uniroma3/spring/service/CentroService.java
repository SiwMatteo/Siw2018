package it.uniroma3.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Centro;
import it.uniroma3.spring.repository.CentroRepository;

@Service
@Transactional
public class CentroService {

	@Autowired
	CentroRepository centroRepository;

	public List<Centro> findAll() {

		return this.centroRepository.findAll();
	}

	public void save(final Centro centro) {
		this.centroRepository.save(centro);
	}

	public List<Centro> centriByNome(String nome) {
		return (List<Centro>) this.centroRepository.findByNome(nome);
	}

	public void deleteCentroByNome(String nome) {
		this.centroRepository.deleteByNome(nome);
	}

	public void deleteCentro(Centro centro) {
		this.centroRepository.delete(centro);
	}

	public void deleteCentroById(Long id) {
		this.centroRepository.deleteById(id);
	}
	
	public Centro findById(Long id) {
		return this.centroRepository.findById(id);
	}
}

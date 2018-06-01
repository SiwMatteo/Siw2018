package it.uniroma3.spring.service;

import java.util.Optional;

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

	public Optional<Allievo> findById(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<Allievo> findAllById(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Transactional
	public void add(final Allievo allievo) {
		this.allievoRepository.save(allievo);
	}

	public Allievo findbyCodiceFiscale(String codiceFiscale) {
		return this.allievoRepository.findByCodiceFiscale(codiceFiscale);
	}

	public boolean existsById(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void deleteById(Long arg0) {
		// TODO Auto-generated method stub

	}

	public void deleteAll(Iterable<? extends Allievo> arg0) {
		// TODO Auto-generated method stub

	}

	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	public void delete(Allievo arg0) {
		// TODO Auto-generated method stub

	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public <S extends Allievo> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Allievo> Iterable<S> saveAll(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}

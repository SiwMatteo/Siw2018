package it.uniroma3.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.spring.model.Attivita;
import it.uniroma3.spring.service.AttivitaService;

@RestController
public class AttivitaRestController {

	@Autowired
	AttivitaService attivitaService;

	@RequestMapping("/rest/attivita/{id}")
	public Attivita getAllievo(@PathVariable Long id) {
		return attivitaService.findById(id);
	}
}

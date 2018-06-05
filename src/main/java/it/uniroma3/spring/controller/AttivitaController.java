package it.uniroma3.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.spring.model.Attivita;
import it.uniroma3.spring.service.AttivitaService;

@Controller
public class AttivitaController {

	@Autowired
	AttivitaService attivitaService;

	@RequestMapping("/rest/attivita/{id}")
	public Attivita getAllievo(@PathVariable Long id) {
		return attivitaService.findById(id);
	}
}

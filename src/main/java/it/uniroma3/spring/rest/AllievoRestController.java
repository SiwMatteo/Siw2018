package it.uniroma3.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.spring.model.Allievo;
import it.uniroma3.spring.service.AllievoService;
@RestController
public class AllievoRestController {
	
	
		@Autowired
		AllievoService allievoService;

		@RequestMapping("/rest/allievo/{id}")
		public Allievo getAllievo(@PathVariable String codiceFiscale) {
			return allievoService.findbyCodiceFiscale(codiceFiscale);
		}

	}

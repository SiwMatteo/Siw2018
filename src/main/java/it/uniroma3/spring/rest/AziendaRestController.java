package it.uniroma3.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.spring.model.Azienda;
import it.uniroma3.spring.service.AziendaService;

@RestController
public class AziendaRestController {
	
	@Autowired
	private AziendaService aziendaService;
	

    @RequestMapping("/rest/azienda/{id}")
    public Azienda getAzienda(@PathVariable Long id) {
        return aziendaService.findById(id);
    

}

}
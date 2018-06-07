package it.uniroma3.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.spring.model.Azienda;
import it.uniroma3.spring.service.AziendaService;

@Controller
public class AziendaController {
	
	@Autowired
	private AziendaService aziendaService;
	

    @RequestMapping("/rest/azienda/{id}")
    public Azienda getAzienda(@PathVariable int id) {
        return aziendaService.findById(id);
    

}

}
package it.uniroma3.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.spring.model.Responsabile;
import it.uniroma3.spring.service.ResponsabileService;

@Controller
public class ResponsabileController {
	@Autowired
	ResponsabileService responsabileService;
	
    @RequestMapping("/rest/responsabile/{id}")
    public Responsabile getResponsabile(@PathVariable String email) {
        return responsabileService.findByEmail(email);

}
}
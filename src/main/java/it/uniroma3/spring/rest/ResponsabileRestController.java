package it.uniroma3.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.spring.model.Responsabile;
import it.uniroma3.spring.service.ResponsabileService;

@RestController
public class ResponsabileRestController {
	@Autowired
	ResponsabileService responsabileService;
	
    @RequestMapping("/rest/responsabile/{id}")
    public Responsabile getResponsabile(@PathVariable String email) {
        return responsabileService.findByEmail(email);

}
}
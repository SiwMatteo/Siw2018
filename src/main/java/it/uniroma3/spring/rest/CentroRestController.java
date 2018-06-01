package it.uniroma3.spring.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.spring.model.Centro;
import it.uniroma3.spring.service.CentroService;


@RestController
public class CentroRestController {
	@Autowired
	CentroService centroService;
	
    @RequestMapping("/rest/centro/{id}")
    public Centro getCentro(@PathVariable Long id) {
        return centroService.findOne(id);
    

}
}
package it.uniroma3.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.spring.model.Centro;
import it.uniroma3.spring.service.CentroService;


@Controller
public class CentroController {
	@Autowired
	CentroService centroService;
	
    @RequestMapping("/rest/centro/{id}")
    public Centro getCentro(@PathVariable int id) {
        return centroService.findById(id);
    

}
}
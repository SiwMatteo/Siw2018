package it.uniroma3.spring.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.spring.model.Allievo;
import it.uniroma3.spring.model.Centro;
import it.uniroma3.spring.service.CentroService;
import it.uniroma3.spring.validator.CentroValidator;

@Controller
public class CentroController {
	
	@Autowired
	CentroService centroService;
	@Autowired
	CentroValidator centroValidator;

	@RequestMapping("/rest/centro/{id}")
	public Centro getCentro(@PathVariable int id) {
		return centroService.findById(id);

	}
	
	@RequestMapping("/centri")
	public String allievi(Model model, HttpSession session) {
		model.addAttribute("centri", this.centroService.findAll());
		return "centriList";

	}

	@RequestMapping("/addCentro")
	public String addAllievo(Model model, HttpSession session) {

		Centro centro = new Centro();	
		
		model.addAttribute("centro1", centro);
		return "centroForm";
	}
	
	@RequestMapping(value = "/centro", method = RequestMethod.POST)
	public String verificaAllievo(@Valid @ModelAttribute("centro1") Centro centro, HttpSession session,
			BindingResult bindingResult, Model model) {

		this.centroValidator.validate(centro, bindingResult);
		System.out.println(centro.getNome());

		if (this.centroService.alreadyExists(centro)) {
			model.addAttribute("centroExists", "Questo centro è già stato registrato");
			return "centroForm";

		} else {
			if (!bindingResult.hasErrors()) {

				session.setAttribute("centro", centro);

				return "verificaCentro";
			}
		}
		return "centroForm";

	}
	
	@RequestMapping(value = "/newCentro", method = RequestMethod.GET)
	public String newCentro(HttpSession session, Model model) {

		Centro all = (Centro) session.getAttribute("centro");

		centroService.save(all);

		return "pagina-iniziale-azienda";
	}
}
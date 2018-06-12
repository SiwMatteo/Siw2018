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

import it.uniroma3.spring.model.Attivita;
import it.uniroma3.spring.model.Azienda;
import it.uniroma3.spring.service.AttivitaService;
import it.uniroma3.spring.service.AziendaService;
import it.uniroma3.spring.service.CentroService;
import it.uniroma3.spring.validator.AttivitaValidator;

@Controller
public class AttivitaController {

	@Autowired
	CentroService centroService;
	@Autowired
	AttivitaService attivitaService;
	@Autowired
	AttivitaValidator attivitaValidator;
	@Autowired
	AziendaService aziendaService;

	@RequestMapping("/attivita")
	public String allievi(Model model, HttpSession session) {
		model.addAttribute("attivita", this.attivitaService.findAll());
		return "attivitaList";

	}

	@RequestMapping("/addAttivita")
	public String addAttivita(Model model, HttpSession session) {

		Azienda azienda = aziendaService.findById(1);
		Attivita attivita = new Attivita();

		model.addAttribute("attivita1", attivita);
		return "attivitaForm";
	}

	@RequestMapping(value = "/rest/attivita/{id}", method = RequestMethod.GET)
	public String getAttivita(@PathVariable Long id, Model model, HttpSession session) {
		model.addAttribute("attivita1", attivitaService.findById(id));
		return "attivita";
	}

	@RequestMapping(value = "/attivita", method = RequestMethod.POST)
	public String newAttivita(@Valid @ModelAttribute("attivita1") Attivita attivita, HttpSession session,
			BindingResult bindingResult, Model model) {

		this.attivitaValidator.validate(attivita, bindingResult);
		System.out.println(attivita.getNome());
		if (this.attivitaService.alreadyExists(attivita)) {
			model.addAttribute("exists", "Attivita already exists");
			return "attivitaForm";
		} else {
			if (!bindingResult.hasErrors()) {

				this.attivitaService.save(attivita);
				model.addAttribute("attivita", this.attivitaService.findAll());
				return "attivitaList";
			}
		}
		return "attivitaForm";
	} 

}

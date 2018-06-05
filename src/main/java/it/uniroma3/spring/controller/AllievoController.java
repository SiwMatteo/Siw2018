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
import it.uniroma3.spring.model.Azienda;
import it.uniroma3.spring.service.AllievoService;
import it.uniroma3.spring.service.AziendaService;
import it.uniroma3.spring.service.CentroService;
import it.uniroma3.spring.validator.AllievoValidator;

@Controller
public class AllievoController {

	@Autowired
	CentroService centroService;
	@Autowired
	AllievoService allievoService;
	@Autowired
	AllievoValidator validator;

	@Autowired
	AziendaService aziendaService;

	@RequestMapping("/allievi")
	public String allievi(Model model, HttpSession session) {
		model.addAttribute("allievi", this.allievoService.findAll());
		return "allieviList";

	}

	@RequestMapping("/addAllievo")
	public String addAllievo(Model model, HttpSession session) {
		

;
		Azienda azienda=aziendaService.findById(1);
		Allievo allievo=new Allievo();
		
		model.addAttribute("allievo1",  allievo);
		return "allievoForm";
	}

	@RequestMapping(value = "/rest/allievo/{codiceFiscale}", method = RequestMethod.GET)
	public String getAllievo(@PathVariable String codiceFiscale, Model model, HttpSession session) {
		model.addAttribute("allievo1", allievoService.findbyCodiceFiscale(codiceFiscale));
		return "allievo";
	}

	@RequestMapping(value="/allievo",method=RequestMethod.POST )
	public String newAllievo(@Valid@ModelAttribute("allievo1")Allievo allievo,HttpSession session,BindingResult bindingResult , Model model
			) {
		
		this.validator.validate(allievo, bindingResult);
		System.out.println(allievo.getNome());
		if (this.allievoService.alreadyExists(allievo)) {
			model.addAttribute("exists", "Allievo already exists");
			return "allievoForm";
		} else {
			if (!bindingResult.hasErrors()) {

				this.allievoService.save(allievo);
				model.addAttribute("allievi", this.allievoService.findAll());
				return "allieviList";
			}
		}
		return "allievoForm";
	}

}

package it.uniroma3.spring.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.spring.model.Allievo;
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
	AllievoValidator allievoValidator;
	@Autowired
	AziendaService aziendaService;

	@GetMapping("/allievi")
	public String allievi(Model model, HttpSession session) {
		model.addAttribute("allievi", this.allievoService.findAll());
		return "allieviList";

	}

	@GetMapping("/addAllievo")
	public String addAllievo(Model model, HttpSession session) {

		Allievo allievo = new Allievo();

		model.addAttribute("allievo1", allievo);
		return "allievoForm";
	}

	@RequestMapping(value = "/rest/allievo/{codiceFiscale}", method = RequestMethod.GET)
	public String getAllievo(@PathVariable String codiceFiscale, Model model, HttpSession session) {
		model.addAttribute("allievo1", allievoService.findbyCodiceFiscale(codiceFiscale));
		return "allievo";
	}

	@RequestMapping(value = "/allievo", method = RequestMethod.POST)
	public String verificaAllievo(@Valid @ModelAttribute("allievo1") Allievo allievo, HttpSession session,
			BindingResult bindingResult, Model model) {

		this.allievoValidator.validate(allievo, bindingResult);
		System.out.println(allievo.getNome());

		if (this.allievoService.alreadyExists(allievo)) {
			model.addAttribute("allievoExists", "Questo allievo è già stato registrato");
			return "allievoForm";

		} else {
			if (!bindingResult.hasErrors()) {

				session.setAttribute("allievo", allievo);

				return "verificaAllievo";
			}
		}
		return "allievoForm";

	}

	@RequestMapping(value = "/newAllievo", method = RequestMethod.GET)
	public String newAllievo(HttpSession session, Model model) {

		Allievo all = (Allievo) session.getAttribute("allievo");

		allievoService.save(all);

		return "pagina-iniziale-centro";
	}
}

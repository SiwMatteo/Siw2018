package it.uniroma3.spring.controller;

import java.util.ArrayList;
import java.util.List;

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
import it.uniroma3.spring.model.Attivita;
import it.uniroma3.spring.model.Centro;
import it.uniroma3.spring.model.Responsabile;
import it.uniroma3.spring.service.AllievoService;
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
	@Autowired
	AllievoService allievoService;

	@GetMapping("/attivita")
	public String attivita(Model model, HttpSession session) {
		model.addAttribute("attivita", this.attivitaService.findAll());
		return "attivitaList";

	}

	@RequestMapping("/addAttivita")
	public String addAttivita(Model model, HttpSession session) {

		Responsabile res = (Responsabile) session.getAttribute("responsabile");
	
		Attivita attivita = new Attivita();
		
		model.addAttribute("attivita1", attivita);
		return "attivitaForm";
	}

	@RequestMapping(value = "/attivita/{id}", method = RequestMethod.GET)
	public String getAttivita(@PathVariable("id") Long id, Model model, HttpSession session) {

		Attivita att = attivitaService.findById(id);
		session.setAttribute("attivitaB", att);
		List<Allievo> allievi = AllieviNotAttivita(att);
		model.addAttribute("allievi", allievi);
		return "allievo-attivita";
	}

	@RequestMapping(value = "/attivita", method = RequestMethod.POST)
	public String controllaAttivita(@Valid @ModelAttribute("attivita1") Attivita attivita, HttpSession session,
			BindingResult bindingResult, Model model) {

		this.attivitaValidator.validate(attivita, bindingResult);

		if (this.attivitaService.alreadyExists(attivita)) {
			model.addAttribute("attivitaExists", "Questa attività è già presente");
			return "attivitaForm";
		} else {
			if (!bindingResult.hasErrors()) {
			
				session.setAttribute("attivita", attivita);
				return "verificaAttivita";
			}
		}
		return "attivitaForm";
	}

	@RequestMapping(value = "/newAttivita", method = RequestMethod.GET)
	public String newAttivita(HttpSession session, Model model) {
		Attivita att = (Attivita) session.getAttribute("attivita");
		Responsabile re=(Responsabile)session.getAttribute("responsabileCentro");

	
		Centro c1=re.getCentro();
		att.setCentro(c1);
		this.attivitaService.save(att);
		return "/pagina-iniziale-centro";
	}

	

	@RequestMapping("/addAllievoAttivita")
	public String allieviAttivita(Model model, HttpSession session) {
		session.setAttribute("attivita1", this.attivitaService.findAll());

		return "iscrizioneAdAttivita";

	}

	@RequestMapping(value = "/attivita/attivitaAllievo/{codiceFiscale}", method = RequestMethod.GET)
	public String getAttivitaAllievo(@PathVariable("codiceFiscale") String codiceFiscale, Model model,
			HttpSession session) {
		Attivita att = (Attivita) session.getAttribute("attivitaB");
		List<Allievo> allievi = att.getAllievi();
		if (allievi == null) {
			allievi = new ArrayList();
			allievi.add(allievoService.findbyCodiceFiscale(codiceFiscale));
			att.setAllievi(allievi);
			attivitaService.save(att);
		}
		att.getAllievi().add((Allievo) allievoService.findbyCodiceFiscale(codiceFiscale));
		attivitaService.save(att);

		return "conferma-iscrizione";
	}

	public List<Allievo> AllieviNotAttivita(Attivita attivita) {
		List<Allievo> all = allievoService.findAll();
		List<Allievo> all1 = allievoService.findAllByAttivita(attivita);
		List<Allievo> allievi = new ArrayList();
		for (Allievo allievo : all) {
			if (!all1.contains(allievo)) {
				allievi.add(allievo);
			}
		}

		return allievi;

	}
	@RequestMapping(value = "/deleteAttivita/attivitaDelete/{id}", method = RequestMethod.GET)
	public String deleteAttivita(@PathVariable("id") Long id, Model model, HttpSession session) {
		Attivita att = attivitaService.findById(id);
		attivitaService.delete(att);
		return "/pagina-iniziale-centro";
	}

	@RequestMapping("/deleteAttivita")
	public String removeAttivita(Model model, HttpSession session) {
		Responsabile res = (Responsabile) session.getAttribute("responsabileCentro");
		Centro centro = res.getCentro();
		session.setAttribute("attivitaDel", attivitaService.findByCentro(centro));
		return "lista-attivita-da-eliminare";
	}
}

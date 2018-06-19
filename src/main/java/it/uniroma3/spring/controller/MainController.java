package it.uniroma3.spring.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.spring.model.Centro;
import it.uniroma3.spring.model.Responsabile;
import it.uniroma3.spring.service.CentroService;
import it.uniroma3.spring.service.ResponsabileService;

// controller to access the login page
@Controller

public class MainController {
	@Autowired
	private ResponsabileService responsabileService;

	@Autowired
	private CentroService centroService;

	// Login form
	@RequestMapping("/")
	public String Page(HttpSession session) {
		return "index";
	}

	// Login form with error
	@RequestMapping("/login")
	public String Login(Model model,HttpSession session) {
		Responsabile r = new Responsabile();
		model.addAttribute("responsabile", r);
		return "login";
	}
	
	@RequestMapping("/logout")
	public String Login(HttpSession session) {
		session.setAttribute("responsabile", null);
		return "login";
	}

	@RequestMapping("/info")
	public String PageInfo() {
		return "info";
	}
	
	@RequestMapping("/pagina-iniziale-centro")
	public String PageCentro() {
		return "pagina-iniziale-centro";
	}
	
	@RequestMapping("/pagina-iniziale-azienda")
	public String PageAzienda() {
		return "pagina-iniziale-azienda";
	}

	@RequestMapping("/processlogin")
	public String ProcessLogin(@Valid @ModelAttribute("responsabile") Responsabile responsabile,
			BindingResult theBidingResult, Model model, HttpSession session) {

		if (theBidingResult.hasErrors()) {
			return "login";
		} else {
			try {
				Responsabile res = responsabileService.findByEmail(responsabile.getEmail());
			
				if (responsabile.getPassword().equals(res.getPassword())) {
					if (res.getRuolo().equals("direttore")) {
						session.setAttribute("responsabileAzienda", res);
						
						return "pagina-iniziale-azienda";

					}else {
						System.out.println("ho aggiunto l'oggetto");
						session.setAttribute("responsabileCentro", res);;
					}

					session.setAttribute("centro", responsabile.getCentro());
					return "pagina-iniziale-centro";

				} else
					return "login";

			} catch (Exception e) {
				model.addAttribute("errMail", "la mail inserita risulta sbagliata");
				return "login";
			}
		}

	}

}
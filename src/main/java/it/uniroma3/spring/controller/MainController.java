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

	@RequestMapping("/info")
	public String PageInfo() {
		return "info";
	}

	@RequestMapping("/processlogin")
	public String ProcessLogin(@Valid @ModelAttribute("responsabile") Responsabile responsabile,
			BindingResult theBidingResult, Model model, HttpSession session) {

		if (theBidingResult.hasErrors()) {
			return "login";
		} else {
			try {
				Responsabile c = responsabileService.findByEmail(responsabile.getEmail());
				System.out.println(c.getEmail());
				System.out.println(c.getPassword());
				Centro centro = c.getCentro();
				
				if (responsabile.getPassword().equals(c.getPassword())) {
					if (c.getRuolo().equals("direttore")) {
						session.setAttribute("responsabileAzienda", responsabile);
						return "pagina-iniziale-azienda";

					} else
						session.setAttribute("responsabileCentro", responsabile);

					session.setAttribute("centro", centro);
					return "pagina-iniziale-centro";

				} else
					model.addAttribute("errPassw", "la password inserita risulta sbagliata");
				return "login";

			} catch (Exception e) {
				model.addAttribute("errMail", "la mail inserita risulta sbagliata");
				return "login";
			}
		}

	}

}
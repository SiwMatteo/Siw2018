package it.uniroma3.spring;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import it.uniroma3.spring.model.Centro;
import it.uniroma3.spring.model.Responsabile;
import it.uniroma3.spring.service.AllievoService;
import it.uniroma3.spring.service.AziendaService;
import it.uniroma3.spring.service.CentroService;
import it.uniroma3.spring.service.ResponsabileService;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

	@Autowired
	private ResponsabileService responsabileService;
	@Autowired
	private CentroService centroService;
	@Autowired
	private AziendaService aziendaService;
	@Autowired
	private AllievoService allievoService;

	@PostConstruct
	public void inserisci() {
		
		Centro centroA = new Centro();
		centroA.setNome("A");

		Responsabile resp = new Responsabile();
		resp.setEmail("direttore@prova.it");
		resp.setNome("Matteo");
		resp.setCognome("rossi");
		resp.setRuolo("direttore");
		resp.setPassword("prova1");
		
		Responsabile rocco = new Responsabile();
		rocco.setEmail("rocco.b@prova.it");
		rocco.setNome("Rocco");
		rocco.setCognome("Bruni");
		rocco.setRuolo("manager");
		rocco.setPassword("rocco");

		responsabileService.save(resp);
		responsabileService.save(rocco);
		
		

	}

}

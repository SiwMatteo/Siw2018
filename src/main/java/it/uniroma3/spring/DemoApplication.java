package it.uniroma3.spring;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

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
		
		Responsabile res=new Responsabile();
		res.setEmail("prova2@prova.it");
		res.setPassword("prova");
		res.setNome("matteo");
		res.setCognome("forgione");
		res.setRuolo("manager");
		responsabileService.save(res);
		

	}

}

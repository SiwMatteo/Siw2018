package it.uniroma3.spring;

import java.sql.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import it.uniroma3.spring.model.Allievo;
import it.uniroma3.spring.model.Azienda;
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
		Azienda azienda = aziendaService.findById(1);
		Allievo allievo = new Allievo();
		allievo.setCodiceFiscale("sxzdvcvzczv");
		allievo.setNome("matteo");
		allievo.setCognome("desantis");
		allievo.setDataDiNascita(new Date(11 - 11 - 2019));
		allievo.setAzienda(azienda);
		allievo.setLuogoDiNascita("priverno");
		allievo.setTelefono("1223445");

		allievoService.save(allievo);

		Responsabile responsabile = new Responsabile();
		responsabile.setNome("Luca");
		responsabile.setCognome("Molinari");
		responsabile.setEmail("prova1@prova.it");
		responsabile.setAzienda(azienda);
		responsabile.setPassword("prova");
		responsabile.setRuolo("manager");

		responsabileService.save(responsabile);

	}

}

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
	Azienda azienda=aziendaService.findById(1);
		Allievo allievo=new Allievo();
		allievo.setCodiceFiscale("sxzdvcvzczv");
		allievo.setNome("matteo");
		allievo.setCognome("desantis");
		allievo.setDataNascita(new Date(11-11-2019));
		allievo.setAzienda(azienda);
		allievo.setLuogoNascita("priverno");
		allievo.setTelefono(1223445);
		
		allievoService.save(allievo);
	
		
		
	
	}

}

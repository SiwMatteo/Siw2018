package it.uniroma3.spring;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import it.uniroma3.spring.model.Attivita;
import it.uniroma3.spring.model.Azienda;
import it.uniroma3.spring.model.Centro;
import it.uniroma3.spring.model.Responsabile;
import it.uniroma3.spring.service.ResponsabileService;



@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }
    
  @Autowired
  private ResponsabileService responsabileService;
  
  @PostConstruct
  public void inserisci() {
	  Responsabile responsabile=new Responsabile();
	  Responsabile responsabile1=new Responsabile();
	  responsabile.setEmail("prova@prova.it");
	  responsabile.setPassword("prova");
	  responsabile.setNome("Matteo");
	  responsabile.setCognome("De Santis");
	  responsabile.setRuolo("direttore");
	  responsabile.setNumero(1223445);
	    
	  responsabile1.setEmail("prova1@prova.it");
	  responsabile1.setPassword("prova1");
	  responsabile1.setNome("Francesco");
	  responsabile1.setCognome("De Santis");
	  responsabile1.setRuolo("responsabile");
	  responsabile1.setNumero(1223445);
	  
	  Azienda azienda=new Azienda();
	  azienda.setEmail("azienda@azienda.it");
	  azienda.setIndirizzo("via prova 1");
	  azienda.setNome("Azienda prova");
	  azienda.setResponsabile(responsabile);

	  responsabile.setAzienda(azienda);
	  
	  Centro centro= new Centro();
	  centro.setEmail("centro@azienda.it");
	  centro.setIndirizzo("via prova 2");
	  centro.setNome("Centro");
	  List<Responsabile> r=new ArrayList<>();
	  centro.setResponsabili(r);
	  centro.AggiungiResponsabile(responsabile1);
	  List<Attivita>a= new ArrayList();
	  centro.setAttivita(a);

	  responsabile1.setCentro(centro);
	  
	  
	  responsabileService.add(responsabile);
	  responsabileService.add(responsabile1);
  }
  
  
  
    }

    	

    
   

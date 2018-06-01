package it.uniroma3.spring;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

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
    public void prova(){
  
  
    }

    	

    
   
}
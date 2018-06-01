package it.uniroma3.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import it.uniroma3.spring.security.PasswordCrypt;

@Entity
public class Responsabile {

	@Id
	@Column(nullable = false)
	@NotNull(message = "e richiesto")
	@Size(min = 1, message = "e richiesto")
	private String email;

	@NotNull(message = "e richiesto")
	@Size(min = 1, message = "erichiesto")
	@Column(nullable = false)
	private String password;

	@Column
	private String nome;

	@Column
	private String cognome;

	@Column
	private Integer numero;

	@Column(nullable = false)
	private String ruolo;
	@ManyToOne
	private Centro centro;
	
	
	
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {

		this.email = email;
	}

	public String getPassword() {
	
		
		return password;
	}

	public void setPassword(String password) {
		PasswordCrypt pcry=new PasswordCrypt();
		if(password.equals(""))
			this.password= null;
		else
		this.password = pcry.encryptPassword(password);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}

}

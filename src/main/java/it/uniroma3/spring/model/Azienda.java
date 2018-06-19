package it.uniroma3.spring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Azienda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String indirizzo;

	@Column(nullable = false)
	private String email;

	@OneToMany(mappedBy="azienda")
	private List<Centro> centri;

	@ManyToMany(mappedBy="azienda")
	private List<Allievo> allievi;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Centro> getCentri() {
		return centri;
	}

	public void setCentri(List<Centro> centri) {
		this.centri = centri;
	}

	
	public void AggiungiCentro(Centro centro) {
	this.centri.add(centro)	;
	}

	public List<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}
	
	
	}


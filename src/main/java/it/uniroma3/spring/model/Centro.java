package it.uniroma3.spring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Centro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String nome;

	@Column
	private String indirizzo;

	@Column
	private String email;

	@OneToMany(mappedBy = "centro")
	private List<Responsabile> responsabili;

	@ManyToOne
	private Azienda azienda;

	@OneToMany(mappedBy = "azienda")
	private List<Allievo> allievi;

	@OneToMany(mappedBy = "centro")
	private List<Attivita> attivita;

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

	public List<Responsabile> getResponsabili() {
		return responsabili;
	}

	public void setResponsabili(List<Responsabile> responsabili) {
		this.responsabili = responsabili;
	}

	public List<Attivita> getAttivita() {
		return attivita;
	}

	public void setAttivita(List<Attivita> attivita) {
		this.attivita = attivita;
	}

	public void AggiungiResponsabile(Responsabile res) {
		this.responsabili.add(res);
	}

	public void AggiungiAttivita(Attivita attivita) {
		this.attivita.add(attivita);
	}

	public List<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}

	public Azienda getAzienda() {
		return azienda;
	}

	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}

}

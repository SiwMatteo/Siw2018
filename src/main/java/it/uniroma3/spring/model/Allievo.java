package it.uniroma3.spring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Allievo {

	@Id
	@Column (unique = true, nullable = false)
	private String codiceFiscale;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cognome;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataDiNascita;

	@Column(nullable = false)
	private String luogoDiNascita;

	@Column(nullable = false)
	private String telefono;

	@ManyToOne
	private Azienda azienda;
	
	@ManyToMany(mappedBy="allievi",fetch=FetchType.EAGER)
	private List<Attivita> attivita;
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
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

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataNascita) {
		this.dataDiNascita = dataNascita;
	}

	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoNascita) {
		this.luogoDiNascita = luogoNascita;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Azienda getAzienda() {
		return azienda;
	}

	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}

	public List<Attivita> getAttivita() {
		return attivita;
	}

	public void setAttivita(List<Attivita> attivita) {
		this.attivita = attivita;
	}
@Override
public boolean equals(Object o) {
	Allievo allievo=(Allievo)o;
	return this.getCodiceFiscale().equals(allievo.getCodiceFiscale());
}
@Override
public int hashCode() {
	return this.getCodiceFiscale().hashCode();
}
}

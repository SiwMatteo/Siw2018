package it.uniroma3.spring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Centro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(nullable=false)
	private String nome;

	@Column
	private String indirizzo;
	
	@Column
	private String email;
	
	@OneToMany(mappedBy="centro")
	private List<Responsabile> responsabili;
	
	@ManyToOne
	private Azienda azienda;
	

	@OneToMany
	private List<Attivita> attivita;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attivita == null) ? 0 : attivita.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((indirizzo == null) ? 0 : indirizzo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((responsabili == null) ? 0 : responsabili.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Centro other = (Centro) obj;
		if (attivita == null) {
			if (other.attivita != null)
				return false;
		} else if (!attivita.equals(other.attivita))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (responsabili == null) {
			if (other.responsabili != null)
				return false;
		} else if (!responsabili.equals(other.responsabili))
			return false;
		return true;
	}
	
	
	
}

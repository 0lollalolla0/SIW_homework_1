package it.uniroma3.siw.hw1.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Societa {
	
	@Id
	private Long id;
	
	@Column(nullable=false)
	private String ragioneSociale;
	
	@Column(nullable=false)
	private String numeroTelefono;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	//Quando faccio la persist della Societa lo voglio fare anche del suo indirizzo
	//E quando rimuovo una societa' non ha senso mantenere il suo indirizzo
	private Indirizzo indirizzo;
	
	public Societa() {}
	
	public Societa(Long id, String ragioneSociale, String numeroTelefono, Indirizzo indirizzo) {
		this.id = id;
		this.ragioneSociale = ragioneSociale;
		this.numeroTelefono = numeroTelefono;
		this.indirizzo = indirizzo;
	}

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getRagioneSociale() { return ragioneSociale; }

	public void setRagioneSociale(String ragioneSociale) { this.ragioneSociale = ragioneSociale; }

	public String getNumeroTelefono() { return numeroTelefono; }

	public void setNumeroTelefono(String numeroTelefono) { this.numeroTelefono = numeroTelefono; }

	public Indirizzo getIndirizzo() { return indirizzo; }

	public void setIndirizzo(Indirizzo indirizzo) { this.indirizzo = indirizzo; }
}

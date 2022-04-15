package it.uniroma3.siw.hw1.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Allievo {
	@Id
	private String matricola;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String cognome;
	
	private LocalDate dataDiNascita;
	
	@ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	//Per la stessa ragione spiegata nella classe Societa
	private Indirizzo luogoDiNascita;
	
	private String email;
	
	@ManyToMany(mappedBy="allieviIscritti")
	private List<Corso> corsi;
	
	@ManyToOne
	private Societa societa;
	
	public Allievo() {}
	
	public Allievo(String matricola, String nome, String cognome) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
	}

	public LocalDate getDataDiNascita() { return dataDiNascita; }

	public void setDataDiNascita(LocalDate dataDiNascita) { this.dataDiNascita = dataDiNascita; }

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }
	
	public Indirizzo getLuogoDiNascita() { return luogoDiNascita; }

	public void setLuogoDiNascita(Indirizzo luogoDiNascita) { this.luogoDiNascita = luogoDiNascita; }
	
	public void setSoceta(Societa societa) { this.societa = societa; }
	
	public Societa getSocieta() { return this.societa; }
	
	public void addCorso(Corso corso) { this.corsi.add(corso); }
	
	public List<Corso> getCorsi() { return this.corsi; }
}
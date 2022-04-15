package it.uniroma3.siw.hw1.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Docente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String cognome;
	
	private LocalDate dataDiNascita;
	
	@ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	//Per la stessa ragione spiegata nella classe Societa
	private Indirizzo luogoDiNascita;
	
	@Column(nullable=false)
	private Long IVA;
	
	@OneToMany (mappedBy="docente", fetch = FetchType.EAGER)
	//Quando chiediamo informazioni su un docente e' sottinteso che vogliamo sapere di cosa e' docente. Inoltre, essendo i corsi
	//erogati da un docente un numero relativamente piccolo, non avremo grosse differenze di prestazioni ponendo la politica EAGER
    private List<Corso> corsi;
	
	public Docente() {}
	
	public Docente(String nome, String cognome, Long IVA) {
		this.nome = nome;
		this.cognome = cognome;
		this.IVA = IVA;
	}

	public LocalDate getDataDiNascita() { return dataDiNascita; }

    public void setDataDiNascita(LocalDate dataDiNascita) { this.dataDiNascita = dataDiNascita; }

	public Indirizzo getLuogoDiNascita() { return luogoDiNascita; }

	public void setLuogoDiNascita(Indirizzo luogoDiNascita) { this.luogoDiNascita = luogoDiNascita; }
	
	public List<Corso> getCorsi() { return this.corsi; }
	
	public void AddCorso(Corso corso) { this.corsi.add(corso); }
}

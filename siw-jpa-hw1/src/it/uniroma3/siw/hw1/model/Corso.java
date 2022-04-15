package it.uniroma3.siw.hw1.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Corso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codiceCorso;
	
	@Column(nullable=false)
	private LocalDate inizio;
	
	@Column(nullable=false)
	private Integer mesiDiDurata;
	
	@ManyToMany
	private List<Allievo> allieviIscritti;
	
	@ManyToOne
	private Docente docente;
	
	public Corso() {};
	
	public Corso(LocalDate inizio, Integer mesiDiDurata, Docente docente) {
		this.inizio = inizio;
		this.mesiDiDurata = mesiDiDurata;
		this.docente = docente;
	}
}

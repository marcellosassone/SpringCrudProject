package com.begear.model;
 
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name="studente")
public class StudenteH 
{
	 @Id
	 @Column(name="matricola")
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private int matricola;
	 
	 @Column(name="nome")
	 private String nome;
	
	 @Column(name="cognome")
	 private String cognome;
	
	 @Column(unique = true, name="cf")
	 private String cf;
	
	 /*
	 @ElementCollection
	 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 @JoinTable(name = "segue", catalog = "dbcorsi", joinColumns = {
	   @JoinColumn(name = "matricola", nullable = false, updatable = false) },
	   inverseJoinColumns = { @JoinColumn(name = "idcorso",
	     nullable = false, updatable = false) })
	 */
	 
	 
	 
	 // NOTA BENE: LA PARTE SOTTO E' DA MODIFICARE: AL MOMENTO NON VA BENE, PERCHE' IN CASO DI INSERIMENTO STUDENTE CON CORSO, 
	 // ELIMINA TUTTI I CORSI DAlla tabella "SEGUE" IN BASE AL CORSO E NON ALLO STUDENTE (quindi cancellerebbe il corso da TUTTI gli studenti, invece che dal solo studente che inserisco)
	 
	 //@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="listastudente" )
	 
	 /*
	 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	 @JoinTable(name = "segue", joinColumns = {
	   @JoinColumn(name = "matricola") },
	   inverseJoinColumns = { @JoinColumn(name = "idcorso")})
	   */
	 
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)  
	@JoinTable(name="segue", joinColumns=@JoinColumn(name="matricola"), inverseJoinColumns=@JoinColumn(name="idcorso"))
	private Set<CorsoH> listacorso;

	public void setListacorso(Set<CorsoH> listacorso) {
		this.listacorso = listacorso;
	}
	  
	  public Set<CorsoH> getListacorso() {
			return listacorso;
		}

	
	public int getMatricola() {
		return matricola;
	 }
	public void setMatricola(int matricola) {
		this.matricola = matricola;
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
	 public String getCf() {
		 return cf;
	 }
	 public void setCf(String cf) {
		 this.cf = cf;
	 }
		 
	 @Override
	 public String toString() {
		 return "Studente [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", cf=" + cf + "]";
	}
}

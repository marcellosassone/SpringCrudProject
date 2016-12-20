package com.begear.model;

import java.util.ArrayList;
import java.util.List;

public class Studente {

	private int matricola;
	 private String nome;
	 private String cognome;
	 private String cf;
	 private List<Corso> listacorso = new ArrayList<Corso>();
	 
// COSTRUTTORI 
	 
	 public Studente(){
		 
	 }
	 
	 public Studente(int matricola){
		 this.matricola=matricola;
		 
	 }
	 
	 public Studente( String nome, String cognome, String cf) {
	  super();
	     this.nome = nome;
	  this.cognome = cognome;
	  this.cf = cf;
	 }
	 
	 public Studente(int matricola, String nome, String cognome, String cf) {
		  super();
		  this.matricola=matricola ;
		  this.nome = nome;
		  this.cognome = cognome;
		  this.cf = cf;
		 }
	 
// MUTATOR E ACCESSOR
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
	 
	 public List<Corso> getListacorso() {
		return listacorso;
	}

	public void setListacorso(List<Corso> listacorso) {
		this.listacorso = listacorso;
	}

//OVERRIDE DEL METODO TOSTRING
	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", cf=" + cf
				+ "]";
	}

	
	public String toStampa(){
		
		
		return " listacorso = " + listacorso + "]";
	}
	 
	 

	 


}
	
	
	
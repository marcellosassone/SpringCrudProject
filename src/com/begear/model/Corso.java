package com.begear.model;

import java.util.ArrayList;
import java.util.List;

public class Corso {

	 private int idcorso;
	 private String nomec;
	 private int annocorso;
	 private List<Studente> listastudente = new ArrayList<Studente>();

	public void setAnnocorso(int annocorso) {
		this.annocorso = annocorso;
	}
	// COSTRUTTORI
	
public Corso(){
		
	}
	
	public Corso(int idcorso){
		
		this.idcorso=idcorso;	
	}
	
	public Corso(String nomec) {
	  super();
	  this.nomec = nomec;
	 }
	 
	 public Corso(int idcorso, String nomec, int anno) {
		  super();
		  
		  this.idcorso=idcorso;
		  this.nomec = nomec;
		  this.annocorso=anno;
		 }
	 
	 
	 
	 
	 
	 public Corso(int idcorso,String nomec) {
		  super();
		  
		  this.idcorso=idcorso;
		  this.nomec = nomec;
		 }
	 
	 public Corso(int idcorso,int anno) {
		  super();
		  
		  this.idcorso=idcorso;
		  this.annocorso = anno;
		 }
	 
	 
	 // MUTATOR E ACCESSOR
	 
	 
	 public List<Studente> getListastudente() {
			return listastudente;
		}


		public void setListastudente(List<Studente> listastudente) {
			this.listastudente = listastudente;
		}
	 
	 
	 public int getIdcorso() {
	  return idcorso;
	 }
	
	public void setIdcorso(int idcorso) {
	  this.idcorso = idcorso;
	 }
	 public String getNomec() {
	  return nomec;
	 }
	 public void setNomec(String nomec) {
	  this.nomec = nomec;
	 }
	 public int getAnnocorso() {
			return annocorso;
		}
	 // OVERRIDE TOSTRING

	@Override
	public String toString() {
		return "Corso [idcorso=" + idcorso + ", nomec=" + nomec + ", annocorso=" + annocorso + "]";
	}

	public String toStampa(){
		
		
		return " listastudente = " + listastudente + "]";
	}
		
	}

	
	
	
	
	
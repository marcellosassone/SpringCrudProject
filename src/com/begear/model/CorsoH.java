package com.begear.model;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table (name="corso")
public class CorsoH {
	
	@Id
	@Column(name="idcorso")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idcorso;
	
	@Column(name="nomec")
	private String nomec;

	 
//	 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	 @JoinTable(name = "segue", joinColumns = {
//	 @JoinColumn(name = "idcorso", nullable = false, updatable = false) },
//	 inverseJoinColumns = { @JoinColumn(name = "matricola",
//	 nullable = false, updatable = false) })
//   @ManyToMany(fetch = FetchType.LAZY, mappedBy="listacorso" )
	
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="listacorso")
	private Set<StudenteH> listastudente ;
	
	public void setListastudente(Set<StudenteH> listastudente) {
		this.listastudente = listastudente;
	}
	
	public Set<StudenteH> getListastudente() {
		return listastudente;
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




	  
}

package com.begear.dao;

import java.sql.SQLException;
import java.util.List;

import com.begear.model.Corso;
import com.begear.model.Studente;

public interface Dao {
 
//Metodi Studente
	
    void insertStudente(Studente s) throws SQLException;
    void updateStudente(Studente s) throws SQLException;
    void deleteStudente(Studente s) throws SQLException;
    Studente ricercaStudente(Studente s) throws SQLException;
    List<Studente> stampaStudenti() throws SQLException;

  
//Metodi Corso
    
    void insertCorso(Corso c);
    void updateCorso(Corso c);
    void deleteCorso(Corso c);
    void ricercaCorso(Corso c);
    void stampaCorsi();  

    
//Metodi Segue
    
    void insertSegue(Studente s , Corso c);
    void deleteSegue(Studente s, Corso c);
    void stampaSegue();
    
//Metodi Ricerca Specifica
    Studente stampaCorsiStud(Studente s);
    Corso stampaStudCorsi(Corso c);
    
    
}

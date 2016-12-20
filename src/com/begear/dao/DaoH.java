package com.begear.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.begear.model.CorsoH;
import com.begear.model.StudenteH;

public interface DaoH {
	
	   void insertStudente(StudenteH s) throws HibernateException;
	    void updateStudente(StudenteH s) throws HibernateException;
	    void deleteStudente(StudenteH s) throws HibernateException;
	    StudenteH ricercaStudente(StudenteH s) throws HibernateException;
	    List<StudenteH> stampaStudenti() throws HibernateException;

	  //Metodi Corso
	    
	    void insertCorso(CorsoH c) throws HibernateException;
}

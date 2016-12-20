package com.begear.dao;

//import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.begear.model.CorsoH;
import com.begear.model.StudenteH;
import com.begear.utility.HibernateUtil;

public class DaoImplH implements DaoH{

	 public void insertStudente(StudenteH studente) throws HibernateException  {
		  
	
		 //Create session factory object
		  SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		  //getting session object from session factory
		  Session session = sessionFactory.openSession();
		  //getting transaction object from session object
		  session.beginTransaction();
		  
		  session.save(studente);
		  
		  session.getTransaction().commit();
		  
		  session.close();
		  //sessionFactory.close();
	 
	 }
	 
	 public void updateStudente(StudenteH s) throws HibernateException
	 {
		  SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		  Session session = sessionFactory.openSession();
		  session.beginTransaction();
		  session.update(s);
		  session.getTransaction().commit();
		  session.close();
		  //sessionFactory.close();
	 }
	 
	 public void deleteStudente(StudenteH s) throws HibernateException
	 {
		  SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		  Session session = sessionFactory.openSession();
		  session.beginTransaction();
		  session.delete(s);
		  session.getTransaction().commit();
		  session.close();
		  //sessionFactory.close();
	 }
	 
	 public StudenteH ricercaStudente(StudenteH s) 
	 {
		 System.out.println("Init");
		 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 Session session = sessionFactory.openSession();
		 System.out.println("Prima GET qry");
		 StudenteH sh = (StudenteH) session.get(StudenteH.class, s.getMatricola());
		 System.out.println("Dopo GET qry");
		 session.close();
		 //sessionFactory.close();
		 System.out.println("Restituisco " + sh);
		 return sh;
	 }
	 
	 
	 public List<StudenteH> stampaStudenti()  
	 {
		 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 Session session = sessionFactory.openSession();
		 String hql="from StudenteH order by Cognome,Nome";
		 Query qry = session.createQuery(hql);
		 List<StudenteH> list=qry.list();
		 session.close();
		 //sessionFactory.close();
		 return list;
	}
	
	 
	 public void insertCorso(CorsoH corso)
	 {
		  SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		  Session session = sessionFactory.openSession();
		  session.beginTransaction();
		  session.save(corso);
		  session.getTransaction().commit();
		  session.close();
		  //sessionFactory.close();
	 }
}

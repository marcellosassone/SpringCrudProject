package com.begear.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import javax.naming.NamingException;

import org.apache.log4j.Logger;
import com.begear.model.Studente;
import com.begear.model.Corso;

public class DaoImpl implements Dao {
 
//LOGGER

    Logger log = Logger.getLogger(DaoImpl.class);
    
    
    private static String user = "root";
    private static String pass = "root";
    private static String nomedriver = "jdbc:mysql://localhost:3306/dbcorsi?useSSL=false";
// Inizializzatore Statico
  static {
	  try {
	   Class.forName("com.mysql.jdbc.Driver");
	  } catch (ClassNotFoundException e) {
		  e.printStackTrace();
   		}
  }
 // Fine blocco statico
  
    
 //SINGLETON
  private static DaoImpl istance;
  private DaoImpl(){}//COSTRUTTORE PRIVATO VUOTO
  
  public static DaoImpl getIstance(){
	  if(istance==null){
		  istance=new DaoImpl();
		   }
	  return istance; 
  }
  
  
 //Connection PreparedStatement ResultSet NULL 
  private Connection connect = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultset = null;
  
  
 

  
//||||||||||||_______METODI SU STUDENTE______||||||||||||
  
 //INSERTSTUDENTE() 
 @Override
 public void insertStudente(Studente studente) throws SQLException  {
	 log.info(studente);
	 
	 
  String query = "INSERT INTO studente( nome, cognome, cf) VALUES(?,?,?)";
  try {
   connect = DriverManager.getConnection(nomedriver, user, pass);
	  //Datasource ds=Datasource.getIstance();  // SINGETHONE
	  //connect=ds.getConnection();

   preparedStatement = connect.prepareStatement(query);
   // preparedStatement.setInt(1, studente.getMatricola());
   preparedStatement.setString(1, studente.getNome());
   preparedStatement.setString(2, studente.getCognome());
   preparedStatement.setString(3, studente.getCf());
   preparedStatement.executeUpdate();
  
  } catch (SQLException e) {
	  e.printStackTrace();
	  throw e;
  } 
   finally {
	 try {
	  if (preparedStatement != null) {
		   preparedStatement.close();
	  }
	  	if (connect != null) {
	  		 connect.close();
	  	}
	 } catch (SQLException e) {
	 	}
	}  
 }
 
 
//UPDATE STUDENTE
 @Override
 public void updateStudente(Studente studente) throws SQLException {
 
	log.info(studente);;
	 String query = "UPDATE studente SET nome=(?), cognome=(?), cf=(?) WHERE matricola=(?)";
  try {
	  connect = DriverManager.getConnection(nomedriver, user, pass);
   preparedStatement = connect.prepareStatement(query);
   
   preparedStatement.setString(1, studente.getNome());
   preparedStatement.setString(2, studente.getCognome());
   preparedStatement.setString(3, studente.getCf());
   preparedStatement.setInt(4 , studente.getMatricola());
   preparedStatement.executeUpdate();
  } catch (SQLException e) {
   e.printStackTrace();
   throw e;
  } finally {
   try {
    if (preparedStatement != null) {
    	 preparedStatement.close();
    }
    if (connect != null) {
    	 connect.close();
    }
   } catch (SQLException e) {
   }
  }
  
 }
 
 
//DELETE STUDENTE
 @Override
 public void deleteStudente(Studente studente) throws SQLException {
	 log.info(studente);
  String query = "DELETE FROM studente WHERE matricola = (?)";
  try {
	  connect = DriverManager.getConnection(nomedriver, user, pass);
   preparedStatement = connect.prepareStatement(query);
   preparedStatement.setInt(1, studente.getMatricola());
   preparedStatement.executeUpdate();
  } catch (SQLException e) {
   e.printStackTrace();
   throw e;
  } finally {
   try {
    if (preparedStatement != null) {
    	 preparedStatement.close();
    }
    if (connect != null) {
    	 connect.close();
    }
   } catch (SQLException e) {
   }
  }
  
 }
 
 
//STAMPASTUDENTI
@Override
public List<Studente> stampaStudenti()  throws SQLException{
	
 List<Studente> lista = new ArrayList<Studente>();
 String query = "SELECT * FROM studente order by cognome,nome,cf,matricola;";
 try {
	 connect = DriverManager.getConnection(nomedriver, user, pass);
	 preparedStatement = connect.prepareStatement(query);
	 resultset=preparedStatement.executeQuery();
	 log.debug(query);
  
   while(resultset.next()){
       int matricola=resultset.getInt("matricola")    ;
       String nome=resultset.getString("nome") ;
       String cognome=resultset.getString("cognome") ;
       String cf=resultset.getString("cf") ;
       Studente studente= new Studente(nome, cognome, cf);
       studente.setMatricola(matricola);
       lista.add(studente);
    }
  
  //System.out.println(lista);
   return lista;
 
 } catch (SQLException e) {
  //e.printStackTrace();
  throw e;
 } finally {
  try {
   if(resultset!=null){
       resultset.close();
   }
   if (preparedStatement != null) {
	    preparedStatement.close();
   }
   	if (connect != null) {
   		 connect.close();
   	}
  } catch (SQLException e) {
 }
}
 
}




//||||||||||||_______METODI SU CORSO______||||||||||||



//INSERT CORSO
 @Override
 public void insertCorso(Corso corso) {
	 log.info(corso);
  String query = "INSERT INTO corso(nomec) VALUES(?)";
  try {
	  connect = DriverManager.getConnection(nomedriver, user, pass);
   preparedStatement = connect.prepareStatement(query);
   preparedStatement.setString(1, corso.getNomec());
   preparedStatement.executeUpdate();
   log.debug(query);
  } catch (SQLException e) {
   e.printStackTrace();
  } finally {
   try {
    if (preparedStatement != null) {
    	 preparedStatement.close();
    }
    if (connect != null) {
    	 connect.close();
    }
   } catch (SQLException e) {
   }
  }
  
 }
 
 
//UPDATECORSO()
 @Override
 public void updateCorso(Corso corso) {
	 log.info(corso);
  String query = "UPDATE corso SET nomec=(?) WHERE idcorso=(?)";
  try {
	  connect = DriverManager.getConnection(nomedriver, user, pass);
   preparedStatement = connect.prepareStatement(query);
   preparedStatement.setString(1, corso.getNomec());
   preparedStatement.setInt(2, corso.getIdcorso());
   preparedStatement.executeUpdate();
  } catch (SQLException e) {
   e.printStackTrace();
  } finally {
   try {
    if (preparedStatement != null) {
    	 preparedStatement.close();
    }
    if (connect != null) {
    	 connect.close();
    }
   } catch (SQLException e) {
   }
  }
  
 }
 
 
//DELETECORSO()
 @Override
 public void deleteCorso(Corso corso) {
	 log.info(corso);
  String query = "DELETE FROM corso WHERE idcorso = (?)";
  try {
   log.info(query);
   connect = DriverManager.getConnection(nomedriver, user, pass);
   preparedStatement = connect.prepareStatement(query);
   preparedStatement.setInt(1, corso.getIdcorso());
   preparedStatement.executeUpdate();
  } catch (SQLException e) {
   e.printStackTrace();
  } finally {
   try {
    if (preparedStatement != null) {
    	 preparedStatement.close();
    }
    if (connect != null) {
    	 connect.close();
    }
   } catch (SQLException e) {
  }
 }
  
}


//STAMPACORSI
 @Override
 public void stampaCorsi() {
  List<Corso> listacorso = new ArrayList<Corso>();
  String query = "SELECT * FROM corso;";
  try {
	  connect = DriverManager.getConnection(nomedriver, user, pass);

	   log.debug(query);
	   preparedStatement = connect.prepareStatement(query);
       resultset=preparedStatement.executeQuery();
   
    while(resultset.next()){
        int idcorso=resultset.getInt("idcorso")    ;
        String nomec=resultset.getString("nomec") ;
        Corso corso= new Corso(nomec);
        corso.setIdcorso(idcorso);
        listacorso.add(corso);
    }
    
   System.out.println(listacorso);
  
  } catch (SQLException e) {
   e.printStackTrace();
  } finally {
   try {
    if(resultset!=null){
      resultset.close();
    }
    if (preparedStatement != null) {
    	 preparedStatement.close();
    }
    if (connect != null) {
    	 connect.close();
    }
   } catch (SQLException e) {
   		}
  	}
  
 }
 
 
 //||||||||||||_______METODI SU SEGUE______||||||||||||
 
 
//INSERTSEGUE()
 @Override
 public void insertSegue(Studente s, Corso c) {
	 log.info(s);
	 log.info(c);
  String query = "INSERT INTO segue (matricola, idcorso, annoaccademico) VALUES(?,?,?)";
  try {
	  connect = DriverManager.getConnection(nomedriver, user, pass);
	   log.debug(query);
	   preparedStatement = connect.prepareStatement(query);
	   preparedStatement.setInt(1, s.getMatricola());
	   preparedStatement.setInt(2, c.getIdcorso());
	   preparedStatement.setInt(3, c.getAnnocorso()); // sposta data in corso e richiama c.getData();
 
	   preparedStatement.executeUpdate();
  
  } catch (SQLException e) {
	   e.printStackTrace();
  		} finally {
   try {
    if (preparedStatement != null) {
    	 preparedStatement.close();
    }
    if (connect != null) {
    	 connect.close();
    }
   } catch (SQLException e) {
   }
  }
  
 }
 
 
//DELETESEGUE()
@Override
public void deleteSegue(Studente s , Corso c) {
	log.debug(s);
	log.debug(c);
 String query = "DELETE FROM segue WHERE matricola = (?) and idcorso = (?) and annoaccademico = (?) ";

 try {
	 connect = DriverManager.getConnection(nomedriver, user, pass);
	   log.debug(query);
	   preparedStatement = connect.prepareStatement(query);
	   preparedStatement.setInt(1, s.getMatricola());
	   preparedStatement.setInt(2, c.getIdcorso());
	   preparedStatement.setInt(3, c.getAnnocorso());
 } catch (SQLException e) {
  e.printStackTrace();
 } finally {
  try {
   if (preparedStatement != null) {
   	 preparedStatement.close();
   }
   if (connect != null) {
   	 connect.close();
   }
  } catch (SQLException e) {
 }
}
 
}

//fine logger_____________________________________________________________________________________
 //STAMPASEGUE()
 @Override
 public void stampaSegue() {
  List<String> lista = new ArrayList<String>();
  String query = "SELECT * FROM segue;";
 
 try {
	 connect = DriverManager.getConnection(nomedriver, user, pass);
   preparedStatement = connect.prepareStatement(query);
   resultset=preparedStatement.executeQuery();
   
    while(resultset.next()){
        int matricola=resultset.getInt("matricola")    ;
        int idcorso=resultset.getInt("idcorso") ;
        int annoaccademico=resultset.getInt("annoaccademico") ;      
        String result = matricola + " " + idcorso + " "+ annoaccademico;
        lista.add(result);
    }
   
    System.out.println(lista);
  	
 } catch (SQLException e) {
  		e.printStackTrace();
  	} finally {
  		
  		try {
  			if(resultset!=null){
  				resultset.close();
  	  		}
  
  			if(preparedStatement != null) {
  				preparedStatement.close();
  			}
  				if(connect != null) {
  					connect.close();
  				}
  			} catch (SQLException e) {
  		}
  	}
  
 }

 
//||||||||||||_____METODI DI RICERCA_____||||||||||||
 //RICERCA INFORMAZIONI STUDENTE
@Override
public Studente ricercaStudente(Studente s) throws SQLException {

		  String query = "SELECT * FROM studente  WHERE matricola = (?)";
		  try {
			  connect = DriverManager.getConnection(nomedriver, user, pass);
		   preparedStatement = connect.prepareStatement(query);
		   preparedStatement.setInt(1, s.getMatricola());
		   resultset=preparedStatement.executeQuery();
		   
		   Studente studente=null;
		   while(resultset.next()){
		       int matricola=resultset.getInt("matricola")    ;
		       String nome=resultset.getString("nome") ;
		       String cognome=resultset.getString("cognome") ;
		       String cf=resultset.getString("cf") ;
		       studente= new Studente(nome, cognome, cf);
		       studente.setMatricola(matricola);
			   //System.out.println(studente);
		    }
		   
		   return studente;
		   
		  } catch (SQLException e) {
		   e.printStackTrace();
		   throw e;
		  } finally {
		   try {
		    if(resultset!=null){
		      resultset.close();
		    }
		    if (preparedStatement != null) {
		    	 preparedStatement.close();
		    }
		    if (connect != null) {
		    	 connect.close();
		    }
		   } catch (SQLException e) {
		   		}
		  	}
		  
		}

//RICERCA INFORMAZIONI CORSO	
@Override
public void ricercaCorso(Corso c) {
 	 String query = "SELECT * FROM corso WHERE idcorso = (?)";
	  try {
		  connect = DriverManager.getConnection(nomedriver, user, pass);
	   preparedStatement = connect.prepareStatement(query);
	   preparedStatement.setInt(1, c.getIdcorso());
	   resultset=preparedStatement.executeQuery();
	   
	   while(resultset.next()){
	       int id=resultset.getInt("idcorso")    ;
	       String nomec=resultset.getString("nomec") ;
	      
	       Corso corso = new Corso(nomec);
	       corso.setIdcorso(id);
		   System.out.println(corso);
	    }

	   
	  } catch (SQLException e) {
	   e.printStackTrace();
	  } finally {
	   try {
	    if(resultset!=null){
	      resultset.close();
	    }
	    if (preparedStatement != null) {
	    	 preparedStatement.close();
	    }
	    if (connect != null) {
	    	 connect.close();
	    }
	   } catch (SQLException e) {
	   		}
	  	}
	  
}


//STAMPA LISTA CORSI FREQUENTATI DA STUDENTE
@Override
public Studente stampaCorsiStud(Studente s) {
	 	 String query = "SELECT * FROM studente s JOIN segue sg on s.matricola=sg.matricola JOIN corso c on sg.idcorso=c.idcorso WHERE s.matricola = ?";
		 Studente stud = new Studente();
	 	 
	 	 try {
	 		connect = DriverManager.getConnection(nomedriver, user, pass);
		   preparedStatement = connect.prepareStatement(query);
		   preparedStatement.setInt(1, s.getMatricola());
		   resultset=preparedStatement.executeQuery();
		   
		   	  int matricola=0;
		      String nome=null;
		      String cognome=null; 
		      String cf = null;
		   
		   while(resultset.next()){
		      matricola=resultset.getInt("matricola");
		      nome = resultset.getString("nome");
		      cognome = resultset.getString("cognome");
		      cf=resultset.getString("cf");
		      int idcorso=resultset.getInt("idcorso");
		      String nomec = resultset.getString("nomec");
		      int anno=resultset.getInt("annoaccademico");
		      
			
		      Corso c = new Corso(idcorso,nomec,anno);
			  stud.getListacorso().add(c);
		    }
		   stud.setMatricola(matricola);
		   stud.setCognome(cognome);
		   stud.setNome(nome);
		   stud.setCf(cf);
		   
		  } catch (SQLException e) {
		   e.printStackTrace();
		  } finally {
		   try {
		    if(resultset!=null){
		      resultset.close();
		    }
		    if (preparedStatement != null) {
		    	 preparedStatement.close();
		    }
		    if (connect != null) {
		    	 connect.close();
		    }
		   } catch (SQLException e) {
		   		}
		  	}
		  
return stud;	
}
	
	
//STAMPA LISTA STUDENTI DA UN CORSO 
@Override
public Corso stampaStudCorsi(Corso c) {
	 
	String query = "SELECT * FROM studente s JOIN segue sg on s.matricola=sg.matricola JOIN corso c on sg.idcorso=c.idcorso WHERE idcorso = ?";
	Corso corso = new Corso();
 	 
 	 try {
 		connect = DriverManager.getConnection(nomedriver, user, pass);
	   preparedStatement = connect.prepareStatement(query);
	   preparedStatement.setInt(1, corso.getIdcorso());
	   resultset=preparedStatement.executeQuery();
	   
	   	  int id=0;
	      int anno=0;
	   	  String nomec=null;
	   
	   while(resultset.next()){
	      id=resultset.getInt("idcorso");
	      nomec = resultset.getString("nome");
	      anno=resultset.getInt("annoaccademico");
	      int matricola=resultset.getInt("matricola");
	      String nome = resultset.getString("nome");
	      String cognome = resultset.getString("cognome");
	      String cf=resultset.getString("cf");
	      
		  Studente stud2 = new Studente(matricola,nome,cognome,cf);
		  corso.getListastudente().add(stud2);
	    }
	   
	   corso.setIdcorso(id);
	   corso.setNomec(nomec);
	   corso.setAnnocorso(anno);
	  } catch (SQLException e) {
	   e.printStackTrace();
	  } finally {
	   try {
	    if(resultset!=null){
	      resultset.close();
	    }
	    if (preparedStatement != null) {
	    	 preparedStatement.close();
	    }
	    if (connect != null) {
	    	 connect.close();
	    }
	   } catch (SQLException e) {
	   		}
	  	}
	  
return corso;		
}
}


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Studenti</title>
</head>
<body>
<h1>Lista Studenti</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Mat</th><th>Cognome</th><th>Nome</th><th>Codice Fiscale</th><th>Edit</th><th>Delete</th></tr>  
  <c:forEach var="stu" items="${list}">   
	  <tr>  
		  <td>${stu.matricola}</td>  
		  <td>${stu.cognome}</td>  
		  <td>${stu.nome}</td>  
		  <td>${stu.cf}</td>  
		  <td><a href="updateStudente/${stu.matricola}">Edit</a></td>  
		 <!--  <td><button type="submit" onClick='confirm("Sei sicuro etcetc?")'>Delete </button></td> -->
		  <td><a href="deleteStudente/${stu.matricola}"  onClick='return confirm("Sei sicuro di Voler Eliminare il Record?")'>Delete</a></td>
	  </tr>  
  </c:forEach>  
  </table>  
  <br/>  
  <a href="/SpringCrudProject2/studenteIns">Aggiungi Studente</a> 
</body>
</html>
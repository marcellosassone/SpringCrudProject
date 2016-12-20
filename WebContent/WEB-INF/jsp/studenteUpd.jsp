<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Studente</title>
</head>
<body>
<form:form method="POST" commandName="formStudente" action="/SpringCrudProject2/updStudente" >
<table>
    <tr>
        <td><form:label path="cognome">Cognome</form:label></td>
        <td><form:input path="cognome" /></td>
    </tr>
    <tr>
        <td><form:label path="nome">Nome</form:label></td>
        <td><form:input path="nome" /></td>
    </tr>
    <tr>
        <td><form:label path="cf">Codice Fiscale</form:label></td>
        <td><form:input path="cf" /></td>
    </tr>
    <tr>
        <td><form:label path="matricola">Matricola</form:label></td>
        <td><form:input path="matricola" readonly="true" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Modifica"/>
        </td>
    </tr>
</table>  
<br>
<br>
 <a href="/SpringCrudProject2/">Torna al Main</a> 
</form:form>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dati allievo</title>
</head>
<body>
	<h1>Verifica i dati allievo</h1>

	Codice Fiscale:
	<div>${allievo.codiceFiscale}</div>
	<br>
	<br>
    Nome:<div>${allievo.nome}</div>
	<br>
	<br>
     Cognome:<div>${allievo.cognome}</div>
	<br>
	<br>
	 Data di nascita:<div>${allievo.dataDiNascita}</div>
	<br>
	<br>
	 Luogo Di Nascita:<div>${allievo.luogoDiNascita}</div>
	<br>
	<br>
	<br> Telefono:
	<div>${allievo.telefono}</div>
    <br>
	<br>
	<input type="button" name="conferma" onclick="location.href='newAllievo'" value="Conferma">
	<input type="button" name="indietro" onclick="location.href='addAllievo'" value="Modifica">

</body>
</html>
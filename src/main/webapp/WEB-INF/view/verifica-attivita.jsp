<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dati attivita</title>
</head>
<body>
<h1>Dati attivita</h1>

	
	Nome:<div>${attivita.nome}</div>
	<br>
	<br>
    Descrizione:<div>${attivita.descrizione}</div>
	<br>
	<br>
     Data:<div>${attivita.data}</div>
   
	<br>
	<br>
	<input type="button" name="conferma" onclick="location.href='newAttivita'" value="Conferma">
	<input type="button" name="indietro" onclick="location.href='addAttivita'" value="Modifica">
</body>
</html>
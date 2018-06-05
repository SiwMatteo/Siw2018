<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aggiungi allievo</title>
</head>
<body>
<h1>inserisci le credenziali del nuovo allievo</h1>

<form:form action="allievo" modelAttribute="allievo1">
Codice Fiscale:<form:input path="codiceFiscale"/>
<br>
<br>
Nome:<form:input path="nome"/>
<br>
<br>
Cognome:<form:input path="cognome"/>
<br>
<br>
Data di nascita:<form:input path="dataNascita" type="text"/>
<br>
<br>
Luogo di nascita:<form:input path="luogoNascita"/>
<br>
<br>
Telefono:<form:input path="telefono"/>
<br>
<br>
<input type="submit" name="invia">

</form:form>
</body>
</html>
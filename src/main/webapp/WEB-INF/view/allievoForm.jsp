<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Inserisci Allievo</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link
	href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900|Quicksand:400,700|Questrial"
	rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<div id="header-wrapper">
		<div id="header" class="container">
			<div id="logo">
				<h1>
					<a href="/">MF Activity Corporation</a>
				</h1>
				<div id="menu">
					<ul>
						<li><a href="/pagina-iniziale-centro" accesskey="1" title="">Homepage Centro</a></li>
						<li><a href="logout" accesskey="2" title="">Logout
								Responsabile</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<div id="page-wrapper">
		<p>Inserisci un nuovo Allievo</p>
		<br>
		<div><font color="yellow">${allievoExists}</font></div>
		<br>
		<br>
		<form:form action="allievo" modelAttribute="allievo1">
			Codice Fiscale: <form:input path="codiceFiscale" />
			<font color="yellow"><form:errors path="codiceFiscale"/></font>
			<br>
			<br> 
			Nome: <form:input path="nome" />
			<font color="yellow"><form:errors path="nome" /></font>
			<br>
			<br>
			Cognome: <form:input path="cognome" />
			<font color="yellow"><form:errors path="cognome" /></font>
			<br>
			<br>
			Data di nascita: <form:input path="dataDiNascita" type="date" />
			<font color="yellow"><form:errors path="dataDiNascita" /></font>
			<br>
			<br>
			Luogo di nascita: <form:input path="luogoDiNascita" />
			<font color="yellow"><form:errors path="luogoDiNascita" /></font>
			<br>
			<br>
			Telefono: <form:input path="telefono" />
			<font color="yellow"><form:errors path="telefono" /></font>
			<br>
			<br>
			<br>
			 <input type="submit" name="invia">
			<br>
			<br>
			<br>
		</form:form>
		</div>
		<div id="copyright" class="container">
		<p>
			&copy; Untitled. All rights reserved. | Photos by <a
				href="http://fotogrph.com/">Fotogrph</a> | Design by <a
				href="http://templated.co" rel="nofollow">TEMPLATED</a>.
		</p>
		<ul class="contact">
			<li><a href="#" class="icon icon-twitter"><span>Twitter</span></a></li>
			<li><a href="#" class="icon icon-facebook"><span>Facebook</span></a></li>
			<li><a href="#" class="icon icon-instagram"><span>Instagram</span></a></li>
		</ul>
	</div>
</body>
</html>
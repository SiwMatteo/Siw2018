<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Inserisci Attivit�</title>
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
						<li><a href="/" accesskey="1" title="">Homepage</a></li>
						<li><a href="login" accesskey="2" title="">Logout
								Responsabile</a></li>
						<li><a href="/info" accesskey="3" title="">Info</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div id="page-wrapper">
			<form:form action="attivita" modelAttribute="attivita1">
			Nome: <form:input path="nome" />
			<form:errors path="nome"/>
			<br>
			<br>
			Descrizione: <form:input path="descrizione" />
			<form:errors path="descrizione"/>
			<br>
			<br>
			Data : <form:input path="data" type="date" />
			<form:errors path="data"/> 
			<br>
			<br>
			 <input type="submit" name="invia">
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
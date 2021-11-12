<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Info compte</title>
	<link rel="stylesheet" type="text/css" href="css/base.css" >
</head>
<body>
	<h1>Affichage Colis </h1>
	<p>ID : ${Colis.id }</p>
	<p>valeur : <fmt:formatNumber type="currency" currencySymbol="&euro;"
	   value="${Colis.getValeur() }"></fmt:formatNumber>
	</p>
	<p>Poid : ${Colis.getPoid() }</p>
	<p>destination : ${Colis.getDestination() }</p>
	<p>origine : ${Colis.getOrigine() }</p>
	<p>position : ${Colis.getPosition() }</p>
	<a href="index.html">Revenir à la page principale</a>
</body>
</html>
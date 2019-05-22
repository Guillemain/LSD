<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="informations.Profil,informations.Badge,informations.Formulaire,java.util.Collection" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Consultation profil</title>
</head>
<body>
<form method="get" action="ServletOp">

	<% Profil profil = (Profil) request.getAttribute("profil"); %>
	<% int age = (int) request.getAttribute("age"); %>
	<% int score = (int) request.getAttribute("score"); %>

	<h4>==== Informations générales ====</h4>
	<%=profil.getPrenom()%> <%=profil.getNom()%> (id <%=profil.getId()%>)<br>
	Genre : <%=profil.getGenre()%><br>
	Age : <%=age%> (Date de naissance : <%=profil.getDateNaissance().toString()%>)<br>
	<br>

	<h4>==== Liste des amis ====</h4>
	<% for (Profil amis : profil.getAmis()) { %>
		<a href="/LSD/ServletOp?consulterProfil&idProfil=<%=amis.getId()%>"> <%=amis.getPrenom()%> <%=amis.getNom()%> (id <%=amis.getId()%>) </a><br>
	<%}%>
	<br>

	Ajouter un Ami : <input type="text" name="idAmi"> <input type="submit" value="ajouterAmi"><br>
	<br>

	<h4>==== Liste des badges obtenus ====</h4>
	<% for (Badge badge : profil.getBadges()) { %>
		<%=badge.getNom()%> : <%=badge.getDescription()%> (<%=badge.getValeur()%> points)<br>
	<%}%>
	Score Total : <%=score%> points 
	<br>

	<a href="listerBadge.html"> Voir tous les badges </a><br>
	<br>

	<h4>==== Liste des formulaires postés ====</h4>
	<% for (Formulaire formulaire : profil.getFormulaires()) { %>
		<%=formulaire.getNom()%> <br>
	<%}%>

	<input type="hidden" name="idProfil" value="<%=profil.getId()%>">
	<input type="hidden" name="op" value="ajouterAmi">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="informations.Profil,informations.Badge,informations.Sondage,java.util.Collection" %>
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

	==== Informations générales ====<br>
	Pseudo : <%=profil.getPseudo()%> (id <%=profil.getId()%>)<br>
	Genre : <%=profil.getGenre()%><br>
	Age : <%=age%> (Date de naissance : <%=profil.getDateNaissance().toString()%>)<br>
	<br>

	==== Liste des amis ====<br>
	<blockquote>
	<% for (Profil amis : profil.getAmis()) { %>
		<%=amis.getPseudo()%> (id <%=amis.getId()%>)<br>
	<%}%>
	</BLOCKQUOTE>
	<br>

	Ajouter un Ami : <input type="text" name="idAmi"> <input type="submit" value="ajoutAmi"><br>
	<br>

	==== Liste des badges obtenus ====
	<blockquote>
	<% for (Badge badge : profil.getBadges()) { %>
		<%=badge.getNom()%> : <%=badge.getDescription()%> (<%=badge.getValeur()%> points)<br>
	<%}%>
	</BLOCKQUOTE>
	Score Total : <%=score%> points 
	<br>

	<a href="listerBadge.html"> Voir tous les badges </a><br>
	<br>

	==== Liste des sondages postés ====
	<blockquote>
	<% for (Sondage sondage : profil.getSondages()) { %>
		<%=sondage.getQuestion()%> <br>
	<%}%>
	</BLOCKQUOTE>

	<input type="hidden" name="op" value="ajouterProfil">
</form>
</body>
</html>
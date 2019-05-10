<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Connexion</title>
</head>
<body>
<form method="get" action="ServletOp">

	<%
	Boolean loginError = (Boolean) request.getAttribute("loginError");
	if (loginError==null) {
		loginError = false;
	}
	%>

	Bienvenue sur LSD !<br>
	<br>	
	Identifiant : <input type="text" name="id"><br>
	Mot de passe : <input type="text" name="mdp"><br>
	<input type="submit" value="Connexion"><br>

	<br>
	Pas encore inscrit ?<br>
	<a href="ajoutUtilisateur.jsp"> Créer un compte ! </a>

	<% if (loginError) { %>
		<br><br>
		Identifiant ou mot de passe invalide.
	<% } %>

	<input type="hidden" name="op" value="connecterUtilisateur">
</form>
</body>
</html>
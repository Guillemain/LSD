<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inscription</title>
</head>
<body>
<form method="get" action="ServletOp">

	<%
	String error = (String) request.getAttribute("error");
	if (error==null) {
		error = "";
	}
	%>

	Identifiant : <input type="text" name="id"><br>
	Mot de passe : <input type="password" name="mdp"><br>

	<input type="submit" value="OK">

	<% if (error.equals("doublon")) { %>
		<br><br>
		Cet identifiant est déjà pris !
	<% } else if (error.equals("emptyField")) { %>
		<br><br>
		Un des champs est resté vide !
	<% } %>

	<input type="hidden" name="op" value="ajouterUtilisateur">
</form>
</body>
</html>
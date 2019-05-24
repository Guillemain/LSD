<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Creation profil</title>
</head>
<body>
<form method="get" action="ServletOp">

	<%
	String error = (String) request.getAttribute("error");
	if (error==null) {
		error = "";
	}
	%>

	Merci d'avoir rejoint LSD ! Veuillez créer votre profil :<br>
	<br>
	Prénom : <input type="text" name="profileFirstname"><br>
	Nom : <input type="text" name="profileSurname"><br>
	<br>
	Genre :
	<select name="genre">
		<option value="homme">Homme</option>
		<option value="femme">Femme</option>
		<option value="autre">Autre</option>
		<option value="non specifie" selected>Non spécifié</option>
	</select><br>
	<br>
	Date de naissance :
		<select name="birthDay">
		<% for (int i=1 ; i<=31 ; i++) { %>
			<option value=<%=i%>><%=i%></option>
		<% } %>
		</select>
		<select name="birthMonth">
		<% for (int i=1 ; i<=12 ; i++) { %>
			<option value=<%=i%>><%=i%></option>
		<% } %>
		</select>
		<select name="birthYear">
		<% for (int i=1900 ; i<=2019 ; i++) { %>
			<option value=<%=i%>><%=i%></option>
		<% } %>
		</select><br>

		<input type="submit" value="OK">

	<% if (error.equals("invalidDate")) { %>
		<br><br>
		La date de naissance donnée n'existe pas !
	<% } else if (error.equals("emptyField")) { %>
		<br><br>
		Un des champs est resté vide !
	<% } %>

	<input type="hidden" name="op" value="ajouterProfil">
</form>
</body>
</html>
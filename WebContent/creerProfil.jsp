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
	Boolean loginError = (Boolean) request.getAttribute("loginError");
	if (loginError==null) {
		loginError = false;
	}
	%>

	Merci d'avoir rejoint LSD ! Veuillez créer votre profil :<br>
	<br>	
	Pseudo : <input type="text" name="id"><br>
	<br>
	Genre :
	<select name="Genre">
		<option value="homme">Homme</option>
		<option value="femme">Femme</option>
		<option value="autre">Autre</option>
		<option value="none" selected>Non spécifié</option>
	</select><br>
	<br>
	Date de naissance :
	<input type="text" name="test" id="datepicker">

	<input type="hidden" name="op" value="connecterUtilisateur">
</form>
</body>
</html>
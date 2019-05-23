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

	ID Profil : <input type="text" name="idProfil"><br>
	<input type="submit" value="Rechercher">

	<% if (error.equals("notFound")) { %>
		<br><br>
		Aucun profil trouvé !
	<% } %>

	<input type="hidden" name="op" value="consulterProfil">
</form>
</body>
</html>
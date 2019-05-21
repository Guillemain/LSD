<%@ page language="java" import="java.util.*, informations.* " contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
boolean echec = (boolean) request.getAttribute("echec");
if (echec){
%>
Ce hastag n'existe pas !
<%
}
%>

<form method="get" action="/LSD/ServletOp">
# : <input type="text" name="label"><br>
<input type="submit" value="Rechercher"><br>
<input type="hidden" name="op" value="resultatRecherche">
</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
String idf = (String) request.getAttribute("idf");
%>
<body>
Ajouter des Hastags

<form method="get" action="/LSD/ServletOp">
# : <input type="text" name="h1"><br>
# : <input type="text" name="h2"><br>
# : <input type="text" name="h3"><br>
<input type="submit" value="Valider"><br>
<input type="hidden" name="op" value="finFormulaire">
<input type="hidden" name="idf" value=<%=idf %>>
</form>
</body>
</html>
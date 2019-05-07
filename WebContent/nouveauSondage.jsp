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
String idf = (String) request.getAttribute("idf");
%>
<form method="get" action="/LSD/ServletOp">
Question : <input type="text" name="question"><br>
Proposition n°1 : <input type="text" name="p"><br>
Proposition n°2 : <input type="text" name="pp"><br>
Proposition n°3 : <input type="text" name="ppp"><br>

<input type="submit" value="Valider"><br>
<input type="hidden" name="op" value="majFormulaire">
<input type="hidden" name="idf" value=<%=idf %>>
</form>
</body>
</html>



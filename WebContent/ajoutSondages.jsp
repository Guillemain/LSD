<%@ page language="java" import="java.util.*, informations.* " contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
<% 
Formulaire f = (Formulaire) request.getAttribute("Formulaire");
String idf = (String) request.getAttribute("idf");
Collection<Sondage> ls = (Collection<Sondage>) f.getListeSondages();
for (Sondage s : ls){
	String question = s.getQuestion();
	
%>
<li><%=question%></li>
<%	
}
%>
</ul>

<form method="get" action="/LSD/ServletOp">
<input type="submit" value="Ajouter un nouveau sondage"><br>
<input type="hidden" name="op" value="ajoutSondage">
<input type="hidden" name="idf" value=<%=idf %>>
</form>
<p></p>


<form method="get" action="/LSD/ServletOp">
<input type="submit" value="Valider"><br>
<input type="hidden" name="op" value="ajoutHastags">
<input type="hidden" name="idf" value=<%=idf %>>
</form>

<form method="get" action="/LSD/ServletOp">
<input type="submit" value="Annuler"><br>
<input type="hidden" name="op" value="accueil">
</form>

</body>
</html>
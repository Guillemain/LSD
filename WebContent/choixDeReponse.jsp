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
Formulaire f = (Formulaire) request.getAttribute("Formulaire");
String id = String.valueOf(f.getId());
Collection<Sondage> ls = f.getListeSondages();
System.out.println(ls.size());
for (Sondage s : ls){
	String question = s.getQuestion();
	Collection<String> lp = s.getListePropositions();
		
%>
<p><%=question%></p>
<ul>
<% 
	for (String p : lp){
%>
		<li><%=p%></li>
<%
	}
%>
</ul>
<%
}
%>	

<form>
<input type="submit" value="Accueil"><br>
<input type="hidden" name="op" value="accueil"><br>
</form>
</body>
</html>
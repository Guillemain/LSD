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
Collection<Formulaire> lf = (Collection<Formulaire>) request.getAttribute("listeFormulaires");
for (Formulaire f : lf){
%>
	<form method="get" action="/LSD/ServletOp">	
<%	
	String nom = f.getNom();
	int id = f.getId();
%>
	<li><%=nom%></li>
	<ul>
<%
	Collection<Sondage> ls = f.getListeSondages();
    System.out.println("Nombre sondages : "+ls.size());
	for (Sondage s : ls){
		String question = s.getQuestion();
		Collection<String> lp = s.getListePropositions();
		System.out.println(lp.size());		
%>
		<li><%=question%></li>
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
	System.out.println("Nombre sondages (2) : "+ls.size());
%>	
	</ul>
	<input type="hidden" name="op" value="accesFormulaire"><br>
	<input type="hidden" name="form" value="<%=id %>" ><br>
	<input type="submit" value="Choix"><br>
	</form>
<%	
}
%>
</ul>
<p></p>
<form>
<input type="submit" value="Accueil"><br>
<input type="hidden" name="op" value="accueil"><br>
</form>
</body>
</html>
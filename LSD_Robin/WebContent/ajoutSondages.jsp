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
System.out.println("ajoutSondage");
Formulaire f = (Formulaire) request.getAttribute("Formulaire");
System.out.println("recuperation formulaire");
System.out.println(f);
String idf = (String) request.getAttribute("idf");
System.out.println("recuperation identifiant");
System.out.println(idf);
Collection<Sondage> ls = (Collection<Sondage>) f.getListeSondages();
System.out.println("recuperation liste sondage");


System.out.println(ls);
if (ls != null){
System.out.println(ls.size());
for (Sondage s : ls){
	String question = s.getQuestion();
	System.out.println("recuperation question");
	
%>
<li><%=question%></li>
<%	
}
System.out.println("fin boucle for");
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
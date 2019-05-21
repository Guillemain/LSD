<%@ page language="java" import="java.util.*, informations.* " contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
<% 
Formulaire f = (Formulaire) request.getAttribute("Formulaire");
String id = String.valueOf(f.getId());
Collection<Sondage> ls = f.getListeSondages();
System.out.println("Nombre de sondage :"+ls.size());
int nb_s = 0;
for (Sondage s : ls){
	String question = s.getQuestion();
	Collection<String> lp = s.getListePropositions();
		
%>
<p><%=question%></p>
<% 
	int nb_p = 0;
	for (String p : lp){
%>
		<input type="radio" id=<%=nb_s %> name=<%=nb_s %> value=<%=nb_p %>> <%=p %> <br>
		
<%
		nb_p += 1;
	}
	nb_s +=1;
}
%>

<input type="submit" value="Valider"><br>
<input type="hidden" name="op" value="ajoutReponse"><br>
<input type="hidden" name="idf" value=<%=id %>><br>
</form>

<form>
<input type="submit" value="Accueil"><br>
<input type="hidden" name="op" value="accueil"><br>
</form>
</body>
</html>
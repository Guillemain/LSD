package informations;


import java.io.IOException;
import java.util.Collection;

import javax.ejb.EJB;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletOp
 */
@WebServlet("/ServletOp")
public class ServletOp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private Facade facade;
	
    /**
     * Default constructor. 
     */
    public ServletOp() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Declaration des variables
		String idUser;
		String mdpUser;
		
		// Traitement des operations
		String op = request.getParameter("op");
		switch(op){

		case "ajouterUtilisateur" :
			idUser = request.getParameter("id");
			mdpUser = request.getParameter("mdp");
			try {
				facade.ajoutUtilisateur(idUser, mdpUser);
				request.getRequestDispatcher("connexion.jsp").forward(request, response);
			} catch (Exception e) {
				request.setAttribute("doublon",true);
				request.getRequestDispatcher("ajoutUtilisateur.jsp").forward(request, response);
			}
			break;

		case "connecterUtilisateur" :
			idUser = request.getParameter("id");
			mdpUser = request.getParameter("mdp");
			System.out.println("Connexion");
			if (facade.connecterUtilisateur(idUser,mdpUser)) {
				System.out.println("Yes");
				request.getRequestDispatcher("index.html").forward(request, response);
			} else {
				System.out.println("No");
				request.setAttribute("loginError",true);
				request.getRequestDispatcher("connexion.jsp").forward(request, response);
			}
			break;

		case "ajouterProfil" :
			break;

		case "ajouterFormulaire" :
			String nom = request.getParameter("nom");
			String type = request.getParameter("type");
			System.out.println("ajout formulaire");
			Formulaire f;
			
			if (type.equals("privee")){
				System.out.println("privee");
				f = new Formulaire(nom,false);
				facade.ajoutFormulaire(f);
			}
			else {
				System.out.println("public");
				f = new Formulaire(nom,true);
				facade.ajoutFormulaire(f);
			}
			
			int idf = f.getId();
			request.setAttribute("idf",String.valueOf(idf));
			request.setAttribute("Formulaire", f);
			request.getRequestDispatcher("ajoutSondages.jsp").forward(request, response);
		
			break;
			
		case "majFormulaire":
			System.out.println("majFormulaire");
			String idf3 = request.getParameter("idf");
			
			Formulaire f2 = facade.trouverFormulaire(idf3);
			
			String question = request.getParameter("question");
			String p1 = request.getParameter("p");
			String p2 = request.getParameter("pp");
			String p3 = request.getParameter("ppp");
			Sondage s = new Sondage();
			s.setQuestion(question);
			if (!p1.equals("")){
				s.addListePropositions(p1);
			}
			if (!p2.equals("")){
				s.addListePropositions(p2);
			}
			if (!p3.equals("")){
				s.addListePropositions(p3);
			}
			
			facade.ajoutSondage(s);
			f2.addListeSondages(s);
			
			request.setAttribute("Formulaire",f2);
			request.setAttribute("idf", idf3);
			request.getRequestDispatcher("ajoutSondages.jsp").forward(request, response);
			break;
			
		
		case "consultation" :
			Collection<Formulaire> lf = facade.getlisteFormulaires();
			System.out.println(lf.size());
			request.setAttribute("listeFormulaires",lf);
			request.getRequestDispatcher("consultation.jsp").forward(request, response);
			break;
			
			
		case "ajoutSondage" :
			String idf2 = request.getParameter("idf");
			request.setAttribute("idf",idf2);
			request.getRequestDispatcher("nouveauSondage.jsp").forward(request, response);
			break;
			
		case "ajoutHastags" :
			String idf4 = request.getParameter("idf");
			request.setAttribute("idf",idf4);
			request.getRequestDispatcher("ajoutHastag.jsp").forward(request, response);
			break;
			
		case "test" :
			System.out.println("test");
			request.getRequestDispatcher("test.jsp").forward(request, response);
			break;
			
		case "finFormulaire" :
			String h1 = request.getParameter("h1");
			String h2 = request.getParameter("h2");
			String h3 = request.getParameter("h3");
			
			String idf5 = request.getParameter("idf");
			
			Formulaire f3 = facade.trouverFormulaire(idf5);
			
			if (!h1.equals("")){
				Hastag ha1 = facade.ajoutHastag(h1);
				f3.addListeHastags(ha1);
				ha1.addListeFormulaires(f3);

			}
			if (!h2.equals("")){
				Hastag ha2 = facade.ajoutHastag(h2);
				f3.addListeHastags(ha2);
				ha2.addListeFormulaires(f3);
			}
			if (!h3.equals("")){
				Hastag ha3 = facade.ajoutHastag(h3);
				f3.addListeHastags(ha3);
				ha3.addListeFormulaires(f3);

			}
			
			request.getRequestDispatcher("index.html").forward(request, response);
			break;
			
		case "accueil" :
			request.getRequestDispatcher("index.html").forward(request, response);
			break;
		
		case "reponseFormulaire" :
			Collection<Formulaire> lf2 = facade.getlisteFormulaires();
			request.setAttribute("listeFormulaires",lf2);
			request.getRequestDispatcher("reponseFormulaire.jsp").forward(request, response);
			break;
			
		case "accesFormulaire" :
			int id = Integer.parseInt(request.getParameter("form"));
			System.out.println(id);
		
		case "recherche" :
			request.setAttribute("echec",false);
			request.getRequestDispatcher("recherche.jsp").forward(request, response);
			break;
			
		case "resultatRecherche" :
			String label = request.getParameter("label");
			Hastag h = facade.getHastag(label);
			if (h == null){
				request.setAttribute("echec",true);
				request.getRequestDispatcher("recherche.jsp").forward(request, response);
			}
			else{
				request.setAttribute("hastag", h);
				request.getRequestDispatcher("resultatRecherche.jsp").forward(request, response);
				
			}
			
			
		case "retour" :
			request.getRequestDispatcher("index.html").forward(request, response);
			break;
		default : 
			break;
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

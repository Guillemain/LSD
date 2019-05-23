package informations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.persistence.EntityExistsException;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import LDAPContact.INPTAccount; // Classe qui nous permet de savoir si l'utilisateur détient bien un compte à l'INPT
import sun.org.mozilla.javascript.internal.UintMap;
/**
 * Servlet implementation class ServletOp
 */
@WebServlet("/ServletOp")
public class ServletOp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String LOGIN = "LOGIN";

	@EJB
	private Facade facade;
	
    /**
     * Default constructor. 
     */
    public ServletOp() {
        // TODO Auto-generated constructor stub
    }
    
    /** Méthode pour obtenir l'id de l'utilisateur et traiter le cas non connecté à l'aide d'une exception*/
    protected String getID(HttpSession session) throws UtilisateurInconnu{
		if(session.getAttribute(LOGIN) == null){
			throw new UtilisateurInconnu();
		}
		return (String) session.getAttribute(LOGIN);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("op");
		String idUser;
		String mdpUser;
		int idProfil;
		Profil profil;
		HttpSession session; // La session de l'utilisateur.
		switch(op){

			case "ajouterUtilisateur" :
				idUser = request.getParameter("id");
				mdpUser = request.getParameter("mdp");
				try {
					facade.ajoutUtilisateur(idUser, mdpUser);
					request.getRequestDispatcher("connexion.jsp").forward(request, response);
				} catch (EmptyFieldException e) {
					request.setAttribute("error","emptyField");
					request.getRequestDispatcher("ajoutUtilisateur.jsp").forward(request, response);	
				} catch (NonMembreINPT e) {
					request.setAttribute("error","Il faut être m'embre de l'INPT pour profiter de ce service");
					request.getRequestDispatcher("ajoutUtilisateur.jsp").forward(request, response);
				}
				catch (Exception e) {
					request.setAttribute("error","doublon");
					request.getRequestDispatcher("ajoutUtilisateur.jsp").forward(request, response);
				}
				break;

			case "connecterUtilisateur" :
				idUser = request.getParameter("id");
				mdpUser = request.getParameter("mdp");
				if (facade.connecterUtilisateur(idUser,mdpUser)) {
					request.getRequestDispatcher("ajoutProfil.jsp").forward(request, response);
					session = request.getSession();
					session.setAttribute(LOGIN, request.getParameter("id"));
				} else {
					request.setAttribute("loginError",true);
					request.getRequestDispatcher("connexion.jsp").forward(request, response);
				}
				break;

			case "ajouterProfil" :
				String profileFirstname = request.getParameter("profileFirstname");
				String profileSurname = request.getParameter("profileSurname");
				String profileGenre = request.getParameter("genre");
				int birthDay = Integer.parseInt(request.getParameter("birthDay"));
				int birthMonth = Integer.parseInt(request.getParameter("birthMonth"));
				int birthYear = Integer.parseInt(request.getParameter("birthYear"));
				try {
					facade.ajoutProfil(profileSurname,profileFirstname,profileGenre,birthDay,birthMonth,birthYear);
					request.getRequestDispatcher("index.html").forward(request, response);
				} catch (EmptyFieldException e) {
					request.setAttribute("error","emptyField");
					request.getRequestDispatcher("ajoutProfil.jsp").forward(request, response);
				} catch (Exception e) {
					request.setAttribute("error","invalidDate");
					request.getRequestDispatcher("ajoutProfil.jsp").forward(request, response);
				}
				break;

			case "consulterProfil" :
				String temp = request.getParameter("idProfil");
				if (!temp.equals("")) {
					idProfil = Integer.parseInt(temp);
					profil = facade.getProfil(idProfil);
					if (profil != null) {
						int age = facade.computeAge(profil.getDateNaissance());
						int score = facade.computeScore(profil.getBadges());
						request.setAttribute("profil", profil);
						request.setAttribute("age", age);
						request.setAttribute("score", score);
						request.getRequestDispatcher("consulterProfil.jsp").forward(request, response);
					} else {
						request.setAttribute("error","notFound");
						request.getRequestDispatcher("rechercheProfil.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("error","notFound");
					request.getRequestDispatcher("rechercheProfil.jsp").forward(request, response);
				}
				break;

			case "ajouterAmi" :
				idProfil = Integer.parseInt(request.getParameter("idProfil"));
				int idAmi = Integer.parseInt(request.getParameter("idAmi"));
				facade.rendreAmis(idProfil,idAmi);
				request.getRequestDispatcher("rechercheProfil.jsp").forward(request,response);
				break;

			case "ajouterFormulaire" :
				String nom = request.getParameter("nom");
				String type = request.getParameter("type");
				//System.out.println("ajout formulaire");
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
				//System.out.println("majFormulaire");
				String idf3 = request.getParameter("idf");
				
				Formulaire f2 = facade.trouverFormulaire(idf3);
				//System.out.println("formulaire dans servlet :"+f2);
				
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
				
				Analyse a = new AnalyseChoix();
				facade.ajoutAnalyse(a);
				facade.ajoutSondage(s);
				//System.out.println("nb sondages avant : "+ f2.getListeSondages().size());
				f2.addListeSondages(s);
				facade.update(f2);
				//System.out.println("nb sondages apres : "+ f2.getListeSondages().size());
				
				request.setAttribute("Formulaire",f2);
				request.setAttribute("idf", idf3);
				request.getRequestDispatcher("ajoutSondages.jsp").forward(request, response);
				break;
				
			
			case "consultation" :
				Collection<Formulaire> lf = facade.getlisteFormulaires();
				//System.out.println(lf.size());
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
				
			case "ajoutReponse" :
				//System.out.println("Ajout de la reponse");
				String idf6 = request.getParameter("idf");
				Formulaire f10 = facade.trouverFormulaire(idf6);
				Collection<Sondage> ls2 = f10.getListeSondages();
				int nb_s = 0;
				for (Sondage s2 : ls2){
					
					String rep = request.getParameter(String.valueOf(nb_s));
					Reponse r = new Reponse();
					r.setSondage(s2);
					r.setChoix(rep);
					facade.ajoutReponse(r);
					facade.update(r);
					s2.addListeReponses(r);
					facade.update(s2);
					nb_s =1;
				}
				request.getRequestDispatcher("index.html").forward(request, response);
				
			case "dernierSondages" :
				
				Collection<Formulaire> lf2dcxc = facade.getFormulairesSortByDates();
				request.setAttribute("listeFormulaires",lf2dcxc);
				request.getRequestDispatcher("reponseFormulaire.jsp").forward(request, response);
				
				
				break;
				
			case "finFormulaire" :
				String ha = request.getParameter("h1");
				String[] hashtags = ha.split(" ");
				
				String idf5 = request.getParameter("idf");
				
				Formulaire f3 = facade.trouverFormulaire(idf5);
				ArrayList<String> labelh = new ArrayList<String>();
				
				for (String h1 : hashtags){
					if (!h1.equals("")){
						
						Hastag ha1 = null;
						try{
							ha1 = facade.ajoutHastag(h1);
						}
						catch (Exception e){
							ha1 = facade.getHastag(h1);
							//System.out.println("recherche de l'hastag");
						}
						labelh.add(h1);
						//System.out.println(ha1);
						//System.out.println(f3);
						f3.addListeHastags(ha1);
						facade.update(ha1);
						//ha1.addListeFormulaires(f3);
						//System.out.println("ajout hashtag 1");
					}
				}
					
				facade.update(f3);
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
				//System.out.println(id);
				Formulaire f6 = facade.trouverFormulaire(String.valueOf(id));
				System.out.println("nombre sondages : "+f6.getListeSondages().size());
				System.out.println("envoi du formulaire pour la reponse");
				request.setAttribute("Formulaire",f6);
				request.getRequestDispatcher("choixDeReponse.jsp").forward(request, response);
				break;
			
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
				break;
				
				
			case "retour" :
				request.getRequestDispatcher("index.html").forward(request, response);
				break;
			default :
				System.out.println("CASE NOT FOUUUUUUUUUUUUUUUUUUUUUUND");
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

package servlet;


import java.io.IOException;
import java.util.Collection;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Facade;

/**
 * Servlet implementation class ServletJsp
 */
@WebServlet("/ServletJsp")
public class ServletJsp extends HttpServlet {

	@EJB
	Facade facade;

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletJsp() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
//		Collection<Personne> listePersonnes;
//		Collection<Adresse> listeAdresses;
		switch (op) {
		case "associer" :
//			listePersonnes = facade.listePersonnes();
//			listeAdresses = facade.listeAdresses();
//		request.setAttribute("listePersonnes", listePersonnes);
//			request.setAttribute("listeAdresses", listeAdresses);
			request.getRequestDispatcher("associer.jsp").forward(request, response);
			break;
		case "lister" :
//			listePersonnes = facade.listePersonnes();
//			request.setAttribute("listePersonnes", listePersonnes);
			request.getRequestDispatcher("lister.jsp").forward(request, response);
			break;
		default :
			response.getWriter().append("Selection non reconnue");
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

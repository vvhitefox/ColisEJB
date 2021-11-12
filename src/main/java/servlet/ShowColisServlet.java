package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.EJBColis;
import jpa.Colis;
import jpa.Mesure;

/**
 * Servlet implementation class AddMesureServlet
 */
@WebServlet("/ShowColisServlet")
public class ShowColisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// injection de la reference de l'ejb
	@EJB
	private EJBColis ejb;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowColisServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperation et parsing des parametres de la requete
		long Id = Long.parseLong(request.getParameter("ID"));
	
		// appel de l'ejb
		Colis m = ejb.findColis(Id);		
		
		request.setAttribute("Colis",m);
		// transfert a la JSP d'affichage
		request.getRequestDispatcher("/showColis.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

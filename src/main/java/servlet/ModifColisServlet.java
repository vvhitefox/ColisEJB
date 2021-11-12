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
import jpa.Position;

/**
 * Servlet implementation class AddMesureServlet
 */
@WebServlet("/ModifColisServlet")
public class ModifColisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// injection de la reference de l'ejb
	@EJB
	private EJBColis ejb;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifColisServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		double latitude = Double.parseDouble(request.getParameter("lat"));
	    double longitude = Double.parseDouble(request.getParameter("long")) ;;
	
		String emplacement = request.getParameter("emplacement");
		String etat = request.getParameter("etat");
		

		
		// recuperation et parsing des parametres de la requete
		long Id = Long.parseLong(request.getParameter("ID"));
	
		// appel de l'ejb
		Colis m = ejb.findColis(Id);
		if(m == null)
			return;
		Position P = ejb.changePosition(Id, latitude, longitude, emplacement, etat);		
		// ajout de la mesure dans la requete
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

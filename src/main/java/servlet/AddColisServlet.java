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
@WebServlet("/AddColisServlet")
public class AddColisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// injection de la reference de l'ejb
	@EJB
	private EJBColis ejb;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddColisServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double Poid = Double.parseDouble(request.getParameter("poid"));
		double valeur = Double.parseDouble(request.getParameter("valeur")) ;
		String origine = request.getParameter("origine");
		String destination = request.getParameter("destination");
		Position position = null;
		
		
		
		
		Colis m = ejb.addColis(Poid, valeur, origine, destination, position);		
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

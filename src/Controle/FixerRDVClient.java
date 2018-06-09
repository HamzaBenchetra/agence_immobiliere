package Controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Fonctions;
import Model.OperationsOperateur;

/**
 * Servlet implementation class FixerRDVClient
 */
@WebServlet("/FixerRDVClient")
public class FixerRDVClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FixerRDVClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	//	s.setAttribute("idClient",request.getParameter("idC"));
		
		request.setAttribute("List", Fonctions.listesdatesdispo(1));
		request.setAttribute("nomClient", request.getParameter("nomC")+" "+request.getParameter("prenomC"));
		this.getServletContext().getRequestDispatcher("/FixerRDVClient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String date=request.getParameter("date");
		String heure=request.getParameter("heure");
		request.setAttribute("List", Fonctions.listesdatesdispo(1));

		boolean b = OperationsOperateur.FixerRdvOperateur(1,1,"'"+date+" "+heure+"'");
		this.getServletContext().getRequestDispatcher("http://localhost:8080/AgenceImmobiliere/FixerRDVClient").forward(request, response);


	}

}

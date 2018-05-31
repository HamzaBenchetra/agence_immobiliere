package Controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Appartement;
import Model.OperationsOperateur;

/**
 * Servlet implementation class RechercherAppartOperateurAchat
 */
@WebServlet("/RechercherAppartOperateurAchat")
public class RechercherAppartOperateurAchat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercherAppartOperateurAchat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String localite=request.getParameter("localite");
		String type=request.getParameter("type");
		int etage = Integer.parseInt(request.getParameter("etage"));
		ArrayList<Appartement> a = new ArrayList<Appartement>();
		a=OperationsOperateur.AfficherAppart(localite, type, etage);
		request.setAttribute("Apparts", a);
		this.getServletContext().getRequestDispatcher("/ListAppartAchat.jsp").forward(request, response);
		
	}

}

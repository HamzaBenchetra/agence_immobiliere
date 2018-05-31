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

@WebServlet("/RechercherAppartOperateur")
public class RechercherAppartOperateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RechercherAppartOperateur() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/FixerRDVOp.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String localite=request.getParameter("localite");
		String type=request.getParameter("type");
		int etage = Integer.parseInt(request.getParameter("etage"));
		ArrayList<Appartement> a = new ArrayList<Appartement>();
		a=OperationsOperateur.AfficherAppart(localite, type, etage);
		request.setAttribute("Apparts", a);
		this.getServletContext().getRequestDispatcher("/ListeAppartsOperateur.jsp").forward(request, response);
		
		
		
	}

}

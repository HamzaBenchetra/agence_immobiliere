package Controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.OperationsOperateur;
import Model.RDV;

/**
 * Servlet implementation class RdvAcheuteur
 */
@WebServlet("/RdvAcheteur")
public class RdvAcheteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RdvAcheteur() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tel=request.getParameter("numtel");
		System.out.println(tel);
		int i=OperationsOperateur.verifierClient(tel);
		HttpSession s=request.getSession(true);
		s.setAttribute("idAch", i);

		if(i!=0) {
			ArrayList<RDV> R=OperationsOperateur.RecupererListeRDV(tel);
			request.setAttribute("L", R);
			this.getServletContext().getRequestDispatcher("/AfficherListeRDVAcheteur.jsp").forward(request, response);
		}else {
			this.getServletContext().getRequestDispatcher("/CreerCompteAcheteur.jsp").forward(request, response);
		}
		
		
	
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("IDR"));
		System.out.print(id);
		RDV R=OperationsOperateur.RecupererRDVAcheteur(id);
		HttpSession s=request.getSession(true);
		s.setAttribute("RDV", R);
		request.setAttribute("r", R);
		this.getServletContext().getRequestDispatcher("/AfficherRDVAcheteur.jsp").forward(request, response);

	}

}

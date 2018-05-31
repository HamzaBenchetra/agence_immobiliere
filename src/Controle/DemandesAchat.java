package Controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Appartement;
import Model.Client;
import Model.Fonctions;
import Model.OperationsClient;

@WebServlet("/DemandesAchat")
public class DemandesAchat extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DemandesAchat() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.setAttribute("L", Fonctions.RecupererListeDemandesA());
		this.getServletContext().getRequestDispatcher("/AfficherDemandes.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession(true);
		Appartement A=OperationsClient.AfficherAppart(Integer.parseInt(request.getParameter("IDAppart")));
		Client C=Fonctions.AfficherClient(Integer.parseInt(request.getParameter("IDClient")));
		request.setAttribute("A", A);
		s.setAttribute("C", C);
		this.getServletContext().getRequestDispatcher("/AfficherDetailsDemandes.jsp").forward(request, response);

	}

}

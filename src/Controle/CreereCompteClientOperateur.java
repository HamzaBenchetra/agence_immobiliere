package Controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.OperationsOperateur;

@WebServlet("/CreereCompteClientOperateur")
public class CreereCompteClientOperateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CreereCompteClientOperateur() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String tel=request.getParameter("numtel");
		int id=OperationsOperateur.creerCompteClient(nom,prenom,tel);
		HttpSession s=request.getSession(true);
		s.setAttribute("idC", id);
		this.getServletContext().getRequestDispatcher("/FixerRDVOperateurClient.jsp").forward(request, response);
	}

}

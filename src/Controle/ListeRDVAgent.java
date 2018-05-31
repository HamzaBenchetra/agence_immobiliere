package Controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Fonctions;

@WebServlet("/ListeRDVAgent")
public class ListeRDVAgent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ListeRDVAgent() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession(true);
		int i=(int)s.getAttribute("idA");
		request.setAttribute("RDV",Fonctions.RecupererListeRDVAgent(i));
		

		this.getServletContext().getRequestDispatcher("/ListeRDVAgent.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

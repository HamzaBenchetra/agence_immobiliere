package Controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Fonctions;

@WebServlet("/DonnerPreavis")
public class DonnerPreavis extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DonnerPreavis() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession(true);
		int i=(int)s.getAttribute("idA");
		request.setAttribute("RDVE",Fonctions.RecupererListeRDVAgentE(i));
		this.getServletContext().getRequestDispatcher("/ListeRDVAgentEffectue.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

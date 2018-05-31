package Controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ControleAppartement")
public class ControleAppartement extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ControleAppartement() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String r=request.getParameter("what");
		switch (r) {
		case "add":
			this.getServletContext().getRequestDispatcher("/AjouterAppart.jsp").forward(request, response);
			break;
		case "mod":
			this.getServletContext().getRequestDispatcher("/ModifierAppart.jsp").forward(request, response);
			break;
		case "del":
			this.getServletContext().getRequestDispatcher("/SupprimerAppart.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

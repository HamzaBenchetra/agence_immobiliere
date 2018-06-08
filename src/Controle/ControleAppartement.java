package Controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Appartement;
import Model.OperationsAdmin;


@WebServlet("/ControleAppartement")
public class ControleAppartement extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ControleAppartement() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession(true);
		
		String r=request.getParameter("what");
		String q=(String)s.getAttribute("type");
		request.setAttribute("msg", " ");
		switch(q) {
		case("Admin") : switch (r) {
						case "add":
							this.getServletContext().getRequestDispatcher("/AjouterAppart.jsp").forward(request, response);
							break;
						case "mod":
							this.getServletContext().getRequestDispatcher("/ModifierAppart.jsp").forward(request, response);
							break;
						default:
							break;
						}
		}
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String r=request.getParameter("what");
		Appartement a=new Appartement();
		switch (r) {
		case "add":
			a.setIdBatiment(Integer.parseInt(request.getParameter("IdBat")));
			a.setEtage(Integer.parseInt(request.getParameter("etage")));
			a.setType(request.getParameter("Type"));
			a.setPrix(Integer.parseInt(request.getParameter("prix")));
			a.setDescription(request.getParameter("description"));
			OperationsAdmin.AjouterAppart(a);
			request.setAttribute("msg", "OK");
			this.getServletContext().getRequestDispatcher("/AjouterAppart.jsp").forward(request, response);
			break;
		case "mod":
			a.setIdAppart(Integer.parseInt(request.getParameter("IdApp")));
			a.setIdBatiment(Integer.parseInt(request.getParameter("IdBat")));
			a.setEtage(Integer.parseInt(request.getParameter("etage")));
			a.setType(request.getParameter("Type"));
			a.setPrix(Integer.parseInt(request.getParameter("prix")));
			a.setDescription(request.getParameter("description"));
			OperationsAdmin.ModifierAppart(a);
			request.setAttribute("msg", "OK");
			this.getServletContext().getRequestDispatcher("/ModifierAppart.jsp").forward(request, response);
			break;
		case "del":
			this.getServletContext().getRequestDispatcher("/SupprimerAppart.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}

}

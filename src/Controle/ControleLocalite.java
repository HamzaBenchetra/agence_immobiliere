package Controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Fonctions;
import Model.Localite;
import Model.OperationsAdmin;


@WebServlet("/ControleLocalite")
public class ControleLocalite extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ControleLocalite() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String r=request.getParameter("what");
		request.setAttribute("msg", " ");
		switch (r) {
		case "add":
			this.getServletContext().getRequestDispatcher("/AjouterLocalite.jsp").forward(request, response);
			break;
		case "mod":
			ArrayList<Localite> L=Fonctions.ListeLocalitees();
			request.setAttribute("LL", L);
			this.getServletContext().getRequestDispatcher("/ModifierLocalite.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String r=request.getParameter("what");
		
		switch (r) {
		case "add":
			OperationsAdmin.AjouterLocalite(request.getParameter("nomLocalite"));
			request.setAttribute("msg", "OK");
			this.getServletContext().getRequestDispatcher("/AjouterLocalite.jsp").forward(request, response);
			break;
		case "mod":
			OperationsAdmin.ModifierLocalite(Integer.parseInt(request.getParameter("idLocalite")),request.getParameter("NVnomLocalite"));
			request.setAttribute("msg", "OK");
			ArrayList<Localite> L=Fonctions.ListeLocalitees();
			request.setAttribute("LL", L);
			this.getServletContext().getRequestDispatcher("/ModifierLocalite.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}

}

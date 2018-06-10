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
import Model.Region;

@WebServlet("/ControleRegion")
public class ControleRegion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleRegion() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession()==null||request.getSession().getAttribute("type")==null) {
			System.out.println(request.getSession().getAttribute("type"));
			this.getServletContext().getRequestDispatcher("/LoginAdmin").forward(request, response);;
		}else {
		String r=request.getParameter("what");
		request.setAttribute("msg", " ");
		switch (r) {
		case "add":
			ArrayList<Localite> L=Fonctions.ListeLocalitees();
			request.setAttribute("LL", L);
			this.getServletContext().getRequestDispatcher("/AjouterRegion.jsp").forward(request, response);
			break;
		case "mod":
			ArrayList<Region> LR=Fonctions.ListeRegions();
			request.setAttribute("LR", LR);
			this.getServletContext().getRequestDispatcher("/ModifierRegion.jsp").forward(request, response);
			break;
		default:
			break;
		}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession()==null||request.getSession().getAttribute("type")==null) {
			System.out.println(request.getSession().getAttribute("type"));
			this.getServletContext().getRequestDispatcher("/LoginAdmin").forward(request, response);;
		}else {
		String r=request.getParameter("what");
		
		switch (r) {
		case "add":
			OperationsAdmin.AjouterRegion(Integer.parseInt(request.getParameter("idLocalite")),request.getParameter("nomRegion"));
			ArrayList<Localite> L=Fonctions.ListeLocalitees();
			request.setAttribute("LL", L);
			request.setAttribute("msg", "OK");
			this.getServletContext().getRequestDispatcher("/AjouterRegion.jsp").forward(request, response);
			break;
		case "mod":
			OperationsAdmin.ModifierRegion(Integer.parseInt(request.getParameter("idRegion")),request.getParameter("NVnomRegion"));
			ArrayList<Region> LR=Fonctions.ListeRegions();
			for(Region R:LR)
				System.out.println(R.getIdRegion()+" "+R.getNomRegion());
			request.setAttribute("LR", LR);
			request.setAttribute("msg", "OK");
			this.getServletContext().getRequestDispatcher("/ModifierRegion.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}
	}
}

package Controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Fonctions;
import Model.OperationsAdmin;
import Model.Region;

@WebServlet("/ControleBatiment")
public class ControleBatiment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleBatiment() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession()==null||request.getSession().getAttribute("type")==null) {
			System.out.println(request.getSession().getAttribute("type"));
			this.getServletContext().getRequestDispatcher("/LoginAdmin").forward(request, response);
		}else {
			String r=request.getParameter("what");
			request.setAttribute("msg", " ");
			switch (r) {
			case "add":
				ArrayList<Region> LR=Fonctions.ListeRegions();
				request.setAttribute("LR", LR);
				this.getServletContext().getRequestDispatcher("/AjouterBatiment.jsp").forward(request, response);
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
				OperationsAdmin.AjouterBatiment(Integer.parseInt(request.getParameter("idRegion")),Integer.parseInt(request.getParameter("nbrEtages")),Integer.parseInt(request.getParameter("nbrApparts")));
				ArrayList<Region> LR=Fonctions.ListeRegions();
				request.setAttribute("LR", LR);
				request.setAttribute("msg", "OK");
				this.getServletContext().getRequestDispatcher("/AjouterBatiment.jsp").forward(request, response);
				break;
			
			default:
				break;
			}
		}
		}
	}

package Controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Fonctions;
import Model.Preaviss;

@WebServlet("/Preavis")
public class Preavis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Preavis() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d;
		
		int idAG=Integer.parseInt(request.getParameter("IDAG"));
		int idRDV=Integer.parseInt(request.getParameter("IDRDV"));
		HttpSession s=request.getSession(true);
		s.setAttribute("IDAG",idAG);
		s.setAttribute("IDRDV",idRDV);
		 d = request.getRequestDispatcher("/detailpreavis.jsp");	
		d.forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		int avis=Integer.parseInt(request.getParameter("avis"));
		String contenu=request.getParameter("contenu");
		HttpSession s=request.getSession(true);
		int idAG=(int) s.getAttribute("IDAG");
		int idRDV=(int) s.getAttribute("IDRDV");
		Preaviss p =new Preaviss();
		p.setIdAgent(idAG);
		p.setIdRDV(idRDV);
		p.setAvis(avis);
		p.setC(contenu);
		if(Fonctions.DonnerPRV(p)) {
			out.print("preavis enregistrer");
			
		}
		
		
	}
}

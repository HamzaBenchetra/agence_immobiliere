package Controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.OperationsClient;

@WebServlet("/PrendreRDV")
public class PrendreRDV extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PrendreRDV() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("IDApp"));
		
		HttpSession s = request.getSession();
		//request.setAttribute("IDApp", id);//idappart
		s.setAttribute("IDAP", id);		
		this.getServletContext().getRequestDispatcher("/PrendreRDV.jsp").forward(request, response);
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession(true);	
		int idC=(int) s.getAttribute("id");
		
	//	int idA=(int) request.getAttribute("IDApp");
		
		
		
		
		int i=(int) s.getAttribute("IDAP");
		System.out.println(i);
		
		String date=request.getParameter("date");
		String heure=request.getParameter("heure");
		boolean b;		
		b=OperationsClient.prendreRDV(idC, i,"'"+date+" "+heure+"'");
		if(b)
			request.setAttribute("msg", "Votre Rendez-vous est fixé");
		else
			request.setAttribute("msg", "Cette date n'est pas disponible");
		
		this.getServletContext().getRequestDispatcher("/Reponse.jsp").forward(request, response);
	}

}

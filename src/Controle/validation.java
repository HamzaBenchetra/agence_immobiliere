package Controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Fonctions;

@WebServlet("/validation")
public class validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public validation() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession s=request.getSession(true);
			if(s.isNew()) {
				s.invalidate();
				this.getServletContext().getRequestDispatcher("/Mustlogin.jsp").forward(request, response);
			}else {
				if(((String) s.getAttribute("type")).equalsIgnoreCase("Admin")) {
					request.setAttribute("TypeVal", null);
					this.getServletContext().getRequestDispatcher("/AfficherListDemandes.jsp").forward(request, response);
				}else {
					this.getServletContext().getRequestDispatcher("/AccessDenied.jsp").forward(request, response);

				}
			}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher ds ;
		String rep=request.getParameter("valid");
		String typeVal=request.getParameter("TypeVal");
		switch(rep) {
		
		case "oui" :{
			switch(typeVal){
					case "Operateur":{
							int id=Integer.parseInt(request.getParameter("IDO"));
							String type=request.getParameter("TypeVal");
							Fonctions.Valider(id,type);
							this.getServletContext().getRequestDispatcher("/AfficherListDemandes.jsp").forward(request, response);
							}break;
					
					case "Agent":{
							int id=Integer.parseInt(request.getParameter("IDA"));
							String type=request.getParameter("TypeVal");
							Fonctions.Valider(id,type);
							this.getServletContext().getRequestDispatcher("/AfficherListDemandes.jsp").forward(request, response);
							}break;
							
					case "Client":{
							int id=Integer.parseInt(request.getParameter("IDC"));
							String type=request.getParameter("TypeVal");
							Fonctions.Valider(id,type);
							this.getServletContext().getRequestDispatcher("/AfficherListDemandes.jsp").forward(request, response);
							}break;
		}break;
		}case "non" :{ 
			ds =request.getRequestDispatcher("/AfficherListDemandes.jsp");	
			ds.forward(request, response);
		}break;

		}
		}

}

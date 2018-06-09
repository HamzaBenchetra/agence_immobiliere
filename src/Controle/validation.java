package Controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.OperationsAdmin;

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
		String rep=request.getParameter("valid");
		String typeVal=request.getParameter("TypeVal");
		HttpSession s=request.getSession(true); 
		int idAdmin=(int) s.getAttribute("id");
		switch(rep) {
		
		case "oui" :{
			switch(typeVal){
					case "Operateur":{
							int id=Integer.parseInt(request.getParameter("IDO"));
							String type=request.getParameter("TypeVal");
							
							OperationsAdmin.Valider(idAdmin,id,type);
							this.getServletContext().getRequestDispatcher("/AfficherListDemandes.jsp").forward(request, response);
							}break;
					
					case "Agent":{
							int id=Integer.parseInt(request.getParameter("IDA"));
							String type=request.getParameter("TypeVal");
							OperationsAdmin.Valider(idAdmin,id,type);
							this.getServletContext().getRequestDispatcher("/AfficherListDemandes.jsp").forward(request, response);
							}break;
							
					case "Client":{
							int id=Integer.parseInt(request.getParameter("IDC"));
							String type=request.getParameter("TypeVal");
							OperationsAdmin.Valider(idAdmin,id,type);
							this.getServletContext().getRequestDispatcher("/AfficherListDemandes.jsp").forward(request, response);
							}break;
					}break;
		}case "non" :{ 
			switch (typeVal) {
			case "Operateur":{int id=Integer.parseInt(request.getParameter("IDO"));
					OperationsAdmin.SupprimerDemande(id,"Operateur");
					this.getServletContext().getRequestDispatcher("/AfficherListDemandes.jsp").forward(request, response);
			}break;
			case "Agent":{int id=Integer.parseInt(request.getParameter("IDA"));
					OperationsAdmin.SupprimerDemande(id,"Agent");
					this.getServletContext().getRequestDispatcher("/AfficherListDemandes.jsp").forward(request, response);
			}break;
			case "Client":{int id=Integer.parseInt(request.getParameter("IDC"));
					OperationsAdmin.SupprimerDemande(id,"Client");
					this.getServletContext().getRequestDispatcher("/AfficherListDemandes.jsp").forward(request, response);
			}break;

			default:
				break;
			}
		}break;

		}
		}

}

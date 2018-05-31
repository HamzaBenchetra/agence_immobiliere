package Controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.OperationsOperateur;

@WebServlet("/DemanderAchat")
public class DemanderAchat extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DemanderAchat() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession(true);
	//	RDV r=(RDV) s.getAttribute("RDV");
		
		int idAp= Integer.parseInt(request.getParameter("IDA"));
		int idAch=(int) s.getAttribute("idAch");
		OperationsOperateur.insererDemande(idAp,idAch);
		this.getServletContext().getRequestDispatcher("/DemandeOK.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

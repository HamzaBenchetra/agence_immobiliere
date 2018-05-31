package Controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.OperationsOperateur;

@WebServlet("/VerifierClientOperateur")
public class VerifierClientOperateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public VerifierClientOperateur() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession(true);
		s.setAttribute("idApp", request.getParameter("IDA"));
		this.getServletContext().getRequestDispatcher("/RechercheClientOperateur.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession(true);
		
		String tel=request.getParameter("numtel");
		int i=OperationsOperateur.verifierClient(tel);
		if(i!=0) {
			s.setAttribute("idC", i);
			this.getServletContext().getRequestDispatcher("/FixerRDVOperateurClient.jsp").forward(request, response);
		}else {
			this.getServletContext().getRequestDispatcher("/CreerCompteClient.jsp").forward(request, response);
		}
	}

}

package Controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.OperationsOperateur;

@WebServlet("/FixerRDVOperateur")
public class FixerRDVOperateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FixerRDVOperateur() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession  s=request.getSession(true);
		int idAppartement=Integer.parseInt((String) s.getAttribute("idApp"));
		int idClient=(int) s.getAttribute("idC");
		String date=request.getParameter("date");
		String heure=request.getParameter("heure");
		
		boolean b = OperationsOperateur.FixerRdvOperateur(idAppartement,idClient,"'"+date+" "+heure+"'");
		if(b) {
			System.out.println("felicitations");
		this.getServletContext().getRequestDispatcher("/NewFile.jsp").forward(request, response);
		}else {
		this.getServletContext().getRequestDispatcher("/Reponse.jsp").forward(request, response);
		}
	}

}

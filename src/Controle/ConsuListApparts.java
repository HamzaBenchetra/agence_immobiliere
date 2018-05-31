package Controle;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Appartement;
import Model.OperationsClient;

@WebServlet("/ConsuListApparts")
public class ConsuListApparts extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ConsuListApparts() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Appartement> allA = OperationsClient.RecupererListeApparts();
		request.setAttribute("Apparts", allA);
		this.getServletContext().getRequestDispatcher("/AfficherListeAppartements.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id=Integer.parseInt(request.getParameter("IDA"));
	Appartement a=OperationsClient.AfficherAppart(id);
	request.setAttribute("appartement", a);
	request.setAttribute("IDApp", id);
	this.getServletContext().getRequestDispatcher("/AfficherAppart.jsp").forward(request, response);
	}

}

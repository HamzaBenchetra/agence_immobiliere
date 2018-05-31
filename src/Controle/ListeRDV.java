package Controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.OperationsClient;
import Model.RDV;

@WebServlet("/ListeRDV")
public class ListeRDV extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ListeRDV() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession(true);
		int ID=(int) s.getAttribute("id");
		ArrayList<RDV> L=OperationsClient.RecupererListeRDV(ID);
		request.setAttribute("RDVs", L);
		this.getServletContext().getRequestDispatcher("/ListeRDV.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

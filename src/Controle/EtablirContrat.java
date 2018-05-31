package Controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Fonctions;
import Model.Impression;

@WebServlet("/EtablirContrat")
public class EtablirContrat extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EtablirContrat() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idc=Integer.parseInt(request.getParameter("IDC"));
		int idA=Integer.parseInt(request.getParameter("IDA"));
		Fonctions.EtablirC(idc,idA);
		Impression.imprimerContrat();
		this.getServletContext().getRequestDispatcher("/ContratOK.jsp").forward(request, response);
		
	}

}

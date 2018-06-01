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

/**
 * Servlet implementation class ListAppartGlobale
 */
@WebServlet("/ListAppartGlobale")
public class ListAppartGlobale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAppartGlobale() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		   ArrayList<Integer> Etage =OperationsClient.RecupererEtage();
		   ArrayList<String> Localite =OperationsClient.RecupererLocalite();
		   ArrayList<String> type =OperationsClient.RecupererTypeAppart();

		   ArrayList<Appartement> A =OperationsClient.RecupererListeApparts();
		   request.setAttribute("ListAppart",A);
		   request.setAttribute("ListEtage",Etage);
		   request.setAttribute("ListLocalite",Localite);
		   request.setAttribute("ListType",type);
		   this.getServletContext().getRequestDispatcher("/Internaute.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

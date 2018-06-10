package Controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String i=(String) request.getAttribute("msg");
		System.out.println(i);
		   ArrayList<Integer> Etage =OperationsClient.RecupererEtage();
		   ArrayList<String> Localite =OperationsClient.RecupererLocalite();
		   ArrayList<String> type =OperationsClient.RecupererTypeAppart();
		   ArrayList<String> secteur =OperationsClient.RecupererSecteur();

		   ArrayList<Appartement> A =OperationsClient.RecupererListeApparts();
		   request.setAttribute("ListAppart",A);
		   request.setAttribute("ListEtage",Etage);
		   request.setAttribute("ListLocalite",Localite);
		   request.setAttribute("ListType",type);
		   request.setAttribute("Secteur",secteur);
		   
		   

			if(request.getSession()==null||request.getSession().getAttribute("type")==null) {
				System.out.println(request.getSession().getAttribute("type"));
				   this.getServletContext().getRequestDispatcher("/Internaute.jsp").forward(request, response);
			}else {
				HttpSession s=request.getSession(true);
				   this.getServletContext().getRequestDispatcher("/Client.jsp").forward(request, response);

			}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

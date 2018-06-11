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
 * Servlet implementation class ListAppartRech
 */
@WebServlet("/ListAppartRech")
public class ListAppartRech extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAppartRech() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type=request.getParameter("type");
		
		String Loc=request.getParameter("localite");
		String Secteur=request.getParameter("Secteur");
		int etage=Integer.parseInt(request.getParameter("etage"));
		int minPrix=Integer.parseInt(request.getParameter("minPrix"));
		int maxPrix=Integer.parseInt(request.getParameter("maxPrix"));

		System.out.println(type);
		System.out.println(Loc);
		System.out.println(Secteur);
		System.out.println(etage);
		System.out.println(minPrix);
		System.out.println(maxPrix);
		
		System.out.println("hna sa3");
		ArrayList<Appartement> A =OperationsClient.RechercherAppart(Loc, type, etage, Secteur,minPrix,maxPrix );
		   request.setAttribute("ListAppart",A);
			System.out.println(A.size());

		   
		   
		   if(request.getSession()==null||request.getSession().getAttribute("type")==null) {
				System.out.println(request.getSession().getAttribute("type"));
				   this.getServletContext().getRequestDispatcher("/listAppart.jsp").forward(request, response);	
			}else {
				HttpSession s=request.getSession(true);
				   this.getServletContext().getRequestDispatcher("/listAppartClient.jsp").forward(request, response);	

			}
		   }
	}



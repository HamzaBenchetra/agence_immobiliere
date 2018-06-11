package Controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Fonctions;
import Model.OperationsClient;

/**
 * Servlet implementation class ModifierPreavis
 */
@WebServlet("/ModifierPreavis")
public class ModifierPreavis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierPreavis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession()==null||request.getSession().getAttribute("type")==null) {
			System.out.println(request.getSession().getAttribute("type"));
			this.getServletContext().getRequestDispatcher("/LoginEmploye").forward(request, response);;
		}else {
		int i=(Integer.parseInt(request.getParameter("idPreavis")));
		HttpSession s=request.getSession(true);
		s.setAttribute("idPrv",i);
		this.getServletContext().getRequestDispatcher("/ModifierPreavis.jsp").forward(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession()==null||request.getSession().getAttribute("type")==null) {
			System.out.println(request.getSession().getAttribute("type"));
			this.getServletContext().getRequestDispatcher("/LoginEmploye").forward(request, response);;
		}else {
		HttpSession s=request.getSession(true);
	
			int idPRV=(int) s.getAttribute("idPrv");
		int avis=Integer.parseInt(request.getParameter("avis"));
			String c=request.getParameter("contenu");
	 OperationsClient.ModifierPreavis(idPRV, avis, c);
	
		
	//	System.out.println(idAppart);
		this.getServletContext().getRequestDispatcher("Agent.jsp").forward(request, response);
		
		
	}
	}
}

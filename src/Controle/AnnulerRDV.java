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
 * Servlet implementation class AnnulerRDV
 */
@WebServlet("/AnnulerRDV")
public class AnnulerRDV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnulerRDV() {
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
			
			   this.getServletContext().getRequestDispatcher("/LoginServlet").forward(request, response);

		}else {
		//	HttpSession s=request.getSession(true);
			int idRDV=Integer.parseInt((String)request.getParameter("idRDV"));
	//		s.setAttribute("idAppart",idAppart);
			OperationsClient.AnnulerRDV(idRDV);
			   this.getServletContext().getRequestDispatcher("/ListeRDV").forward(request, response);
			   
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

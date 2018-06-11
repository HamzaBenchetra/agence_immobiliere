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
import Model.OperationsOperateur;
import Model.RDV;

/**
 * Servlet implementation class ConsulterRDVOP
 */
@WebServlet("/ConsulterRDVOP")
public class ConsulterRDVOP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsulterRDVOP() {
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
	//	RDV r=(RDV) s.getAttribute("RDV");
		
	//	int idAp= Integer.parseInt(request.getParameter("IDA"));
		//int idAch=(int) s.getAttribute("idAch");
		//OperationsOperateur.insererDemande(idAp,idAch);
		ArrayList<RDV>r=OperationsClient.RecupererListeRDV();
		
		request.setAttribute("ListRDV",r);

		this.getServletContext().getRequestDispatcher("/ConsulterRDVOP.jsp").forward(request, response);
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

package Controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Fonctions;
import Model.OperationsOperateur;

/**
 * Servlet implementation class FixerRDVClient
 */
@WebServlet("/FixerRDVClient")
public class FixerRDVClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FixerRDVClient() {
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
			HttpSession s=request.getSession(true);
			int idAppart=Integer.parseInt((String)request.getParameter("idAppart"));
			s.setAttribute("idAppart",idAppart);
			request.setAttribute("List", Fonctions.listesdatesdispo(idAppart));
			   this.getServletContext().getRequestDispatcher("/FixerRDVClient.jsp").forward(request, response);
			   
		}
	}
	
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	int idAppart=(int)request.getParameter("idAppart");
		HttpSession s=request.getSession(true);
		int idAppart=(int) s.getAttribute("idAppart");
			int id=(int) s.getAttribute("id");
			String date=request.getParameter("date");
		String heure=request.getParameter("heure");
		//request.setAttribute("List", Fonctions.listesdatesdispo(1));

		boolean b = OperationsOperateur.FixerRdvOperateur(idAppart,id,"'"+date+" "+heure+"'");
		request.setAttribute("msg","okkkkkkkkkkkkkk");
		System.out.println(idAppart);
		this.getServletContext().getRequestDispatcher("/ListAppartGlobale").forward(request, response);


	}

}

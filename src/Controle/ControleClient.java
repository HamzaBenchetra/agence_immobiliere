package Controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.OperationsAdmin;

@WebServlet("/ControleClient")
public class ControleClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ControleClient() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String what=request.getParameter("what");
		switch (what) {
		case "block":
			this.getServletContext().getRequestDispatcher("/BloquerClient.jsp").forward(request, response);		
			break;
		case "cons":
			this.getServletContext().getRequestDispatcher("/ConsulterClient.jsp").forward(request, response);
			break;
		case "del":
			this.getServletContext().getRequestDispatcher("/SupprimerClient.jsp").forward(request, response);
			break;

		default:
			break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String what=request.getParameter("what");
		switch (what) {
		case "block":
			
			OperationsAdmin.BloquerClient(Integer.parseInt(request.getParameter("idClient")));
			request.setAttribute("msg", "OK");
			this.getServletContext().getRequestDispatcher("/BloquerClient.jsp").forward(request, response);		
			break;
		case "cons":
			this.getServletContext().getRequestDispatcher("/ConulterClient.jsp").forward(request, response);
			break;
		case "del":
			this.getServletContext().getRequestDispatcher("/SupprimerClient.jsp").forward(request, response);
			break;

		default:
			break;
		}
	}

}

package Controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.OperationsAdmin;

@WebServlet("/ControleAgent")
public class ControleAgent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleAgent() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession()==null||request.getSession().getAttribute("type")==null) {
			this.getServletContext().getRequestDispatcher("/LoginAdmin").forward(request, response);;
		}else {
			request.setAttribute("msg", " ");
			this.getServletContext().getRequestDispatcher("/AffecterAgent.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession()==null||request.getSession().getAttribute("type")==null) {
			this.getServletContext().getRequestDispatcher("/LoginAdmin").forward(request, response);;
		}else {
			int idA=Integer.parseInt(request.getParameter("idAgent"));
			int idL=Integer.parseInt(request.getParameter("Localite"));
			System.out.println(idA+"  "+idL);
			OperationsAdmin.ReaffecterAgent(idA,idL);
			request.setAttribute("msg", "OK");
			this.getServletContext().getRequestDispatcher("/AffecterAgent.jsp").forward(request, response);
		}
	}

}

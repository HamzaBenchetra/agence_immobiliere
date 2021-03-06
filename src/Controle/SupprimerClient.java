package Controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Fonctions;

@WebServlet("/SupprimerClient")
public class SupprimerClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SupprimerClient() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession()==null||request.getSession().getAttribute("type")==null) {
			System.out.println(request.getSession().getAttribute("type"));
			this.getServletContext().getRequestDispatcher("/LoginAdmin").forward(request, response);;
		}else {
		HttpSession s=request.getSession(true);
		
			if(((String) s.getAttribute("type")).equalsIgnoreCase("Admin")) {
				Fonctions.SupprimerClient(Integer.parseInt(request.getParameter("IDC")));
				this.getServletContext().getRequestDispatcher("/AfficherListClient.jsp").forward(request, response);
			}else {
				this.getServletContext().getRequestDispatcher("/AccessDenied.jsp").forward(request, response);

			}
		
	}}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

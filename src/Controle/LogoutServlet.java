 package Controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LogoutServlet() {
        super();
    }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if (request.getSession()==null||request.getSession().getAttribute("type")==null) {
		this.getServletContext().getRequestDispatcher("/LoginServlet").forward(request, response);;
	}else {
		String t=(String) request.getSession().getAttribute("type");
		switch(t) {
		case("Admin") : request.getSession().invalidate();
		response.sendRedirect("/AgenceImmobiliere/LoginAdmin");break;
		case("Operateur") : request.getSession().invalidate();
		response.sendRedirect("/AgenceImmobiliere/LoginEmploye");break;
		case("Agent") : request.getSession().invalidate();
		response.sendRedirect("/AgenceImmobiliere/LoginEmploye");break;
		case("Client") : request.getSession().invalidate();
		response.sendRedirect("/AgenceImmobiliere/ListAppartGlobale");break;
		case("respventes") : request.getSession().invalidate();
		response.sendRedirect("/AgenceImmobiliere/LoginEmploye");break;
		}
		
		
		
	
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

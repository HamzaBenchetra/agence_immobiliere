 package Controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LogoutServlet() {
        super();
    }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession s=request.getSession(true);
	if (s.isNew()) {
		s.invalidate();
		response.sendRedirect("/AgenceImmobiliere/LoginServlet");
	}else {
		String t=(String) s.getAttribute("type");
		switch(t) {
		case("Admin") : s.invalidate();
		response.sendRedirect("/AgenceImmobiliere/LoginAdmin");break;
		case("Operateur") : s.invalidate();
		response.sendRedirect("/AgenceImmobiliere/LoginEmploye");break;
		case("Agent") : s.invalidate();
		response.sendRedirect("/AgenceImmobiliere/LoginEmploye");break;
		case("Client") : s.invalidate();
		response.sendRedirect("/AgenceImmobiliere/LoginServlet");break;
		case("respventes") : s.invalidate();
		response.sendRedirect("/AgenceImmobiliere/LoginEmploye");break;
		}
		
		
		
	
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

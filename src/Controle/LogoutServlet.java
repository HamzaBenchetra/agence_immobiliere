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
	this.getServletContext().getRequestDispatcher("/Mustlogin.jsp").forward(request, response);
	}else {
		String t=(String) s.getAttribute("type");
		switch(t) {
		case("Admin") : s.invalidate();
		this.getServletContext().getRequestDispatcher("/LoginAdmin").forward(request, response);break;
		case("Operateur") : s.invalidate();
		this.getServletContext().getRequestDispatcher("/LoginEmploye").forward(request, response);break;
		case("Agent") : s.invalidate();
		this.getServletContext().getRequestDispatcher("/LoginEmploye").forward(request, response);break;
		case("Client") : s.invalidate();
		this.getServletContext().getRequestDispatcher("/LoginServlet").forward(request, response);
		case("respventes") : s.invalidate();
		this.getServletContext().getRequestDispatcher("/LoginEmploye").forward(request, response);break;
		}
		
		
		
	
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

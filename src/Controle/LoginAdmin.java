package Controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Login;

@WebServlet("/LoginAdmin")
public class LoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginAdmin() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("e", 0);
		this.getServletContext().getRequestDispatcher("/AuthentificationAdmin.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail=request.getParameter("mail");
		String mdpss=request.getParameter("pass");
		String type=request.getParameter("type");
		int b=0;
		b=Login.AuthentificationEmploye(type, mail, mdpss);
		if(b!=0) {
			HttpSession s=request.getSession(true);
			s.setAttribute("type", type);
			s.setAttribute("id", b);
			this.getServletContext().getRequestDispatcher("/EspaceAdmin.jsp").forward(request, response);
		}else {
			request.setAttribute("e", -1);
			this.getServletContext().getRequestDispatcher("/AuthentificationAdmin.jsp").forward(request, response);
		}
			
	}

}

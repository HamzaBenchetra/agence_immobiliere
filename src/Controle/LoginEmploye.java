package Controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Login;

@WebServlet("/LoginEmploye")
public class LoginEmploye extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginEmploye() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("e", 0);
		this.getServletContext().getRequestDispatcher("/AuthentificationEmploye.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String mail=request.getParameter("mail");
		String mdpss=request.getParameter("pass");
		String type=request.getParameter("type");
		int i=0;
		switch(type) {
		case "Operateur" :i=Login.AuthentificationEmploye(type,mail, mdpss);
		if(i!=0) {
			HttpSession s=request.getSession(true);
			s.setAttribute("type", type);
			s.setAttribute("idO", i);
			this.getServletContext().getRequestDispatcher("/Operateur.jsp").forward(request, response);
		}
		else {
			request.setAttribute("e", -1);
			this.getServletContext().getRequestDispatcher("/AuthentificationEmploye.jsp").forward(request, response);
		}
				break;
		case "Agent" : i=Login.AuthentificationEmploye(type,mail, mdpss);
		if(i!=0) {
			HttpSession s=request.getSession(true);
			s.setAttribute("type", type);
			s.setAttribute("idA", i);
			this.getServletContext().getRequestDispatcher("/Agent.jsp").forward(request, response);
		}
		else {
			request.setAttribute("e", -1);
			this.getServletContext().getRequestDispatcher("/AuthentificationEmploye.jsp").forward(request, response);
		}
				break;
		case "respventes" : i=Login.AuthentificationEmploye(type,mail, mdpss);
	if(i!=0) {
		HttpSession s=request.getSession(true);
		s.setAttribute("type", type);
		s.setAttribute("idR", i);
		this.getServletContext().getRequestDispatcher("/responsabledesventes.jsp").forward(request, response);
	}
	else {
		request.setAttribute("e", -1);
		this.getServletContext().getRequestDispatcher("/AuthentificationEmploye.jsp").forward(request, response);
	}
			break;
	}
	}
}

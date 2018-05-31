package Controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Client;
import Model.SignUp;

@WebServlet("/SignupServlet")
public class SignupServle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SignupServle() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/InsForm.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter(); 
		Client c=new Client();
		c.setNom(request.getParameter("Nom"));
		c.setPrenom(request.getParameter("Prenom"));
		c.setAdresse(request.getParameter("Adresse"));
		c.setDatenais(request.getParameter("datenais"));
		c.setNumtel(request.getParameter("NumTel"));
		c.setMail(request.getParameter("mail"));
		c.setMdpss(request.getParameter("Mdpss"));
		c.setSexe(request.getParameter("sexe"));
		//String type=request.getParameter("type");
		
		if(SignUp.InscriptionClient(c))
			out.print("inscription terminéé avc succés");
		else
			out.print("no inscription");
		System.out.println(c.getNom());
		System.out.println(c.getPrenom());
		System.out.println(c.getAdresse());
		System.out.println(c.getNumtel());
		System.out.println(c.getMail());
		System.out.println(c.getMdpss());
		System.out.println(c.getDatenais());
		System.out.println(c.getSexe());
		//System.out.println(type);

	}

}

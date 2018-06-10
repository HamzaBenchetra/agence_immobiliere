package Controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Fonctions;

@WebServlet("/EtablirContrat")
public class EtablirContrat extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EtablirContrat() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession()==null||request.getSession().getAttribute("type")==null) {
			System.out.println(request.getSession().getAttribute("type"));
			this.getServletContext().getRequestDispatcher("/LoginEmploye").forward(request, response);;
		}else {
		HttpSession s=request.getSession(true);
		int idc=Integer.parseInt(request.getParameter("IDC"));
		int idA=Integer.parseInt(request.getParameter("IDA"));
		int idO=(int)s.getAttribute("idR");
		String l=Fonctions.EtablirC(idc,idO,idA);
		System.out.println(l);
		s.setAttribute("lien", l);
		this.getServletContext().getRequestDispatcher("/ContratOK.jsp").forward(request, response);
		
	}}

}

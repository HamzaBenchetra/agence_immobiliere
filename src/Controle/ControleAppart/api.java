package Controle.ControleAppart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Appartement;
import Model.Client;
import Model.Fonctions;

@WebServlet("/api")
public class api extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public api() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String r=request.getParameter("action");
		String val=request.getParameter("val");
		if(r.equalsIgnoreCase("complete")&&val!=null) {
			Client c=Fonctions.getClient(val);
			if(c.getNom()==null) {
				response.getWriter().append("ghalt");

			}else {
				response.getWriter().append(c.getNom());
			}
		}else {
			if(r.equalsIgnoreCase("idbat")&&val!=null) {
				int c=Fonctions.getNbE(val);
				if(c==0) {
					response.getWriter().append("ghalt");
					
				}else {
					response.getWriter().append(""+c);
				}
			}else {
				/*if(r.equalsIgnoreCase("idApp")&&val!=null) {
					Appartement c=Fonctions.getAppart(Integer.parseInt(val));
					if(c!=null) {
						response.getWriter().append("ghalt");
						{a: c.getEtage(),b: 42,c: false}
					}else {
						response.getWriter().append(""+c);
					}
				}*/
			}
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

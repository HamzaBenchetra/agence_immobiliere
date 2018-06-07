package Controle.ControleAppart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import Model.Appartement;
import Model.Client;
import Model.Fonctions;
import Model.OperationsOperateur;

@WebServlet("/api")
public class api extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public api() {
        super();
    }
	@SuppressWarnings({ "unchecked", "unused" })
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
				if(r.equalsIgnoreCase("idApp")&&val!=null) {
					Appartement a=Fonctions.getAppart(Integer.parseInt(val));
					
					if(a==null) {
						response.getWriter().append("ghalt");
						
					}else {
						JSONObject Appart = new JSONObject();
					      Appart.put("type", a.getType());
					      Appart.put("idBat", a.getIdBatiment());
					      Appart.put("etage", a.getEtage());
					      Appart.put("prix", a.getPrix());
					      Appart.put("NomLoca", a.getNomLocal());
						response.getWriter().append(Appart.toJSONString());
					}
				}else {
					if(r.equalsIgnoreCase("numclient")&&val!=null) {
						//int id=0;
						int id=OperationsOperateur.trouverClient(val);
						if(id==0) {
							response.getWriter().append("ghalt");
						}else {
							response.getWriter().append(""+id);
						}
					}
				}
			}
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

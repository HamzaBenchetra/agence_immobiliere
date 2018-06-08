package Controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Fonctions;
import Model.OperationsOperateur;

@WebServlet("/ControleRendezVous")
public class ControleRendezVous extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControleRendezVous() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession(true);
		System.out.println(s.isNew());
		if(s.isNew()) {
			s.invalidate();
			response.sendRedirect("/AgenceImmobiliere/LoginServlet");
			
		}else {
		String who=(String)s.getAttribute("type");
		String what=request.getParameter("what");
		String op=request.getParameter("operation");
		
		
		switch (what) {
		case "add":{switch (who) {
					case "Operateur":{
						if(op.equalsIgnoreCase("form")) {
							request.setAttribute("msg", " ");
							this.getServletContext().getRequestDispatcher("/FixerRDVOp.jsp").forward(request, response);
						}
						if(op.equalsIgnoreCase("infos")) {
							int localite=Integer.parseInt(request.getParameter("localite"));
							int region=Integer.parseInt(request.getParameter("region"));
							String type=request.getParameter("type");
							int etage=Integer.parseInt(request.getParameter("etage"));
							int prixMin=Integer.parseInt(request.getParameter("prixMin"));
							int prixMax=Integer.parseInt(request.getParameter("prixMax"));
							request.setAttribute("Apparts", Fonctions.ChercherAppart(localite,region,type,etage,prixMax,prixMin));
							this.getServletContext().getRequestDispatcher("/ListeAppartsOperateur.jsp").forward(request, response);
						}
						if(op.equalsIgnoreCase("idApp")) {
							s.setAttribute("idApp",request.getParameter("IDA"));
							this.getServletContext().getRequestDispatcher("/RechercheClientOperateur.jsp").forward(request, response);
						}
						if(op.equalsIgnoreCase("idClient")) {
							s.setAttribute("idClient",request.getParameter("idC"));
							request.setAttribute("List", Fonctions.listesdatesdispo(Integer.parseInt((String)s.getAttribute("idApp"))));
							request.setAttribute("nomClient", request.getParameter("nomC")+" "+request.getParameter("prenomC"));
							
							this.getServletContext().getRequestDispatcher("/FixerRDVOperateurClient.jsp").forward(request, response);
						}
						if(op.equalsIgnoreCase("creerClient")) {
							int id=OperationsOperateur.creerCompteClient(request.getParameter("nom"), request.getParameter("prenom"),request.getParameter("numerotel"));
							System.out.println(id);
							s.setAttribute("idClient",""+id);
							request.setAttribute("List", Fonctions.listesdatesdispo(Integer.parseInt((String)s.getAttribute("idApp"))));
							this.getServletContext().getRequestDispatcher("/FixerRDVOperateurClient.jsp").forward(request, response);
						}
						if(op.equalsIgnoreCase("dateR")) {
							int idAppartement=Integer.parseInt((String) s.getAttribute("idApp"));
							int idClient=Integer.parseInt((String) s.getAttribute("idClient"));
							String date=request.getParameter("date");
							String heure=request.getParameter("heure");
							boolean b = OperationsOperateur.FixerRdvOperateur(idAppartement,idClient,"'"+date+" "+heure+"'");
							if(b) {
								request.setAttribute("msg", "OK");
								this.getServletContext().getRequestDispatcher("/FixerRDVOp.jsp").forward(request, response);
							}
						}
						
					}
						
						break;
					case "Client":{
						
					}
						
						break;
			
					default:
						break;
					}
			
			break;
		}
		case "mod":
			
			break;
		case "del":
			
			break;

		default:
			break;
		}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

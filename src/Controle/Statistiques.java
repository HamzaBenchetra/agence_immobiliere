package Controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.OperationsRESP;

@WebServlet("/Statistiques")
public class Statistiques extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Statistiques() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		if(request.getSession()==null) {
			response.getWriter().append("IF").append(request.getContextPath());
			this.getServletContext().getRequestDispatcher("/LoginEmploye").forward(request, response);
		}else{
			
			String s=(String) request.getSession().getAttribute("type");
							if(s.equals("Admin")) {
								System.out.println(request.getSession().getAttribute("type"));
								response.getWriter().append("Admin").append(request.getContextPath());
							request.setAttribute("ListA", OperationsRESP.StatAgent());
							request.setAttribute("ListL", OperationsRESP.StatLocalite());
							request.setAttribute("ListT", OperationsRESP.StatType());
							request.setAttribute("Ratio", OperationsRESP.ratio());
							this.getServletContext().getRequestDispatcher("/StatistiquesAdmin.jsp").forward(request, response);
							}
						if(s.equals("respventes")){
							response.getWriter().append("resp").append(request.getContextPath());
						System.out.println(request.getSession().getAttribute("type"));
						request.setAttribute("ListA", OperationsRESP.StatAgent());
						request.setAttribute("ListL", OperationsRESP.StatLocalite());
						request.setAttribute("ListT", OperationsRESP.StatType());
						request.setAttribute("Ratio", OperationsRESP.ratio());
						this.getServletContext().getRequestDispatcher("/Statistiques.jsp").forward(request, response);
					}
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
/*ArrayList<StatsAgent> LA=(ArrayList<StatsAgent>)request.getAttribute("ListA"); %>
    <%ArrayList<StatsLocalite> LL=(ArrayList<StatsLocalite>)request.getAttribute("ListL"); %>
	<%ArrayList<StatsType> LT=(ArrayList<StatsType>)request.getAttribute("ListT");*/
package Controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Appartement;
import Model.OperationsAdmin;


@WebServlet("/ControleAppartement")
public class ControleAppartement extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ControleAppartement() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String r=request.getParameter("what");
		request.setAttribute("msg", " ");
		switch (r) {
		case "add":
			this.getServletContext().getRequestDispatcher("/AjouterAppart.jsp").forward(request, response);
			break;
		case "mod":
			this.getServletContext().getRequestDispatcher("/ModifierAppart.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String r=request.getParameter("what");
		Appartement a=new Appartement();
		switch (r) {
		case "add":
			/*List<Part> fileParts = request.getParts().stream().filter(part -> "image".equals(part.getName())).collect(Collectors.toList()); // Retrieves <input type="file" name="file" multiple="true">

		    for (Part filePart : fileParts) {
		        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		        File file = File.createTempFile("somefilename-", ".ext", uploads);

		        try (InputStream fileContent = filePart.getInputStream();) {
		        	File uploads = new File("/path/to/uploads");
		            Files.copy(uploads, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
		        }
		    }*/
			
			a.setIdBatiment(Integer.parseInt(request.getParameter("IdBat")));
			a.setEtage(Integer.parseInt(request.getParameter("etage")));
			a.setType(request.getParameter("Type"));
			a.setPrix(Integer.parseInt(request.getParameter("prix")));
			a.setDescription(request.getParameter("description"));
			OperationsAdmin.AjouterAppart(a);
			request.setAttribute("msg", "OK");
			this.getServletContext().getRequestDispatcher("/AjouterAppart.jsp").forward(request, response);
			break;
		case "mod":
			a.setIdAppart(Integer.parseInt(request.getParameter("IdApp")));
			a.setIdBatiment(Integer.parseInt(request.getParameter("IdBat")));
			a.setEtage(Integer.parseInt(request.getParameter("etage")));
			a.setType(request.getParameter("Type"));
			a.setPrix(Integer.parseInt(request.getParameter("prix")));
			a.setDescription(request.getParameter("description"));
			OperationsAdmin.ModifierAppart(a);
			request.setAttribute("msg", "OK");
			this.getServletContext().getRequestDispatcher("/ModifierAppart.jsp").forward(request, response);
			break;
		case "del":
			this.getServletContext().getRequestDispatcher("/SupprimerAppart.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}

}

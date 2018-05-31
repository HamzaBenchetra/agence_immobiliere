package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUp {
	private static Connection connexion;
	 
	public static void ConnecterBD() {
	        try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver ok!");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}  
			try {
				connexion = DriverManager.getConnection("jdbc:mysql://Localhost:3306/agenceimmobiliere", "root", "0000");
		        System.out.println("Connection ok!");

			} catch (SQLException e) {
				e.printStackTrace();
			}                   
	        
	  }
	public static boolean InscriptionClient(Client c) {
		ConnecterBD();
		int i=-5;
		try {
			PreparedStatement pst=connexion.prepareStatement("insert into client(nom,prenom,numtel,adresse,datenais,mail,mdpss,sexe) values(?,?,?,?,?,?,?,?);");
			pst.setString(1, c.getNom());
			pst.setString(2, c.getPrenom());
			pst.setString(3, c.getNumtel());
			pst.setString(4, c.getAdresse());
			pst.setString(5, c.getDatenais());
			pst.setString(6, c.getMail());
			pst.setString(7, c.getMdpss());
			pst.setString(8, c.getSexe());
			i=pst.executeUpdate();
		if(i!=-5) return true;
		else return false;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
	}
	public static boolean InscriptionEmp(Employe E) {
		ConnecterBD();
		int i=-5;
		try {
			if(E.getType().equalsIgnoreCase("operateur")) {
			
			PreparedStatement pst=connexion.prepareStatement("insert into "+E.getType()+"(nom,prenom,numtel,adresse,datenais,mail,mdpss,sexe) values(?,?,?,?,?,?,?,?);");
			pst.setString(1, E.getNom());
			pst.setString(2, E.getPrenom());
			pst.setString(3, E.getNumtel());
			pst.setString(4, E.getAdresse());
			pst.setString(5, E.getDatenais());
			pst.setString(6, E.getMail());
			pst.setString(7, E.getMdpss());
			pst.setString(8, E.getSexe());
			i=pst.executeUpdate();}
			else{
				
				PreparedStatement pst=connexion.prepareStatement("insert into "+E.getType()+"(idL,nom,prenom,numtel,adresse,datenais,mail,mdpss,sexe) values(1,?,?,?,?,?,?,?,?);");
				pst.setString(1, E.getNom());
				pst.setString(2, E.getPrenom());
				pst.setString(3, E.getNumtel());
				pst.setString(4, E.getAdresse());
				pst.setString(5, E.getDatenais());
				pst.setString(6, E.getMail());
				pst.setString(7, E.getMdpss());
				pst.setString(8, E.getSexe());
				i=pst.executeUpdate();}
			if(i!=-5) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}

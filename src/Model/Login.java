package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {
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
	 
	 public static int AuthentificationClient(String mail,String mdpss) {
		
		 ConnecterBD();
		 int id=0;
		 try {
			 Statement s=connexion.createStatement();
			 ResultSet rs=s.executeQuery("Select * from client;");
			 
			 while(rs.next()){
				if((mail.equals(rs.getString("mail"))&&mdpss.equals(rs.getString("mdpss")))) {
					id=rs.getInt("idClient");
						return id;
				}
			 }
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 
		 
		 return id;
	 }
	 
	 
	 
	 public static int AuthentificationEmploye(String type,String mail,String mdpss) {
			
		 ConnecterBD();
		 int i=0;
		 try {
			 Statement s=connexion.createStatement();
			 ResultSet rs=s.executeQuery("Select * from "+type+";");
			 while(rs.next()){
				if((mail.equals(rs.getString("mail"))&&mdpss.equals(rs.getString("mdpss")))||(mail.equals(rs.getString("numtel"))&&mdpss.equals(rs.getString("mdpss"))))
						i= rs.getInt(1);
				}
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 
		 
		 return i;
	 }
	 
	 
}

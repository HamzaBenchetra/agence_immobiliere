package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
				if((mail.equals(rs.getString("mail"))&&mdpss.equals(rs.getString("mdpss")))||(mail.equals(rs.getString("numtel"))&&mdpss.equals(rs.getString("mdpss")))) {
					id=rs.getInt("idClient");
					DateFormat dt= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date=new Date();
					PreparedStatement ps=connexion.prepareStatement("update client set lastlogin='"+dt.format(date)+"' ,log=1 where idclient="+id+";");	
					ps.executeUpdate();
					
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
	 public static void logout(int id) {
		 ConnecterBD();
		 try {
			 
					PreparedStatement ps=connexion.prepareStatement("update client set log=0 where idclient="+id+";");	
					ps.executeUpdate();
					
					
				
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	 }
	 
}

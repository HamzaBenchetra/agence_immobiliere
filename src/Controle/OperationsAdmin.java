package Controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Appartement;

public class OperationsAdmin {
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
	
	public static void AjouterAppart(Appartement a) {
		ConnecterBD();
		PreparedStatement ps;
		try {
			ps = connexion.prepareStatement("insert into appartement(idbat,type,prix,description,etage)values(?,?,?,?,?);");
			ps.setInt(1, a.getIdBatiment());
			ps.setString(2, a.getType());
			ps.setFloat(3, (float)a.getPrix());
			ps.setString(4, a.getDescription());
			ps.setInt(5, a.getEtage());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void ModifierAppart(Appartement a) {
		ConnecterBD();
		System.out.println(a.toString());
		PreparedStatement ps;
		try {
			ps = connexion.prepareStatement("UPDATE Appartement SET idbat = ?, type =?,prix=?,description=?,etage=? WHERE idAppart=?;");
			ps.setInt(1, a.getIdBatiment());
			ps.setString(2, a.getType());
			ps.setFloat(3, (float)a.getPrix());
			ps.setString(4, a.getDescription());
			ps.setInt(5, a.getEtage());
			ps.setInt(6, a.getIdAppart());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

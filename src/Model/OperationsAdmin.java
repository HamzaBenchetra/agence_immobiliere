package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

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
	public static boolean Valider(int idA,int id, String t){
		int statut = -5;
		ConnecterBD();
		try {
		PreparedStatement pst=connexion.prepareStatement("update "+ t +" set etat =1, idAdmin="+idA+" where id"+t+"="+id+";");
		statut= pst.executeUpdate();
		
		Statement s = (Statement) connexion.createStatement();
		ResultSet rs=s.executeQuery("select mail from "+t+" where id"+t+"="+id+";");
		if(rs.next()) {
			//Contact.EnvoyerMailDemandeAccepte(rs.getString(1));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(statut != -5){
			return true;
		}else{
			return false;
		}
		}
	public static void SupprimerDemande(int id, String type) {
		ConnecterBD();
		PreparedStatement ps;
		try {
			Statement s = (Statement) connexion.createStatement();
			ResultSet rs=s.executeQuery("select mail from "+type+" where id"+type+"="+id+";");
			if(rs.next()) {
				Contact.EnvoyerMailDemandeRefuse(rs.getString(1));
			}
			ps = connexion.prepareStatement("delete from "+type+" where id"+type+"="+id+";");
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void AjouterAppart(Appartement a) {
		ConnecterBD();
		PreparedStatement ps;
		System.out.print(a.toString());
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

	public static void AjouterLocalite(String nomL) {
		ConnecterBD();
		PreparedStatement ps;
		System.out.print(nomL);
		try {
			ps = connexion.prepareStatement("insert into localite(nomLocalite)values('"+nomL+"');");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void ModifierLocalite(int id, String nom) {
		ConnecterBD();
		System.out.println(id +" "+ nom);
		PreparedStatement ps;
		try {
			ps = connexion.prepareStatement("UPDATE Localite SET nomLocalite='"+nom+"'  WHERE idLocalite="+id+";");
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void AjouterRegion(int idLocalite, String nomRegion) {
		ConnecterBD();
		PreparedStatement ps;
		System.out.print(idLocalite+" "+nomRegion);
		try {
			ps = connexion.prepareStatement("insert into secteur(idLocal,nomSecteur)values("+idLocalite+",'"+nomRegion+"');");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void ModifierRegion(int idRegion, String nom) {
		ConnecterBD();
		System.out.println(idRegion +" "+ nom);
		PreparedStatement ps;
		try {
			ps = connexion.prepareStatement("UPDATE secteur SET nomSecteur='"+nom+"'  WHERE idSecteur="+idRegion+";");
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void BloquerClient(int i) {
		ConnecterBD();
		System.out.println(i);
		PreparedStatement ps;
		try {
			ps = connexion.prepareStatement("UPDATE client SET Authorisation='bloque'  WHERE idClient="+i+";");
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void ReaffecterAgent(int idAgent, int idLocalite) {
		ConnecterBD();
		try {
			PreparedStatement ps=connexion.prepareStatement("update agent set idL="+idLocalite+" where idagent="+idAgent+";");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static int RecupererAgent(String val) {
		ConnecterBD();
		try {
		Statement s=(Statement) connexion.createStatement();
		ResultSet rs=s.executeQuery("select idL from agent where idAgent="+Integer.parseInt(val)+";");
		if(rs.next()) {
			System.out.println(rs.getInt(1));
			return(rs.getInt(1));
		}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 0;
	}
	public static void AjouterBatiment(int idRegion, int nbrEtages, int nbrApparts) {
		ConnecterBD();
		PreparedStatement ps;
		System.out.print(idRegion+" "+nbrEtages+" "+nbrApparts);
		try {
			ps = connexion.prepareStatement("insert into Batiment(idSecteur,nbrEtages,nbrAppart)values("+idRegion+","+nbrEtages+","+nbrApparts+");");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}

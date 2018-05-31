package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OperationsOperateur {
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
	public static ArrayList<Appartement> AfficherAppart(String localite,String type,int etage){
		ConnecterBD();
		
		ArrayList<Appartement> a = new ArrayList<Appartement>();
		try {
		Statement statement = connexion.createStatement();
		String Query="select * from appartement as a, batiment as b,localite as l where a.idBat=b.idBatiment and b.idLocal=l.idLocalite and l.nomLocalite='"+localite+"' and a.type='"+type+"' and a.etage="+etage+" and a.etat=0;";
		ResultSet rs=statement.executeQuery(Query);
		Appartement A=new Appartement();
		while(rs.next()){
			
			A.setIdAppart(rs.getInt("idAppart"));
			A.setIdBatiment(rs.getInt("idBat"));
			A.setType(rs.getString("type"));
			A.setEtage(rs.getInt("etage"));
			A.setPrix(rs.getDouble("prix"));
			A.setNomLocal(rs.getString("nomLocalite"));
			a.add(A);
		}
		return a ;
		
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return a;
	}
	public static int verifierClient(String tel) {
		ConnecterBD();
		Statement statement1;
		int i=0;
		try {
		statement1 = connexion.createStatement();
		ResultSet rs=statement1.executeQuery("select * from Client;");
		
		while(rs.next()) {
		if(rs.getString("numtel").equalsIgnoreCase(tel))
			i=rs.getInt("idClient");
		}
		
		return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static boolean FixerRdvOperateur(int idApp, int idC, String d) {
		ConnecterBD();
		try {
			Statement s=connexion.createStatement();
			ResultSet r=s.executeQuery("SELECT * FROM RDV where idApp="+idApp+" and date="+d+";");
			int i=0;
			while(r.next()) {
				i++;
			}
			
			
			if(i==0) {
				int idA=0;
				Statement st=connexion.createStatement();
				ResultSet rs=st.executeQuery("select idAgent,count(idRDV) from Agent left join rdv on Agent.idAgent=rdv.idA where idAgent not in (select idA From RDV where date="+d+" ) group by idAgent order by count(idRDV) asc;");
				if(rs.next()) {
					idA=rs.getInt("idAgent");
					
				}
				
				PreparedStatement ss=connexion.prepareStatement("insert into RDV (idApp,idA,idC,date)values("+idApp+","+idA+","+idC+","+d+");");
				ss.executeUpdate();
				System.out.println(i);
				System.out.println("RDV ok");
				return true;
			}else {
				return false;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public static int creerCompteClient(String nom, String prenom, String tel) {
		ConnecterBD();
		int id=0;
		try {
			PreparedStatement ps=connexion.prepareStatement("insert into client (nom,prenom,numtel) values('"+nom+"','"+prenom+"','"+tel+"');");
			ps.executeUpdate();
			Statement s = connexion.createStatement();
			ResultSet rs=s.executeQuery("select idclient from client where numtel='"+tel+"';");
			while(rs.next()) {
				id=rs.getInt("idclient");
			}
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
public static ArrayList<RDV> RecupererListeRDV(String tel){
		
		ConnecterBD();
		   ArrayList<RDV> R = new ArrayList<RDV>();
		   try {
				
		 Statement statement = connexion.createStatement();
			String Query="select * from rdv where idC=(SELECT idClient from client where numtel='"+tel+"') and etat=0;";
			ResultSet rs=statement.executeQuery(Query);
			
		//	ResultSet r = null;
			while(rs.next()){
				RDV r=new RDV ();
				r.setIdClient(rs.getInt("idC"));
				r.setIdRDV(rs.getInt("idRDV"));
				r.setIdApp(rs.getInt("idApp"));
				r.setIdAgent(rs.getInt("idA"));
				r.setD(rs.getString("date"));
				r.setEtat(rs.getBoolean("etat"));
				
				R.add(r);
			}
			return R ;
	   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		   return R ;		
	}

public static RDV RecupererRDVAcheteur(int i){
	
	ConnecterBD();
	RDV r=new RDV ();
	   try {
			
	 Statement statement = connexion.createStatement();
		String Query="select * from rdv where idRDV="+i+" and etat=0;";
		ResultSet rs=statement.executeQuery(Query);
		
	//	ResultSet r = null;
		while(rs.next()){
			r.setIdClient(rs.getInt("idC"));
			r.setIdRDV(rs.getInt("idRDV"));
			r.setIdApp(rs.getInt("idApp"));
			r.setIdAgent(rs.getInt("idA"));
			r.setD(rs.getString("date"));
			r.setEtat(rs.getBoolean("etat"));
		}
		return r ;
   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	   return r ;		
}

public static boolean insererDemande(int idAp,int idC) {
	
	ConnecterBD();
	try {
		PreparedStatement ps=connexion.prepareStatement("insert into demandesAchat(idC,IdApp) values ("+idC+","+idAp+");");
		ps.executeUpdate();
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch blockfgf fb bghdghgfjtdjhsh
		return false;
	}
}
public static void main(String[] args) {
	//prendreRDV(1,1,"'2018-04-22 08:00:00'")

}
}


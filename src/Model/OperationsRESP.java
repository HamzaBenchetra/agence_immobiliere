package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OperationsRESP {
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
	public static ArrayList<StatsAgent> StatAgent(){
		ConnecterBD();
		try {
		 ArrayList<StatsAgent> ls=new ArrayList<StatsAgent>();
		 
		 Statement statement = connexion.createStatement();
		 String query="select nom,prenom,count(idRDV) from Agent left join rdv on Agent.idAgent=rdv.idA group by nom order by count(idRDV);";
		 ResultSet rs=statement.executeQuery(query);
			while(rs.next()){
				StatsAgent s=new StatsAgent();
				 s.setNom(rs.getString(1));
				 s.setPrenom(rs.getString(2));
				 s.setCountA(rs.getInt(3));
				 ls.add(s);
				 
			}
				return ls;

	   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
	   }
				return null;

		 		
	}
	
	public static ArrayList<StatsLocalite> StatLocalite(){
		ConnecterBD();
		try {
		 ArrayList<StatsLocalite> ls=new ArrayList<StatsLocalite>();
		 
		 Statement statement = connexion.createStatement();
		 String query="select nomLocalite,Count(idRDV) from Batiment b,Localite l, Appartement a left join rdv r on a.idAppart=r.idApp where a.idBat=b.idBatiment and b.idLocal=l.idLocalite group by idLocalite;";
		 ResultSet rs=statement.executeQuery(query);
			while(rs.next()){
				StatsLocalite s=new StatsLocalite();
				 s.setNomLocalite(rs.getString(1));
				 s.setCountL(rs.getInt(2));
				 ls.add(s);
				 
			}
				return ls;

	   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
	   }
				return null;

		 		
	}
	
	public static ArrayList<StatsType> StatType(){
		ConnecterBD();
		try {
		 ArrayList<StatsType> ls=new ArrayList<StatsType>();
		 
		 Statement statement = connexion.createStatement();
		 String query="select type,count(idRDV) from appartement a left join rdv r on a.idAppart=r.idApp group by type;";
		 ResultSet rs=statement.executeQuery(query);
			while(rs.next()){
				StatsType s=new StatsType();
				 s.setType(rs.getString(1));
				 s.setCountT(rs.getInt(2));
				 ls.add(s);
				 
			}
				return ls;

	   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
	   }
				return null;

		 		
	}
	
	
	public static float ratio() {
		ConnecterBD();
		Statement s;
		Statement ss;
		int nbRDV=0;
		int nbCont=0;
		try {
			s = connexion.createStatement();
			ResultSet rs=s.executeQuery("select count(idrdv) from rdv;");
			while(rs.next()) {
				nbRDV=rs.getInt(1);
				System.out.println(nbRDV);
			}
			ss = connexion.createStatement();
			ResultSet rss=ss.executeQuery("select count(idContrat) from contrat;");
			while(rss.next()) {
				nbCont=rss.getInt(1);
				System.out.println(nbCont);

			}
			//System.out.println(nbCont/nbRDV);
			return (float)nbCont/nbRDV;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(StatLocalite(2));
		 ArrayList<StatsAgent> A=StatAgent();
		 ArrayList<StatsLocalite> B=StatLocalite();
		 ArrayList<StatsType> C=StatType();
		 for(StatsAgent s: A) {
			 System.out.println(s.getNom()+" "+s.getPrenom()+" "+s.getCountA());
		 }
		 for(StatsLocalite s: B) {
			 System.out.println(s.getNomLocalite()+" "+s.getCountL());
		 }
		 for(StatsType s: C) {
			 System.out.println(s.getType()+" "+s.getCountT());
		 }
	}

}

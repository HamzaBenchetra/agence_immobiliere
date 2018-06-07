package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class OperationsClient {
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

public static ArrayList<Appartement> RecupererListeApparts(){
		
		ConnecterBD();
		   ArrayList<Appartement> A = new ArrayList<Appartement>();
		   try {
				
			Statement statement = connexion.createStatement();
			String Query="select * from appartement as a,batiment as b, secteur as s, localite as l where b.idbatiment=a.idBat and b.idsecteur=s.idsecteur and s.idlocal=l.idlocalite and a.etat=0;";
			ResultSet rs=statement.executeQuery(Query);
			
		//	ResultSet r = null;
			while(rs.next()){
				Appartement a=new Appartement ();
				a.setIdAppart(rs.getInt("idAppart"));
				a.setNomLocal(rs.getString("nomLocalite"));
				//a.setImg1(rs.getString("img1"));
				a.setType(rs.getString("type"));
				a.setEtage(rs.getInt("etage"));
				a.setPrix(rs.getDouble("prix"));
				a.setNomRegion(rs.getString("nomsecteur"));
				A.add(a);
			}
			return A ;
	   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		   return A ;		
	}
public static ArrayList<Integer>  RecupererEtage(){
	
	ConnecterBD();
	   ArrayList<Integer> E = new ArrayList<Integer>();

	   try {
			
		Statement statement = connexion.createStatement();
		String Query="SELECT etage FROM agenceimmobiliere.appartement Group by etage; ";
		ResultSet rs=statement.executeQuery(Query);
		
	//	ResultSet r = null;
		while(rs.next()){
			
			int a=(rs.getInt("etage"));
       		E.add(a);
		}
		return E ;
   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	   return E;		
}
public static ArrayList<String>  RecupererLocalite(){
	
	ConnecterBD();
	   ArrayList<String> E = new ArrayList<String>();

	   try {
			
		Statement statement = connexion.createStatement();
		String Query="SELECT nomLocalite FROM agenceimmobiliere.localite Group by nomLocalite; ";
		ResultSet rs=statement.executeQuery(Query);
		
	//	ResultSet r = null;
		while(rs.next()){
			
			String a=(rs.getString("nomLocalite"));
       		E.add(a);
		}
		return E ;
   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	   return E;		
}
public static ArrayList<String>  RecupererTypeAppart(){
	
	ConnecterBD();
	   ArrayList<String> E = new ArrayList<String>();

	   try {
			
		Statement statement = connexion.createStatement();
		String Query="SELECT type FROM agenceimmobiliere.appartement Group by type; ";
		ResultSet rs=statement.executeQuery(Query);
		
	//	ResultSet r = null;
		while(rs.next()){
			
			String a=(rs.getString("type"));
       		E.add(a);
		}
		return E ;
   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	   return E;		
}
public static ArrayList<Appartement> RechercherAppart(String localite,String type,int etage){
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
		//A.setImg1(rs.getString("img1"));

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
	
	public static Appartement AfficherAppart(int id){
		ConnecterBD();
		Appartement A=new Appartement();
		try {
		Statement statement = connexion.createStatement();
		String Query="select * from appartement as a,batiment as b, secteur as s, localite as l where b.idbatiment=a.idBat and b.idsecteur=s.idsecteur and s.idlocal=l.idlocalite and a.etat=0 and a.idAppart="+id+";";
		ResultSet rs=statement.executeQuery(Query);
		
		while(rs.next()){
			A.setIdAppart(rs.getInt("idAppart"));
			A.setIdBatiment(rs.getInt("idBat"));
			A.setType(rs.getString("type"));
			A.setEtage(rs.getInt("etage"));
			A.setPrix(rs.getDouble("prix"));
			A.setNomLocal(rs.getString("nomSecteur"));
			A.setNomLocal(rs.getString("nomLocalite"));
		}
		return A ;
		
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return A;
	}
	public static boolean prendreRDV(int idc,int id,String d) {
		ConnecterBD();
		try {
			Statement s=connexion.createStatement();
			ResultSet r=s.executeQuery("SELECT * FROM RDV where idApp="+id+" and date="+d+";");
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
				
				PreparedStatement ss=connexion.prepareStatement("insert into RDV (idApp,idA,idC,date)values("+id+","+idA+","+idc+","+d+");");
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
public static ArrayList<RDV> RecupererListeRDV(int idc){
		
		ConnecterBD();
		   ArrayList<RDV> R = new ArrayList<RDV>();
		   try {
				
		 Statement statement = connexion.createStatement();
			String Query="SELECT * from rdv where idC="+idc+" and etat=0;";
			ResultSet rs=statement.executeQuery(Query);
			
		//	ResultSet r = null;
			while(rs.next()){
				RDV r=new RDV ();
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
	
	public static void main(String[] args) {
OperationsClient.RecupererTypeAppart();

ArrayList<String> v=OperationsClient.RecupererTypeAppart();
for(String s : v)
    System.out.println(s);

}
}

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
				ArrayList<String> Bn=new ArrayList<String>();
				a.setIdAppart(rs.getInt("idAppart"));
				a.setIdBatiment(rs.getInt("idBat"));
				a.setDescription(rs.getString("Description"));
				a.setNomLocal(rs.getString("nomLocalite"));
				//a.setImg1(rs.getString("img1"));
				a.setType(rs.getString("type"));
				a.setEtage(rs.getInt("etage"));
				a.setPrix(rs.getDouble("prix"));
				a.setNomRegion(rs.getString("nomSecteur"));
				//a.setImages(OperationsClient.ImageAppart(a.getIdAppart()));
			//	System.out.println(a.getIdAppart());
				Statement statement1 = connexion.createStatement();
				String Query1="select LienIMG from appartement as a,figure as f where a.idAppart=f.idApp and f.idApp="+a.getIdAppart()+";";
				ResultSet r=statement1.executeQuery(Query1);
				while(r.next())
				{ 
					String s=r.getString(1);
					Bn.add(s);
					
				}
				
				a.setImages(Bn);
				
			

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
public static void AnnulerRDV(int idRDV) {
	ConnecterBD();
	
	try {
		PreparedStatement ps=connexion.prepareStatement("delete from rdv where idRDV="+idRDV+";");
		ps.executeUpdate();
		
		 
	} catch (SQLException e) {
		e.printStackTrace();
	}

	
}
public static ArrayList<String>  RecupererSecteur(){
	
	ConnecterBD();
	   ArrayList<String> E = new ArrayList<String>();

	   try {
			
		Statement statement = connexion.createStatement();
		String Query="SELECT nomSecteur FROM agenceimmobiliere.secteur Group by nomSecteur; ";
		ResultSet rs=statement.executeQuery(Query);
		
	//	ResultSet r = null;
		while(rs.next()){
			
			String a=(rs.getString("nomSecteur"));
       		E.add(a);
		}
		return E ;
   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	   return E;		
}
public static ArrayList<Appartement> RechercherAppart(String localite,String type,int etage,String secteur,int max,int min){
	System.out.println(localite);
	System.out.println(type);
	System.out.println(etage);
	System.out.println(secteur);
	System.out.println(max);
	System.out.println(min);
	ConnecterBD();
	System.out.println("ani hna 1");

	ArrayList<Appartement> a = new ArrayList<Appartement>();
	try {
	Statement statement = connexion.createStatement();
//	ResultSet rs=statement.executeQuery("select * from appartement as a,batiment as b,secteur as s,localite as l where a.idbat=b.idbatiment and b.idsecteur=s.idsecteur and s.idlocal=l.idlocalite and l.nomlocalite='"+localite+"' and type='"+type+"' and nomSecteur='"+secteur+"' and etage="+etage+" and prix between "+min+" AND "+max+";");
//	ResultSet rs=statement.executeQuery("select * from appartement as a,batiment as b,secteur as s,localite as l where a.idbat=b.idbatiment and b.idsecteur=s.idsecteur and s.idlocal=l.idlocalite and l.nomlocalite='Ali mendjli' and type='F3' and nomSecteur='AADL' and etage=2 and prix between 100 AND 150;");
	ResultSet rs=statement.executeQuery("select nomlocalite,nomsecteur,idappart,idBat,etage,prix,type,Description from appartement as a,batiment as b,secteur as s,localite as l where a.idbat=b.idbatiment and b.idsecteur=s.idsecteur and s.idlocal=l.idlocalite and nomLocalite='"+localite+"' and s.nomSecteur='"+secteur+"' and type='"+type+"' and etage="+etage+" and prix between "+max+" AND "+min+" ;");

	//System.out.println("ani hna 81"+rs);

	
	while(rs.next()){
		System.out.println("ani hna 81"+rs.getInt("idAppart"));

		Appartement A=new Appartement();
System.out.println("aw dkhoul");
		System.out.println("ani hna");
		A.setIdAppart(rs.getInt("idAppart"));
		A.setIdBatiment(rs.getInt("idBat"));
		A.setType(rs.getString("type"));
		A.setEtage(rs.getInt("etage"));
		A.setPrix(rs.getDouble("prix"));
		A.setNomRegion(rs.getString("nomSecteur"));
		A.setNomLocal(rs.getString("nomLocalite"));
		A.setDescription(rs.getString("Description"));

		A.setImages(OperationsClient.ImageAppart(A.getIdAppart()));
		a.add(A);
	}
	return a ;
	
	}catch(Exception e){		System.out.println("erreur fla requete");

		e.printStackTrace();
	}
	return a;
}
	

public static ArrayList<String> ImageAppart(int id){
	ConnecterBD();
	Appartement Ap=new Appartement();

	ArrayList<String> A=new ArrayList<String>();
	
	try {
	Statement statement = connexion.createStatement();
	String Query="select LienIMG from appartement as a,figure f where f.idApp=a.idAppart and a.idAppart="+id+";";
	ResultSet rs=statement.executeQuery(Query);
	
	while(rs.next()){
		
		String a=rs.getString("LienIMG");
		
		
	A.add(a) ;
	
	} 
	Ap.setImages(A);
	return A;
	}catch(Exception e){
		e.printStackTrace();
		
	}
	return A;
}
	public static Appartement AfficherAppart(int id){
		ConnecterBD();
		Appartement A=new Appartement();
		try {
		Statement statement = connexion.createStatement();
	//	String Query=("select * from appartement as a,batiment as b,secteur as s,localite as l where a.idbat=b.idbatiment and b.idsecteur=s.idsecteur and s.idlocal=l.idlocalite and l.nomlocalite='Ali mendjli' and type='F3' and nomSecteur='AADL' and etage=2 and prix between 100 AND 150;");
		String Query="select * from appartement as a,batiment as b, secteur as s, localite as l where b.idbatiment=a.idBat and b.idsecteur=s.idsecteur and s.idlocal=l.idlocalite and a.etat=0 and a.idAppart="+id+";";
		ResultSet rs=statement.executeQuery(Query);
		
		while(rs.next()){
			A.setIdAppart(rs.getInt("idAppart"));
			A.setIdBatiment(rs.getInt("idBat"));
			A.setType(rs.getString("type"));
			A.setEtage(rs.getInt("etage"));
			A.setPrix(rs.getDouble("prix"));
			A.setNomRegion(rs.getString("nomSecteur"));
			A.setNomLocal(rs.getString("nomLocalite"));
			A.setDescription(rs.getString("Description"));
			A.setImages(OperationsClient.ImageAppart(id));
			
		}
		return A ;
		
		}catch(Exception e){
			System.out.println(e.getMessage());
			//e.printStackTrace();
			
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
/**
 * @param idc
 * @return
 */
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
public static ArrayList<Appartement> RecupererListeAppartRDV(int idC){
	
	ConnecterBD();
	   ArrayList<Appartement> R = new ArrayList<Appartement>();
	   try {
		  // select * from rdv as r,appartement as a where r.idapp=a.idappart and r.idRDV=1;
	 Statement statement = connexion.createStatement();
		String Query="select * from rdv as r,appartement as a,batiment as b, secteur as s, localite as l where b.idbatiment=a.idBat and b.idsecteur=s.idsecteur and s.idlocal=l.idlocalite and r.idapp=a.idappart and r.idC="+idC;
	//	select * from appartement as a,batiment as b, secteur as s, localite as l where b.idbatiment=a.idBat and b.idsecteur=s.idsecteur and s.idlocal=l.idlocalite and a.etat=0 and a.idAppart="+id+";";
		ResultSet rs=statement.executeQuery(Query);
		
	//	ResultSet r = null;
		while(rs.next()){
			Appartement A=new Appartement();
			A.setIdAppart(rs.getInt("idAppart"));
			A.setIdBatiment(rs.getInt("idBat"));
			A.setType(rs.getString("type"));
			A.setEtage(rs.getInt("etage"));
			A.setPrix(rs.getDouble("prix"));
		//	A.setNomRegion(rs.getString("nomSecteur"));
			A.setNomLocal(rs.getString("nomLocalite"));
			A.setDescription(rs.getString("Description"));
			A.setImages(OperationsClient.ImageAppart(A.getIdAppart()));
			
			R.add(A);
		}
		return R ;
   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	   return R ;		
}	
	public static void main(String[] args) {
	//	System.out.println("qsdfsdgbfgfvdc");
		/*ArrayList<Appartement> v = OperationsClient.RechercherAppart("Ali mendjli","F3",2,"AADL",100,150);

		for(Appartement v1 : v)
		    System.out.println(v1.getDescription());*/
	//OperationsClient.AnnulerRDV(6);
		

}
}

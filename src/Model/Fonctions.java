package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class Fonctions {
	private static Connection connexion;
	public static boolean ValiderRDV(int id){
		int statut = -5;
		ConnecterBD();
		try {
		
	//	String SQL ="update client set etat =1 where idClient="+id;
		PreparedStatement pst=connexion.prepareStatement("update rdv set etat =1 where idRDV="+id);

		statut= pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(statut != -5){
			return true;
		}else{
			return false;
		}
		}
	public static boolean DonnerPRV(Preaviss P ) {
		ConnecterBD();
		ValiderRDV(P.getIdRDV());
		int i=-5;
		try {
			
			PreparedStatement pst=connexion.prepareStatement("insert into preavis(idAgent,idRDV,avis,contenu) values(?,?,?,?);");
			pst.setInt(1,P.getIdAgent());
			pst.setInt(2,P.getIdRDV());
			pst.setInt(3,P.getAvis());
			pst.setString(4,P.getC());

		
			i=pst.executeUpdate();
		if(i!=-5) return true;
		else return false;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
		
	}
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
	public static ArrayList<Employe> RecupererListAgent(){
		
		ConnecterBD();
		   ArrayList<Employe> c = new ArrayList<Employe>();
		   try {
				
		 Statement statement = (Statement) connexion.createStatement();
			String Query="SELECT * FROM agent where etat=0; ";
			ResultSet rs=statement.executeQuery(Query);
			
		//	ResultSet r = null;
			while(rs.next()){
				Employe ca=new Employe ();
				ca.setIdemp(rs.getInt("idAgent"));
				ca.setNom(rs.getString("nom"));
				ca.setPrenom(rs.getString("prenom"));
				ca.setNumtel(rs.getString("numtel"));
				ca.setAdresse(rs.getString("adresse"));
				ca.setDatenais(rs.getString("datenais"));
				ca.setMail(rs.getString("mail"));
				ca.setSexe(rs.getString("sexe"));
				c.add(ca);
			}
			return c ;
	   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		   return c ;

}
	public static ArrayList<Client> RecupererListClient(){
		
		ConnecterBD();
		   ArrayList<Client> c = new ArrayList<Client>();
		   try {
				
		 Statement statement = (Statement) connexion.createStatement();
			String Query="SELECT * FROM client where etat=0; ";
			ResultSet rs=statement.executeQuery(Query);
			
		//	ResultSet r = null;
			while(rs.next()){
				Client ca=new Client ();
				ca.setIdc(rs.getInt("idClient"));
				ca.setNom(rs.getString("nom"));
				ca.setPrenom(rs.getString("prenom"));
				ca.setNumtel(rs.getString("numtel"));
				ca.setAdresse(rs.getString("adresse"));
				ca.setDatenais(rs.getString("datenais"));
				ca.setMail(rs.getString("mail"));
				ca.setSexe(rs.getString("sexe"));
				c.add(ca);
			}
			return c ;
	   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		   return c ;

}
	public static ArrayList<Employe> RecupererListOperateur(){
	
	ConnecterBD();
	   ArrayList<Employe> k = new ArrayList<Employe>();
	   try {
			
	 Statement statement = (Statement) connexion.createStatement();
		String Query="SELECT * FROM operateur where etat=0; ";
		ResultSet rs=statement.executeQuery(Query);
		
	//	ResultSet r = null;
		while(rs.next()){
			Employe ca=new Employe ();
			ca.setIdemp(rs.getInt("idOperateur"));
			ca.setNom(rs.getString("nom"));
			ca.setPrenom(rs.getString("prenom"));
			ca.setNumtel(rs.getString("numtel"));
			ca.setAdresse(rs.getString("adresse"));
			ca.setDatenais(rs.getString("datenais"));
			ca.setMail(rs.getString("mail"));
			ca.setSexe(rs.getString("sexe"));
			k.add(ca);
		}
		return k ;
   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	   return k ;

}
	public static boolean Valider(int id, String t){
			int statut = -5;
			ConnecterBD();
			try {
			
		//	String SQL ="update client set etat =1 where idClient="+id;
			PreparedStatement pst=connexion.prepareStatement("update "+ t +" set etat =1 where id"+t+"="+id+";");

			statut= pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(statut != -5){
				return true;
			}else{
				return false;
			}
			}
	public static boolean SupprimerClient(int id){
			int statut = -5;
			ConnecterBD();
			try {
			
		//	String SQL ="update client set etat =1 where idClient="+id;
			PreparedStatement pst=connexion.prepareStatement("DELETE FROM client WHERE idClient="+id+";");

			statut= pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(statut != -5){
				return true;
			}else{
				return false;
			}
			}
		public static boolean SupprimerOperateur(int id){
			int statut = -5;
			ConnecterBD();
			try {
			
		//	String SQL ="update client set etat =1 where idClient="+id;
			PreparedStatement pst=connexion.prepareStatement("DELETE FROM operateur WHERE idOperateur="+id+";");

			statut= pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(statut != -5){
				return true;
			}else{
				return false;
			}
			}
		public static boolean SupprimerAgent(int id){
			int statut = -5;
			ConnecterBD();
			try {
			
		//	String SQL ="update client set etat =1 where idClient="+id;
			PreparedStatement pst=connexion.prepareStatement("DELETE FROM agent WHERE idAgent="+id+";");

			statut= pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(statut != -5){
				return true;
			}else{
				return false;
			}
			}
		public static ArrayList<RDV> RecupererListeRDVAgent(int ida){
			ConnecterBD();
			
			   ArrayList<RDV> R = new ArrayList<RDV>();
			   try {
					
			 Statement statement = connexion.createStatement();
				String Query="SELECT * from rdv where idA="+ida+" and etat=0 And date>(SELECT DATE_ADD(CURDATE(),INTERVAL 1 DAY)) order by date;";
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
		public static ArrayList<DemandeAchat> RecupererListeDemandesA() {
				ConnecterBD();
				   ArrayList<DemandeAchat> D = new ArrayList<DemandeAchat>();
				   try {
						
				 Statement statement = connexion.createStatement();
					String Query="SELECT * from demandesAchat;";
					ResultSet rs=statement.executeQuery(Query);
					
				//	ResultSet r = null;
					while(rs.next()){
						DemandeAchat d=new DemandeAchat ();
						d.setIdClient(rs.getInt("idc"));
						d.setIdApp(rs.getInt("idApp"));
						d.setIdDemande(rs.getInt("idDemande"));
						D.add(d);
					}
					return D ;
			   } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				   return D ;		
			}
		public static Client AfficherClient(int id) {
				Client ca=new Client();
				
				ConnecterBD();
				Statement s;
				try {
					s = connexion.createStatement();
					ResultSet rs=s.executeQuery("SELECT * from client where idClient="+id+";");
					while(rs.next()) {
						ca.setIdc(rs.getInt("idClient"));
						ca.setNom(rs.getString("nom"));
						ca.setPrenom(rs.getString("prenom"));
						ca.setNumtel(rs.getString("numtel"));
						ca.setAdresse(rs.getString("adresse"));
						ca.setDatenais(rs.getString("datenais"));
						ca.setMail(rs.getString("mail"));
						ca.setSexe(rs.getString("sexe"));
					}
					return ca;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return ca;
		}
		public static boolean EtablirC(int idc, int idA) {
			ConnecterBD();
			try {
				PreparedStatement ps=connexion.prepareStatement("insert into Contrat(idCL,IdApp) values ("+idc+","+idA+");");
				ps.executeUpdate();
				PreparedStatement pstt=connexion.prepareStatement("update appartement set etat =1 where idAppart="+idA+";");
				pstt.executeUpdate();
				PreparedStatement psttt=connexion.prepareStatement("update rdv set etat =1 where idApp="+idA+";");
				psttt.executeUpdate();
				Statement s=connexion.createStatement();
				ResultSet r=s.executeQuery("select mail,date,numtel from client as c , rdv as r where c.idClient=r.idC and r.idApp="+idA+" and c.idclient<>"+idc+" and r.date>CURDATE() ;");
				String mail=" ";
				String date=" ";
				String tel=" ";
				while (r.next()) {
					mail=r.getString(1);
					date=r.getString(2);
					tel=r.getString(3);
					System.out.println(mail);
					System.out.println(date);
					System.out.println(tel);
					/*if(mail.equalsIgnoreCase("null")) {
						int t=Integer.parseInt(tel);
						tel="213"+t;
						Contact.sendSms(tel,date);
					}else {*/
					Contact.EnvoyerMailAppartVendu(mail,date);
					//}
				}
				/*je prend le num tel
				 * le lui fais un parseInt
				 * le 0 au debut va disparaitre
				 * ensuite je fais numt="213"+n
				 * cequi me donnera 213555098350 parEx
				 * ensuite je le passe en parametre
				 * */
				
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			
		}
		public static ArrayList<RDV> RecupererListeRDVAgentE(int ida){
			ConnecterBD();
			
			   ArrayList<RDV> R = new ArrayList<RDV>();
			   try {
					
			 Statement statement = connexion.createStatement();
				String Query="SELECT * from rdv where idA="+ida+" And date<CURDATE() order by date;";
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
		public static int Recuperer(String mail) {
			ConnecterBD();
			
			try {
				int i=0;
				Statement s=connexion.createStatement();
				ResultSet r=s.executeQuery("SELECT count(*) from Client where mail='"+mail+"';  ");
				if(r.next()) {
					i=r.getInt("count(*)");
				}
				if(i!=0) {
					int code=(int)(Math.random() * ( 9999 - 1000 ));
					return code;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return -1;
		}
		public static void EnregistrerCode(int code,String mail) {
			ConnecterBD();
			try {
				PreparedStatement ps=connexion.prepareStatement("INSERT into Recuperation (mail,code) values('"+mail+"','"+code+"');");
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public static void main(String[] args) {
			//System.out.println(Recuperer("hamza.ben2zelda@gmail.com"));
		}
		public static Client getClient(String val) {
			Client ca=new Client();
			ConnecterBD();
			Statement s;
			try {
				s = connexion.createStatement();
				ResultSet rs=s.executeQuery("SELECT * from client where Numtel='"+val+"';");
				while(rs.next()) {
					ca.setIdc(rs.getInt("idClient"));
					ca.setNom(rs.getString("nom"));
					ca.setPrenom(rs.getString("prenom"));
					ca.setNumtel(rs.getString("numtel"));
					ca.setAdresse(rs.getString("adresse"));
					ca.setDatenais(rs.getString("datenais"));
					ca.setMail(rs.getString("mail"));
					ca.setSexe(rs.getString("sexe"));
				}
				return ca;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ca;
			
		}
		public static int getNbE(String val) {
			ConnecterBD();
			Statement s;
			int nb=0;
			try {
				s = connexion.createStatement();
				ResultSet rs=s.executeQuery("SELECT * from batiment where idbatiment="+val+";");
				
				if(rs.next()) {
					nb=rs.getInt("nbrEtages");
					System.out.println(nb);
				}
				return nb;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return nb;
		}
		public static Appartement getAppart(int id) {
			ConnecterBD();
			Statement s;
			Appartement a=new Appartement();
			try {
				s = connexion.createStatement();
				ResultSet rs=s.executeQuery("SELECT * from APPARTEMENT where idappart="+id+";");
				
				if(rs.next()) {
					a.setIdBatiment(rs.getInt("idbat"));
					a.setPrix(rs.getFloat("prix"));
					a.setType(rs.getString("Type"));
					a.setEtage(rs.getInt("etage"));
				}
				return a;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
}

package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
						System.out.print("IdAppart= "+d.getIdApp()+"\nIdClient= "+d.getIdClient()+"\nIdDemande= "+d.getIdDemande());
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
						ca.setAuthorisation(rs.getString("Autorisation"));
					}
					return ca;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return ca;
		}
		public static String EtablirC(int idc,int idO, int idA) {
			ConnecterBD();
			Client c=Fonctions.AfficherClient(idc);
			Employe e=Fonctions.RecupererEmploye(idO,"respventes");
			Appartement a=Fonctions.getAppart(idA);
			String lien=Impression.imprimerContrat(c,e,a);
			DateFormat dt= new SimpleDateFormat("yyyy-MM-dd");
			Date datee=new Date();
			
			try {
				PreparedStatement ps=connexion.prepareStatement("insert into Contrat(idCL,IdApp,idResp,lienContrat,date) values ("+idc+","+idA+","+idO+",'"+lien+"','"+dt.format(datee)+"');");
				ps.executeUpdate();
				PreparedStatement pstt=connexion.prepareStatement("update appartement set etat =1 where idAppart="+idA+";");
				pstt.executeUpdate();
				PreparedStatement psttt=connexion.prepareStatement("update rdv set etat =1 where idApp="+idA+";");
				psttt.executeUpdate();
				PreparedStatement pstttt=connexion.prepareStatement("delete from demandesAchat where idc="+idc+" and idApp="+idA+";");
				pstttt.executeUpdate();
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
				
				return lien;
			} catch (SQLException ee) {
				ee.printStackTrace();
				return " ";
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
			
			try {
				s = connexion.createStatement();
				ResultSet rs=s.executeQuery("SELECT * from APPARTEMENT where idappart="+id+";");
				
				if(rs.next()) {
					Appartement a=new Appartement();
					a.setIdBatiment(rs.getInt("idbat"));
					a.setPrix(rs.getFloat("prix"));
					a.setType(rs.getString("Type"));
					a.setEtage(rs.getInt("etage"));
					return a;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		public static ArrayList<Localite> ListeLocalitees() {
			ConnecterBD();
			try {
				Statement s=connexion.createStatement();
				ArrayList<Localite> l=new ArrayList<Localite>();
				
				ResultSet rs=s.executeQuery("SELECT * FROM localite;");
				while(rs.next()) {
					Localite lo=new Localite();
					lo.setIdLocalite(rs.getInt(1));
					lo.setNomLocalite(rs.getString(2));
					l.add(lo);
				}
				return l;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		public static ArrayList<Region> ListeRegions() {
			ConnecterBD();
			try {
				Statement s=connexion.createStatement();
				ArrayList<Region> l=new ArrayList<Region>();
				
				ResultSet rs=s.executeQuery("SELECT idSecteur,nomSecteur FROM secteur;");
				while(rs.next()) {
					Region lo=new Region();
					lo.setIdRegion(rs.getInt(1));
					lo.setNomRegion(rs.getString(2));
					l.add(lo);
				}
				for(Region R:l)
					System.out.println(R.getIdRegion()+" "+R.getNomRegion());
				return l;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		public static ArrayList<date> listesdatesdispo(int idA){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date=new Date();
			String dt=sdf.format(date);     //date actuelle
			System.out.println(dt);
			Calendar c = Calendar.getInstance();
				try {
					c.setTime(sdf.parse(dt));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			  // number of days to add
			ConnecterBD();
			ArrayList<date> dates=new ArrayList<date>();
			
			for(int i=0;i<=30;i++) {
				c.add(Calendar.DATE, 1);
				date d=new date();
				d.setDate(sdf.format(c.getTime()));
				d.setHeur("08:00:00.0");
				dates.add(d);
				date d1=new date();
				d1.setDate(sdf.format(c.getTime()));
				d1.setHeur("10:00:00.0");
				dates.add(d1);
				date d2=new date();
				d2.setDate(sdf.format(c.getTime()));
				d2.setHeur("12:00:00.0");
				dates.add(d2);
				date d3=new date();
				d3.setDate(sdf.format(c.getTime()));
				d3.setHeur("14:00:00.0");
				dates.add(d3);
				
				
			}
			
			try {
				Statement s=connexion.createStatement();
				ResultSet rs=s.executeQuery("select * from rdv where date>curdate() and idApp="+idA+" order by date;");
				while(rs.next()) {
					String da=rs.getString("date");
					
					for(int k=0;k<dates.size();k++) {
					if(da.equals(dates.get(k).getDate()+" "+dates.get(k).getHeur()))
						dates.get(k).setEtat(false);
					}
				}
				return dates;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return dates;
			}
			
		}
		public static ArrayList<Appartement> ChercherAppart(int idlocalite, int idregion, String type, int etage,int prixMin, int prixMax) {
			ConnecterBD();
			System.out.println(idlocalite+" "+idregion+" "+type+" "+etage+" "+prixMax+" "+prixMin);
			ArrayList<Appartement> L=new ArrayList<Appartement>();
			try {
				Statement s=connexion.createStatement();
				ResultSet rs=s.executeQuery("select nomlocalite,nomsecteur,idappart,idBat,etage,prix,type,description from appartement as a,batiment as b,secteur as s,localite as l where a.idbat=b.idbatiment and b.idsecteur=s.idsecteur and s.idlocal=l.idlocalite and idlocalite="+idlocalite+" and s.idsecteur="+idregion+" and type='"+type+"' and etage="+etage+" and prix between "+prixMax+" AND "+prixMin+" ;");
				while(rs.next()) {
					Appartement a=new Appartement();
					a.setNomLocal(rs.getString(1));
					a.setNomRegion(rs.getString(2));
					a.setIdAppart(rs.getInt(3));
					a.setIdBatiment(rs.getInt(4));
					a.setEtage(rs.getInt(5));
					a.setPrix(rs.getInt(6));
					a.setType(rs.getString(7));
					a.setDescription(rs.getString(8));
					L.add(a);
				}
				return L;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return L;
		}
		public static Employe RecupererEmploye(int id, String type) {
			ConnecterBD();
			try {
				Statement s=connexion.createStatement();
				ResultSet rs=s.executeQuery("Select * from "+type+" where id"+type+"="+id+";");
				if(rs.next()) {
					Employe e=new Employe();
					e.setNom(rs.getString("nom"));
					e.setPrenom(rs.getString("prenom"));
					e.setAdresse(rs.getString("Adresse"));
					e.setDatenais(rs.getString("datenais"));
					e.setMail(rs.getString("mail"));
					e.setSexe(rs.getString("sexe"));
					e.setNumtel(rs.getString("numtel"));
					return e;
				}
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public static ArrayList<Batiment> ListeBatiments() {
			ConnecterBD();
			try {
				ArrayList<Batiment> L=new ArrayList<Batiment>();
				Statement s=connexion.createStatement();
				ResultSet rs=s.executeQuery("select * from batiment");
				while(rs.next()) {
					Batiment b=new Batiment();
					b.setIdBatiment(rs.getInt(1));
					b.setIdRegion(rs.getInt(2));
					b.setNbrEtages(rs.getInt(3));
					b.setNbrApparts(rs.getInt(4));
					L.add(b);
				}
				return L;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		public static ArrayList<Region> ListeRegion(int id) {
			ConnecterBD();
			try {
				ArrayList<Region> L=new ArrayList<Region>();
				Statement s=connexion.createStatement();
				ResultSet rs=s.executeQuery("select * from secteur where idLocal="+id+";");
				while(rs.next()) {
					Region b=new Region();
					b.setIdRegion(rs.getInt(1));
					b.setNomRegion(rs.getString(3));
					L.add(b);
				}
				return L;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		public static void main(String[] args) {
			/*ArrayList<Region> LR=Fonctions.ListeRegions();
			for(Region R:LR)
				System.out.println(R.getIdRegion()+" "+R.getNomRegion());
			ArrayList<date> d=listesdatesdispo(16);
			for(int i=1;i<=d.size();i++) {
				if(d.get(i-1).getEtat()) {
				System.out.println(d.get(i-1).getDate()+" "+d.get(i-1).getHeur()+" Libre");
				}else {
				System.out.println(d.get(i-1).getDate()+" "+d.get(i-1).getHeur()+" Prise");
				}
				if(i%4==0)
					System.out.println("\n");
			}
			ArrayList<Appartement> L=ChercherAppart(5 ,17, "F3" ,14 ,20000000 ,25000000);
			System.out.println(L.size());
			for(Appartement a:L) {
				System.out.println(a.toString());
			}*/
			
		}
		
		
		
}

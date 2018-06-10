package Model;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Impression {
	public static String imprimerContrat(Client c, Employe rv, Appartement a) {
		DateFormat dt= new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		dt.format(date);
		Document contrat=new Document();
		try {
			PdfWriter.getInstance(contrat, new FileOutputStream("C:\\Users\\hamzaben\\eclipse-workspace\\AgenceImmobiliere\\WebContent\\Contrats\\Contrat"+c.getNom()+""+c.getPrenom()+"-"+dt.format(date)+".pdf"));
			contrat.open();
			contrat.add(new Paragraph("Contrat de vente d’un appartement\r\n" + 
					"\r\n" + 
					"Le présent contrat est signé et prend effet à compter du "+dt.format(date)+" \r\n" + 
					"\r\n" + 
					"ENTRE :              Notre Société immobilière Situer à ( ektoub l’adresse te3 la société )\r\n" + 
					"\r\n" + 
					"	d’une part,\r\n" + 
					"ET :                     Mr/ Mme "+c.getNom()+" "+c.getPrenom()+"\r\n" + 
					"	de l'autre\r\n" + 
					"\r\n" + 
					"PREAMBULE :\r\n" + 
					"En considération des dispositions du présent contrat, le vendeur accepte de vendre et de transmettre à l’acheteur, et l’acheteur accepte d’accepter et de recevoir du vendeur, la propriété immobilière situer à (adresse te3ha) et décrite comme suit :\r\n" + 
					"Numéro d’appartement :"+a.getIdAppart()+"\r\n" + 
					"Bâtiment : "+a.getIdBatiment()+"\r\n" + 
					"Etage : "+a.getEtage()+"\r\n" + 
					"Type : "+a.getType()+"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"Le transfert à l’acheteur inclut tous les droits, titre et intérêt du vendeur sur tout l’appartement.\r\n" + 
					"\r\n" + 
					"•	PRIX D’ACHAT : \r\n" + 
					"Le prix d’achat de la propriété est fixé au prix de : "+(int)a.getPrix()+" DA.\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"LE RESPONSABLE DES VENTES\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"	L’acheteur \r\n" + 
					"Nom & Prénom : "+rv.getNom()+" "+rv.getPrenom()+"\r\n" + 
					"	Nom & prénom :"+c.getNom()+" "+c.getPrenom()+"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"Signature :	\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"Signature :\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					""));
			contrat.close();
			return ("Contrat"+c.getNom()+""+c.getPrenom()+"-"+dt.format(date)+".pdf");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	public static void StatistiquesExcel()  {
		ArrayList<StatsAgent> LA =OperationsRESP.StatAgent();
		ArrayList<StatsLocalite> LL =OperationsRESP.StatLocalite();
		ArrayList<StatsType> LT =OperationsRESP.StatType();
		float R=OperationsRESP.ratio();
		File stats=new File("C:\\Users\\hamzaben\\eclipse-workspace\\AgenceImmobiliere\\WebContent\\Statistiques\\Stats.xls");
		WritableWorkbook myexel;
		int i=0;
		try {
			myexel = Workbook.createWorkbook(stats);
			WritableSheet mysheet=myexel.createSheet("mySheet",0);
			
				for(StatsAgent s: LA) {
					Label l=new Label(0,i,s.getNom());
					Label l2=new Label(1,i,s.getPrenom());
					Label l3=new Label(3,i,""+s.getCountA());
					mysheet.addCell(l);
					mysheet.addCell(l2);
					mysheet.addCell(l3);
					i++;
				}
				i++;
				for(StatsLocalite s: LL) {
					Label l=new Label(0,i,s.getNomLocalite());
					Label l2=new Label(2,i,""+s.getCountL());
					mysheet.addCell(l);
					mysheet.addCell(l2);
					i++;
				}
				i++;
				for(StatsType s: LT) {
					Label l=new Label(0,i,s.getType());
					Label l2=new Label(2,i,""+s.getCountT());
					mysheet.addCell(l);
					mysheet.addCell(l2);
					i++;
				}
				i++;
				Label l=new Label(0,i,"Ratio des ventes");
				Label l2=new Label(2,i,""+R);
				
				mysheet.addCell(l);
				mysheet.addCell(l2);
			myexel.write();
			myexel.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		//StatistiquesExcel();
		
		imprimerContrat(Fonctions.AfficherClient(18),Fonctions.RecupererEmploye(1,"respventes"), Fonctions.getAppart(16));
	}
	

}

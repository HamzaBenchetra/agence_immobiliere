package Model;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Impression {
	public static void imprimerContrat() {
		Document contrat=new Document();
		try {
			PdfWriter.getInstance(contrat, new FileOutputStream("C:\\Users\\hamzaben\\eclipse-workspace\\AgenceImmobiliere\\WebContent\\Contrats\\Contrat.pdf"));
			contrat.open();
			contrat.add(new Paragraph(" Constantine, le : 05/03/1018\r\n" + 
					"Nom : Abrit	\r\n" + 
					"Pr�nom : Ahmed cheraf Eddine\r\n" + 
					"Adresse : Cit� boussouf copreba bts 09 N�117 Constantine, Alg�rie\r\n" + 
					"T�l�phone : +213 553 177 328\r\n" + 
					"Email : charaf.abrit@univ-constantine2.dz\r\n" + 
					" �\r\n" + 
					" L�attention du responsable du CROUS\r\n" + 
					"Objet : D�claration sur l�honneur .\r\n" + 
					" Je soussign�, M. Abrit Ahmed cheraf Eddine, demeurant � Constantine, titulaire d�un\r\n" + 
					"passeport alg�rien N� : 157121994 d�livr� par La da�ra de Constantine le 23/11/2015.\r\n" + 
					" Atteste sur l�honneur qu�actuellement, je fais des d�marches au sein de Campus France\r\n" + 
					"Alg�rie pour une �ventuelle inscription en informatique (L3) dans un �tablissement fran�ais dans\r\n" + 
					"l�une des villes suivantes : Paris , Toulouse et Nantes pour l�ann�e 2018/2019.\r\n" + 
					" Veuillez agr�ez Madame, Monsieur, l�assurance de ma haute\r\n" + 
					" consid�ration.\r\n" + 
					" Signature,"));
			contrat.close();
			Desktop.getDesktop().open(new File("C:\\Users\\hamzaben\\eclipse-workspace\\AgenceImmobiliere\\WebContent\\Contrats\\Contrat.pdf"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		StatistiquesExcel();
	}
	

}

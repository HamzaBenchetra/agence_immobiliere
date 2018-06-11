package Model;

import java.io.BufferedReader;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//imports pour sms
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//imports pour mail
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//import acces a base de donn�es
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Contact {
	private static String username="societeimmobiliere933@gmail.com";
	private static String password="motdepass1234";
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
	public static void EnvoyerMailAppartVendu(String d,String date) {
		Properties props=new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session=Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			Message message=new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(d));
			message.setSubject("Votre Rendez-Vous");
			message.setText("Nous avons le regret de vous annoncer que votre Rendez vous du "+date+" est annul� car l'appartement a �t� vendu");
			Transport.send(message);
			System.out.println("ok");
		}catch(MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
	public static void EnvoyerMailDemandeRefuse(String d) {
		Properties props=new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session=Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			Message message=new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(d));
			message.setSubject("Votre Rendez-Vous");
			message.setText("Nous avons le regret de vous informer que votre demande d'emploie a �t� d�clin�e pour des raisons profesionnels");
			Transport.send(message);
			System.out.println("ok");
		}catch(MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
	public static void EnvoyerMailDemandeAccepte(String d) {
		Properties props=new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session=Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			Message message=new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(d));
			message.setSubject("Votre Rendez-Vous");
			message.setText("Nous vous informons que vous avez �t� acc�pt� comme employ� dans notre scociet� immobiliere");
			Transport.send(message);
			System.out.println("ok");
		}catch(MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
	public static String sendSms(String tel,String date) {
		try {
			// Construct data
			String apiKey = "apikey=" + "7qd1CZ3+OsU-HXRH7RrC4ThW6UV2nFL540yTqEys8a";
			String message = "&message=" + "Votre RDV du "+date+" est annule car l'appartement a ete vendu";
			String sender = "&sender=" + "Agence Immo";
			String numbers = "&numbers=" + tel;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
	public static String sendSmsRDV(String tel,String date) {
		try {
			// Construct data
			String apiKey = "apikey=" + "7qd1CZ3+OsU-HXRH7RrC4ThW6UV2nFL540yTqEys8a";
			String message = "&message=" + "Votre RDV du "+date+" est fixe.";
			String sender = "&sender=" + "Agence Immo";
			String numbers = "&numbers=" + tel;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
	public static String sendSmsMdpss(String tel,int mdpss) {
		try {
			// Construct data
			String apiKey = "apikey=" + "7qd1CZ3+OsU-HXRH7RrC4ThW6UV2nFL540yTqEys8a";
			String message = "&message=" + "Pour vous connecter a votre compte utilisez ce mot de passe"+mdpss+".";
			String sender = "&sender=" + "Agence Immo";
			String numbers = "&numbers=" + tel;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
	public static String sendNotif(String tel,String date) {
		try {
			// Construct data
			String apiKey = "apikey=" + "7qd1CZ3+OsU-HXRH7RrC4ThW6UV2nFL540yTqEys8a";
			String message = "&message=" + "N'ouvliez pas que vous avez rendez-vous demain a "+date+" Soyez a l'heure.";
			String sender = "&sender=" + "Agence Immo";
			String numbers = "&numbers=" + tel;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			System.out.print("sms envoy� a "+tel+" � "+date+"");
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
	public static void Notifier(String h) {
		DateFormat dt= new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        Date datePlusOne = c.getTime();
		System.out.println(dt.format(date));
		System.out.println(dt.format(datePlusOne));
		ConnecterBD();
		
		try {
			Statement s = connexion.createStatement();
			ResultSet rs=s.executeQuery("select a.numtel as numtelA,c.numtel as numtelC from rdv as r,client as c ,agent as a where r.idA=a.idAgent and c.idClient=r.idC and date='"+dt.format(datePlusOne)+" "+h+"';");
			System.out.println(dt.format(datePlusOne)+" "+h);
			while(rs.next()) {
				System.out.println("okkkkkk");
				String telA=rs.getString(1);
				String telC=rs.getString(2);
				sendNotif("213"+Integer.parseInt(telC),h);
				System.out.println(telA+" "+telC+"      213"+Integer.parseInt(telC)+" "+h);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static String sendSmsBloque(String tel) {
		try {
			// Construct data
			String apiKey = "apikey=" + "7qd1CZ3+OsU-HXRH7RrC4ThW6UV2nFL540yTqEys8a";
			String message = "&message=" + "Votre compte li� a notre site a �t� bloqu� par l'admin.";
			String sender = "&sender=" + "Agence Immo";
			String numbers = "&numbers=" + tel;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			System.out.println(tel+" SMS ENVOY�");
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
		
	}
public static void main(String[] args) {
	//sendSms("213794204107","2018-05-12 10:00:00.0");
	//sendSms("213799957655","2018-05-12 10:00:00.0");
	//sendSms("213696689498","2018-05-12 10:00:00.0");
	/*Notifier("08:00:00");
	sendSms("213795287375", "2018-06-12 10:00:00.0");
	sendSmsMdpss("213795287375", 37325423);
	sendSmsRDV("213795287375", "2018-06-12");*/
	//sendSmsBloque("213"+Integer.parseInt("0795287375"));
}

}

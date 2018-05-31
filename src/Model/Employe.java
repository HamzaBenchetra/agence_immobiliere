package Model;


public class Employe {
	private String nom,prenom,numtel,adresse,mail,mdpss,sexe,datenais,type;
	private int idemp;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNumtel() {
		return numtel;
	}
	public void setNumtel(String numtel) {
		this.numtel = numtel;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String user) {
		this.mail = user;
	}
	public String getMdpss() {
		return mdpss;
	}
	public void setMdpss(String mdpss) {
		this.mdpss = mdpss;
	}
	public String getDatenais() {
		return datenais;
	}
	public void setDatenais(String string) {
		this.datenais = string;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getIdemp() {
		return idemp;
	}
	public void setIdemp(int idemp) {
		this.idemp = idemp;
	};

}

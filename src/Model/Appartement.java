package Model;

public class Appartement {
private int idAppart,idBatiment,etage;
private double prix;
private String type,nomLocal;
public int getIdAppart() {
	return idAppart;
}
public void setIdAppart(int idAppart) {
	this.idAppart = idAppart;
}
public int getIdBatiment() {
	return idBatiment;
}
public void setIdBatiment(int idBatiment) {
	this.idBatiment = idBatiment;
}
public int getEtage() {
	return etage;
}
public void setEtage(int etage) {
	this.etage = etage;
}
public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getNomLocal() {
	return nomLocal;
}
public void setNomLocal(String nomLocal) {
	this.nomLocal = nomLocal;
}
}

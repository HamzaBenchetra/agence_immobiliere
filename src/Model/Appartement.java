package Model;

import java.util.ArrayList;

public class Appartement {
private int idAppart,idBatiment,etage;
private double prix;
private String description;
private String type,nomLocal,nomRegion;
 private ArrayList<String> Images;
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
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Override
public String toString() {
	return "Appartement [idAppart=" + idAppart + ", idBatiment=" + idBatiment + ", etage=" + etage + ", prix=" + (int)prix
			+ ", description=" + description + ", type=" + type + ", nomLocal=" + nomLocal + "]";
}
public String getNomRegion() {
	return nomRegion;
}
public void setNomRegion(String nomRegion) {
	this.nomRegion = nomRegion;
}
public ArrayList<String> getImages() {
	return Images;
}
public void setImages(ArrayList<String> images) {
	Images = images;
}
}

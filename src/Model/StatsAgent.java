package Model;

public class StatsAgent {
@Override
	public String toString() {
		return "StatsAgent [nom=" + nom + ", prenom=" + prenom + ", countA=" + countA + "]";
	}
private String nom,prenom;
private int countA;
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
public int getCountA() {
	return countA;
}
public void setCountA(int countA) {
	this.countA = countA;
}
}

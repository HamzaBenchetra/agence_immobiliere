package Model;

public class StatsLocalite {
@Override
	public String toString() {
		return "StatsLocalite [nomLocalite=" + nomLocalite + ", countL=" + countL + "]";
	}
private String nomLocalite;
private int countL;
public String getNomLocalite() {
	return nomLocalite;
}
public void setNomLocalite(String nomLocalite) {
	this.nomLocalite = nomLocalite;
}
public int getCountL() {
	return countL;
}
public void setCountL(int countL) {
	this.countL = countL;
}
}

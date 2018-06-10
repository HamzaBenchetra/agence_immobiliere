package Model;

public class StatsType {
@Override
	public String toString() {
		return "StatsType [type=" + type + ", countT=" + countT + "]";
	}
private String type;
private int countT;
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getCountT() {
	return countT;
}
public void setCountT(int countT) {
	this.countT = countT;
}
}

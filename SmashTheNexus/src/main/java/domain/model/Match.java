package domain.model;

import java.util.Date;

public class Match {

	private int ID;
	private Date date;
	private String FirstTeam;
	private String SecondTeam;
	private String Result;
	private int BestOf;
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFirstTeam() {
		return FirstTeam;
	}
	public void setFirstTeam(String firstTeam) {
		FirstTeam = firstTeam;
	}
	public String getSecondTeam() {
		return SecondTeam;
	}
	public void setSecondTeam(String secondTeam) {
		SecondTeam = secondTeam;
	}
	public String getResult() {
		return Result;
	}
	public void setResult(String result) {
		Result = result;
	}
	public int getBestOf() {
		return BestOf;
	}
	public void setBestOf(int bestOf) {
		BestOf = bestOf;
	}
	
}

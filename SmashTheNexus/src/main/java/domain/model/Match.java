package domain.model;

import java.util.Date;

public class Match {

	private int ID;
	private Date date;
	private Team FirstTeam;
	private Team SecondTeam;
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
	public Team getFirstTeam() {
		return FirstTeam;
	}
	public void setFirstTeam(Team firstTeam) {
		FirstTeam = firstTeam;
	}
	public Team getSecondTeam() {
		return SecondTeam;
	}
	public void setSecondTeam(Team secondTeam) {
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

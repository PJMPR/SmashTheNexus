package domain.model;

import java.util.Date;

public class Match implements IHaveId{

	private int id;
	private Date date;
	private int FirstTeam;
	private int SecondTeam;
	private int FirstTeamId;
	private int SecondTeamId;
	private String Result;
	private int BestOf;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getFirstTeam() {
		return FirstTeam;
	}
	public void setFirstTeam(int firstTeam) {
		FirstTeam = firstTeam;
	}
	public int getSecondTeam() {
		return SecondTeam;
	}
	public void setSecondTeam(int secondTeam) {
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
	public int getFirstTeamId() {
		return FirstTeamId;
	}
	public void setFirstTeamId(int firstTeamId) {
		FirstTeamId = firstTeamId;
	}
	public int getSecondTeamId() {
		return SecondTeamId;
	}
	public void setSecondTeamId(int secondTeamId) {
		SecondTeamId = secondTeamId;
	}

	
}

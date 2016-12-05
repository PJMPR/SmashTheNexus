package domain.model;

import java.util.Date;

public class Match implements IHaveId{

	private int id;
	private Date date;
	private Team FirstTeam;
	private Team SecondTeam;
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

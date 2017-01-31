package domain.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "match")
@NamedQueries({ 
		@NamedQuery(name = "match.all", query = "SELECT m FROM Match m"),
		@NamedQuery(name = "match.id", query = "SELECT m FROM Match m WHERE m.id=:id") })
public class Match implements IHaveId{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "match_date")
	private Date date;
	private Team FirstTeam;
	private Team SecondTeam;
	private String Result;
	private int BestOf;
	
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

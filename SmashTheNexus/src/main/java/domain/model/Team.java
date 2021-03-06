package domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "team")
@NamedQueries({ 
		@NamedQuery(name = "team.all", query = "SELECT t FROM Team t"),
		@NamedQuery(name = "team.id", query = "SELECT t FROM Team t WHERE t.id=:id") })
public class Team implements IHaveId {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Name;
	private int Wins;
	private int Loses;
	private int FormDate;
	private String ShortName;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getWins() {
		return Wins;
	}
	public void setWins(int wins) {
		Wins = wins;
	}
	public int getLoses() {
		return Loses;
	}
	public void setLoses(int loses) {
		Loses = loses;
	}
	public int getFormDate() {
		return FormDate;
	}
	public void setFormDate(int formDate) {
		FormDate = formDate;
	}
	public String getShortName() {
		return ShortName;
	}
	public void setShortName(String shortName) {
		ShortName = shortName;
	}
	
}

package domain.model;

public class Team implements IHaveId {
	
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

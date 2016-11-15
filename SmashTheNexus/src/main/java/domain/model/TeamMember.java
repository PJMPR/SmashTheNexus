package domain.model;

public class TeamMember {
	
	private int ID;
	private String Name;
	private String Surname;
	private String Nick;
	private Team TeamID;
	private int Age;
	private int Country;
	private String FavouriteChampion;
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	public String getNick() {
		return Nick;
	}
	public void setNick(String nick) {
		Nick = nick;
	}
	public Team getTeamID() {
		return TeamID;
	}
	public void setTeamID(Team teamID) {
		TeamID = teamID;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public int getCountry() {
		return Country;
	}
	public void setCountry(int country) {
		Country = country;
	}
	public String getFavouriteChampion() {
		return FavouriteChampion;
	}
	public void setFavouriteChampion(String favouriteChampion) {
		FavouriteChampion = favouriteChampion;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
}

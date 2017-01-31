package rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TeamMemberDto {

	private int id;
	private String Name;
	private String Surname;
	private String Nick;
	private int Age;
	private String Country;
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

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getFavouriteChampion() {
		return FavouriteChampion;
	}

	public void setFavouriteChampion(String favouriteChampion) {
		FavouriteChampion = favouriteChampion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

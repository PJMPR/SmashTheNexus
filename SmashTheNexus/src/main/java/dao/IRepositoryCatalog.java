package dao;

public interface IRepositoryCatalog {

	public IMatchRepository matches();
	public ITeamRepository teams();
	public ITeamMemberRepository teamMembers();
	
	public void saveAndClose();
	
}

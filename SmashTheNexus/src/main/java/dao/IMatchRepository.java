package dao;

import domain.model.Match;

public interface IMatchRepository extends IRepository<Match>{
	
	public void fillwithTeams(Match matchWithoutTeams);

}
				
	


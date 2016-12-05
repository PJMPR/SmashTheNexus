package dao;

import java.util.List;

import domain.model.Team;

public interface ITeamRepository extends IRepository<Team> {
	public List<Team> withShortName(String shortName);
}

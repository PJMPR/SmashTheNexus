package dao;

import domain.model.TeamMember;

public interface ITeamMemberRepository extends IRepository<TeamMember> {

	public void assignToTeam(TeamMember teamMemberWithoutTeam);
}

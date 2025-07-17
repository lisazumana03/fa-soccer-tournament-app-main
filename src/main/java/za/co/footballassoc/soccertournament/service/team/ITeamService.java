package za.co.footballassoc.soccertournament.service.team;

import za.co.footballassoc.soccertournament.domain.team.Team;

import java.util.List;

public interface ITeamService {
    Team create(Team team);
    Team read(String teamID);
    List<Team> getAllTeams();
    Team update(String teamID, Team updatedTeam);
    void delete(String teamID);
}

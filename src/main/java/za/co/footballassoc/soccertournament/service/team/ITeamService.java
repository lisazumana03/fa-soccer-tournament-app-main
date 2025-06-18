package za.co.footballassoc.soccertournament.service.team;

import za.co.footballassoc.soccertournament.domain.team.Team;

public interface ITeamService {
    Team create(Team team);
    Team read(String teamID);
    Team update(Team team);
    void delete(String teamID);
}

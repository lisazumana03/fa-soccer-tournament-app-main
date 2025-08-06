package za.co.footballassoc.soccertournament.service.team;

import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.service.IService;

import java.util.List;

public interface ITeamService extends IService<Team, String> {
    void delete(String teamID);
}

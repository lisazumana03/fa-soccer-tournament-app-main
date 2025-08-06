package za.co.footballassoc.soccertournament.service.team;

import za.co.footballassoc.soccertournament.domain.team.Owner;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.service.IService;

import java.util.List;

public interface IOwnerService extends IService<Owner, String> {
    void delete(String ownerID);

    //Owner Logic
    List<Team> getTeamsByOwner(String ownerID);
    Team transferTeamOwnership(String teamID, String newOwnerID);
}

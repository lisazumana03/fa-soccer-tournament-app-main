package za.co.footballassoc.soccertournament.service.team;

import za.co.footballassoc.soccertournament.domain.team.Owner;
import za.co.footballassoc.soccertournament.domain.team.Team;

import java.util.List;

public interface IOwnerService {
    Owner create(Owner owner);
    List<Owner> getAllOwners();
    Owner updateOwner(Owner owner);
    void delete(String ownerID);

    //Owner Logic
    List<Team> getTeamsByOwner(String ownerID);
    Team transferTeamOwnership(String teamID, String newOwnerID);
}

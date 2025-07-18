package za.co.footballassoc.soccertournament.service.team;

import za.co.footballassoc.soccertournament.domain.team.Owner;

public interface IOwnerService {
    Owner create(Owner owner);
    void delete(String ownerID);
}

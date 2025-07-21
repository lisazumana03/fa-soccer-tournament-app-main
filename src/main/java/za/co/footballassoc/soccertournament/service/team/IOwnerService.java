package za.co.footballassoc.soccertournament.service.team;

import za.co.footballassoc.soccertournament.domain.team.Owner;

import java.util.List;

public interface IOwnerService {
    Owner create(Owner owner);
    List<Owner> getAllOwners();
    Owner updateOwner(Owner owner);
    void delete(String ownerID);
}

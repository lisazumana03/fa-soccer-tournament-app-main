package za.co.footballassoc.soccertournament.service.team.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.team.Owner;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.repository.team.OwnerRepository;
import za.co.footballassoc.soccertournament.repository.team.TeamRepository;
import za.co.footballassoc.soccertournament.service.team.IOwnerService;

import java.util.List;

@Service
public class OwnerService implements IOwnerService {
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Owner create(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner updateOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(String ownerID){
        if (!ownerRepository.existsById(ownerID)) {
            throw new EntityNotFoundException(ownerID);
        }
        ownerRepository.deleteById(ownerID);
    }

    @Override
    public List<Team> getTeamsByOwner(String ownerID) {
        return teamRepository.findByOwner_OwnerId(ownerID);
    }

    @Override
    public Team transferTeamOwnership(String teamID, String newOwnerID) {
        Team team = teamRepository.findById(teamID)
                .orElseThrow(EntityNotFoundException::new);
        Owner newOwner = ownerRepository.findById(newOwnerID)
                .orElseThrow(EntityNotFoundException::new);
        team.setOwner(newOwner);
        return teamRepository.save(team);
    }
}

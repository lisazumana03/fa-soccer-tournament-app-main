package za.co.footballassoc.soccertournament.service.team.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import za.co.footballassoc.soccertournament.domain.team.Owner;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.repository.team.OwnerRepository;
import za.co.footballassoc.soccertournament.repository.team.TeamRepository;
import za.co.footballassoc.soccertournament.service.team.IOwnerService;

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
    public List<Owner> getAll() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner read(String ownerID) {
        return ownerRepository.findById(ownerID)
                .orElseThrow(() -> new EntityNotFoundException("Owner not found with ID: " + ownerID));
    }

    @Override
    public Owner update(String ownerID, Owner updatedOwner) {
        Owner owner = ownerRepository.findById(ownerID)
                .orElseThrow(() -> new EntityNotFoundException("Owner not found with ID: " + ownerID));
        
        Owner updated = new Owner.Builder()
                .copy(owner)
                .setOwnerName(updatedOwner.getOwnerName())
                .setGender(updatedOwner.getGender())
                .setDateOfBirth(updatedOwner.getDateOfBirth())
                .setBirthLocation(updatedOwner.getBirthLocation())
                .setNetWorth(updatedOwner.getNetWorth())
                .build();
        return ownerRepository.save(updated);
    }

    @Override
    public void delete(String ownerID) {
        if (!ownerRepository.existsById(ownerID)) {
            throw new EntityNotFoundException("Owner not found with ID: " + ownerID);
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
                .orElseThrow(() -> new EntityNotFoundException("Team not found with ID: " + teamID));
        Owner newOwner = ownerRepository.findById(newOwnerID)
                .orElseThrow(() -> new EntityNotFoundException("Owner not found with ID: " + newOwnerID));

        // Validate that owner can afford the team
        Double teamValue = team.getTeamValue();
        Double ownerNetWorth = newOwner.getNetWorth();
        
        if (teamValue != null && ownerNetWorth != null && teamValue > ownerNetWorth) {
            throw new IllegalArgumentException("Owner cannot afford this team. Team value: $" + 
                teamValue + "B, Owner net worth: $" + ownerNetWorth + "B");
        }

        Team updatedTeam = new Team.Builder()
                .copy(team)
                .setOwner(newOwner)
                .build();

        return teamRepository.save(updatedTeam);
    }

    public Team sellTeam(String teamID) {
        Team team = teamRepository.findById(teamID)
                .orElseThrow(() -> new EntityNotFoundException("Team not found with ID: " + teamID));

        Team soldTeam = new Team.Builder()
                .copy(team)
                .setOwner(null)
                .build();

        return teamRepository.save(soldTeam);
    }
}

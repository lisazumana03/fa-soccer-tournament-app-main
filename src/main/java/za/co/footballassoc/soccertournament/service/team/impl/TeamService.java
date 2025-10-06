package za.co.footballassoc.soccertournament.service.team.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.repository.team.TeamRepository;
import za.co.footballassoc.soccertournament.service.team.ITeamService;

@Service
public class TeamService implements ITeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team create(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team read(String teamID) {
        return teamRepository.findById(teamID).orElse(null);
    }

    @Override
    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team update(String teamID, Team updatedTeam) {
        Team team = teamRepository.findById(updatedTeam.getTeamID())
                .orElseThrow(()->new RuntimeException("Team not found"));
        return teamRepository.save(updatedTeam);
    }

    @Override
    public void delete(String teamID) {
        if (!teamRepository.existsById(teamID)) {
            throw new EntityNotFoundException("Team not found with ID: " + teamID);
        }
        teamRepository.deleteById(teamID);
    }
}

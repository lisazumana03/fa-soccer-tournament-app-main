package za.co.footballassoc.soccertournament.service.impl.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.team.Player;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.repository.team.TeamRepository;
import za.co.footballassoc.soccertournament.service.team.ITeamService;

import java.util.List;

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
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team update(String teamID, Team updatedTeam) {
        Team team = teamRepository.findById(updatedTeam.getTeamID()).orElseThrow(()->new RuntimeException("Team not found"));
        return teamRepository.save(updatedTeam);
    }

    @Override
    public void delete(String teamID) {
        teamRepository.deleteById(teamID);
    }
}

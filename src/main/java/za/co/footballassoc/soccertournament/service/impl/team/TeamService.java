package za.co.footballassoc.soccertournament.service.impl.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public Team update(Team team) {
        return null;
    }

    @Override
    public void delete(String teamID) {

    }
}

package za.co.footballassoc.soccertournament.service.impl.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.tournament.League;
import za.co.footballassoc.soccertournament.repository.tournament.LeagueRepository;
import za.co.footballassoc.soccertournament.service.tournament.ILeagueService;

import java.util.List;

@Service
public class LeagueService implements ILeagueService {
    @Autowired
    private LeagueRepository leagueRepository;

    @Override
    public League create(League league) {
        return leagueRepository.save(league);
    }

    @Override
    public List<League> findAll() {
        return List.of();
    }
}

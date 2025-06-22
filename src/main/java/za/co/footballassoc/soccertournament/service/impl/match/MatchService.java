package za.co.footballassoc.soccertournament.service.impl.match;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.match.Match;
import za.co.footballassoc.soccertournament.domain.match.MatchEvent;
import za.co.footballassoc.soccertournament.domain.tournament.League;
import za.co.footballassoc.soccertournament.repository.match.MatchRepository;
import za.co.footballassoc.soccertournament.repository.tournament.LeagueRepository;
import za.co.footballassoc.soccertournament.repository.tournament.StandingRepository;
import za.co.footballassoc.soccertournament.service.match.IMatchService;

@Service
public class MatchService implements IMatchService {
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private StandingRepository standingRepository;

    @Transactional
    public void startMatch(String matchID){
        Match match = matchRepository.findByMatchID(matchID)
                .orElseThrow(() -> new RuntimeException("Match not found!"));
        if("Scheduled".equals(match.getMatchStatus())){
            match.setMatchStatus("Ongoing");
            matchRepository.save(match);

            //Standings logic affecting the league table
            if(match.getTournament() instanceof League){
                updateStandings(match.getHomeTeam(), match.getTournament().getMatchID());
                updateStandings(match.getAwayTeam(), match.getTournament().getMatchID());
            }
        }
    }

    @Transactional
    public void recordMatchEvent(String matchID, MatchEvent event){
        Match match = matchRepository.findByMatchID(matchID)
                .orElseThrow(() -> new RuntimeException("Match not found!"));
    }

}

package za.co.footballassoc.soccertournament.service.impl.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.match.Match;
import za.co.footballassoc.soccertournament.domain.match.MatchEvent;
import za.co.footballassoc.soccertournament.repository.match.MatchRepository;
import za.co.footballassoc.soccertournament.repository.tournament.LeagueRepository;
import za.co.footballassoc.soccertournament.service.match.IMatchService;

@Service
public class MatchService implements IMatchService {
    @Autowired
    private MatchRepository matchRepository;
    private LeagueRepository leagueRepository;

    @Override
    public void startMatch(String matchID){
        Match match = matchRepository.findByMatchID(matchID)
                .orElseThrow(() -> new RuntimeException("Match not found!"));
        if("Scheduled".equals(match.getMatchStatus())){
            match.setMatchStatus("Ongoing");
            matchRepository.save(match);
        }
    }

    public void recordMatchEvent(String matchID, MatchEvent event){
        Match match = matchRepository.findByMatchID(matchID)
                .orElseThrow(() -> new RuntimeException("Match not found!"));
    }

}

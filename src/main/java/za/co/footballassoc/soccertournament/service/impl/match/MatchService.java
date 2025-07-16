package za.co.footballassoc.soccertournament.service.impl.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.match.Match;
import za.co.footballassoc.soccertournament.domain.match.MatchEvent;
import za.co.footballassoc.soccertournament.domain.match.MatchStatus;
import za.co.footballassoc.soccertournament.repository.match.MatchRepository;
import za.co.footballassoc.soccertournament.service.match.IMatchService;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class MatchService implements IMatchService{
    @Autowired
    private MatchRepository matchRepository;


    @Override
    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public Optional<Match> getMatchById(String matchId) {
        return matchRepository.findById(matchId);
    }

    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public List<Match> getMatchesByTournament(String tournamentId) {
        return matchRepository.findByTournament_TournamentID(tournamentId);
    }

    @Override
    public List<Match> getMatchesByTeam(String teamId) {
        return matchRepository.findByHomeTeam_TeamIDOrAwayTeam_TeamID(teamId, teamId);
    }

    @Override
    public Match updateMatchScore(String matchId, int homeScore, int awayScore, MatchStatus status, LocalDateTime fullTime) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new RuntimeException("Match not found"));
        match.setHomeTeamScore(homeScore);
        match.setAwayTeamScore(awayScore);
        match.setMatchStatus(status);
        match.setFullTime(fullTime);
        return matchRepository.save(match);
    }

}

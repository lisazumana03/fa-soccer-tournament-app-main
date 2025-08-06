package za.co.footballassoc.soccertournament.service.match;

import za.co.footballassoc.soccertournament.domain.match.Match;
import za.co.footballassoc.soccertournament.domain.match.MatchEvent;
import za.co.footballassoc.soccertournament.domain.match.MatchStatus;
import za.co.footballassoc.soccertournament.service.IService;

import java.time.LocalDateTime;
import java.util.*;

public interface IMatchService extends IService<Match, String> {
    Optional<Match> getMatchById(String matchId);
    List<Match> getMatchesByTournament(String tournamentID);
    List<Match> getMatchesByTeam(String teamId);
    Match updateMatchScore(String matchId, int homeScore, int awayScore, MatchStatus status, LocalDateTime fullTime);
}

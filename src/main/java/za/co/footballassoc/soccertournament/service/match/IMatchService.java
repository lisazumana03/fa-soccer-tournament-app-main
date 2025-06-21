package za.co.footballassoc.soccertournament.service.match;

import za.co.footballassoc.soccertournament.domain.match.MatchEvent;

public interface IMatchService {
    void startMatch(String matchID);
    void recordMatchEvent(String matchID, MatchEvent event);
}

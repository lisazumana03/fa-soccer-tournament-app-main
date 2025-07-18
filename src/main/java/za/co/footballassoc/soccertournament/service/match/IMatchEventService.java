package za.co.footballassoc.soccertournament.service.match;

import org.w3c.dom.stylesheets.LinkStyle;
import za.co.footballassoc.soccertournament.domain.match.MatchEvent;

import java.util.List;

public interface IMatchEventService {
    MatchEvent createMatchEvent(MatchEvent matchEvent);
    List<MatchEvent> getMatchEvents();
    MatchEvent updateMatchEvent(String eventID, MatchEvent matchEvent);
    void deleteMatchEvent(String eventID);
}

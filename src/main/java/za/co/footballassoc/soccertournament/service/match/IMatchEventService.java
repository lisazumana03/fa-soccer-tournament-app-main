package za.co.footballassoc.soccertournament.service.match;

import org.w3c.dom.stylesheets.LinkStyle;
import za.co.footballassoc.soccertournament.domain.match.MatchEvent;
import za.co.footballassoc.soccertournament.service.IService;

import java.util.List;

public interface IMatchEventService extends IService<MatchEvent, String> {
    void deleteMatchEvent(String eventID);
}

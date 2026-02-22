package za.co.footballassoc.soccertournament.factory.match;

import za.co.footballassoc.soccertournament.domain.match.EventType;
import za.co.footballassoc.soccertournament.domain.match.Match;
import za.co.footballassoc.soccertournament.domain.match.MatchEvent;
import za.co.footballassoc.soccertournament.domain.match.Venue;
import za.co.footballassoc.soccertournament.domain.team.Player;
import za.co.footballassoc.soccertournament.domain.team.Team;

public class MatchEventFactory {
    public static MatchEvent addMatchEvent(String eventID, Match match, int minute,
                                           EventType eventType, Player playerInvolved, Team teamInvolved,
                                           String eventDescription, boolean isVARReviewed, boolean isCancelledByVAR,
                                           String additionalInfo, Venue venueSelection, String assistantRefereeDecision,
                                           boolean injuryRelated) {
        return new MatchEvent.Builder()
                .setEventID(eventID)
                .setMatch(match)
                .setMinute(minute)
                .setEventType(eventType)
                .setPlayerInvolved(playerInvolved)
                .setTeam(teamInvolved)
                .setEventDescription(eventDescription)
                .setIsVARReviewed(isVARReviewed)
                .setIsCancelledByVAR(isCancelledByVAR)
                .setAdditionalInfo(additionalInfo)
                .setVenueSelection(venueSelection)
                .setAssistantRefereeDecision(assistantRefereeDecision)
                .setInjuryRelated(injuryRelated)
                .build();
    }
}

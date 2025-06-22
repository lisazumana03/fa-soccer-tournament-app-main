package za.co.footballassoc.soccertournament.factory.match;

import za.co.footballassoc.soccertournament.domain.match.Match;
import za.co.footballassoc.soccertournament.domain.match.Venue;
import za.co.footballassoc.soccertournament.domain.team.Team;

import java.time.LocalDateTime;

public class MatchFactory {
    public static Match createFixture(String matchID, LocalDateTime matchDate,
                                      Team homeTeam, Team awayTeam, String matchStatus,
                                      Venue venue, boolean extraTime, boolean penaltyShootout) {
        return new Match.Builder()
                .setMatchID(matchID)
                .setMatchDate(matchDate)
                .setHomeTeam(homeTeam)
                .setAwayTeam(awayTeam)
                .setHomeTeamScore(0)
                .setAwayTeamScore(0)
                .setVenue(venue)
                .setDuration(90)
                .setMatchStatus("Ongoing")
                .setExtraTime(extraTime)
                .setPenaltyShootout(penaltyShootout)
                .build();
    }
}

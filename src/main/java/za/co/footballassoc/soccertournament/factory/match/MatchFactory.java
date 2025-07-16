package za.co.footballassoc.soccertournament.factory.match;

import za.co.footballassoc.soccertournament.domain.match.Match;
import za.co.footballassoc.soccertournament.domain.match.MatchStatus;
import za.co.footballassoc.soccertournament.domain.match.Venue;
import za.co.footballassoc.soccertournament.domain.team.Player;
import za.co.footballassoc.soccertournament.domain.team.Team;

import java.time.LocalDateTime;

public class MatchFactory {
    public static Match createFixture(String matchID, LocalDateTime matchDate,
                                      Team homeTeam, Team awayTeam, MatchStatus matchStatus,
                                      Venue venue, LocalDateTime kickoffTime,
                                      LocalDateTime fullTime,boolean extraTime, boolean penaltyShootout, Player manOfTheMatch) {
        return new Match.Builder()
                .setMatchID(matchID)
                .setMatchDate(matchDate)
                .setHomeTeam(homeTeam)
                .setAwayTeam(awayTeam)
                .setHomeTeamScore(0)
                .setAwayTeamScore(0)
                .setVenue(venue)
                .setDuration(90)
                .setMatchStatus(matchStatus)
                .setKickOffTime(kickoffTime)
                .setFullTime(fullTime)
                .setExtraTime(extraTime)
                .setPenaltyShootout(penaltyShootout)
                .setManOfTheMatch(manOfTheMatch)
                .build();
    }
}

package za.co.footballassoc.soccertournament.factory.tournament;

import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.domain.tournament.League;

import java.time.LocalDate;
import java.util.List;

public class LeagueFactory {
    public static League createLeague(List<Team> teams, int numberOfGroups, int numberOfMatchDays) {
        return new League.Builder()
                .
                .setNumberOfGroups(numberOfGroups)
                .setNumberOfMatchDays(numberOfMatchDays)
                .build();
    }
}

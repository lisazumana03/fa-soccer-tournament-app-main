package za.co.footballassoc.soccertournament.factory.tournament;

import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.domain.tournament.League;

import java.time.LocalDate;
import java.util.List;

public class LeagueFactory {
    public static League createLeague(String tournamentID, String tournamentName,
                                      List<Team> teams,
                                      int homeAndAwayGames,
                                      int numberOfGroups, int numberOfMatchDays) {
        return new League.Builder()
                .setTournamentID(tournamentID)
                .setTournamentName(tournamentName)
                .setHomeAndAwayGames(homeAndAwayGames)
                .setTeams(teams)
                .setNumberOfGroups(numberOfGroups)
                .setNumberOfMatchDays(numberOfMatchDays)
                .build();
    }
}

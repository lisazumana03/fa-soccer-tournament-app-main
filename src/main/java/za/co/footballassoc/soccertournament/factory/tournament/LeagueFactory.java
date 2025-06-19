package za.co.footballassoc.soccertournament.factory.tournament;

import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.domain.tournament.League;

import java.time.LocalDate;
import java.util.List;

public class LeagueFactory {
    public static League createLeague(String tournamentID, String tournamentName, String tournamentLocation, String tournamentSeason, LocalDate startDate, LocalDate endDate, List<Team> teams, int homeAndAwayGames, byte[]tournamentLogo, int numberOfMatchDays, boolean hasPlayOffs, String playOffType) {
        return new League.Builder()
                .setTournamentID()
                .build();
    }
}

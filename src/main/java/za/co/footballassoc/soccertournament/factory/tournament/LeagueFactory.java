package za.co.footballassoc.soccertournament.factory.tournament;

import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.team.Gender;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.domain.tournament.League;
import za.co.footballassoc.soccertournament.domain.tournament.Tournament;
import za.co.footballassoc.soccertournament.domain.tournament.TournamentType;

import java.time.LocalDate;
import java.util.List;

public class LeagueFactory {
    public static League createLeague(String tournamentID, String tournamentName, Location tournamentLocation,
                                      String tournamentSeason, String ageGroup, TournamentType tournamentType,
                                      Gender tournamentGenderGroup, List<Team> teams, int homeAndAwayGames,
                                      int numberOfGroups, int numberOfMatchDays) {
        return new League.Builder()
                .setTournamentID(tournamentID)
                .setTournamentName(tournamentName)
                .setTournamentLocation(tournamentLocation)
                .setTournamentSeason(tournamentSeason)
                .setAgeGroup(ageGroup)
                .setTournamentType(tournamentType)
                .setTournamentGenderGroup(tournamentGenderGroup)

                .setHomeAndAwayGames(homeAndAwayGames)
                .setTeams(teams)
                .setNumberOfGroups(numberOfGroups)
                .setNumberOfMatchDays(numberOfMatchDays)
                .build();
    }
}

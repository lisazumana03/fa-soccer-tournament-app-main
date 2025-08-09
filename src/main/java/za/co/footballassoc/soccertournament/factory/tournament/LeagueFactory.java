package za.co.footballassoc.soccertournament.factory.tournament;

import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.team.Gender;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.domain.tournament.Association;
import za.co.footballassoc.soccertournament.domain.tournament.League;
import za.co.footballassoc.soccertournament.domain.tournament.Tournament;
import za.co.footballassoc.soccertournament.domain.tournament.TournamentType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class LeagueFactory {
    public static League createLeague(String tournamentID, String tournamentName, Location tournamentLocation,
                                      String tournamentSeason, String ageGroup, TournamentType tournamentType,
                                      Gender tournamentGenderGroup, LocalDateTime startDate, LocalDateTime endDate,
                                      List<Team> teams, int homeAndAwayGames, byte[] tournamentLogo, Association association,
                                      int numberOfGroups, int numberOfMatchDays, int promotionSpots, int relegationSpots,
                                      boolean hasPlayOffs, String playOffType) {
        return new League.Builder()
                .setTournamentID(tournamentID)
                .setTournamentName(tournamentName)
                .setTournamentLocation(tournamentLocation)
                .setTournamentSeason(tournamentSeason)
                .setAgeGroup(ageGroup)
                .setTournamentType(tournamentType)
                .setTournamentGenderGroup(tournamentGenderGroup)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .setTeams(teams)
                .setHomeAndAwayGames(homeAndAwayGames)
                .setTournamentLogo(tournamentLogo)
                .setAssociation(association)
                //The setters from the child class
                .setNumberOfGroups(numberOfGroups)
                .setNumberOfMatchDays(numberOfMatchDays)
                .setPromotionSpots(promotionSpots)
                .setRelegationSpots(relegationSpots)
                .hasPlayOffs(hasPlayOffs)
                .setPlayOffType(playOffType)
                .build();
    }
}

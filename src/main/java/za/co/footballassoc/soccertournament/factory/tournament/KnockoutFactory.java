package za.co.footballassoc.soccertournament.factory.tournament;

import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.team.Gender;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.domain.tournament.Association;
import za.co.footballassoc.soccertournament.domain.tournament.Knockout;
import za.co.footballassoc.soccertournament.domain.tournament.TournamentType;

import java.time.LocalDateTime;
import java.util.List;

public class KnockoutFactory {
    public static Knockout createKnockout(String tournamentID, String tournamentName, Location tournamentLocation,
                                          String tournamentSeason, String ageGroup, TournamentType tournamentType,
                                          Gender tournamentGenderGroup, LocalDateTime startDate, LocalDateTime endDate,
                                          List<Team> teams, int homeAndAwayGames, byte[] tournamentLogo, Association association,
                                          int numberOfRounds, boolean hasPlayOffs){
        return new Knockout.Builder()
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
                //Knockout logic
                .setNumberOfRounds(numberOfRounds)
                .setHasPlayOffs(hasPlayOffs)
                .build();
    }
}

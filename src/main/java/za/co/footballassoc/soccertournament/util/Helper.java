package za.co.footballassoc.soccertournament.util;

import ch.qos.logback.core.joran.sanity.Pair;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.domain.tournament.Knockout;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Helper {

    private static final Random RANDOM = new Random();

    public static int generateGoals() {
        return RANDOM.nextInt(100);
    }

    public static String determineWinner(int homeGoals, int awayGoals) {
        if (homeGoals > awayGoals) return "HOME";
        if (awayGoals > homeGoals) return "AWAY";
        return "DRAW";
    }

    //TOURNAMENT LOGICS

    //KNOCKOUT LOGICS
    public static Knockout mergeKnockout(Knockout existing, Knockout updated) {
        return new Knockout.Builder()
                .setTournamentID(existing.getTournamentID()) // id never changes
                .setTournamentName(updated.getTournamentName() != null ? updated.getTournamentName() : existing.getTournamentName())
                .setTournamentLocation(updated.getTournamentLocation() != null ? updated.getTournamentLocation() : existing.getTournamentLocation())
                .setTournamentSeason(updated.getTournamentSeason() != null ? updated.getTournamentSeason() : existing.getTournamentSeason())
                .setAgeGroup(updated.getAgeGroup() != null ? updated.getAgeGroup() : existing.getAgeGroup())
                .setTournamentType(updated.getTournamentType() != null ? updated.getTournamentType() : existing.getTournamentType())
                .setTournamentGenderGroup(updated.getTournamentGenderGroup() != null ? updated.getTournamentGenderGroup() : existing.getTournamentGenderGroup())
                .setStartDate(updated.getStartDate() != null ? updated.getStartDate() : existing.getStartDate())
                .setEndDate(updated.getEndDate() != null ? updated.getEndDate() : existing.getEndDate())
                .setTeams(updated.getTeams() != null ? updated.getTeams() : existing.getTeams())
                .setHomeAndAwayGames(updated.getHomeAndAwayGames() != 0 ? updated.getHomeAndAwayGames() : existing.getHomeAndAwayGames())
                .setTournamentLogo(updated.getTournamentLogo() != null ? updated.getTournamentLogo() : existing.getTournamentLogo())
                .setAssociation(updated.getAssociation() != null ? updated.getAssociation() : existing.getAssociation())
                .setNumberOfRounds(updated.getNumberOfRounds() != 0 ? updated.getNumberOfRounds() : existing.getNumberOfRounds())
                .setHasPlayOffs(updated.isHasPlayOffs())
                .build();
    }

}

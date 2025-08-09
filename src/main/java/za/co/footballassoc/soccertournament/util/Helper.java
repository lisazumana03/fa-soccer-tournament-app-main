package za.co.footballassoc.soccertournament.util;

import ch.qos.logback.core.joran.sanity.Pair;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.domain.tournament.Knockout;

import java.time.LocalDateTime;
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
    //LEAGUE LOGICS
    // Sorts teams depending on whether tournament has started
    public static List<Team> sortTable(List<Team> teams, LocalDateTime startDate) {
        if (startDate.isAfter(LocalDateTime.now())) {
            // Alphabetical order before start
            teams.sort(Comparator.comparing(Team::getTeamName));
        } else {
            // By points, then GD, then goals for
            teams.sort(Comparator.comparingInt(Team::getPoints).reversed()
                    .thenComparingInt(team -> team.getGoalsFor() - team.getGoalsAgainst()).reversed()
                    .thenComparingInt(Team::getGoalsFor).reversed());
        }
        return teams;
    }

    // Updates team stats after a match
    public static void updateTeamStats(Team home, Team away, int homeGoals, int awayGoals) {
        home.setGamesPlayed(home.getGamesPlayed() + 1);
        away.setGamesPlayed(away.getGamesPlayed() + 1);

        home.setGoalsFor(home.getGoalsFor() + homeGoals);
        home.setGoalsAgainst(home.getGoalsAgainst() + awayGoals);
        away.setGoalsFor(away.getGoalsFor() + awayGoals);
        away.setGoalsAgainst(away.getGoalsAgainst() + homeGoals);

        if (homeGoals > awayGoals) {
            home.setWins(home.getWins() + 1);
            away.setLosses(away.getLosses() + 1);
        } else if (awayGoals > homeGoals) {
            away.setWins(away.getWins() + 1);
            home.setLosses(home.getLosses() + 1);
        } else {
            home.setDraws(home.getDraws() + 1);
            away.setDraws(away.getDraws() + 1);
        }
    }
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

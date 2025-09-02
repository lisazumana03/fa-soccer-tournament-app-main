package za.co.footballassoc.soccertournament.util;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.domain.tournament.Knockout;

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
    public static List<Team> sortLeagueTable(List<Team> teams, boolean beforeStart) {
        if (beforeStart) {
            teams.sort(Comparator.comparing(Team::getTeamName));
        } else {
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

//    public static List<Match> generateRound(List<Team> teams, Tournament tournament) {
//        if (teams.size() % 2 != 0) throw new IllegalArgumentException("Teams must be even");
//        List<Match> matches = new ArrayList<>();
//        for (int i = 0; i < teams.size(); i += 2) {
//            matches.add(MatchFactory.createFixture(
//                    UUID.randomUUID().toString(),
//                    teams.get(i), teams.get(i + 1),
//                    LocalDateTime.now().plusDays(7),
//                    tournament
//            ));
//        }
//        return matches;
//    }

}

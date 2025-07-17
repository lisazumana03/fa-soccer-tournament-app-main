package za.co.footballassoc.soccertournament.util;

import za.co.footballassoc.soccertournament.domain.team.Team;

public class Helper {
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

}

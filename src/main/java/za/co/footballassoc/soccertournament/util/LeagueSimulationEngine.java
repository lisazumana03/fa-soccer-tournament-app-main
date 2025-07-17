package za.co.footballassoc.soccertournament.util;

import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.domain.tournament.League;

public class LeagueSimulationEngine {
    public static void applyFinalResults(League league) {
        List<Team> sorted = calculateLeagueTable(league);

        for (Team team : league.getTeams()) {
            team.setChampion(false);
            team.setRelegated(false);
            team.setPromoted(false);
            team.setQualifiesForContinental(false);
        }

        if (league.getEndDate().isBefore(LocalDateTime.now())) {
            sorted.get(0).setChampion(true);

            determinePromotedTeams(league).forEach(t -> t.setPromoted(true));
            determineRelegatedTeams(league).forEach(t -> t.setRelegated(true));
            determineContinentalQualifiedTeams(league, 4).forEach(t -> t.setQualifiesForContinental(true));
        }
    }
}

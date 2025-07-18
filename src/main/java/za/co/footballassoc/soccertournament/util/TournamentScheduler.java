package za.co.footballassoc.soccertournament.util;

import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.domain.tournament.Knockout;

import java.util.*;

public class TournamentScheduler {
    // Simulate group rankings & qualification
    public List<Team> getQualifiedTeams(List<Team> allTeams, int topNPerGroup) {
        Map<String, List<Team>> groupedTeams = new HashMap<>();

        // Group teams by group name
        for (Team team : allTeams) {
            String group = team.getGroupName();
            groupedTeams.putIfAbsent(group, new ArrayList<>());
            groupedTeams.get(group).add(team);
        }

        List<Team> qualified = new ArrayList<>();

        // For each group, sort by points and select top N
        for (Map.Entry<String, List<Team>> entry : groupedTeams.entrySet()) {
            List<Team> group = entry.getValue();

            group.sort(Comparator.comparingInt(Team::getPoints).reversed());
            qualified.addAll(group.stream().limit(topNPerGroup).toList());
        }

        return qualified;
    }

    // Generate knockout fixtures (bracket pairings)
    public List<Knockout> scheduleKnockoutMatches(List<Team> qualifiedTeams) {
        List<Knockout> matches = new ArrayList<>();

        // Shuffle for random seeding (optional)
        Collections.shuffle(qualifiedTeams);

        for (int i = 0; i < qualifiedTeams.size(); i += 2) {
            Team teamA = qualifiedTeams.get(i);
            Team teamB = qualifiedTeams.get(i + 1);
            matches.add(new Knockout(teamA, teamB));
        }

        return matches;
    }
}

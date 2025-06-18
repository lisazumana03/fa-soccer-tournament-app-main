package za.co.footballassoc.soccertournament.factory.team;

import za.co.footballassoc.soccertournament.domain.team.Team;

public class TeamFactory {
    public static Team createTeam() {
        return new Team.Builder()
                .setTeamID(createTeam().getTeamID()).build();
    }
}

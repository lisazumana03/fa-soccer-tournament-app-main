package za.co.footballassoc.soccertournament.factory.tournament;

import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.domain.tournament.League;

import java.time.LocalDate;
import java.util.List;

public class LeagueFactory {
    public static League createLeague() {
        return new League.Builder()
                .build();
    }
}

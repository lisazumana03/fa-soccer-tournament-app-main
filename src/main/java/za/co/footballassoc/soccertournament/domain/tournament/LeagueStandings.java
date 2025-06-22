package za.co.footballassoc.soccertournament.domain.tournament;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LeagueStandings {
    @Id
    private int standingNumber;
}

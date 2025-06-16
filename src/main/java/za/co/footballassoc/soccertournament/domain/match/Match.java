package za.co.footballassoc.soccertournament.domain.match;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import za.co.footballassoc.soccertournament.domain.tournament.Tournament;

@Entity
public class Match {
    @Id
    private String matchID;
    @ManyToOne
    private Tournament tournament;
}

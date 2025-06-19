package za.co.footballassoc.soccertournament.domain.match;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class MatchEvent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eventID;
    @ManyToOne
    private Match match;
}

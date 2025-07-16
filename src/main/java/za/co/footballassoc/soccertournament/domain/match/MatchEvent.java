package za.co.footballassoc.soccertournament.domain.match;

import jakarta.persistence.*;
import za.co.footballassoc.soccertournament.domain.team.Player;
import za.co.footballassoc.soccertournament.domain.team.Team;

import java.io.Serializable;

@Entity
public class MatchEvent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String eventID;
    @ManyToOne
    private Match match;
    private int minute; // Minute of the match (e.g., 23, 45+2, 90+5)

    @Enumerated(EnumType.STRING)
    private EventType eventType;
    @ManyToOne
    private Player playerInvolved;

    @ManyToOne
    private Team team; // Team responsible for the event

    private String eventDescription; // Optional: “Goal from outside the box”

    private boolean isVARReviewed;
    private boolean isCancelledByVAR;

    private String additionalInfo; // Assist, second yellow, etc.
    @OneToOne
    private Venue venueSelection;
    private String assistantRefereeDecision;
    private boolean isInjuryRelated;

}

package za.co.footballassoc.soccertournament.domain.team;

import jakarta.persistence.*;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;

import java.io.Serializable;

@Entity
public class Player implements Serializable {
    @Id
    private String playerID;
    @Embedded
    private Name playerName;
    @Embedded
    private Location playerLocationOfBirth;

    @ManyToOne
    private Team club;
    @ManyToOne
    @JoinColumn(name = "national_team_id")
    private Team nationalTeam;
}

package za.co.footballassoc.soccertournament.domain.team;

import jakarta.persistence.*;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Player implements Serializable {
    @Id
    private String playerID;
    @Embedded
    private Name playerName;
    private String playerNationality;
    private LocalDate playerDateOfBirth;
    @Embedded
    private Location playerLocationOfBirth;

    @ManyToOne
    private Team club;
    @ManyToOne
    @JoinColumn(name = "national_team_id")
    private Team nationalTeam;
}

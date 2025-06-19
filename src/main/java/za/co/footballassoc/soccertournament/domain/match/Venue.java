package za.co.footballassoc.soccertournament.domain.match;

import jakarta.persistence.*;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.team.Team;

import java.io.Serializable;
import java.util.List;

@Entity
public class Venue implements Serializable {
    @Id
    private String venueID;
    private String name;
    private Location stadiumAddress;
    @Enumerated(EnumType.STRING)
    private VenueType venueType;
    @OneToMany(mappedBy = "teamHomeGround")
    private List<Team> teams;
}

package za.co.footballassoc.soccertournament.domain.team;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.tournament.Tournament;

import java.io.Serializable;
import java.sql.Blob;

@Entity
public class Team implements Serializable {
    @Id
    private String teamId;
    private String teamName;
    @Embedded
    private Location teamLocation;
    private String teamFormationYear;
    private Blob teamLogo;
    @ManyToOne
    private Tournament tournament;
}

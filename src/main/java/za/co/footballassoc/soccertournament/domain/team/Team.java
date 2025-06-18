package za.co.footballassoc.soccertournament.domain.team;

import jakarta.persistence.*;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.tournament.Tournament;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

@Entity
public class Team implements Serializable {
    @Id
    private String teamID;
    private String teamName;
    @Embedded
    private Location teamLocation;
    private String teamFormationYear;
    private byte[] teamLogo; ///1024 x 768 e.g.
    @ManyToOne
    private Tournament tournament;
    @OneToMany(mappedBy = "team")
    private List<Player> players;

    @Enumerated(EnumType.STRING)
    private TeamType teamType;

    public Team() {}

    public static class Builder{
        private String teamID;
        private String teamName;
        private Location teamLocation;
        private String teamFormationYear;
        private byte[] teamLogo;
        private Tournament tournament;
    }

}

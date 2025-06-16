package za.co.footballassoc.soccertournament.domain.tournament;

import jakarta.persistence.*;
import za.co.footballassoc.soccertournament.domain.Team;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Tournament implements Serializable {
    @Id
    private UUID tournamentId;
    private String tournamentName;
    private String tournamentLocation; //city/town, country, continent
    @OneToMany(mappedBy = "tournament")
    private List<Team> teams;

    public Tournament() {}// for JPA

    protected Tournament(Builder<?> builder) {
        this.tournamentId = builder.tournamentId;
        this.tournamentName = builder.tournamentName;
        this.tournamentLocation = builder.tournamentLocation;
        this.teams = builder.teams;

    }

    public static class Builder<T extends Builder<T>> {
        private UUID tournamentId;
        private String tournamentName;
        private String tournamentLocation;
        private List<Team> teams;
        private Blob tournamentLogo; ////2000x1450 eg.
    }
}

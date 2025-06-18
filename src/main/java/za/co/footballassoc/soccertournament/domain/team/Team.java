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

    private Team(Builder builder) {
        this.teamID = builder.teamID;
        this.teamName = builder.teamName;
        this.teamLocation = builder.teamLocation;
        this.teamFormationYear = builder.teamFormationYear;
        this.teamLogo = builder.teamLogo;
        this.tournament = builder.tournament;
        this.players = builder.players;
        this.teamType = builder.teamType;
    }

    public static class Builder{
        private String teamID;
        private String teamName;
        private Location teamLocation;
        private String teamFormationYear;
        private byte[] teamLogo;
        private Tournament tournament;
        private List<Player> players;
        private TeamType teamType;

        public Builder setTeamID(String teamID) {
            this.teamID = teamID;
            return this;
        }

        public Builder setTeamName(String teamName) {
            this.teamName = teamName;
            return this;
        }
        public Builder setTeamLocation(Location teamLocation) {
            this.teamLocation = teamLocation;
            return this;
        }
        public Builder setTeamFormationYear(String teamFormationYear) {
            this.teamFormationYear = teamFormationYear;
            return this;
        }
        public Builder setTeamLogo(byte[] teamLogo) {
            this.teamLogo = teamLogo;
            return this;
        }
        public Builder setTournament(Tournament tournament) {
            this.tournament = tournament;
            return this;
        }


    }

}

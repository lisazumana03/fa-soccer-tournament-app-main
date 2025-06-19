package za.co.footballassoc.soccertournament.domain.team;

import jakarta.persistence.*;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.match.Venue;
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
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;
    @OneToMany(mappedBy = "club")
    private List<Player> players;
    @Enumerated(EnumType.STRING)
    private TeamType teamType;

    @ManyToOne
    private Venue teamHomeGround;

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
        this.teamHomeGround = builder.teamHomeGround;
    }

    public String getTeamID() {
        return teamID;
    }

    public String getTeamName() {
        return teamName;
    }

    public Location getTeamLocation() {
        return teamLocation;
    }

    public String getTeamFormationYear() {
        return teamFormationYear;
    }

    public byte[] getTeamLogo() {
        return teamLogo;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public TeamType getTeamType() {
        return teamType;
    }

    public Venue getTeamHomeGround() {
        return teamHomeGround;
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
        private Venue teamHomeGround;

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
        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        public Builder setTeamType(TeamType teamType) {
            this.teamType = teamType;
            return this;
        }
        public Builder setTeamHomeGround(Venue teamHomeGround) {
            this.teamHomeGround = teamHomeGround;
            return this;
        }

        public Builder copy(Team team){
            this.teamID = team.teamID;
            this.teamName = team.teamName;
            this.teamLocation = team.teamLocation;
            this.teamFormationYear = team.teamFormationYear;
            this.teamLogo = team.teamLogo;
            this.tournament = team.tournament;
            this.players = team.players;
            this.teamType = team.teamType;
            this.teamHomeGround = team.teamHomeGround;
            return this;
        }

        public Team build() {
            return new Team(this);
        }

    }

}

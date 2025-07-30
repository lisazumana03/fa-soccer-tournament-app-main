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

    @Column(nullable = true)
    private String groupName; // e.g., "Group A", null for knockout-only
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    // Team stats
    private int gamesPlayed;
    private int wins;
    private int draws;
    private int losses;
    private int goalsFor;
    private int goalsAgainst;
    private int points;

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
        this.groupName = builder.groupName;
        this.gamesPlayed = builder.gamesPlayed;
        this.wins = builder.wins;
        this.draws = builder.draws;
        this.losses = builder.losses;
        this.goalsFor = builder.goalsFor;
        this.goalsAgainst = builder.goalsAgainst;
        this.points = builder.points;
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

    public String getGroupName() {
        return groupName;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLosses() {
        return losses;
    }

    public int getGoalsFor(){
        return goalsFor;
    }

    public int getGoalsAgainst(){
        return goalsAgainst;
    }

    public int getGoalDifference() {
        return goalsFor - goalsAgainst;
    }

    public int getPoints() {
        return (wins * 3) + draws; // Standard 3-1-0 point system
    }

    public Owner getOwner() {
        return owner;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public void setPoints(int points) {
        this.points = points;
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
        private String groupName; // e.g., "Group A", null for knockout-only
        private Owner owner;

        // Team stats
        private int gamesPlayed;
        private int wins;
        private int draws;
        private int losses;
        private int goalsFor;
        private int goalsAgainst;
        private int points;

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

        public Builder setGroupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        public Builder setGamesPlayed(int gamesPlayed) {
            this.gamesPlayed = gamesPlayed;
            return this;
        }

        public Builder setWins(int wins) {
            this.wins = wins;
            return this;
        }

        public Builder setDraws(int draws) {
            this.draws = draws;
            return this;
        }

        public Builder setLosses(int losses) {
            this.losses = losses;
            return this;
        }

        public Builder setGoalsFor(int goalsFor) {
            this.goalsFor = goalsFor;
            return this;
        }

        public Builder setGoalsAgainst(int goalsAgainst) {
            this.goalsAgainst = goalsAgainst;
            return this;
        }

        public Builder setPoints(int points) {
            this.points = points;
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
            this.groupName = team.groupName;
            this.gamesPlayed = team.gamesPlayed;
            this.wins = team.wins;
            this.draws = team.draws;
            this.losses = team.losses;
            this.goalsFor = team.goalsFor;
            this.goalsAgainst = team.goalsAgainst;
            this.points = team.points;
            return this;
        }

        public Team build() {
            return new Team(this);
        }

    }

}

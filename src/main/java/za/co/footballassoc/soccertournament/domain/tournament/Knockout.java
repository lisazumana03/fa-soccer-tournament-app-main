package za.co.footballassoc.soccertournament.domain.tournament;

import jakarta.persistence.Entity;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.team.Gender;
import za.co.footballassoc.soccertournament.domain.team.Team;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Knockout extends Tournament implements Serializable {
    private int numberOfRounds;
    private boolean hasPlayOffs;

    protected Knockout(){}

    public Knockout(Team teamA, Team teamB){
        super();
    }

    private Knockout(Builder builder) {
        super(builder.tournamentID,
                builder.tournamentName,
                builder.tournamentLocation,
                builder.tournamentSeason,
                builder.ageGroup,
                builder.tournamentType,
                builder.tournamentGenderGroup,
                builder.startDate,
                builder.endDate,
                builder.teams,
                builder.homeAndAwayGames,
                builder.tournamentLogo,
                builder.association);
        this.tournamentID = builder.tournamentID;
        this.numberOfRounds = builder.numberOfRounds;
        this.hasPlayOffs = builder.hasPlayOffs;
    }


    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public boolean isHasPlayOffs() {
        return hasPlayOffs;
    }

    @Override
    public String toString() {
        return "Knockout{" +
                "numberOfRounds=" + numberOfRounds +
                ", hasPlayOffs=" + hasPlayOffs +
                ", tournamentName='" + tournamentName + '\'' +
                ", tournamentLocation='" + tournamentLocation + '\'' +
                ", tournamentSeason='" + tournamentSeason + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", teams=" + teams +
                '}';
    }

    public static class Builder{
        private String tournamentID;
        private String tournamentName;
        private Location tournamentLocation;
        private String tournamentSeason;
        private String ageGroup;
        private Gender tournamentGenderGroup;
        private TournamentType tournamentType;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private List<Team> teams;
        private int homeAndAwayGames;
        private byte[] tournamentLogo;
        private Association association;
        private int numberOfRounds;
        private boolean hasPlayOffs;

        public Builder setTournamentID(String tournamentID){
            this.tournamentID = tournamentID;
            return this;
        }

        public Builder setTournamentName(String name) { this.tournamentName = name; return this; }
        public Builder setTournamentLocation(Location tournamentLocation) { this.tournamentLocation = tournamentLocation; return this; }
        public Builder setTournamentSeason(String season) { this.tournamentSeason = season; return this; }
        public Builder setAgeGroup(String ageGroup) { this.ageGroup = ageGroup; return this; }
        public Builder setTournamentType(TournamentType type) { this.tournamentType = type; return this; }
        public Builder setTournamentGenderGroup(Gender gender) { this.tournamentGenderGroup = gender; return this; }
        public Builder setStartDate(LocalDateTime startDate) { this.startDate = startDate; return this; }
        public Builder setEndDate(LocalDateTime endDate) { this.endDate = endDate; return this; }
        public Builder setTeams(List<Team> teams) { this.teams = teams; return this; }
        public Builder setHomeAndAwayGames(int games) { this.homeAndAwayGames = games; return this; }
        public Builder setTournamentLogo(byte[] logo) { this.tournamentLogo = logo; return this; }
        public Builder setAssociation(Association association) { this.association = association; return this; }

        public Builder setNumberOfRounds(int numberOfRounds) {
            this.numberOfRounds = numberOfRounds;
            return this;
        }

        public Builder setHasPlayOffs(boolean hasPlayOffs) {
            this.hasPlayOffs = hasPlayOffs;
            return this;
        }

        protected Builder self(){
            return this;
        }

        public Builder copy(Knockout knockout){
            this.tournamentID = knockout.tournamentID;
            this.tournamentName = knockout.tournamentName;
            this.tournamentLocation = knockout.tournamentLocation;
            this.tournamentSeason = knockout.tournamentSeason;
            this.ageGroup = knockout.ageGroup;
            this.tournamentGenderGroup = knockout.tournamentGenderGroup;
            this.tournamentType = knockout.tournamentType;
            this.startDate = knockout.startDate;
            this.endDate = knockout.endDate;
            this.teams = knockout.teams;
            this.homeAndAwayGames = knockout.homeAndAwayGames;
            this.tournamentLogo = knockout.tournamentLogo;
            this.association = knockout.association;
            this.numberOfRounds = knockout.numberOfRounds;
            this.hasPlayOffs = knockout.hasPlayOffs;
            return this;
        }

        public Knockout build() {
            return new Knockout(this);
        }

    }
}

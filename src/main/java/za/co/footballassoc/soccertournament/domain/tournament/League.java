package za.co.footballassoc.soccertournament.domain.tournament;

import jakarta.persistence.Entity;
import za.co.footballassoc.soccertournament.domain.team.Gender;
import za.co.footballassoc.soccertournament.domain.team.Team;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class League extends Tournament implements Serializable {
    private int numberOfMatchDays;
    private int promotionSpots;
    private int relegationSpots;
    private int numberOfGroups;///optional
    private boolean hasPlayOffs;///optional
    private String playOffType;///optional

    protected League() {
        super();
    }

    protected League(Builder builder) {
        this.tournamentID = builder.tournamentID;
        this.tournamentName = builder.tournamentName;
        this.tournamentLocation = builder.tournamentLocation;
        this.tournamentSeason = builder.tournamentSeason;
        this.tournamentGenderGroup = builder.tournamentGenderGroup;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.teams = builder.teams;
        this.numberOfMatchDays = builder.numberOfMatchDays;
        this.promotionSpots = builder.promotionSpots;
        this.relegationSpots = builder.relegationSpots;
        this.numberOfGroups = builder.numberOfGroups;
        this.hasPlayOffs = builder.hasPlayOffs;
        this.playOffType = builder.playOffType;
    }

    public int getNumberOfMatchDays() {
        return numberOfMatchDays;
    }

    public int getPromotionSpots() {
        return promotionSpots;
    }

    public int getRelegationSpots() {
        return relegationSpots;
    }

    public boolean isHasPlayOffs() {
        return hasPlayOffs;
    }

    public String getPlayOffType() {
        return playOffType;
    }

    @Override
    public String toString() {
        return "League{" +
                "numberOfMatchDays=" + numberOfMatchDays +
                ", promotionSpots=" + promotionSpots +
                ", relegationSpots=" + relegationSpots +
                ", numberOfGroups=" + numberOfGroups +
                ", hasPlayOffs=" + hasPlayOffs +
                ", playOffType='" + playOffType + '\'' +
                ", tournamentID='" + tournamentID + '\'' +
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
        private String tournamentLocation;
        private String tournamentSeason;
        private Gender tournamentGenderGroup;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private List<Team> teams;
        private int numberOfMatchDays;
        private int promotionSpots;
        private int relegationSpots;
        private int numberOfGroups;
        private boolean hasPlayOffs;
        private String playOffType;

        public Builder setNumberOfMatchDays(int numberOfMatchDays) {
            this.numberOfMatchDays = numberOfMatchDays;
            return this;
        }

        public Builder setPromotionSpots(int promotionSpots) {
            this.promotionSpots = promotionSpots;
            return this;
        }

        public Builder setRelegationSpots(int relegationSpots) {
            this.relegationSpots = relegationSpots;
            return this;
        }

        public Builder setNumberOfGroups(int numberOfGroups) {
            this.numberOfGroups = numberOfGroups;
            return this;
        }

        public Builder hasPlayOffs(boolean hasPlayOffs) {
            this.hasPlayOffs = hasPlayOffs;
            return this;
        }

        public Builder setPlayOffType(String playOffType) {
            this.playOffType = playOffType;
            return this;
        }

        protected Builder self(){
            return this;
        }

        public League build() {
            return new League(this);
        }

    }

}

package za.co.footballassoc.soccertournament.domain.tournament;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.io.Serializable;
import java.util.Arrays;

@Entity
public class Hybrid extends Tournament implements Serializable {

    // League-related
    private int numberOfMatchDays;
    private int promotionSpots;
    private int relegationSpots;
    private int numberOfGroups; // optional
    private boolean hasPlayOffs; // optional
    private String playOffType; // optional

    // Knockout-related
    private int numberOfKnockoutRounds;
    private boolean hasFinalKnockout;

    // Hybrid-specific
    private boolean groupStageBeforeKnockout; // true = league then knockout
    private int numberOfTeamsToQualify; // number of teams advancing to knockout

    public Hybrid(){}

    private Hybrid(Builder builder) {
        super();
        this.numberOfMatchDays = builder.numberOfMatchDays;
        this.promotionSpots = builder.promotionSpots;
        this.relegationSpots = builder.relegationSpots;
        this.numberOfGroups = builder.numberOfGroups;
        this.hasPlayOffs = builder.hasPlayOffs;
        this.playOffType = builder.playOffType;
        this.numberOfKnockoutRounds = builder.numberOfKnockoutRounds;
        this.hasFinalKnockout = builder.hasFinalKnockout;
        this.groupStageBeforeKnockout = builder.groupStageBeforeKnockout;
        this.numberOfTeamsToQualify = builder.numberOfTeamsToQualify;
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

    public int getNumberOfGroups() {
        return numberOfGroups;
    }

    public boolean isHasPlayOffs() {
        return hasPlayOffs;
    }

    public String getPlayOffType() {
        return playOffType;
    }

    public int getNumberOfKnockoutRounds() {
        return numberOfKnockoutRounds;
    }

    public boolean isHasFinalKnockout() {
        return hasFinalKnockout;
    }

    public boolean isGroupStageBeforeKnockout() {
        return groupStageBeforeKnockout;
    }

    public int getNumberOfTeamsToQualify() {
        return numberOfTeamsToQualify;
    }

    @Override
    public String toString() {
        return "Hybrid{" +
                "numberOfMatchDays=" + numberOfMatchDays +
                ", promotionSpots=" + promotionSpots +
                ", relegationSpots=" + relegationSpots +
                ", numberOfGroups=" + numberOfGroups +
                ", hasPlayOffs=" + hasPlayOffs +
                ", playOffType='" + playOffType + '\'' +
                ", numberOfKnockoutRounds=" + numberOfKnockoutRounds +
                ", hasFinalKnockout=" + hasFinalKnockout +
                ", groupStageBeforeKnockout=" + groupStageBeforeKnockout +
                ", numberOfTeamsToQualify=" + numberOfTeamsToQualify +
                ", tournamentID='" + tournamentID + '\'' +
                ", tournamentName='" + tournamentName + '\'' +
                ", tournamentLocation='" + tournamentLocation + '\'' +
                ", tournamentSeason='" + tournamentSeason + '\'' +
                ", ageGroup='" + ageGroup + '\'' +
                ", association=" + association +
                ", tournamentLogo=" + Arrays.toString(tournamentLogo) +
                ", homeAndAwayGames=" + homeAndAwayGames +
                ", teams=" + teams +
                ", endDate=" + endDate +
                ", startDate=" + startDate +
                ", tournamentGenderGroup=" + tournamentGenderGroup +
                ", tournamentType=" + tournamentType +
                '}';
    }

    public static class Builder{
        // League-related
        private int numberOfMatchDays;
        private int promotionSpots;
        private int relegationSpots;
        private int numberOfGroups; // optional
        private boolean hasPlayOffs; // optional
        private String playOffType; // optional

        // Knockout-related
        private int numberOfKnockoutRounds;
        private boolean hasFinalKnockout;

        // Hybrid-specific
        private boolean groupStageBeforeKnockout; // true = league then knockout
        private int numberOfTeamsToQualify; // number of teams advancing to knockout

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

        public Builder setNumberOfKnockoutRounds(int numberOfKnockoutRounds) {
            this.numberOfKnockoutRounds = numberOfKnockoutRounds;
            return this;
        }

        public Builder setHasFinalKnockout(boolean hasFinalKnockout) {
            this.hasFinalKnockout = hasFinalKnockout;
            return this;
        }

        public Builder setNumberOfTeamsToQualify(int numberOfTeamsToQualify) {
            this.numberOfTeamsToQualify = numberOfTeamsToQualify;
            return this;
        }

        protected Builder self(){
            return this;
        }
        public Hybrid build() {
            return new Hybrid(this);
        }
    }
}

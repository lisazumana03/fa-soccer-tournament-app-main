package za.co.footballassoc.soccertournament.domain.tournament;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Standing {
    @Id
    private int standingNumber;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesDrawn;
    private int gamesLost;
    private int goalsScored;
    private int goalsConceded;
    private int goalsDifference;
    private int points;

    public Standing() {
    }

    private Standing(Builder builder) {
        this.standingNumber = builder.standingNumber;
        this.gamesPlayed = builder.gamesPlayed;
        this.gamesWon = builder.gamesWon;
        this.gamesDrawn = builder.gamesDrawn;
        this.gamesLost = builder.gamesLost;
        this.goalsScored = builder.goalsScored;
        this.goalsConceded = builder.goalsConceded;
        this.goalsDifference = builder.goalsDifference;
        this.points = builder.points;
    }

    public int getStandingNumber() {
        return standingNumber;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public int getGamesDrawn() {
        return gamesDrawn;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public int getGoalsDifference() {
        return goalsDifference;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Standing{" +
                "standingNumber=" + standingNumber +
                ", gamesPlayed=" + gamesPlayed +
                ", gamesWon=" + gamesWon +
                ", gamesDrawn=" + gamesDrawn +
                ", gamesLost=" + gamesLost +
                ", goalsScored=" + goalsScored +
                ", goalsConceded=" + goalsConceded +
                ", goalsDifference=" + goalsDifference +
                ", points=" + points +
                '}';
    }

    public static class Builder {
        private int standingNumber;
        private int gamesPlayed;
        private int gamesWon;
        private int gamesDrawn;
        private int gamesLost;
        private int goalsScored;
        private int goalsConceded;
        private int goalsDifference;
        private int points;

        public Builder setStandingNumber(int standingNumber) {
            this.standingNumber = standingNumber;
            return this;
        }
        public Builder setGamesPlayed(int gamesPlayed) {
            this.gamesPlayed = gamesPlayed;
            return this;
        }
        public Builder setGamesWon(int gamesWon) {
            this.gamesWon = gamesWon;
            return this;
        }
        public Builder setGamesDrawn(int gamesDrawn) {
            this.gamesDrawn = gamesDrawn;
            return this;
        }
        public Builder setGamesLost(int gamesLost) {
            this.gamesLost = gamesLost;
            return this;
        }
        public Builder setGoalsScored(int goalsScored) {
            this.goalsScored = goalsScored;
            return this;
        }
        public Builder setGoalsConceded(int goalsConceded) {
            this.goalsConceded = goalsConceded;
            return this;
        }
        public Builder setGoalsDifference(int goalsDifference) {
            this.goalsDifference = goalsDifference;
            return this;
        }
        public Builder setPoints(int points) {
            this.points = points;
            return this;
        }
        public Standing build() {
            return new Standing(this);
        }
    }
}

package za.co.footballassoc.soccertournament.domain.tournament;

import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class League extends Tournament implements Serializable {
    private int numberOfMatchDays;
    private boolean hasPlayOffs;
    private String playOffType;

    public League() {}

    private League(Builder builder) {
        super(builder);
        this.numberOfMatchDays = builder.numberOfMatchDays;
    }

    public int getNumberOfMatchDays() {
        return numberOfMatchDays;
    }

    public boolean isHasPlayOffs() {
        return hasPlayOffs;
    }

    public String getPlayOffType() {
        return playOffType;
    }

    @Override
    public String toString() {
        return "LeagueTournament{" +
                "numberOfMatchDays=" + numberOfMatchDays +
                ", hasPlayOffs=" + hasPlayOffs +
                ", playOffType='" + playOffType + '\'' +
                '}';
    }

    public static class Builder extends Tournament.Builder<Builder> {
        private int numberOfMatchDays;
        private boolean hasPlayOffs;
        private String playOffType;

        public Builder setNumberOfMatchDays(int numberOfMatchDays) {
            this.numberOfMatchDays = numberOfMatchDays;
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

package za.co.footballassoc.soccertournament.domain.tournament;

import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class Hybrid extends Tournament implements Serializable {
    private int groupStageRounds;
    private int knockoutRounds;
    private boolean hasPlayOffs;
    private String playOffType;

    public Hybrid(){}

    private Hybrid(Builder builder) {
        super();
        this.groupStageRounds = builder.groupStageRounds;
        this.knockoutRounds = builder.knockoutRounds;
        this.hasPlayOffs = builder.hasPlayOffs;
        this.playOffType = builder.playOffType;
    }

    public int getGroupStageRounds() {
        return groupStageRounds;
    }

    public int getKnockoutRounds() {
        return knockoutRounds;
    }

    public boolean isHasPlayOffs() {
        return hasPlayOffs;
    }

    public String getPlayOffType() {
        return playOffType;
    }

    public static class Builder{
        private int groupStageRounds;
        private int knockoutRounds;
        private boolean hasPlayOffs;
        private String playOffType;

        public Builder setGroupStageRounds(int groupStageRounds) {
            this.groupStageRounds = groupStageRounds;
            return this;
        }
        public Builder setKnockoutRounds(int knockoutRounds) {
            this.knockoutRounds = knockoutRounds;
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
        public Hybrid build() {
            return new Hybrid(this);
        }
    }
}

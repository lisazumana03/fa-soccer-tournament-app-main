package za.co.footballassoc.soccertournament.domain.tournament;

import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class Hybrid extends Tournament implements Serializable {
    private boolean hasPlayOffs;
    private String playOffType;

    public Hybrid(){}

    private Hybrid(Builder builder) {
        super(builder);
        this.hasPlayOffs = builder.hasPlayOffs;
        this.playOffType = builder.playOffType;
    }

    public boolean isHasPlayOffs() {
        return hasPlayOffs;
    }

    public String getPlayOffType() {
        return playOffType;
    }

    public static class Builder extends Tournament.Builder<Builder>{
        private boolean hasPlayOffs;
        private String playOffType;

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

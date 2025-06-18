package za.co.footballassoc.soccertournament.domain.tournament;

import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class Knockout extends Tournament implements Serializable {
    private int numberOfRounds;
    private boolean hasPlayOffs;

    public Knockout(){}

    private Knockout(Builder builder) {
        super(builder);
        this.numberOfRounds = builder.numberOfRounds;
        this.hasPlayOffs = builder.hasPlayOffs;
    }


    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public boolean isHasPlayOffs() {
        return hasPlayOffs;
    }


    public static class Builder extends Tournament.Builder<Builder> {
        private int numberOfRounds;
        private boolean hasPlayOffs;

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

        public Knockout build() {
            return new Knockout(this);
        }

    }
}

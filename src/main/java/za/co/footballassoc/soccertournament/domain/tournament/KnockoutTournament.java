package za.co.footballassoc.soccertournament.domain.tournament;

import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class KnockoutTournament extends Tournament implements Serializable {
    private int numberOfRounds;
    private boolean hasPlayOffs;
    private String playOffType;

    public KnockoutTournament(){}

    private KnockoutTournament(Builder builder) {
        super(builder);
        this.numberOfRounds = builder.numberOfRounds;
        this.hasPlayOffs = builder.hasPlayOffs;
        this.playOffType = builder.playOffType;
    }


    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public boolean isHasPlayOffs() {
        return hasPlayOffs;
    }

    public String getPlayOffType() {
        return playOffType;
    }

    public static class Builder extends Tournament.Builder<Builder> {
        private int numberOfRounds;
        private boolean hasPlayOffs;
        private String playOffType;
    }
}

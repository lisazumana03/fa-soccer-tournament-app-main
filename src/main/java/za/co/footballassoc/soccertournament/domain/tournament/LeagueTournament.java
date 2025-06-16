package za.co.footballassoc.soccertournament.domain.tournament;

import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class LeagueTournament extends Tournament implements Serializable {
    private int numberOfMatchDays;
    private boolean hasPlayOffs;
    private String playOffType;

    public LeagueTournament(){}

    private LeagueTournament(Builder builder) {
        super(builder);
        this.numberOfMatchDays = builder.numberOfMatchDays;
    }

    public static class Builder extends Tournament.Builder<Builder> {
        private int numberOfMatchDays;
    }

}

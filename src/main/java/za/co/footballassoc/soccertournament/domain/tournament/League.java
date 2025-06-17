package za.co.footballassoc.soccertournament.domain.tournament;

import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class League extends Tournament implements Serializable {
    private int numberOfMatchDays;
    private boolean hasPlayOffs;
    private String playOffType;

    public League(){}

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
    }

}

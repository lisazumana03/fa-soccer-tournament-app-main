package za.co.footballassoc.soccertournament.domain.tournament;

import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class KnockoutTournament extends Tournament implements Serializable {
    private int numberOfRounds;
    private boolean hasPlayOffs;
    private String playOffType;
}

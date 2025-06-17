package za.co.footballassoc.soccertournament.domain.tournament;

import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class Hybrid extends Tournament implements Serializable {
    private boolean hasPlayOffs;
    private String playOffType;
}

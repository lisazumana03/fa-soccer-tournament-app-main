package za.co.footballassoc.soccertournament.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import za.co.footballassoc.soccertournament.domain.tournament.Tournament;

import java.io.Serializable;

@Entity
public class Team implements Serializable {
    @Id
    private Long teamId;
    private String teamName;

    @ManyToOne
    private Tournament tournament;
}

package za.co.footballassoc.soccertournament.domain.team;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import za.co.footballassoc.soccertournament.domain.Name;

import java.io.Serializable;

@Entity
public class Player implements Serializable {
    @Id
    private String playerID;
    @Embedded
    private Name playerName;
}

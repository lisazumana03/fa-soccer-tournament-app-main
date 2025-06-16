package za.co.footballassoc.soccertournament.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.validator.constraints.ISBN;

import java.io.Serial;
import java.io.Serializable;

@Entity
public class Player implements Serializable {
    @Id
    private String playerID;
    private Name playerName;
}

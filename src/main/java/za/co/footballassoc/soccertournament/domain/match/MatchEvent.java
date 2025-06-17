package za.co.footballassoc.soccertournament.domain.match;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class MatchEvent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eventID;
}

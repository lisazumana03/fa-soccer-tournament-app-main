package za.co.footballassoc.soccertournament.domain.official;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public abstract class Official implements Serializable {
    @Id
    private String officialId;
}

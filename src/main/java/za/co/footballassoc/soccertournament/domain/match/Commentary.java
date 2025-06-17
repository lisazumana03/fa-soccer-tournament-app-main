package za.co.footballassoc.soccertournament.domain.match;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import za.co.footballassoc.soccertournament.domain.Name;

import java.io.Serializable;

@Entity
public class Commentary implements Serializable {
    @Id
    private String commentaryID;
    @Embedded
    private Name commentatorName;
    private String commentatorNationality;
}

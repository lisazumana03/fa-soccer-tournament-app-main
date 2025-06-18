package za.co.footballassoc.soccertournament.domain.match;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import za.co.footballassoc.soccertournament.domain.Name;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Commentary implements Serializable {
    @Id
    private String commentaryID;
    @Embedded
    private Name commentatorName;
    private String commentatorNationality;
    private LocalDate commentatorDateOfBirth;
    private String commentaryLanguage;
}

package za.co.footballassoc.soccertournament.domain.official;

import jakarta.persistence.*;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.match.Match;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public abstract class Official implements Serializable {
    @Id
    private String officialId;
    @Embedded
    private Name officalName;
    private String officialNationality;
    private LocalDate officalDateOfBirth;
    @Embedded
    private Location officialLocationOfBirth;
    private String officalOrganisation;
    @ManyToOne
    private Match match;

    public Official() {}


}

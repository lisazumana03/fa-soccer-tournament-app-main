package za.co.footballassoc.soccertournament.domain.official;

import jakarta.persistence.*;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.match.Match;
import za.co.footballassoc.soccertournament.domain.team.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public abstract class Official implements Serializable {
    @Id
    protected String officialId;
    @Embedded
    protected Name officialName;
    @Enumerated(EnumType.STRING)
    protected Gender officialGender;
    protected String officialNationality;
    protected LocalDate officialDateOfBirth;
    @Embedded
    protected Location officialLocationOfBirth;
    protected String officialOrganisation;
    @ManyToOne
    protected Match match;

    public Official() {}

    public Official(String officialId, Name officialName, Gender officialGender, String officialNationality, LocalDate officialDateOfBirth, Location officialLocationOfBirth, String officialOrganisation, Match match) {
        this.officialId = officialId;
        this.officialName = officialName;
        this.officialGender = officialGender;
        this.officialNationality = officialNationality;
        this.officialDateOfBirth = officialDateOfBirth;
        this.officialLocationOfBirth = officialLocationOfBirth;
        this.officialOrganisation = officialOrganisation;
        this.match = match;
    }

    public String getOfficialId() {
        return officialId;
    }

    public void setOfficialId(String officialId) {
        this.officialId = officialId;
    }

    public Name getOfficialName() {
        return officialName;
    }

    public void setOfficialName(Name officalName) {
        this.officialName = officalName;
    }

    public String getOfficialNationality() {
        return officialNationality;
    }

    public void setOfficialNationality(String officialNationality) {
        this.officialNationality = officialNationality;
    }

    public LocalDate getOfficialDateOfBirth() {
        return officialDateOfBirth;
    }

    public void setOfficialDateOfBirth(LocalDate officialDateOfBirth) {
        this.officialDateOfBirth = officialDateOfBirth;
    }

    public Location getOfficialLocationOfBirth() {
        return officialLocationOfBirth;
    }

    public void setOfficialLocationOfBirth(Location officialLocationOfBirth) {
        this.officialLocationOfBirth = officialLocationOfBirth;
    }

    public String getOfficialOrganisation() {
        return officialOrganisation;
    }

    public void setOfficialOrganisation(String officialOrganisation) {
        this.officialOrganisation = officialOrganisation;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    @Override
    public abstract String toString();
}

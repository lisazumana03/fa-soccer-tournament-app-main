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
    protected Name officalName;
    protected String officialNationality;
    protected LocalDate officialDateOfBirth;
    @Embedded
    protected Location officialLocationOfBirth;
    protected String officialOrganisation;
    @ManyToOne
    protected Match match;

    public Official() {}

    public Official(String officialId, Name officalName, String officialNationality, LocalDate officialDateOfBirth, Location officialLocationOfBirth, String officialOrganisation, Match match) {
        this.officialId = officialId;
        this.officalName = officalName;
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

    public Name getOfficalName() {
        return officalName;
    }

    public void setOfficalName(Name officalName) {
        this.officalName = officalName;
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
}

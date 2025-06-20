package za.co.footballassoc.soccertournament.domain.official;

import jakarta.persistence.Entity;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.match.Match;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class VAR extends Official implements Serializable {
    private int techExperience;

    public VAR() {}

    private VAR(Builder builder) {
        this.techExperience = builder.techExperience;
    }

    public int getTechExperience() {
        return techExperience;
    }

    @Override
    public String toString() {
        return "VAR{" +
                "techExperience=" + techExperience +
                ", officialName=" + officialName +
                ", officialNationality='" + officialNationality + '\'' +
                ", officialDateOfBirth=" + officialDateOfBirth +
                ", officialLocationOfBirth=" + officialLocationOfBirth +
                ", officialOrganisation='" + officialOrganisation + '\'' +
                ", match=" + match +
                '}';
    }

    public static class Builder{
        private int officialId;
        private Name officialName;
        private String officialNationality;
        private LocalDate officialDateOfBirth;
        private Location officialLocationOfBirth;
        private String officialOrganisation;
        private Match match;
        private int techExperience;
    }

}

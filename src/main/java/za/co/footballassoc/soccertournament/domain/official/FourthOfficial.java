package za.co.footballassoc.soccertournament.domain.official;

import jakarta.persistence.Entity;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.match.Match;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class FourthOfficial extends Official implements Serializable {
    private String role;

    public FourthOfficial() {}

    private FourthOfficial(Builder builder) {
        this.role = builder.role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "FourthOfficial{" +
                "role='" + role + '\'' +
                ", officialName=" + officialName +
                ", officialNationality='" + officialNationality + '\'' +
                ", officialDateOfBirth=" + officialDateOfBirth +
                ", officialOrganisation='" + officialOrganisation + '\'' +
                ", officialLocationOfBirth=" + officialLocationOfBirth +
                ", match=" + match +
                '}';
    }

    public static class Builder {
        private int officialId;
        private Name officialName;
        private String officialNationality;
        private LocalDate officialDateOfBirth;
        private Location officialLocationOfBirth;
        private String officialOrganisation;
        private Match match;
        private String role;
    }
}

package za.co.footballassoc.soccertournament.domain.official;

import jakarta.persistence.Entity;

import java.io.Serializable;

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
        private int techExperience;
    }

}

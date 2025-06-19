package za.co.footballassoc.soccertournament.domain.official;

import jakarta.persistence.Entity;

import java.io.Serializable;

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
        private String role;
    }
}

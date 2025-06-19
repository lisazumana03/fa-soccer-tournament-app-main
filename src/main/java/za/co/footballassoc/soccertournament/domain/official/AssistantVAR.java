package za.co.footballassoc.soccertournament.domain.official;

import jakarta.persistence.Entity;

import java.io.Serializable;
@Entity
public class AssistantVAR extends Official implements Serializable {
    private String supportRole;

    public AssistantVAR() {}

    private AssistantVAR(Builder builder) {
        this.supportRole = builder.supportRole;
    }

    public String getSupportRole() {
        return supportRole;
    }

    @Override
    public String toString() {
        return "AssistantVAR{" +
                "supportRole='" + supportRole + '\'' +
                ", officialName=" + officialName +
                ", officialNationality='" + officialNationality + '\'' +
                ", officialDateOfBirth=" + officialDateOfBirth +
                ", officialLocationOfBirth=" + officialLocationOfBirth +
                ", officialOrganisation='" + officialOrganisation + '\'' +
                ", match=" + match +
                '}';
    }

    public static class Builder{
        private String supportRole;
    }

}

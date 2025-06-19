package za.co.footballassoc.soccertournament.domain.official;

import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class Referee extends Official implements Serializable {
    private String certificationLevel;

    public Referee() {}

    private Referee(Builder builder) {
        this.certificationLevel = builder.certificationLevel;
    }

    @Override
    public String toString() {
        return "Referee{" +
                "certificationLevel='" + certificationLevel + '\'' +
                ", officialName=" + officialName +
                ", officialNationality='" + officialNationality + '\'' +
                ", officialDateOfBirth=" + officialDateOfBirth +
                ", officialLocationOfBirth=" + officialLocationOfBirth +
                ", officialOrganisation='" + officialOrganisation + '\'' +
                ", match=" + match +
                '}';
    }

    public static class Builder{
        private String certificationLevel;

        public Builder setCertificationLevel(String certificationLevel) {
            this.certificationLevel = certificationLevel;
            return this;
        }

        protected Builder self(){
            return this;
        }
        public Referee build(){
            return new Referee(this);
        }

    }

}

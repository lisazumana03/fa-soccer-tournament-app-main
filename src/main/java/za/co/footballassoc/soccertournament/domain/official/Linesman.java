package za.co.footballassoc.soccertournament.domain.official;

import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class Linesman extends Official implements Serializable {
    private String side;

    public Linesman() {}

    private Linesman(Builder builder) {
        this.side = builder.side;
    }

    public String getSide() {
        return side;
    }

    @Override
    public String toString() {
        return "Linesman{" +
                "side='" + side + '\'' +
                ", officialName=" + officialName +
                ", officialNationality='" + officialNationality + '\'' +
                ", officialDateOfBirth=" + officialDateOfBirth +
                ", officialLocationOfBirth=" + officialLocationOfBirth +
                ", match=" + match +
                ", officialOrganisation='" + officialOrganisation + '\'' +
                '}';
    }

    public static class Builder{
        private String side;

        public Builder setSide(String side){
            this.side = side;
            return this;
        }

    }
}

package za.co.footballassoc.soccertournament.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class OwnerCompany {
    private double companyNetWorth;
    private String companyName;
    @Embedded
    private Location companyLocation;
    private int formationYear;

    public OwnerCompany() {}

    public OwnerCompany(Builder builder) {
        this.companyNetWorth = builder.companyNetWorth;
        this.companyName = builder.companyName;
        this.companyLocation = builder.companyLocation;
        this.formationYear = builder.formationYear;
    }

    public static class Builder{
        private double companyNetWorth;
        private String companyName;
        private Location companyLocation;
        private int formationYear;

        public Builder companyNetWorth(double companyNetWorth) {
            this.companyNetWorth = companyNetWorth;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder companyLocation(Location companyLocation) {
            this.companyLocation = companyLocation;
            return this;
        }

        public Builder formationYear(int formationYear) {
            this.formationYear = formationYear;
            return this;
        }

        public OwnerCompany build() {
            return new OwnerCompany(this);
        }
    }
}

package za.co.footballassoc.soccertournament.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class OwnerCompany {
    private double companyNetWorth;
    private String companyName;
    @Embedded
    private Location companyLocation;
}

package za.co.footballassoc.soccertournament.domain;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Location implements ValueObject {
    private String suburb;
    private String cityOrTown;
    private String stateOrProvince;
    private String country;
    private String continent;
    private String zipCodeOrPostalCode;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(suburb, location.suburb) && Objects.equals(cityOrTown, location.cityOrTown) && Objects.equals(stateOrProvince, location.stateOrProvince) && Objects.equals(country, location.country) && Objects.equals(continent, location.continent) && Objects.equals(zipCodeOrPostalCode, location.zipCodeOrPostalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suburb, cityOrTown, stateOrProvince, country, continent, zipCodeOrPostalCode);
    }
}

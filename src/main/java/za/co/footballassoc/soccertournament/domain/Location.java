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
    private double latitude;
    private double longitude;

    public Location(){}

    private Location(Builder builder) {
        this.suburb = builder.suburb;
        this.cityOrTown = builder.cityOrTown;
        this.stateOrProvince = builder.stateOrProvince;
        this.country = builder.country;
        this.continent = builder.continent;
        this.zipCodeOrPostalCode = builder.zipCodeOrPostalCode;
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getCityOrTown() {
        return cityOrTown;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public String getCountry() {
        return country;
    }

    public String getContinent() {
        return continent;
    }

    public String getZipCodeOrPostalCode() {
        return zipCodeOrPostalCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(suburb, location.suburb) && Objects.equals(cityOrTown, location.cityOrTown) && Objects.equals(stateOrProvince, location.stateOrProvince) && Objects.equals(country, location.country) && Objects.equals(continent, location.continent) && Objects.equals(zipCodeOrPostalCode, location.zipCodeOrPostalCode) && Objects.equals(latitude, location.latitude) && Objects.equals(longitude, location.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suburb, cityOrTown, stateOrProvince, country, continent, zipCodeOrPostalCode, latitude, longitude);
    }

    public static class Builder {
        private String suburb;
        private String cityOrTown;
        private String stateOrProvince;
        private String country;
        private String continent;
        private String zipCodeOrPostalCode;
        private double latitude;
        private double longitude;

        public Builder setSuburb(String suburb) {
            this.suburb = suburb;
            return this;
        }
        public Builder setCityOrTown(String cityOrTown) {
            this.cityOrTown = cityOrTown;
            return this;
        }
        public Builder setStateOrProvince(String stateOrProvince) {
            this.stateOrProvince = stateOrProvince;
            return this;
        }
        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }
        public Builder setContinent(String continent) {
            this.continent = continent;
            return this;
        }
        public Builder setZipCodeOrPostalCode(String zipCodeOrPostalCode) {
            this.zipCodeOrPostalCode = zipCodeOrPostalCode;
            return this;
        }
        public Builder setLatitude(double latitude) {
            this.latitude = latitude;
            return this;
        }
        public Builder setLongitude(double longitude) {
            this.longitude = longitude;
            return this;
        }
        public Location build() {
            return new Location(this);
        }
    }
}

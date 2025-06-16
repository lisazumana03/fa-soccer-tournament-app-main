package za.co.footballassoc.soccertournament.domain;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Name implements ValueObject{
    private String firstName;
    private String middleName;
    private String lastName;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(firstName, name.firstName) && Objects.equals(lastName, name.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName);
    }
}

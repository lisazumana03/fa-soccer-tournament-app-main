package za.co.footballassoc.soccertournament.factory.tournament;

import org.junit.jupiter.api.Test;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.tournament.Association;

import static org.junit.jupiter.api.Assertions.*;

class AssociationFactoryTest {

    @Test
    void createAssociation() {
        String associationCode = "FA";
        String associationName = "Football Association";
        Name associationCEO = new Name.Builder()
                .setFirstName("John")
                .setLastName("Doe")
                .build();
        Location associationHeadquarters = new Location.Builder()
                .setCityOrTown("London")
                .setCountry("England")
                .setContinent("Europe")
                .setStateOrProvince( "Greater London")
                .setZipCodeOrPostalCode( "E1 7EZ")
                .build();

        Association association = AssociationFactory.createAssociation(associationCode, associationName, associationCEO, associationHeadquarters, null, null);
        assertNotNull(association);
        System.out.println(association);
    }
}
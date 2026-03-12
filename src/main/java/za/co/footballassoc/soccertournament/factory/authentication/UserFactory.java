package za.co.footballassoc.soccertournament.factory.authentication;

import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.authentication.User;

public class UserFactory {
    public static User createUser(Name name, String username, String password) {
        return new User.Builder()
                .setName(name)
                .setUserName(username)
                .setPassword(password)
                .build();
    }
}

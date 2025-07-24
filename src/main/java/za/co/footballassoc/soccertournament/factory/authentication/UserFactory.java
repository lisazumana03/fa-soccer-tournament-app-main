package za.co.footballassoc.soccertournament.factory.authentication;

import za.co.footballassoc.soccertournament.domain.authentication.User;

public class UserFactory {
    public static User createUser(String username, String password) {
        return new User.Builder()
                .setUserName(username)
                .setPassword(password)
                .build();
    }
}

package za.co.footballassoc.soccertournament.service.authentication;

import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.authentication.Role;
import za.co.footballassoc.soccertournament.domain.authentication.User;

public interface IUserService {
    User registerUser(Name name, String username, String email, String password, String phoneNumber, Role role);
    String authenticateUser(String username, String password);
}

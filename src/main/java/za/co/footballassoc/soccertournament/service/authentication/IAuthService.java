package za.co.footballassoc.soccertournament.service.authentication;

import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.authentication.Role;
import za.co.footballassoc.soccertournament.domain.authentication.User;

public interface IAuthService {
    User registerUser(Name name, String username, String email, String password, Role role);
    boolean authenticateUser(String username, String password);
}

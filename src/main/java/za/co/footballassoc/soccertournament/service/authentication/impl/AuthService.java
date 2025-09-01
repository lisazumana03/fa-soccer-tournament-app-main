package za.co.footballassoc.soccertournament.service.authentication.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.authentication.Role;
import za.co.footballassoc.soccertournament.domain.authentication.User;
import za.co.footballassoc.soccertournament.repository.authentication.UserRepository;
import za.co.footballassoc.soccertournament.service.authentication.IAuthService;

@Service
public class AuthService implements IAuthService {

    private UserRepository userRepository;



    @Override
    public User registerUser(Name name, String username, String email,
                             String password, String phoneNumber, Role role) {
        if(userRepository.findByUserName(username).isPresent()) {
            throw new RuntimeException("Username is already in use");
        }

        User user = new User.Builder()
                .setName(name)
                .setUserName(username)
                .setEmail(email)
                .setPassword(password)
                .setPhoneNumber(phoneNumber)
                .setRole(role)
                .build();

        return userRepository.save(user);
    }

    @Override
    public String authenticateUser(String username, String password) {
        return "";
    }

    public User loadUser(String username) {
        return userRepository.findByUserName(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}

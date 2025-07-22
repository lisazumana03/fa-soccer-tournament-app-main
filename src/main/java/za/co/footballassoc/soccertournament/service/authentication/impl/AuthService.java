package za.co.footballassoc.soccertournament.service.authentication.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.Role;
import za.co.footballassoc.soccertournament.domain.User;
import za.co.footballassoc.soccertournament.repository.authentication.UserRepository;
import za.co.footballassoc.soccertournament.service.authentication.IAuthService;

@Service
public class AuthService implements IAuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(Name name, String username, String email, String password, Role role) {
        if(userRepository.findByUserName(username).isPresent()) {
            throw new RuntimeException("Username is already in use");
        }
        User user = new User.Builder()
                .setName(name)
                .setUserName(username)
                .setEmail(email)
                .setPassword(password)
                .build();
        return userRepository.save(user);
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return passwordEncoder.matches(password, user.getPassword());
    }
}

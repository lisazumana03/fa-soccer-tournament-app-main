package za.co.footballassoc.soccertournament.controller.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.authentication.Role;
import za.co.footballassoc.soccertournament.domain.authentication.User;
import za.co.footballassoc.soccertournament.security.JwtUtils;
import za.co.footballassoc.soccertournament.service.authentication.impl.AuthService;

import java.util.HashMap;
import java.util.Map;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private AuthService authService;
    private JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Map<String, String> body) {
        Name name = new Name.Builder()
                .setFirstName(body.get("firstName"))
                .setMiddleName(body.get("middleName"))
                .setLastName(body.get("lastName"))
                .build();

        Role role = Role.valueOf(body.get("role").toUpperCase());

        User user = authService.registerUser(
                name,
                body.get("userName"),
                body.get("email"),
                body.get("password"),
                body.get("phoneNumber"),
                role);
        return ResponseEntity.ok("Registered user: " + user.getUserName());
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> body) {
        try {
            String token = authService.authenticateUser(body.get("userName"), body.get("password"));
            return ResponseEntity.ok(Map.of("token", token));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", e.getMessage()));
        }
    }
}

package za.co.footballassoc.soccertournament.controller.authentication;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.authentication.Role;
import za.co.footballassoc.soccertournament.domain.authentication.User;
import za.co.footballassoc.soccertournament.service.authentication.impl.UserService;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Map<String, String> body) {
        Name name = new Name.Builder()
                .setFirstName(body.get("firstName"))
                .setMiddleName(body.get("middleName"))
                .setLastName(body.get("lastName"))
                .build();

        Role role = Role.valueOf(body.get("role").toUpperCase());

        User user = userService.registerUser(
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
        String username = body.get("userName");
        String password = body.get("password");
        String result = userService.authenticateUser(username, password);
        if (result != null && !result.isEmpty()) {
            return ResponseEntity.ok("Login successful for user: " + username);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}

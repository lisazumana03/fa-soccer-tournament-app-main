package za.co.footballassoc.soccertournament.service.authentication.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
}

package za.co.footballassoc.soccertournament.service.impl.official;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.repository.official.RefereeRepository;

@Service
public class RefereeService {
    @Autowired
    private RefereeRepository refereeRepository;
}

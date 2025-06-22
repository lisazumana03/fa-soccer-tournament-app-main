package za.co.footballassoc.soccertournament.service.impl.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.repository.tournament.KnockoutRepository;

@Service
public class KnockoutService {
    @Autowired
    private KnockoutRepository knockoutRepository;

}

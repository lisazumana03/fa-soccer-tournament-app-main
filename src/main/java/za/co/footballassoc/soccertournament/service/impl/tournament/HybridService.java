package za.co.footballassoc.soccertournament.service.impl.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.repository.tournament.HybridRepository;
import za.co.footballassoc.soccertournament.service.tournament.IHybridService;

@Service
public class HybridService {
    @Autowired
    private HybridRepository hybridRepository;
}

package za.co.footballassoc.soccertournament.service.impl.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.tournament.Knockout;
import za.co.footballassoc.soccertournament.repository.tournament.KnockoutRepository;
import za.co.footballassoc.soccertournament.service.tournament.IKnockoutService;

import java.util.List;
import java.util.Optional;

@Service
public class KnockoutService implements IKnockoutService {
    @Autowired
    private KnockoutRepository knockoutRepository;

    @Override
    public Knockout create(Knockout knockout) {
        return knockoutRepository.save(knockout);
    }

    @Override
    public List<Knockout> getAllKnockouts() {
        return knockoutRepository.findAll();
    }

    @Override
    public List<Knockout> getKnockoutsByAssociation(String associationCode) {
        return knockoutRepository.findByAssociation_AssociationCode(associationCode);
    }

    @Override
    public Optional<Knockout> getKnockoutById(String id) {
        return knockoutRepository.findById(id);
    }


}

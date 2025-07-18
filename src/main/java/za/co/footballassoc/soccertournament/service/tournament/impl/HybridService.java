package za.co.footballassoc.soccertournament.service.tournament.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.tournament.Hybrid;
import za.co.footballassoc.soccertournament.repository.tournament.HybridRepository;
import za.co.footballassoc.soccertournament.service.tournament.IHybridService;

import java.util.List;
import java.util.Optional;

@Service
public class HybridService implements IHybridService {
    @Autowired
    private HybridRepository hybridRepository;

    @Override
    public Hybrid create(Hybrid hybrid) {
        return hybridRepository.save(hybrid);
    }

    @Override
    public List<Hybrid> getAllHybrid() {
        return hybridRepository.findAll();
    }

    @Override
    public void delete(Hybrid hybrid){
        hybridRepository.delete(hybrid);
    }

    @Override
    public Optional<Hybrid> getHybridById(String id) {
        return hybridRepository.findById(id);
    }

    @Override
    public List<Hybrid> getHybridByAssociationCode(String associationCode) {
        return hybridRepository.findByAssociation_AssociationCode(associationCode);
    }
}

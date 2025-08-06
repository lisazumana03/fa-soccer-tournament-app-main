package za.co.footballassoc.soccertournament.service.official.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.official.VAR;
import za.co.footballassoc.soccertournament.repository.official.VARRepository;
import za.co.footballassoc.soccertournament.service.official.IVARService;

import java.util.List;
import java.util.Optional;

@Service
public class VARService implements IVARService {
    @Autowired
    private VARRepository varRepository;

    @Override
    public List<VAR> getVARsByMatch(String matchId) {
        return List.of();
    }

    @Override
    public Optional<VAR> getVARById(String officialId) {
        return Optional.empty();
    }

    @Override
    public void fireVAR(String officialId) {

    }

    @Override
    public VAR create(VAR var) {
        return null;
    }

    @Override
    public VAR read(String s) {
        return null;
    }

    @Override
    public List<VAR> getAll() {
        return List.of();
    }

    @Override
    public VAR update(String s, VAR var) {
        return null;
    }
}

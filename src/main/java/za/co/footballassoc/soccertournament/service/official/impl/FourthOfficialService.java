package za.co.footballassoc.soccertournament.service.official.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.official.FourthOfficial;
import za.co.footballassoc.soccertournament.repository.official.FourthOfficialRepository;
import za.co.footballassoc.soccertournament.service.official.IFourthOfficialService;

import java.util.List;
import java.util.Optional;

@Service
public class FourthOfficialService implements IFourthOfficialService {
    @Autowired
    private FourthOfficialRepository fourthOfficialRepository;

    @Override
    public FourthOfficial create(FourthOfficial fourthOfficial) {
        return fourthOfficialRepository.save(fourthOfficial);
    }

    @Override
    public List<FourthOfficial> getAllFourthOfficials() {
        return fourthOfficialRepository.findAll();
    }

    @Override
    public List<FourthOfficial> getFourthOfficialsByMatch(String matchId) {
        return List.of();
    }

    @Override
    public Optional<FourthOfficial> getFourthOfficialById(String officialId) {
        return Optional.empty();
    }
}

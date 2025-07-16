package za.co.footballassoc.soccertournament.service.impl.official;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.official.Linesman;
import za.co.footballassoc.soccertournament.repository.official.LinesmanRepository;
import za.co.footballassoc.soccertournament.service.official.ILinesmanService;

import java.util.List;
import java.util.Optional;

@Service
public class LinesmanService implements ILinesmanService {
    @Autowired
    private LinesmanRepository linesmanRepository;


    @Override
    public Linesman create(Linesman linesman) {
        return null;
    }

    @Override
    public List<Linesman> getAllLinesmen() {
        return List.of();
    }

    @Override
    public List<Linesman> getLinesmenByMatch(String matchId) {
        return List.of();
    }

    @Override
    public Optional<Linesman> getLinesmenById(String officialId) {
        return Optional.empty();
    }

    @Override
    public void fireLinesman(Linesman linesman) {

    }
}

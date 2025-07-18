package za.co.footballassoc.soccertournament.service.official.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.dto.MatchOfficialsDTO;
import za.co.footballassoc.soccertournament.repository.official.*;
import za.co.footballassoc.soccertournament.service.official.IMatchOfficialsService;

@Service
public class MatchOfficialsService implements IMatchOfficialsService {

    @Autowired
    private AssistantVARRepository assistantVARRepository;
    @Autowired
    private RefereeRepository refereeRepository;
    @Autowired
    private LinesmanRepository linesmanRepository;
    @Autowired
    private VARRepository varRepository;
    @Autowired
    private FourthOfficialRepository fourthOfficialRepository;

    @Override
    public MatchOfficialsDTO getAllOfficialsByMatch(String matchId) {
        MatchOfficialsDTO dto = new MatchOfficialsDTO();
        dto.setReferees(refereeRepository.findByMatch_MatchID(matchId));
        dto.setVars(varRepository.findByMatch_MatchID(matchId));
        dto.setAssistantVars(assistantVARRepository.findByMatch_MatchID(matchId));
        dto.setLinesmen(linesmanRepository.findByMatch_MatchID(matchId));
        dto.setFourthOfficials(fourthOfficialRepository.findByMatch_MatchID(matchId));
        return dto;
    }
}

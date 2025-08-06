package za.co.footballassoc.soccertournament.service.official.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.official.AssistantVAR;
import za.co.footballassoc.soccertournament.repository.official.AssistantVARRepository;
import za.co.footballassoc.soccertournament.service.official.IAssistantVARService;

import java.util.List;
import java.util.Optional;

@Service
public class AssistantVARService implements IAssistantVARService {
    @Autowired
    private AssistantVARRepository assistantVARRepository;


    @Override
    public AssistantVAR create(AssistantVAR assistantVAR) {
        return assistantVARRepository.save(assistantVAR);
    }

    @Override
    public List<AssistantVAR> getAll() {
        return assistantVARRepository.findAll();
    }

    @Override
    public AssistantVAR read(String officialId) {
        return null;
    }

    @Override
    public void fireAssistantVARs(String officialId){
        assistantVARRepository.deleteById(officialId);
    }

    @Override
    public List<AssistantVAR> getRefereesByMatch(String matchId) {
        return assistantVARRepository.findByMatch_MatchID(matchId);
    }

    @Override
    public AssistantVAR update(String officialId, AssistantVAR updatedAssistantVAR){
        AssistantVAR assistantVAR = assistantVARRepository.findById(officialId)
                .orElseThrow(()->new RuntimeException("Assistant VAR not found"));
        AssistantVAR updated = new AssistantVAR.Builder()
                .copy(assistantVAR)
                .setOfficialName(updatedAssistantVAR.getOfficialName())
                .setOfficialGender(updatedAssistantVAR.getOfficialGender())
                .setOfficialNationality(updatedAssistantVAR.getOfficialNationality())
                .setOfficialDateOfBirth(updatedAssistantVAR.getOfficialDateOfBirth())
                .setOfficialLocationOfBirth(updatedAssistantVAR.getOfficialLocationOfBirth())
                .setOfficialOrganisation(updatedAssistantVAR.getOfficialOrganisation())
                .setSupportRole(updatedAssistantVAR.getSupportRole())
                .build();
        return assistantVARRepository.save(updatedAssistantVAR);
    }

    @Override
    public Optional<AssistantVAR> getAssistantVARById(String officialId) {
        return assistantVARRepository.findById(officialId);
    }
}

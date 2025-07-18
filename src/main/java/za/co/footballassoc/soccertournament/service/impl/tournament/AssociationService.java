package za.co.footballassoc.soccertournament.service.impl.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.tournament.*;
import za.co.footballassoc.soccertournament.repository.tournament.AssociationRepository;
import za.co.footballassoc.soccertournament.repository.tournament.HybridRepository;
import za.co.footballassoc.soccertournament.repository.tournament.KnockoutRepository;
import za.co.footballassoc.soccertournament.repository.tournament.LeagueRepository;
import za.co.footballassoc.soccertournament.service.tournament.IAssociationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AssociationService implements IAssociationService {

    @Autowired
    private AssociationRepository associationRepository;
    @Autowired
    private LeagueRepository leagueRepository;
    @Autowired
    private KnockoutRepository knockoutRepository;
    @Autowired
    private HybridRepository hybridRepository;

    @Override
    public Association establishAssociation(Association association) {
        return associationRepository.save(association);
    }

    @Override
    public List<Association> getAssociations(){
        return associationRepository.findAll();
    }

    @Override
    public Association updateAssociation(Association association) {
        return null;
    }

    @Override
    public Association deformAssociation() {
        return null;
    }

    @Override
    public List<League> getLeaguesByRegion(Region region) {
        return leagueRepository.findAll().stream()
                .filter(l -> l.getAssociation().getRegion() == region)
                .toList();
    }

    @Override
    public List<Knockout> getKnockoutsByRegion(Region region) {
        return knockoutRepository.findAll().stream()
                .filter(k -> k.getAssociation().getRegion() == region)
                .toList();
    }

    @Override
    public List<Hybrid> getHybridsByRegion(Region region){
        return hybridRepository.findAll().stream()
                .filter(h -> h.getAssociation().getRegion() == region)
                .toList();
    }

    @Override
    public Map<TournamentType, List<Tournament>> groupTournamentsByType(String associationCode) {
        List<League> leagues = leagueRepository.findByAssociation_AssociationCode(associationCode);
        List<Knockout> knockouts = knockoutRepository.findByAssociation_AssociationCode(associationCode);
        List<Hybrid> hybrids = hybridRepository.findByAssociation_AssociationCode(associationCode);

        Map<TournamentType, List<Tournament>> grouped = new HashMap<>();
        grouped.put(TournamentType.LEAGUE, new ArrayList<>(leagues));
        grouped.put(TournamentType.KNOCKOUT, new ArrayList<>(knockouts));
        grouped.put(TournamentType.HYBRID, new ArrayList<>(hybrids));

        return grouped;
    }
}

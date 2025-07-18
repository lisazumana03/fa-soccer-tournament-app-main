package za.co.footballassoc.soccertournament.service.tournament;

import za.co.footballassoc.soccertournament.domain.tournament.*;

import java.util.List;
import java.util.Map;

public interface IAssociationService {
    Association establishAssociation(Association association);
    List<Association> getAssociations();
    Association updateAssociation(Association association);
    Association deformAssociation();

    // Custom methods
    List<League> getLeaguesByRegion(Region region);
    List<Knockout> getKnockoutsByRegion(Region region);
    List<Hybrid> getHybridsByRegion(Region region);
    Map<TournamentType, List<Tournament>> groupTournamentsByType(String associationCode);
}

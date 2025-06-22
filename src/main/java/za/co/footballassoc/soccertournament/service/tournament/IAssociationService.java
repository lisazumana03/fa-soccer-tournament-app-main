package za.co.footballassoc.soccertournament.service.tournament;

import za.co.footballassoc.soccertournament.domain.tournament.Association;

public interface IAssociationService {
    Association establishAssociation(Association association);
    Association getAssociation();
    Association updateAssociation(Association association);
    Association deformAssociation();
}

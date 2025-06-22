package za.co.footballassoc.soccertournament.service.impl.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.tournament.Association;
import za.co.footballassoc.soccertournament.repository.tournament.AssociationRepository;
import za.co.footballassoc.soccertournament.service.tournament.IAssociationService;

@Service
public class AssociationService implements IAssociationService {

    @Autowired
    private AssociationRepository associationRepository;

    @Override
    public Association establishAssociation(Association association) {
        return associationRepository.save(association);
    }

    @Override
    public Association getAssociation() {
        return null;
    }

    @Override
    public Association updateAssociation(Association association) {
        return null;
    }

    @Override
    public Association deformAssociation() {
        return null;
    }
}

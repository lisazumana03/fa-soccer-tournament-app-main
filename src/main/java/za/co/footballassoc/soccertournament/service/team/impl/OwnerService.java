package za.co.footballassoc.soccertournament.service.team.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.team.Owner;
import za.co.footballassoc.soccertournament.repository.team.OwnerRepository;
import za.co.footballassoc.soccertournament.service.team.IOwnerService;

@Service
public class OwnerService implements IOwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Owner create(Owner owner) {
        return ownerRepository.save(owner);
    }
}

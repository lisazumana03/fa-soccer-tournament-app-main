package za.co.footballassoc.soccertournament.service.team.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.team.Manager;
import za.co.footballassoc.soccertournament.repository.team.ManagerRepository;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    public Manager create(Manager manager) {
        return managerRepository.save(manager);
    }
}

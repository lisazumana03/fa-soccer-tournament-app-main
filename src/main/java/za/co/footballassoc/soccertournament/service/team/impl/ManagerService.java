package za.co.footballassoc.soccertournament.service.team.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.team.Manager;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.repository.team.ManagerRepository;
import za.co.footballassoc.soccertournament.service.team.IManagerService;

import java.util.List;

@Service
public class ManagerService implements IManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public Manager create(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Manager read(String managerId) {
        return managerRepository.findById(managerId).orElse(null);
    }

    @Override
    public List<Manager> getAll() {
        return managerRepository.findAll();
    }

    @Override
    public Manager update(String managerId, Manager updateManager) {
        Manager manager = managerRepository.findById(updateManager.getManagerId())
                .orElseThrow(()->new RuntimeException("Manager not found"));
        return managerRepository.save(updateManager);
    }


    @Override
    public void delete(String managerId) {
        managerRepository.deleteById(managerId);
    }
}

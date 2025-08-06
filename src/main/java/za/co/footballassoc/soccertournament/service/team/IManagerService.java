package za.co.footballassoc.soccertournament.service.team;

import za.co.footballassoc.soccertournament.domain.team.Manager;
import za.co.footballassoc.soccertournament.service.IService;

public interface IManagerService extends IService<Manager, String> {
    void delete (String managerId);
}

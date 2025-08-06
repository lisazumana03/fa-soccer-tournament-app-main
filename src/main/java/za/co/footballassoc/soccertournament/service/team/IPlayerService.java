package za.co.footballassoc.soccertournament.service.team;

import za.co.footballassoc.soccertournament.domain.team.Player;
import za.co.footballassoc.soccertournament.service.IService;

import java.util.List;

public interface IPlayerService extends IService<Player, String> {
    List<Player> getAllPlayers();
    void delete(String playerID);
}

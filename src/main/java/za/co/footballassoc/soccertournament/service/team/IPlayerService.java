package za.co.footballassoc.soccertournament.service.team;

import za.co.footballassoc.soccertournament.domain.team.Player;
import za.co.footballassoc.soccertournament.service.IService;

import java.util.List;

public interface IPlayerService extends IService<Player, String> {
    Player create(Player player);
    List<Player> getAllPlayers();
    Player update(Player updatedPlayer);
    void delete(String playerID);
}

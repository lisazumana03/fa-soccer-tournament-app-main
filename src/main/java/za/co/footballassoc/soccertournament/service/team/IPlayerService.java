package za.co.footballassoc.soccertournament.service.team;

import za.co.footballassoc.soccertournament.domain.team.Player;

import java.util.List;

public interface IPlayerService {
    Player create(Player player);
    List<Player> getAllPlayers();
    Player update(String playerID, Player updatedPlayer);
    void delete(String playerID);
}

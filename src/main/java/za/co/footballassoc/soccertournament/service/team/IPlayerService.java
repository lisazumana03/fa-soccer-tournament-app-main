package za.co.footballassoc.soccertournament.service.team;

import za.co.footballassoc.soccertournament.domain.team.Player;

public interface IPlayerService {
    Player create(Player player);
    Player read(String playerID);
    Player update(Player player);
    void delete(String playerID);
}

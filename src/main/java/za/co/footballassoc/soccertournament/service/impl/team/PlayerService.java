package za.co.footballassoc.soccertournament.service.impl.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.team.Player;
import za.co.footballassoc.soccertournament.repository.team.PlayerRepository;
import za.co.footballassoc.soccertournament.service.team.IPlayerService;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player create(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player read(String playerID) {
        return null;
    }

    @Override
    public Player update(Player player) {
        return null;
    }

    @Override
    public void delete(String playerID) {

    }
}

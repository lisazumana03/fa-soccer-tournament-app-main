package za.co.footballassoc.soccertournament.service.team.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.team.Player;
import za.co.footballassoc.soccertournament.repository.team.PlayerRepository;
import za.co.footballassoc.soccertournament.service.team.IPlayerService;

import java.util.List;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player create(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player read(String playerID) {
        return playerRepository.getReferenceById(playerID);
    }

    @Override
    public Player update(String playerID, Player updatedPlayer) {
        Player player = playerRepository.findById(playerID)
                .orElseThrow(()->new RuntimeException("Team not found"));
        Player updated = new Player.Builder()
                .copy(player)
                .setPlayerName(updatedPlayer.getPlayerName())
                .setPlayerGender(updatedPlayer.getPlayerGender())
                .setPlayerNationality(updatedPlayer.getPlayerNationality())
                .setPlayerDateOfBirth(updatedPlayer.getPlayerDateOfBirth())
                .setPlayerLocationOfBirth(updatedPlayer.getPlayerLocationOfBirth())
                .setPlayerPosition(updatedPlayer.getPlayerPosition())
                .setPlayerHeight(updatedPlayer.getPlayerHeight())
                .setPlayerWeight(updatedPlayer.getPlayerWeight())
                .setClub(updatedPlayer.getClub())
                .setKitNumber(updatedPlayer.getKitNumber())
                .setNationalTeam(updatedPlayer.getNationalTeam())
                .build();
        return playerRepository.save(updatedPlayer);
    }

    @Override
    public void delete(String playerID) {
        if (!playerRepository.existsById(playerID)) {
            throw new EntityNotFoundException("Player not found with ID: " + playerID);
        }
        playerRepository.deleteById(playerID);
    }
}

package za.co.footballassoc.soccertournament.service.team.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.team.Gender;
import za.co.footballassoc.soccertournament.domain.team.Player;
import za.co.footballassoc.soccertournament.domain.team.PlayerPosition;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.factory.team.PlayerFactory;
import za.co.footballassoc.soccertournament.repository.team.PlayerRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PlayerServiceTest {

    @InjectMocks
    private PlayerService playerService;

    @Mock
    private PlayerRepository playerRepository;

    private Player malePlayer;
    private Player femalePlayer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        malePlayer = PlayerFactory.createMalePlayer("070312 0567 084", new Name(), Gender.MALE, "South Africa", LocalDate.of(2007, 3, 12), new Location(), PlayerPosition.RW, 170.5, 56.67, new Team(), 11, new Team());
        femalePlayer = PlayerFactory.createFemalePlayer("020703 0457 084", new Name(), Gender.FEMALE, "South Africa", LocalDate.of(2004, 1, 14), new Location(), PlayerPosition.RW, 170.5, 56.67, new Team(), 11, new Team());
    }

    @Test
    void create() {
        when(playerRepository.save(malePlayer)).thenReturn(malePlayer);
        when(playerRepository.save(femalePlayer)).thenReturn(femalePlayer);
        assertEquals(malePlayer, playerService.create(malePlayer));
        assertEquals(femalePlayer, playerService.create(femalePlayer));
    }

    @Test
    void getAllPlayers() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {

    }
}
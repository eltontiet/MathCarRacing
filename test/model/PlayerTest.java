package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player testPlayer;

    @BeforeEach
    void setup() {
        testPlayer = new Player("Player 1");
    }

    @Test
    void testAddScore() {
        testPlayer.addScore(2);
        assertEquals(testPlayer.getScore(), 2);

        testPlayer.addScore(6);
        assertEquals(testPlayer.getScore(), 2 + 6);
    }

    @Test
    void testAddGame() {
    }

    @Test
    void testSetName() {
        testPlayer.setName("Player");
        assertEquals(testPlayer.getName(), "Player");
    }
}
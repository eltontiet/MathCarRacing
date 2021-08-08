package model;

import exceptions.InactiveCellException;
import exceptions.OutOfRangeException;
import exceptions.PlayerNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Board testBoard;
    Cell testCell1, testCell2, testCell3, testCell4;
    Game testGame;
    Player testPlayer1;
    Player testPlayer2;

    @BeforeEach
    void setup() {
        testBoard = new Board(2,2);

        try {
            testCell1 = new Cell(new Equation("1 + 1", 2));
            testBoard.setCell(testCell1, 0, 0);

            testCell2 = new Cell(new Equation("2 + 2", 4));
            testBoard.setCell(testCell2, 0, 1);

            testCell3 = new Cell(new Equation("3 + 3", 6));
            testBoard.setCell(testCell3, 1, 0);

            testCell4 = new Cell(new Equation("4 + 4", 8));
            testBoard.setCell(testCell4, 1, 1);

        } catch (OutOfRangeException e) {
            e.printStackTrace();
        }

        testPlayer1 = new Player("Player 1");
        testPlayer2 = new Player("Player 2");
        testGame = new Game(testBoard, testPlayer1, testPlayer2);
    }

    @Test
    void testAddMoveActiveCell() {
        try {
            testGame.addMove(1, 1);
            assertEquals(testPlayer1.getScore(), 8);
            assertFalse(testGame.getCurrentBoard().getCell(1,1).isActive());
            testGame.setTurn(testPlayer2);

            testGame.addMove(1, 0);
            assertEquals(testPlayer2.getScore(), 6);
            assertFalse(testGame.getCurrentBoard().getCell(1,0).isActive());

        } catch (Exception e) {
            fail("No exception should be thrown");
        }
    }

    @Test
    void testAddMoveInactiveCell() {
        try {
            testGame.addMove(1, 1);
            testGame.setTurn(testPlayer2);

        } catch (Exception e) {
            fail("No exception should be thrown");
        }

        try {
            testGame.addMove(1, 1);
            fail("Exception should have been thrown");
        } catch (InactiveCellException e) {
            // pass
        } catch (OutOfRangeException e) {
            fail("Wrong exception was full");
        }
    }

    @Test
    void testAddMoveOutOfRange() {
        try {
            testGame.addMove(1, 2);
            fail("Exception should have been thrown");
        } catch (InactiveCellException e) {
            fail("Wrong exception was full");
        } catch (OutOfRangeException e) {
            // pass
        }
    }

    @Test
    void testSetTurn() {
        testGame.setTurn(true);
        assertTrue(testGame.getTurn());

        testGame.setTurn(false);
        assertFalse(testGame.getTurn());

        try {
            testGame.setTurn(testPlayer1);
            assertFalse(testGame.getTurn());

            testGame.setTurn(testPlayer2);
            assertTrue(testGame.getTurn());

        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    void testSetTurnWrongPlayer() {
        Player newPlayer = new Player("New Player");
        try {
            testGame.setTurn(newPlayer);
            fail("Exception should be thrown");
        } catch (PlayerNotFoundException e) {
            // pass
        }
    }
}
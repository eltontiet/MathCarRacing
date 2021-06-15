package model;

import exceptions.OutOfRangeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board testBoard;
    Cell testCell1, testCell2, testCell3, testCell4;

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
    }

    @Test
    void setCell() {
        Cell testCell = new Cell(new Equation("5 + 5", 10));

        try {
            testBoard.setCell(testCell, 1, 1);
            assertEquals(testBoard.getCell(1,1), testCell);
        } catch (OutOfRangeException e) {
            fail("Should not throw exception");
        }

    }

    @Test
    void setCellOutOfRange() {
        Cell testCell = new Cell(new Equation("5 + 5", 10));

        try {
            testBoard.setCell(testCell, 1, 2);
            fail("Should throw exception");
        } catch (OutOfRangeException e) {
            // pass
        }
    }

    @Test
    void getCell() {
        try {
            assertEquals(testBoard.getCell(0,0), testCell1);
        } catch (OutOfRangeException e) {
            fail("should not throw exception");
        }
    }

    @Test
    void getCellOutOfRange() {
        try {
            testBoard.getCell(2,2);
            fail("Should've thrown exception");
        } catch (OutOfRangeException e) {
            // pass
        }
    }

    @Test
    void getCells() {
        Cell[][] cells = testBoard.getCells();
        assertEquals(cells[0][0],testCell1);
        assertEquals(cells[0][1],testCell2);
        assertEquals(cells[1][0],testCell3);
        assertEquals(cells[1][1],testCell4);
    }

    @Test
    void getRows() {
        assertEquals(2, testBoard.getRows());
    }

    @Test
    void getColumns() {
        assertEquals(2, testBoard.getColumns());
    }

    @Test
    void createCopy() {
    }
}
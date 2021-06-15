package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    Cell testCell;
    Equation testEquation;

    @BeforeEach
    void setup() {
        testEquation = new Equation("2 + 2", 4);
        testCell = new Cell(testEquation);
    }

    @Test
    void testEquals() {
        assertEquals(testEquation, new Equation("2 + 2", 4));
    }

    @Test
    void testGetEquation() {
        assertEquals(testEquation, testCell.getEquation());
    }

    @Test
    void testGetScore() {
        assertEquals(4, testCell.getScore());
    }

    @Test
    void testSetRow() {
        testCell.setRow(1);
        assertEquals(1, testCell.getRow());
    }

    @Test
    void testSetColumn() {
        testCell.setColumn(1);
        assertEquals(1, testCell.getColumn());
    }

    @Test
    void testSetEquation() {
        Equation equation = new Equation("1 + 1", 2);
        testCell.setEquation(equation);
        assertEquals(equation, testCell.getEquation());
        assertEquals(2, testCell.getScore());
    }
}

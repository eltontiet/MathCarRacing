package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EquationTest {
    Equation testEquation;

    @BeforeEach
    void setup() {
        testEquation = new Equation("2 * 2", 4);
    }

    @Test
    void testConstructor() {
        Equation e1 = new Equation("1 + 1", 2);
        assertEquals(e1.getEquation(), "1 + 1");
        assertEquals(e1.getAnswer(), 2);
    }

    @Test
    void testGetEquation() {
        assertEquals(testEquation.getEquation(), "2 * 2");
    }

    @Test
    void testGetAnswer() {
        assertEquals(testEquation.getAnswer(), 4);
    }
}

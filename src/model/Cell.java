package model;

// Represents a cell that contains an equation.
public class Cell {
    private Equation equation;
    private int score;
    private int row;
    private int column;

    // MODIFIES: this
    // EFFECTS: initializes a cell with an equation, row, and column
    public Cell(Equation equation) {
        this.equation = equation;
        score = equation.getAnswer();
    }

    // getters
    public Equation getEquation() {
        return equation;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getScore() {
        return score;
    }

    // setters
    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    // MODIFIES: this
    // EFFECTS: sets the equation, and changes the score of the cell.
    public void setEquation(Equation equation) {
        this.equation = equation;
        score = equation.getAnswer();
    }
}

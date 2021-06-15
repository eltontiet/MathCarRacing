package model;

import exceptions.OutOfRangeException;

// Represents a board with a collection of cells
public class Board {
    private Cell[][] cells;
    private int rows;
    private int columns;

    // MODIFIES: this
    // EFFECTS: sets cells to an empty 2D array that is rows x columns in size;
    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        cells = new Cell[rows][columns];
    }

    // MODIFIES: this, cell
    // EFFECTS: sets the cell at (row, column), and sets the row and column of the cell.
    //          if it is out of range, throws OutOfRangeException
    public void setCell(Cell cell, int row, int column) throws OutOfRangeException {
        if (row >= rows || column >= columns) {
            throw new OutOfRangeException();
        } else {
            cells[row][column] = cell;
            cell.setRow(row);
            cell.setColumn(column);
        }
    }

    // REQUIRES: if in range, cell exists at (row, column)
    // EFFECTS: returns the cell at (row,column), if it is out of range, throws OutOfRangeException
    public Cell getCell(int row, int column) throws OutOfRangeException {
        if (row >= rows || column >= columns) {
            throw new OutOfRangeException();
        } else {
            return cells[row][column];
        }
    }

    // getters
    public Cell[][] getCells() {
        return cells;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    // EFFECTS: returns a deep copy of the board
    public Board createCopy() {
        Board newBoard = new Board(rows, columns);
        try {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    Equation tempEquation = cells[i][j].getEquation();
                    newBoard.setCell(new Cell(new Equation(tempEquation.getEquation(), tempEquation.getAnswer())), i, j);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Something seems to have gone very wrong.");
        }

        return newBoard;
    }
}

package model;

import exceptions.InactiveCellException;
import exceptions.OutOfRangeException;
import exceptions.PlayerNotFoundException;

import java.util.LinkedHashMap;

// Represents a game with a list of moves, a starting board state, and the current board state
// moves represent all moves in the game, swapping between player1 and player2
public class Game {
    Player player1;
    Player player2;
    LinkedHashMap<Integer,Integer> moves;
    Board startingBoard;
    Board currentBoard;
    boolean turn; // false for player1, true for player2

    // MODIFIES: this
    // EFFECTS: creates a new game with the starting board, and player1 as the starting player
    public Game(Board board, Player player1, Player player2) {
        startingBoard = board.createCopy();
        this.currentBoard = board;
        moves = new LinkedHashMap<>();
        this.player1 = player1;
        this.player2 = player2;
        turn = false;
    }

    // MODIFIES: this
    // EFFECTS: creates a game with moves, a startingBoard, and the currentBoard
    public Game(LinkedHashMap<Integer,Integer> moves, Board startingBoard, Board currentBoard, Player p1, Player p2) {
        this.moves = moves;
        this.startingBoard = startingBoard;
        this.currentBoard = currentBoard;
        this.player1 = p1;
        this.player2 = p2;
    }

    // MODIFIES: this, currentBoard
    // EFFECTS: adds the move into moves, adds to the score,
    //          and deactivates the cell on currentBoard.
    //          throws OutOfRangeException if the row and column is out of range,
    //          throws InactiveCellException if the cell is inactive.
    public void addMove(int row, int column) throws OutOfRangeException, InactiveCellException {
        Cell cell = currentBoard.getCell(row, column);
        if (cell.isActive()) {
            moves.put(row, column);

            if (turn) {
                player2.addScore(cell.getScore());
            } else {
                player1.addScore(cell.getScore());
            }

            currentBoard.changeCellActive(row, column, false);
        } else {
            throw new InactiveCellException();
        }
    }

    // MODIFIES: this
    // EFFECTS: sets turn to turnBool
    public void setTurn(Boolean turnBool) {
        turn = turnBool;
    }

    // MODIFIES: this
    // EFFECTS: sets turn to the player, throws PlayerNotFoundException if player cannot be found
    public void setTurn(Player player) throws PlayerNotFoundException {
        if (player.equals(player1)) {
            turn = false;

        } else if (player.equals(player2)) {
            turn = true;

        } else {
            throw new PlayerNotFoundException();

        }
    }

    // getters

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public LinkedHashMap<Integer, Integer> getMoves() {
        return moves;
    }

    public Board getStartingBoard() {
        return startingBoard;
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }

    public boolean getTurn() {
        return turn;
    }
}

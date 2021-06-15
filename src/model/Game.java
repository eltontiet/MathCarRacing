package model;

import java.util.LinkedHashMap;

// Represents a game with a list of moves, a starting board state, and the current board state
// moves represent all moves in the game, swapping between player1 and player2
public class Game {
    Player player1;
    Player player2;
    LinkedHashMap<Integer,Integer> moves;
    Board startingBoard;
    Board currentBoard;

    // MODIFIES: this
    // EFFECTS: creates a new game with the starting board.
    public Game(Board board, Player player1, Player player2) {
        startingBoard = board.createCopy();
        this.currentBoard = board;
        moves = new LinkedHashMap<>();
        this.player1 = player1;
        this.player2 = player2;
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

    // MODIFIES: this
    // EFFECTS: adds the move into moves
    public void addMove(int row, int column) {

    }
}

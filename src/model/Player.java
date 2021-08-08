package model;

import java.util.ArrayList;
import java.util.List;

// Represents a player with a name, score, and game history
public class Player {
    private String name;
    private int score;
    List<Game> gameHistory;

    // MODIFIES: this
    // EFFECTS: creates a player with a name, and initializes score, and game history.
    public Player(String name) {
        this.name = name;
        score = 0;
        gameHistory = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: creates a player with a name and game history, and initializes score.
    public Player(String name, List<Game> gameHistory) {
        this.name = name;
        this.score = 0;
        this.gameHistory = gameHistory;
    }

    // MODIFIES: this
    // EFFECTS: adds score to player score
    public void addScore(int score) {
        this.score += score;
    }

    public void addGame(Game game) {
        gameHistory.add(game);
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    // getters
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public List<Game> getGameHistory() {
        return gameHistory;
    }
}

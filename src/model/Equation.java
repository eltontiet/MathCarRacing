package model;

// Represents an equation with an answer
public class Equation {
    private String equation;
    private int answer;

    // MODIFIES: this
    // EFFECTS: initializes an Equation with an equation and an answer
    public Equation(String equation, int answer) {
        this.equation = equation;
        this.answer = answer;
    }

    // getters
    public String getEquation() {
        return equation;
    }

    public int getAnswer() {
        return answer;
    }
}

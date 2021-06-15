package model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equation equation1 = (Equation) o;
        return answer == equation1.answer &&
                equation.equals(equation1.equation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equation, answer);
    }
}

package minesweeper;

public class Coordinate {
    boolean empty;
    char symbol;

    Coordinate() {
        this.empty = true;
        this.symbol = '.';
    }

    public void placeMine() {
        this.empty = false;
        this.symbol = 'X';
    }

    public boolean isEmpty() {
        return empty;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = !this.empty ? 'X' : symbol;
    }
}

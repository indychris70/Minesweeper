package minesweeper;

public class Coordinate {
    boolean empty;

    Coordinate() {
        this.empty = true;
    }

    public void placeMine() {
        this.empty = false;
    }

    public boolean isEmpty() {
        return empty;
    }
}

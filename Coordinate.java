package minesweeper;

public class Coordinate {
    boolean empty;
    char symbol;
    boolean flagged;

    Coordinate() {
        this.empty = true;
        this.symbol = '.';
        this.flagged = false;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public void toggleFlag() {
        setFlagged(!flagged);
        if (isFlagged()) {
            setSymbol('*');
        } else {
            setSymbol('.');
        }
    }

    public void placeMine() {
        setEmpty(false);
        setSymbol('.');
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}

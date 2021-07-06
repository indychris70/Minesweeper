package minesweeper;

public class Main {
    public static void main(String[] args) {
        int fieldRows = 9;
        int fieldColumns = 9;
        int numberOfMines = 10;
        MineField field = new MineField(fieldColumns, fieldRows, numberOfMines);
        field.print();
    }
}

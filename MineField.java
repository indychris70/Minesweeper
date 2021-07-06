package minesweeper;

import java.util.Random;

public class MineField {
    int numberOfColumns;
    int numberOfRows;
    int numberOfMines;
    Coordinate[][] field;

    MineField(int numberOfColumns, int numberOfRows, int numberOfMines) {
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;
        this.numberOfMines = numberOfMines;
        initializeField();
        layMines();
    }

    public void print() {
        for (int i = 0; i < numberOfColumns; i++) {
            for (int j = 0; j < numberOfRows; j++) {
                if (field[i][j].isEmpty()) {
                    System.out.print('.');
                } else {
                    System.out.print('X');
                }
            }
            System.out.println();
        }
    }

    private void initializeField() {
        this.field = new Coordinate[numberOfColumns][numberOfRows];
        for (int i = 0; i < numberOfColumns; i++) {
            for (int j = 0; j < numberOfRows; j++) {
                field[i][j] = new Coordinate();
            }
        }
    }

    private void layMines() {
        Random rand = new Random();
        int randomColumn;
        int randomRow;
        boolean placementFailed;
        for (int k = 0; k < numberOfMines; k++) {
            placementFailed = true;
            do {
                randomColumn = rand.nextInt(this.numberOfColumns);
                randomRow = rand.nextInt(this.numberOfRows);
                if (field[randomColumn][randomRow].isEmpty()) {
                    field[randomColumn][randomRow].placeMine();
                    placementFailed = false;
                }
            } while (placementFailed);
        }
    }
}

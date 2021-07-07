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
        setSymbols();
    }

    public void print() {
        StringBuilder columnHeader = new StringBuilder(" |");
        StringBuilder border = new StringBuilder("-|");
        for (int h = 0; h < numberOfColumns; h++) {
            columnHeader.append(h + 1);
            border.append("-");
        }
        columnHeader.append("|");
        border.append("|");
        System.out.println(columnHeader.toString());
        System.out.println(border.toString());

        for (int i = 0; i < numberOfColumns; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < numberOfRows; j++) {
                System.out.print(field[i][j].getSymbol());
            }
            System.out.println("|");
        }

        System.out.println(border.toString());
    }

    public boolean coordinateCanBeFlagged(int columnIndex, int rowIndex) {
        Coordinate coord = this.field[columnIndex][rowIndex];
        return coord.getSymbol() == '.' || coord.getSymbol() == '*';
    }

    public void flagCoordinate(int columnIndex, int rowIndex) {
        Coordinate coord = this.field[columnIndex][rowIndex];
        coord.toggleFlag();
    }

    public boolean gameOver() {
        for (int i = 0; i < this.numberOfColumns; i++) {
            for (int j = 0; j < this.numberOfRows; j++) {
                boolean emptyCellFlagged = field[i][j].isFlagged() && field[i][j].isEmpty();
                boolean mineNotFlagged = !field[i][j].isFlagged() && !field[i][j].isEmpty();
                if (emptyCellFlagged || mineNotFlagged) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean coordinateInField(int columnIndex, int rowIndex) {
        boolean validColumn = false;
        boolean validRow = false;
        if (columnIndex >= 0 && columnIndex < this.numberOfColumns) {
            validColumn = true;
        }
        if (rowIndex >= 0 && rowIndex < this.numberOfRows) {
            validRow = true;
        }
        return validColumn && validRow;
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

    private void setSymbols() {
        for (int i = 0; i < numberOfColumns; i++) {
            for (int j = 0; j < numberOfRows; j++) {
                if (field[i][j].isEmpty()) {
                    field[i][j].setSymbol(findAdjacentMines(i, j));
                }
            }
        }
    }

    private char findAdjacentMines(int columnIndex, int rowIndex) {
        int checkColumnIndex;
        int checkRowIndex;
        int numberOfAdjacentMines = 0;
        for (int i = -1; i < 2; i++) {
            checkColumnIndex = columnIndex + i;
            for (int j = -1; j < 2; j++) {
                checkRowIndex = rowIndex + j;
                if (!(checkColumnIndex == columnIndex && checkRowIndex == rowIndex) && coordinateInField(checkColumnIndex, checkRowIndex)) {
                    if (!field[checkColumnIndex][checkRowIndex].isEmpty()) {
                        numberOfAdjacentMines++;
                    }
                }
            }
        }
        return numberOfAdjacentMines == 0 ? '.' : (char) (numberOfAdjacentMines + '0');
    }
}

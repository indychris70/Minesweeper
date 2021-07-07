package minesweeper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldColumns = 9;
        int fieldRows = 9;
        final int maxNumberMines =  fieldColumns * fieldRows;
        int numberOfMines = Integer.MAX_VALUE;
        // Place mines
        do {
            System.out.println("How many mines do you want on the field?");
            numberOfMines = scanner.nextInt();
            if (!validNumberOfMines(numberOfMines, 0, maxNumberMines)) {
                System.out.println(String.format("Error: There can be a minimum of 1 and a maximum of %d mines on the field.", maxNumberMines));
            }
        } while (!validNumberOfMines(numberOfMines, 0, maxNumberMines));
        MineField field = new MineField(fieldColumns, fieldRows, numberOfMines);
        field.print();

        // game loop
        int columnNumber;
        int rowNumber;
        boolean canBeFlagged = false;
        boolean coordinateInField = false;

        do {
            do {
                System.out.println("Set/delete mines marks (x and y coordinates): ");
                columnNumber = scanner.nextInt();
                rowNumber = scanner.nextInt();
                coordinateInField = field.coordinateInField(rowNumber - 1, columnNumber - 1);
                canBeFlagged = field.coordinateCanBeFlagged(rowNumber - 1, columnNumber - 1);
                if (!coordinateInField) {
                    System.out.println("This coordinate does not exist on the minefield.");
                } else {
                    if (!canBeFlagged) {
                        System.out.println("There is a number here!");
                    }
                }
            } while (!canBeFlagged || !coordinateInField);
            field.flagCoordinate(rowNumber - 1, columnNumber - 1);
            field.print();
        } while (!field.gameOver());
        System.out.println("Congratulations! You found all the mines!");
    }

    private static boolean validNumberOfMines(int number, int min, int max) {
        return number >= min || number <= max;
    }
}

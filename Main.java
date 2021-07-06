package minesweeper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldColumns = 9;
        int fieldRows = 9;
        final int maxNumberMines =  fieldColumns * fieldRows;
        int numberOfMines = Integer.MAX_VALUE;
        do {
            System.out.println("How many mines do you want on the field?");
            numberOfMines = scanner.nextInt();
            if (!validNumberOfMines(numberOfMines, 0, maxNumberMines)) {
                System.out.println(String.format("Error: There can be a minimum of 1 and a maximum of %d mines on the field.", maxNumberMines));
            }
        } while (!validNumberOfMines(numberOfMines, 0, maxNumberMines));
        MineField field = new MineField(fieldColumns, fieldRows, numberOfMines);
        field.print();
    }

    private static boolean validNumberOfMines(int number, int min, int max) {
        return number >= min || number <= max;
    }
}

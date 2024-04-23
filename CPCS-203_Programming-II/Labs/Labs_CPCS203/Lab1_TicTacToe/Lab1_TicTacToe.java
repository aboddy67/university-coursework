/* 
Abdulrahman Thigah
*/
package Labs_CPCS203.Lab1_TicTacToe;

import java.util.Scanner;

public class Lab1_TicTacToe {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Let's play TicTacToe -- X goes first");
        System.out.println();
        String TicGrid[][] = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
        //String TicGrid[][] = {{"-_-", "-_-", "-_-"}, {"-_-", "-_-", "-_-",}, {"-_-", "-_-", "-_-",}};


        GridP(TicGrid);

        int pCount = 1;
        boolean winner = false;

        while (!winner) {
            if (pCount == 1) {
                player1_X(TicGrid);
                pCount = 2;

            } else if (pCount == 2) {
                player2_O(TicGrid);
                pCount = 1;
            }
            GridP(TicGrid);
            winner = checkWin(TicGrid);

        }
        System.out.println("Game over!");
    }

    public static void GridP(String TicGrid[][]) {
        for (int i = 0; i < TicGrid.length; i++) {
            for (int j = 0; j < TicGrid[i].length; j++) {
                System.out.print(TicGrid[i][j]);
                while (j != 2) {
                    System.out.print(" | ");
                    break;
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void player1_X(String TicGrid[][]) {
        System.out.println("Enter coordinates to play, you're X");
        int row = in.nextInt();
        int coloumn = in.nextInt();

        if (isValidMove(TicGrid, row, coloumn)) {
            TicGrid[row][coloumn] = "X";
        } else {
            System.out.println("Invalid move. Try again.");
            player1_X(TicGrid);
        }
    }

    public static void player2_O(String TicGrid[][]) {
        System.out.println("Enter coordinates to play, you're O");
        int row = in.nextInt();
        int coloumn = in.nextInt();

        if (isValidMove(TicGrid, row, coloumn)) {
            TicGrid[row][coloumn] = "O";
        } else {
            System.out.println("Occupied, Try again.");
            player2_O(TicGrid);
        }
    }

    public static boolean checkWin(String TicGrid[][]) {
        // checking rows and coloumns
        for (int i = 0; i < 3; i++) {
            if (TicGrid[i][0].equals(TicGrid[i][1]) && TicGrid[i][1].equals(TicGrid[i][2]) && !TicGrid[i][0].equals("-")) {
                System.out.println("Player " + TicGrid[i][0] + " wins!");
                return true;
            }
            if (TicGrid[0][i].equals(TicGrid[1][i]) && TicGrid[1][i].equals(TicGrid[2][i]) && !TicGrid[0][i].equals("-")) {
                System.out.println("Player " + TicGrid[0][i] + " wins!");
                return true;
            }
        }

        // checking for diagonals
        if (TicGrid[0][0].equals(TicGrid[1][1]) && TicGrid[1][1].equals(TicGrid[2][2]) && !TicGrid[0][0].equals("-")) {
            System.out.println("Player " + TicGrid[0][0] + " wins!");
            return true;
        }
        if (TicGrid[0][2].equals(TicGrid[1][1]) && TicGrid[1][1].equals(TicGrid[2][0]) && !TicGrid[0][2].equals("-")) {
            System.out.println("Player " + TicGrid[0][2] + " wins!");
            return true;
        }

        return false;
    }

    public static boolean isValidMove(String TicGrid[][], int row, int column) {
        if (row < 0 || row >= TicGrid.length || column < 0 || column >= TicGrid[0].length || !TicGrid[row][column].equals("-")) {
            return false; // Invalid move
        }
        return true;
    }
}

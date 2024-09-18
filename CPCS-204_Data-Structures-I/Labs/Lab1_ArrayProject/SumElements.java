/* 
Abdulrahman Thigah
*/
package Lab1_ArrayProject;

import java.util.Scanner;

public class SumElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int m = sc.nextInt();
        System.out.println();

        System.out.print("Enter number of columns: ");
        int n = sc.nextInt();
        System.out.println();

        //Create a two dimensional array
        int[][] matrix = new int[m][n];

        //Initialize array with random values from 0 to 99
        System.out.println("Entering random numbers in matrix of " + matrix.length
                + "rows and " + matrix[0].length + " columns: ");

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                matrix[row][column] = (int) (Math.random() * 100);
            }
        }
        System.out.println();

        //Print the elements of the array
        System.out.println("The elements of two dimensional array with rank "
                + m + "X" + n + " are as follows: ");
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                System.out.print("Matrix (" + row + ", " + column + ")= " + matrix[row][column] + "\t\t");

            }
            System.out.println();
        }
        //Summing all elements
        int total = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                total += matrix[row][column];
            }
        }
        System.out.println(0);
        System.out.println("The sum of all elements of the above array ig " + total);

    }
}

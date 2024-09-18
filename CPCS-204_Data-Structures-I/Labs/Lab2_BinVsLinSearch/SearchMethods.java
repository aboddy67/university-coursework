/* 
Abdulrahman Thigah
*/
package Lab2_BinVsLinSearch;

import java.sql.Time;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalTime;

public class SearchMethods {
    public static void main(String[] args) {

        // make array and fill it with random variables
        Random rand = new Random();
        int[] SearchArray = new int[100000000];
        for (int i = 0; i < SearchArray.length; i++) {
            SearchArray[i] = rand.nextInt(SearchArray.length + 1);
        }

        int userChoice = 0;
        //Time time = new Time(milii);

        while (userChoice != 3) {
            System.out.println("*******************************************\n" +
                               "************** Search Menu ****************\n" +
                               "*******************************************");

            System.out.println("| 1. Linear Search      |\n" +
                               "| 2. Binary Search      |\n" +
                               "| 3. Exit the program   |\n" +
                               "-------------------------");

            Scanner in = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            userChoice = in.nextInt();

            System.out.print("Please enter a value to search for (between 0 and 100 million): ");
            int inputKey = in.nextInt();

            long duration = 0;
            switch (userChoice) {
                case 1:
                    long startTime = System.nanoTime();
                    linearSearch(SearchArray, inputKey);
                    long endTime = System.nanoTime();
                    duration = endTime - startTime; // Duration in nanoseconds
                case 2:
                    binarySearch(SearchArray, inputKey);
            }
        }
    }

    public static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int key) {
        Arrays.sort(array);

        int low = 0;
        int mid = 0;
        int high = array.length - 1;

        while (low <= high) {
            mid = (low + high) / 2;

            if (key == array[mid])
                return mid;
            else if (key < array[mid]) // it is less than half
                high = mid - 1;
            else // (key > array[mid]) it more than half
                low = mid + 1;
        }

        return -1;
    }
}

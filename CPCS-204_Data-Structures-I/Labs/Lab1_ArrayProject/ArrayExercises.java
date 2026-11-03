/* 
Abdulrahman Thigah
*/
package Lab1_ArrayProject;

import java.util.ArrayList;

public class ArrayExercises {

    public void BelowAboveAvg(int[] arr) {
        int sumOfArr = 0;

        // Add elements and find sum
        for (int element : arr)
            sumOfArr += element;

        // Calculate average
        int avg = sumOfArr / arr.length;

        // get # elements above average
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            ArrayList<Integer> indices = new ArrayList<>();

            //if (element > sumOfArr) {

           // }
        }

        // get # elements below average
    }
}

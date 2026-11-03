/* 
Abdulrahman Thigah
*/
package Lab5_Recursion01;

import java.util.Random;
import java.util.Scanner;

public class SumNums {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner in = new Scanner(System.in);


        // generate two numbers from 1 - 20 inclusive
        int a = rand.nextInt(20) + 1;
        int b = rand.nextInt(20) + 1;

        System.out.println("A = " + a + "\nB = " + b);

        //Edge case if b is greater than a
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        System.out.print("Sum of integers from " + a + " to " + b + " = ");

        System.out.println(SumRec(a, b));
    }
    public static int SumRec(int a, int b) {
        if(b == a) {
            return a;
        }
        else {
            return b + SumRec(a, b - 1);
        }
    }
}

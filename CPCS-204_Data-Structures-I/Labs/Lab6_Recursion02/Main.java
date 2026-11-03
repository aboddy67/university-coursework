/* 
Abdulrahman Thigah
*/
package Lab6_Recursion02;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList<Integer> LL = new LinkedList<>();

        System.out.print("enter the base number: ");
        int base = in.nextInt();
        System.out.print("enter the e: ");
        int e = in.nextInt();

        System.out.println("the result of base^e = " + SumOfPower(base, e));

    }
    public static int SumOfPower(int b, int e) {
        if(e == 0) {
            return b;
        }
        return b * SumOfPower(b, e-1);
    }
}

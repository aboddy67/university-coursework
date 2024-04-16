/* 
Abdulrahman Thigah
*/
package Lab4;

import java.util.Scanner;

public class Quadrilateral {
    // create
    private double side1, side2, side3, side4;

    // initialize by 1
    public Quadrilateral() {
        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;
        this.side4 = 1.0;
    }

    // Constructor
    public Quadrilateral(double side1, double side2, double side3, double side4) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = side4;

    }

    // Setters
    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public void setSide4(double side4) {
        this.side4 = side4;
    }

    // Getters
    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getSide4() {
        return side4;
    }


    public double getPerimeter() {
        return side1 + side2 + side3 + side4;
    }

    public String toString() {
        Scanner in = new Scanner(System.in);
        StringBuilder result = new StringBuilder();

        System.out.print("How many quadrilaterals would you like to compute? ");
        int count = in.nextInt();
        for (int i = 1; i <= count; i++) {
            System.out.println("Quadrilateral No." + i + "\nSides: ");
            System.out.print("Input Side 1: "); double side1 = in.nextDouble();
            System.out.print("Input Side 2: "); double side2 = in.nextDouble();
            System.out.print("Input Side 3: "); double side3 = in.nextDouble();
            System.out.print("Input Side 4: "); double side4 = in.nextDouble();
            System.out.println();
            result.append("Quadrilateral No.").append(i).append("\nSides: \n");
            result.append("Side 1 = ").append(side1).append("\n");
            result.append("Side 2 = ").append(side2).append("\n");
            result.append("Side 3 = ").append(side3).append("\n");
            result.append("Side 4 = ").append(side4).append("\n");
            result.append("Perimeter = ").append(side1 + side2 + side3 + side4).append("\n\n");
        }
        return result.toString();
    }
}

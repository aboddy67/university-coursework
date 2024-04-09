/*
Name: Abdulrahman Adnan Thigah
*/
package Lab9_AbstractClassesAndInterfaces;

public class Point implements Shape {
    // Class representing a Point with x and y coordinate

    // Coordinates of the Point
    protected int x, y;

    // No-argument constructor
    public Point() {
        // Set default coordinates to (0, 0)
        setPoint(0, 0);
    }

    // Constructor with specified coordinates
    public Point(int xCoordinate, int yCoordinate) {
        // Set coordinates to specified values
        setPoint(xCoordinate, yCoordinate);
    }

    // Set x and y coordinates of the Point
    public void setPoint(int xCoordinate, int yCoordinate) {
        x = xCoordinate;
        y = yCoordinate;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    // convert point into String representation
    @Override
    public String toString() {
        return String.format("[%d, %d]", x, y);
    }
    public double area() {
        return 0.0;
    }
    public double volume() {
        return 0.0;
    }
    public String getName() {
        return "Point";
    }
}
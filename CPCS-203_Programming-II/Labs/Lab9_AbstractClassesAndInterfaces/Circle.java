/*
Name: Abdulrahman Adnan Thigah
*/
package Lab9_AbstractClassesAndInterfaces;

public class Circle extends Point {
    protected double radius;

    // no-argument constructor
    public Circle() {
        //implicit call to superclass construcotr here
        setRadius(0);
    }

    public Circle(double circleRadius, int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        setRadius(circleRadius);
    }

    // radius of circle
    public void setRadius(double circleRadius) {
        radius = (circleRadius >= 0 ? circleRadius : 0);
    }

    public double getRadius() {
        return radius;
    }
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    // convert circle to a String representation
    public String toString() {
        return String.format("Center = %s; Radius = %f", super.toString(), radius);
    }
    @Override
    public String getName() {
        return "Circle";
    }
}
